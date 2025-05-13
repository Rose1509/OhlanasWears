package com.OhlanasWears.model;

/**
 * Represents a user profile in the Oh-Lana's Wears system.
 * 
 * <p>LMU ID: 23048677<br>
 * NAME: Rose Khatiwada</p>
 */
public class ProfileModel {

    private String fullName;   // Maps to customerName in CustomerModel
    private String username;   // Maps to userName in CustomerModel
    private String email;
    private String phone;      // Maps to phoneNumber in CustomerModel
    private String location;   // New field for location
    private String password;   // For secure operations

    /**
     * Default constructor.
     */
    public ProfileModel() {
    }

    /**
     * Constructor to initialize profile using a CustomerModel object.
     *
     * @param customer the CustomerModel object containing customer details
     */
    public ProfileModel(CustomerModel customer) {
        this.fullName = customer.getCustomerName();
        this.username = customer.getUserName();
        this.email = customer.getEmail();
        this.phone = customer.getPhoneNumber();
        this.password = customer.getPassword(); // Optional: review if password transfer is secure
    }

    /**
     * Constructor to create a profile with all fields.
     *
     * @param fullName the full name of the user
     * @param username the username of the user
     * @param email    the user's email address
     * @param phone    the user's phone number
     * @param location the user's location
     * @param password the user's password
     */
    public ProfileModel(String fullName, String username, String email, String phone, String location, String password) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.password = password;
    }

    /**
     * @return the full name of the user
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the full name to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the email address of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone number of the user
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone number to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the location of the user
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
