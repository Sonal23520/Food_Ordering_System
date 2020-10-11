package lk.com.foodOrdering.Controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import lk.com.foodOrdering.alert.Alert;
import lk.com.foodOrdering.bo.BoFactory;
import lk.com.foodOrdering.bo.custom.CustomerBO;
import lk.com.foodOrdering.bo.custom.RestaurantBO;
import lk.com.foodOrdering.dto.CustomerDTO;
import lk.com.foodOrdering.dto.DeliverOrderDTO;
import lk.com.foodOrdering.dto.RestaurantDTO;
import lk.com.foodOrdering.setUI.SetUI;
import lk.com.foodOrdering.setUI.SuperSetUI;
import lk.com.foodOrdering.view.tm.DeliverOrderTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DefaultPanelContoller implements Initializable {

    public Label lblOrder;
    public Label lblCustomer;
    public Label lblEmployee;
    @FXML
    private AnchorPane root;

    @FXML
    private TableView<DeliverOrderTM> table;

    @FXML
    private TableColumn<?, ?> colOrderID;

    @FXML
    private TableColumn<?, ?> colCustomerID;

    @FXML
    private TableColumn<?, ?> colFirstName;

    @FXML
    private TableColumn<?, ?> colLastName;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colOrderStatus;

    @FXML
    private TableColumn<?, ?> colOperaton;
    SuperSetUI superSetUI=new SetUI();
    ObservableList<DeliverOrderTM> observableList = FXCollections.observableArrayList();
    RestaurantBO restaurantBO = BoFactory.getInstance().getBO(BoFactory.BoType.RESTAURANT);
    CustomerBO customerBO = BoFactory.getInstance().getBO(BoFactory.BoType.CUSTOMER);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colOrderID.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("phone_no"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("province"));
        colOrderStatus.setCellValueFactory(new PropertyValueFactory<>("order_status"));
        colOperaton.setCellValueFactory(new PropertyValueFactory<>("button"));

        tableLoad();
        getCustomer();
        getRestaurant();


    }

    void tableLoad(){
        try {
            ArrayList<DeliverOrderDTO> deliverOrder = restaurantBO.getDeliverOrder();
            for (DeliverOrderDTO deliverOrderDTO : deliverOrder) {
                JFXButton jfxButton = new JFXButton("TAKE");
                jfxButton.setStyle("-fx-background-color: #079992");
                jfxButton.setMinSize(50,2);
                jfxButton.setTextFill(Color.WHITE);
                jfxButton.setOnAction((e)->{
                    try {
                        boolean b = Alert.conformAlert("Alert", "Are you sure deliver this order?");
                        if (b){
                            restaurantBO.changeOrderStatus("DELIVERED",deliverOrderDTO.getOrder_id());
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    observableList.clear();
                    table.refresh();
                    tableLoad();
                    lblOrder.setText(String.valueOf(table.getItems().size()));
                });
                observableList.add(new DeliverOrderTM(deliverOrderDTO.getOrder_id(),deliverOrderDTO.getCustomer_id(),deliverOrderDTO.getFirst_name(),deliverOrderDTO.getLast_name(),deliverOrderDTO.getPhone_no(),deliverOrderDTO.getProvince(),deliverOrderDTO.getOrder_status(),jfxButton));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        table.setItems(observableList);
        lblOrder.setText(String.valueOf(table.getItems().size()));
    }

    void getCustomer(){
        ArrayList<CustomerDTO> loginDetails = null;
        try {
            loginDetails = customerBO.getLoginDetails();
        } catch (Exception e) {
            e.printStackTrace();
        }
        lblCustomer.setText(String.valueOf(loginDetails.size()));
    }
    void getRestaurant(){
        try {
            ArrayList<RestaurantDTO> all = restaurantBO.getAll();
            lblEmployee.setText(String.valueOf(all.size()));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
