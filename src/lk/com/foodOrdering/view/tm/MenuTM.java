package lk.com.foodOrdering.view.tm;

public class MenuTM {
    private int id;
    private String name;
    private int price;
    private int qty;

    public MenuTM() {
    }

    public MenuTM(int id, String name, int price, int qty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "MenuTM{" +
                "id=" + id +
                ", namel='" + name + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }
}
