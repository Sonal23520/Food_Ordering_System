package lk.com.foodOrdering.bo.custom;

import lk.com.foodOrdering.bo.SuperBo;
import lk.com.foodOrdering.dto.MenuDTO;

import java.util.ArrayList;

public interface MenuBO extends SuperBo {
    public ArrayList<MenuDTO> get() throws Exception;
    public ArrayList<MenuDTO>search(String s)throws Exception;
    public boolean add(MenuDTO menuDTO)throws Exception;
    public boolean update(MenuDTO menuDTO)throws Exception;
    public boolean delete(String s)throws Exception;

}
