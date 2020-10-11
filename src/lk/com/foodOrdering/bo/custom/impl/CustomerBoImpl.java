package lk.com.foodOrdering.bo.custom.impl;

import lk.com.foodOrdering.bo.custom.CustomerBO;
import lk.com.foodOrdering.dao.DaoFactory;
import lk.com.foodOrdering.dao.custom.*;
import lk.com.foodOrdering.dto.CustomerDTO;
import lk.com.foodOrdering.entity.CustomerEntity;

import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBO  {
    QueryDAO queryDAO= DaoFactory.getInstance().getDao(DaoFactory.DaoType.QUERY);
    CustomerDAO customerDAO=DaoFactory.getInstance().getDao(DaoFactory.DaoType.CUSTOMER);
    OrderDAO orderDAO=DaoFactory.getInstance().getDao(DaoFactory.DaoType.ORDER);
    OrderDetailDAO orderDetailDAO=DaoFactory.getInstance().getDao(DaoFactory.DaoType.ORDERDETAIL);
    PaymentDAO paymentDAO=DaoFactory.getInstance().getDao(DaoFactory.DaoType.PAYMENT);
    PaymentDetailsDAO paymentDetailsDAO=DaoFactory.getInstance().getDao(DaoFactory.DaoType.PAYMENTDETAIL);


    @Override
    public ArrayList<CustomerDTO> getLoginDetails() throws Exception {
        ArrayList<CustomerDTO> arrayList = new ArrayList<>();
        ArrayList<CustomerEntity> loginDetails = customerDAO.get();

        for (CustomerEntity loginDetail : loginDetails) {
            arrayList.add(new CustomerDTO(loginDetail.getId(),loginDetail.getFname(),loginDetail.getLname(),
                    loginDetail.getEmail(),loginDetail.getPassword(),loginDetail.getPhoneno(),loginDetail.getProvince(),
                    loginDetail.getAddressline1(),loginDetail.getAddressline2(),loginDetail.getPostalcode()));
        }
        return arrayList;

    }

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        return customerDAO.add(new CustomerEntity(customerDTO.getId(),customerDTO.getFname(),customerDTO.getLname(),
                customerDTO.getEmail(),customerDTO.getPassword(),customerDTO.getPhoneno(),customerDTO.getProvince(),
                customerDTO.getAddressline1(),customerDTO.getAddressline2(),customerDTO.getPostalcode()));

    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        return customerDAO.update(new CustomerEntity(customerDTO.getId(),customerDTO.getFname(),customerDTO.getLname(),
                customerDTO.getEmail(),customerDTO.getPassword(),customerDTO.getPhoneno(),customerDTO.getProvince(),
                customerDTO.getAddressline1(),customerDTO.getAddressline2(),customerDTO.getPostalcode()));
    }

    @Override
    public boolean deleteCustomer(String s) throws Exception {
//        if (orderDetailDAO.delete(s)){
//            if (paymentDAO.delete(s)){
//                if (orderDAO.delete(s)){
//                    if (customerDAO.delete(s)) {
//                        return true;
//                    }
//                }
//            }
//        }
        return false;
    }

    @Override
    public ArrayList<CustomerDTO> searchCustomer(String s) throws Exception {
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        ArrayList<CustomerEntity> search = customerDAO.search(s);
        for (CustomerEntity customerEntity : search) {
            customerDTOS.add(new CustomerDTO(customerEntity.getId(),customerEntity.getFname(),customerEntity.getLname(),
                    customerEntity.getEmail(),customerEntity.getPassword(),customerEntity.getPhoneno(),
                    customerEntity.getProvince(),customerEntity.getAddressline1(),customerEntity.getAddressline2(),
                    customerEntity.getPostalcode()));
        }
        return customerDTOS;
    }

    @Override
    public boolean updateCustomerAll(CustomerDTO customerDTO) throws Exception {
        return queryDAO.updateCustomer(new CustomerEntity(customerDTO.getId(),customerDTO.getFname(),
                customerDTO.getLname(),customerDTO.getEmail(),customerDTO.getPassword(),customerDTO.getPhoneno(),
                customerDTO.getProvince(),customerDTO.getAddressline1(),customerDTO.getAddressline2(),
                customerDTO.getPostalcode()));

    }
}
