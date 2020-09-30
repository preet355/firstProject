
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
 		
 		<link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet" />
 		<link href="https://cdn.datatables.net/fixedcolumns/3.2.6/css/fixedColumns.dataTables.min.css" rel="stylesheet" />
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
						    <li class="active open">
						       <a href="" class="dropdown-toggle">

								<i class="menu-icon fa fa-list"></i><span
								class="menu-text">Requisitions Reports</span>

						</a>
						  <b class="arrow"></b>
						  
						    <ul class="submenu">
							<li class="active">
								<a href="javascript:groupDReport('Group-D')">
									<i class="menu-icon fa fa-caret-right"></i>
									Group-D
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
						</li>
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
      		                          Department Wise Requisition Report
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
										  <form:form method="post" id="allRequisitions" >								 	
 										<input type="hidden" id="idRequisition" name="idRequisition" />  
										  <input type="hidden" id="pageNo" name="pageNo" />
     							     	  <input type="hidden" id="page" name="page" value="" /> 
     							     	  <input type="hidden" id="sort" name="sort" value="" />  
     							     	  <input type="hidden" id="pageSizeTotal" name="pageSizeTotal" value="${pageSizeTotal }" />
     							     	  <input type="hidden" id="actionString" name="actionString" value=""/>
     							     	  <input type="hidden" id="toformat" name="toformat" />
     							     	  <input type="hidden" name="Group" id="Group">
 	

									  <div>
									     <table id="example" class="stripe row-border order-column" style="width:100%">
									         <thead >
									           <tr>
									            <th>Department</th>
									            <th>Post name</th>
									            <th style="background-color: pink;">No. of Posts</th>
									            <th>General Total</th>
									            <th>General NONESMESP</th>
									            <th>General ESM</th>
									            <th>General ESP</th>
									            <th>SC Total</th>
									            <th>SC NONESMESP</th>
									            <th>SC ESM</th>
									            <th>SC ESP</th>
									            <th>BCA Total</th>
									            <th>BCA NONESMESP</th>
									            <th>BCA ESM</th>
									            <th>BCA ESP</th>
									            <th>BCB Total</th>
									            <th>BCB NONESMESP</th>
									            <th>BCB ESM</th>
									            <th>BCB ESP</th>
									            <th>SBC Total</th>
									            <th>SBC NONESMESP</th>
									            <th>SBC ESM</th>
									            <th>SBC ESP</th>
									            <th>EBPGC Total</th>
									            <th>EBPGC NONESMESP</th>
									            <th>EBPGC ESM</th>
									            <th>EBPGC ESP</th>
									            <th>PWD</th>
									           </tr>
									         </thead>
									         <tbody>
									           <c:forEach items="${allDeptRequisitions}" var="req" varStatus="loop">
									              <tr>
									                 <td >${req.departmentName}</td>
									                 <td>${req.postName}</td>
									                 <td style="text-align: center;background-color: pink;">${req.numberOfPostToBeFilled}</td>
									                 <td style="text-align: center;"><b>${req.generalTotal}</b></td>
									                 <td style="text-align: center;">${req.generalNonesmesp}</td>
									                 <td style="text-align: center;">${req.generalEsm}</td>
									                 <td style="text-align: center;">${req.generalEsp}</td>
									                 <td style="text-align: center;"><b>${req.scTotal}</b></td>
									                 <td style="text-align: center;">${req.scNonesmesp}</td>
									                 <td style="text-align: center;">${req.scEsm}</td>
									                 <td style="text-align: center;">${req.scEsp}</td>
									                 <td style="text-align: center;"><b>${req.bcaTotal}</b></td>
									                 <td style="text-align: center;">${req.bcaNonesmesp}</td>
									                 <td style="text-align: center;">${req.bcaEsm}</td>
									                 <td style="text-align: center;">${req.bcaEsp}</td>
									                 <td style="text-align: center;"><b>${req.bcbTotal}</b></td>
									                 <td style="text-align: center;">${req.bcbNonesmesp}</td>
									                 <td style="text-align: center;">${req.bcbEsm}</td>
									                 <td style="text-align: center;">${req.bcbEsp}</td>
									                 <td style="text-align: center;"><b>${req.sbcTotal}</b></td>
									                 <td style="text-align: center;">${req.sbcNonesmesp}</td>
									                 <td style="text-align: center;">${req.sbcEsm}</td>
									                 <td style="text-align: center;">${req.sbcEsp}</td>
									                 <td style="text-align: center;"><b>${req.ebpgcTotal}</b></td>
									                 <td style="text-align: center;">${req.ebpgcNonesmesp}</td>
									                 <td style="text-align: center;">${req.ebpgcEsm}</td>
									                 <td style="text-align: center;">${req.ebpgcEsp}</td>
									                 <td style="text-align: center;">${req.totalPwd}</td>
									              </tr>
									           </c:forEach>
									         </tbody>
									         <tfoot>
									            <tr>
									            <th></th>
									             <th>Total No. Of Posts:</th>
									             <th style="text-align: center;background-color: pink;">${totalNoOfPosts}</th>
									             <th style="text-align: center;">${generalTotal}</th>
									             <th style="text-align: center;">${generalNonesmesp}</th>
									             <th style="text-align: center;">${generalesm}</th>
									             <th style="text-align: center;">${generalesp}</th>
									             <th style="text-align: center;">${scTotal}</th>
									             <th style="text-align: center;">${scNonesmesp}</th>
									             <th style="text-align: center;">${scesm}</th>
									             <th style="text-align: center;">${scesp}</th>
									             <th style="text-align: center;">${bcaTotal}</th>
									             <th style="text-align: center;">${bcaNonesmesp}</th>
									             <th style="text-align: center;">${bcaesm}</th>
									             <th style="text-align: center;">${bcaesp}</th>
									             <th style="text-align: center;">${bcbTotal}</th>
									             <th style="text-align: center;">${bcbNonesmesp}</th>
									             <th style="text-align: center;">${bcbesm}</th>
									             <th style="text-align: center;">${bcbesp}</th>
									             <th style="text-align: center;">${sbcTotal}</th>
									             <th style="text-align: center;">${sbcNonesmesp}</th>
									             <th style="text-align: center;">${sbcesm}</th>
									             <th style="text-align: center;">${sbcesp}</th>
									             <th style="text-align: center;">${ebpgcTotal}</th>
									             <th style="text-align: center;">${ebpgcNonesmesp}</th>
									             <th style="text-align: center;">${ebpgcesm}</th>
									             <th style="text-align: center;">${ebpgcesp}</th>
									             <th style="text-align: center;">${pwdTotal}</th>
									            </tr>
									         </tfoot>
									     </table>
									   
										 </div>	
									</form:form>
									
