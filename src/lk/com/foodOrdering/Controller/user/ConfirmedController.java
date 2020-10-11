/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.com.foodOrdering.Controller.user;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import lk.com.foodOrdering.setUI.SetUI;
import lk.com.foodOrdering.setUI.SuperSetUI;


public class ConfirmedController implements Initializable {
    SuperSetUI superSetUI;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            superSetUI=new SetUI();
    }

    public void back(MouseEvent mouseEvent) throws Exception {
        superSetUI.setUI(mouseEvent,"lk/com/foodOrdering/view/user/Login.fxml");
    }
}
