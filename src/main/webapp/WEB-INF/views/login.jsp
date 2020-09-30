<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  <title>Haryana Staff Selection Commission</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="author" content="Clasified">
    <meta name="generator" content="Wordpress! - Open Source Content Management">
       

   
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

  <body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">    
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
               <li class="postadd">
                <a class="btn btn-success btn-post" style="width:100%" href="javascript:validateCount()"><span class="fa fa-check-square"></span>validate Bifurcation (Group-D)</a>
              </li>
            </ul>
          </div>
          <!-- Navbar End -->
        </div>
      </nav>
     

    <!-- Page Header Start -->
    <div class="page-header" style="background: url(resources/css/tel1.jpg);">
      <div class="container">
        <div class="row">         
          <div class="col-md-12">
            <div class="breadcrumb-wrapper">
             
             
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Page Header End --> 

    <!-- Content section Start --> 
    <section id="content">
      <div class="container">
        <div class="row">
          <div class="col-sm-6 col-sm-offset-4 col-md-4 col-md-offset-4">
            <div class="page-login-form box">
              <h3>
                Login to Portal
              </h3>
              <form:form role="form" class="login-form" id="loginUser" commandName="UserData" method="post">
              <input type="hidden" name="browserNameAndVersion" id="browserNameAndVersion">
               <p class="Error">${Success}</p>
                <p class="Error">${passwordChanged}</p>
               <p class="Error1">${failed}</p>
                <div class="form-group">
                  <div class="input-icon">
                    <i class="icon fa fa-user"></i>
                    <input type="text" id="sender-username" class="form-control" name="email" placeholder="Email" required>
                  </div>
                </div> 
                <div class="form-group">
                  <div class="input-icon">
                    <i class="icon fa fa-unlock-alt"></i>
                    <input type="password" class="form-control" name="userPassword"  placeholder="Password" required>
                  </div>
                </div>            
                <a class="btn btn-common log-btn" href="javascript:login()">Log In</a>
              </form:form>
               <ul class="form-links">
                <li class="pull-left"><a href="<c:url value="forgotPassword"/>">I forgot my password</a></li>
                 <li class="pull-right"><a href="<c:url value="signUp"/>">Register Yourself</a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Content section End --> 
    	
    	<!-- Copyright Start  -->
    	<div id="copyright">
    		<div class="container">
    			<div class="row">
    				<div class="col-md-12">
              <div class="site-info pull-left">
                <p>Designed and Developed by <a rel="nofollow"  target="_blank" href="http://hkcl.in">HKCL</a></p>
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
  <script>
    window.history.forward();
	function noBack() { window.history.forward(); }	
    </script> 
    
  <script>
     function login(){
    	 var geckobrowsers;
  		var browser = "";
  		var browserVersion = 0;
  		var agent = navigator.userAgent + " ";
  		if(agent.substring(agent.indexOf("Mozilla/")+8, agent.indexOf(" ")) == "5.0" && agent.indexOf("like Gecko") != -1){
  		    geckobrowsers = agent.substring(agent.indexOf("like Gecko")+10).substring(agent.substring(agent.indexOf("like Gecko")+10).indexOf(") ")+2).replace("LG Browser", "LGBrowser").replace("360SE", "360SE/");
  		    for(i = 0; i < 1; i++){
  		        geckobrowsers = geckobrowsers.replace(geckobrowsers.substring(geckobrowsers.indexOf("("), geckobrowsers.indexOf(")")+1), "");
  		    }
  		    geckobrowsers = geckobrowsers.split(" ");
  		    for(i = 0; i < geckobrowsers.length; i++){
  		        if(geckobrowsers[i].indexOf("/") == -1)geckobrowsers[i] = "Chrome";
  		        if(geckobrowsers[i].indexOf("/") != -1)geckobrowsers[i] = geckobrowsers[i].substring(0, geckobrowsers[i].indexOf("/"));
  		    }
  		    if(geckobrowsers.length < 4){
  		        browser = geckobrowsers[0];
  		    } else {
  		        for(i = 0; i < geckobrowsers.length; i++){
  		            if(geckobrowsers[i].indexOf("Chrome") == -1 && geckobrowsers[i].indexOf("Safari") == -1 && geckobrowsers[i].indexOf("Mobile") == -1 && geckobrowsers[i].indexOf("Version") == -1)browser = geckobrowsers[i];
  		        }
  		    }
  		    browserVersion = agent.substring(agent.indexOf(browser)+browser.length+1, agent.indexOf(browser)+browser.length+1+agent.substring(agent.indexOf(browser)+browser.length+1).indexOf(" "));
  		} else if(agent.substring(agent.indexOf("Mozilla/")+8, agent.indexOf(" ")) == "5.0" && agent.indexOf("Gecko/") != -1){
  		    browser = agent.substring(agent.substring(agent.indexOf("Gecko/")+6).indexOf(" ") + agent.indexOf("Gecko/")+6).substring(0, agent.substring(agent.substring(agent.indexOf("Gecko/")+6).indexOf(" ") + agent.indexOf("Gecko/")+6).indexOf("/"));
  		    browserVersion = agent.substring(agent.indexOf(browser)+browser.length+1, agent.indexOf(browser)+browser.length+1+agent.substring(agent.indexOf(browser)+browser.length+1).indexOf(" "));
  		} else if(agent.substring(agent.indexOf("Mozilla/")+8, agent.indexOf(" ")) == "5.0" && agent.indexOf("Clecko/") != -1){
  		    browser = agent.substring(agent.substring(agent.indexOf("Clecko/")+7).indexOf(" ") + agent.indexOf("Clecko/")+7).substring(0, agent.substring(agent.substring(agent.indexOf("Clecko/")+7).indexOf(" ") + agent.indexOf("Clecko/")+7).indexOf("/"));
  		    browserVersion = agent.substring(agent.indexOf(browser)+browser.length+1, agent.indexOf(browser)+browser.length+1+agent.substring(agent.indexOf(browser)+browser.length+1).indexOf(" "));
  		} else if(agent.substring(agent.indexOf("Mozilla/")+8, agent.indexOf(" ")) == "5.0"){
  		    browser = agent.substring(agent.indexOf("(")+1, agent.indexOf(";"));
  		    browserVersion = agent.substring(agent.indexOf(browser)+browser.length+1, agent.indexOf(browser)+browser.length+1+agent.substring(agent.indexOf(browser)+browser.length+1).indexOf(" "));
  		} else if(agent.substring(agent.indexOf("Mozilla/")+8, agent.indexOf(" ")) == "4.0" && agent.indexOf(")")+1 == agent.length-1){
  		    browser = agent.substring(agent.indexOf("(")+1, agent.indexOf(")")).split("; ")[agent.substring(agent.indexOf("(")+1, agent.indexOf(")")).split("; ").length-1];
  		} else if(agent.substring(agent.indexOf("Mozilla/")+8, agent.indexOf(" ")) == "4.0" && agent.indexOf(")")+1 != agent.length-1){
  		    if(agent.substring(agent.indexOf(") ")+2).indexOf("/") != -1)browser = agent.substring(agent.indexOf(") ")+2, agent.indexOf(") ")+2+agent.substring(agent.indexOf(") ")+2).indexOf("/"));
  		    if(agent.substring(agent.indexOf(") ")+2).indexOf("/") == -1)browser = agent.substring(agent.indexOf(") ")+2, agent.indexOf(") ")+2+agent.substring(agent.indexOf(") ")+2).indexOf(" "));
  		    browserVersion = agent.substring(agent.indexOf(browser)+browser.length+1, agent.indexOf(browser)+browser.length+1+agent.substring(agent.indexOf(browser)+browser.length+1).indexOf(" "));
  		} else if(agent.substring(0, 6) == "Opera/"){
  		    browser = "Opera";
  		    browserVersion = agent.substring(agent.indexOf(browser)+browser.length+1, agent.indexOf(browser)+browser.length+1+agent.substring(agent.indexOf(browser)+browser.length+1).indexOf(" "));
  		    if(agent.substring(agent.indexOf("(")+1).indexOf(";") != -1)os = agent.substring(agent.indexOf("(")+1, agent.indexOf("(")+1+agent.substring(agent.indexOf("(")+1).indexOf(";"));
  		    if(agent.substring(agent.indexOf("(")+1).indexOf(";") == -1)os = agent.substring(agent.indexOf("(")+1, agent.indexOf("(")+1+agent.substring(agent.indexOf("(")+1).indexOf(")"));
  		} else if(agent.substring(0, agent.indexOf("/")) != "Mozilla" && agent.substring(0, agent.indexOf("/")) != "Opera"){
  		    browser = agent.substring(0, agent.indexOf("/"));
  		    browserVersion = agent.substring(agent.indexOf(browser)+browser.length+1, agent.indexOf(browser)+browser.length+1+agent.substring(agent.indexOf(browser)+browser.length+1).indexOf(" "));
  		} else {
  		    browser = agent;
  		}
  		/* alert(browser + " v" + browserVersion); */
  		var browserNameAndVersion=browser + " v" + browserVersion;
  		
  	   document.getElementById('browserNameAndVersion').value=browserNameAndVersion; 
       document.getElementById('loginUser').action="login";
       document.getElementById('loginUser').submit();
     }
     
     function validateCount(){
    		document.getElementById('loginUser').target='Validate Requisitions';	
    		document.getElementById('loginUser').onsubmit = window.open("about:blank","Validate Requisitions", "width=1000,height=600");
    		document.getElementById('loginUser').action = "readOnlyReq";
    		document.getElementById('loginUser').submit();
    		}
  </script>  
    
  </body>
  </html>