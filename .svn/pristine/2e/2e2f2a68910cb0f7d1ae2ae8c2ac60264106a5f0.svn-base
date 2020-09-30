<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
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
    
    <script src="https://code.jquery.com/jquery-1.7.min.js"></script> 

   
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
              Create New Password
              </h3>
              <form:form role="form" id="depListForm" class="login-form"  method="post">
                <p class="Error">${Success}</p>
                <p class="Error1">${failed}</p>
                 <input type="hidden" id="userId" name="userId" />
                <div class="form-group">
                  <div class="input-icon">
                    <i class="icon fa fa-user"></i>
                    <input type="text" id="sender-username" class="form-control" name="email" value="${userList.email}" placeholder="Registered Email" readonly>
                  </div>
                </div>  
                 <div class="form-group">
                  <div class="input-icon" id="myPassword">
                    <i class="icon fa fa-unlock-alt"></i>
                    <input type="password" id="sender-username" class="form-control" id="txtPassword" name="userPassword" 
                    maxlength="15"pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
                    title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" 
                    placeholder="New Password" autocomplete="new-password" required>
                    <input type="text" class="form-control" id="txthdnPassword" placeholder="New Password"/>
                  </div>
                 <%--  <div class="checkbox">
                       <input type="checkbox" id="remember" name="rememberme" value="forever" style="float: left;">
                       <label for="remember">Show Password</label>
                        <p class="Error1">${failed1}</p>
                 </div> --%>
                </div>                   
                <button class="btn btn-common log-btn" onclick="javascript:changePassword(${userList.userId});">Change</button>
              </form:form>
               <div id="pswd_info">
                     <h4>Password must meet the following requirements:</h4>
                        <ul>
                          <li id="letter" class="invalid">At least <strong>one letter</strong></li>
						  <li id="capital" class="invalid">At least <strong>one capital letter</strong></li>
						  <li id="number" class="invalid">At least <strong>one number</strong></li>
					      <li id="length" class="invalid">Be at least <strong>8 characters</strong> and max <strong>15 characters</strong></li>
                        </ul>
              </div>
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
	  <script type="text/javascript">
    
   function changePassword(userId){
	    document.getElementById('userId').value=userId;
     	document.getElementById('depListForm').action="saveNewPassword";
     	document.getElementById('depListForm').submit();
    } 
  </script>
   <script>
 $(document).ready(function() {
       
	 $('input[type=password]').keyup(function() {
		 var pswd = $(this).val();
		 if (pswd.length==null || pswd.length < 8) {
			    $('#length').removeClass('valid').addClass('invalid');
			} else {
			    $('#length').removeClass('invalid').addClass('valid');
			}
		 if ( pswd.match(/[A-z]/) ) {
			    $('#letter').removeClass('invalid').addClass('valid');
			} else {
			    $('#letter').removeClass('valid').addClass('invalid');
			}

			//validate capital letter
			if ( pswd.match(/[A-Z]/) ) {
			    $('#capital').removeClass('invalid').addClass('valid');
			} else {
			    $('#capital').removeClass('valid').addClass('invalid');
			}

			//validate number
			if ( pswd.match(/\d/) ) {
			    $('#number').removeClass('invalid').addClass('valid');
			} else {
			    $('#number').removeClass('valid').addClass('invalid');
			}
		}).focus(function() {
		    $('#pswd_info').show();
		}).blur(function() {
		    $('#pswd_info').hide();
		});
	});
   $(document).bind("contextmenu",function(e) {
	 e.preventDefault();
	});	
   $(document).keydown(function(e){
	    if(e.which === 123){
	       return false;
	    }
	});
   
   $('#txthdnPassword').hide();
   $('#txthdnPassword').attr('readonly','readonly');

   $('#txtPassword').blur(function() {
	   
   $('#txthdnPassword').val($(this).val());
   
   $('#remember').change(function() {
	   
	     var isChecked = $(this).prop('checked');
	   
	     if (isChecked) {
	   
	        $('#txtPassword').hide();
	   
	        $('#txthdnPassword').show();
	   
	     }
	   
	     else {
	   
	        $('#txtPassword').show();
	   
	        $('#txthdnPassword').hide();

	     }
	   
	   });
  })
  $(document).ready(function() {

    $('#txthdnPassword').hide();

    $('#txthdnPassword').attr('readonly','readonly');
    $('#txtPassword').blur(function() {

        $('#txthdnPassword').val($(this).val());

    });

 

    $('#remember').change(function() {

        var isChecked = $(this).prop('checked');

        if (isChecked) {

            $('#txtPassword').hide();

            $('#txthdnPassword').show();

        }

        else {

            $('#txtPassword').show();

            $('#txthdnPassword').hide();

        }

    });

});

 </script>
  </body>
  </html>