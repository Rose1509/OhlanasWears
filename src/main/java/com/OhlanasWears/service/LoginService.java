package com.OhlanasWears.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.OhlanasWears.config.DbConfig;
import com.OhlanasWears.model.CustomerModel;
import com.OhlanasWears.util.PasswordUtil;

/**
 * Service class for handling login operations by verifying the 
 * username and password of the customer from the database.
 *
 * LMU ID: 23048677  
 * NAME: Rose Khatiwada
 */
public class LoginService {

    private Connection dbConn;
    private boolean isConnectionError = false;

    /**
     * Constructor that attempts to establish a connection to the database.
     * If the connection fails, a flag is set to indicate a connection error.
     */
    public LoginService() {
        try {
            dbConn = DbConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            isConnectionError = true;
        }
    }

    /**
     * Authenticates the customer by verifying the username and password.
     *
     * @param customerModel A model object containing login credentials.
     * @return true if login is successful, false if credentials are invalid, 
     *         or null if there is a connection or query error.
     */
    public Boolean loginUser(CustomerModel customerModel) {
        if (isConnectionError) {
            System.out.println("Connection Error!");
            return null;
        }

        String query = "SELECT User_Name, Password FROM customer WHERE LOWER(User_Name) = LOWER(?)";

        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setString(1, customerModel.getUserName());
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                return validatePassword(result, customerModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return false;
    }

    /**
     * Decrypts the stored password and compares it with the user input.
     *
     * @param result        ResultSet object containing the stored username and encrypted password.
     * @param customerModel The input model containing the login credentials.
     * @return true if both username and password match, false otherwise.
     * @throws SQLException if there is an error accessing the ResultSet.
     */
    private boolean validatePassword(ResultSet result, CustomerModel customerModel) throws SQLException {
        String dbUsername = result.getString("User_Name");
        String dbPassword = result.getString("Password");

        try {
            String decryptedPassword = PasswordUtil.decrypt(dbPassword, dbUsername);
            return dbUsername.equalsIgnoreCase(customerModel.getUserName()) &&
                   decryptedPassword.equals(customerModel.getPassword());
        } catch (Exception e) {
            System.out.println("Password decryption failed.");
            e.printStackTrace();
            return false;
        }
    }
}
