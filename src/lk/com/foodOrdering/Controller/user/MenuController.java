package lk.com.foodOrdering.Controller.user;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.com.foodOrdering.alert.Alert;
import lk.com.foodOrdering.bo.BoFactory;
import lk.com.foodOrdering.bo.custom.CustomerBO;
import lk.com.foodOrdering.bo.custom.MenuBO;
import lk.com.foodOrdering.bo.custom.OrderBO;
import lk.com.foodOrdering.bo.custom.OrderStatusBO;
import lk.com.foodOrdering.db.DBConnection;
import lk.com.foodOrdering.dto.CustomerDTO;
import lk.com.foodOrdering.dto.MenuDTO;
import lk.com.foodOrdering.dto.OrderDTO;
import lk.com.foodOrdering.dto.OrderStatusDTO;
import lk.com.foodOrdering.setUI.SetUI;
import lk.com.foodOrdering.setUI.SuperSetUI;
import lk.com.foodOrdering.view.tm.MenuTM;
import lk.com.foodOrdering.view.tm.OrderStatusTM;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    public TextField txtProvince;
    public TextField txtAddressLine1;
    public TextField txtPostalcode;
    public TextArea txtAddressLine2;
    public SplitPane Amenu1;
    @FXML
    private JFXButton btn1;

    @FXML
    private JFXButton btn2;

    @FXML
    private JFXButton btn3;

    @FXML
    private JFXButton btn4;

    @FXML
    private JFXButton btn5;

    @FXML
    private JFXButton btn6;

    @FXML
    private JFXButton btn7;

    @FXML
    private JFXButton btn8;

    @FXML
    private JFXButton btn9;

    @FXML
    private JFXButton btn12;

    @FXML
    private JFXButton btn11;

    @FXML
    private JFXButton btn10;

    @FXML
    private Label custLabel;

    @FXML
    private TableView<MenuTM> table;

    @FXML
    private TableColumn<?, ?> MenuIdCol;

    @FXML
    private TableColumn<?, ?> MenuNameCol;

    @FXML
    private TableColumn<?, ?> PriceCol;

    @FXML
    private TableColumn<?, ?> QuantityCol;

    @FXML
    private Label totalAmount;

    @FXML
    private PasswordField oldpasstxt;

    @FXML
    private PasswordField newpasstxt;

    @FXML
    private TableView<OrderStatusTM> table1;

    @FXML
    private TableColumn<?, ?> OrderidCol1;

    @FXML
    private TableColumn<?, ?> MenuNameCol1;

    @FXML
    private TableColumn<?, ?> QuantityCol1;

    @FXML
    private TableColumn<?, ?> OrderStatusCol1;
    int cust=0;
    SuperSetUI superSetUI;
    CustomerBO customerBO;
    MenuBO menuBO;
    OrderBO orderBO;
    OrderStatusBO orderStatusBO;
    static CustomerDTO customerDTOS;
    ObservableList<MenuTM>observableList=FXCollections.observableArrayList();
    ObservableList<OrderStatusTM>orderStatusList=FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MenuIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        MenuNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        QuantityCol.setCellValueFactory(new PropertyValueFactory<>("qty"));

        OrderidCol1.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        MenuNameCol1.setCellValueFactory(new PropertyValueFactory<>("menu_name"));
        QuantityCol1.setCellValueFactory(new PropertyValueFactory<>("qty"));
        OrderStatusCol1.setCellValueFactory(new PropertyValueFactory<>("order_status"));




        orderStatusBO = BoFactory.getInstance().getBO(BoFactory.BoType.ORDERSTATUS);
        customerBO= BoFactory.getInstance().getBO(BoFactory.BoType.CUSTOMER);
        superSetUI=new SetUI();
        menuBO=BoFactory.getInstance().getBO(BoFactory.BoType.Menu);
        orderBO=BoFactory.getInstance().getBO(BoFactory.BoType.ORDER);

        try {
            ArrayList<OrderStatusDTO> orderStatus = orderStatusBO.getOrderStatus(LoginController.getCustID());
            for (OrderStatusDTO status : orderStatus) {
                orderStatusList.add(new OrderStatusTM(status.getOrder_id(),status.getMenu_name(),status.getQty(),
                        status.getOrder_status()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        table1.setItems(orderStatusList);









    }

    @FXML
    void Logout(ActionEvent event) throws Exception {
        superSetUI.setUI(event,"lk/com/foodOrdering/view/user/Login.fxml");
    }


    @FXML
    void Menu1(ActionEvent event) throws Exception {
        loadTable(1);

    }

    @FXML
    void Menu2(ActionEvent event) throws Exception {
        loadTable(2);
    }


    @FXML
    void Menu3(ActionEvent event) throws Exception {
        loadTable(3);
    }

    @FXML
    void Menu4(ActionEvent event) throws Exception {
        loadTable(4);
    }

    @FXML
    void Menu5(ActionEvent event) throws Exception {
        loadTable(5);
    }

    @FXML
    void Menu6(ActionEvent event) throws Exception {
        loadTable(6);
    }

    @FXML
    void Menu7(ActionEvent event) throws Exception {
        loadTable(7);
    }

    @FXML
    void Menu8(ActionEvent event) throws Exception {
        loadTable(8);
    }

    @FXML
    void Menu9(ActionEvent event) throws Exception {
        loadTable(9);
    }

    @FXML
    void Menu10(ActionEvent event) throws Exception {
        loadTable(10);
    }

    @FXML
    void Menu11(ActionEvent event) throws Exception {
        loadTable(11);
    }

    @FXML
    void Menu12(ActionEvent event) throws Exception {
        loadTable(12);
    }

    @FXML
    void UpdatePassword(ActionEvent event) throws Exception {
        ArrayList<CustomerDTO> loginDetails = customerBO.getLoginDetails();
        for (CustomerDTO loginDetail : loginDetails) {
            if (customerDTOS.getId()==loginDetail.getId()){

                if(oldpasstxt.getText().trim().equalsIgnoreCase("") || newpasstxt.getText().trim()
                        .equalsIgnoreCase("")){
                    Alert.alertType("asserts/infomations.png","Information","Please fill blank fields");
                    oldpasstxt.requestFocus();
                }else {
                    if (newpasstxt.getLength()>=4){
                        if (oldpasstxt.getText().trim().equals(loginDetail.getPassword())){
                            oldpasstxt.setStyle("-fx-border-color: green;");

                            boolean confirmation = Alert.conformAlert("CONFIRMATION", "Are You Sure?");
                            if (confirmation){
                                boolean b = customerBO.updateCustomer(new CustomerDTO(loginDetail.getId(),
                                        loginDetail.getFname(),loginDetail.getLname(),loginDetail.getEmail(),
                                        newpasstxt.getText(),loginDetail.getPhoneno(),loginDetail.getProvince(),
                                        loginDetail.getAddressline1(),loginDetail.getAddressline2(),
                                        loginDetail.getPostalcode()));
                                if(b){
                                    Alert.alertType("asserts/success.png","Updated","Password Updated");
                                    oldpasstxt.setStyle("-fx-border-color: null");
                                    oldpasstxt.clear();
                                    newpasstxt.clear();
                                }else {
                                    Alert.alertType("asserts/erro.png","Update Fail",
                                            "Password Updated Fail");
                                }
                            }else {
                                oldpasstxt.clear();
                                newpasstxt.clear();
                            }

                        }else {
                            Alert.alertType("asserts/infomations.png","Information",
                                    "Incorrect Old Password");
                            oldpasstxt.setStyle("-fx-border-color: red;");
                            oldpasstxt.requestFocus();
                        }
                    }else {
                        Alert.alertType("asserts/infomations.png","Information",
                                "Password length should be more than 4");
                    }
                }
            }
        }

    }

    @FXML
    void deleteItem(ActionEvent event) {
        if (table.getSelectionModel().getSelectedItem()==null){
            Alert.alertType("/asserts/infomations.png","Information","Please select field");
            return;
        }
        for (int i = 0; i < table.getItems().size(); i++) {
            if (observableList.get(i).getId()==table.getSelectionModel().getSelectedItem().getId()){
                if (table.getSelectionModel().getSelectedItem().getQty()>1){
                    observableList.get(i).setPrice((observableList.get(i).getPrice())-(table.getSelectionModel()
                            .getSelectedItem().getPrice()/table.getSelectionModel().getSelectedItem().getQty()));
                    findTotal();
                    observableList.get(i).setQty(table.getSelectionModel().getSelectedItem().getQty()-1);
                    table.refresh();
                    return;
                }else {
                    table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
                    findTotal();
                    return;
                }
            }
        }
    }

    @FXML
    void paymentScreen(ActionEvent event) throws Exception {
        System.out.println(java.time.LocalDate.now());
        ArrayList<OrderDTO> arrayList = new ArrayList<>();
        for (int i = 0; i < table.getItems().size(); i++) {
            arrayList.add(new OrderDTO(0,customerDTOS.getId(),"ADDED_TO_CART",java.time.LocalDate.
                    now().toString(),Integer.parseInt(MenuIdCol.getCellData(i).toString()),Integer.parseInt
                    (QuantityCol.getCellData(i).toString())));
        }
        boolean add = orderBO.add(arrayList);
        if (add){
            Alert.alertType("asserts/success.png","Success","Order Added");
            superSetUI.setUI(event, "lk/com/foodOrdering/view/user/Payment.fxml");
        }
    }

    @FXML
    void putAddress(ActionEvent event) throws Exception {
        String province=txtProvince.getText().toLowerCase();
        String line1=txtAddressLine1.getText().toLowerCase();
        String line2=txtAddressLine2.getText().toLowerCase();
        String postal=txtPostalcode.getText();
        String pass=null;
        ArrayList<CustomerDTO> loginDetails = customerBO.getLoginDetails();
        for (CustomerDTO loginDetail : loginDetails) {
            if (loginDetail.getId()==customerDTOS.getId()){
                pass=loginDetail.getPassword();
            }
        }

        if (province.isEmpty() || line1.isEmpty() || line2.isEmpty() || postal.isEmpty()){
            Alert.alertType("/asserts/infomations.png","Information","Please fill blank fields");
        }else if (!(province.matches("[a-zA-Z]+"))){
            invalid(txtProvince,"invalid province field");
        }else if (!(line1.matches("[a-zA-Z]+"))){
            invalid(txtAddressLine1,"invalid address_line_1 field");
        }else if(!(line2.matches("[a-zA-Z]+"))){
            invalid(txtAddressLine2,"invalid address_line_2 field");
        }else if(!(postal.matches("[0-9][0-9][0-9][0-9][0-9]"))){
            invalid(txtPostalcode,"invalid postalcode");
        }else {
            boolean b = customerBO.updateCustomer(new CustomerDTO(customerDTOS.getId(),customerDTOS.getFname(),
                    customerDTOS.getLname(),customerDTOS.getEmail(),pass,customerDTOS.getPhoneno(),province,line1,line2,
                    Integer.parseInt(postal)));
            if (b){
                Alert.alertType("asserts/success.png","Updated","Address Updated");
                txtProvince.clear();
                txtAddressLine1.clear();
                txtAddressLine2.clear();
                txtPostalcode.clear();
            }
        }


    }



    public static void getPassword(CustomerDTO customerDTO){
      customerDTOS=customerDTO;

    }

    private static void invalid(TextField textField,String text){
        Alert.alertType("/asserts/invalids.png","Information",text);
        textField.setStyle("-fx-border-color: red;");
    }
    private static void invalid(TextArea textArea,String text){
        Alert.alertType("/asserts/invalids.png","Information",text);
        textArea.setStyle("-fx-border-color: red;");


    }
    public static ArrayList<MenuDTO> getMenu() throws Exception {
        MenuBO menuBO=BoFactory.getInstance().getBO(BoFactory.BoType.Menu);
        ArrayList<MenuDTO> arrayList = new ArrayList<>();
        ArrayList<MenuDTO> menuDTOS = menuBO.get();
        for (MenuDTO menuDTO : menuDTOS) {
            arrayList.add(new MenuDTO(menuDTO.getId(),menuDTO.getName(),menuDTO.getPrice()));
        }
        return arrayList;

    }
    boolean loadTable(int id) throws Exception {

        ArrayList<MenuDTO> menu = getMenu();
        for (MenuDTO menuDTO : menu) {
            if (menuDTO.getId()==id){
                if (table.getItems().isEmpty()){
                    observableList.add(new MenuTM(menuDTO.getId(),menuDTO.getName(),menuDTO.getPrice(),1));
                    table.setItems(observableList);
                    findTotal();
                    return true;
                }else {
                    table.refresh();
                    for (int i = 0; i < table.getItems().size(); i++) {
                        if (observableList.get(i).getId()==menuDTO.getId()){
                            boolean information = Alert.conformAlert("Information",
                                    "Do You Want To Add Another One?");
                            if (information) {
                                observableList.get(i).setPrice(observableList.get(i).getPrice() + menuDTO.getPrice());
                                observableList.get(i).setQty(observableList.get(i).getQty()+1);
                                findTotal();
                                table.refresh();
                            }
                            return true;
                        }
                    }
                    observableList.add(new MenuTM(menuDTO.getId(), menuDTO.getName(), menuDTO.getPrice(), 1));
                    table.setItems(observableList);
                    table.refresh();
                    findTotal();
                    return true;
                }

            }
        }

        return false;
    }
static String s;
    void findTotal(){
        int x=0;
        for (int i = 0; i < table.getItems().size(); i++) {
            x+=Integer.parseInt(PriceCol.getCellData(i).toString());
        }
        totalAmount.setText(String.valueOf(x));
        s=totalAmount.getText();
    }
    public static String getAmount(){
        return s;
    }

    public static int getCustomerID(){
        return customerDTOS.getId();
    }

    public void customerOrderReport(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, JRException {

        InputStream inputStream = this.getClass().getResourceAsStream(
                "/lk/com/foodOrdering/reports/Customer_Wise_Orders.jasper");
        HashMap hashMap = new HashMap<>();
        hashMap.put("custID",customerDTOS.getId());
        JasperReport jasperReport;
        JRDataSource dataSource;
        JasperPrint jasperPrint=JasperFillManager.fillReport(inputStream, hashMap, DBConnection.getInstance().
                getConnection());
        JasperViewer.viewReport(jasperPrint,false);



    }
}
