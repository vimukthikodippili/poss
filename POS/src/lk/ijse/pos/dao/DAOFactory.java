package lk.ijse.pos.dao;

import lk.ijse.pos.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.pos.dao.custom.impl.ItemDAOImpl;
import lk.ijse.pos.dao.custom.impl.OrderDAOImpl;
import lk.ijse.pos.dao.custom.impl.QueryDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public SuperDAO GetDAO(DAOType type) {
        switch (type) {
            case CUSTOMER:
                return (SuperDAO) new CustomerDAOImpl();
            case ITEM:
                return (SuperDAO) new ItemDAOImpl();
            case ORDER:
                return (SuperDAO) new OrderDAOImpl();
            case QUERY:
                return (SuperDAO) new QueryDAOImpl();
            case ORDERDETAILS:
                return (SuperDAO) new OrderDAOImpl();

default:
    return null;
    }
}
public enum DAOType{
    CUSTOMER, ITEM, ORDER, ORDERDETAILS, QUERY

}
}
