package lk.com.foodOrdering.Controller.user;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import lk.com.foodOrdering.alert.Alert;
import lk.com.foodOrdering.bo.BoFactory;
import lk.com.foodOrdering.bo.custom.CustomerBO;
import lk.com.foodOrdering.dto.CustomerDTO;
import lk.com.foodOrdering.setUI.SetUI;
import lk.com.foodOrdering.setUI.SuperSetUI;
import org.controlsfx.control.Notifications;

import javax.management.Notification;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public ImageView backToHome;
    public ImageView lblemailok;
    public ImageView lblpassok;
    public Hyperlink txtsign;
    @FXML
    private JFXTextField textemail;

    @FXML
    private JFXPasswordField textpass;

    @FXML
    private Label alertLabel;
    static int custID=0;
    SuperSetUI superSetUI;
    CustomerBO customerBO= BoFactory.getInstance().getBO(BoFactory.BoType.CUSTOMER);

    @FXML
    void Login(ActionEvent event) throws Exception {
        textemail.setText("bmaxcreations@gmail.com");
        textpass.setText("1234");

        if (textemail.getText().trim().equalsIgnoreCase("") || textpass.getText().trim().equalsIgnoreCase("")){
            textemail.setFocusColor(Paint.valueOf("red"));
            textpass.setFocusColor(Paint.valueOf("red"));
            Alert.alertType("asserts/infomations.png","Information","Please fill blank fields");
        }else {
            ArrayList<CustomerDTO> loginDetails = customerBO.getLoginDetails();
            for (CustomerDTO loginDetail : loginDetails) {
                if (textemail.getText().equals(loginDetail.getEmail()) && textpass.getText().equals(loginDetail.getPassword())){
                    setCustID(loginDetail.getId());
                    superSetUI.setUI(event, "lk/com/foodOrdering/view/user/Menu.fxml");
                    Alert.alertType("/asserts/success.png","Access Granted","Welcome "+loginDetail.getFname()+" "+loginDetail.getLname());
                    MenuController.getPassword(new CustomerDTO(loginDetail.getId(),loginDetail.getFname(),loginDetail.getLname(),loginDetail.getEmail(),loginDetail.getPassword(),loginDetail.getPhoneno(),loginDetail.getProvince(),loginDetail.getAddressline1(),loginDetail.getAddressline2(),loginDetail.getPostalcode()));


                }else {
                    ArrayList<CustomerDTO> details = customerBO.getLoginDetails();
                    for (CustomerDTO detail : details) {
                        if (textemail.getText().trim().toLowerCase().equalsIgnoreCase(detail.getEmail())){
                            lblemailok.setVisible(true);
                            textpass.requestFocus();
                            if (textpass.getText().trim().toLowerCase().equalsIgnoreCase(detail.getPassword())){
                                lblpassok.setVisible(true);
                            }else {
                                textpass.setFocusColor(Paint.valueOf("red"));
                                textpass.requestFocus();
                            }
                            break;
                        }else {
                            textemail.setFocusColor(Paint.valueOf("red"));
                            textemail.requestFocus();
                        }
                    }
                }
            }
        }
    }

    @FXML
    void exitScreen(ActionEvent event) {

        System.exit(0);
    }

    public void backToHome(MouseEvent mouseEvent) throws Exception {
        superSetUI.setUI(mouseEvent, "lk/com/foodOrdering/view/user/Welcome.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblemailok.setVisible(false);
        lblpassok.setVisible(false);

        superSetUI=new SetUI();
    }
    void setCustID(int a){
        custID=a;
    }
    public static int getCustID(){
        return custID;
    }


    public void signup(ActionEvent actionEvent) throws Exception {
        superSetUI.setUI(actionEvent, "lk/com/foodOrdering/view/user/Signup.fxml");

    }
}
