package lk.com.foodOrdering.bo.custom;

import lk.com.foodOrdering.bo.SuperBo;
import lk.com.foodOrdering.dto.OrderStatusDTO;

import java.util.ArrayList;

public interface OrderStatusBO extends SuperBo {
    public ArrayList<OrderStatusDTO> getOrderStatus(int ID)throws Exception;

}
