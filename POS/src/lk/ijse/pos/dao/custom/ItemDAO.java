package lk.ijse.pos.dao.custom;

import lk.ijse.pos.dao.CrudDAO;
import lk.ijse.pos.entity.Item;

public interface ItemDAO  extends CrudDAO<Item,String> {
//    public boolean addItem(Item item) throws Exception;
//    public boolean deleteItem(String code) throws Exception;
//    public boolean updateItem(Item item) throws Exception;
//    public Item searchItem(String code) throws Exception;
//    public ArrayList<Item> getAllItems() throws Exception;


    boolean updateItemQtyOnHand(String code, int qtyOnHand) throws Exception;

}
