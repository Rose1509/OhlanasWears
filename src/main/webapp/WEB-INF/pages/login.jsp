<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - Oh-Lana’s Wears</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
    <div class="container">
        <div class="left-panel">
            <h1>Sign in to Oh-Lana’s Wears</h1>
            <p>Please enter your login details below using this app </p>
			 
			 <%if (request.getParameter("Error") != null){ %>
			 	<p class = "error message"><%= request.getParameter("Error") %></p>
			 	
			 <%} %>
			 <% if (request.getAttribute("error")!= null){ %>
			 	<p class = "error-message"><%=request.getAttribute("error") %></p>
			 <%} %> 
			 
            <form action="${pageContext.request.contextPath}/login" method="post">
                <input type="text" name="username" placeholder="User Name" required />
                <input type="password" name="password" placeholder="Password" required />
                <a href="#" class="forgot">Forgot your password?</a>
                <button type="submit">Login</button>
            </form>

            <p class="register-text">
                Don’t have an account?
                <a href="register" class="register-link">Register one</a>
            </p>
        </div>

        <div class="right-panel">
            <div class="slogan">Unleash Your Inner Lana.</div>
            <img class="image-img" src="${pageContext.request.contextPath}/resources/images/system/image.png" alt="background image" />          
        </div>
    </div>
</body>
</html>
