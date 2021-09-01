package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.entity.Orders;

import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
//    @Override
//    public boolean addOrder(Orders orders) throws Exception {
////        Connection connection = DBConnection.getInstance().getConnection();
////        String sql = "INSERT INTO Orders VALUES (?,?,?)";
////        PreparedStatement pstm = connection.prepareStatement(sql);
////        pstm.setObject(1, orders.getId());
////        pstm.setObject(2, orders.getDate());
////        pstm.setObject(3, orders.getCustomerId());
////        return (pstm.executeUpdate() > 0);
//    return     CrudUtil.executeUpdate("INSERT INTO Orders VALUES (?,?,?)",orders.getId(),orders.getDate(),orders.getCustomerId());
//    }
//
//    @Override
//    public boolean deleteOrder() {
//        return false;
//    }
//
//    @Override
//    public boolean updateOrder() {
//        return false;
//    }
//
//    @Override
//    public Orders searchOrder() {
//        return null;
//    }
//
//    @Override
//    public ArrayList<Orders> getAllOrders() {
//        return null;
//    }

    @Override
    public boolean add(Orders orders) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Orders VALUES (?,?,?)", orders.getId(), orders.getDate(), orders.getCustomerId());

    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Orders Entity) throws Exception {
        return false;
    }

    @Override
    public Orders search(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Customer> getALL() throws Exception {
        return null;
    }
//    public boolean addOrder(Orders orders) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "INSERT INTO Orders VALUES (?,?,?)";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, orders.getId());
//        pstm.setObject(2, orders.getDate());
//        pstm.setObject(3, orders.getCustomerId());
//        return (pstm.executeUpdate() > 0);
//    }
//
//    public boolean deleteOrder() {
//        throw new UnsupportedOperationException("This feature is not supported yet");
//    }
//
//    public boolean updateOrder() {
//        throw new UnsupportedOperationException("This feature is not supported yet");
//    }
//
//    public Orders searchOrder() {
//        throw new UnsupportedOperationException("This feature is not supported yet");
//    }
//
//    public ArrayList<Orders> getAllOrders() {
//        throw new UnsupportedOperationException("This feature is not supported yet");
//    }


}
