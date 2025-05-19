package com.OhlanasWears.model;

/**
 * Model class representing a clothing item in the Oh-Lana's Wears inventory.
 */
public class ClothesModel {

    private int code;
    private String clothesName;
    private String color;
    private int stock;
    private double price;
    private String image;

    /**
     * Default constructor.
     */
    public ClothesModel() {
        // Default constructor
    }

    /**
     * Parameterized constructor to create a ClothesModel with all attributes.
     *
     * @param code        the unique code of the clothing item
     * @param clothesName the name of the clothing item
     * @param color       the color of the clothing item
     * @param stock       the available stock quantity
     * @param price       the price of the clothing item
     */
    public ClothesModel(int code, String clothesName, String color, int stock, double price, String image) {
        this.code = code;
        this.clothesName = clothesName;
        this.color = color;
        this.stock = stock;
        this.price = price;
        this.image = image;
    }

    /**
     * @return the name of the clothing item
     */
    public String getClothesName() {
        return clothesName;
    }

    /**
     * @param clothesName the name of the clothing item to set
     */
    public void setClothesName(String clothesName) {
        this.clothesName = clothesName;
    }

    /**
     * @return the color of the clothing item
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color of the clothing item to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the stock quantity of the clothing item
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock quantity to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the price of the clothing item
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price of the clothing item to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the unique code of the clothing item
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the unique code of the clothing item to set
     */
    public void setCode(int code) {
        this.code = code;
    }
    
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}    
}
