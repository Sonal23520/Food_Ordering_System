package lk.com.foodOrdering.dto;

public class RestaurantDTO {
    private int restaurant_id;
    private String password;
    private String first_name;
    private String last_name;
    private String post;

    public RestaurantDTO() {
    }

    public RestaurantDTO(int restaurant_id, String password, String first_name, String last_name, String post) {
        this.restaurant_id = restaurant_id;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.post = post;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "RestaurantDTO{" +
                "restaurant_id=" + restaurant_id +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", post='" + post + '\'' +
                '}';
    }
}
