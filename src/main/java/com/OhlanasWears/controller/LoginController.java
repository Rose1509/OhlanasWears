package com.OhlanasWears.controller;

import java.io.IOException;

import com.OhlanasWears.model.CustomerModel;
import com.OhlanasWears.service.LoginService;
import com.OhlanasWears.util.CookiesUtil;
import com.OhlanasWears.util.SessionUtil;
import com.OhlanasWears.util.RedirectionUtil;
import com.OhlanasWears.util.ValidationUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * LMU ID: 23048677
 * NAME: Rose Khatiwada
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ValidationUtil validationUtil;
    private RedirectionUtil redirectionUtil;
    private LoginService loginService;

    
    /**
     * Initializes the servlet with required utilities and services.
     *
     * @throws ServletException if an initialization error occurs.
     */    
    @Override
    public void init() throws ServletException {
    	
        this.validationUtil = new ValidationUtil();
        this.redirectionUtil = new RedirectionUtil();
        this.loginService = new LoginService();
    }

    /**
     * Handles GET requests and forwards users to the login page.
     *
     * @param req  the HttpServletRequest object.
     * @param resp the HttpServletResponse object.
     * @throws ServletException if a servlet error occurs.
     * @throws IOException      if an I/O error occurs.
     */    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(RedirectionUtil.loginUrl).forward(req, resp);
    }
    
    /**
     * Handles POST requests for user login.
     * Validates input, authenticates user, sets session and cookies, and redirects.
     *
     * @param req  the HttpServletRequest containing login credentials.
     * @param resp the HttpServletResponse used for redirection and cookies.
     * @throws ServletException if a servlet error occurs.
     * @throws IOException      if an I/O error occurs.
     */    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (!validationUtil.isNullOrEmpty(username) && !validationUtil.isNullOrEmpty(password)) {
            CustomerModel customerModel = new CustomerModel(username, password);
            Boolean loginStatus = loginService.loginUser(customerModel);

            if (loginStatus != null && loginStatus) {
                SessionUtil.setAttribute(req, "username", username);

                if (username.equalsIgnoreCase("admin")) {
                    CookiesUtil.addCookie(resp, "role", "admin", 5 * 30);   
                    resp.sendRedirect(req.getContextPath() + "/admindashboard?success=true");   //password: rose1509//
                } else {
                    CookiesUtil.addCookie(resp, "role", "customer", 5 * 30);
                    resp.sendRedirect(req.getContextPath() + "/home?success=true");
                }
            } else {
                handleLoginFailure(req, resp, loginStatus);
            }
        } else {
            redirectionUtil.setMsgAndRedirect(req, resp, "error", "Please fill all the fields!", RedirectionUtil.loginUrl);
        }
    }
    
    /**
     * Handles failed login attempts by displaying appropriate error messages.
     *
     * @param req         the HttpServletRequest object.
     * @param resp        the HttpServletResponse object.
     * @param loginStatus the status of login attempt; null if server error.
     * @throws ServletException if a servlet error occurs.
     * @throws IOException      if an I/O error occurs.
     */

    private void handleLoginFailure(HttpServletRequest req, HttpServletResponse resp, Boolean loginStatus)
            throws ServletException, IOException {
        String errorMessage = (loginStatus == null)
                ? "Our server is under maintenance. Please try again later!"
                : "User credential mismatch. Please try again!";
        redirectionUtil.setMsgAndRedirect(req, resp, "error", errorMessage, RedirectionUtil.loginUrl);
    }
}
