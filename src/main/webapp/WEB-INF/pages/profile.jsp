<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
</head>
<body>
    <jsp:include page="header.jsp" />

    <div class="container">
        <!-- Sidebar with Profile Info -->
        <aside class="sidebar">
            <h1>My Profile</h1>
            <div class="profile-pic">
                <i class="fas fa-user"></i>
            </div>
            <div class="profile-name">${customer.customerName}</div>
        </aside>

        <!-- Main Content Area -->
        <main class="main-content">
            <form id="profile-form" class="profile-section" method="POST">

                <!-- Full Name & Username -->
                <div class="form-row">
                    <div class="form-group half-width">
                        <label>Full Name</label>
                        <input type="text" id="Customer_Name" name="fullname" value="${customer.customerName}" required>
                    </div>
                    <div class="form-group half-width">
                        <label>User Name</label>
                        <input type="text" id="User_Name" name="username" value="${customer.userName}" readonly>
                    </div>
                </div>

                <!-- Email & Phone -->
                <div class="form-row">
                    <div class="form-group half-width">
                        <label>Email Address</label>
                        <input type="email" id="Email" name="email" value="${customer.email}" required>
                        <div class="note">
                            This is your primary email address, and will be used to send notifications.
                        </div>
                    </div>
                    <div class="form-group half-width">
                        <label>Phone Number</label>
                        <input type="tel" id="Phone_Number" name="phone" value="${customer.phoneNumber}" required>
                    </div>
                </div>

                <!-- Password change -->
                <div class="form-row">
                    <div class="form-group half-width">
                        <label>New Password</label>
                        <input type="password" id="New_Password" name="newPassword" placeholder="Enter new password">
                    </div>
                    <div class="form-group half-width">
                        <label>Confirm Password</label>
                        <input type="password" id="Confirm_Password" name="confirmPassword" placeholder="Confirm new password">
                    </div>
                </div>

                <!-- Save Button -->
                <button type="submit" class="save-btn">Save Changes</button>
            </form>

            <c:if test="${not empty message}">
                <div class="success-message">${message}</div>
            </c:if>
            <c:if test="${not empty error}">
                <div class="error-message">${error}</div>
            </c:if>
        </main>
    </div>

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
    <jsp:include page="footer.jsp" />
</body>
</html>
