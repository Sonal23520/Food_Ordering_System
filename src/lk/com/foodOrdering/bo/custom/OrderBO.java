package lk.com.foodOrdering.bo.custom;

import lk.com.foodOrdering.bo.SuperBo;
import lk.com.foodOrdering.dto.MenuDTO;
import lk.com.foodOrdering.dto.OrderDTO;

import java.util.ArrayList;

public interface OrderBO extends SuperBo {
    public boolean add(ArrayList<OrderDTO> arrayList)throws Exception;
    public ArrayList<OrderDTO>getOrders()throws Exception;
    public int passOrderID()throws Exception;

}
