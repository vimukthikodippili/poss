package lk.ijse.pos.dao;

import lk.ijse.pos.controller.ManageCustomerFormController;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean addCustomer(Customer customer) throws Exception {
       // ManageCustomerFormController manageCustomerFormController=new ManageCustomerFormController();
    //public boolean addCustomer(Customer customer) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer VALUES (?,?,?,?)");
        pstm.setObject(1, customer.getcID());
      pstm.setObject(2, customer.getName());
        pstm.setObject(3, customer.getAddress());
        pstm.setObject(4, 0);

        return (pstm.executeUpdate() > 0);

    }

    @Override
    public boolean updateCustomer(Customer customer) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
        pstm.setObject(1, customer.getName());
        pstm.setObject(2, customer.getAddress());
        pstm.setObject(3, customer.getcID());
        return (pstm.executeUpdate() > 0);
    }

    @Override
    public boolean deletaCustomer(String id) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
        pstm.setObject(1, id);
       return (pstm.executeUpdate() > 0);
    }

    @Override
    public Customer SearchCustomer(String id) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer where id=?");
        if (rst.next()) {
            return new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"));
        }
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
        //////////////////////////////////////////////////////////////////////////////////////////////
        ArrayList<Customer> alCustomers = new ArrayList<>();
        while (rst.next()) {
            Customer customer = new Customer(rst.getString(1), rst.getString(2), rst.getString(3));
            alCustomers.add(customer);
        }
        return alCustomers;
    }
//    ManageCustomerFormController manageCustomerFormController=new ManageCustomerFormController();
//    public boolean addCustomer(Customer customer) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer VALUES (?,?,?,?)");
//
////        pstm.setObject(1, txtCustomerId.getText());
////        pstm.setObject(2, txtCustomerName.getText());
////        pstm.setObject(3, txtCustomerAddress.getText());
//        pstm.setObject(1, customer.getcID());
//        pstm.setObject(2, customer.getName());
//        pstm.setObject(3, customer.getAddress());
//        pstm.setObject(4, 0);
//
//        return (pstm.executeUpdate() > 0);
//
//    }
//    public boolean updateCustomer(Customer customer) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//
//        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
////        pstm.setObject(1, txtCustomerName.getText());
////        pstm.setObject(2, txtCustomerAddress.getText());
////        pstm.setObject(3, txtCustomerId.getText());
////        pstm.setObject(1, txtCustomerName.getText());
////        pstm.setObject(2, txtCustomerAddress.getText());
////        pstm.setObject(3, txtCustomerId.getText());
//        pstm.setObject(1, customer.getName());
//        pstm.setObject(2, customer.getAddress());
//        pstm.setObject(3, customer.getcID());
//        return (pstm.executeUpdate() > 0);
//
//    }
//    public boolean deletaCustomer(String  id) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
//        pstm.setObject(1, id);
//        return (pstm.executeUpdate() > 0);
//
//    }
//    public Customer SearchCustomer(String id) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Customer where id=?");
//        if (rst.next()) {
//            return new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"));
//        }
//        return null;
//
//
//    }
//    public ArrayList<Customer> getAll() throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
//        //////////////////////////////////////////////////////////////////////////////////////////////
//        ArrayList<Customer> alCustomers = new ArrayList<>();
//        while (rst.next()) {
//            Customer customer = new Customer(rst.getString(1), rst.getString(2), rst.getString(3));
//            alCustomers.add(customer);
//        }
//        return alCustomers;
//    }
}
