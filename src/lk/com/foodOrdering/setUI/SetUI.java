package lk.com.foodOrdering.setUI;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SetUI implements SuperSetUI {

    public void setUI(Event event,String location) throws IOException {

        Stage stage= new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/"+location))));
        stage.show();
        ((Node)event.getSource()).getScene().getWindow().hide();

    }

    @Override
    public void setFxml(AnchorPane pane,String location) throws Exception {
        pane.getChildren().clear();
        AnchorPane s=FXMLLoader.load(this.getClass().getResource("/"+location));
        pane.getChildren().add(s);
    }


}
