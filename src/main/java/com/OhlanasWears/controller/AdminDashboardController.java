package com.OhlanasWears.controller;

import com.OhlanasWears.service.AdminDashboardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.OhlanasWears.model.Product;
import com.OhlanasWears.model.Order;

/**
 * LMU ID: 23048677
 * NAME: Rose Khatiwada
 *
 * Servlet implementation class AdminDashboardController
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/admindashboard"})
public class AdminDashboardController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminDashboardService dashboardService;

    public AdminDashboardController() {
        super();
    }

    @Override
    public void init() throws ServletException {
        dashboardService = new AdminDashboardService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get real-time statistics from the service
        int totalProducts = dashboardService.getTotalProducts();
        int totalStock = dashboardService.getTotalStock();
        double highestPrice = dashboardService.getHighestPriceProduct();
        double totalRevenue = dashboardService.getTotalRevenue();
        
        // Get top selling products
        List<Product> topProducts = dashboardService.getTopSellingProducts();
        
        // Get seasonal distribution
        Map<String, Integer> seasonalDistribution = dashboardService.getSeasonalDistribution();
        
        // Get recent orders
        List<Order> recentOrders = dashboardService.getRecentOrders();
        
        // Add all data to request attributes
        request.setAttribute("totalProducts", totalProducts);
        request.setAttribute("totalStock", totalStock);
        request.setAttribute("highestPrice", highestPrice);
        request.setAttribute("totalRevenue", totalRevenue);
        request.setAttribute("topProducts", topProducts);
        request.setAttribute("seasonalDistribution", seasonalDistribution);
        request.setAttribute("recentOrders", recentOrders);

        request.getRequestDispatcher("WEB-INF/pages/admindashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}