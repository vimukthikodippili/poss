package lk.ijse.pos.bo;

import lk.ijse.pos.bo.custom.impl.CustomerBOImpl;
import lk.ijse.pos.bo.custom.impl.ItemBOImpl;
import lk.ijse.pos.bo.custom.impl.PurchaseOrderBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory():boFactory;
    }
    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case CUSTOMER:
                return (SuperBO) new CustomerBOImpl();
            case ITEM:
                return (SuperBO) new ItemBOImpl();
            case ORDER:
                return (SuperBO) new PurchaseOrderBOImpl();
            default:
                return null;
        }
    }

    public enum BOTypes {
        CUSTOMER, ITEM, ORDER
    }
}
