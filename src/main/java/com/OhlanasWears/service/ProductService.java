package com.OhlanasWears.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.OhlanasWears.config.DbConfig;
import com.OhlanasWears.model.ClothesModel;

/**
 * Service class responsible for managing product-related operations,
 * including adding, retrieving, and deleting clothes from the database.
 * 
 * LMU ID: 23048677  
 * NAME: Rose Khatiwada
 */
public class ProductService {

    private Connection connection;

    /**
     * Constructor that initializes the database connection using DbConfig.
     * Logs connection status to the console.
     */
    public ProductService() {
        try {
            this.connection = DbConfig.getDbConnection();
            if (this.connection != null && !this.connection.isClosed()) {
                System.out.println("Database connection established successfully");
            } else {
                System.out.println("Failed to establish database connection");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a new product (clothes) to the database.
     * 
     * @param clothesModel the model object containing product details
     * @return true if product is successfully added, false if not, or null if DB connection failed
     */
    public Boolean addProduct(ClothesModel clothesModel) {
        if (this.connection == null) {
            System.out.println("Database did not connect");
            return null;
        }

        String insertQuery = "INSERT INTO clothes (ClothesName, Color, Stock, Price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
            insertStmt.setString(1, clothesModel.getClothesName());
            insertStmt.setString(2, clothesModel.getColor());
            insertStmt.setInt(3, clothesModel.getStock());
            insertStmt.setDouble(4, clothesModel.getPrice());

            int rowsAffected = insertStmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Retrieves all clothes/products from the database.
     * 
     * @return a list of ClothesModel objects representing all clothes
     */
    public List<ClothesModel> getAllClothes() {
        List<ClothesModel> clothesList = new ArrayList<>();
        String query = "SELECT * FROM clothes";

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                ClothesModel model = new ClothesModel(
                        rs.getInt("clothes_id"),
                        rs.getString("ClothesName"),
                        rs.getString("Color"),
                        rs.getInt("Stock"),
                        rs.getDouble("Price")
                );
                clothesList.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clothesList;
    }

    /**
     * Deletes a product (clothes) from the database based on its ID.
     * 
     * @param code the ID of the clothes to be deleted
     * @return true if deletion was successful, false otherwise
     */
    public boolean deleteClothesById(int code) {
        String deleteQuery = "DELETE FROM clothes WHERE clothes_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(deleteQuery)) {
            stmt.setInt(1, code);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
