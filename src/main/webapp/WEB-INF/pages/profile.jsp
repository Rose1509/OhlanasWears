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
    <jsp:include page="header.jsp"/>

    <div class="container">
        <aside class="sidebar">
            <nav>
                <a href="#basic-info" class="active" aria-current="page">
                    <i class="fas fa-user"></i> Basic Information
                </a>
                <a href="#password"><i class="fas fa-shopping-cart"></i> Order History</a>
                <a href="#preferences"><i class="fas fa-cog"></i> Preferences</a>
                <a href="#support"><i class="fas fa-question-circle"></i> Support</a>
            </nav>
        </aside>
        <main class="main-content">
            <form id="profile-form" class="profile-section" action="${pageContext.request.contextPath}/updateProfile" method="POST">
                <div class="form-group">
                    <label for="full-name">First Name</label>
                    <input type="text" id="full-name" name="fullName" value="">
                </div>
                
                <div class="form-group">
                    <label for="full-name">Last Name</label>
                    <input type="text" id="last-name" name="LastName" value=" ">
                </div>
                                
                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input type="email" id="email" name="email" value="" >
                    <div class="note">
                        This is your primary email address and will be used to send notifications.
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="phone">Phone Number</label>
                    <input type="tel" id="phone" name="phone" value="" pattern="\+?[1-9]\d{1,14}" title="Enter a valid phone number">
                </div>
                
                <div class="form-group">
                    <label for="billing-address">Billing Address</label>
                    <textarea id="billing-address" name="billingAddress" rows="4" ></textarea>
                </div>
                
                <button type="submit" class="save-btn">Save Changes</button>
            </form>
        </main>
    </div>
    <jsp:include page="footer.jsp"/>

</body>
</html>