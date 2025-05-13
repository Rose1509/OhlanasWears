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
     * @param req  HttpServletRequest object that contains the request the client made to the servlet.
     * @param resp HttpServletResponse object that contains the response the servlet returns to the client.
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
     * @param req  HttpServletRequest object that contains the request the client made to the servlet.
     * @param resp HttpServletResponse object that contains the response the servlet returns to the client.
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
     * @param req HttpServletRequest containing form data submitted by the client.
     * @return A validation error message if input is invalid; otherwise, returns null.
     */
    private String validateRegistrationForm(HttpServletRequest req) {
        String fullName = req.getParameter("Customer_Name");
        String username = req.getParameter("User_Name");
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("Phone_Number");
        String password = req.getParameter("Password");
        String confirmPassword = req.getParameter("confirm_password");

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

        return null;
    }

    /**
     * Extracts and processes registration form data to create a CustomerModel.
     *
     * @param req HttpServletRequest containing form data submitted by the client.
     * @return CustomerModel object populated with the validated and encrypted form data.
     * @throws Exception if passwords do not match or are null.
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

        password = PasswordUtil.encrypt(username, password);
        return new CustomerModel(fullName, username, email, phoneNumber, password);
    }

    /**
     * Handles successful registration by setting a success message and redirecting.
     *
     * @param req          HttpServletRequest object for accessing session and context.
     * @param resp         HttpServletResponse object used to redirect.
     * @param message      Success message to be stored in the session.
     * @param redirectPage URL path to which the user should be redirected.
     * @throws ServletException if servlet-specific error occurs.
     * @throws IOException      if an I/O error occurs.
     */
    private void handleSuccess(HttpServletRequest req, HttpServletResponse resp, String message, String redirectPage)
            throws ServletException, IOException {
        req.getSession().setAttribute("success", message);
        resp.sendRedirect(req.getContextPath() + redirectPage);
    }

    /**
     * Handles registration errors by setting an error message and forwarding to the form page.
     *
     * @param req     HttpServletRequest object for storing error attributes.
     * @param resp    HttpServletResponse object for forwarding the request.
     * @param message Error message to be displayed on the registration page.
     * @throws ServletException if servlet-specific error occurs.
     * @throws IOException      if an I/O error occurs.
     */
    private void handleError(HttpServletRequest req, HttpServletResponse resp, String message)
            throws ServletException, IOException {
        req.setAttribute("error", message);
        req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
    }

    /**
     * Getter for the RegisterService instance.
     *
     * @return RegisterService instance used for registration logic.
     */
    public RegisterService getService() {
        return service;
    }

    /**
     * Setter for the RegisterService instance.
     *
     * @param service RegisterService instance to replace the current one (for testing or override).
     */
    public void setService(RegisterService service) {
        this.service = service;
    }
}
