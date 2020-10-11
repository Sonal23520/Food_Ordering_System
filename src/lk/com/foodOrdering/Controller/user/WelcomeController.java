/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.com.foodOrdering.Controller.user;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.com.foodOrdering.setUI.SetUI;
import lk.com.foodOrdering.setUI.SuperSetUI;


public class WelcomeController implements Initializable {
    public ImageView lblAdmin;
    SuperSetUI superSetUI;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      superSetUI=new SetUI();
    }
    @FXML
     public void loginScreen(ActionEvent event) throws Exception  {
        superSetUI.setUI(event,"lk/com/foodOrdering/view/user/Login.fxml");
	}
     @FXML
      public void signupScreen(ActionEvent event) throws Exception  {
        superSetUI.setUI(event,"lk/com/foodOrdering/view/user/Signup.fxml");
	}

    public void loadAdminLogin(MouseEvent mouseEvent) throws Exception {
        superSetUI.setUI(mouseEvent, "lk/com/foodOrdering/view/Admin/Login.fxml");
    }
}
