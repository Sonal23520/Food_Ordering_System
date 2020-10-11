package lk.com.foodOrdering.Controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import lk.com.foodOrdering.alert.Alert;
import lk.com.foodOrdering.bo.BoFactory;
import lk.com.foodOrdering.bo.custom.MenuBO;
import lk.com.foodOrdering.dto.MenuDTO;
import lk.com.foodOrdering.view.tm.MenuTM;
import lk.com.foodOrdering.view.tm.MenuTM_1;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UpdateMenuController implements Initializable {

    public Label lblAllMenu;
    public JFXTextField tetxprice;
    public JFXTextField txtMID;
    public JFXButton btninsert;
    public TableColumn coloperator;
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private TableView<MenuTM_1> table;

    @FXML
    private TableColumn<?, ?> colmenuid;

    @FXML
    private TableColumn<?, ?> colmenuname;

    @FXML
    private TableColumn<?, ?> colprice;

    @FXML
    private JFXTextField textlname;

    @FXML
    private JFXTextField tetxpost;

    @FXML
    private JFXButton btnUpdate;


    @FXML
    private JFXButton btnset;
    ObservableList<MenuTM_1> observableList = FXCollections.observableArrayList();
    MenuBO menuBO = BoFactory.getInstance().getBO(BoFactory.BoType.Menu);

    @FXML
    void getAll(ActionEvent event) {
        tableLoad();
    }

    @FXML
    void searchOnAction(ActionEvent event) throws Exception {
        observableList.clear();
        ArrayList<MenuDTO> search = menuBO.search(txtSearch.getText());
        for (MenuDTO menuDTO : search) {
            JFXButton jfxButton = new JFXButton("Delete");
            jfxButton.setStyle("-fx-background-color: #079992");
            jfxButton.setMinSize(50,2);
            jfxButton.setTextFill(Color.WHITE);
            jfxButton.setOnAction((e)->{
                boolean b = Alert.conformAlert("Alert", "Are You Sure Delete This Item?");
                if (b){
                    boolean delete = false;
                    try {
                        delete = menuBO.delete(String.valueOf(menuDTO.getId()));
                        if (delete){
                            Alert.alertType("asserts/success.png","Success","Item Deleted");
                            observableList.clear();
                            table.refresh();
                            tableLoad();
                            ArrayList<MenuDTO> menuDTOS = menuBO.get();
                            txtMID.setText(String.valueOf(menuDTOS.size()+1));
                            txtSearch.clear();
                            return;
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            });
            observableList.add(new MenuTM_1(menuDTO.getId(),menuDTO.getName(),menuDTO.getPrice(),jfxButton));
        }
        table.setItems(observableList);

    }

    @FXML
    void setOnAction(ActionEvent event) throws Exception {
        ArrayList<MenuDTO> search = menuBO.get();
        for (MenuDTO menuDTO : search) {
            if (txtMID.getText().equals(String.valueOf(menuDTO.getId()))){
                textlname.setText(menuDTO.getName());
                tetxprice.setText(String.valueOf(menuDTO.getPrice()));
                return;
            }
        }
        Alert.alertType("asserts/infomations.png","Information","No Item Found!");
        return;
    }

    @FXML
    void updateOnAction(ActionEvent event) throws Exception {
        String id=txtMID.getText();
        String name = textlname.getText();
        String price=tetxprice.getText();

        if (id.isEmpty() || name.isEmpty() || price.isEmpty()){
            Alert.alertType("asserts/infomations.png", "Information", "Please fill blank fields");
        }else{
            ArrayList<MenuDTO> menuDTOS = menuBO.get();
            for (MenuDTO menuDTO : menuDTOS) {
                if (txtMID.getText().equals(String.valueOf(menuDTO.getId()))){
                    boolean update = menuBO.update(new MenuDTO(Integer.parseInt(id),name,Integer.parseInt(price)));
                    if (update){
                        ArrayList<MenuDTO> menuDTOS1 = menuBO.get();
                        txtMID.setText(String.valueOf(menuDTOS1.size()+1));
                        Alert.alertType("asserts/success.png","Success","Item Updated");
                        tableLoad();
                        clear();
                        return;
                    }
                    return;
                }
            }

            boolean add = menuBO.add(new MenuDTO(Integer.parseInt(id), name, Integer.parseInt(price)));
            if (add){
                ArrayList<MenuDTO> menuDTOS1 = menuBO.get();
                txtMID.setText(String.valueOf(menuDTOS1.size()+1));
                Alert.alertType("asserts/success.png","Success","Item Added Success");
                tableLoad();
                clear();
                return;
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colmenuid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colmenuname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colprice.setCellValueFactory(new PropertyValueFactory<>("price"));
        coloperator.setCellValueFactory(new PropertyValueFactory<>("jfxButton"));


        tableLoad();

        try {
            ArrayList<MenuDTO> menuDTOS = menuBO.get();
            txtMID.setText(String.valueOf(menuDTOS.size()+1));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tableLoad() {
        observableList.clear();
        try {
            ArrayList<MenuDTO> menuDTOS = menuBO.get();
            for (MenuDTO menuDTO : menuDTOS) {
                JFXButton jfxButton = new JFXButton("Delete");
                jfxButton.setStyle("-fx-background-color: #079992");
                jfxButton.setMinSize(50,2);
                jfxButton.setTextFill(Color.WHITE);
                jfxButton.setOnAction((e)->{
                    boolean b = Alert.conformAlert("Alert", "Are You Sure Delete This Item?");
                    if (b){
                        boolean delete = false;
                        try {
                            delete = menuBO.delete(String.valueOf(menuDTO.getId()));
                            if (delete){
                                Alert.alertType("asserts/success.png","Success","Item Deleted");
                                observableList.clear();
                                table.refresh();
                                tableLoad();
                                ArrayList<MenuDTO> menuDTOS2 = menuBO.get();
                                txtMID.setText(String.valueOf(menuDTOS2.size()+1));
                                return;
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                });
                observableList.add(new MenuTM_1(menuDTO.getId(),menuDTO.getName(),menuDTO.getPrice(),jfxButton));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        table.setItems(observableList);
        lblAllMenu.setText(String.valueOf(observableList.size()));
    }

    public void InsertOnAction(ActionEvent actionEvent) {

    }
    void clear(){
        textlname.clear();
        tetxprice.clear();
    }

}
