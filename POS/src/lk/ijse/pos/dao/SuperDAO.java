package lk.ijse.pos.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SuperDAO<T,ID> {
boolean add(T Entity) throws Exception;
boolean delete(ID id) throws Exception;
boolean update(T Entity) throws Exception;
T search(ID id)throws Exception;
ArrayList<T> getALL()throws Exception;
}
