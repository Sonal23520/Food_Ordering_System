package lk.com.foodOrdering.Controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.com.foodOrdering.bo.BoFactory;
import lk.com.foodOrdering.bo.custom.OrderBO;
import lk.com.foodOrdering.dto.OrderDTO;
import lk.com.foodOrdering.view.tm.OrderTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrderDetailFormController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private TableView<OrderTM> table;

    @FXML
    private TableColumn<?, ?> colorderid;

    @FXML
    private TableColumn<?, ?> colcustomerid;

    @FXML
    private TableColumn<?, ?> colorderstatus;

    @FXML
    private TableColumn<?, ?> coltime;
    OrderBO orderBO = BoFactory.getInstance().getBO(BoFactory.BoType.ORDER);
    ObservableList<OrderTM> observableList = FXCollections.observableArrayList();

    @FXML
    void getAll(ActionEvent event) {
        tableLoad();
    }

    @FXML
    void searchOnAction(ActionEvent event) throws Exception {
        observableList.clear();
        ArrayList<OrderDTO> orders = orderBO.getOrders();
        for (OrderDTO order : orders) {
            if (txtSearch.getText().equals(String.valueOf(order.getOrder_id()))){
                observableList.add(new OrderTM(order.getOrder_id(),order.getCustomer_id(),order.getOrder_status(),order.getTime_stamp()));

            }
        }
        table.setItems(observableList);
        return;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colorderid.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        colcustomerid.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        colorderstatus.setCellValueFactory(new PropertyValueFactory<>("order_status"));
        coltime.setCellValueFactory(new PropertyValueFactory<>("time_stamp"));

        tableLoad();
    }

    private void tableLoad() {
        observableList.clear();
        try {
            ArrayList<OrderDTO> orders = orderBO.getOrders();
            for (OrderDTO order : orders) {
                observableList.add(new OrderTM(order.getOrder_id(),order.getCustomer_id(),order.getOrder_status(),order.getTime_stamp()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        table.setItems(observableList);
    }
}
