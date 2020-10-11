package lk.com.foodOrdering.dao.custom.impl;

import lk.com.foodOrdering.dao.CrudUtil;
import lk.com.foodOrdering.dao.custom.OrderDAO;
import lk.com.foodOrdering.entity.OrderEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderDaoImpl implements OrderDAO {

    @Override
    public boolean add(OrderEntity orderEntity) throws Exception {
        return CrudUtil.execute("INSERT INTO orders VALUES(?,?,?,?)",orderEntity.getOrder_id(),orderEntity.getCustomer_id(),orderEntity.getOrder_status(),orderEntity.getTime_stamp());
    }

    @Override
    public boolean update(OrderEntity orderEntity) throws Exception {
        return false;
    }

    @Override
    public ArrayList<OrderEntity> get() throws Exception, ClassNotFoundException {
        ArrayList<OrderEntity> arrayList = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM orders");
        while (resultSet.next()){
            arrayList.add(new OrderEntity(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4)));
        }
        return arrayList;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("delete from orders where customer_id=?",s);
    }

    @Override
    public ArrayList<OrderEntity> search(String s) throws Exception {
        return null;
    }
}
