<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="author" content="Clasified">
    <meta name="generator" content="Wordpress! - Open Source Content Management">
    <title>Haryana Staff Selection Commission</title>    

   
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css">    
    <link rel="stylesheet" href="resources/css/jasny-bootstrap.min.css" type="text/css">    
    <!-- Material CSS -->
    <link rel="stylesheet" href="resources/css/material-kit.css" type="text/css">
    <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="resources/css/font-awesome.min.css" type="text/css">
        <!-- Line Icons CSS -->
    <link rel="stylesheet" href="resources/fonts/line-icons/line-icons.css" type="text/css">
    <!-- Main Styles -->
    <link rel="stylesheet" href="resources/css/main.css" type="text/css">
    <!-- Animate CSS -->
    <link rel="stylesheet" href="resources/extras/animate.css" type="text/css">
    <!-- Owl Carousel -->
    <link rel="stylesheet" href="resources/extras/owl.carousel.css" type="text/css">
    <link rel="stylesheet" href="resources/extras/owl.theme.css" type="text/css">    
    <!-- Responsive CSS Styles -->
    <link rel="stylesheet" href="resources/css/responsive.css" type="text/css">
    <!-- Slicknav js -->
    <link rel="stylesheet" href="resources/css/slicknav.css" type="text/css">
        <!-- Bootstrap Select -->
    <link rel="stylesheet" href="resources/css/bootstrap-select.min.css">
    <style> .carousel-inner > .item > img{ width:100%; height:208px; } </style>
  </head>
  <body>
  <nav class="navbar navbar-default main-navigation" role="navigation">
        <div class="container">
          <div class="navbar-header">
            <!-- Stat Toggle Nav Link For Mobiles -->
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <!-- End Toggle Nav Link For Mobiles -->
            <a class="navbar-brand logo" href="#"><img src="assets/images/gallery/hssclogo2.png" alt=""></a>
          </div>
          <!-- brand and toggle menu for mobile End -->

          <!-- Navbar Start -->
          <div class="collapse navbar-collapse" id="navbar">
		   <ul class="nav navbar-nav navbar-left">  
			    <li class="top-heading">Haryana Staff Selection Commission</li>
			</ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="<c:url value="login"/>"><i class="lnr lnr-enter"></i> Login</a></li>
             <%--  <li><a href="<c:url value="register"/>"><i class="lnr lnr-user"></i> Signup</a></li> --%>
              <li class="postadd">
                <a class="btn btn-danger btn-post" href="<c:url value="contact"/>"><span class="fa fa-plus-circle"></span>contact</a>
              </li>
            </ul>
          </div>
          <!-- Navbar End -->
        </div>
      </nav>
      <section id="content">
      <div class="container">
        <div class="row">
          <div class="col-sm-6 col-sm-offset-4 col-md-4 col-md-offset-41">
            <div class="page-login-form box">
               	 <h3>Contact Us</h3>  
                       <p><b>Haryana Staff Selection Commission</b></p>
                       <p> Bays No. 67-70, Sector-2, Panchkula, Haryana 134151</p>
                       <p>Phone: 0172 514 3700</p>
                       <p>Email:</p> 
                       <p>website:http://www.hssc.gov.in/</p>    
                       <br> 
               <div id="googleMap"></div>
            </div>
           </div>
         </div>
        </div>
<!--         <div class="container"> -->
<!--         <div class="row"> -->
<!--           <div class="col-sm-6 col-sm-offset-4 col-md-4 col-md-offset-4"> -->
<!--              <div class="page-login-form box"> -->
<!--              <div id="googleMap"></div> -->
<!--              </div> -->
<!--             </div> -->
<!--          </div> -->
<!--         </div> -->
        </section>
      <!-- Copyright Start  -->
    	<div id="copyright">
    		<div class="container">
    			<div class="row">
    				<div class="col-md-12">
              <div class="site-info pull-left">
                <p>Designed and Developed by <a rel="nofollow" target="_blank" href="http://hkcl.in">HKCL</a></p>
              </div>    					
              <div class="bottom-social-icons social-icon pull-right">  
                <a class="facebook" target="_blank" href="https://www.facebook.com/hkcl.india"><i class="fa fa-facebook"></i></a> 
                <a class="twitter" target="_blank" href="https://twitter.com/HKCLHaryana"><i class="fa fa-twitter"></i></a>
                <a class="youtube" target="_blank" href="https://www.youtube.com/channel/UCFz24fAzovJgl8XpS3pSIxA/videos"><i class="fa fa-youtube"></i></a>
                <a class="linkedin" target="_blank" href="https://www.linkedin.com/company/13452035/"><i class="fa fa-linkedin"></i></a>
              </div>
    				</div>
    			</div>
    		</div>
    	</div>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAMGUAWVRFzu0CNxLHk3nPpfHi5mgcmM1c"></script>
 <script>
        var myCenter = new google.maps.LatLng(30.695696, 76.860031);

		function initialize() {
		var mapProp = {
		center:myCenter,
		zoom:15,
		scrollwheel:false,
		draggable:false,
		mapTypeId:google.maps.MapTypeId.ROADMAP
		};

		var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

		var marker = new google.maps.Marker({
		position:myCenter,
		});

		marker.setMap(map);
		}
		google.maps.event.addDomListener(window, 'load', initialize);
</script>
<script>
$(document).ready(function(){
    // Initialize Tooltip
    $('[data-toggle="tooltip"]').tooltip(); 
})
</script>
  </body>
  </html>