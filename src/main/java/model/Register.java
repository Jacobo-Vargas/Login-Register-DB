package model;

import java.sql.*;
import java.time.LocalDate;

import static dataBase.connectionDB.*;

public class Register {

    /**
     *
     * @param document
     * @param user
     * @param password
     * @param mail
     * @param gender
     * @param name
     * @param lastName
     * @return true in case of register is successful
     */

    public boolean registerUser(String document, String user, String password, String mail, Gender gender, String name, String lastName, int age) {

        boolean registerSuccessfull = false;

        String query = "INSERT INTO datosUno (gender,name,lastName,fechaReg,document,user,password,mail,age) VALUES (?, ?, ?, ?, ? ,?, ?, ?, ?)";

        LocalDate dateReg = LocalDate.now();

        try (Connection connection = getConnectionDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, String.valueOf(gender));
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, lastName);
            preparedStatement.setDate(4, Date.valueOf(dateReg));
            preparedStatement.setString(5, document);
            preparedStatement.setString(6, user);
            preparedStatement.setString(7, password);
            preparedStatement.setString(8, mail);
            preparedStatement.setInt(9,age);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                registerSuccessfull = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registerSuccessfull;
    }

    /**
     * @param document type string
     * @return true in case the document is checked in
     */
    public boolean validateUserByDocument(String document) {
        boolean validator = false;
        String query = "SELECT COUNT(document) FROM datosUno WHERE document = ?";
        try (Connection connection = getConnectionDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, document);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    validator = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return validator;
    }

     /**
     * @param user type String
     * @return true in case the document is checked in
     */

    public boolean validateUserByUser(String user) {
        boolean validator = false;
        String query = "SELECT COUNT(user) FROM datos WHERE user = ?";

        try (Connection connection = getConnectionDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, user);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                int count = result.getInt(1);
                if (count > 0) {
                    validator = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return validator;
    }

}