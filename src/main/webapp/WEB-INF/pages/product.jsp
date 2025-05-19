<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Oh Lana's Wears - Product</title>
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
            <a href="aboutus" class="menu-item"><i class="fas fa-info-circle"></i>About Us</a>
        </nav>
        <div class="sidebar-footer">
            <a href="login" class="logout-btn" onclick="return confirmLogout();"><i class="fas fa-sign-out-alt"></i>Log out</a>
        </div>
    </div>

    <!-- Main Content -->
    <main class="main-content">
        <!-- Header -->
        <header class="header">
            <div class="header-title">
                <h1>Product</h1>
                <p>Manage your clothing inventory</p>
            </div>
            <div class="header-actions">
                <form action="${pageContext.request.contextPath}/product" method="get" class="search-box">
                    <input type="text" name="search" placeholder="Search by clothes name..." value="${param.search}">
                    <button type="submit"><i class="fas fa-search"></i></button>
                </form>
                <a href="adminprofile" class="usericon"><i class="fas fa-user"></i></a>
            </div>
        </header>

        <!-- Popup container -->
        <div id="popup-container"></div>

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
                        <th>Image</th>
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
                            <td>$${product.price}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${not empty product.image && product.image != '0'}">
                                        <img src="${pageContext.request.contextPath}/resources/images/system/${product.image}" 
                                             alt="${product.clothesName}" 
                                             class="product-image">
                                    </c:when>
                                    <c:otherwise>
                                        <div class="no-image">No Image</div>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td class="action-column">
                                <a href="product?action=edit&id=${product.code}" class="edit-btn"><i class="fas fa-edit"></i></a>
                                <form method="post" action="${pageContext.request.contextPath}/product" class="delete-form">
                                    <input type="hidden" name="productId" value="${product.code}" />
                                    <input type="hidden" name="action" value="delete" />
                                    <button type="button" class="delete-btn" onclick="confirmDelete(this)"><i class="fas fa-trash"></i></button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- Add Product Form -->
        <div class="add-products-section">
            <h2>Add Products</h2>
            <c:if test="${not empty error}">
                <p class="error-messagees">${error}</p>
            </c:if>
            <c:if test="${not empty success}">
                <p class="success-messagees">${success}</p>
            </c:if>

            <form action="${pageContext.request.contextPath}/product" method="post" enctype="multipart/form-data" class="add-product-form">
                <div class="form-row">
                    <div class="form-group">
                        <label for="ClothesName">Clothes Name</label>
                        <input type="text" id="ClothesName" name="clothesName" required>
                    </div>
                    <div class="form-group">
                        <label for="Color">Color</label>
                        <input type="text" id="Color" name="color" required>
                    </div>
                    <div class="form-group">
                        <label for="Stock">Stock</label>
                        <input type="number" id="Stock" name="stock" required>
                    </div>
                    <div class="form-group">
                        <label for="Price">Price</label>
                        <input type="number" step="0.01" id="Price" name="price" required>
                    </div>
                    <div class="form-group">
                        <label for="image">Product Image</label>
                        <input type="file" id="image" name="image" accept="image/*" onchange="previewImage(this)">
                        <div class="image-preview">
                            <img id="imagePreview" src="#" alt="Image Preview">
                        </div>
                    </div>
                </div>
                <div class="button-container">
                    <button type="submit" class="add-product-button">Add Product</button>
                </div>
            </form>
        </div>

        <!-- Scripts -->
        <script>
            function confirmDelete(button) {
                if (confirm("Are you sure you want to delete this product?")) {
                    sessionStorage.setItem("deleteSuccess", "true");
                    button.closest("form").submit();
                }
            }

            window.addEventListener("DOMContentLoaded", function () {
                if (sessionStorage.getItem("deleteSuccess")) {
                    showSuccessPopup("Product deleted successfully!");
                    sessionStorage.removeItem("deleteSuccess");
                }
            });

            function showSuccessPopup(message) {
                const popup = document.createElement("div");
                popup.className = "popup-message";
                popup.textContent = message;
                document.getElementById("popup-container").appendChild(popup);
                setTimeout(() => popup.remove(), 4000);
            }

            function confirmLogout() {
                return confirm("Are you sure you want to log out?");
            }
            
            // Image preview functionality
            function previewImage(input) {
                const preview = document.getElementById('imagePreview');
                
                if (input.files && input.files[0]) {
                    const reader = new FileReader();
                    
                    reader.onload = function(e) {
                        preview.src = e.target.result;
                        preview.style.display = 'block';
                    }
                    
                    reader.readAsDataURL(input.files[0]);
                } else {
                    preview.src = '#';
                    preview.style.display = 'none';
                }
            }
        </script>

        <!-- Footer -->
        <footer class="footer">
            <p>Copyright © 2024 Oh-lana's Wears</p>
        </footer>
    </main>
</body>
</html>