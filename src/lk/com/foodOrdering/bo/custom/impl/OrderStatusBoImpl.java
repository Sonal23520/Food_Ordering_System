package lk.com.foodOrdering.bo.custom.impl;

import lk.com.foodOrdering.bo.custom.OrderStatusBO;
import lk.com.foodOrdering.dao.DaoFactory;
import lk.com.foodOrdering.dao.custom.QueryDAO;
import lk.com.foodOrdering.dto.OrderStatusDTO;
import lk.com.foodOrdering.entity.OrderStatusEntity;

import java.util.ArrayList;
public class OrderStatusBoImpl implements OrderStatusBO {
    QueryDAO queryDAO= DaoFactory.getInstance().getDao(DaoFactory.DaoType.QUERY);
    @Override
    public ArrayList<OrderStatusDTO> getOrderStatus(int ID) throws Exception {
        ArrayList<OrderStatusDTO> arrayList = new ArrayList<>();
        ArrayList<OrderStatusEntity> orderStatus = queryDAO.getOrderStatus(ID);
        for (OrderStatusEntity status : orderStatus) {
            arrayList.add(new OrderStatusDTO(status.getOrder_id(),status.getMenu_name(),status.getQty(),status.getOrder_status()));
        }
        return arrayList;
    }

}
