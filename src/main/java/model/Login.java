package model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static dataBase.connectionDB.*;

public class Login {
    public boolean verifyCredentials(String user, String pass){
       boolean loginSuccesfull = false;
       try {
           String query = "SELECT * FROM datos WHERE user = " + user+ " AND password = "+ pass;
           Connection connection = getConnectionDB();
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(query);

           while (resultSet.next()){
               loginSuccesfull = true;
           }

           resultSet.close();
           statement.close();
           connection.close();
       }catch (SQLException e){
           e.printStackTrace();
       }
       return loginSuccesfull;
    }

}
