package lk.com.foodOrdering.entity;

public class PaymentEntity {
    private int payment_id;
    private int order_id;
    private String payment_type;
    private String payment_status;
    private String time_stamp;

    public PaymentEntity() {
    }

    public PaymentEntity(int payment_id, int order_id, String payment_type, String payment_status, String time_stamp) {
        this.payment_id = payment_id;
        this.order_id = order_id;
        this.payment_type = payment_type;
        this.payment_status = payment_status;
        this.time_stamp = time_stamp;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "payment_id=" + payment_id +
                ", order_id=" + order_id +
                ", payment_type='" + payment_type + '\'' +
                ", payment_status='" + payment_status + '\'' +
                ", time_stamp='" + time_stamp + '\'' +
                '}';
    }
}
