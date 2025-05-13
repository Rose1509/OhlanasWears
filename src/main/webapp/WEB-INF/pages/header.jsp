<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="jakarta.servlet.http.HttpServletRequest"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Oh Lana's Wears</title>
    <!-- Google Fonts for typography -->
    <link href="https://fonts.googleapis.com/css2?family=Inria+Sans:wght@400;700&family=Kalnia:wght@700&family=Meow+Script&display=swap" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
    <!-- Link to external CSS file -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>
    <!-- Navigation Bar -->
    <nav class="navbar">
        <div class="logo">
            <a href="home">Oh Lana's Wears</a>
        </div>

        <ul class="nav-links">
            <li><a href="home">HOME</a></li>
            <li><a href="collection">COLLECTION</a></li>
            <li><a href="contactus">CONTACT US</a></li>
            <li><a href="aboutus">ABOUT US</a></li>
            <li><a href="admindashboard">DASHBOARD</a></li>            
        </ul>

        <div class="nav-icons">
            <a href="search.jsp" class="search-icon"><i class="fas fa-search"></i></a>
            <a href="profile" class="user-icon"><i class="fas fa-user"></i></a>
            <a href="login" class="sign-out-icon"><i class="fas fa-sign-out-alt"></i></a>
        </div>
    </nav>
