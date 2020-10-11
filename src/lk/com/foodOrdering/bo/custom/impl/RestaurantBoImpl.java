package lk.com.foodOrdering.bo.custom.impl;

import lk.com.foodOrdering.bo.custom.RestaurantBO;
import lk.com.foodOrdering.dao.DaoFactory;
import lk.com.foodOrdering.dao.custom.QueryDAO;
import lk.com.foodOrdering.dao.custom.RestaurantDAO;
import lk.com.foodOrdering.dto.DeliverOrderDTO;
import lk.com.foodOrdering.dto.RestaurantDTO;
import lk.com.foodOrdering.entity.DeliverOrderEntity;
import lk.com.foodOrdering.entity.RestaurantEntity;

import java.util.ArrayList;

public class RestaurantBoImpl implements RestaurantBO {
    QueryDAO queryDAO = DaoFactory.getInstance().getDao(DaoFactory.DaoType.QUERY);
    RestaurantDAO restaurantDAO = DaoFactory.getInstance().getDao(DaoFactory.DaoType.RESTAURANT);
    @Override
    public ArrayList<DeliverOrderDTO> getDeliverOrder() throws Exception {
        ArrayList<DeliverOrderDTO> arrayList = new ArrayList<>();
        ArrayList<DeliverOrderEntity> deliverOrder = queryDAO.getDeliverOrder();
        for (DeliverOrderEntity deliverOrderEntity : deliverOrder) {
            arrayList.add(new DeliverOrderDTO(deliverOrderEntity.getOrder_id(),deliverOrderEntity.getCustomer_id(),deliverOrderEntity.getFirst_name(),deliverOrderEntity.getLast_name(),deliverOrderEntity.getPhone_no(),deliverOrderEntity.getProvince(),deliverOrderEntity.getOrder_status()));
        }
        return arrayList;
    }

    @Override
    public boolean changeOrderStatus(String text,int ID) throws Exception {
        return queryDAO.changeOrderStatus(text, ID);
    }

    @Override
    public ArrayList<RestaurantDTO> getAll() throws Exception {
        ArrayList<RestaurantDTO> arrayList = new ArrayList<>();
        ArrayList<RestaurantEntity> restaurantEntities = restaurantDAO.get();
        for (RestaurantEntity restaurantEntity : restaurantEntities) {
            arrayList.add(new RestaurantDTO(restaurantEntity.getRestaurant_id(),restaurantEntity.getPassword(),restaurantEntity.getFirst_name(),restaurantEntity.getLast_name(),restaurantEntity.getPost()));
        }
        return arrayList;
    }

    @Override
    public ArrayList<RestaurantDTO> search(String s) throws Exception {
        ArrayList<RestaurantDTO> arrayList = new ArrayList<>();
        ArrayList<RestaurantEntity> restaurantEntities = restaurantDAO.search(s);
        for (RestaurantEntity restaurantEntity : restaurantEntities) {
            arrayList.add(new RestaurantDTO(restaurantEntity.getRestaurant_id(),restaurantEntity.getPassword(),restaurantEntity.getFirst_name(),restaurantEntity.getLast_name(),restaurantEntity.getPost()));
        }
        return arrayList;
    }

    @Override
    public boolean add(RestaurantDTO restaurantDTO) throws Exception {
        return restaurantDAO.add(new RestaurantEntity(restaurantDTO.getRestaurant_id(),restaurantDTO.getPassword(),restaurantDTO.getFirst_name(),restaurantDTO.getLast_name(),restaurantDTO.getPost()));
    }

    @Override
    public boolean update(RestaurantDTO restaurantDTO) throws Exception {
        return restaurantDAO.update(new RestaurantEntity(restaurantDTO.getRestaurant_id(),restaurantDTO.getPassword(),restaurantDTO.getFirst_name(),restaurantDTO.getLast_name(),restaurantDTO.getPost()));

    }


}
