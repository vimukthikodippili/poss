package lk.ijse.pos.dao;

import lk.ijse.pos.controller.ManageCustomerFormController;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Customer;
import lk.ijse.pos.model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class ItemDAOImpl  implements ItemDAO{
    @Override
    public boolean addItem(Item item) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item VALUES (?,?,?,?)");
        pstm.setObject(1, item.getCode());
        pstm.setObject(2, item.getDescription());
        pstm.setObject(3, item.getUnitPrice());
        pstm.setObject(4, item.getQtyOnHand());
        return (pstm.executeUpdate() > 0);
    }

    @Override
    public boolean deleteItem(String code) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
        pstm.setObject(1, code);
        return (pstm.executeUpdate() > 0);
    }

    @Override
    public boolean updateItem(Item item) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
        pstm.setObject(1, item.getDescription());
        pstm.setObject(2, item.getUnitPrice());
        pstm.setObject(3, item.getQtyOnHand());
        pstm.setObject(4, item.getCode());
        return (pstm.executeUpdate() > 0);
    }

    @Override
    public Item searchItem(String code) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM Item where code=?");
        stm.setObject(1, code);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            return new Item(rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getInt(4));
        }
        return null;
    }

    @Override
    public ArrayList<Item> getAllItems() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Item");
        ArrayList<Item> allItems = new ArrayList<>();
        while (rst.next()) {
            Item item = new Item(rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getInt(4));
            allItems.add(item);
        }
        return allItems;
    }

    //public boolean addItem(Item item) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item VALUES (?,?,?,?)");
//        pstm.setObject(1, item.getCode());
//        pstm.setObject(2, item.getDescription());
//        pstm.setObject(3, item.getUnitPrice());
//        pstm.setObject(4, item.getQtyOnHand());
//        return (pstm.executeUpdate() > 0);
//    }
//
//    public boolean deleteItem(String code) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
//        pstm.setObject(1, code);
//        return (pstm.executeUpdate() > 0);
//    }
//
//
//    public boolean updateItem(Item item) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
//        pstm.setObject(1, item.getDescription());
//        pstm.setObject(2, item.getUnitPrice());
//        pstm.setObject(3, item.getQtyOnHand());
//        pstm.setObject(4, item.getCode());
//        return (pstm.executeUpdate() > 0);
//    }
//    public boolean updateItemQnty(Item  D,int U) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET qtyOnHand=? WHERE code=?");
//        pstm.setObject(1, D);
//        pstm.setObject(2, U);
//
//        return (pstm.executeUpdate() > 0);
//
//    }
//
//
//    public Item searchItem(String code) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        PreparedStatement stm = connection.prepareStatement("SELECT * FROM Item where code=?");
//        stm.setObject(1, code);
//        ResultSet rst = stm.executeQuery();
//        if (rst.next()) {
//            return new Item(rst.getString(1),
//                    rst.getString(2),
//                    rst.getBigDecimal(3),
//                    rst.getInt(4));
//        }
//        return null;
//    }
//
//    public ArrayList<Item> getAllItems() throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Item");
//        ArrayList<Item> allItems = new ArrayList<>();
//        while (rst.next()) {
//            Item item = new Item(rst.getString(1),
//                    rst.getString(2),
//                    rst.getBigDecimal(3),
//                    rst.getInt(4));
//            allItems.add(item);
//        }
//        return allItems;
//    }
//
//    public boolean updateItemQnty(Item item) {
//        throw new UnsupportedOperationException("This feature is not supported yet");
//    }
}