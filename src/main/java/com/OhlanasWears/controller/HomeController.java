package com.OhlanasWears.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controller to handle requests for the Home page of Oh-Lana’s Wears website.
 *
 * 
 * LMU ID: 23048677
 * NAME: Rose Khatiwada
 * 
 */
@WebServlet(
    asyncSupported = true, 
    urlPatterns = { 
        "/home", 
        "/index"
    })
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new HomeController servlet.
     */
    public HomeController() {
        super();
    }

    /**
     * Handles HTTP GET requests to show the home page.
     *
     * @param request  the {@link HttpServletRequest} object that contains the request the client made to the servlet
     * @param response the {@link HttpServletResponse} object that contains the response the servlet returns to the client
     * @throws ServletException if the request could not be handled
     * @throws IOException      if an input or output error occurs while the servlet is handling the GET request
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to the home.jsp page
        request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
    }

    /**
     * Handles HTTP POST requests. Forwards to {@code doGet()} since no special POST logic is needed.
     *
     * @param request  the {@link HttpServletRequest} object that contains the request the client made to the servlet
     * @param response the {@link HttpServletResponse} object that contains the response the servlet returns to the client
     * @throws ServletException if the request could not be handled
     * @throws IOException      if an input or output error occurs while the servlet is handling the POST request
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Delegate POST requests to GET
        doGet(request, response);
    }
}
