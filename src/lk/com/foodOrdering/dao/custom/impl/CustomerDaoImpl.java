package lk.com.foodOrdering.dao.custom.impl;

import lk.com.foodOrdering.dao.CrudUtil;
import lk.com.foodOrdering.dao.custom.CustomerDAO;
import lk.com.foodOrdering.entity.CustomerEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDAO {
    @Override
    public boolean add(CustomerEntity customerEntity) throws Exception {
        return CrudUtil.execute("INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?,?)",customerEntity.getId(),customerEntity.getFname(),customerEntity.getLname(),customerEntity.getEmail(),customerEntity.getPassword(),customerEntity.getPhoneno(),customerEntity.getProvince(),customerEntity.getAddressline1(),customerEntity.getAddressline2(),customerEntity.getPostalcode());
    }

    @Override
    public boolean update(CustomerEntity customerEntity) throws Exception {
        return CrudUtil.execute("UPDATE customer SET password=?, province=?, addressline1=?, addressline2=?, pincode=? WHERE customer_id=?",customerEntity.getPassword(),customerEntity.getProvince(),customerEntity.getAddressline1(),customerEntity.getAddressline2(),customerEntity.getPostalcode(),customerEntity.getId());
    }

    @Override
    public ArrayList<CustomerEntity> get() throws Exception, ClassNotFoundException {
        ArrayList<CustomerEntity> arrayList = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM customer");
        while (resultSet.next()){
            arrayList.add(new CustomerEntity(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getInt(10)));
        }
        return arrayList;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("Delete from customer where customer_id=?",s);
    }

    @Override
    public ArrayList<CustomerEntity> search(String s) throws Exception {
        ArrayList<CustomerEntity> customerEntities = new ArrayList<>();
        ResultSet resultSet=CrudUtil.execute("SELECT * FROM customer where customer_id=?",Integer.parseInt(s));
        while (resultSet.next()){
            customerEntities.add(new CustomerEntity(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getInt(10)));
        }
        return customerEntities;
    }


}
