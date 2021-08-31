package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.model.Item;

import java.sql.ResultSet;
import java.util.ArrayList;
public class ItemDAOImpl  implements ItemDAO {
//    @Override
//    public boolean addItem(Item item) throws Exception {
////        Connection connection = DBConnection.getInstance().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item VALUES (?,?,?,?)");
////        pstm.setObject(1, item.getCode());
////        pstm.setObject(2, item.getDescription());
////        pstm.setObject(3, item.getUnitPrice());
////        pstm.setObject(4, item.getQtyOnHand());
//        return CrudUtil.executeUpdate("INSERT INTO Item VALUES (?,?,?,?)",item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());
//    }
//
//    @Override
//    public boolean deleteItem(String code) throws Exception {
////        Connection connection = DBConnection.getInstance().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
////        pstm.setObject(1, code);
////        return (pstm.executeUpdate() > 0);
//    return     CrudUtil.executeUpdate("DELETE FROM Item WHERE code=?",code);
//    }
//
//
//    @Override
//    public boolean updateItem(Item item) throws Exception {
////        Connection connection = DBConnection.getInstance().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
////        pstm.setObject(1, item.getDescription());
////        pstm.setObject(2, item.getUnitPrice());
////        pstm.setObject(3, item.getQtyOnHand());
////        pstm.setObject(4, item.getCode());
////        return (pstm.executeUpdate() > 0);
//        return CrudUtil.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",item.getDescription(),item.getUnitPrice(),item.getQtyOnHand(),item.getCode());
//    }
//
//    @Override
//    public Item searchItem(String code) throws Exception {
////        Connection connection = DBConnection.getInstance().getConnection();
////        PreparedStatement stm = connection.prepareStatement("SELECT * FROM Item where code=?");
////        stm.setObject(1, code);
////        ResultSet rst = stm.executeQuery();
//        ResultSet rst = CrudUtil.ExecuteQuery("SELECT * FROM Item where code=?", code);
//        if (rst.next()) {
//            return new Item(rst.getString(1),
//                    rst.getString(2),
//                    rst.getBigDecimal(3),
//                    rst.getInt(4));
//        }
//        return null;
//    }
//
//    @Override
//    public ArrayList<Item> getAllItems() throws Exception {
////        Connection connection = DBConnection.getInstance().getConnection();
////        Statement stm = connection.createStatement();
////        ResultSet rst = stm.executeQuery("SELECT * FROM Item");
//        ResultSet rst = CrudUtil.ExecuteQuery("SELECT * FROM Item");
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

    @Override
    public boolean add(Item item) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Item VALUES (?,?,?,?)", item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand());

    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM Item WHERE code=?", id);
    }

    @Override
    public boolean update(Item item) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", item.getDescription(), item.getUnitPrice(), item.getQtyOnHand(), item.getCode());
    }

    @Override
    public Item search(String id) throws Exception {
        ResultSet rst = CrudUtil.ExecuteQuery("SELECT * FROM Item where code=?", id);
        if (rst.next()) {
            return new Item(rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getInt(4));
        }
        return null;
    }

    @Override
    public String getALL() throws Exception {
        ResultSet rst = CrudUtil.ExecuteQuery("SELECT * FROM Item");
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

    @Override
    public boolean updateItemQtyOnHand(String code, int qtyOnHand) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Item SET qtyOnHand=? WHERE code=?", qtyOnHand, code);
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