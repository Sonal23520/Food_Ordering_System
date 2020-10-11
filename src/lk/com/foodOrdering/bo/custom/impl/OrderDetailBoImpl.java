package lk.com.foodOrdering.bo.custom.impl;

import lk.com.foodOrdering.bo.custom.OrderDetailBO;
import lk.com.foodOrdering.dao.DaoFactory;
import lk.com.foodOrdering.dao.custom.OrderDetailDAO;
import lk.com.foodOrdering.dto.OrderDetailDTO;
import lk.com.foodOrdering.entity.OrderDetailEntity;

import java.util.ArrayList;

public class OrderDetailBoImpl implements OrderDetailBO {
    OrderDetailDAO orderDetailDAO = DaoFactory.getInstance().getDao(DaoFactory.DaoType.ORDERDETAIL);
    @Override
    public ArrayList<OrderDetailDTO> getAll() throws Exception {
        ArrayList<OrderDetailDTO> arrayList = new ArrayList<>();
        ArrayList<OrderDetailEntity> orderDetailEntities = orderDetailDAO.get();
        for (OrderDetailEntity orderDetailEntity : orderDetailEntities) {
            arrayList.add(new OrderDetailDTO(orderDetailEntity.getOrderid(),orderDetailEntity.getMenuid(),orderDetailEntity.getQty()));
        }
        return arrayList;

    }
}
