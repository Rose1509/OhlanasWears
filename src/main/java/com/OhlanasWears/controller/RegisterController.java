package com.OhlanasWears.controller;

import java.io.IOException;

import com.OhlanasWears.model.CustomerModel;
import com.OhlanasWears.service.RegisterService;
import com.OhlanasWears.util.PasswordUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * LMU ID: 23048677
 * NAME: Rose Khatiwada
 */

/**
 * RegisterController handles user registration requests and processes form
 * submissions for the "Unleash Your Inner Lana" registration page.
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final RegisterService registerService = new RegisterService();
    private RegisterService service;

    public RegisterController() {
        super();
        this.setService(new RegisterService());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CustomerModel customerModel = extractRegisterModel(req);
            System.out.println("Extracted Customer");

            Boolean isAdded = registerService.registerCustomer(customerModel);
            System.out.println("User registered");

            if (isAdded == null) {
                handleError(req, resp, "Our server is under maintenance. Please try again later!");
            } else if (isAdded) {
                handleSuccess(req, resp, "Your account is successfully created!", "/home");
            } else {
                handleError(req, resp, "Could not register your account. Please try again later!");
            }
        } catch (Exception e) {
            handleError(req, resp, "An unexpected error occurred. Please try again later!");
            e.printStackTrace(); // Log the exception
        }
    }

    private CustomerModel extractRegisterModel(HttpServletRequest req) throws Exception {
        System.out.println("Reached here 1");
        String fullName = req.getParameter("Customer_Name");
        String username = req.getParameter("User_Name");
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("Phone_Number");
        System.out.println("Reached here 2");

        String password = req.getParameter("Password");
        String confirmPassword = req.getParameter("confirm-password");

        System.out.println(password);
        System.out.println(confirmPassword);

        if (password == null || !password.equals(confirmPassword)) {
            throw new Exception("Passwords do not match or are invalid.");
        }

        // Encrypt password before storing
        password = PasswordUtil.encrypt(username, password);

        return new CustomerModel(fullName, username, email, phoneNumber, password);
    }

    private void handleSuccess(HttpServletRequest req, HttpServletResponse resp, String message, String redirectPage)
            throws ServletException, IOException {
        req.getSession().setAttribute("success", message); // using session attribute for redirect
        resp.sendRedirect(req.getContextPath() + redirectPage); // redirect to home page
    }

    private void handleError(HttpServletRequest req, HttpServletResponse resp, String message)
            throws ServletException, IOException {
        req.setAttribute("error", message);
        req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
    }

    public RegisterService getService() {
        return service;
    }

    public void setService(RegisterService service) {
        this.service = service;
    }
}
