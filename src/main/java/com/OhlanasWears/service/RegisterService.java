package com.OhlanasWears.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.OhlanasWears.config.DbConfig;
import com.OhlanasWears.model.CustomerModel;

public class RegisterService {

    private Connection connection;

    public RegisterService() {
        try {
            this.connection = DbConfig.getDbConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Consider logging instead
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging instead
        }
    }

    public Boolean registerCustomer(CustomerModel customerModel) {
        if (this.connection == null) {
            System.out.println("Database did not connect");
            return null;
        }

        String insertQuery = "INSERT INTO customer (Customer_Name, User_Name, Email, Phone_Number, Password) " + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {

            // Insert customer details
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
