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
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import lk.com.foodOrdering.alert.Alert;
import lk.com.foodOrdering.bo.BoFactory;
import lk.com.foodOrdering.bo.custom.CustomerBO;
import lk.com.foodOrdering.dto.CustomerDTO;
import lk.com.foodOrdering.view.tm.CustomerTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UpdateCustomerController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private Label lblAllCustomer;

    @FXML
    private TableView<CustomerTM> table;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colfname;

    @FXML
    private TableColumn<?, ?> collname;

    @FXML
    private TableColumn<?, ?> colemail;

    @FXML
    private TableColumn<?, ?> colpassword;

    @FXML
    private TableColumn<?, ?> colcontact;

    @FXML
    private TableColumn<?, ?> colprovince;

    @FXML
    private TableColumn<?, ?> colpostalcode;


    @FXML
    private JFXTextField textfname;

    @FXML
    private JFXTextField textlname;

    @FXML
    private JFXTextField textemail;

    @FXML
    private JFXPasswordField textpass;

    @FXML
    private JFXTextField textnumber;

    @FXML
    private JFXTextField textaddressline1;

    @FXML
    private JFXTextField textprovince;

    @FXML
    private JFXTextField textaddressline2;

    @FXML
    private JFXTextField textpostalcode;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private Label alertLabel;

    @FXML
    private JFXTextField txtcustID;

    @FXML
    private JFXButton btnset;

    CustomerBO customerBO= BoFactory.getInstance().getBO(BoFactory.BoType.CUSTOMER);
    ObservableList<CustomerTM> observableList = FXCollections.observableArrayList();
    boolean custID;
    @FXML
    void searchOnAction(ActionEvent event) throws Exception {
        observableList.clear();
        ArrayList<CustomerDTO> customerDTOS = customerBO.searchCustomer(txtSearch.getText());
        for (CustomerDTO loginDetail : customerDTOS) {
            observableList.add(new CustomerTM(loginDetail.getId(),loginDetail.getFname(),loginDetail.getLname(),loginDetail.getEmail(),loginDetail.getPassword(),loginDetail.getPhoneno(),loginDetail.getProvince()+","+loginDetail.getAddressline1()+","+loginDetail.getAddressline2(),loginDetail.getPostalcode()));

        }
        table.setItems(observableList);

    }

    @FXML
    void setOnAction(ActionEvent event) throws Exception {

        ArrayList<CustomerDTO> loginDetails = customerBO.getLoginDetails();
        for (CustomerDTO loginDetail : loginDetails) {
            if (txtcustID.getText().equals(String.valueOf(loginDetail.getId()))){
                textfname.setText(loginDetail.getFname());
                textlname.setText(loginDetail.getLname());
                textemail.setText(loginDetail.getEmail());
                textpass.setText(loginDetail.getPassword());
                textnumber.setText(String.valueOf(loginDetail.getPhoneno()));
                textprovince.setText(loginDetail.getProvince());
                textaddressline1.setText(loginDetail.getAddressline1());
                textaddressline2.setText(loginDetail.getAddressline2());
                textpostalcode.setText(String.valueOf(loginDetail.getPostalcode()));
                returntrue(false);
                return;
            }
        }
        Alert.alertType("asserts/infomations.png","Information","No Customer Found!");
        returntrue(true);
        return;


    }

    private void returntrue(boolean b) {
        custID=b;
    }

    @FXML
    void updateOnAction(ActionEvent event) throws Exception {
        String fname = textfname.getText();
        String lname = textlname.getText();
        String email = textemail.getText().toLowerCase();
        String pass = textpass.getText();
        String phone = textnumber.getText();
        String province = textprovince.getText().toLowerCase();
        String addressline1 = textaddressline1.getText().toLowerCase();
        String addressline2 = textaddressline2.getText().toLowerCase();
        String postalcode = textpostalcode.getText();




        if (fname.isEmpty() || lname.isEmpty() || email.isEmpty() || pass.isEmpty() || phone.isEmpty() || province.isEmpty() || addressline1.isEmpty() || addressline2.isEmpty() || postalcode.isEmpty()) {
            alertLabel.setText("Please fill blank fields");
            Alert.alertType("asserts/infomations.png", "Information", "Please fill blank fields");
        }else if (!(fname.matches("[a-zA-Z]+"))){
            invalid(textfname,"invalid name format");
        }else if (!(lname.matches("[a-zA-Z]+"))){
            invalid(textlname,"invalid name format");
        }else if (!(email.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$"))){
            invalid(textemail,"invalid email");
        }else if(isemailExits() && custID){
            invalid(textemail,"E-mail is already taken");
        }else if (!(pass.length()>=4)){
            invalid(textpass,"Password length should be more than 4");
        }else if (!(phone.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]"))){
            invalid(textnumber,"invalid phone number");
        }else if (!(province.matches("[a-zA-Z]+"))){
            invalid(textprovince,"invalid province field");
        }else if (!(addressline1.matches("[a-zA-Z]+"))){
            invalid(textaddressline1,"invalid address_line_1 field");
        }else if (!(addressline2.matches("[a-zA-Z]+"))){
            invalid(textaddressline2,"invalid address_line_2 field");
        }else if(!(postalcode.matches("[0-9][0-9][0-9][0-9][0-9]"))){
            invalid(textpostalcode,"invalid postalcode");
        }else {
            ArrayList<CustomerDTO> details = customerBO.getLoginDetails();
            for (CustomerDTO detail : details) {
                if (txtcustID.getText().trim().equalsIgnoreCase(String.valueOf(detail.getId()))){
                    System.out.println(txtcustID.getText().equals(String.valueOf(detail.getId())));
                    boolean b = customerBO.updateCustomerAll(new CustomerDTO(Integer.parseInt(txtcustID.getText()), fname, lname, email, pass, Integer.parseInt(phone), province, addressline1, addressline2, Integer.parseInt(postalcode)));
                    if (b){
                        ArrayList<CustomerDTO> loginDetails = customerBO.getLoginDetails();
                        txtcustID.setText(String.valueOf(loginDetails.size()+1));
                        Alert.alertType("asserts/success.png","Success","Customer Updated");
                        tableLoad();
                        clear();
                        return;
                    }
                    return;
                }
            }
            ArrayList<CustomerDTO> loginDetails = customerBO.getLoginDetails();
            for (CustomerDTO loginDetail : loginDetails) {
                if (textemail.getText().equals(loginDetail.getEmail())){
                    invalid(textemail,"E-mail is already taken");
                    return;
                }

            }
            boolean b = customerBO.addCustomer(new CustomerDTO(Integer.parseInt(txtcustID.getText()), fname, lname, email, pass, Integer.parseInt(phone), province, addressline1, addressline2, Integer.parseInt(postalcode)));
            if (b){
                ArrayList<CustomerDTO> login = customerBO.getLoginDetails();
                txtcustID.setText(String.valueOf(login.size()+1));
                Alert.alertType("asserts/success.png","Success","Customer Added Success");
                clear();
                tableLoad();
                return;
            }

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colfname.setCellValueFactory(new PropertyValueFactory<>("fname"));
        collname.setCellValueFactory(new PropertyValueFactory<>("lname"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colpassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colcontact.setCellValueFactory(new PropertyValueFactory<>("phoneno"));
        colprovince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colpostalcode.setCellValueFactory(new PropertyValueFactory<>("postalcode"));


        tableLoad();

        ArrayList<CustomerDTO> loginDetails = null;
        try {
            loginDetails = customerBO.getLoginDetails();
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtcustID.setText(String.valueOf(loginDetails.size()+1));
    }

    private void tableLoad() {
        observableList.clear();
        try {
            ArrayList<CustomerDTO> loginDetails = customerBO.getLoginDetails();
            lblAllCustomer.setText(String.valueOf(loginDetails.size()));
            for (CustomerDTO loginDetail : loginDetails) {
                observableList.add(new CustomerTM(loginDetail.getId(),loginDetail.getFname(),loginDetail.getLname(),loginDetail.getEmail(),loginDetail.getPassword(),loginDetail.getPhoneno(),loginDetail.getProvince()+","+loginDetail.getAddressline1()+","+loginDetail.getAddressline2(),loginDetail.getPostalcode()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        table.setItems(observableList);
    }

    public void getAll(ActionEvent actionEvent) {
        tableLoad();
    }
    private static void invalid(JFXPasswordField jfxTextField,String text){
        Alert.alertType("/asserts/invalids.png","Information",text);
        jfxTextField.requestFocus();
        jfxTextField.setFocusColor(Paint.valueOf("red"));

    }

    protected boolean isemailExits() throws Exception {
        ArrayList<CustomerDTO> loginDetails = customerBO.getLoginDetails();
        for (CustomerDTO loginDetail : loginDetails) {
            if (textemail.getText().trim().toLowerCase().equalsIgnoreCase(loginDetail.getEmail())){
                return true;
            }
        }
        return false;
    }
    private static void invalid(JFXTextField jfxTextField,String text){
        Alert.alertType("/asserts/invalids.png","Information",text);
        jfxTextField.requestFocus();
        jfxTextField.setFocusColor(Paint.valueOf("red"));

    }

    void clear(){
       textfname.clear();
       textlname.clear();
       textemail.clear();
       textpass.clear();
       textnumber.clear();
       textprovince.clear();
       textaddressline1.clear();
       textaddressline2.clear();
       textpostalcode.clear();
    }
}
