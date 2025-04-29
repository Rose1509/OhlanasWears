<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <div class="product-card">
        	<img src="${pageContext.request.contextPath}/resources/images/system/jacket.png" alt="Vintage Leather Jacket" />
            <h3>Vintage Leather Jacket</h3>
            <div class="price">$250.890</div>
            <div class="rating">
                <i class="fas fa-star"></i><i class="fas fa-star"></i>
                <i class="fas fa-star"></i><i class="fas fa-star"></i>
                <i class="fas fa-star-half-alt"></i>
                <a>(4.5)</a>
            </div>
            	<button class="shop-now-btn">Shop Now</button>                        
        </div>

        <div class="product-card">
        	<img src="${pageContext.request.contextPath}/resources/images/system/knittopp.png" alt="Wool Blend Colorblock Top" />
            <h3>Wool Blend Colorblock Top</h3>
            <div class="price">$133.08</div>
            <div class="rating">
                <i class="fas fa-star"></i><i class="fas fa-star"></i>
                <i class="fas fa-star"></i><i class="fas fa-star"></i>
                <a>(4.0)</a>
            </div>
            	<button class="shop-now-btn">Shop Now</button>                        
        </div>

        <div class="product-card">
        	<img src="${pageContext.request.contextPath}/resources/images/system/flarejeans.png" alt="Flare Blue Jeans" />
            <h3>Flare Blue Jeans</h3>
            <div class="price">$90.88</div>
            <div class="rating">
                <i class="fas fa-star"></i><i class="fas fa-star"></i>
                <i class="fas fa-star"></i><i class="fas fa-star"></i>
                <i class="fas fa-star-half-alt"></i>
                <a>(4.2)</a>
            </div>
            	<button class="shop-now-btn">Shop Now</button>                        
        </div>

        <div class="product-card">
        	<img src="${pageContext.request.contextPath}/resources/images/system/poloshirt.png" alt="Waffle Knit Polo Shirt" />
            <h3>Waffle Knit Polo Shirt</h3>
            <div class="price">$90.88</div>
            <div class="rating">
                <i class="fas fa-star"></i><i class="fas fa-star"></i>
                <i class="fas fa-star"></i><i class="fas fa-star"></i>
                <i class="fas fa-star-half-alt"></i>
                <a>(4.1)</a>
            </div>
            	<button class="shop-now-btn">Shop Now</button>                        
        </div>

        <div class="product-card">
        	<img src="${pageContext.request.contextPath}/resources/images/system/silkshirt.png" alt="Off-White Silk Shirt" />
            <h3>Off-White Silk Shirt</h3>
            <div class="price">$75.00</div>
            <div class="rating">
                <i class="fas fa-star"></i><i class="fas fa-star"></i>
                <i class="fas fa-star"></i><i class="fas fa-star"></i>
                <i class="fas fa-star-half-alt"></i>
                <a>(4.3)</a>
            </div>
            	<button class="shop-now-btn">Shop Now</button>                        
        </div>

        <div class="product-card">
        	<img src="${pageContext.request.contextPath}/resources/images/system/denimjackets.png" alt="Oversize Denim Jacket" />
            <h3>Oversize Denim Jacket</h3>
            <div class="price">$250.670</div>
            <div class="rating">
                <i class="fas fa-star"></i><i class="fas fa-star"></i>
                <i class="fas fa-star"></i><i class="fas fa-star"></i>
                <a>(4.0)</a>
            </div>
            	<button class="shop-now-btn">Shop Now</button>                        
        </div>

        <div class="product-card">
        	<img src="${pageContext.request.contextPath}/resources/images/system/off-sholderdress.png" alt="Vintage Off Shoulder Dress" />
            <h3>Vintage Off Shoulder Dress</h3>
            <div class="price">$85.88</div>
            <div class="original-price">$99.99</div>
            <div class="rating">
                <i class="fas fa-star"></i><i class="fas fa-star"></i>
                <i class="fas fa-star"></i><i class="fas fa-star"></i>
                <i class="fas fa-star-half-alt"></i>
                <a>(4.4)</a>
            </div>
            	<button class="shop-now-btn">Shop Now</button>                        
        </div>

        <div class="product-card">
        	<img src="${pageContext.request.contextPath}/resources/images/system/flared.png" alt="Flared Off Shoulder T-Shirt" />
            <h3>Flared Off Shoulder T-Shirt</h3>
            <div class="price">$6.79</div>
            <div class="original-price">$20.00</div>
            <div class="rating">
                <i class="fas fa-star"></i><i class="fas fa-star"></i>
                <i class="fas fa-star"></i><i class="fas fa-star"></i>
                <i class="fas fa-star-half-alt"></i>
                <a>(4.2)</a>             
            </div>
            	<button class="shop-now-btn">Shop Now</button>                        
        </div>

        <div class="product-card">
        	<img src="${pageContext.request.contextPath}/resources/images/system/baggyjeans.png" alt="Washed Baggy Jeans" />
            <h3>Washed Baggy Jeans</h3>
            <div class="price">$96.79</div>
            <div class="rating">
                <i class="fas fa-star"></i><i class="fas fa-star"></i>
                <i class="fas fa-star"></i><i class="fas fa-star"></i>
                <i class="fas fa-star-half-alt"></i>
                <a>(4.3)</a>
                
            </div>
            	<button class="shop-now-btn">Shop Now</button>            
        </div>        
    </div>

    <jsp:include page="footer.jsp" />
</body>
</html>
