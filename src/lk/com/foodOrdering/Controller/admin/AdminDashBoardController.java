package lk.com.foodOrdering.Controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.com.foodOrdering.setUI.SetUI;
import lk.com.foodOrdering.setUI.SuperSetUI;

import java.net.URL;
import java.util.ResourceBundle;
public class AdminDashBoardController implements Initializable {
    public ImageView lblCancel;
    public JFXButton btnMangeCustomer;
    public Label lblTitle;
    public JFXButton btnManageEmploye;
    public JFXButton btnManageItem;
    public JFXButton btnOrderDetail;
    public JFXButton btnHome;
    public Label post;
    public JFXButton btnReport;
    SuperSetUI superSetUI=new SetUI();
    @FXML
    private AnchorPane root;
    static int po=0;

    @FXML
    void dashBoard(ActionEvent event) throws Exception {
        superSetUI.setFxml(root, "lk/com/foodOrdering/view/Admin/DefaultPanel.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            superSetUI.setFxml(root, "lk/com/foodOrdering/view/Admin/DefaultPanel.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        setButtonVisibel();
        System.out.println(po);



    }

    public void cancel(MouseEvent mouseEvent) {
        System.exit(0);
    }

    public void manageCustomer(ActionEvent actionEvent) throws Exception {
        lblTitle.setText(btnMangeCustomer.getText());
        superSetUI.setFxml(root, "lk/com/foodOrdering/view/Admin/UpdateCustomer.fxml");
    }

    public void manageEmployee(ActionEvent actionEvent) throws Exception {
        lblTitle.setText(btnManageEmploye.getText());
        superSetUI.setFxml(root, "lk/com/foodOrdering/view/Admin/UpdateEmploye.fxml");

    }

    public void manageItem(ActionEvent actionEvent) throws Exception {
        lblTitle.setText(btnManageItem.getText());
        superSetUI.setFxml(root, "lk/com/foodOrdering/view/Admin/UpdateMenu.fxml");

    }

    public void backToHome(ActionEvent actionEvent) throws Exception {
        superSetUI.setUI(actionEvent, "lk/com/foodOrdering/view/Admin/Login.fxml");
    }

    public void orderDetailOnAction(ActionEvent actionEvent) throws Exception {
        lblTitle.setText(btnOrderDetail.getText());
        superSetUI.setFxml(root, "lk/com/foodOrdering/view/Admin/OrderDetailForm.fxml");

    }

    public static void postIndicator(int post){
        po = post;
    }
    private void setButtonVisibel(){
        if (po==1){
            post.setText("ADMIN");
        }else if (po==2){
            post.setText("EMPLOYEE");
            btnManageEmploye.setDisable(true);
            btnManageItem.setDisable(true);
            btnReport.setDisable(true);
        }else if (po==3){
            post.setText("DELIVER");
            btnManageEmploye.setDisable(true);
            btnManageItem.setDisable(true);
            btnReport.setDisable(true);
            btnOrderDetail.setDisable(true);
            btnMangeCustomer.setDisable(true);
        }
    }

    public void report(ActionEvent actionEvent) throws Exception {
        superSetUI.setUI(actionEvent, "lk/com/foodOrdering/view/Admin/Report.fxml");
    }
}
