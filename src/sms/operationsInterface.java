package sms;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface operationsInterface {
    ResultSet getData(String query) throws SQLException;
    void insertData(String query) throws SQLException;
}
