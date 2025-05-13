package com.OhlanasWears.util;

import java.util.regex.Pattern;

/**
 * LMU ID: 23048677
 * NAME: Rose Khatiwada
 */
public class ValidationUtil {

    /**
     * Validates if a given string is null or empty.
     * 
     * @param value the string to check
     * @return true if the string is null or empty, false otherwise
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Checks if the string contains only alphabetic characters.
     * 
     * @param value the string to validate
     * @return true if the string contains only letters, false otherwise
     */
    public static boolean isAlphabetic(String value) {
        return !isNullOrEmpty(value) && value.matches("^[a-zA-Z]+$");
    }

    /**
     * Checks if the string starts with a letter and contains only letters and digits.
     * 
     * @param value the string to validate
     * @return true if the string is alphanumeric and starts with a letter, false otherwise
     */
    public static boolean isAlphanumericStartingWithLetter(String value) {
        return !isNullOrEmpty(value) && value.matches("^[a-zA-Z][a-zA-Z0-9]*$");
    }


    /**
     * Validates an email string against a basic email regex pattern.
     * 
     * @param email the email string to validate
     * @return true if the email is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return !isNullOrEmpty(email) && Pattern.matches(emailRegex, email);
    }

    /**
     * Validates a phone number to ensure it is 10 digits and starts with "98".
     * 
     * @param phoneNumber the phone number string to validate
     * @return true if valid Nepali phone number, false otherwise
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return !isNullOrEmpty(phoneNumber) && phoneNumber.matches("^98\\d{8}$");
    }

    /**
     * Validates password with at least one uppercase, one digit, one special character, and minimum 8 characters.
     * 
     * @param password the password string to validate
     * @return true if the password meets the criteria, false otherwise
     */
    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return !isNullOrEmpty(password) && password.matches(passwordRegex);
    }

    /**
     * Checks whether the original and confirmation passwords match.
     * 
     * @param password the original password
     * @param confirmPassword the retyped confirmation password
     * @return true if both passwords match, false otherwise
     */
    public static boolean doPasswordsMatch(String password, String confirmPassword) {
        return password != null && password.equals(confirmPassword);
    }

    /**
     * Validates a username: must start with a letter and can contain letters and digits.
     * 
     * @param userName the username to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidUsername(String userName) {
        return userName != null && userName.matches("^[a-zA-Z][a-zA-Z0-9]*$");
    }

    /**
     * Validates a customer name to contain only letters.
     * 
     * @param customerName the customer name to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidCustomerName(String customerName) {
        return customerName != null && customerName.matches("^[a-zA-Z][a-zA-Z]*$");
    }

    /**
     * Validates a clothes name to ensure it starts with a letter/number and can contain spaces, hyphens, and ampersands.
     * 
     * @param clothesName the name of the clothing item to validate
     * @return true if the clothes name is valid, false otherwise
     */
    public static boolean isValidClothesName(String clothesName) {
        if (isNullOrEmpty(clothesName)) return false;
        return Pattern.matches("^[A-Za-z0-9][A-Za-z0-9\\s\\-&]*$", clothesName);
    }

    /**
     * Validates a color name to contain only letters and spaces.
     * 
     * @param color the color string to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidColor(String color) {
        if (isNullOrEmpty(color)) return false;
        return Pattern.matches("^[A-Za-z\\s]+$", color);
    }

    /**
     * Validates a stock quantity to ensure it's a number between 0 and 10000.
     * 
     * @param stockStr the stock value as string
     * @return true if valid stock quantity, false otherwise
     */
    public static boolean isValidStock(String stockStr) {
        if (isNullOrEmpty(stockStr)) return false;
        try {
            int stock = Integer.parseInt(stockStr);
            return stock >= 0 && stock <= 10000;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Validates a price value to ensure it's a number between 0 and 100000.
     * 
     * @param priceStr the price value as string
     * @return true if valid price, false otherwise
     */
    public static boolean isValidPrice(String priceStr) {
        if (isNullOrEmpty(priceStr)) return false;
        try {
            double price = Double.parseDouble(priceStr);
            return price >= 0 && price <= 100000;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
