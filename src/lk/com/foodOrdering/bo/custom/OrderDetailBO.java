package lk.com.foodOrdering.bo.custom;

import lk.com.foodOrdering.dto.OrderDetailDTO;

import java.util.ArrayList;

public interface OrderDetailBO {
    public ArrayList<OrderDetailDTO> getAll()throws Exception;
}
