package lk.ijse.pos.dao;

import lk.ijse.pos.entity.Customer;

import java.util.ArrayList;

public interface CrudDAO<T,ID> {
     boolean add(T Entity) throws Exception;
    boolean delete(ID id) throws Exception;
    boolean update(T Entity) throws Exception;
    T search(ID id)throws Exception;
    ArrayList<Customer> getALL()throws Exception;
}
