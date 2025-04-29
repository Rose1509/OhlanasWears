<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
</head>
<body>
    <div class="container">
    
        <div class="left-panel">
        <%
			String errorMessage = (String) request.getAttribute("error");
			String successMessage = (String) request.getAttribute("success");	
			if (errorMessage != null && !errorMessage.isEmpty()) {
				out.println("<p class=\"error-message\">" + errorMessage + "</p>");
			}
			if (successMessage != null && !successMessage.isEmpty()) {
		%>
		<p class="success-message"><%=successMessage%></p>
		<%}%>      
            <h1>Registration</h1>
            <form method="post" action="${pageContext.request.contextPath}/register">
			    <div class="input-group">
			        <input type="text" id="Customer_Name" name="Customer_Name" placeholder="FULL NAME" required>
			    </div>
			    <div class="input-group">
			        <input type="text" id="User_Name" name="User_Name" placeholder="USER NAME" required>
			    </div>
			    <div class="input-group">
			        <input type="email" id="Email" name="email" placeholder="EMAIL ADDRESS" required>
			    </div>
			    <div class="input-group">
			        <input type="tel" id="Phone_Number" name="Phone_Number" placeholder="PHONE NUMBER" required>
			    </div>
			    <div class="input-group">
			        <input type="password" id="Password" name="Password" placeholder="CREATE A PASSWORD" required>
			    </div>
			    <div class="input-group">
			        <input type="password" id="confirm-password" name="confirm-password" placeholder="CONFIRM PASSWORD" required>
			    </div>
			    <button type="submit">Register Now</button>
			</form>

        </div>
        <div class="right-panel">
        	<div class="slogan">Unleash Your Inner Lana.</div>
            <img class="image-img" src="${pageContext.request.contextPath}/resources/images/system/image.png" alt="background image" />          
        </div>
    </div>
</body>
</html>