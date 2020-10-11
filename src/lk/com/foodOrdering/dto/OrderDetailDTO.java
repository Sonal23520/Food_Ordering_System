package lk.com.foodOrdering.dto;

public class OrderDetailDTO {
    private int orderid;
    private int menuid;
    private int qty;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int orderid, int menuid, int qty) {
        this.orderid = orderid;
        this.menuid = menuid;
        this.qty = qty;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "orderid=" + orderid +
                ", menuid=" + menuid +
                ", qty=" + qty +
                '}';
    }
}
