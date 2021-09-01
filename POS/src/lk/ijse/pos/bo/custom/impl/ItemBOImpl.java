package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.ItemBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dto.ItenDTO;
import lk.ijse.pos.entity.Item;

import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().GetDAO(DAOFactory.DAOType.ITEM);
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
    public ArrayList<ItenDTO> getAllItem() throws Exception {
        return itemDAO.getALL();
    }

}
