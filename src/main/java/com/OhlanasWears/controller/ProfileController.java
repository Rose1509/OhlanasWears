package com.OhlanasWears.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.OhlanasWears.model.CustomerModel;
import com.OhlanasWears.service.ProfileService;
import com.OhlanasWears.util.PasswordUtil;

/**
 * 
 * LMU ID: 23048677
 * NAME: Rose Khatiwada
 * 
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/profile" })
public class ProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProfileService service;

    /**
     * Constructs a new ProfileController.
     */
    public ProfileController() {
        super();
        this.service = new ProfileService();
    }

    /**
     * Handles HTTP GET requests to display the user profile page.
     *
     * @param request  the {@link HttpServletRequest} object that contains the request the client made to the servlet
     * @param response the {@link HttpServletResponse} object that contains the response the servlet returns to the client
     * @throws ServletException if the request could not be handled
     * @throws IOException      if an input or output error occurs while the servlet is handling the GET request
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            System.out.println("Username from session: " + username);

            CustomerModel customer = service.getCustomerByUsername(username);
            if (customer != null) {
                request.setAttribute("customer", customer);
            } else {
                System.out.println("No customer found for username: " + username);
            }
        } else {
            System.out.println("Session or username attribute is null");
            response.sendRedirect("login.jsp"); // Redirect if not logged in
            return;
        }

        request.getRequestDispatcher("WEB-INF/pages/profile.jsp").forward(request, response);
    }

    /**
     * Handles HTTP POST requests to update user profile data.
     *
     * @param request  the {@link HttpServletRequest} object that contains the request the client made to the servlet
     * @param response the {@link HttpServletResponse} object that contains the response the servlet returns to the client
     * @throws ServletException if the request could not be handled
     * @throws IOException      if an input or output error occurs while the servlet is handling the POST request
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String username = null;
        if (session != null) {
            username = (String) session.getAttribute("username");
        }
        if (username == null) {
            request.setAttribute("error", "User not logged in.");
            doGet(request, response);
            return;
        }

        String customerName = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phone");  
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        String encryptedPassword = null;
        boolean updatePassword = false;

        if (newPassword != null && !newPassword.isEmpty()) {
            if (newPassword.equals(confirmPassword)) {
                encryptedPassword = PasswordUtil.encrypt(username, newPassword);
                updatePassword = true;
            } else {
                request.setAttribute("error", "New password and confirm password do not match.");
                doGet(request, response);
                return;
            }
        }

        System.out.println("Updating profile for user: " + username);
        System.out.println("Name: " + customerName + ", Email: " + email + ", Phone: " + phoneNumber + ", Update password: " + updatePassword);

        boolean success = service.updateUserProfile(
            username,
            customerName,
            email,
            phoneNumber,
            updatePassword ? encryptedPassword : null
        );

        if (success) {
            request.setAttribute("message", "Profile updated successfully.");
        } else {
            request.setAttribute("error", "Failed to update profile.");
        }

        doGet(request, response);
    }
}
