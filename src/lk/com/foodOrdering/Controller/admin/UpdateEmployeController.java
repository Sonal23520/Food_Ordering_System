package lk.com.foodOrdering.Controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
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
import javafx.scene.paint.Paint;
import lk.com.foodOrdering.alert.Alert;
import lk.com.foodOrdering.bo.BoFactory;
import lk.com.foodOrdering.bo.custom.RestaurantBO;
import lk.com.foodOrdering.dto.RestaurantDTO;
import lk.com.foodOrdering.view.tm.EmployeeTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class UpdateEmployeController implements Initializable {

    public Label lblAllEmployee;
    public JFXTextField tetxpost;
    public JFXTextField txtEmID;
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private Label lblAllCustomer;

    @FXML
    private TableView<EmployeeTM> table;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colpassword;

    @FXML
    private TableColumn<?, ?> colfname;

    @FXML
    private TableColumn<?, ?> collname;

    @FXML
    private TableColumn<?, ?> colpost;

    @FXML
    private JFXTextField textfname;

    @FXML
    private JFXTextField textlname;

    @FXML
    private JFXTextField textemail;

    @FXML
    private JFXPasswordField textpass;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private Label alertLabel;

    @FXML
    private JFXTextField txtcustID;

    @FXML
    private JFXButton btnset;

    RestaurantBO restaurantBO = BoFactory.getInstance().getBO(BoFactory.BoType.RESTAURANT);
    ObservableList<EmployeeTM>observableList= FXCollections.observableArrayList();

    @FXML
    void getAll(ActionEvent event) {
        tableLoad();
    }

    @FXML
    void searchOnAction(ActionEvent event) throws Exception {
        observableList.clear();
        ArrayList<RestaurantDTO> search = restaurantBO.search(txtSearch.getText());
        for (RestaurantDTO restaurantDTO : search) {
            observableList.add(new EmployeeTM(restaurantDTO.getRestaurant_id(),restaurantDTO.getPassword(),restaurantDTO.getFirst_name(),restaurantDTO.getLast_name(),restaurantDTO.getPost()));
        }
        table.setItems(observableList);

    }

    @FXML
    void setOnAction(ActionEvent event) throws Exception {
        ArrayList<RestaurantDTO> all = restaurantBO.getAll();
        for (RestaurantDTO restaurantDTO : all) {
            if (txtEmID.getText().equals(String.valueOf(restaurantDTO.getRestaurant_id()))){
                textfname.setText(restaurantDTO.getFirst_name());
                textlname.setText(restaurantDTO.getLast_name());
                textpass.setText(restaurantDTO.getPassword());
                tetxpost.setText(restaurantDTO.getPost());
                return;
            }
        }
        Alert.alertType("asserts/infomations.png","Information","No Employee Found!");
        return;

    }

    @FXML
    void updateOnAction(ActionEvent event) throws Exception {

    String pass=textpass.getText();
    String fname=textfname.getText();
    String lname=textlname.getText();
    String post=tetxpost.getText().toUpperCase().trim();

        if (pass.isEmpty() || fname.isEmpty() || lname.isEmpty() || post.isEmpty()){
            Alert.alertType("asserts/infomations.png", "Information", "Please fill blank fields");
        }else if (!(fname.matches("[a-zA-Z]+"))){
            invalid(textfname,"invalid name format");
        }else if (!(lname.matches("[a-zA-Z]+"))){
            invalid(textlname,"invalid name format");
        }else if (!(pass.length()>=4)){
            invalid(textpass,"Password length should be more than 4");
        }else if (!(post.matches("[a-zA-Z]+"))){
            invalid(tetxpost,"invalid format");
        }else {
            ArrayList<RestaurantDTO> all = restaurantBO.getAll();
            for (RestaurantDTO restaurantDTO : all) {
                if (txtEmID.getText().equals(String.valueOf(restaurantDTO.getRestaurant_id()))){
                    boolean update = restaurantBO.update(new RestaurantDTO(Integer.parseInt(txtEmID.getText()), pass, fname, lname, post));
                    if (update){
                        ArrayList<RestaurantDTO> all1 = restaurantBO.getAll();
                        txtEmID.setText(String.valueOf(all1.size()+1));
                        Alert.alertType("asserts/success.png","Success","Employee Updated");
                        tableLoad();
                        clear();
                        return;
                    }

                    return;
                }
            }
            boolean add = restaurantBO.add(new RestaurantDTO(Integer.parseInt(txtEmID.getText()), pass, fname, lname, post));
            if (add){
                ArrayList<RestaurantDTO> all1 = restaurantBO.getAll();
                txtEmID.setText(String.valueOf(all1.size()+1));
                Alert.alertType("asserts/success.png","Success","Employee Added Success");
                clear();
                tableLoad();
                return;

            }
            return;


        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colid.setCellValueFactory(new PropertyValueFactory<>("restaurant_id"));
        colpassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colfname.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        collname.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        colpost.setCellValueFactory(new PropertyValueFactory<>("post"));

        tableLoad();

        try {
            ArrayList<RestaurantDTO> all = restaurantBO.getAll();
            txtEmID.setText(String.valueOf(all.size()+1));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void tableLoad() {
        observableList.clear();
        try {
            ArrayList<RestaurantDTO> all = restaurantBO.getAll();
            for (RestaurantDTO restaurantDTO : all) {
                observableList.add(new EmployeeTM(restaurantDTO.getRestaurant_id(),restaurantDTO.getPassword(),restaurantDTO.getFirst_name(),restaurantDTO.getLast_name(),restaurantDTO.getPost()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        table.setItems(observableList);
        lblAllEmployee.setText(String.valueOf(observableList.size()));
    }
    private static void invalid(JFXTextField jfxTextField,String text){
        Alert.alertType("/asserts/invalids.png","Information",text);
        jfxTextField.requestFocus();
        jfxTextField.setFocusColor(Paint.valueOf("red"));

    }
    private static void invalid(JFXPasswordField jfxTextField,String text){
        Alert.alertType("/asserts/invalids.png","Information",text);
        jfxTextField.requestFocus();
        jfxTextField.setFocusColor(Paint.valueOf("red"));

    }
    void clear(){
        textpass.clear();
        textfname.clear();
        textlname.clear();
        tetxpost.clear();
    }
}
