<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="org.apache.commons.beanutils.*"%>
<html>
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
		
		<link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet" />
 		<link href="https://cdn.datatables.net/fixedcolumns/3.2.6/css/fixedColumns.dataTables.min.css" rel="stylesheet" />

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
 		
 		 <style>
        /* Ensure that the demo table scrolls */
    th, td { white-space: nowrap; } 
    div.dataTables_wrapper {
        width: 100%;
        margin: 0 auto;
    }
 
   th input {
        width: 90%;
    }
      </style>
 </head>
 <body  class="skin-1">
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
					</li>
					<li>
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
					
					<li class="active">
					 <a href="<c:url value="examsDetails"/>">
					 <c:set var="var" value="${module}"/>
					    <c:choose>
					      <c:when test="${var=='mis'}">
					         <i class="menu-icon fa fa-users"></i>
							<span class="menu-text">Exam Center Module</span>
					      </c:when>
					    </c:choose>
					 </a>
					</li>
					<c:set var="var" value="${module}"/>
					     <c:choose>
					    <c:when test="${var=='mis' && (user.idRole=='2' || user.idRole=='3')}">
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
						<li class=""><a href="<c:url value="allRegisteredRequisitions"/>">

								<i class="menu-icon fa fa-list"></i> <span
								class="menu-text">All Requisitions</span>

						</a></li>
						 <c:if test="${not empty user.hasSpe && user.hasSpe eq true}"> 
						 <li class=""><a href="<c:url value="advtStatusFormForSpe"/>">

								<i class="menu-icon fa fa-info-circle"></i> <span
								class="menu-text">Advt Status Report</span>

						</a></li>
						</c:if>
						<%-- <li class=""><a href="<c:url value="javascript:validateCount()"/>">

								<i class="menu-icon fa fa-check-square"></i> <span
								class="menu-text">Validate Bifurcation</span>

						</a></li> --%>
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
								Exam Center Module
							</li>

							<li>
							 <c:choose>
      		                          <c:when test="${user.isAdmin=='Y'}"> 
      		                         Allocation List
      		                          </c:when></c:choose>
      		                          <c:choose>
      		                           <c:when test="${user.isAdmin=='N'}">
								${deptInfo}
								</c:when>
								</c:choose>
								
							</li>
						</ul><!-- /.breadcrumb -->
					</div>
				
				<div class="page-content">

						<div class="row">
							<div class="col-xs-12">
							  <form:form method="post" id="allotmentList" target="_blank">
							  <input type="hidden" id="examId" name="examId" />
							   <div class="clearfix">
											<div class="pull-right tableTools-container"></div>
										</div>
										<div class="table-header">
											Alloted Invigilators
										</div>
										<div>
											<table  id="dynamic-table" class="stripe row-border order-column" style="width:100%">
											<thead>
													<tr>
													    <th>S.No</th>
														<th>Invigilator Name</th>
														<th>Invigilator Home District</th>
														<th>Invigilator Alloted District</th>
														<th>Exam Center Name</th>
													</tr>
											</thead>		
													<tbody>
													<c:forEach items="${allocationList}" var="list" varStatus="loop">
													 <tr>
													  <td>${loop.index+1}</td>
													  <td>${list.invigilatorName}</td>
													  <td>${list.invigilatorDistrict}</td>
													  <td>${list.allotedExamCenterDistrict}</td>
													  <td>${list.allotedExamCenterName}</td>
													 </tr>
													</c:forEach>
													</tbody>
												 <tfoot>
												 <tr>
												    <td>
												     <button type="button" onclick="centerAllotmentList('${allocationList[0].examId}')" class="btn btn-white btn-purple btn-sm">Center Allotment Data</button>
												    </td>
												 </tr>
												 </tfoot>
											</table>
										</div>
							  </form:form>
							
							</div>
					    </div>
				</div>
							
				
				</div>
			</div>
		</div>
		<script src="assets/js/jquery-2.1.4.min.js"></script>
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
		
		<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/fixedcolumns/3.2.6/js/dataTables.fixedColumns.min.js"></script>
        
        <script>
$(document).ready(function() {
    // Setup - add a text input to each footer cell
   /*  $('#example tfoot th').each( function (i) {
        var title = $('#example thead th').eq( $(this).index() ).text();
        $(this).html( '<input type="text" placeholder="Search '+title+'" data-index="'+i+'" />' );
    } ); */
  
    // DataTable
    var table = $('#dynamic-table').DataTable( {
        scrollY:        "500px",
        scrollX:        true,
        scrollCollapse: true,
        paging:         true,
        fixedColumns:   false,
    } );
 
    // Filter event handler
    /* $( table.table().container() ).on( 'keyup', 'tfoot input', function () {
        table
            .column( $(this).data('index') )
            .search( this.value )
            .draw();
    } ); */
} );


function centerAllotmentList(examId){
	document.getElementById('examId').value=examId
	document.getElementById('allotmentList').action = "centerAllotmentList";
	document.getElementById('allotmentList').submit();
}
</script>
        
 </body>
</html>