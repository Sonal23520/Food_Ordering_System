package lk.com.foodOrdering.view.tm;

public class OrderStatusTM {
    private int order_id;
    private String menu_name;
    private int qty;
    private String order_status;

    public OrderStatusTM() {
    }

    public OrderStatusTM(int order_id, String menu_name, int qty, String order_status) {
        this.order_id = order_id;
        this.menu_name = menu_name;
        this.qty = qty;
        this.order_status = order_status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    @Override
    public String toString() {
        return "OrderStatusEntity{" +
                "order_id=" + order_id +
                ", menu_name='" + menu_name + '\'' +
                ", qty=" + qty +
                ", order_status='" + order_status + '\'' +
                '}';
    }
}
