
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="org.apache.commons.beanutils.*"%>
<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Haryana Staff Selection Commission</title>

		<meta name="description" content="Static &amp; Dynamic Tables" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />
        <link rel="stylesheet" href="assets/css/searchAlign.css" />
		<!-- page specific plugin styles -->
			<link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
		    <link rel="stylesheet" href="assets/css/chosen.min.css" />
            <link rel="stylesheet" href="assets/css/select2.min.css" />
		<!-- text fonts -->
		<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="assets/js/ace-extra.min.js"></script>

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
 		<link href="assets/css/select2.min.css" rel="stylesheet" />
	</head>
	<body class="skin-1">
		<div id="navbar" class="navbar navbar-default          ace-save-state navbar-fixed-top">
			<div class="navbar-container ace-save-state" id="navbar-container">
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

			        <div class="navbar-header pull-left">
						<p class="navbar-brand">
							<small>
								Haryana Staff Selection Commission
							</small>
						</p>
					</div>
					<div class="pull-rightLogo" role="navigation">
						 <small>
							   <img src="assets/images/gallery/hssclogo2.png" alt="">
							</small>
					</div>
			</div><!-- /.navbar-container -->
		</div>

		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>

			<div id="sidebar" class="sidebar                  responsive                    ace-save-state sidebar-fixed sidebar-scroll">
				<script type="text/javascript">
					try{ace.settings.loadState('sidebar')}catch(e){}
				</script>


				<ul class="nav nav-list">
					<li class="">
						<c:set var="var" value="${module}"/>
					    <c:choose>
					    <c:when test="${var=='cc'}">
						<a href="<c:url value="dashboardForCourtCase"/>">						
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text"> Dashboard </span>
						</a>
						<b class="arrow"></b>
						</c:when></c:choose>
						<c:set var="var" value="${module}"/>
					    <c:choose>
					    <c:when test="${var=='mis'}">
						<a href="<c:url value="dashboard"/>">						
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text"> Dashboard </span>
						</a>
						<b class="arrow"></b>
						</c:when></c:choose>
						 <c:choose>
					    <c:when test="${var=='req'}">
						<a href="<c:url value="requisitionDashboard"/>">						
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text"> Dashboard </span>
						</a>
						<b class="arrow"></b>
						</c:when></c:choose>
					</li>
					 <c:set var="var" value="${module}"/>
					 <c:choose>
					   <c:when test="${var !='req'}">
					<li class="">
					<a href="<c:url value="allHSSCPostname"/>">
					<c:set var="var" value="${module}"/>
					    <c:choose>
					    <c:when test="${var=='mis'}">
					    <i class="menu-icon fa fa-list"></i>
							<span class="menu-text">Search Advt Details </span>
					    </c:when>
					     </c:choose>
					     <c:choose>
					    <c:when test="${var=='cc'}">
					        <i class="menu-icon fa fa-list"></i>
							<span class="menu-text">Add New Court Case </span>
					    </c:when>
					   </c:choose>
						</a>
					</li>
					  </c:when>
					</c:choose>
					<c:set var="var" value="${module}"/>
					     <c:choose>
					    <c:when test="${var=='mis' && user.idRole=='2'}">
					<li class="">
					   <a href="<c:url value="courtCaseSearch"/>">
						
							<i class="menu-icon fa fa-fw fa-bank"></i>
							<span class="menu-text"> Search Court Case</span>

						</a>	
					</li>
					    </c:when>
					   </c:choose>
					   <c:choose>
						   <c:when test="${user.isAdmin=='N'}">
							  <li class=""><a href="<c:url value="requisitionRegistration"/>">

								<i class="menu-icon fa fa-fw fa-plus-square-o"></i> <span
								class="menu-text">Add New Requisition</span>

						</a></li>
						<c:set var="var" value="${module}"/>
						<c:choose>	
						<c:when test="${var=='req' && user.idRole=='1'}">
						<li class="active"><a href="<c:url value="allRegisteredRequisitions"/>">

								<i class="menu-icon fa fa-list"></i> <span
								class="menu-text">All Requisitions</span>

						</a></li>
						</c:when>
						</c:choose>	
						<li class=""><a href="<c:url value="javascript:validateCount()"/>">

								<i class="menu-icon fa fa-check-square"></i> <span
								class="menu-text">Validate Bifurcation</span>

						</a></li>
							</c:when>
						</c:choose>
						<c:choose>
						   <c:when test="${user.isAdmin=='Y' && var=='req' && user.idRole=='1'}">
						        <li class="active"><a href="<c:url value="allRegisteredRequisitions"/>">

								<i class="menu-icon fa fa-list"></i> <span
								class="menu-text">All Requisitions</span>

						    </a></li>
						   </c:when>
						</c:choose>
					<li class="">
					<c:set var="var" value="${module}"/>
					<c:choose>
					<c:when test="${var=='cc'}">
					  <a href="<c:url value="courtCaseSearch"/>">
						
							<i class="menu-icon fa fa-fw fa-bank"></i>
							<span class="menu-text"> Search Court Case</span>

						</a>
					</c:when>
					</c:choose>
					</li>
						<c:choose>
						<c:when test="${var=='req' && user.idRole=='2'}">			
						    <li class="active"><a href="<c:url value="allReports"/>">

								<i class="menu-icon fa fa-list"></i><span
								class="menu-text">Requisitions Reports</span>

						</a></li>
						</c:when>
						</c:choose>
				</ul><!-- /.nav-list -->

				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
			</div>

			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state breadcrumbs-fixed" id="breadcrumbs">
					<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">

						<li class="light-blue dropdown-modal">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="assets/images/avatars/avatar2.png" alt="Jason's Photo" />
								<span class="user-info">
									<small>Welcome,</small>
									${user.userName}
								</span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								 <li>
									<a href="<c:url value="changePasswordInSession"/>">
										<i class="ace-icon fa fa-lock"></i>
										change Password
									</a>
								</li>
								<li>
									<a href="<c:url value="logout "/>">
										<i class="ace-icon fa fa-power-off"></i>
										Logout
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								Requisitions
							</li>

							<li>
							 <c:choose>
      		                          <c:when test="${user.isAdmin=='Y'}"> 
      		                          All Reports
      		                          </c:when></c:choose>
      		                          <c:choose>
      		                           <c:when test="${user.isAdmin=='N'}">
								${deptName}
								</c:when>
								</c:choose>
								
							</li>
						</ul><!-- /.breadcrumb -->
					</div>

					<div class="page-content">

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
                                     
								<div class="row">
									<div class="col-xs-12">
										

										<div class="clearfix">
											<div class="pull-right tableTools-container"></div>
										</div>
										  <form:form method="post" id="allRequisitions">								 	
 										<input type="hidden" id="idRequisition" name="idRequisition" />  
										  <input type="hidden" id="pageNo" name="pageNo" />
     							     	  <input type="hidden" id="page" name="page" value="" /> 
     							     	  <input type="hidden" id="sort" name="sort" value="" />  
     							     	  <input type="hidden" id="pageSizeTotal" name="pageSizeTotal" value="${pageSizeTotal }" />
     							     	  <input type="hidden" id="actionString" name="actionString" value=""/>
     							     	  <input type="hidden" id="toformat" name="toformat" />
 	

									  <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline no-footer">
									     <table class="table  table-bordered table-hover">
									         <thead>
									         <tr>
									             <th> 
									                Sr.no
									            </th>
									            <th> 
									                Description
									            </th>
									            <th> 
									                Action
									            </th>
									            </tr>
									         </thead>
									         <tbody>
									            <tr>
									                <td>
									                    1.
									                </td>
									                 <td> 
									                    Department wise Requisition Report
									                 </td>
									                 <td align="center">
									                    <a  href='<c:url value="departmewiseReqReport"></c:url>' title="Back Reffered Remarks"><i class="fa fa-list-alt bigger-120"></i></a>
									                 </td>
									                 
									            </tr>
									         </tbody>
									     </table>
									   
										 </div>	
									</form:form>
									
