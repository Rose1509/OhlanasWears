package com.OhlanasWears.controller;

import jakarta.servlet.ServletException;
import com.OhlanasWears.model.ProfileModel;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * LMU ID: 23048677

 * NAME: Rose Khatiwada
 */

/**
 * Servlet implementation class ProfileController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/profile" })
public class ProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public ProfileController() {
        super();
    }

    /**
     * Handles HTTP GET requests.
     *
     * @param request  The HttpServletRequest object that contains the request the client has made.
     * @param response The HttpServletResponse object that contains the response the servlet sends to the client.
     * @throws ServletException If an error occurs while processing the request.
     * @throws IOException      If an input or output error occurs during the request-response cycle.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Make sure to cast it to ProfileModel instead of profile
        ProfileModel profileModel = (ProfileModel) request.getSession().getAttribute("user");

        if (profileModel != null) {
            // Set profile data as request attributes to be accessed in the JSP
            request.setAttribute("fullName", profileModel.getFullName());
            request.setAttribute("username", profileModel.getUsername());
            request.setAttribute("email", profileModel.getEmail());
            request.setAttribute("phone", profileModel.getPhone());
            request.setAttribute("location", profileModel.getLocation());

            // For security, don't pass the password directly — just show masked or omit
            request.setAttribute("maskedPassword", "********");
        }

        // Forward the request to the profile JSP
        request.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(request, response);
    }

    /**
     * Handles HTTP POST requests.
     *
     * @param request  The HttpServletRequest object that contains the request the client has made.
     * @param response The HttpServletResponse object that contains the response the servlet sends to the client.
     * @throws ServletException If an error occurs while processing the request.
     * @throws IOException      If an input or output error occurs during the request-response cycle.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Call the doGet method to handle POST requests (e.g., updating profile data)
        doGet(request, response);
    }
}
