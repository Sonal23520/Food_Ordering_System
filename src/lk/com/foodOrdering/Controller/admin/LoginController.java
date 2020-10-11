package lk.com.foodOrdering.Controller.admin;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.com.foodOrdering.alert.Alert;
import lk.com.foodOrdering.bo.BoFactory;
import lk.com.foodOrdering.bo.custom.RestaurantBO;
import lk.com.foodOrdering.dto.RestaurantDTO;
import lk.com.foodOrdering.setUI.SetUI;
import lk.com.foodOrdering.setUI.SuperSetUI;

import java.util.ArrayList;

public class LoginController {

    public JFXTextField idtxt;
    public AnchorPane root;
    @FXML
    private JFXTextField emptxt;

    @FXML
    private JFXPasswordField passtxt;
    SuperSetUI superSetUI=new SetUI();
    RestaurantBO restaurantBO = BoFactory.getInstance().getBO(BoFactory.BoType.RESTAURANT);


    @FXML
    void Login(ActionEvent event) throws Exception {
        String id= idtxt.getText();
        String pass = passtxt.getText();

        if (id.isEmpty() || pass.isEmpty()){
            Alert.alertType("/asserts/infomations.png","Information","Please fill blank fields");
        } else if (!(id.matches("[0-9]{1,}"))) {
            Alert.alertType("/asserts/infomations.png","Information","Incorrect id");
        }else{

            ArrayList<RestaurantDTO> all = restaurantBO.getAll();
            for (RestaurantDTO restaurantDTO : all) {
                if (id.equals(String.valueOf(restaurantDTO.getRestaurant_id())) && pass.equals(restaurantDTO.getPassword())){

                    if (restaurantDTO.getPost().trim().equalsIgnoreCase("ADMIN")){
                        System.out.println("okkkkkkkkk admin");
                        AdminDashBoardController.postIndicator(1);
                    }else if(restaurantDTO.getPost().trim().equalsIgnoreCase("EMPLOYEE")){
                        System.out.println("okkkkkkkkk employee");
                        AdminDashBoardController.postIndicator(2);
                    }else {
                        System.out.println("okkkkkkkkk deliver");
                        AdminDashBoardController.postIndicator(3);
                    }

                    superSetUI.setUI(event, "lk/com/foodOrdering/view/Admin/AdminDashBoard.fxml");
                    Alert.alertType("/asserts/success.png","Success","Login as "+restaurantDTO.getPost());
                    return;
                }
            }
            Alert.alertType("/asserts/infomations.png","Information","Incorrect username or password");

        }
    }

    @FXML
    void exitScreen(ActionEvent event) {
        System.exit(0);
    }

    public void backToHome(MouseEvent mouseEvent) throws Exception {
        superSetUI.setUI(mouseEvent, "lk/com/foodOrdering/view/user/Welcome.fxml");

    }

//    public void translateTransaction(int a, int b) {
//        TranslateTransition slide = new TranslateTransition();
//        slide.setDuration(Duration.seconds(0.4));
//        slide.setNode(root);
//        slide.setToX(a);
//        slide.play();
//
//       root.setTranslateX(b);
//    }
}