</div>
								    </div>



								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			<div class="footer">
				<div class="footer-inner">
					<div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">HKCL</span>
							Application 
						</span>
						<span class="action-buttons">
							<a href="https://twitter.com/HKCLHaryana" target="_blank">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="https://www.facebook.com/hkcl.india" target="_blank">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="https://www.youtube.com/channel/UCFz24fAzovJgl8XpS3pSIxA/videos" target="_blank">
								<i class="ace-icon fa fa-youtube-play red bigger-150"></i>
							</a>
							<a href="https://www.linkedin.com/company/13452035/" target="_blank">
								<i class="ace-icon fa fa-linkedin-square blue bigger-150"></i>
							</a>
						</span>
					</div>
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->
									
		
<script>

function searchRequisitions(){   
	   //document.getElementById('sort').value='';
	   //document.getElementById('action').value='allHSSCPostname';
	    document.getElementById('allRequisitions').action='allRegisteredRequisitions';
	    document.getElementById('allRequisitions').target='';
	    document.getElementById('allRequisitions').onsubmit = '';
        document.getElementById('allRequisitions').submit();
    
   
} 
   function viewRequisitionForm(idRequisition){
	   document.getElementById('idRequisition').value=idRequisition;
	   document.getElementById('allRequisitions').action="viewRequisitionForm";
	   document.getElementById('allRequisitions').submit();
   }
   
   function editRequisitionForm(idRequisition){
	   document.getElementById('idRequisition').value=idRequisition;
	   document.getElementById('allRequisitions').action="editRegisteredRequisitionForm";
	   document.getElementById('allRequisitions').submit();
   }
   
   function showBackReferredForm(idRequisition){
	   document.getElementById('idRequisition').value=idRequisition;
	   document.getElementById('allRequisitions').action="backReferred";
	   document.getElementById('allRequisitions').submit();
   }
   
   function goToPage(pageNo){
		//clicker();
		//var formName = document.getElementsByTagName('form')[0].id;
		document.getElementById('page').value=pageNo;
	    document.getElementById('allRequisitions').action='allRegisteredRequisitions';
	    document.getElementById('allRequisitions').target='';
	    document.getElementById('allRequisitions').onsubmit = '';
		
		document.getElementsByTagName('form')[0].submit();
	}
   
   function validateCount(){
		document.getElementById('allRequisitions').target='Validate Requisitions';	
		document.getElementById('allRequisitions').onsubmit = window.open("about:blank","Validate Requisitions", "width=1000,height=600");
		document.getElementById('allRequisitions').action = "readOnlyReq";
		document.getElementById('allRequisitions').submit();
		}

	function nextPrev(pageNo){
		//clicker();
		pageNumber = pageNo.substring(pageNo.lastIndexOf('=')+1);
		document.getElementById('page').value=pageNumber;
	    document.getElementById('allRequisitions').action='allRegisteredRequisitions';
	    document.getElementById('allRequisitions').target='';
	    document.getElementById('allRequisitions').onsubmit = '';
		
		//var formName = document.getElementsByTagName('form')[3].id;
		document.getElementsByTagName('form')[0].submit();
	}
	



  </script>
 
 
 <!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="assets/js/jquery-2.1.4.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="assets/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->
		<script src="assets/js/jquery.dataTables.min.js"></script>
		<script src="assets/js/jquery.dataTables.bootstrap.min.js"></script>
		<script src="assets/js/dataTables.buttons.min.js"></script>
		<script src="assets/js/buttons.flash.min.js"></script>
		<script src="assets/js/buttons.html5.min.js"></script>
		<script src="assets/js/buttons.print.min.js"></script>
		<script src="assets/js/buttons.colVis.min.js"></script>
		<script src="assets/js/dataTables.select.min.js"></script>
	
		<!-- ace scripts -->
		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.1/js/select2.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {	
 var data = document.getElementById(selectCat1);
   $("#selectCat1").select2({
	   allowClear: true,
		  data: data,
		  placeholderOption: function () { return 'Please select...';}
		});
});

