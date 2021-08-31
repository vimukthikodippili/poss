package lk.ijse.pos.bo;

import lk.ijse.pos.model.OrderDetails;
import lk.ijse.pos.model.Orders;

import java.util.ArrayList;

public class PurchaseBO {
    public interface PurchaseOrderBO {
        boolean purchaseOrder(Orders order, ArrayList<OrderDetails> orderDetails) throws Exception;
    }
}

