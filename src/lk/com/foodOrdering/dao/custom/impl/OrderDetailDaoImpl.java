package lk.com.foodOrdering.dao.custom.impl;

import lk.com.foodOrdering.dao.CrudUtil;
import lk.com.foodOrdering.dao.custom.OrderDetailDAO;
import lk.com.foodOrdering.entity.OrderDetailEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderDetailDaoImpl implements OrderDetailDAO {

    @Override
    public boolean add(OrderDetailEntity orderDetailEntity) throws Exception {
        return CrudUtil.execute("INSERT INTO order_details  VALUES(?,?,?)",orderDetailEntity.getOrderid(),orderDetailEntity.getMenuid(),orderDetailEntity.getQty());
    }

    @Override
    public boolean update(OrderDetailEntity orderDetailEntity) throws Exception {
        return false;
    }

    @Override
    public ArrayList<OrderDetailEntity> get() throws Exception, ClassNotFoundException {
        ArrayList<OrderDetailEntity> arrayList = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM foody.order_details");
        while (resultSet.next()){
            arrayList.add(new OrderDetailEntity(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3)));
        }
        return arrayList;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("delete foody.order_details from order_details inner join orders where orders.order_id=order_details.orderid and customer_id=?",s);

    }

    @Override
    public ArrayList<OrderDetailEntity> search(String s) throws Exception {
        return null;
    }
}
