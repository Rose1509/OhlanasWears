<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Oh Lana's Wears - Product </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admindashboard.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/product.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/6882fa3990.js" crossorigin="anonymous"></script>
</head>
<body>
    <!-- Sidebar -->
    <div class="sidebar">
        <div class="sidebar-logo">
            <h2>Oh Lana's Wears</h2>
        </div>
        <nav class="sidebar-menu">
            <a href="admindashboard" class="menu-item"><i class="fas fa-tachometer-alt"></i>Dashboard</a>
            <a href="product" class="menu-item active"><i class="fas fa-box"></i>Product</a>
            <a href="contactus" class="menu-item"><i class="fas fa-envelope"></i>Contact Us</a>
            <a href="aboutus" class="menu-item"><i class="fas fa-info-circle"></i>About US</a>
        </nav>
        <div class="sidebar-footer">
            <a href="login" class="logout-btn"><i class="fas fa-sign-out-alt"></i>Log out</a>
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
                <a href="product?action=add" class="add-product-btn" style="text-decoration: none;">Add New Product</a>
                <div>
                    <a href="adminprofile" class="usericon"><i class="fas fa-user"></i></a>
                </div>
            </div>
        </header>

        <!-- Product List -->
        <div class="product-container">
            <table class="product-table">
                <thead>
                    <tr>
                        <th>Product Code</th>
                        <th>Clothes Name</th>
                        <th>Color</th>
                        <th>Stock</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${products}">
                        <tr>
                            <td>${product.code}</td>
                            <td>${product.clothesName}</td>
                            <td>${product.color}</td>
                            <td>${product.stock}</td>
                            <td>${product.price}</td>
                            <td class="action-column">
                                <!-- Edit button -->
                                <a href="product?action=edit&id=${product.code}" class="edit-btn">
                                    <i class="fas fa-edit"></i>
                                </a>
                                <!-- Delete button -->
                                <form method="post" action="${pageContext.request.contextPath}/product" style="display:inline;">
                                    <input type="hidden" name="productId" value="${product.code}" />
                                    <button type="submit" name="action" value="delete" class="delete-btn">
                                        <i class="fas fa-trash"></i>
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- Add Products Form -->
        <div class="add-products-section">
            <h2>Add Products</h2>

            <%
                String errorMessage = (String) request.getAttribute("error");
                String successMessage = (String) request.getAttribute("success");

                if (errorMessage != null && !errorMessage.isEmpty()) {
            %>
                <p class="error-messagees"><%= errorMessage %></p>
            <%
                }

                if (successMessage != null && !successMessage.isEmpty()) {
            %>
                <p class="success-messagees"><%= successMessage %></p>
            <%
                }
            %>

            <form action="${pageContext.request.contextPath}/product" method="post" class="add-product-form">
                <div class="form-row">
                    <div class="form-group">
                        <label for="productName">Clothes Name</label>
                        <input type="text" id="ClothesName" name="clothesName" required>
                    </div>
                    <div class="form-group">
                        <label for="color">Color</label>
                        <input type="text" id="Color" name="color" required>
                    </div>
                    <div class="form-group">
                        <label for="stock">Stock</label>
                        <input type="number" id="Stock" name="stock" required>
                    </div>
                    <div class="form-group">
                        <label for="price">Price</label>
                        <input type="text" id="Price" name="price" required>
                    </div>
                </div>
                <div class="forms">
                    <div class="button-container">
                        <button type="submit" class="add-product-button">Add Product</button>
                    </div>
                </div>
            </form>
        </div>

        <!-- Footer -->
        <footer class="footer">
        	<p>Copyright © 2024 Oh-lana's Wears</p>
        </footer>
    </main>
</body>
</html>
