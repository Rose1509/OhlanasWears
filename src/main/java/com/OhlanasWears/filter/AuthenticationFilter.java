package com.OhlanasWears.filter;

import java.io.IOException;

import com.OhlanasWears.util.SessionUtil;
import com.OhlanasWears.util.CookiesUtil;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * AuthenticationFilter is a servlet filter that manages access control
 * based on user roles (admin or customer). It allows access to public resources
 * and redirects users based on their login status and role.
 *
 * LMU ID: 23048677  
 * NAME: Rose Khatiwada
 */
@WebFilter(asyncSupported = true, urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {

    // Constants for commonly accessed URL patterns
    private static final String LOGIN = "/login";
    private static final String REGISTER = "/register";
    private static final String LOGOUT = "/logout";
    private static final String HOME = "/home";
    private static final String ROOT = "/";
    private static final String ADMIN_DASHBOARD = "/admindashboard";
    private static final String ADMIN_PROFILE = "/adminprofile";
    private static final String PROFILE = "/profile";
    private static final String PRODUCT = "/product";
    private static final String COLLECTION = "/collection";
    private static final String ABOUT = "/aboutus";
    private static final String CONTACT = "/contactus";

    /**
     * Initializes the filter. Currently no initialization logic is used.
     *
     * @param filterConfig The filter configuration
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    /**
     * Filters incoming requests based on user session and role.
     * Redirects users to appropriate pages if they attempt to access unauthorized resources.
     *
     * @param request  The incoming ServletRequest
     * @param response The outgoing ServletResponse
     * @param chain    The FilterChain to pass control to the next filter
     * @throws IOException      If an I/O error occurs during filtering
     * @throws ServletException If a servlet error occurs during filtering
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();

        // Allow access to static resources like CSS and images
        if (uri.endsWith(".png") || uri.endsWith(".jpg") || uri.endsWith(".css")) {
            chain.doFilter(request, response);
            return;
        }

        // Allow public pages
        if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER) || uri.endsWith(LOGOUT)) {
            chain.doFilter(request, response);
            return;
        }

        // Check login status and role
        boolean isLoggedIn = SessionUtil.getAttribute(req, "username") != null;
        String userRole = CookiesUtil.getCookie(req, "role") != null
                ? CookiesUtil.getCookie(req, "role").getValue()
                : null;

        if (isLoggedIn) {
            if ("admin".equals(userRole)) {
                handleAdminRouting(req, res, chain, uri);
            } else if ("customer".equals(userRole)) {
                handleCustomerRouting(req, res, chain, uri);
            }
        } else {
            // Unauthenticated users
            if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER) || uri.endsWith(ROOT)) {
                chain.doFilter(request, response);
            } else {
                res.sendRedirect(req.getContextPath() + LOGIN);
            }
        }
    }

    /**
     * Handles request routing for admin users based on the requested URI.
     */
    private void handleAdminRouting(HttpServletRequest req, HttpServletResponse res, FilterChain chain, String uri)
            throws IOException, ServletException {
        if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER)) {
            res.sendRedirect(req.getContextPath() + ADMIN_DASHBOARD);
        } else if (uri.endsWith(ADMIN_DASHBOARD) || uri.endsWith(PRODUCT)
                || uri.endsWith(ADMIN_PROFILE) || uri.endsWith(ABOUT) || uri.endsWith(CONTACT)
                || uri.endsWith(LOGOUT) || uri.endsWith(ROOT)) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect(req.getContextPath() + ADMIN_DASHBOARD);
        }
    }

    /**
     * Handles request routing for customer users based on the requested URI.
     */
    private void handleCustomerRouting(HttpServletRequest req, HttpServletResponse res, FilterChain chain, String uri)
            throws IOException, ServletException {
        if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER)) {
            res.sendRedirect(req.getContextPath() + HOME);
        } else if (uri.endsWith(HOME) || uri.endsWith(ROOT) || uri.endsWith(ABOUT) || uri.endsWith(COLLECTION)
                || uri.endsWith(CONTACT) || uri.endsWith(PROFILE) || uri.endsWith(LOGOUT)) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect(req.getContextPath() + HOME);
        }
    }

    // Uncomment this if you need to clean up resources when the filter is destroyed
    /*
    @Override
    public void destroy() {
        // Cleanup logic, if required
    }
    */
}
