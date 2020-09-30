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
    
    <link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
		    <link rel="stylesheet" href="assets/css/chosen.min.css" />
            <link rel="stylesheet" href="assets/css/select2.min.css" />
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
                Register to Portal
              </h3>
              <form:form role="form" class="login-form" name="validateUser" id="registerUser" commandName="UserData" method="post">
               <p class="Error">${Success}</p>
                <p class="Error">${passwordChanged}</p>
               <p class="Error1">${failed}</p>
               <span style="color:red;" id="Error"></span>
                 <div class="form-group">
                <select name="idDept" class="formControl" id="selectCat3" style="width:325px;" data-placeholder="Select Department...">
					   <option value="0">Select Department...</option>
					   <c:forEach items="${deptList}" var="tag3" varStatus="loop">
	                   <option value="${tag3.dEpartmentId}" 
					     <c:set var="var" value="${dEpartmentId}"/><c:choose>
					       <c:when test="${tag3.dEpartmentId==var}">
					        selected
					       </c:when>
					      </c:choose>>${tag3.dEpartment}</option>	
					      </c:forEach>
				</select>
			 </div>
               <div class="form-group">
                  <div class="input-icon">
                    <i class="icon fa fa-user"></i>
                    <input type="text" class="form-control" name="candidateName" placeholder="Full Name" value="${userObj.candidateName}" >
                  </div>
                </div> 
                <div class="form-group">
                  <div class="input-icon">
                    <i class="icon fa fa-user"></i>
                    <input type="text" class="form-control" name="userName" placeholder="UserName" value="${userObj.userName}"  >
                  </div>
                </div> 	
                 <div class="form-group">
                  <div class="input-icon">
                    <i class="icon fa fa-user"></i>
                    <input type="text" class="form-control" name="phoneNumber" placeholder="Mobile No."  maxlength="10" value="${userObj.phoneNumber}" onkeypress="return isNumberKey(event,'characters not allowed','Error')">
                  </div>
                </div> 	
                <div class="form-group">
                  <div class="input-icon">
                    <i class="icon fa fa-user"></i>
                    <input type="text"  class="form-control" name="email" placeholder="Email" value="${userObj.email}" >
                  </div>
                </div> 
               <div class="form-group">
                  <div class="input-icon">
                    <i class="icon fa fa-unlock-alt"></i>
                    <input type="password" class="form-control" name="userPassword"  placeholder="Password" >
                  </div>
                </div>    
                <a class="btn btn-common log-btn" href="javascript:registerUser()">Register</a>
              </form:form>
               <%-- <ul class="form-links">
                <li class="pull-left"><a href="<c:url value="forgotPassword"/>">I forgot my password</a></li>
              </ul> --%>
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
    	<script src="assets/js/jquery-2.1.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.1/js/select2.min.js"></script>
  
    <script>
    $(document).ready(function() {
    	var data = document.getElementById(selectCat3);
    	   $("#selectCat3").select2({
    		   allowClear: true,
    			  data: data,
    			  placeholderOption: function () { return "choose..";}
    			});
    	});
    </script>
    <script>
    window.history.forward();
	function noBack() { window.history.forward(); }	
    </script>
    <script>
    
    function isNumberKey(evt,msg,errId){
        var charCode = (evt.which) ? evt.which : event.keyCode
        var id=errId;
        if (charCode > 31 && (charCode< 48 || charCode>57)){
        	 document.getElementById(errId).innerHTML = msg;
            return false;
            }
        else{
        	document.getElementById(errId).innerHTML = "";
             return true;
        
        }
        
    }
     function registerUser(){
    	 var depart=document.validateUser.idDept.value;
    	 var CandidateName=document.validateUser.candidateName.value;
    	 var userName=document.validateUser.userName.value;
    	 var phoneNo=document.validateUser.phoneNumber.value;
    	 var email=document.validateUser.email.value;
    	 var password=document.validateUser.userPassword.value;
    	 
    	  if(depart=='' || depart==0){
    		  document.getElementById("Error").innerHTML = "Please Select Department";
  	   	      return false;
    	  }
    	  if(CandidateName==''){
    		  document.getElementById("Error").innerHTML = "Please Enter your Full Name";
    	
  	   	      return false;
    	  }
    	  if(userName==''){
    		  document.getElementById("Error").innerHTML = "Please Enter UserName";
    		 
  	   	      return false;
    	  }
    	  if(phoneNo==''){
    		  document.getElementById("Error").innerHTML = "Please Enter Mobile No.";
    		
  	   	      return false;
    	  }
    	  if(email==''){
    		  document.getElementById("Error").innerHTML = "Please Enter Email";
    		
  	   	      return false;
    	  }
    	  if(password==''){
    		  document.getElementById("Error").innerHTML = "Please Enter password";
    		 
  	   	      return false;
    	  }
    	  else{
    	 document.getElementById('registerUser').action='signUp';
         document.getElementById('registerUser').submit();       
        }
     }
    </script>
    
  </body>
  </html>