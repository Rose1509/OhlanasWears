package com.OhlanasWears.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.OhlanasWears.config.DbConfig;
import com.OhlanasWears.model.CustomerModel;

/**
 * ProfileService handles business logic related to customer data
 * retrieval and update for the Oh-Lana's Wears system.
 *
 * LMU ID: 23048677
 * NAME: Rose Khatiwada
 */
public class ProfileService {

    private Connection connection;

    /**
     * Constructs a ProfileService object and initializes a database connection using DbConfig.
     */
    public ProfileService() {
        try {
            this.connection = DbConfig.getDbConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Log the exception
        }
    }

    /**
     * Retrieves customer details by username.
     *
     * @param username the username of the customer
     * @return CustomerModel object containing customer details, or null if not found
     */
    public CustomerModel getCustomerByUsername(String username) {
        CustomerModel customer = null;
        String query = "SELECT * FROM customer WHERE User_Name = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                customer = new CustomerModel(
                    rs.getString("Customer_Name"),
                    rs.getString("User_Name"),
                    rs.getString("Email"),
                    rs.getString("Phone_Number"),
                    rs.getString("Password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    /**
     * Updates the profile information of a customer.
     *
     * @param username          the username of the customer whose profile is being updated
     * @param customerName      the new full name of the customer
     * @param email             the new email address
     * @param  phno              the new phone number
     * @param encryptedPassword the new encrypted password (nullable if password is not being updated)
     * @return true if the profile update was successful, false otherwise
     */
    public boolean updateUserProfile(String username, String customerName, String email,
                                     String phno, String encryptedPassword) {

        String query;
        boolean includePassword = encryptedPassword != null && !encryptedPassword.isEmpty();

        if (includePassword) {
            query = "UPDATE customer SET Customer_Name = ?, Email = ?, Phone_Number = ?, Password = ? WHERE User_Name = ?";
        } else {
            query = "UPDATE customer SET Customer_Name = ?, Email = ?, Phone_Number = ? WHERE User_Name = ?";
        }

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, customerName);
            stmt.setString(2, email);
            stmt.setString(3, phno);

            if (includePassword) {
                stmt.setString(4, encryptedPassword);
                stmt.setString(5, username);
            } else {
                stmt.setString(4, username);
            }

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
