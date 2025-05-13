package com.OhlanasWears.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Handles contact form display and processing for Oh-Lana’s Wears.
 *
 * LMU ID: 23048677
 * NAME: Rose Khatiwada
 */
@WebServlet("/contactus")
public class ContactUsController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     * Calls the superclass constructor.
     */
    public ContactUsController() {
        super();
    }

    /**
     * Handles GET requests to load the Contact Us page.
     *
     * @param request  the HttpServletRequest object that contains the request the client made.
     * @param response the HttpServletResponse object that contains the response the servlet returns.
     * @throws ServletException if the request could not be handled.
     * @throws IOException      if an input or output error is detected when the servlet handles the request.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/contactus.jsp").forward(request, response);        
    }

    /**
     * Handles POST requests from the contact form.
     * Captures input data and sets a success message to display on the contact page.
     *
     * @param request  the HttpServletRequest object that contains the form data.
     * @param response the HttpServletResponse object used to return the response.
     * @throws ServletException if the request could not be handled.
     * @throws IOException      if an input or output error is detected when the servlet handles the request.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("full-name");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        request.setAttribute("message", "Message Sent!");
        request.getRequestDispatcher("/WEB-INF/pages/contactus.jsp").forward(request, response);
    }
}
