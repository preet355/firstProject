<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="org.apache.commons.beanutils.*"%>
<!DOCTYPE html>
<html lang="en">
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
		<!-- text fonts -->
		<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />


		<link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
		<link rel="stylesheet" href="assets/css/chosen.min.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-datepicker3.min.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-timepicker.min.css" />
		<link rel="stylesheet" href="assets/css/daterangepicker.min.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.min.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-colorpicker.min.css" />
		<link rel="stylesheet" href="assets/css/select2.min.css" />

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
 		<style>
 		 .readOnly{
 		   pointer-events: none;
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
			</div>
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
					<c:choose>
						   <c:when test="${user.isAdmin=='N'}">
							  <li class="active"><a href="<c:url value="requisitionRegistration"/>">

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
								 Home
							</li>
							<li>
				                Advertisement Status Form
							</li>
						</ul>
					</div>
					<div class="page-content">
								<div class="page-header">
									<h1>
									    Advertisement Status Form
									</h1>
								</div>
						<div class="row">
							<div class="col-xs-12">
							<c:choose>
								<c:when test="${not empty failed}">
								<div class="alert alert-block alert-danger">
										<button type="button" class="close" data-dismiss="alert">
											<i class="ace-icon fa fa-times"></i>
										</button>
										<strong class="Red">
										    ${failed}
										 </strong>
									  <div class="space-4"></div>   
								</div>
								 </c:when>
								 <c:when test="${not empty success}">
								   <div class="alert alert-block alert-success">
										<button type="button" class="close" data-dismiss="alert">
											<i class="ace-icon fa fa-times"></i>
										</button>
										<strong class="Red">
										    ${success}
										 </strong>
									  <div class="space-4"></div>   
								</div>
								 </c:when>
								</c:choose>
							<form:form id="advtStatusForm" method="post">
							              <input type="hidden" id="pageNo" name="pageNo" />
     							     	  <input type="hidden" id="page" name="page" value="" /> 
     							     	  <input type="hidden" id="sort" name="sort" value="" />  
     							     	  <input type="hidden" id="pageSizeTotal" name="pageSizeTotal" value="${pageSizeTotal }" />
								<table align="center" id="simple-table" class="table  table-bordered table-hover" style="width:75%;">
										      <tbody>
										      <tr>
										        <td >
										         <label class="pos-rel" style="font-weight:0;font-size:12px;">
										           Designation &nbsp<sup style="color:red;">*</sup>&nbsp
										         </label>
										        </td>
										         <td>
										         <select name="postmasterId" class="formControl" id="desigDropDown" style="width:200px;"  data-placeholder="Search Designation...">
										                  <option value="0">Search Designation...</option>
														     <c:forEach items="${desigList}" var="tag3" varStatus="loop">
											                  <option value="${tag3.postmasterId}" 
											                  <c:set var="var1" value="${designation}"/><c:choose>
											                   <c:when test="${tag3.postmasterId==var1}">
											                         selected
											                    </c:when>
											                    </c:choose>>${tag3.postName}</option>	
											                  </c:forEach>
														 </select>	
												  <br>
													  <span style="color:red;" id="Error5"></span>		 
										        </td>
<!-- 										       </tr> -->
<!-- 										       <tr> -->
										         <td>
													<label class="pos-rel" style="font-weight:0;font-size:12px;">
														 Number of posts in direct quota &nbsp<sup style="color:red;">*</sup>&nbsp
												    </label>
													</td>
													<td>
													  <input type="text" style="width:100%" id="idnoOfPostInDirectQuata" name="noOfPostInDirectQuata" 
													  onkeypress="return isNumberKey(event,'characters not allowed','Error1')">
													  <br>
													  <span style="color:red;" id="Error1"></span>
													</td>
										       </tr>
										       
										       <tr>
										         <td>
													<label class="pos-rel" style="font-weight:0;font-size:12px;">
														 Number of vacant posts in direct quota &nbsp<sup style="color:red;">*</sup>&nbsp
												    </label>
													</td>
													<td>
													  <input type="text" style="width:100%" id="idnoOfVacantPostInDirectQuata" name="noOfVacantPostInDirectQuata" 
													  onkeypress="return isNumberKey(event,'characters not allowed','Error2')">
													  <br>
													  <span style="color:red;" id="Error2"></span>
													</td>
<!-- 										       </tr> -->
										       
<!-- 										       <tr> -->
										         <td>
													<label class="pos-rel" style="font-weight:0;font-size:12px;">
														 Number of posts for which requisition sent to HSSC &nbsp<sup style="color:red;">*</sup>&nbsp
												    </label>
													</td>
													<td>
													  <input type="text" style="width:100%" id="idnoOfPostSentToHSSC" name="noOfPostSentToHSSC" 
													  onkeypress="return isNumberKey(event,'characters not allowed','Error3')">
													  <br>
													  <span style="color:red;" id="Error3"></span>
													</td>
										       </tr>
										       
										       <tr>
										         <td>
													<label class="pos-rel" style="font-weight:0;font-size:12px;">
														Has advertisement been issued ? &nbsp<sup style="color:red;">*</sup>
												    </label>
													</td>
													<td>
													  <div class="col-xs-12 col-sm-9">
																	<div class="radio">
																		<label class="line-height-1" style="font-weight:0;font-size:12px;"> 
																			<input name="hasAdvtIssued" value="Y" id="hasAdvtYes" type="radio" onclick="showhide()">
																			<span class="lbl">Yes</span>
																		</label>
																	</div>

																	<div class="radio">
																		<label class="line-height-1" style="font-weight:0;font-size:12px;">
																			<input name="hasAdvtIssued" value="N" id="hasAdvtNo" type="radio" onclick="showhide()">
																			<span class="lbl"> No</span>
																		</label>
																	</div>
																	<br>
													                <span style="color:red;" id="Error6"></span>
																</div>													
													 
													</td>
													
													<td>
													<label class="pos-rel" style="font-weight:0;font-size:12px;">
														Has HSSC provided selection list ? &nbsp<sup style="color:red;">*</sup>
												    </label>
													</td>
													<td>
													  <div class="col-xs-12 col-sm-9">
																	<div class="radio">
																		<label class="line-height-1" style="font-weight:0;font-size:12px;"> 
																			<input name="hasHsscProvidedSelectionList" value="Y" type="radio">
																			<span class="lbl">Yes</span>
																		</label>
																	</div>

																	<div class="radio">
																		<label class="line-height-1" style="font-weight:0;font-size:12px;">
																			<input name="hasHsscProvidedSelectionList" value="N" type="radio">
																			<span class="lbl"> No</span>
																		</label>
																	</div>
																	<br>
													                <span style="color:red;" id="Error8"></span>
																</div>													
												      
														</td>
										       </tr>
										       
										       <tr id="doAdvt" style="display:none">
										          <td colspan='2'>
											      <label style="font-weight:0;font-size:12px;"> 
                                                       Date of Advertisement &nbsp<sup style="color:red;">*</sup>
												      </label>
											    </td>
											    <td colspan='2'>
											       <input name="dateOfAdvertisement" class="form-control date-picker" id="id-date-picker-1" style="width:50%" type="text">
											      <br>
													  <span style="color:red;" id="Error7"></span>
											    </td>
										       </tr>
										       
										       <tr>
										         <td>
													<label class="pos-rel" style="font-weight:0;font-size:12px;">
														Has offer of appointment been issued ? &nbsp<sup style="color:red;">*</sup>
												    </label>
													</td>
													<td>
													  <div class="col-xs-12 col-sm-9">
																	<div class="radio">
																		<label class="line-height-1" style="font-weight:0;font-size:12px;"> 
																			<input name="hasOfferOfAppoIssued" value="Y" type="radio">
																			<span class="lbl">Yes</span>
																		</label>
																	</div>

																	<div class="radio">
																		<label class="line-height-1" style="font-weight:0;font-size:12px;">
																			<input name="hasOfferOfAppoIssued" value="N" type="radio">
																			<span class="lbl"> No</span>
																		</label>
																	</div>
																	<br>
													                <span style="color:red;" id="Error9"></span>
																</div>													
													 
													</td>
										      <!--  </tr>
										       <tr> -->
										         <td>
													<label class="pos-rel" style="font-weight:0;font-size:12px;">
														 Number of posts for which appointment letter issued &nbsp<sup style="color:red;">*</sup>&nbsp
												    </label>
													</td>
													<td>
													  <input type="text" style="width:100%" id="idnoOfPostForWhichLetterIssued" name="noOfPostForWhichLetterIssued" 
													  onkeypress="return isNumberKey(event,'characters not allowed','Error4')">
													  <br>
													  <span style="color:red;" id="Error4"></span>
													</td>
										       </tr>
										      </tbody>
										      <tfoot>
										       <tr>
										         <td colspan='4'>
										         <div style="text-align:center">
										            <a class="btn btn-sm btn-warning" href="javascript:submitAdvtResponse();">Submit</a>
								                    <a class="btn btn-sm btn-warning" href="<c:url value="dashboard"/>">Cancel</a>
								                 </div>   
										         </td>
										       </tr>
										      </tfoot>
								</table> 
							</form:form>
							</div><!-- /.col -->
							  <display:table  id="dynamic-table" class="table table-striped table-bordered table-hover" excludedParams="*" 
									  requestURI="" name="advtStatusList"  
									   pagesize="${pageSize}" uid="tblPostList" cellspacing="0" >
									   <display:column property="postObj.postName" title="PostName"  sortable="true" ></display:column>
									   <display:column property="noOfPostInDirectQuata" title="Number Of Posts In Direct Quata"  sortable="true" ></display:column>
									   <display:column property="noOfVacantPostInDirectQuata" title="Number Of Vacant Posts In Direct Quata"  sortable="true" ></display:column>
									   <display:column property="noOfPostSentToHSSC" title="Number Of Posts For Which Requisition Sent To HSSC"  sortable="true" ></display:column>
									   <display:column property="hasAdvtIssued" title="Has Advertisement Been Issued(Y/N)"  sortable="true" ></display:column>
									   <display:column property="dateOfAdvertisement" title="Date Of Advertisement"  sortable="true" ></display:column>
									   <display:column property="hasHsscProvidedSelectionList" title="Has Hssc Provided Selection List(Y/N)"  sortable="true" ></display:column>
									   <display:column property="hasOfferOfAppoIssued" title="Has Offer Of Appointment Been Issued(Y/N)"  sortable="true" ></display:column>
									   <display:column property="noOfPostForWhichLetterIssued" title="Number Of Posts For Which Appointment Letter Issued"  sortable="true" ></display:column>
							  </display:table>
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


		
		<script src="assets/js/jquery-2.1.4.min.js"></script>
		<script src="assets/js/bootstrap-datepicker.min.js"></script>
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="assets/js/chosen.jquery.min.js"></script>
		<script src="assets/js/bootstrap.min.js"></script>
		<!-- page specific plugin scripts -->
		<script src="assets/js/wizard.min.js"></script>
		<script src="assets/js/jquery.validate.min.js"></script>
		<script src="assets/js/jquery-additional-methods.min.js"></script>
		
		<script src="assets/js/bootbox.js"></script>
		<script src="assets/js/jquery.maskedinput.min.js"></script>
		<script src="assets/js/select2.min.js"></script>
		
        <script src="assets/js/spin.js"></script>
		<!-- ace scripts -->
		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.1/js/select2.min.js"></script>	
		<script src="assets/js/custom.min.js"></script>
<!-- 		<script src="assets/customJS/custom.js"></script> -->
<script type="text/javascript">
$(document).ready(function() {	
	 var data = document.getElementById(desigDropDown);
	   $("#desigDropDown").select2({
		   allowClear: true,
			  data: data,
			  placeholderOption: function () { return 'Please select...';}
			});
	});

function submitAdvtResponse(){
	var validation=0;
	var elements = [
		 //'desigDropDown',
		 'idnoOfPostInDirectQuata',
		 'idnoOfVacantPostInDirectQuata',
		 'idnoOfPostSentToHSSC',
 		// 'id-date-picker-1',
		 'idnoOfPostForWhichLetterIssued'];
	
	var errors=[
		 //'Error5',
		 'Error1',
		 'Error2',
		 'Error3',
		 //'Error7',
		 'Error4'];
	
	var msg = [
		//'Designation',
		'The required info',
		'The required info',
		'The required info',
 	//	'The required info',
		'The required info'];
	
	var radioElements=['hasAdvtIssued','hasHsscProvidedSelectionList','hasOfferOfAppoIssued'];
	var radioErrors = ['Error6','Error8','Error9'];
	var radioMsg = ['The required info','The required info','The required info'];
	
	eleLength = elements.length;
	radioEleLength = radioElements.length;
	
	
	
	for (i = 0; i < eleLength; i++) {
		if (document.getElementById(elements[i]).value == "") {
			var error = elements[i];
			$("#" + error).focus();
			document.getElementById(errors[i]).innerHTML = "Please enter/select "
				+ msg[i];
		    document.getElementById(errors[i]).style.display = "Block";
		    validation=validation+1;
		}else{
			document.getElementById(errors[i]).innerHTML = "";
		}
	}
	
	for (i = 0; i < radioEleLength; i++) {
		
		var option = document.getElementsByName(radioElements[i]);
		if (!(option[0].checked || option[1].checked)) {
			var radioError = radioElements[i];
			$("#" + radioError).focus();
			document.getElementById(radioErrors[i]).innerHTML = "Please select "
					+ radioMsg[i];
			document.getElementById(radioErrors[i]).style.display = "Block";
			validation=validation+1;
		}else{
			document.getElementById(radioErrors[i]).innerHTML = "";
		}
	}
	if((null!=document.getElementById("hasAdvtYes"))&&(document.getElementById("hasAdvtYes").checked)){
		if(document.getElementById('id-date-picker-1').value == ""){
			document.getElementById('Error7').innerHTML = "Please enter/select The required info";
			document.getElementById('Error7').style.display = "Block";
			validation=validation+1;
		}
		
	}
	if(document.getElementById('desigDropDown').value =="0"){
		document.getElementById('Error5').innerHTML = "Please enter/select Designation";
		document.getElementById('Error5').style.display = "Block";
		validation=validation+1;
	}
	
	if(validation==0){
		
	  document.getElementById('advtStatusForm').action = "saveAdvtStatusFormForSpe";
	  document.getElementById('advtStatusForm').submit();
	}
}


function showhide(){
	if((null!=document.getElementById("hasAdvtYes"))&&(document.getElementById("hasAdvtYes").checked)){
		document.getElementById("doAdvt").style.display = "table-row";
	}
	if((null!=document.getElementById("hasAdvtNo"))&&(document.getElementById("hasAdvtNo").checked)){
		document.getElementById("doAdvt").style.display = "none";
	}
}


$('.date-picker').datepicker({
	autoclose: true,
	todayHighlight: true
})


 function goToPage(pageNo){
		//clicker();
		//var formName = document.getElementsByTagName('form')[0].id;
		document.getElementById('page').value=pageNo;
	    document.getElementById('advtStatusForm').action='advtStatusFormForSpe';
	    document.getElementById('advtStatusForm').target='';
	    document.getElementById('advtStatusForm').onsubmit = '';
		
		document.getElementsByTagName('form')[0].submit();
	}
	
function nextPrev(pageNo){
	//clicker();
	pageNumber = pageNo.substring(pageNo.lastIndexOf('=')+1);
	document.getElementById('page').value=pageNumber;
    document.getElementById('advtStatusForm').action='advtStatusFormForSpe';
    document.getElementById('advtStatusForm').target='';
    document.getElementById('advtStatusForm').onsubmit = '';
	
	//var formName = document.getElementsByTagName('form')[3].id;
	document.getElementsByTagName('form')[0].submit();
}
</script>

		<!-- inline scripts related to this page -->
	</body>
	</html>