package lk.com.foodOrdering.dao;

import java.util.ArrayList;

public interface CrudDAO<T,ID> extends SuperDAO {
    public boolean add(T t)throws Exception;
    public boolean update(T t)throws Exception;
    public ArrayList<T> get()throws Exception,ClassNotFoundException;
    public boolean delete(ID id)throws Exception;
    public ArrayList<T> search(ID id)throws Exception;
}
