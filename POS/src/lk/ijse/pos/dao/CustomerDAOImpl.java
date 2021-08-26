package lk.ijse.pos.dao;

import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerDAOImpl {
    public boolean addCustomer() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer VALUES (?,?,?,?)");

        pstm.setObject(1, txtCustomerId.getText());
        pstm.setObject(2, txtCustomerName.getText());
        pstm.setObject(3, txtCustomerAddress.getText());
        pstm.setObject(4, 0);
        return

    }
    public boolean updateCustomer() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
        pstm.setObject(1, txtCustomerName.getText());
        pstm.setObject(2, txtCustomerAddress.getText());
        pstm.setObject(3, txtCustomerId.getText());

    }
    public boolean deletaCustomer() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
        pstm.setObject(1, customerID);

    }
    public Customer SearchCustomer() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer where id=?");

    }
    public Customer getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
    }
}
