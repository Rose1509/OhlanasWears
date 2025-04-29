<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Oh Lana's Wears - About Us</title>
    <!-- Google Fonts for typography -->
    <link href="https://fonts.googleapis.com/css2?family=Inria+Sans:wght@400;700&family=Kalnia:wght@700&family=Meow+Script&display=swap" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <!-- Link to external CSS file -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/aboutus.css">
</head>
<body>
    <jsp:include page="header.jsp"/>
     <!-- Header Section -->
    <header class="header">
        <h1>WHO WE ARE</h1>
        <p>At Oh-Lana's Wears, we're not just about clothing - we're about confidence, comfort and creativity. We design pieces that empower your style and celebrate individuality.</p>
    </header>

	<div>
		<section class="description">
			<h2>Unveiling Your Unique Fashion Journey</h2>
            <p>At Oh - Lana's Wears, we’re all about making every season your favorite. For summer we bring you lightweight,
             breathable styles perfect for sunny days and beach vibes. When winter rolls around, our cozy, warm
             pieces keep you bundled up and looking great..</p>
        </section>
	</div>
	
    <div class="values-section">
        <div>
            <img src = "${pageContext.request.contextPath}/resources/images/system/aboutusimg.png"  alt="Portrait">
            <h3>What We Stand For</h3>
            <p><span class="highlight comfort">Comfort:</span><br>We believe in easygoing styles that feel great all day long.</p>
            <p><span class="highlight versatility">Versatility:</span><br>Our pieces are designed to adapt to your changing wardrobe needs.</p>
            <p><span class="highlight confidence">Confidence:</span><br>We celebrate individuality and self-expression through fashion.</p>
        </div>
        <div>
            <h3>Our Story</h3>
            <p>Founded in 2018, Oh-Lana’s Wears began with a simple yet powerful mission: to help you dress your best, every day of the year. 
            What started as a small idea has blossomed into a growing fashion destination, driven by creativity, comfort, and confidence.
			From day one, we set out to design clothing that speaks to real people living real lives—versatile pieces that transition 
			effortlessly from season to season, from casual to classy, from weekdays to weekends. We believe that fashion shouldn’t be 
			complicated—it should feel easy, empowering, and entirely you. At Oh-Lana’s Wears, each collection is thoughtfully crafted with timeless silhouettes, trend-conscious touches, and a deep love for quality. We take pride in creating styles that not only look good but also feel good—because your wardrobe should never slow you down, only lift you up.
			Today, Oh-Lana’s Wears stands as a symbol of style, simplicity, and self-expression. Whether you're dressing up or dressing down, 
			we’re here to make sure you feel confident in your skin and in your style.This is more than just fashion—it’s a lifestyle. 
			Welcome to Oh-Lana’s Wears. Let’s style every season, together.
            </p>
            <h3>Join The Movement</h3>
            <p>Be part of a community that embraces timeless style. Shop our new arrivals and refresh your look.</p>
            <a href="collection" class="button">Explore Our Collection</a>
            
        </div>
    </div>
	      
    
    <jsp:include page="footer.jsp"/>

</body>
</html>