package lk.com.foodOrdering.dao.custom.impl;

import lk.com.foodOrdering.dao.CrudUtil;
import lk.com.foodOrdering.dao.custom.PaymentDetailsDAO;
import lk.com.foodOrdering.entity.PaymentDetailsEntity;

import java.util.ArrayList;

public class PaymentDetailsDAOImpl implements PaymentDetailsDAO {
    @Override
    public boolean add(PaymentDetailsEntity paymentDetailsEntity) throws Exception {
        return CrudUtil.execute("INSERT INTO payment_details VALUES(?,?,?,?,?,?,?,?)",paymentDetailsEntity.getPayment_id(),paymentDetailsEntity.getCustomer_id(),paymentDetailsEntity.getCard_number(),paymentDetailsEntity.getCard_holder_name(),paymentDetailsEntity.getCvv(),paymentDetailsEntity.getExp_month(),paymentDetailsEntity.getExp_year(),paymentDetailsEntity.getTime_stamp());
    }

    @Override
    public boolean update(PaymentDetailsEntity paymentDetailsEntity) throws Exception {
        return false;
    }

    @Override
    public ArrayList<PaymentDetailsEntity> get() throws Exception, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("delete from payment_details where customer_id=?",s);
    }

    @Override
    public ArrayList<PaymentDetailsEntity> search(String s) throws Exception {
        return null;
    }
}
