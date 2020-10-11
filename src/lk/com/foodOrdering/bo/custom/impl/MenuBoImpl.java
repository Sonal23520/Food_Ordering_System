package lk.com.foodOrdering.bo.custom.impl;

import lk.com.foodOrdering.bo.custom.MenuBO;
import lk.com.foodOrdering.dao.DaoFactory;
import lk.com.foodOrdering.dao.custom.MenuDAO;
import lk.com.foodOrdering.dto.MenuDTO;
import lk.com.foodOrdering.entity.MenuEntity;

import java.util.ArrayList;

public class MenuBoImpl implements MenuBO {
    MenuDAO menuDAO= DaoFactory.getInstance().getDao(DaoFactory.DaoType.MENU);
    @Override
    public ArrayList<MenuDTO> get() throws Exception {
        ArrayList<MenuDTO> arrayList = new ArrayList<>();
        ArrayList<MenuEntity> menuEntities = menuDAO.get();
        for (MenuEntity menuEntity : menuEntities) {
            arrayList.add(new MenuDTO(menuEntity.getId(),menuEntity.getName(),menuEntity.getPrice()));
        }
        return arrayList;
    }

    @Override
    public ArrayList<MenuDTO> search(String s) throws Exception {
        ArrayList<MenuDTO> arrayList = new ArrayList<>();
        ArrayList<MenuEntity> search = menuDAO.search(s);
        for (MenuEntity menuEntity : search) {
            arrayList.add(new MenuDTO(menuEntity.getId(),menuEntity.getName(),menuEntity.getPrice()));
        }
        return arrayList;
    }

    @Override
    public boolean add(MenuDTO menuDTO) throws Exception {
        return menuDAO.add(new MenuEntity(menuDTO.getId(),menuDTO.getName(),menuDTO.getPrice()));
    }

    @Override
    public boolean update(MenuDTO menuDTO) throws Exception {
        return menuDAO.update(new MenuEntity(menuDTO.getId(),menuDTO.getName(),menuDTO.getPrice()));

    }

    @Override
    public boolean delete(String s) throws Exception {
        return menuDAO.delete(s);
    }
}