</div>
								    </div>
								    <div class="box-footer">
										<div class="row">
											<div class="col-xs-8">
												&emsp; <a href="javascript:searchCalculatedPointsExcelReport('Group-D')" id="exportExcelBtn" onclick=""
													class="btn btn-white btn-yellow btn-sm no-border">Export To Excel</a>
											</div>
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
									
		

 
 
 <!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="assets/js/jquery-2.1.4.min.js"></script>
<!-- <script src="https://code.jquery.com/jquery-3.3.1.js"></script> -->

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
    var table = $('#example').DataTable( {
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
</script>

<script>
function searchCalculatedPointsExcelReport(Group){
	document.getElementById("Group").value=Group;
	 document.getElementById("allRequisitions").action="exportExcelDeptwiseRequisition";
	 document.getElementById("allRequisitions").submit();	 
}
function groupDReport(Group){
	document.getElementById("Group").value=Group;
	document.getElementById('allRequisitions').action = "departmewiseReqReport";
	document.getElementById('allRequisitions').submit();
}
</script>

<script type="text/javascript">

$(document).ready(function() {	
 var data = document.getElementById(selectCat1);
   $("#selectCat1").select2({
	   allowClear: true,
		  data: data,
		  placeholderOption: function () { return 'Please select...';}
		});
});
</script>
	</body>
</html>
