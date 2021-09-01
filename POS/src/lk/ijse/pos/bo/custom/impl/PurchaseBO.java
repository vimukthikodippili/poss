package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.entity.OrderDetails;
import lk.ijse.pos.entity.Orders;

import java.util.ArrayList;

public class PurchaseBO {
    public interface PurchaseOrderBO {
        boolean purchaseOrder(Orders order, ArrayList<OrderDetails> orderDetails) throws Exception;
    }
}

