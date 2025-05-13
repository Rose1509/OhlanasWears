<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Oh Lana's Wears</title>
        <!-- Google Fonts for typography -->
        <link href="https://fonts.googleapis.com/css2?family=Inria+Sans:wght@400;700&family=Kalnia:wght@700&family=Meow+Script&display=swap" rel="stylesheet">
        <!-- Font Awesome for icons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
        <!-- Link to external CSS file -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <div class="background-container">
            <img src="${pageContext.request.contextPath}/resources/images/system/homeimg.png" alt="background image" />

            <section class="heading">
                <h2>Best Collection</h2>
                <p>FOR THIS SUMMER</p>
                <div class="sale">SALE UP TO 30% OFF</div>
                <a href="collection" class="shopbtn">SHOP NOW</a>
            </section>

            <section class="description">
                <p>Dive into our handpicked selection of stylish pieces that transform your wardrobe.
                Whether you're seeking breezy summer outfits or snug winter essentials, discover the perfect look for every moment.</p>
            </section>
        </div>

        <!-- Featured Categories Section -->
        <section class="featured-categories">
            <div class="category-container">
                <!-- Left category item (T-shirt) -->
                <div class="category-item left">
                    <div class="category-image">
                        <img src="${pageContext.request.contextPath}/resources/images/system/img.png" alt="T-shirt Collection">
                    </div>
                    <div class="category-info">
                        <h3 class="category-type">T-shirt</h3>
                        <h4 class="category-label">New</h4>
                        <p class="category-title">Collection</p>
                        <a href="collection" class="shop-btn">SHOP NOW</a>
                    </div>
                </div>

                <!-- Middle category item (slightly larger) -->
                <div class="category-item">
                    <div class="category-image">
                        <img src="${pageContext.request.contextPath}/resources/images/system/knittop.png" alt="Knit-Top Collection">
                    </div>
                    <div class="category-info">
                        <h3 class="category-type">Knit-Top</h3>
                        <h4 class="category-label">New</h4>
                        <p class="category-title">Collection</p>
                        <a href="collection" class="shop-btn">SHOP NOW</a>
                    </div>
                </div>

                <!-- Right category item (Denim) -->
                <div class="category-item right">
                    <div class="category-image">
                        <img src="${pageContext.request.contextPath}/resources/images/system/denim.png" alt="Denim Jacket Collection">
                    </div>
                    <div class="category-info">
                        <h3 class="category-type">Denim Jacket</h3>
                        <h4 class="category-label">New</h4>
                        <p class="category-title">Collection</p>
                        <a href="collection" class="shop-btn">SHOP NOW</a>
                    </div>
                </div>
            </div>
        </section>

        <div class="backgrounds-container">
            <img src="${pageContext.request.contextPath}/resources/images/system/flare.png" alt="background image" /> 
            
            <section class="flare">
                <h1>Meet the Marlow Flare</h1>
                <p>The new widest flare in the PAGE collection</p>
                <a href="collection" class="shopbutton">Go to the Collection</a>
            </section>
        </div>
        
        <%
        String success = request.getParameter("success");
        if ("true".equals(success)) {
        %>
            <script>
                alert("Logged into Home page successfully!");
            </script>
        <%
        }
        %>
 
        <jsp:include page="footer.jsp"/>
    </body>
</html>