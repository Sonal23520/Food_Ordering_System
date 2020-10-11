package lk.com.foodOrdering.dao.custom;

import lk.com.foodOrdering.dao.SuperDAO;
import lk.com.foodOrdering.entity.CustomerEntity;
import lk.com.foodOrdering.entity.DeliverOrderEntity;
import lk.com.foodOrdering.entity.OrderStatusEntity;

import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    public int genarateOrderID()throws Exception;
    public int paymentID()throws Exception;
    public boolean changeOrderStatus(String text,int ID)throws Exception;
    public ArrayList<OrderStatusEntity> getOrderStatus(int ID)throws Exception;
    public ArrayList<DeliverOrderEntity>getDeliverOrder()throws Exception;
    public boolean updateCustomer(CustomerEntity customerEntity)throws Exception;
}
