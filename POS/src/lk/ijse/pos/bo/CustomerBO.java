package lk.ijse.pos.bo;

import lk.ijse.pos.model.Customer;

public interface CustomerBO {

    public boolean addCustomer(Customer customer) throws Exception;



    public boolean UpdateCustomer(Customer customer) throws Exception ;


    public boolean deleteCustomer(String id) throws Exception ;


    public Customer searchCustomer(String id) throws Exception ;


    public String getAllCustomer() throws Exception ;

    }

}
