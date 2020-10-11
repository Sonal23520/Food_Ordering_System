package lk.com.foodOrdering.bo.custom;

import lk.com.foodOrdering.bo.SuperBo;
import lk.com.foodOrdering.dto.DeliverOrderDTO;
import lk.com.foodOrdering.dto.RestaurantDTO;
import lk.com.foodOrdering.entity.RestaurantEntity;

import java.util.ArrayList;

public interface RestaurantBO extends SuperBo {
    public ArrayList<DeliverOrderDTO>getDeliverOrder()throws Exception;
    public boolean changeOrderStatus(String text,int ID)throws Exception;
    public ArrayList<RestaurantDTO>getAll()throws Exception;
    public ArrayList<RestaurantDTO> search(String s)throws Exception;
    public boolean add(RestaurantDTO restaurantDTO)throws Exception;
    public boolean update(RestaurantDTO restaurantDTO)throws Exception;
}
