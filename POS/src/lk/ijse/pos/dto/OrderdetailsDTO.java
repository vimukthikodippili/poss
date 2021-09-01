package lk.ijse.pos.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class OrderdetailsDTO {
    private String orderId;
    private String itemCode;
    private int qty;
    private BigDecimal unitPrice;

    public OrderdetailsDTO(String text, Date date, String selectedItem) {
    }

    public OrderdetailsDTO(String orderId, String itemCode, int qty, BigDecimal unitPrice) {
        this.orderId = orderId;
        this.itemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(ArrayList<OrderdetailsDTO> itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
