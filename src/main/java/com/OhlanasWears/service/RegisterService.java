package com.OhlanasWears.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.OhlanasWears.config.DbConfig;
import com.OhlanasWears.model.CustomerModel;

/**
 * Service class responsible for registering a new customer into the database.
 * Establishes a database connection and inserts customer details into the `customer` table.
 * 
 * LMU ID: 23048677  
 * NAME: Rose Khatiwada
 */
public class RegisterService {

    private Connection connection;

    /**
     * Constructor that initializes the database connection using DbConfig.
     * Logs stack trace if any exception occurs during connection.
     */
    public RegisterService() {
        try {
            this.connection = DbConfig.getDbConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Consider replacing with logging in production
        } catch (SQLException e) {
            e.printStackTrace(); // Consider replacing with logging in production
        }
    }

    /**
     * Registers a new customer by inserting their details into the database.
     * 
     * @param customerModel the model containing customer details
     * @return true if the registration was successful, false if not, or null if DB connection failed
     */
    public Boolean registerCustomer(CustomerModel customerModel) {
        if (this.connection == null) {
            System.out.println("Database did not connect");
            return null;
        }

        String insertQuery = "INSERT INTO customer (Customer_Name, User_Name, Email, Phone_Number, Password) " +
                             "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
            insertStmt.setString(1, customerModel.getCustomerName());
            insertStmt.setString(2, customerModel.getUserName());
            insertStmt.setString(3, customerModel.getEmail());
            insertStmt.setString(4, customerModel.getPhoneNumber());
            insertStmt.setString(5, customerModel.getPassword());

            return insertStmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error during customer registration: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    } 
}
