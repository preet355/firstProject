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
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="assets/css/searchAlign.css" />
<!-- text fonts -->
<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />


<link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
<link rel="stylesheet" href="assets/css/chosen.min.css" />
<link rel="stylesheet" href="assets/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet" href="assets/css/bootstrap-timepicker.min.css" />
<link rel="stylesheet" href="assets/css/daterangepicker.min.css" />
<link rel="stylesheet"
	href="assets/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="assets/css/bootstrap-colorpicker.min.css" />
<link rel="stylesheet" href="assets/css/select2.min.css" />

<!-- ace styles -->
<link rel="stylesheet" href="assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />

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
.readOnly {
	pointer-events: none;
}
</style>
</head>

<body class="skin-1">
	<div id="navbar"
		class="navbar navbar-default          ace-save-state navbar-fixed-top">
		<div class="navbar-container ace-save-state" id="navbar-container">
			<button type="button" class="navbar-toggle menu-toggler pull-left"
				id="menu-toggler" data-target="#sidebar">
				<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span>

				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>

			<div class="navbar-header pull-left">
				<p class="navbar-brand">
					<small> Haryana Staff Selection Commission </small>
				</p>
			</div>
			<div class="pull-rightLogo" role="navigation">
				<small> <img src="assets/images/gallery/hssclogo2.png"
					alt="">
				</small>
			</div>
		</div>
	</div>

	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.loadState('main-container')
			} catch (e) {
			}
		</script>
		<div class="main-content">
			<div class="main-content-inner">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i>Check Bifurcation Count</li>
				</ul>
			</div>
			<div class="page-content">

				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->
						<div class="page-header">
							<h1>
								<c:choose>
									<c:when test='${requisitionForm[0].idRequisition!=null}'>
									    Edit Requisition <b>${requisitionForm[0].uniqueRequisitionNumber}</b>
									</c:when>
									<c:otherwise>
									     Check Bifurcation Count
									    </c:otherwise>
								</c:choose>
							</h1>
							<c:choose>
								<c:when test="${requisitionForm[0].status=='back referred'}">
									<a style="float: right; margin-top: -25px; margin-right: 10%;"
										class="btn btn-sm btn-grey"
										href="javascript:showBackReferredForm('${requisitionForm[0].idRequisition}')">Back
										Referred Info</a>
								</c:when>
							</c:choose>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<form:form name="registerRequisitionForm" id="requisitionForm"
									method="post" commandName="validateBifurcationObj">
									<input type="hidden" name="idRequisition" id="idRequisition"
										value="${requisitionForm[0].idRequisition}" />
									<input type="hidden" name="status" id="status"
										value="${requisitionForm[0].status}" />
									<table id="simple-table"
										class="table  table-bordered table-hover">
										<tbody>
											<tr>
												<td colspan="4"><label
													style="font-weight: 900; font-size: 14px;"> General Information
												</label></td>
											</tr>
											<tr>
												<td><label class="pos-rel"
													style="font-weight: 0; font-size: 12px;">
														Department<sup style="color: red;">*</sup>
												</label></td>

												<td><select name="dEpartmentId"
													class="formControl" id="deptDropDown"
													style="width: 200px;"
													data-placeholder="Search Department...">
														<option value="0">Search Department...</option>
														<c:forEach items="${deptList}" var="tag3"
															varStatus="loop">
															<option value="${tag3.dEpartmentId}"
																<c:set var="var1" value="${deptId}"/>
																<c:choose>
											                           <c:when test="${tag3.dEpartmentId==var1}">
											                           selected
											                           </c:when>
											                          </c:choose>>${tag3.dEpartment}</option>
														</c:forEach>
												</select> <%-- <input:select type="text" style="width:100%" name="designationOfPost" value="${requisitionForm[0].designationOfPost}"> --%>
												</td>
												<td><label class="pos-rel"
													style="font-weight: 0; font-size: 12px;">
														Field Office Name<sup style="color: red;">*</sup>
												</label></td>
												<td><input type="text" style="width: 100%"
													id=fieldOfficeName name="fieldOfficeName" value="${fieldOffice}"></td>

											</tr>
											<tr>
												<td><label class="pos-rel"
													style="font-weight: 0; font-size: 12px;"> Number of
														posts to be filled &nbsp<sup style="color: red;">*</sup>
												</label></td>
												<td><input type="text" style="width: 100%"
													id="noOfPosts" name="noofposts"
													onkeypress="return isNumberKey(event,'characters not allowed','Error1')"
													onchange="getbifucatedvalues()"
													value="${noOfPosts}">
													<br> <span style="color: red;" id="Error1"></span></td>
												<td><label class="pos-rel"
													style="font-weight: 0; font-size: 12px;"> Previous
														Roster Point Filled &nbsp<sup style="color: red;">*</sup>
												</label></td>
												<td><input type="text" style="width: 100%"
													id="previosuRosterPoint" name="previousrosterpoint"
													onkeypress="return isNumberKey(event,'characters not allowed','Error1')"
													onchange="getbifucatedvalues()"
													value="${prevRoasterPoint}">
													<br> <span style="color: red;" id="Error1"></span></td>

											</tr>


											<tr>
												<td colspan="4"><label
													style="font-weight: 900; font-size: 14px;"> Total
														Vacancies and vertical/horizontal reservation as per state
														policy </label><br> <label
													style="font-weight: 400; font-size: 12px; color: red">
														<i> Recruitment for SBC category has been stayed as
															per orders from High Court.</i>
												</label></td>
											</tr>
											<tr>
												<td colspan="4">
															<div id="secondTable">
																<table id="simple"
																	class="table  table-bordered table-hover">
																	<thead>
																		<tr>
																			<c:forEach items="${headersArr}" var="var"
																				varStatus="loop">
																				<th><c:out value="${var}" /></th>
																			</c:forEach>
																		</tr>
																	</thead>
																	<tbody>
																		<c:forEach items="${reqBifurcationList}" var="req"
																			varStatus="loop">
																			<tr>
																				<td rowspan="1"><c:out value="${req.category}" />
																				</td>
																				<td><c:out value="${req.totalCount}" /> </td>
																				<td>${req.nonEsmEspCount}</td>
																				<td>${req.esmCount}</td>
																				<td>${req.espCount}</td>
																			</tr>
																			
																		</c:forEach>
																		<tr>
																			<td><b>Total Calculated</b></td>
																			<td>
																				${noOfPosts}</td>
																		</tr>
																	</tbody>

																</table>
															</div>													
													</td>
											</tr>
									</table>
									<center>
										<a class="btn btn-sm btn-warning"
											href="javascript:calculate();">Calculate</a>
									</center>
									<center>
										<span style="color: red;" id="Error"></span>
									</center>
								</form:form>
							</div>
						</div>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-content -->

	<div class="footer">
		<div class="footer-inner">
			<div class="footer-content">
				<span class="bigger-120"> <span class="blue bolder">HKCL</span>
					Application
				</span> <span class="action-buttons"> <a
					href="https://twitter.com/HKCLHaryana" target="_blank"> <i
						class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
				</a> <a href="https://www.facebook.com/hkcl.india" target="_blank">
						<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
				</a> <a
					href="https://www.youtube.com/channel/UCFz24fAzovJgl8XpS3pSIxA/videos"
					target="_blank"> <i
						class="ace-icon fa fa-youtube-play red bigger-150"></i>
				</a> <a href="https://www.linkedin.com/company/13452035/"
					target="_blank"> <i
						class="ace-icon fa fa-linkedin-square blue bigger-150"></i>
				</a>
				</span>
			</div>
		</div>
	</div>

	<a href="#" id="btn-scroll-up"
		class="btn-scroll-up btn btn-sm btn-inverse"> <i
		class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
	</a>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->



	<script src="assets/js/jquery-2.1.4.min.js"></script>
	<script src="assets/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
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


	<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.1/js/select2.min.js"></script>
	<script src="assets/js/custom.min.js"></script>



	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		
			$(document).ready(function() {
				var data = document.getElementById(deptDropDown);
				$("#deptDropDown").select2({
					allowClear : true,
					data : data,
					placeholderOption : function() {
						return 'Please select...';
					}
				});
			});

	function calculate(){
		document.getElementById('requisitionForm').action = "saveReadOnlyReq";
		document.getElementById('requisitionForm').submit();	
		
	}
		
	</script>
</body>
<t
	=document.getElementById("noOfPostForBifurcation").value;

                                var
	totalPwd=Math.trunc((noOfPost*4)/100); tml>