$(document).ready(function() {
	var thArray = [];
	var tab = document.getElementById('tblPostList');
	var col1 = tab.rows[0].cells[0].getElementsByTagName('a')[0].getAttribute("href");
	var col2 = tab.rows[0].cells[1].getElementsByTagName('a')[0].getAttribute("href");
	var col3 = tab.rows[0].cells[2].getElementsByTagName('a')[0].getAttribute("href");
	var col4 = tab.rows[0].cells[3].getElementsByTagName('a')[0].getAttribute("href");
	var col5 = tab.rows[0].cells[4].getElementsByTagName('a')[0].getAttribute("href");
	var col6 = tab.rows[0].cells[5].getElementsByTagName('a')[0].getAttribute("href");
	var col7 = tab.rows[0].cells[6].getElementsByTagName('a')[0].getAttribute("href");
	
	//alert(col1);
	col1 = col1.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	col2 = col2.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	col3 = col3.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	col4 = col4.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	col5 = col5.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	col6 = col6.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	col7 = col7.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);

	tab.rows[0].cells[0].getElementsByTagName('a')[0].setAttribute("href",col1);
	tab.rows[0].cells[1].getElementsByTagName('a')[0].setAttribute("href",col2);
	tab.rows[0].cells[2].getElementsByTagName('a')[0].setAttribute("href",col3);
	tab.rows[0].cells[3].getElementsByTagName('a')[0].setAttribute("href",col4);
	tab.rows[0].cells[4].getElementsByTagName('a')[0].setAttribute("href",col5);
	tab.rows[0].cells[5].getElementsByTagName('a')[0].setAttribute("href",col6);
    tab.rows[0].cells[6].getElementsByTagName('a')[0].setAttribute("href",col7);});

</script>
	</body>
</html>
