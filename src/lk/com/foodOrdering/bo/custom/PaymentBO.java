package lk.com.foodOrdering.bo.custom;

import lk.com.foodOrdering.bo.SuperBo;
import lk.com.foodOrdering.dao.custom.PaymentDetailsDAO;
import lk.com.foodOrdering.dto.PaymentDTO;
import lk.com.foodOrdering.dto.PaymentDetailsDTO;

public interface PaymentBO extends SuperBo {
    public boolean add(PaymentDTO paymentDTO)throws Exception;
    public boolean addWithDetails(PaymentDetailsDTO paymentDetailsDTO)throws Exception;
}
