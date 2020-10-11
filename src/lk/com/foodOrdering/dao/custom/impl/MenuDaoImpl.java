package lk.com.foodOrdering.dao.custom.impl;

import lk.com.foodOrdering.dao.CrudUtil;
import lk.com.foodOrdering.dao.custom.MenuDAO;
import lk.com.foodOrdering.entity.MenuEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MenuDaoImpl implements MenuDAO {
    @Override
    public boolean add(MenuEntity menuEntity) throws Exception {
        return CrudUtil.execute("INSERT INTO menu VALUES(?,?,?)",menuEntity.getId(),menuEntity.getName(),menuEntity.getPrice());
    }

    @Override
    public boolean update(MenuEntity menuEntity) throws Exception {
        return CrudUtil.execute("UPDATE menu SET menu_name=?,price=? WHERE menu_id=?",menuEntity.getName(),menuEntity.getPrice(),menuEntity.getId());

    }

    @Override
    public ArrayList<MenuEntity> get() throws Exception, ClassNotFoundException {
        ArrayList<MenuEntity> arrayList = new ArrayList<>();
        ResultSet resultSet= CrudUtil.execute("SELECT * FROM menu");
        while (resultSet.next()){
            arrayList.add(new MenuEntity(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)));
        }
        return arrayList;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("DELETE FROM menu WHERE menu_id=?",Integer.parseInt(s));
    }

    @Override
    public ArrayList<MenuEntity> search(String s) throws Exception {
        ArrayList<MenuEntity> arrayList = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM menu WHERE menu_id=?",Integer.parseInt(s));
        while (resultSet.next()){
            arrayList.add(new MenuEntity(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)));
        }
        return arrayList;
    }


}
