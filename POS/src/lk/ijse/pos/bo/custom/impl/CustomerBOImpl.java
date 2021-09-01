package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.CustomerBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.entity.Customer;

import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().GetDAO(DAOFactory.DAOType.CUSTOMER);
    @Override
public boolean addCustomer(Customer customer) throws Exception {
   return customerDAO.add(customer);

}
    @Override
public boolean UpdateCustomer(Customer customer) throws Exception {
    return customerDAO.update(customer);
}
    @Override
public boolean deleteCustomer(String id) throws Exception {
    return customerDAO.delete(id);
}
    @Override
public Customer searchCustomer(String id) throws Exception {
return customerDAO.search(id);
}
    @Override
public ArrayList<Customer> getAllCustomer() throws Exception {
    return customerDAO.getALL();
}

}
