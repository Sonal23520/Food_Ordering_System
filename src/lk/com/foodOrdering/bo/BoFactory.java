package lk.com.foodOrdering.bo;

import lk.com.foodOrdering.bo.custom.impl.*;

public class BoFactory {

    private static BoFactory boFactoryInstance;

    private BoFactory() {
    }

    public static BoFactory getInstance() {
        if (boFactoryInstance == null) {
            boFactoryInstance = new BoFactory();
        }
        return boFactoryInstance;
    }

    public enum BoType{
        CUSTOMER,Menu,ORDER,PAYMENT,ORDERSTATUS,RESTAURANT,ORDERDETAIL
    }
    public <T> T getBO(BoType boType){
        switch (boType) {
            case CUSTOMER:
                return (T) new CustomerBoImpl();
            case Menu:
                return (T) new MenuBoImpl();
            case ORDER:
                return (T) new OrderBoImpl();
            case PAYMENT:
                return (T) new PaymentBoImpl();
            case ORDERSTATUS:
                return (T) new OrderStatusBoImpl();
            case RESTAURANT:
                return (T) new RestaurantBoImpl();
            case ORDERDETAIL:
                return (T) new OrderDetailBoImpl();
            default:
                return null;
        }
    }

}
