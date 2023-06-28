package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connectionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/login";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    /**
     *
     * @return this method help me to get connection by databases
     * @throws SQLException can obtain this type exception
     */

    public static Connection getConnectionDB() throws SQLException {
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);

    }
}
