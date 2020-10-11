package lk.com.foodOrdering.view.tm;

public class OrderTM {
    private int order_id;
    private int customer_id;
    private String order_status;
    private String time_stamp;

    public OrderTM() {
    }

    public OrderTM(int order_id, int customer_id, String order_status, String time_stamp) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.order_status = order_status;
        this.time_stamp = time_stamp;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

    @Override
    public String toString() {
        return "OrderTM{" +
                "order_id=" + order_id +
                ", customer_id=" + customer_id +
                ", order_status='" + order_status + '\'' +
                ", time_stamp='" + time_stamp + '\'' +
                '}';
    }
}
