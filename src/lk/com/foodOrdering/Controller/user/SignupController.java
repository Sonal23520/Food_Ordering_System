package lk.com.foodOrdering.Controller.user;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import lk.com.foodOrdering.alert.Alert;
import lk.com.foodOrdering.bo.BoFactory;
import lk.com.foodOrdering.bo.custom.CustomerBO;
import lk.com.foodOrdering.dto.CustomerDTO;
import lk.com.foodOrdering.setUI.SetUI;
import lk.com.foodOrdering.setUI.SuperSetUI;

import java.util.ArrayList;

public class SignupController {

    public JFXTextField textaddressline1;
    public JFXTextField textprovince;
    public JFXTextField textaddressline2;
    public JFXTextField textpostalcode;
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
    private Label alertLabel;
    SuperSetUI superSetUI = new SetUI();
    CustomerBO customerBO = BoFactory.getInstance().getBO(BoFactory.BoType.CUSTOMER);

    @FXML
    void Signup(ActionEvent event) throws Exception {
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
        }else if(isemailExits()){
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
            boolean b = customerBO.addCustomer(new CustomerDTO(0, fname, lname, email, pass, Integer.parseInt(phone), province, addressline1, addressline2, Integer.parseInt(postalcode)));
            if (b){
                Alert.alertType("asserts/success.png","Success","Customer Added Success");
                clear();
            }
        }


    }

        @FXML
        void exitScreen (ActionEvent event){
            System.exit(0);
        }

        public void backToHome (MouseEvent mouseEvent) throws Exception {
            superSetUI.setUI(mouseEvent, "lk/com/foodOrdering/view/user/Welcome.fxml");
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

    protected boolean isemailExits() throws Exception {
        ArrayList<CustomerDTO> loginDetails = customerBO.getLoginDetails();
        for (CustomerDTO loginDetail : loginDetails) {
            if (textemail.getText().trim().toLowerCase().equalsIgnoreCase(loginDetail.getEmail())){
                return true;
            }
        }
        return false;
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


