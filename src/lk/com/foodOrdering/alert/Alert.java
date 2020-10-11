package lk.com.foodOrdering.alert;

import javafx.geometry.Pos;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.util.Optional;

public class Alert {
    public static void alertType(String url,String title,String text){
        Image image = new Image(url,50,50,false,false);
        Notifications notifications=Notifications.create();
        notifications.title(title);
        notifications.graphic(new ImageView(image));
        notifications.text(text);
        notifications.hideAfter(Duration.seconds(4));
        notifications.position(Pos.BOTTOM_RIGHT);
//        notifications.darkStyle();
        notifications.show();
    }

    public static boolean conformAlert(String title,String text){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setContentText(text);
        alert.setHeaderText(null);
        alert.getButtonTypes();
        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;

    }
}
