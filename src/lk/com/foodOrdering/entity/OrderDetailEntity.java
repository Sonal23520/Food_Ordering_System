package lk.com.foodOrdering.entity;

public class OrderDetailEntity {
    private int orderid;
    private int menuid;
    private int qty;

    public OrderDetailEntity() {
    }

    public OrderDetailEntity(int orderid, int menuid, int qty) {
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
        return "OrderDetailEntity{" +
                "orderid=" + orderid +
                ", menuid=" + menuid +
                ", qty=" + qty +
                '}';
    }
}
