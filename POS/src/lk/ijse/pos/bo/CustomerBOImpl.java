package lk.ijse.pos.bo;

import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.pos.model.Customer;

import java.util.ArrayList;

public class CustomerBOImpl {
    private final CustomerDAO customerDAO = new CustomerDAOImpl();
public boolean addCustomer(Customer customer) throws Exception {
   return customerDAO.add(customer);

}
public boolean UpdateCustomer(Customer customer) throws Exception {
    return customerDAO.update(customer);
}
public boolean deleteCustomer(String id) throws Exception {
    return customerDAO.delete(id);
}
public Customer searchCustomer(String id) throws Exception {
return customerDAO.search(id);
}
public ArrayList<Customer> getAllCustomer() throws Exception {
    return customerDAO.getALL();
}

}
