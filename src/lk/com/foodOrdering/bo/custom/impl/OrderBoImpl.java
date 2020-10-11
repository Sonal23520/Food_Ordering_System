package lk.com.foodOrdering.bo.custom.impl;

import lk.com.foodOrdering.bo.custom.OrderBO;
import lk.com.foodOrdering.dao.DaoFactory;
import lk.com.foodOrdering.dao.custom.OrderDAO;
import lk.com.foodOrdering.dao.custom.OrderDetailDAO;
import lk.com.foodOrdering.dao.custom.QueryDAO;
import lk.com.foodOrdering.db.DBConnection;
import lk.com.foodOrdering.dto.OrderDTO;
import lk.com.foodOrdering.entity.OrderDetailEntity;
import lk.com.foodOrdering.entity.OrderEntity;

import javax.xml.parsers.DocumentBuilder;
import java.sql.Connection;
import java.util.ArrayList;

public class OrderBoImpl implements OrderBO {
    OrderDAO orderDAO= DaoFactory.getInstance().getDao(DaoFactory.DaoType.ORDER);
    OrderDetailDAO orderDetailDAO=DaoFactory.getInstance().getDao(DaoFactory.DaoType.ORDERDETAIL);
    QueryDAO queryDAO=DaoFactory.getInstance().getDao(DaoFactory.DaoType.QUERY);

    @Override
    public boolean add(ArrayList<OrderDTO> arrayList) throws Exception {
        boolean b=false;
        boolean add=false;
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            for (OrderDTO orderDTO : arrayList) {
                if (orderDAO.add(new OrderEntity(orderDTO.getOrder_id(),orderDTO.getCustomer_id(),orderDTO.getOrder_status(),orderDTO.getTime_stamp()))){
                    for (int i = 0; i < arrayList.size(); i++) {
                        if(orderDetailDAO.add(new OrderDetailEntity(queryDAO.genarateOrderID(), arrayList.get(i).getMenu_id(), arrayList.get(i).getQty()))){

                        }
                    }
                    connection.commit();
                    return true;
                }
                connection.rollback();

            }
        }finally {
            connection.setAutoCommit(true);
        }
        return false;
    }

    @Override
    public ArrayList<OrderDTO> getOrders() throws Exception {
        ArrayList<OrderDTO> arrayList = new ArrayList<>();
        ArrayList<OrderEntity> orderEntities = orderDAO.get();
        for (OrderEntity orderEntity : orderEntities) {
            arrayList.add(new OrderDTO(orderEntity.getOrder_id(),orderEntity.getCustomer_id(),orderEntity.getOrder_status(),orderEntity.getTime_stamp(),5,5));
        }
        return arrayList;
    }

    @Override
    public int passOrderID() throws Exception {
        return queryDAO.genarateOrderID();
    }

}
