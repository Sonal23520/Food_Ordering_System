package lk.com.foodOrdering.dao.custom.impl;

import lk.com.foodOrdering.dao.CrudDAO;
import lk.com.foodOrdering.dao.CrudUtil;
import lk.com.foodOrdering.dao.custom.QueryDAO;
import lk.com.foodOrdering.entity.CustomerEntity;
import lk.com.foodOrdering.entity.DeliverOrderEntity;
import lk.com.foodOrdering.entity.OrderStatusEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class QueryDaoImpl implements QueryDAO {

    @Override
    public int genarateOrderID() throws Exception {
        ResultSet resultSet=CrudUtil.execute("SELECT order_id from orders ORDER BY order_id DESC limit 1");
        int x=0;
        if (resultSet.next()){
            x=resultSet.getInt(1);
        }
        return x;
    }

    @Override
    public int paymentID() throws Exception {
        ResultSet resultSet=CrudUtil.execute("SELECT payment_id from payment ORDER BY payment_id DESC limit 1");
        int x=0;
        if (resultSet.next()){
            x=resultSet.getInt(1);
        }
        return x;
    }

    @Override
    public boolean changeOrderStatus(String text,int ID) throws Exception {
        return CrudUtil.execute("UPDATE orders SET order_status=? WHERE order_id=?",text,ID);
    }

    @Override
    public ArrayList<OrderStatusEntity> getOrderStatus(int ID) throws Exception {
        ArrayList<OrderStatusEntity> arrayList = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT foody.orders.order_id,foody.menu.menu_name,foody.order_details.qty,foody.orders.order_status from foody.orders join order_details on foody.orders.order_id=foody.order_details.orderid join menu on foody.order_details.menuid=foody.menu.menu_id where foody.orders.customer_id=?",ID);
        while (resultSet.next()){
            arrayList.add(new OrderStatusEntity(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4)));
        }
        return arrayList;
    }

    @Override
    public ArrayList<DeliverOrderEntity> getDeliverOrder() throws Exception {
        ArrayList<DeliverOrderEntity> arrayList = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT order_id,customer.customer_id,first_name,last_name,phone_no,province,addressline1,addressline2,order_status FROM foody.orders inner join foody.customer on foody.orders.customer_id=foody.customer.customer_id WHERE order_status=\"CONFIRMED\" or order_status=\"PAYMENT_CONFIRMED\"");
        while (resultSet.next()){
            arrayList.add(new DeliverOrderEntity(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6)+","+resultSet.getString(7)+","+resultSet.getString(8),resultSet.getString(9)));
        }
        return arrayList;
    }

    @Override
    public boolean updateCustomer(CustomerEntity customerEntity) throws Exception {
        return CrudUtil.execute("UPDATE customer SET first_name=?,last_name=?,email_id=?,password=?,phone_no=?, province=?, addressline1=?, addressline2=?, pincode=? WHERE customer_id=?",customerEntity.getFname(),customerEntity.getLname(),customerEntity.getEmail(),customerEntity.getPassword(),customerEntity.getPhoneno(),customerEntity.getProvince(),customerEntity.getAddressline1(),customerEntity.getAddressline2(),customerEntity.getPostalcode(),customerEntity.getId());
    }


}
