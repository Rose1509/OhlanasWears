package com.OhlanasWears.util;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Utility class for handling page redirection and setting messages in the request scope.
 * 
 * LMU ID: 23048677
 * NAME: Rose Khatiwada
 */
public class RedirectionUtil {

    /** Base directory for JSP pages */
    private static final String baseUrl = "/WEB-INF/pages/";

    /** Path to the register page */
    public static final String registerUrl = baseUrl + "register.jsp";

    /** Path to the login page */
    public static final String loginUrl = baseUrl + "login.jsp";

    /** Path to the home page (typically a controller endpoint) */
    public static final String homeUrl = baseUrl + "home";

    /** Path to the admin dashboard page (typically a controller endpoint) */
    public static final String admindashboardUrl = baseUrl + "admindashboard";

    /**
     * Sets a message attribute in the request scope.
     * 
     * @param req     the HttpServletRequest object
     * @param msgType the name of the attribute (e.g., "error", "success")
     * @param msg     the actual message to display
     */
    public void setMsgAttribute(HttpServletRequest req, String msgType, String msg) {
        req.setAttribute(msgType, msg);
    }

    /**
     * Redirects or forwards the user to the specified JSP page using RequestDispatcher.
     * 
     * @param req   the HttpServletRequest object
     * @param resp  the HttpServletResponse object
     * @param page  the target JSP path to forward to
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    public void redirectToPage(HttpServletRequest req, HttpServletResponse resp, String page)
            throws ServletException, IOException {
        req.getRequestDispatcher(page).forward(req, resp);
    }

    /**
     * Sets a message in the request and redirects to the specified page.
     * 
     * @param req     the HttpServletRequest object
     * @param resp    the HttpServletResponse object
     * @param msgType the attribute name for the message (e.g., "error", "info")
     * @param msg     the message content
     * @param page    the JSP page path to forward to
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    public void setMsgAndRedirect(HttpServletRequest req, HttpServletResponse resp, String msgType, String msg,
            String page) throws ServletException, IOException {
        setMsgAttribute(req, msgType, msg);
        redirectToPage(req, resp, page);
    }

}
