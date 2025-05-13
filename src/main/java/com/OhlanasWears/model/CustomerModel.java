package com.OhlanasWears.model;

/**
 * Represents a customer in the Oh-Lana's Wears system.
 * 
 * <p>LMU ID: 23048677<br>
 * NAME: Rose Khatiwada</p>
 */
public class CustomerModel {

    private String customerName;
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;

    /**
     * Default constructor.
     */
    public CustomerModel() {
    }

    /**
     * Constructor for login functionality.
     *
     * @param userName the username of the customer
     * @param password the password of the customer
     */
    public CustomerModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * Constructor for creating a new customer with all details.
     *
     * @param customerName the full name of the customer
     * @param userName     the username for account login
     * @param email        the email address of the customer
     * @param phoneNumber  the phone number of the customer
     * @param password     the password for account login
     */
    public CustomerModel(String customerName, String userName, String email, String phoneNumber, String password) {
        this.customerName = customerName;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    /**
     * @return the customer's full name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the full name of the customer to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the username of the customer
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the username of the customer to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the email address of the customer
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email address of the customer to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone number of the customer
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phone number of the customer to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the password of the customer
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password of the customer to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
