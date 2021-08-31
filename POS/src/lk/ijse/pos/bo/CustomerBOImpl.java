package lk.ijse.pos.bo;

import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.pos.model.Customer;

public class CustomerBOImpl implements CustomerBO {
    private final CustomerDAO customerDAO = new CustomerDAOImpl();
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
public String getAllCustomer() throws Exception {
    return customerDAO.getALL();
}

}
