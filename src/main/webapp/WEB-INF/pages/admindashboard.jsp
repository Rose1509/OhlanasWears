<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Oh Lana's Wears - Admin Dashboard</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admindashboard.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    </head>
    <body>
        <!-- Sidebar -->
        <div class="sidebar">
            <div class="sidebar-logo">
                <h2>Oh Lana's Wears</h2>
            </div>
            <nav class="sidebar-menu">
                <a href="admindashboard" class="menu-item active"><i class="fas fa-tachometer-alt"></i>Dashboard</a>
                <a href="product" class="menu-item"><i class="fas fa-box"></i>Product</a>
                <a href="contactus" class="menu-item"><i class="fas fa-envelope"></i>Contact Us</a>
                <a href="aboutus" class="menu-item"><i class="fas fa-info-circle"></i>About US</a>
            </nav>
            <div class="sidebar-footer">
                <a href="login" class="logout-btn" onclick="return confirmLogout();">
                    <i class="fas fa-sign-out-alt"></i>
                    Log out
                </a>
            </div>
        </div>

        <!-- Main Content -->
        <main class="main-content">
            <!-- Header -->
            <header class="header">
                <div class="header-title">
                    <h1>Dashboard</h1>
                    <p>Welcome back to Oh-lana's wears admin panel</p>
                </div>
                <div class="header-actions">
                    <a href="product?action=add" class="add-product-btn" style="text-decoration: none;">Add New Product</a>
                    <div>
                        <a href="adminprofile" class="usericon"><i class="fas fa-user"></i></a>               
                    </div>                
                </div>
            </header>

            <!-- Stats Cards -->
            <div class="stats-container">
                <div class="stat-card">
                    <div class="stat-card-icon dollar">
                        <i class="fas fa-dollar-sign"></i>
                    </div>
                    <div class="stat-card-title">Total Revenue</div>
                    <div class="stat-card-value">$<fmt:formatNumber value="${totalRevenue}" pattern="#,##0.00"/></div>
                    <div class="stat-change up">
                        <i class="fas fa-arrow-up"></i>
                        12.5% from last month
                    </div>
                </div>
                <div class="stat-card">
                    <div class="stat-card-icon orders">
                        <i class="fas fa-boxes"></i>
                    </div>
                    <div class="stat-card-title">Stock</div>
                    <div class="stat-card-value">${totalStock}</div>
                    <div class="stat-change up">
                        <i class="fas fa-arrow-up"></i>
                        8.2% from last month
                    </div>
                </div>
                <div class="stat-card">
                    <div class="stat-card-icon customers">
                        <i class="fas fa-users"></i>
                    </div>
                    <div class="stat-card-title">Highest Price Product</div>
                    <div class="stat-card-value">$<fmt:formatNumber value="${highestPrice}" pattern="#,##0.00"/></div>
                    <div class="stat-change up">
                        <i class="fas fa-arrow-up"></i>
                        3.1% from last month
                    </div>
                </div>
                <div class="stat-card">
                    <div class="stat-card-icon average">
                        <i class="fas fa-tags"></i>
                    </div>
                    <div class="stat-card-title">Total Product</div>
                    <div class="stat-card-value">${totalProducts}</div>
                    <div class="stat-change down">
                        <i class="fas fa-arrow-down"></i>
                        1.2% from last month
                    </div>
                </div>
            </div>

            <!-- Dashboard Grid -->
            <div class="dashboard-grid">
                <!-- Top Selling Products -->
                <div class="products-container">
                    <h2 class="section-title">Top Selling Products</h2>
                    <p class="section-subtitle">Your best performing products this month</p>
                    <div class="product-grid">
                        <c:forEach var="product" items="${topProducts}">
                            <div class="product-item">
                                <div class="product-info">
                                    <h4>${product.name}</h4>
                                    <p>Stock: ${product.stock}</p>
                                </div>
                                <div class="product-price">
                                    <h4>$<fmt:formatNumber value="${product.price}" pattern="#,##0.00"/></h4>
                                    <p>Sales: ${product.sales}</p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <a href="product" class="view-all-btn" style="text-decoration: none; display: block;">View All Products</a>
                </div>

                <!-- Seasonal Distribution -->
                <div class="seasonal-container">
                    <h2 class="section-title">Seasonal Distribution</h2>
                    <p class="section-subtitle">Current inventory by season</p>
                    <div class="seasonal-list">
                        <c:forEach var="season" items="${seasonalDistribution}">
                            <div class="seasonal-item">
                                <div class="season-name">${season.key}</div>
                                <div class="season-percentage">${season.value}%</div>
                            </div>
                        </c:forEach>
                    </div>

                    <!-- Recent Orders -->
                    <div class="recent-orders">
                        <h2 class="section-title">Recent Order</h2>
                        <c:forEach var="order" items="${recentOrders}">
                            <div class="order-item">
                                <div class="order-info">
                                    <h4>${order.productName}</h4>
                                    <p>$<fmt:formatNumber value="${order.totalPrice}" pattern="#,##0.00"/></p>
                                </div>
                                <div class="order-status ${order.status.toLowerCase()}">${order.status}</div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            
            <!-- JavaScript for logout confirmation -->
            <script>
                function confirmLogout() {
                    return confirm("Are you sure you want to log out?");
                }
            </script>
            
            <%
            String success = request.getParameter("success");
            if ("true".equals(success)) {
            %>
                <script>
                    alert("Logged into Admin Dashboard successfully!");
                </script>
            <%
            }
            %>

            <!-- Footer -->
            <footer class="footer">
                <p>Copyright © 2024 Oh-lana's Wears</p>
            </footer>
        </main>
    </body>
</html>