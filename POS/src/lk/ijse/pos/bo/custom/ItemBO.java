package lk.ijse.pos.bo.custom;

import lk.ijse.pos.dto.ItenDTO;
import lk.ijse.pos.entity.Item;

import java.util.ArrayList;

public interface ItemBO {
    public boolean addItem(Item item) throws Exception ;


    public boolean UpdateItem(Item item) throws Exception ;

    public boolean deleteItem(String id) throws Exception ;


    public Item searchItem(String id) throws Exception ;


    public ArrayList<ItenDTO> getAllItem() throws Exception;


}
