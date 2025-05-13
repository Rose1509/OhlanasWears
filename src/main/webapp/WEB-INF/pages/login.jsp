<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="jakarta.servlet.http.HttpServletRequest"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - Oh-Lana’s Wears</title>
    <!-- Link to external CSS file -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
    <div class="container">
        <!-- Left panel for login form -->
        <div class="left-panel">
            <h1>Sign in to Oh-Lana’s Wears</h1>
            <p>Please enter your login details below using this app</p>

            <!-- Display error from URL parameter -->
            <% if (request.getParameter("Error") != null) { %>
                <p class="error message"><%= request.getParameter("Error") %></p>
            <% } %>

            <!-- Display error -->
            <% if (request.getAttribute("error") != null) { %>
                <p class="error-message"><%= request.getAttribute("error") %></p>
            <% } %>


            <!-- Login form -->
            <form action="${pageContext.request.contextPath}/login" method="post">
                <input type="text" name="username" placeholder="User Name" required />
                <input type="password" name="password" placeholder="Password" required />
                <a href="#" class="forgot">Forgot your password?</a>
                <button type="submit">Login</button>
            </form>

            <!-- Link to registration page -->
            <p class="register-text">
                Don’t have an account?
                <a href="register" class="register-link">Register one</a>
            </p>
        </div>

        <!-- Right panel with slogan and background image -->
        <div class="right-panel">
            <div class="slogan">Unleash Your Inner Lana.</div>
            <img class="image-img" src="${pageContext.request.contextPath}/resources/images/system/image.png" alt="background image" />
        </div>
    </div>

    <!-- Display success toast if registration was successful -->
    <% if (session.getAttribute("success") != null) { %>
        <div id="successToast" class="toast">
            <%= session.getAttribute("success") %>
        </div>
        <% session.removeAttribute("success"); %> <!-- Remove after displaying -->
    <% } %>

    <!-- Auto-hide toast message after 4 seconds -->
    <script>
        setTimeout(() => {
            const toast = document.getElementById("successToast");
            if (toast) toast.remove();
        }, 4000);
        
    </script>
</body>
</html>
