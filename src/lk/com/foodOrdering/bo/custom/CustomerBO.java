package lk.com.foodOrdering.bo.custom;

import lk.com.foodOrdering.bo.SuperBo;
import lk.com.foodOrdering.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerBO extends SuperBo {
    public ArrayList<CustomerDTO> getLoginDetails()throws Exception;
    public boolean addCustomer(CustomerDTO customerDTO)throws Exception;
    public boolean updateCustomer(CustomerDTO customerDTO)throws Exception;
    public boolean deleteCustomer(String s)throws Exception;
    public ArrayList<CustomerDTO> searchCustomer(String s)throws Exception;
    public boolean updateCustomerAll(CustomerDTO customerDTO)throws Exception;
}
