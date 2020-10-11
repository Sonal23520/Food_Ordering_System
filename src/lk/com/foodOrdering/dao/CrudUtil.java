package lk.com.foodOrdering.dao;

import lk.com.foodOrdering.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {

    public static <T>T execute(String sql,Object...prams) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);

        for (int i = 0; i < prams.length; i++) {
            preparedStatement.setObject((i+1),prams[i]);
        }
        if (sql.startsWith("SELECT")){
            return (T) preparedStatement.executeQuery();
        }
        return ((T)(Boolean) (preparedStatement.executeUpdate()>0));
    }
}
