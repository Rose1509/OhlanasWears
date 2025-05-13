<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <aside class="sidebar">
            <h1> My Profile</h1>
            <div class="profile-pic">
                <i class="fas fa-user"></i>
            </div>
            <!-- Displaying full name from the request -->
            <div class="profile-name">${fullName}</div>
        </aside>
        
        <main class="main-content">
            <form id="profile-form" class="profile-section" method="POST">
                <!-- Full Name -->
                <div class="form-row">
                    <div class="form-group half-width">
                        <label for="full-name">Full Name</label>
                        <!-- Populating full name -->
						<input type="text" id="fullname" name="fullname" value="${fullName}" required>
                    </div>
                    <div class="form-group half-width">
                        <label for="Password">Password</label>
                        <!-- Masking password for security -->
						<input type="password" id="password" name="password" value="${maskedPassword}" required>
                    </div>
                </div>

                <!-- Username & Email Address -->
                <div class="form-row">
                    <div class="form-group half-width">
                        <label for="username">User Name</label>
                        <!-- Populating username -->
                        <input type="text" id="username" name="username" value="${username}" required>
                    </div>
                    <div class="form-group half-width">
                        <label for="email">Email Address</label>
                        <!-- Populating email -->
                        <input type="email" id="email" name="email" value="${email}" required>
                        <div class="note">
                            This is your primary email address, and will be used to send notifications.
                        </div>
                    </div>
                </div>
                
                <!-- Phone Number -->
                <div class="form-group">
                    <label for="phone">Phone Number</label>
                    <!-- Populating phone -->
					<input type="tel" id="phone" name="phone" value="${phone}">
                </div>
                
                <!-- Location -->
                <div class="form-group">
                    <label for="location">Location</label>
                    <!-- Populating location -->
                    <input type="text" id="location" name="location" value="${location}">
                </div>
                
                <button type="submit" class="save-btn">Save Changes</button>
            </form>
        </main>
    </div>
    <jsp:include page="footer.jsp" />    
</body>
</html>
