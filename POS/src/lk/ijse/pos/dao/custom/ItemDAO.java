package lk.ijse.pos.dao.custom;

import lk.ijse.pos.dao.SuperDAO;
import lk.ijse.pos.model.Item;
import lk.ijse.pos.model.OrderDetails;

import java.util.ArrayList;

public interface ItemDAO  extends SuperDAO<Item,String> {
//    public boolean addItem(Item item) throws Exception;
//    public boolean deleteItem(String code) throws Exception;
//    public boolean updateItem(Item item) throws Exception;
//    public Item searchItem(String code) throws Exception;
//    public ArrayList<Item> getAllItems() throws Exception;


    boolean updateItemQtyOnHand(String code, int qtyOnHand) throws Exception;

}
