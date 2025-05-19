<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Oh Lana's Wears - Admin Profile</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admindashboard.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminprofile.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet" />
</head>
<body>
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

    <main class="main-content">
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

        <div class="profile-content">
            <div class="profile-header">
                <i class="fas fa-bars menu-toggle"></i>
                <h2>My Profile</h2>
            </div>

            <div class="profile-body">
                <div class="profile-picture-column">
                    <div class="profile-picture">
                        <img src="${pageContext.request.contextPath}/resources/images/system/roseimg.png" alt="Profile Picture" />
                    </div>
                    <p class="user-name">${customer.customerName}</p>
                </div>

                <div class="profile-form-column">
                    <h3>Personal Information</h3>

                    <c:if test="${not empty error}">
                        <div class="error-message">${error}</div>
                    </c:if>
                    <c:if test="${not empty message}">
                        <div class="success-message">${message}</div>
                    </c:if>

                    <form action="adminprofile" method="post">
                        <div class="form-row">
                            <div class="form-group">
                                <label for="fullName">Full Name</label>
                                <input type="text" id="fullName" name="fullname" value="${customer.customerName}" required />
                            </div>
                            <div class="form-group">
                                <label for="userName">User Name</label>
                                <input type="text" id="userName" name="username" value="${customer.userName}" readonly />
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group">
                                <label for="email">Email Address</label>
                                <input type="email" id="email" name="email" value="${customer.email}" required />
                                <small class="hint-text">This is your primary email address and will be used to send notifications.</small>
                            </div>
                            <div class="form-group">
                                <label for="phone">Phone Number</label>
                                <input type="tel" id="phone" name="phone" value="${customer.phoneNumber}" required />
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group">
                                <label for="newPassword">New Password</label>
                                <input type="password" id="newPassword" name="newPassword" />
                            </div>
                            <div class="form-group">
                                <label for="confirmPassword">Confirm Password</label>
                                <input type="password" id="confirmPassword" name="confirmPassword" />
                            </div>
                        </div>

                        <button type="submit" class="submit-button">Save Changes</button>
                    </form>
                </div>
            </div>
        </div>

        <script>
            function confirmLogout() {
                return confirm("Are you sure you want to log out?");
            }
        </script>

        <script>
            document.querySelector('form').addEventListener('submit', function (e) {
                const newPassword = document.getElementById('newPassword').value.trim();
                const confirmPassword = document.getElementById('confirmPassword').value.trim();

                // If either password field is filled, check for matching passwords
                if (newPassword !== '' || confirmPassword !== '') {
                    if (newPassword === '') {
                        alert('Please enter the new password.');
                        e.preventDefault();
                        return;
                    }
                    if (confirmPassword === '') {
                        alert('Please confirm the new password.');
                        e.preventDefault();
                        return;
                    }
                    if (newPassword !== confirmPassword) {
                        alert('New password and confirm password do not match.');
                        e.preventDefault();
                        return;
                    }
                }

                // Additional validation example (optional):
                // Check phone number is numeric and 10-15 digits
                const phone = document.getElementById('phone').value.trim();
                const phoneRegex = /^[0-9]{10,15}$/;
                if (!phoneRegex.test(phone)) {
                    alert('Please enter a valid phone number with 10 to 15 digits.');
                    e.preventDefault();
                    return;
                }

                // You can add other checks as needed...
            });
        </script>

        <footer class="footer">
            <p>Copyright © 2024 Oh Lana's Wears</p>
        </footer>
    </main>
</body>
</html>
