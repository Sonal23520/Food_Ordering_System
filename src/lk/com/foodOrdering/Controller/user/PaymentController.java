package lk.com.foodOrdering.Controller.user;

import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import lk.com.foodOrdering.alert.Alert;
import lk.com.foodOrdering.bo.BoFactory;
import lk.com.foodOrdering.bo.custom.OrderBO;
import lk.com.foodOrdering.bo.custom.PaymentBO;
import lk.com.foodOrdering.db.DBConnection;
import lk.com.foodOrdering.dto.PaymentDTO;
import lk.com.foodOrdering.dto.PaymentDetailsDTO;
import lk.com.foodOrdering.setUI.SetUI;
import lk.com.foodOrdering.setUI.SuperSetUI;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentController implements Initializable {

    @FXML
    private TextField cardnumtxt;

    @FXML
    private TextField cardholdertxt;

    @FXML
    private TextField monthtxt;

    @FXML
    private TextField yeartxt;

    @FXML
    private PasswordField cvvtxt;

    @FXML
    private JFXRadioButton onlinepaybtn;

    @FXML
    private ToggleGroup payment;

    @FXML
    private JFXRadioButton codbtn;

    @FXML
    private Label amounttxt;

    @FXML
    private Label warning;

    SuperSetUI superSetUI=new SetUI();
    PaymentBO paymentBO;
    OrderBO orderBO;
    @FXML
    void cashOnDelivery(ActionEvent event) {
        codbtn.setSelected(true);
        onlinepaybtn.setSelected(false);
        cardnumtxt.setDisable(true);
        cardholdertxt.setDisable(true);
        cvvtxt.setDisable(true);
        monthtxt.setDisable(true);
        yeartxt.setDisable(true);

    }

    @FXML
    void confirmPayment(ActionEvent event) throws Exception {


        if (codbtn.isSelected()){
            boolean add = paymentBO.add(new PaymentDTO(0, 0, "CASH_ON_DELIVERY", "NOT_CONFIRMED", java.time.LocalDate.now().toString()));
            if (add){
                Alert.alertType("asserts/success.png","Success","Order Added Success");
                superSetUI.setUI(event, "lk/com/foodOrdering/view/user/Confirmed.fxml");
                try {
                    InputStream inputStream = this.getClass().getResourceAsStream("/lk/com/foodOrdering/reports/PaymentBill.jasper");
                    HashMap hashMap = new HashMap();
                    hashMap.put("oid",orderBO.passOrderID());
                    hashMap.put("total",amounttxt.getText());
                    JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, hashMap, DBConnection.getInstance().getConnection());
                    JasperViewer.viewReport(jasperPrint,false);

                } catch (JRException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        }
        else if (onlinepaybtn.isSelected()){

            if(!(cardnumtxt.getText().isEmpty()||cardholdertxt.getText().isEmpty()||cvvtxt.getText().isEmpty()||monthtxt.getText().isEmpty()||yeartxt.getText().isEmpty())){


                if(!(cardnumtxt.getText().length()==16)){
                    warning.setText("Enter valid card numder");
                    return;
                }else if(!(cvvtxt.getText().length()==3)){
                    warning.setText("Enter valid CVV");
                    return;
                }else if(!((monthtxt.getText()).matches("0?[1-9]|1[012]"))){
                    warning.setText("Enter valid month");
                    return;
                }else if(!((yeartxt.getText()).matches("1[8-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]"))){
                    warning.setText("Enter valid year");
                    return;
                }else{

                    boolean b = paymentBO.addWithDetails(new PaymentDetailsDTO(0, 0, "ONLINE_PAYMENT", "CONFIRMED", LocalDate.now().toString(), MenuController.getCustomerID(), cardnumtxt.getText(), cardholdertxt.getText(), Integer.parseInt(cvvtxt.getText()), Integer.parseInt(monthtxt.getText()), Integer.parseInt(yeartxt.getText())));
                    if (b){
                        Alert.alertType("asserts/success.png","Success","Order Added Success");
                        superSetUI.setUI(event, "lk/com/foodOrdering/view/user/Confirmed.fxml");
                        try {
                            InputStream inputStream = this.getClass().getResourceAsStream("/lk/com/foodOrdering/reports/PaymentBill.jasper");
                            HashMap hashMap = new HashMap();
                            hashMap.put("oid",orderBO.passOrderID());
                            hashMap.put("total",amounttxt.getText());
                            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, hashMap, DBConnection.getInstance().getConnection());
                            JasperViewer.viewReport(jasperPrint,false);

                        } catch (JRException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
                }
            }else{
                Alert.alertType("asserts/infomations.png","Information","Enter Payment Details");
            }
    }

    @FXML
    void onlinePayment(ActionEvent event) {
        onlinepaybtn.setSelected(true);
        codbtn.setSelected(false);
        cardnumtxt.setDisable(false);
        cardholdertxt.setDisable(false);
        cvvtxt.setDisable(false);
        monthtxt.setDisable(false);
        yeartxt.setDisable(false);

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        orderBO = BoFactory.getInstance().getBO(BoFactory.BoType.ORDER);
        paymentBO= BoFactory.getInstance().getBO(BoFactory.BoType.PAYMENT);
        amounttxt.setText(MenuController.getAmount());
    }
}
