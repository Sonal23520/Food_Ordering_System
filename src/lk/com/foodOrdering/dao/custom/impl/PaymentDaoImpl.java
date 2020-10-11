package lk.com.foodOrdering.dao.custom.impl;

import lk.com.foodOrdering.dao.CrudUtil;
import lk.com.foodOrdering.dao.custom.PaymentDAO;
import lk.com.foodOrdering.entity.PaymentEntity;

import java.util.ArrayList;

public class PaymentDaoImpl implements PaymentDAO {
    @Override
    public boolean add(PaymentEntity paymentEntity) throws Exception {
        return CrudUtil.execute("INSERT INTO payment VALUES(?,?,?,?,?)",paymentEntity.getPayment_id(),paymentEntity.getOrder_id(),paymentEntity.getPayment_type(),paymentEntity.getPayment_status(),paymentEntity.getTime_stamp());
    }

    @Override
    public boolean update(PaymentEntity paymentEntity) throws Exception {
        return false;
    }

    @Override
    public ArrayList<PaymentEntity> get() throws Exception, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("delete foody.payment from foody.payment inner join orders where payment.order_id=orders.order_id and orders.customer_id=?",s);
    }

    @Override
    public ArrayList<PaymentEntity> search(String s) throws Exception {
        return null;
    }
}
