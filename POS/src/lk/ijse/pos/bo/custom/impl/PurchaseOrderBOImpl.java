package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.controller.OrderFormController;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.dao.custom.OrderDetailDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.entity.OrderDetails;
import lk.ijse.pos.entity.Orders;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PurchaseOrderBOImpl implements PurchaseBO.PurchaseOrderBO {

    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().GetDAO(DAOFactory.DAOType.ITEM);
    private final OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().GetDAO(DAOFactory.DAOType.ORDER);
    private final OrderDetailDAO orderDetailsDAO = (OrderDetailDAO) DAOFactory.getDaoFactory().GetDAO(DAOFactory.DAOType.ORDERDETAILS);

    @Override
    public boolean purchaseOrder(Orders orders, ArrayList<OrderDetails> orderDetails) throws Exception {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            boolean b1 = orderDAO.add(orders);
            if (!b1) {
                connection.rollback();
                return false;

            }
            for (OrderDetails orderdetails : orderDetails) {
                boolean b2 = orderDetails.add(orderdetails);
                if (!b2) {
                    connection.rollback();
                    return false;
                }


            }
            int qtyOnHand = 0;
            Item item = itemDAO.search(orders.getId());
            if (item != null) {
                qtyOnHand = item.getQtyOnHand();
            }
            boolean b = itemDAO.updateItemQtyOnHand(orders.getId(), qtyOnHand - item.getQtyOnHand());

            if (!b) {
                connection.rollback();
                return false;
            }
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(OrderFormController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(OrderFormController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(OrderFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
    }

}
