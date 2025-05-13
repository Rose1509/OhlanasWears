package com.OhlanasWears.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.OhlanasWears.util.CookiesUtil;
import com.OhlanasWears.util.SessionUtil;

/**
 * Handles user logout functionality by removing cookies and invalidating session.
 *
 * LMU ID: 23048677
 * NAME: Rose Khatiwada
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles POST requests to log the user out.
     * Deletes the "role" cookie, invalidates the current session,
     * and redirects to the login page.
     *
     * @param request  the HttpServletRequest object containing client request data.
     * @param response the HttpServletResponse object used to send the response.
     * @throws ServletException if a servlet-specific error occurs.
     * @throws IOException      if an input or output error is detected.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CookiesUtil.deleteCookie(response, "role");
        SessionUtil.invalidateSession(request);
        response.sendRedirect(request.getContextPath() + "/login");
    }
}
