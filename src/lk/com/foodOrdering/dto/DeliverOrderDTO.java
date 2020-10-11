package lk.com.foodOrdering.dto;

public class DeliverOrderDTO {
    private int order_id;
    private int customer_id;
    private String first_name;
    private String last_name;
    private int phone_no;
    private String province;
    private String order_status;

    public DeliverOrderDTO() {
    }

    public DeliverOrderDTO(int order_id, int customer_id, String first_name, String last_name, int phone_no, String province, String order_status) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_no = phone_no;
        this.province = province;
        this.order_status = order_status;
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    @Override
    public String toString() {
        return "DeliverOrderDTO{" +
                "order_id=" + order_id +
                ", customer_id=" + customer_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone_no=" + phone_no +
                ", province='" + province + '\'' +
                ", order_status='" + order_status + '\'' +
                '}';
    }
}
