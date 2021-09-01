package lk.ijse.pos.bo.custom;

import lk.ijse.pos.entity.Customer;

import java.util.ArrayList;

public interface CustomerBO {

    public boolean addCustomer(Customer customer) throws Exception;



    public boolean UpdateCustomer(Customer customer) throws Exception ;


    public boolean deleteCustomer(String id) throws Exception ;


    public Customer searchCustomer(String id) throws Exception ;


    public ArrayList<Customer> getAllCustomer() throws Exception ;

    }


