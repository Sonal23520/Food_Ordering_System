package lk.com.foodOrdering.entity;

public class PaymentDetailsEntity {
    private int payment_id;
    private int customer_id;
    private String card_number;
    private String card_holder_name;
    private int cvv;
    private int exp_month;
    private int exp_year;
    private String time_stamp;

    public PaymentDetailsEntity() {
    }

    public PaymentDetailsEntity(int payment_id, int customer_id, String card_number, String card_holder_name, int cvv, int exp_month, int exp_year, String time_stamp) {
        this.payment_id = payment_id;
        this.customer_id = customer_id;
        this.card_number = card_number;
        this.card_holder_name = card_holder_name;
        this.cvv = cvv;
        this.exp_month = exp_month;
        this.exp_year = exp_year;
        this.time_stamp = time_stamp;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getCard_holder_name() {
        return card_holder_name;
    }

    public void setCard_holder_name(String card_holder_name) {
        this.card_holder_name = card_holder_name;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getExp_month() {
        return exp_month;
    }

    public void setExp_month(int exp_month) {
        this.exp_month = exp_month;
    }

    public int getExp_year() {
        return exp_year;
    }

    public void setExp_year(int exp_year) {
        this.exp_year = exp_year;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

    @Override
    public String toString() {
        return "PaymentDetailsEntity{" +
                "payment_id=" + payment_id +
                ", customer_id=" + customer_id +
                ", card_number='" + card_number + '\'' +
                ", card_holder_name='" + card_holder_name + '\'' +
                ", cvv=" + cvv +
                ", exp_month=" + exp_month +
                ", exp_year=" + exp_year +
                ", time_stamp='" + time_stamp + '\'' +
                '}';
    }
}
