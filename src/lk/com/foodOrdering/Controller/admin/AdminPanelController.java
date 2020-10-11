package lk.com.foodOrdering.Controller.admin;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.com.foodOrdering.setUI.SetUI;
import lk.com.foodOrdering.setUI.SuperSetUI;

public class AdminPanelController {

    @FXML
    private JFXTextField lastNametxt;

    @FXML
    private JFXTextField firstNametxt;

    @FXML
    private JFXPasswordField passtxt;
        SuperSetUI superSetUI=new SetUI();
    @FXML
    void AddEmployee(ActionEvent event) {

    }

    @FXML
    void TakeOrderScreen(ActionEvent event) throws Exception {
        superSetUI.setUI(event, "lk/com/foodOrdering/view/Admin/TakeOrder.fxml");
    }

    @FXML
    void exitScreen(ActionEvent event) {
            System.exit(0);
    }

}
