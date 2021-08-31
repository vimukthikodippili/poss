package lk.ijse.pos.bo;

import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.custom.impl.ItemDAOImpl;
import lk.ijse.pos.model.Item;

public class ItemBOImpl implements ItemBO {
    private final ItemDAO itemDAO = new ItemDAOImpl();
    public boolean addItem(Item item) throws Exception {
        return itemDAO.add(item);

    }
    public boolean UpdateItem(Item item) throws Exception {
        return itemDAO.update(item);
    }
    public boolean deleteItem(String id) throws Exception {
        return itemDAO.delete(id);
    }
    public Item searchItem(String id) throws Exception {
        return itemDAO.search(id);
    }
    public String getAllItem() throws Exception {
        return itemDAO.getALL();
    }

}
