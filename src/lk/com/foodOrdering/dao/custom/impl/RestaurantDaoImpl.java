package lk.com.foodOrdering.dao.custom.impl;

import lk.com.foodOrdering.dao.CrudUtil;
import lk.com.foodOrdering.dao.custom.RestaurantDAO;
import lk.com.foodOrdering.entity.RestaurantEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RestaurantDaoImpl implements RestaurantDAO {
    @Override
    public boolean add(RestaurantEntity restaurantEntity) throws Exception {
        return CrudUtil.execute("INSERT INTO restaurant VALUES(?,?,?,?,?)",restaurantEntity.getRestaurant_id(),restaurantEntity.getPassword(),restaurantEntity.getFirst_name(),restaurantEntity.getLast_name(),restaurantEntity.getPost());
    }

    @Override
    public boolean update(RestaurantEntity restaurantEntity) throws Exception {
        return CrudUtil.execute("UPDATE restaurant SET password=?,first_name=?,last_name=?,post=? where restaurant_id=?",restaurantEntity.getPassword(),restaurantEntity.getFirst_name(),restaurantEntity.getLast_name(),restaurantEntity.getPost(),restaurantEntity.getRestaurant_id());
    }

    @Override
    public ArrayList<RestaurantEntity> get() throws Exception, ClassNotFoundException {
        ArrayList<RestaurantEntity> arrayList = new ArrayList<>();
        ResultSet resultSet= CrudUtil.execute("SELECT * from foody.restaurant");
        while (resultSet.next()){
            arrayList.add(new RestaurantEntity(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
        }
        return arrayList;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public ArrayList<RestaurantEntity> search(String s) throws Exception {
        ArrayList<RestaurantEntity> arrayList = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM restaurant WHERE restaurant_id=?",Integer.parseInt(s));
        while (resultSet.next()){
            arrayList.add(new RestaurantEntity(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
        }
        return arrayList;
    }

}
