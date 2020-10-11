package lk.com.foodOrdering.Controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TakeOrderController {

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> ordernoCol;

    @FXML
    private TableColumn<?, ?> custCol;

    @FXML
    private TableColumn<?, ?> menuCol;

    @FXML
    private TableColumn<?, ?> QuantityCol;

    @FXML
    private TableColumn<?, ?> deliveryCol;

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private JFXButton logout;

    @FXML
    private JFXButton btnDeliverItem;

    @FXML
    void DeliverItem(ActionEvent event) {

    }

    @FXML
    void exitScreen(ActionEvent event) {
        System.exit(0);
    }

}
