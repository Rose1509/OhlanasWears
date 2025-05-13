<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Oh Lana's Wears - Admin Dashboard</title>

    <!-- External CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admindashboard.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminprofile.css">

    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>
    <!-- Sidebar Navigation -->
    <div class="sidebar">
        <div class="sidebar-logo">
            <h2>Oh Lana's Wears</h2>
        </div>
        <nav class="sidebar-menu">
            <a href="admindashboard" class="menu-item"><i class="fas fa-tachometer-alt"></i>Dashboard</a>
            <a href="product" class="menu-item"><i class="fas fa-box"></i>Product</a>
            <a href="contactus" class="menu-item"><i class="fas fa-envelope"></i>Contact Us</a>
            <a href="aboutus" class="menu-item"><i class="fas fa-info-circle"></i>About Us</a>
        </nav>
        <div class="sidebar-footer">
            <a href="login" class="logout-btn"><i class="fas fa-sign-out-alt"></i>Log out</a>
        </div>
    </div>

    <!-- Main Content Area -->
    <main class="main-content">
        <!-- Page Header -->
        <header class="header">
            <div class="header-title">
                <h1>Profile</h1>
                <p>Edit Your Profile</p>
            </div>
            <div class="header-actions">

                <a href="product?action=add" class="add-product-btn" style="text-decoration: none;">Add New Product</a>
                <div>
                    <a href="adminprofile" class="menu-item active usericon"><i class="fas fa-user"></i></a>
                </div>
            </div>
        </header>

        <!-- Profile Section -->
        <div class="profile-content">
            <!-- Profile Header (Icon + Title) -->
            <div class="profile-header">
                <i class="fas fa-bars menu-toggle"></i>
                <h2>My Profile</h2>
            </div>

            <!-- Profile Body -->
            <div class="profile-body">
                <!-- Left Column: Profile Picture -->
                <div class="profile-picture-column">
                    <div class="profile-picture">
                    	<img src="${pageContext.request.contextPath}/resources/images/system/roseimg.png">
                        
                    </div>
                    <p class="user-name">Rose Khatiwada</p>
                </div>

                <!-- Right Column: Profile Form -->
                <div class="profile-form-column">
                    <h3>Personal Information</h3>

                    <!-- Name Fields -->
                    <div class="form-row">
                        <div class="form-group">
                            <label for="firstName">First Name</label>
                            <input type="text" id="firstName">
                        </div>
                        <div class="form-group">
                            <label for="lastName">Last Name</label>
                            <input type="text" id="lastName">
                        </div>
                    </div>

                    <!-- Username and Email -->
                    <div class="form-row">
                        <div class="form-group">
                            <label for="userName">User Name</label>
                            <input type="text" id="userName">
                        </div>
                        <div class="form-group">
                            <label for="email">Email Address</label>
                            <input type="email" id="email">
                            <small class="hint-text">This is your primary email address and will be used to send notifications.</small>
                        </div>
                    </div>

                    <!-- Phone Number and DOB -->
                    <div class="form-row">
                        <div class="form-group">
                            <label for="phone">Phone Number</label>
                            <input type="tel" id="phone">
                        </div>
                        <div class="form-group">
                            <label for="dob">Date of Birth</label>
                            <input type="date" id="dob">
                        </div>
                    </div>

                    <!-- Location -->
                    <div class="form-row">
                        <div class="form-group full-width">
                            <label for="location">Location</label>
                            <input type="text" id="location">
                        </div>
                    </div>
                    
                    <!-- Submit Button -->
                    <button class="submit-button">Save Changes</button>
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