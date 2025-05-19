<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Oh Lana's Wears - Collection</title>
    <!-- Google Fonts for typography -->
    <link href="https://fonts.googleapis.com/css2?family=Inria+Sans:wght@400;700&family=Kalnia:wght@700&family=Meow+Script&display=swap" rel="stylesheet">
    <!-- Font Awesome for icons -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <!-- Link to external CSS file -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/collection.css">
</head>
<body>
    <jsp:include page="header.jsp" />

    <div class="product-container">
        <img src="${pageContext.request.contextPath}/resources/images/system/dress.png" alt="bg image" />
        <div class="text-section">
            <h1>ELEVATE YOUR STYLE</h1>
            <h2>FINAL CLEARANCE SALE</h2>
            <h3>Up to 30% OFF</h3>
        </div>
    </div>
	<div class="products">
	    <c:forEach var="coll" items="${collection}">
	        <div class="product-card">
	            <img src="${pageContext.request.contextPath}/resources/images/system/${coll.image}"/>
	            <h3>${coll.clothesName}</h3>
	            <div class="price">$${coll.price}</div>
	            <div class="rating">
	                <i class="fas fa-star"></i><i class="fas fa-star"></i>
	                <i class="fas fa-star"></i><i class="fas fa-star"></i>
	                <i class="fas fa-star-half-alt"></i>
	                <a>(4.5)</a>
	            </div>
	            <button class="shop-now-btn">Shop Now</button>
	        </div>
	    </c:forEach>
	</div>      

    <jsp:include page="footer.jsp" />
</body>
</html>
