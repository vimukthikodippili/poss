package lk.ijse.pos.dao;

public interface SuperDAO<T,ID> {
boolean add(T Entity) throws Exception;
boolean delete(ID id) throws Exception;
boolean update(T Entity) throws Exception;
T search(ID id)throws Exception;
String getALL()throws Exception;
}
