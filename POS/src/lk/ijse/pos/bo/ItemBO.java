package lk.ijse.pos.bo;

import lk.ijse.pos.model.Item;

public interface ItemBO {
    public boolean addItem(Item item) throws Exception ;


    public boolean UpdateItem(Item item) throws Exception ;

    public boolean deleteItem(String id) throws Exception ;


    public Item searchItem(String id) throws Exception ;


    public String getAllItem() throws Exception


}
