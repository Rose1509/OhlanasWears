<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Oh Lana's Wears - Contact Us</title>
    <link href="https://fonts.googleapis.com/css2?family=Inria+Sans:wght@400;700&family=Kalnia:wght@700&family=Meow+Script&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/contactus.css">
</head>
<body>
    <jsp:include page="header.jsp"/>
    
    <div class="content">
        <section class="contact-section">
            <div class="model-image">        
                <img src="${pageContext.request.contextPath}/resources/images/system/contactimg.png" alt="Fashion model" />
            </div>
            <div class="contact-container">
                <h1>Contact Us</h1>
                <form class="contact-form" id="contactForm">
                    <div class="form-group">
                        <input type="text" id="full-name" placeholder="Full Name" required>
                    </div>
                    <div class="form-group">
                        <input type="email" id="email" placeholder="Email" required>
                    </div>
                    <div class="form-group">
                        <input type="text" id="subject" placeholder="Subject" required>
                    </div>
                    <div class="form-group">
                        <textarea id="message" placeholder="Your Message" rows="5" required></textarea>
                    </div>
                    <button type="submit" class="submit-btn">Contact Us</button>
                </form>
                
                <!-- Pop-up Box -->
                <div class="popup" id="popupMessage">
                    Message Sent!
                </div>
                
                <div class="get-in-touch">
                    <h2>Get In Touch</h2>
                    <p>We'd love to hear from you! Whether you have questions about our collections, sizing, or orders, we're here to help.</p>
                    <div class="contact-info">
                        <!-- Contact info remains unchanged -->
                    </div>
                    <div class="social-follow">
                        <p>Follow us on</p>
                        <div class="social-icons">
                            <a href="#"><i class="fab fa-twitter"></i></a>
                            <a href="#"><i class="fab fa-facebook-f"></i></a>
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="map-section">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d14257.771243632161!2d87.26!3d26.66!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x39ef6c66e8092dc7%3A0x58bed182958bc674!2sTarahara!5e0!3m2!1sen!2snp!4v1650000000000!5m2!1sen!2snp" 
                    width="100%" height="500" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
        </section>
    </div>    
    
    <jsp:include page="footer.jsp"/>

    <!-- JavaScript for Pop-up -->
    <script>
        document.getElementById('contactForm').addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent default form submission

            // Show the pop-up
            const popup = document.getElementById('popupMessage');
            popup.classList.add('show');

            // Hide the pop-up after 4 seconds
            setTimeout(function() {
                popup.classList.remove('show');
            }, 4000);

            // Optionally, reset the form
            this.reset();
        });
    </script>
</body>
</html>