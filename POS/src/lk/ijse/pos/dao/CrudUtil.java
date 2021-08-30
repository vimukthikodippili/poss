package lk.ijse.pos.dao;

import lk.ijse.pos.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudUtil {
    private static PreparedStatement getPreparedStatement(String sql,Object...data) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement(sql);
        for (int i= 0; i<data.length; i++){
            pstm.setObject(i+1,data[i]);
        }


        return pstm;

    }
    public static ResultSet ExecuteQuery(String sql,Object...data) throws Exception {
return getPreparedStatement(sql,data).executeQuery();
    }
    public static boolean executeUpdate(String sql,Object...data) throws Exception {
       return getPreparedStatement(sql,data).executeUpdate()>0;
    }
}
