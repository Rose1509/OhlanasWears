package com.OhlanasWears.controller;

import java.io.IOException;


import com.OhlanasWears.model.CustomerModel;
import com.OhlanasWears.service.RegisterService;
import com.OhlanasWears.util.PasswordUtil;
import com.OhlanasWears.util.ValidationUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Handles user registration requests and processes form submissions
 * for the "Unleash Your Inner Lana" registration page.
 *
 * LMU ID: 23048677
 * NAME: Rose Khatiwada
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final RegisterService registerService = new RegisterService();
    private RegisterService service;

    /**
     * Default constructor initializing the registration service.
     */
    public RegisterController() {
        super();
        this.setService(new RegisterService());
    }

    /**
     * Handles GET requests to display the registration form.
     *
     * @param req  the HttpServletRequest object containing client request data.
     * @param resp the HttpServletResponse object used to send the response.
     * @throws ServletException if servlet-specific error occurs.
     * @throws IOException      if an I/O error occurs during forwarding.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
    }

    /**
     * Handles POST requests for registering a new user.
     *
     * @param req  the HttpServletRequest object containing form data.
     * @param resp the HttpServletResponse object used to send a redirect or forward response.
     * @throws ServletException if servlet-specific error occurs.
     * @throws IOException      if an I/O error occurs.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        	
            String validationMessage = validateRegistrationForm(req);
            if (validationMessage != null) {
                handleError(req, resp, validationMessage);
                return;
            }
            CustomerModel customerModel = extractRegisterModel(req);
            System.out.println("Extracted Customer");

            Boolean isAdded = registerService.registerCustomer(customerModel);
            System.out.println("User registered");
            

            if (isAdded == null) {
                handleError(req, resp, "Our server is under maintenance. Please try again later!");
            } else if (isAdded) {
                handleSuccess(req, resp, "Your account is successfully created!", "/login");
            } else {
                handleError(req, resp, "Could not register your account. Please try again later!");
            }
        } catch (Exception e) {
            handleError(req, resp, "An unexpected error occurred. Please try again later!");
            e.printStackTrace(); // Log the exception
        }
    }
    
    /**
     * Validates the registration form for user input.
     *
     * @param req The HttpServletRequest object that contains the request from the client.
     *            It is used to retrieve the form parameters.
     * @return A validation message if any input is invalid, or null if all validations pass.
     */    
    
    private String validateRegistrationForm(HttpServletRequest req) {
        String fullName = req.getParameter("Customer_Name");
        String username = req.getParameter("User_Name");
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("Phone_Number");
        String password = req.getParameter("Password");
        String confirmPassword = req.getParameter("confirm_password");

        // Check for null or empty fields
        if (ValidationUtil.isNullOrEmpty(fullName))
            return "Full name is required.";
        if (ValidationUtil.isNullOrEmpty(username))
            return "Username is required.";
        if (ValidationUtil.isNullOrEmpty(email))
            return "Email is required.";
        if (ValidationUtil.isNullOrEmpty(phoneNumber))
            return "Phone number is required.";
        if (ValidationUtil.isNullOrEmpty(password))
            return "Password is required.";
        if (ValidationUtil.isNullOrEmpty(confirmPassword))
            return "Please confirm your password.";

        // Validate formats
        if (!ValidationUtil.isAlphanumericStartingWithLetter(username))
            return "Username must start with a letter and contain only letters and numbers.";
        if (!ValidationUtil.isValidEmail(email))
            return "Invalid email format.";
        if (!ValidationUtil.isValidPhoneNumber(phoneNumber))
            return "Phone number must be 10 digits and start with 98.";
        if (!ValidationUtil.isValidPassword(password))
            return "Password must be at least 8 characters long, with 1 uppercase letter, 1 number, and 1 symbol.";
        if (!ValidationUtil.doPasswordsMatch(password, confirmPassword))
            return "Passwords do not match.";

        return null; // All validations passed
    }


    /**
     * Extracts and validates the registration form data and creates a CustomerModel.
     * Encrypts the password before returning the model.
     *
     * @param req the HttpServletRequest containing user-submitted form data.
     * @return a CustomerModel object populated with the form data.
     * @throws Exception if password and confirmation do not match or are invalid.
     */
    private CustomerModel extractRegisterModel(HttpServletRequest req) throws Exception {
        System.out.println("Reached here 1");
        String fullName = req.getParameter("Customer_Name");
        String username = req.getParameter("User_Name");
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("Phone_Number");
        System.out.println("Reached here 2");

        String password = req.getParameter("Password");
        String confirmPassword = req.getParameter("confirm_password");

        System.out.println(password);
        System.out.println(confirmPassword);

        if (password == null || !password.equals(confirmPassword)) {
            throw new Exception("Passwords do not match or are invalid.");
        }

        // Encrypt password before storing
        password = PasswordUtil.encrypt(username, password);

        return new CustomerModel(fullName, username, email, phoneNumber, password);
    }

    /**
     * Handles successful registration by setting a success message and redirecting.
     *
     * @param req          the HttpServletRequest object.
     * @param resp         the HttpServletResponse object.
     * @param message      the success message to display.
     * @param redirectPage the path to redirect the user to.
     * @throws ServletException if servlet-specific error occurs.
     * @throws IOException      if an I/O error occurs.
     */
    private void handleSuccess(HttpServletRequest req, HttpServletResponse resp, String message, String redirectPage)
            throws ServletException, IOException {
        req.getSession().setAttribute("success", message);
        resp.sendRedirect(req.getContextPath() + redirectPage);
    }

    /**
     * Handles registration failure by setting an error message and forwarding back to the form.
     *
     * @param req     the HttpServletRequest object.
     * @param resp    the HttpServletResponse object.
     * @param message the error message to display.
     * @throws ServletException if servlet-specific error occurs.
     * @throws IOException      if an I/O error occurs.
     */
    private void handleError(HttpServletRequest req, HttpServletResponse resp, String message)
            throws ServletException, IOException {
        req.setAttribute("error", message);
        req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
    }

    /**
     * Getter for the RegisterService instance (used for testing or overriding).
     *
     * @return the RegisterService instance.
     */
    public RegisterService getService() {
        return service;
    }

    /**
     * Setter for the RegisterService instance.
     *
     * @param service the RegisterService instance to set.
     */
    public void setService(RegisterService service) {
        this.service = service;
    }
}
