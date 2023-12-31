package model;

import java.sql.*;

import static dataBase.connectionDB.*;

/**
 * @description this class verify the datas of user for your log in
 */
public class Login {
    /**
     * @param nickname name or document of user
     * @param pass     password of user
     * @return true in case the login is successful.
     */
    public boolean verifyCredentials(String nickname, String pass) {
        boolean loginSuccesfull = false;
        String query = "SELECT * FROM datosUno WHERE (user = ? OR document = ?) AND password = ?";

        // When used, try(), it automatically closes the connection.
        try (Connection connection = getConnectionDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, nickname);
            preparedStatement.setString(2, nickname);
            preparedStatement.setString(3, pass);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                loginSuccesfull = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginSuccesfull;
    }

}
