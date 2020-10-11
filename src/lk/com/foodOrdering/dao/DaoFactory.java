package lk.com.foodOrdering.dao;

import lk.com.foodOrdering.dao.custom.impl.*;

public class DaoFactory {
    private static DaoFactory instance;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    public enum DaoType{
       QUERY,CUSTOMER,MENU,ORDER,ORDERDETAIL,PAYMENT,PAYMENTDETAIL,RESTAURANT
    }
    public <T> T getDao(DaoType type){
        switch (type) {
            case QUERY:
                return (T) new QueryDaoImpl();
            case CUSTOMER:
                return (T) new CustomerDaoImpl();
            case MENU:
                return (T) new MenuDaoImpl();
            case ORDER:
                return (T) new OrderDaoImpl();
            case ORDERDETAIL:
                return (T) new OrderDetailDaoImpl();
            case PAYMENT:
                return (T) new PaymentDaoImpl();
            case PAYMENTDETAIL:
                return (T) new PaymentDetailsDAOImpl();
            case RESTAURANT:
                return (T) new RestaurantDaoImpl();
            default:
                return null;
        }
    }
}