package lk.com.foodOrdering.bo.custom.impl;

import lk.com.foodOrdering.bo.custom.PaymentBO;
import lk.com.foodOrdering.dao.DaoFactory;
import lk.com.foodOrdering.dao.custom.PaymentDAO;
import lk.com.foodOrdering.dao.custom.PaymentDetailsDAO;
import lk.com.foodOrdering.dao.custom.QueryDAO;
import lk.com.foodOrdering.db.DBConnection;
import lk.com.foodOrdering.dto.PaymentDTO;
import lk.com.foodOrdering.dto.PaymentDetailsDTO;
import lk.com.foodOrdering.entity.PaymentDetailsEntity;
import lk.com.foodOrdering.entity.PaymentEntity;

import java.sql.Connection;

public class PaymentBoImpl implements PaymentBO {
    PaymentDAO paymentDAO= DaoFactory.getInstance().getDao(DaoFactory.DaoType.PAYMENT);
    QueryDAO queryDAO = DaoFactory.getInstance().getDao(DaoFactory.DaoType.QUERY);
    PaymentDetailsDAO paymentDetailsDAO = DaoFactory.getInstance().getDao(DaoFactory.DaoType.PAYMENTDETAIL);

    @Override
    public boolean add(PaymentDTO paymentDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            if (paymentDAO.add(new PaymentEntity(paymentDTO.getPayment_id(),queryDAO.genarateOrderID(),paymentDTO.getPayment_type(),paymentDTO.getPayment_status(),paymentDTO.getTime_stamp()))){
                if (queryDAO.changeOrderStatus("CONFIRMED", queryDAO.genarateOrderID())){
                    connection.commit();
                    return true;
                }
            }
            connection.rollback();
            return false;
        }finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public boolean addWithDetails(PaymentDetailsDTO paymentDetailsDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            if (paymentDAO.add(new PaymentEntity(paymentDetailsDTO.getPayment_id(),queryDAO.genarateOrderID(),paymentDetailsDTO.getPayment_type(),paymentDetailsDTO.getPayment_status(),paymentDetailsDTO.getTime_stamp()))){
                if(paymentDetailsDAO.add(new PaymentDetailsEntity(queryDAO.paymentID(),paymentDetailsDTO.getCustomer_id(),paymentDetailsDTO.getCard_number(),paymentDetailsDTO.getCard_holder_name(),paymentDetailsDTO.getCvv(),paymentDetailsDTO.getExp_month(),paymentDetailsDTO.getExp_year(),paymentDetailsDTO.getTime_stamp()))){
                    if (queryDAO.changeOrderStatus("PAYMENT_CONFIRMED", queryDAO.genarateOrderID())){
                        connection.commit();
                        return true;
                    }
                }
            }
            connection.rollback();
            return false;
        }finally {
            connection.setAutoCommit(true);
        }
    }



}
