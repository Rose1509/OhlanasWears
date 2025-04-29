<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            <a href="#" class="menu-item active">
                <i class="fas fa-tachometer-alt"></i>
                Dashboard
            </a>
            <a href="#" class="menu-item">
                <i class="fas fa-box"></i>
                Product
            </a>
            <a href="#" class="menu-item">
                <i class="fas fa-envelope"></i>
                Contact Us
            </a>
            <a href="#" class="menu-item">
                <i class="fas fa-info-circle"></i>
                About US
            </a>
        </nav>
        <div class="sidebar-footer">
            <a href="#" class="logout-btn">
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
                <div class="search-box">
                    <input type="text" placeholder="Search...">
                    <i class="fas fa-search"></i>
                </div>
                <button class="add-product-btn">Add New Product</button>
            </div>
            
        </header>

        <!-- Stats Cards -->
        <div class="stats-container">
            <div class="stat-card">
                <div class="stat-card-icon dollar">
                    <i class="fas fa-dollar-sign"></i>
                </div>
                <div class="stat-card-title">Total Revenue</div>
                <div class="stat-card-value">$24,580</div>
                <div class="stat-change up">
                    <i class="fas fa-arrow-up"></i>
                    12.5% from last month
                </div>
            </div>
            <div class="stat-card">
                <div class="stat-card-icon orders">
                    <i class="fas fa-shopping-cart"></i>
                </div>
                <div class="stat-card-title">Orders</div>
                <div class="stat-card-value">420</div>
                <div class="stat-change up">
                    <i class="fas fa-arrow-up"></i>
                    8.2% from last month
                </div>
            </div>
            <div class="stat-card">
                <div class="stat-card-icon customers">
                    <i class="fas fa-users"></i>
                </div>
                <div class="stat-card-title">Customers</div>
                <div class="stat-card-value">2815</div>
                <div class="stat-change up">
                    <i class="fas fa-arrow-up"></i>
                    3.1% from last month
                </div>
            </div>
            <div class="stat-card">
                <div class="stat-card-icon average">
                    <i class="fas fa-chart-line"></i>
                </div>
                <div class="stat-card-title">Average Order</div>
                <div class="stat-card-value">$58.5</div>
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
                    <div class="product-item">
                        <div class="product-info">
                            <h4>Flare off shoulder T-shirt</h4>
                            <p>Stock: 28</p>
                        </div>
                        <div class="product-price">
                            <h4>$79.99</h4>
                            <p>Sales: 100</p>
                        </div>
                    </div>
                    <div class="product-item">
                        <div class="product-info">
                            <h4>Oversize denim jacket</h4>
                            <p>Stock: 45</p>
                        </div>
                        <div class="product-price">
                            <h4>$89.99</h4>
                            <p>Sales: 87</p>
                        </div>
                    </div>
                    <div class="product-item">
                        <div class="product-info">
                            <h4>Off-white Silk Shirt</h4>
                            <p>Stock: 19</p>
                        </div>
                        <div class="product-price">
                            <h4>$159.99</h4>
                            <p>Sales: 75</p>
                        </div>
                    </div>
                    <div class="product-item">
                        <div class="product-info">
                            <h4>Vintage Leather Jacket</h4>
                            <p>Stock: 22</p>
                        </div>
                        <div class="product-price">
                            <h4>$200.99</h4>
                            <p>Sales: 53</p>
                        </div>
                    </div>
                </div>
                <button class="view-all-btn">View All Products</button>
            </div>

            <!-- Seasonal Distribution -->
            <div class="seasonal-container">
                <h2 class="section-title">Seasonal Distribution</h2>
                <p class="section-subtitle">Current inventory by season</p>
                <div class="seasonal-list">
                    <div class="seasonal-item">
                        <div class="season-name">Summer</div>
                        <div class="season-percentage">86%</div>
                    </div>
                    <div class="seasonal-item">
                        <div class="season-name">Winter</div>
                        <div class="season-percentage">55%</div>
                    </div>
                </div>

                <!-- Recent Orders -->
                <div class="recent-orders">
                    <h2 class="section-title">Recent Order</h2>
                    <div class="order-item">
                        <div class="order-info">
                            <h4>Off-white Silk Shirt</h4>
                            <p>$50.00</p>
                        </div>
                        <div class="order-status pending">Pending</div>
                    </div>
                    <div class="order-item">
                        <div class="order-info">
                            <h4>Washed Baggy Jeans</h4>
                            <p>$96.79</p>
                        </div>
                        <div class="order-status completed">Completed</div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Footer -->
        <footer class="footer">
            <p>Copyright © 2024 Oh-lana's Wears</p>
        </footer>
    </main>
</body>
</html>