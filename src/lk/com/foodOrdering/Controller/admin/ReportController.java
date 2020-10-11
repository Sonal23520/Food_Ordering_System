package lk.com.foodOrdering.Controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.com.foodOrdering.bo.BoFactory;
import lk.com.foodOrdering.bo.custom.OrderDetailBO;
import lk.com.foodOrdering.db.DBConnection;
import lk.com.foodOrdering.dto.OrderDetailDTO;
import lk.com.foodOrdering.setUI.SetUI;
import lk.com.foodOrdering.setUI.SuperSetUI;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ReportController {
    public JFXButton btnIncome;
    public JFXButton btnOrderDetail;
    public ImageView back;
    OrderDetailBO orderDetailBO = BoFactory.getInstance().getBO(BoFactory.BoType.ORDERDETAIL);
    int tot=0;
    public void income(ActionEvent actionEvent) throws Exception {
        ArrayList<OrderDetailDTO> all = orderDetailBO.getAll();
        for (OrderDetailDTO orderDetailDTO : all) {
            System.out.println(orderDetailDTO.getQty());

                if (orderDetailDTO.getMenuid()==1){
                    tot+=(350*orderDetailDTO.getQty());
                }else if (orderDetailDTO.getMenuid()==2){
                    tot+=250*orderDetailDTO.getQty();
                }else if (orderDetailDTO.getMenuid()==3){
                    tot+=400*orderDetailDTO.getQty();
                }else if (orderDetailDTO.getMenuid()==4){
                    tot+=450*orderDetailDTO.getQty();
                }else if (orderDetailDTO.getMenuid()==5){
                    tot+=50*orderDetailDTO.getQty();
                }else if (orderDetailDTO.getMenuid()==6){
                    tot+=80*orderDetailDTO.getQty();
                }else if (orderDetailDTO.getMenuid()==7){
                    tot+=300*orderDetailDTO.getQty();
                }else if (orderDetailDTO.getMenuid()==8){
                    tot+=180*orderDetailDTO.getQty();
                }else if (orderDetailDTO.getMenuid()==9){
                    tot+=200*orderDetailDTO.getQty();
                }else if (orderDetailDTO.getMenuid()==10){
                    tot+=150*orderDetailDTO.getQty();
                }else if (orderDetailDTO.getMenuid()==11){
                    tot+=300*orderDetailDTO.getQty();
                }else if (orderDetailDTO.getMenuid()==12){
                    tot+=250*orderDetailDTO.getQty();
                }
        }
        try {
                InputStream inputStream = this.getClass().getResourceAsStream("/lk/com/foodOrdering/reports/Income.jasper");
                HashMap hashMap = new HashMap();
                hashMap.put("total",String.valueOf(tot));
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

    public void orderDetail(ActionEvent actionEvent) {

        try {
            InputStream inputStream =this.getClass().getResourceAsStream("/lk/com/foodOrdering/reports/OrderDetail.jasper");
            JasperPrint jasperPrint = null;
            jasperPrint = JasperFillManager.fillReport(inputStream, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (JRException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }

    SuperSetUI superSetUI = new SetUI();
    public void home(MouseEvent mouseEvent) throws Exception {
        superSetUI.setUI(mouseEvent, "lk/com/foodOrdering/view/Admin/AdminDashBoard.fxml");
    }
}
