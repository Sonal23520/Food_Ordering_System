package lk.com.foodOrdering.view.tm;

import com.jfoenix.controls.JFXButton;

public class MenuTM_1 {
    private int id;
    private String name;
    private int price;
    private JFXButton jfxButton;

    public MenuTM_1() {
    }

    public MenuTM_1(int id, String name, int price, JFXButton jfxButton) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.jfxButton = jfxButton;
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

    public JFXButton getJfxButton() {
        return jfxButton;
    }

    public void setJfxButton(JFXButton jfxButton) {
        this.jfxButton = jfxButton;
    }

    @Override
    public String toString() {
        return "MenuTM_1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", jfxButton=" + jfxButton +
                '}';
    }
}
