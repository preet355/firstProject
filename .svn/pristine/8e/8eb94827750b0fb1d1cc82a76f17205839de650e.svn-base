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
					<li class="active">
					<a href="<c:url value="courtCaseSearch"/>">
						
							<i class="menu-icon fa fa-fw fa-bank"></i>
							<span class="menu-text"> Search Court Case</span>

						</a>
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
								 Advt of Court Case
							</li>

							<li>
							 ${policeDetailsList[0].aDvtNo}
								
							</li>
						</ul><!-- /.breadcrumb -->
					</div>
					<div class="page-content">

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="page-header">
									<h1>
									 <c:choose>
									  <c:when test="${courtCaseDetailsList[0].caseId==null}">
									  Add Court Case
									  </c:when>
									   <c:otherwise>
									    Edit Court Case
										<small>
											<i class="ace-icon fa fa-angle-double-right"></i>
											Writ No. ${courtCaseDetailsList[0].writNo}
										</small>
									   </c:otherwise>
									  </c:choose>
									</h1>
								</div><!-- /.page-header -->
                                         
								<div class="hr hr-18 hr-double dotted"></div>

								<form:form name="courtCaseForm" id="courtCaseForm" method="post"  action="updateCourtCaseDetails" commandName="courtCaseObj">
								 <input type="hidden" id="sRNo" name="sRNo" value="${policeDetailsList[0].sRNo}"/> 
								 <input type="hidden" id="caseId" name="caseId" value="${courtCaseDetailsList[0].caseId}"/>
								  <input type="hidden" id="advtNo" name="advtNo" value="${policeDetailsList[0].aDvtNo}"/>
								 <input type="hidden" id="uniqueCaseId" name="uniqueCaseId" value="${courtCaseDetailsList[0].uniqueCaseId}"/>

								<div class="widget-box">
									<div class="widget-header widget-header-blue widget-header-flat">
										<h4 class="widget-title lighter">Section A</h4>
                                             <small>
												<i class="ace-icon fa fa-angle-double-right"></i>
												General Information
											</small>
										<p style="color:red;"> ${failed}</p>
										<p style="color:red;"> ${hearingDateFailed}</p>
									</div>

									<div class="widget-body">
										<div class="widget-main">
											<div id="fuelux-wizard-container">
			                                    <div class="step-content pos-rel">
			                                         <table id="postDetailstbl" class="table  table-bordered table-hover">
									          												
											<tr>
													<th class="blue">Name of Department</th>
													<td ><input type="text" id="nonEdit" name="policeDetailsObj.deptObj.dEpartment" value="${policeDetailsList[0].deptObj.dEpartment}"></td>
											</tr>
											<tr>	
													<th class="blue">Advt. No.</th>
													<td ><input type="text" id="nonEdit" name="policeDetailsObj.aDvtNo" value="${policeDetailsList[0].aDvtNo}" ></td>													
											</tr>
											<tr>
													<th class="blue">Name of Post</th>
													<td ><input type="text" id="nonEdit" name="policeDetailsObj.nAmeOfPost" value="${policeDetailsList[0].nAmeOfPost}" ></td>
											</tr>
											
											<tr>
													<th class="blue">Cat. No.</th>
													<td ><input type="text" id="nonEdit" name="policeDetailsObj.cAtNo" value="${policeDetailsList[0].cAtNo}" ></td>
											</tr>
											
                                            <tr>    
                                                    <th class="blue">Status</th>
													<td>
													<select name="caseStatus" id="selectCat" class="dropdown"  style="width:170px;" data-placeholder="Select Status...">
													<c:set var="var" value="${courtCaseDetailsList[0].caseStatus}"/>
													
													<option value=""></option>
													<option 
													<c:choose>
					                           		<c:when test="${'Adj. sine die'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Adj. sine die</option>
					                         		 
													<option
													<c:choose>
					                           		<c:when test="${'Admitted'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>
													>Admitted</option>
													<option
													<c:choose>
					                           		<c:when test="${'Disposed off'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Disposed off</option>
													<option 
													<c:choose>
					                           		<c:when test="${'Dismissed'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Dismissed</option>
													<option
													<c:choose>
					                           		<c:when test="${'Allowed'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>
													>Allowed</option>
													<option 
													<c:choose>
					                           		<c:when test="${'In Process(In Hearing)'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>
													>In Process(In Hearing)</option>
													<option 
													<c:choose>
					                           		<c:when test="${'Reserved'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>
													>Reserved</option>

													</select>
													<span id="Error8"></span>
													</td>
										    </tr>
												
												</table>
			                                    </div>
			                                </div>
											
										</div><!-- /.widget-main -->
									</div><!-- /.widget-body -->
								</div>
                              <div class="widget-box">
									<div class="widget-header widget-header-blue widget-header-flat">
										<h4 class="widget-title lighter">Section B</h4>
                                             <small>
												<i class="ace-icon fa fa-angle-double-right"></i>
												Petition Details
											</small>
										
									</div>

									<div class="widget-body">
										<div class="widget-main">
											<div id="fuelux-wizard-container">
			                                    <div class="step-content pos-rel">
			                                         <table id="postDetailstbl" class="table  table-bordered table-hover">
			                                 <tr>		
													<th class="blue">Case Type</th>
													<td>
													<select name="caseType" id="selectCat7" value="${courtCaseDetailsList[0].caseType}" style="width:170px;" data-placeholder="select...">
													<c:set var="var" value="${courtCaseDetailsList[0].caseType}"/>
													<option value=""></option>
													<option<c:choose>
					                           		<c:when test="${'CWP'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>CWP</option>
													<option<c:choose>
					                           		<c:when test="${'LPA'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>LPA</option>
													<option<c:choose>
					                           		<c:when test="${'CM'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>CM</option>
													<option<c:choose>
					                           		<c:when test="${'SLP'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>SLP</option>
													<option<c:choose>
					                           		<c:when test="${'Complaint'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Complaint</option>
													<option<c:choose>
					                           		<c:when test="${'Civil Suit'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Civil Suit</option>
													<option<c:choose>
					                           		<c:when test="${'Civil Appeal'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Civil Appeal</option>
													<option<c:choose>
					                           		<c:when test="${'RSA'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>RSA</option>
													<option<c:choose>
					                           		<c:when test="${'COCP'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>COCP</option>
													<option<c:choose>
					                           		<c:when test="${'EA'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>EA</option>
													<option<c:choose>
					                           		<c:when test="${'RA'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>RA</option>
													</select>
													<span id="Error7"></span>
													</td>
                                            </tr>        
									  
											<tr>	
													<th class="blue">Case No.</th>
													<td >
													<input type="text" name="writNo" value="${courtCaseDetailsList[0].writNo}"  onkeypress="return isNumberKey(event,'characters not allowed','Error1')">
													 <span id="Error1"></span>
													</td>													
											</tr>
											<tr>
													<th class="blue">Year</th>
													<td >
													<input type="text" name="year" value="${courtCaseDetailsList[0].year}" onkeypress="return isNumberKey(event,'characters not allowed','Error2')" maxlength="4">
													<span id="Error2"></span>
													</td>
											</tr>
											 <tr>
			                                      <th class="blue">CM No. and Year</th>
			                                     <td>
			                                  <table id="cmNo"> 
												<tr>
												<td style="display:inline-block;"><a  id="more_fields2"  href="javascript:cmNoRow('civilMiscellaneousDetailsList','cmNo','cmYear','Year','CMNo');" >
												<i class="fa fa-plus-square" aria-hidden="true"></i></a>
												&nbsp<a id="more_fields" href="javascript:deleteRow('cmNo');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
												</td></tr>
												<c:forEach items="${courtCaseDetailsList[0].civilMiscellaneousDetailsList}" var="tag" varStatus="loop">
												<tr>			
												<td><INPUT type="checkbox" name="chk"/>
												  <input type="number"  name="civilMiscellaneousDetailsList[${loop.index}].cmNo" value="${tag.cmNo}" style="width:165px;margin:10px 0px 0px 10px" placeholder="CM No.">
												  </td>
											     <td>
											      <input type="number" name="civilMiscellaneousDetailsList[${loop.index}].cmYear" value="${tag.cmYear}" style="width:165px;margin-top:10px" placeholder="CM year">
												<input type="hidden" name="civilMiscellaneousDetailsList[${loop.index}].caseId" value="${courtCaseDetailsList[0].caseId}"/></td>
												</tr>
												</c:forEach>
												</table>
			                                     </td>
			                                 </tr>        
											
											<tr>
													<th class="blue">Paper Book Received</th>
													<td>
													<select name="paperBookReceived"  value="${courtCaseDetailsList[0].paperBookReceived}" id="selectCat1" style="width:170px;" data-placeholder="select ...">
													<c:set var="var" value="${courtCaseDetailsList[0].paperBookReceived}"/>
													<option value=""></option>
													<option<c:choose>
					                           		<c:when test="${'Yes'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Yes</option>
													<option<c:choose>
					                           		<c:when test="${'No'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>No</option>
													</select>
													</td>
											</tr>
												
												</table>
			                                    </div>
			                                </div>
											
										</div><!-- /.widget-main -->
									</div><!-- /.widget-body -->
								</div>
								
								<div class="widget-box">
									<div class="widget-header widget-header-blue widget-header-flat">
										<h4 class="widget-title lighter">Section c</h4>
                                             <small>
												<i class="ace-icon fa fa-angle-double-right"></i>
												Legal Details
											</small>
										
									</div>

									<div class="widget-body">
										<div class="widget-main">
											<div id="fuelux-wizard-container">
			                                    <div class="step-content pos-rel">
			                                         <table id="postDetailstbl" class="table  table-bordered table-hover">
									          												
											<tr>
													<th class="blue">File No.</th>
													<td><input type="text" name="fileNo" value="${courtCaseDetailsList[0].fileNo}" onkeypress="return isNumberKey(event,'characters not allowed','Error5')">
													<span id="Error5"></span>
													</td>
											</tr>
											<tr>	
													<th class="blue">Priority</th>
													<td >
													<select name="priority" id="selectCat10" value="${courtCaseDetailsList[0].priority}" style="width:170px;" data-placeholder="select...">
													<c:set var="var" value="${courtCaseDetailsList[0].priority}"/>
													<option value=""></option>
													<option<c:choose>
					                           		<c:when test="${'Urgent'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Urgent</option>
													<option<c:choose>
					                           		<c:when test="${'Ordinary'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Ordinary</option>
													</select>
													</td>													
											</tr>											
											<tr >
													<th class="blue">Name Of Court</th>
													<td >
													 <table id=caseIn>
													 <tr id="location">
													  <td>
														<select name="caseIn" id="selectCat9" onchange="getval(this.value,'courtLocation');" value="${courtCaseDetailsList[0].caseIn}" style="width:170px;" data-placeholder="select...">													
														<c:set var="var" value="${courtCaseDetailsList[0].caseIn}"/>
														<option value=""></option>
														<option<c:choose>
						                           		<c:when test="${'Supreme Court'==var}">
						                        		   selected
						                         		  </c:when>
						                         		 </c:choose>>Supreme Court</option>
														<option<c:choose>
						                           		<c:when test="${'High Court'==var}">
						                        		   selected
						                         		  </c:when>
						                         		 </c:choose>>High Court</option>
														<option<c:choose>
						                           		<c:when test="${'Civil Court'==var}">
						                        		   selected
						                         		  </c:when>
						                         		 </c:choose>>Civil Court</option>
														<option<c:choose>
						                           		<c:when test="${'Human Rights Court'==var}">
						                        		   selected
						                         		  </c:when>
						                         		 </c:choose>>Human Rights Court</option>
														</select>
													 </td>
													 <c:forEach items="${courtCaseDetailsList[0].courtLocation}" var="tag" varStatus="loop">
													 <td> 
													 <input type="text" name="courtLocation" value="${courtCaseDetailsList[0].courtLocation}" disabled>
													 </td>
													 </c:forEach>
													 </tr>
													</table>
													</td>
											</tr>
											<tr>
													<th class="blue">Legal Issue</th>
													<td >
<%-- 													    <input type="text" name="legalIssue" value="${courtCaseDetailsList[0].legalIssue}"> --%>
													    <table id=legalIssue>
													 <tr id="otherLegalIssue">
													  <td>
														<select name="legalIssue" id="selectCat16" onchange="getOtherLegalIssue(this.value,'otherLegalIssue');" value="${courtCaseDetailsList[0].legalIssue}" style="width:200px;" data-placeholder="select...">													
														<c:set var="var" value="${courtCaseDetailsList[0].legalIssue}"/>
														<option value=""></option>
														<option<c:choose>
						                           		<c:when test="${'Questions under challenge'==var}">
						                        		   selected
						                         		  </c:when>
						                         		 </c:choose>>Questions under challenge</option>
														<option<c:choose>
						                           		<c:when test="${'Change of category'==var}">
						                        		   selected
						                         		  </c:when>
						                         		 </c:choose>>Change of category</option>
														<option<c:choose>
						                           		<c:when test="${'Not eligible due to experience'==var}">
						                        		   selected
						                         		  </c:when>
						                         		 </c:choose>>Not eligible due to experience</option>
														<option<c:choose>
						                           		<c:when test="${'Not eligible due to qualification'==var}">
						                        		   selected
						                         		  </c:when>
						                         		 </c:choose>>Not eligible due to qualification</option>
						                         		 <option<c:choose>
						                           		<c:when test="${'Smudged OMR Sheet'==var}">
						                        		   selected
						                         		  </c:when>
						                         		 </c:choose>>Smudged OMR Sheet</option>
						                         		 <option<c:choose>
						                           		<c:when test="${'HTET issues'==var}">
						                        		   selected
						                         		  </c:when>
						                         		 </c:choose>>HTET issues</option>
						                         		 <option<c:choose>
						                           		<c:when test="${'Multiple Applications'==var}">
						                        		   selected
						                         		  </c:when>
						                         		 </c:choose>>Multiple Applications</option>
						                         		 <option<c:choose>
						                           		<c:when test="${'Marks less than cut-off'==var}">
						                        		   selected
						                         		  </c:when>
						                         		 </c:choose>>Marks less than cut-off</option>
						                         		 <option<c:choose>
						                           		<c:when test="${'Advertisement under challenge'==var}">
						                        		   selected
						                         		  </c:when>
						                         		 </c:choose>>Advertisement under challenge</option>
						                         		 <option<c:choose>
						                           		<c:when test="${'Other'==var}">
						                        		   selected
						                         		  </c:when>
						                         		 </c:choose>>Other</option>
														</select>
													 </td>
													 </tr>
													 <tr>
													    <c:forEach items="${courtCaseDetailsList[0].otherLegalIssue}" var="tag" varStatus="loop">
													 <td> 
													 <input type="text" name="otherLegalIssue" style="margin-top:10px;width:100%" value="${courtCaseDetailsList[0].otherLegalIssue}" >
													 </td>
													 </c:forEach> 
													 </tr>
													</table>	
													</td>
											</tr>
											<tr>		
												<th class="blue">Main/Similar Case</th>
													<td>
													<select name="main_similarCase" id="selectCat6"  style="width:170px;" data-placeholder="select...">
													<c:set var="var" value="${courtCaseDetailsList[0].main_similarCase}"/>
													<option value=""></option>
													<option
													 <c:choose>
					                           		<c:when test="${'Main'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Main</option>
													<option 
													<c:choose>
					                           		<c:when test="${'Similar'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Similar</option>
													</select>
													</td>
                                            </tr>
                                            <tr>
			                                      <th class="blue">Similar Case Info</th>
			                                     <td>
			                                          <table id="similarCase"> 
												<tr>
												<td style="display:inline-block;"><a  id="more_fields2"  href="javascript:add_similarCases('similarCasesList','similarCase','caseNo','similarCaseType','year');" >
												<i class="fa fa-plus-square" aria-hidden="true"></i></a>
												&nbsp<a id="more_fields" href="javascript:deleteRow('similarCase');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
												</td></tr>
												<c:forEach items="${courtCaseDetailsList[0].similarCasesList}" var="tag" varStatus="loop">
												<tr>			
												<td><INPUT type="checkbox" name="chk"/>
												  <input type="number"  name="similarCasesList[${loop.index}].caseNo" value="${tag.caseNo}" style="width:165px;margin:10px 0px 0px 10px" placeholder="Case No">
												  </td>
											     <td>
											     <select name="similarCasesList[${loop.index}].similarCaseType" id="selectCat13" value="${tag.similarCaseType}" style="width:165px;margin-top:10px" data-placeholder="select case Type...">
													<c:set var="var" value="${tag.similarCaseType}"/>
													<option value=""></option>
													<option<c:choose>
					                           		<c:when test="${'CWP'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>CWP</option>
													<option<c:choose>
					                           		<c:when test="${'LPA'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>LPA</option>
													<option<c:choose>
					                           		<c:when test="${'CM'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>CM</option>
													<option<c:choose>
					                           		<c:when test="${'SLP'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>SLP</option>
													<option<c:choose>
					                           		<c:when test="${'Complaint'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Complaint</option>
													<option<c:choose>
					                           		<c:when test="${'Civil Suit'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Civil Suit</option>
													<option<c:choose>
					                           		<c:when test="${'Civil Appeal'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Civil Appeal</option>
													<option<c:choose>
					                           		<c:when test="${'RSA'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>RSA</option>
													<option<c:choose>
					                           		<c:when test="${'COCP'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>COCP</option>
													<option<c:choose>
					                           		<c:when test="${'EA'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>EA</option>
													<option<c:choose>
					                           		<c:when test="${'RA'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>RA</option>
													</select>
											      </td>
											      <td><input type="number"  name="similarCasesList[${loop.index}].year" value="${tag.year}" style="width:165px;margin-top:10px" placeholder="Year">
												<input type="hidden" name="similarCasesList[${loop.index}].caseId" value="${courtCaseDetailsList[0].caseId}"/></td>
												</tr>
												</c:forEach>
												</table>
			                                     </td>
			                                 </tr>        
                                            <tr>    
                                                    <th class="blue">Concerned Assistant</th>
                                                     <td>
													<select name="concernedAssistant" id="selectCat2"  style="width:170px;" data-placeholder="Select...">
													<c:set var="var"  value="${courtCaseDetailsList[0].concernedAssistant}"/>
													<option value=""></option>
													<option 
													 <c:choose>
					                           		<c:when test="${'1 LA'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>1 LA</option>
													<option 
													 <c:choose>
					                           		<c:when test="${'2 LA'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>2 LA</option>
													<option 
													 <c:choose>
					                           		<c:when test="${'3 LA'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>3 LA</option>
													<option
													  <c:choose>
					                           		<c:when test="${'4 LA'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>4 LA</option>
													<option 
													 <c:choose>
					                           		<c:when test="${'5 LA'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>5 LA</option>
													<option 
													 <c:choose>
					                           		<c:when test="${'6 LA'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>6 LA</option>
													<option 
													 <c:choose>
					                           		<c:when test="${'7 LA'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>7 LA</option>
													<option
													 <c:choose>
					                           		<c:when test="${'8 LA'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>8 LA</option>
					                         		 <option
													 <c:choose>
					                           		<c:when test="${'9 LA'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>9 LA</option>
					                         		 <option
													 <c:choose>
					                           		<c:when test="${'10 LA'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>10 LA</option>
													</select>
												
													</td>
													 </tr>
												
												</table>
			                                    </div>
			                                </div>
											
										</div><!-- /.widget-main -->
									</div><!-- /.widget-body -->
								</div>
								 <div class="widget-box">
									<div class="widget-header widget-header-blue widget-header-flat">
										<h4 class="widget-title lighter">Section D</h4>
                                             <small>
												<i class="ace-icon fa fa-angle-double-right"></i>
												InProcess Details
											</small>
										
									</div>

								 <div class="widget-body">
										<div class="widget-main">
											<div id="fuelux-wizard-container">
			                                    <div class="step-content pos-rel">
			                                         <table id="postDetailstbl" class="table  table-bordered table-hover">
											
											<tr>
													<th class="blue">Letter received from (AG/LR/CS) ?</th>
													<td>
													<select name="letterReceivedFrom_Ag_Lr" id="selectCat8"   style="width:170px;" data-placeholder="select...">
														<c:set var="var"  value="${courtCaseDetailsList[0].letterReceivedFrom_Ag_Lr}"/>
													<option value=""></option>
													<option 
													<c:choose>
					                           		<c:when test="${'AG HRY'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>AG HRY</option>
													<option
													<c:choose>
					                           		<c:when test="${'LR HRY'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>
													>LR HRY</option>
													<option
													<c:choose>
					                           		<c:when test="${'CS HRY'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>
													>CS HRY</option>
													</select>
													</td>
											</tr>
											<tr>
													<th class="blue">Purpose Of Letter</th>
													<td>
													<select name="purposeOfLetter" id="selectCat15"   style="width:170px;" data-placeholder="select...">
														<c:set var="var"  value="${courtCaseDetailsList[0].purposeOfLetter}"/>
													<option value=""></option>
													<option 
													<c:choose>
					                           		<c:when test="${'Reply'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Reply</option>
													<option
													<c:choose>
					                           		<c:when test="${'Legal Opinion'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>
													>Legal Opinion</option>
													<option
													<c:choose>
					                           		<c:when test="${'Record'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>
													>Record</option>
													<option
													<c:choose>
					                           		<c:when test="${'Miscellaneous'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>
													>Miscellaneous</option>
													</select>
													</td>
											</tr>
											<tr>	
													<th class="blue">Letter Date</th>
													<td>
													
													<div class="input-group">
													<input type="text" id="datepicker3"  class="form-control date-picker" name="letterDate" value="${courtCaseDetailsList[0].letterDate}">
													<span class="input-group-addon">
													<i class="fa fa-calendar bigger-110"></i></span>
													</div>
													</td>													
											</tr>
											<tr>
													<th class="blue">Whether Reply Filed or Not</th>
													<td	>
													<select name="replyFrom_Ag_Lr" id="selectCat3"  style="width:170px;" data-placeholder="select...">
													<c:set var="var"  value="${courtCaseDetailsList[0].replyFrom_Ag_Lr}"/>
													<option value=""></option> 
													<option
													<c:choose>
					                           		<c:when test="${'No'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>
													>No</option>
													<option
													<c:choose>
					                           		<c:when test="${'Yes'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>
													>Yes</option>
													</select>
													<!-- <input type="text" name="replyFrom_Ag_Lr" value="" > -->
													</td>
											</tr>
											 <tr> 
												<th class="blue">Reply Filed Date </th> 
												<td>
												
												<div class="input-group">
												<input type="text" id="datepicker" class="form-control date-picker" name="replyFiledDate" value="${courtCaseDetailsList[0].replyFiledDate}" >
												<span class="input-group-addon">
														<i class="fa fa-calendar bigger-110"></i></span>
														</div></td> 
	 											</tr>
											<tr>
													<th class="blue">Reply Status</th>
													<td >
													<select name="replyFrom_Ag_LrStatus" id="selectCat4"  style="width:170px;" data-placeholder="select...">
													<c:set var="var"  value="${courtCaseDetailsList[0].replyFrom_Ag_LrStatus}"/>
													<option value=""></option>
													<option 
													<c:choose>
					                           		<c:when test="${'Short Reply'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Short Reply</option>
													<option
													<c:choose>
					                           		<c:when test="${'Detailed Reply'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Detailed Reply</option>
													<option
													<c:choose>
					                           		<c:when test="${'No Need to file Reply'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>No Need to file Reply</option>
													<option
													<c:choose>
					                           		<c:when test="${'Affidavit'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Affidavit</option>
													</select>
													<!-- <input type="text" name="replyFrom_Ag_Lr" value="" > -->
													</td>
											</tr>
											<tr>    
                                                    <th class="blue">Details Of Reply</th>
													<td ><input type="text" name="detailedReplyFrom_Ag_Lr" value="${courtCaseDetailsList[0].detailedReplyFrom_Ag_Lr}" ></td>
										    </tr>
											
											<tr>		
													<th class="blue">Whether Stay or Not </th>
													<td >
													<select name="stay" id="selectCat5"  style="width:170px;" data-placeholder="select...">
													<c:set var="var"  value="${courtCaseDetailsList[0].stay}"/>
													<option value=""></option>
													<option 
													<c:choose>
					                           		<c:when test="${'Stay'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Stay</option>
													<option 
													<c:choose>
					                           		<c:when test="${'No Stay'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>No Stay</option>
													<option 
													<c:choose>
					                           		<c:when test="${'Status Quo'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Status Quo</option>
													<option 
													<c:choose>
					                           		<c:when test="${'Stay Qua Petitioner'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Stay Qua Petitioner</option>
					                         		 <option 
													<c:choose>
					                           		<c:when test="${'Stay in favour of Haryana'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Stay in favour of Haryana</option>
					                         		 
					                         		  <option 
													<c:choose>
					                           		<c:when test="${'Process Halted'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Process Halted</option>
													</select>
													<!-- <input type="text" name="stay" value=""> -->
													<span id="Error4"></span>
													</td>
                                            </tr>
                                            <tr>    
                                                    <th class="blue">Stay Details</th>
													<td ><input type="text" name="stayDetails" value="${courtCaseDetailsList[0].stayDetails}" ></td>
										    </tr>
<!-- 										    <tr>     -->
<!--                                                     <th class="blue">Remarks/Interim Order</th> -->
<%-- 													<td ><input type="text" name="remarks_InterimOrder" value="${courtCaseDetailsList[0].remarks_InterimOrder}" ></td> --%>
<!-- 										    </tr> -->
										     <tr>
			                                      <th class="blue">Interim Order and Date</th>
			                                     <td>
			                                  <table id="fullInterimOrder"> 
												<tr>
												<td style="display:inline-block;"><a  id="more_fields2"  href="javascript:InterimOrderRow('interimOrderList','fullInterimOrder','interimOrderDate','InterimOrderDate','FullInterimOrder');">
												<i class="fa fa-plus-square" aria-hidden="true"></i></a>
												&nbsp<a id="more_fields" href="javascript:deleteRow('fullInterimOrder');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
												</td></tr>
												<c:forEach items="${courtCaseDetailsList[0].interimOrderList}" var="tag" varStatus="loop">
												<tr>			
												<td><INPUT type="checkbox" name="chk"/>
												  <input type="text"  name="interimOrderList[${loop.index}].fullInterimOrder" value="${tag.fullInterimOrder}" style="width:165px;margin:10px 0px 0px 10px" placeholder="FullInterimOrder">
												  </td>
											     <td>
											      <input type="text" class="form-control date-picker"  id="datepicker5" name="interimOrderList[${loop.index}].interimOrderDate" value="${tag.interimOrderDate}" style="width:165px;margin-top:10px" placeholder="interimOrderDate">
												<input type="hidden" name="interimOrderList[${loop.index}].caseId" value="${courtCaseDetailsList[0].caseId}"/></td>
												</tr>
												</c:forEach>
												</table>
			                                     </td>
			                                 </tr>        
											   
												</table>
			                                    </div>
			                                </div>
											
										</div>
									</div> 
								</div> 
								
								

<div class="widget-box">
									<div class="widget-header widget-header-blue widget-header-flat">
										<h4 class="widget-title lighter">Section E</h4>
                                             <small>
												<i class="ace-icon fa fa-angle-double-right"></i>
												Petitioner Details
											</small>
										
									</div>

								 <div class="widget-body">
										<div class="widget-main">
											<div id="fuelux-wizard-container">
			                                    <div class="step-content pos-rel">
			                                         <table id="postDetailstbl" class="table  table-bordered table-hover">
			                                 <tr>
			                                      <th class="blue">Petitioners Name & Roll No</th>
			                                     <td>
			                                          <table id="name"> 
												<tr>
												<td style="display:inline-block;"><a  id="more_fields2"  href="javascript:add_fields('petitionerDetailsList','name','rollNo','RollNo','PetitionerName');" >
												<i class="fa fa-plus-square" aria-hidden="true"></i></a>
												&nbsp<a id="more_fields" href="javascript:deleteRow('name');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
												</td></tr>
												<c:forEach items="${courtCaseDetailsList[0].petitionerDetailsList}" var="tag" varStatus="loop">
												<tr>			
												<td><INPUT type="checkbox" name="chk"/>
												  <input type="text"  name="petitionerDetailsList[${loop.index}].name" value="${tag.name}" style="width:165px;margin:10px 0px 0px 10px" placeholder="PetitionerName">
												  </td>
											     <td>
											      <input type="number"  name="petitionerDetailsList[${loop.index}].rollNo" value="${tag.rollNo}" style="width:165px;margin-top:10px" placeholder="Roll No">
												<input type="hidden" name="petitionerDetailsList[${loop.index}].caseId" value="${courtCaseDetailsList[0].caseId}"/></td>
												</tr>
												</c:forEach>
												</table>
			                                     </td>
			                                 </tr>         
											<tr>
													<th class="blue">Versus</th>
													<td >
													<input type="text" name="versus" value="${courtCaseDetailsList[0].versus}">
													</td>
											</tr>	
											<tr>
													<th class="blue">Commission Respondent No.</th>
													<td >
													<input type="text" name="commissionRespondentNo" value="${courtCaseDetailsList[0].commissionRespondentNo}" onkeypress="return isNumberKey(event,'characters not allowed','Error3')">
													<span id="Error3"></span>
													</td>
											</tr>										
												</table>
			                                    </div>
			                                </div>
											
										</div>
									</div> 
								</div> 
								
								
									<div class="widget-box">
									<div class="widget-header widget-header-blue widget-header-flat">
									<h4 class="widget-title lighter">Section F</h4>
									  <small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									Hearing Details
									</small>
																			
									</div>
									
										 <div class="widget-body">
										<div class="widget-main">
										<div id="fuelux-wizard-container">
										 <div class="step-content pos-rel">
										<table id="postDetailstbl" class="table  table-bordered table-hover">
										<c:choose>
										 <c:when test="${courtCaseDetailsList[0].caseId!=null}">
										 <tr>
													<th class="blue">Next date of Hearing</th>
													<td>${courtCaseDetailsList[0].dateList}</td>
									       </tr> 
										 </c:when>
										</c:choose>									          												
										<%-- <tr>	
										<th class="blue">Next Date Of Hearing</th>
										<td>
										
										<div class="input-group">		
										<input type="hidden" name="hearingDetailsList[0].caseId" value="${courtCaseDetails[0].caseId}">    
										<input type="text" id="datepicker2" class="form-control date-picker" name="hearingDetailsList[0].date">
										<span class="input-group-addon">
										<i class="fa fa-calendar bigger-110"></i></span>
										</div>
										<span id="Error9" style="color:red;"></span>
										</td>													
										</tr> --%>
										 <tr>
			                                      <th class="blue">All dates Of hearing</th>
			                                     <td>
			                                          <table id="date"> 
												<tr>
												<td style="display:inline-block;"><a  id="more_fields2"  href="javascript:add_hearingDate('hearingDetailsList','date','HearingDate');" >
												<i class="fa fa-plus-square" aria-hidden="true"></i></a>
												&nbsp<a id="more_fields" href="javascript:deleteRow('date');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
												</td></tr>
												<c:forEach items="${courtCaseDetailsList[0].hearingDetailsList}" var="tag" varStatus="loop">
												<tr >			
												<td style="padding-top:15px"><INPUT type="checkbox" name="chk"/>
												  <input type="text" class="form-control date-picker" id="datepicker6"  name="hearingDetailsList[${loop.index}].date" value="<fmt:formatDate type ="date" pattern = "MM/dd/yyyy" value = "${tag.date}"/>" style="width:165px;margin:-25px 0px 0px 20px" placeholder="HearingDate">
												  </td>
											     <td>
												<input type="hidden" name="hearingDetailsList[${loop.index}].caseId" value="${courtCaseDetailsList[0].caseId}"/></td>
												</tr>
												</c:forEach>
												</table>
												 <span style="color:red;">${hearingDateFailed}</span>
			                                     </td>
			                                 </tr>       
										<tr>
											<th class="blue">Detailed Status/ Comments from Legal Secretary</th>
											<td >
											 <input type="text" name="detailedStatus" value="${courtCaseDetailsList[0].detailedStatus}" >
											</td>
										</tr>
										</table>
										 </div>
									 </div>
									</div>
									</div> 
									</div> 								
								
								
						<center> <a class="btn btn-sm btn-warning" href="javascript:saveCourtCaseDetails();">SAVE</a>
						   <p style="color:red;"> ${failed}</p>
						   <span id="Error6"></span>
						</center>	
						  	
						</form:form>
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

<script>

/* $('#datepicker2').datepicker({ 
	  dateFormat: 'yyyy-MM-dd'
 
	}); */
function saveCourtCaseDetails(){
	var writNumber=document.courtCaseForm.writNo.value;
	var year=document.courtCaseForm.year.value;
	var stay=document.courtCaseForm.stay.value;
	var caseType=document.courtCaseForm.caseType.value;
	var caseStatus=document.courtCaseForm.caseStatus.value;
	//var hearingDate=document.getElementById("datepicker7").value;
	if(writNumber==""){
	  document.getElementById("Error1").innerHTML = "Please Enter the Case Number";
	  document.getElementById("Error6").innerHTML = "Please Enter the Case Number";
	  writNumber.focus();
	  return false;
	}
	else if(year==""){
		 document.getElementById("Error2").innerHTML = "Please Enter the year";
		 document.getElementById("Error6").innerHTML = "Please Enter the year";
		 year.focus();
	   	 return false;
	}
	else if(stay==""){
		 document.getElementById("Error4").innerHTML = "Please Select Stay Type";
		 document.getElementById("Error6").innerHTML = "Please Select Stay Type";
		 stay.focus();
	   	 return false;
	}
	else if(caseType==""){
		 document.getElementById("Error7").innerHTML = "Please Select Case Type";
		 document.getElementById("Error6").innerHTML = "Please Select Case Type";
		 stay.focus();
	   	 return false;
	}
	else if(caseStatus==""){
		 document.getElementById("Error8").innerHTML = "Please Select Status";
		 document.getElementById("Error6").innerHTML = "Please Select Status";
		 stay.focus();
	   	 return false;
	}
 /* else if(hearingDate==""){
		 document.getElementById("Error9").innerHTML = "Please Select Next Hearing Date";
		 document.getElementById("Error6").innerHTML = "Please Select Next Hearing Date";
		 stay.focus();
	   	 return false;
	} */
	else{
	 document.getElementById('courtCaseForm').submit();
	}
}
getOtherLegalIssue
function getOtherLegalIssue(sel,name)
{
	var row= document.getElementById("otherLegalIssue");

	var x;
	if(sel=="Other"){
		    x = row.insertCell();
		   /*  x.innerHTML ='<select name='+name+' id="selectCat11" class="formControl" style="width:170px;" onChange="javascript:test()">'+
		    '<option>Select Location...</option>'+
		    '<c:forEach items="${districtList}" var="tag" varStatus="loop">'+
		    '<option value="${tag.districtName}">${tag.districtName}</option>'+
		    '</c:forEach>'+
		    '</select>';  */ 
		    x.innerHTML = '<input type="text" style="margin-left:10px" name='+name+'>';
    }
	else {
		var rowId= document.getElementById("otherLegalIssue");
		var iCell = rowId.cells.length;
		var counter = 0;
		if (iCell > 1) {
			for (var i = 0; i < iCell; i++) {

				   rowId.deleteCell(i+1);
					iCell--;
					i--;
					break;
			}
	}
	
}
}
function getval(sel,name)
{
	var row= document.getElementById("location");

	var x;
	if(sel=="Civil Court"){
		    x = row.insertCell();
		    x.innerHTML ='<select name='+name+' id="selectCat11" class="formControl" style="width:170px;" onChange="javascript:test()">'+
		    '<option>Select Location...</option>'+
		    '<c:forEach items="${districtList}" var="tag" varStatus="loop">'+
		    '<option value="${tag.districtName}">${tag.districtName}</option>'+
		    '</c:forEach>'+
		    '</select>';  
		    
		    $(document).ready(function() {
				
				 var data = document.getElementById(selectCat11);
			       $("#selectCat11").select2({
			    	   allowClear: true,
			    	   placeholderOption: function () { return 'Please select...';},
						  data: data	  
						 
						});
			});
    }
	else {
		var rowId= document.getElementById("location");
		var iCell = rowId.cells.length;
		var counter = 0;
		if (iCell > 1) {
			for (var i = 0; i < iCell; i++) {

				   rowId.deleteCell(i+1);
					iCell--;
					i--;
					break;
			}
	}
	
}
}
</script>
<script type="text/javascript">
function add_fields(list,tableId,entity,placeHolder1,placeHolder2) { 
	var table = document.getElementById(tableId);
	var rowCount = table.rows.length-1;
	var caseId='${courtCaseDetailsList[0].caseId}';
	document.getElementById(tableId).insertRow(-1).innerHTML = 
		'<tr><td><INPUT type="checkbox" name="chk"/>'+
		'<input type="text"  name='+list+'['+rowCount+']'+'.'+tableId+' style="width:165px;margin:10px 0px 0px 10px" placeholder='+placeHolder2+'></td >'+
		'<td><input type="number" name='+list+'['+rowCount+']'+'.'+entity+' placeholder='+placeHolder1+' style="width:165px;margin-top:10px"></td>'+
		'<td><input type="hidden" name='+list+'['+rowCount+']'+'.caseId  value='+caseId+'></td></tr>';
		
	}
function add_similarCases(list,tableId,entity1,entity2,entity3) { 
	var table = document.getElementById(tableId);
	var rowCount = table.rows.length-1;
	var caseId='${courtCaseDetailsList[0].caseId}';
	document.getElementById(tableId).insertRow(-1).innerHTML = 
		'<tr><td><INPUT type="checkbox" name="chk"/>'+
		'<input type="number"  name='+list+'['+rowCount+']'+'.'+entity1+' style="width:165px;margin:10px 0px 0px 10px" placeholder="Case No"></td >'+
		'<td><select name='+list+'['+rowCount+']'+'.'+entity2+' id="selectCat14" class="formControl" style="width:170px;" onChange="javascript:test()">'+
	    '<option>Search by caseType...</option>'+
	    '<option>CWP</option>'+
	    '<option>LPA</option>'+
	    '<option>CM</option>'+
	    '<option>SLP</option>'+
	    '<option>Complaint</option>'+
	    '<option>Civil Suit</option>'+
	    '<option>Civil Appeal</option>'+
	    '<option>RSA</option>'+
	    '<option>COCP</option>'+
	    '<option>EA</option>'+
	    '<option>RA</option>'+
	    '</select></td>'+
		'<td><input type="number" name='+list+'['+rowCount+']'+'.'+entity3+' placeholder="Year" style="width:165px;margin-top:10px"></td>'+
		'<td><input type="hidden" name='+list+'['+rowCount+']'+'.caseId  value='+caseId+'></td></tr>';
		
	$(document).ready(function() {
		
		 var data = document.getElementById(selectCat14);
	       $("#selectCat14").select2({
	    	   allowClear: true,
	    	   placeholderOption: function () { return 'Please select...';},
				  data: data	  
				 
				});
	});
	
	}
function cmNoRow(list,tableId,entity,placeHolder1,placeHolder2) { 
	var table = document.getElementById(tableId);
	var rowCount = table.rows.length-1;
	var caseId='${courtCaseDetailsList[0].caseId}';
	document.getElementById(tableId).insertRow(-1).innerHTML = 
		'<tr><td><INPUT type="checkbox" name="chk"/>'+
		'<input type="number"  name='+list+'['+rowCount+']'+'.'+tableId+' style="width:165px;margin:10px 0px 0px 10px" placeholder='+placeHolder2+'></td >'+
		'<td><input type="number" name='+list+'['+rowCount+']'+'.'+entity+' placeholder='+placeHolder1+' style="width:165px;margin-top:10px"></td>'+
		'<td><input type="hidden" name='+list+'['+rowCount+']'+'.caseId  value='+caseId+'></td></tr>';
		
	}
	
function InterimOrderRow(list,tableId,entity,placeHolder1,placeHolder2) { 
	var table = document.getElementById(tableId);
	var rowCount = table.rows.length-1;
	var caseId='${courtCaseDetailsList[0].caseId}';
	document.getElementById(tableId).insertRow(-1).innerHTML = 
		'<tr><td><INPUT type="checkbox" name="chk"/>'+
		'<input type="text"  name='+list+'['+rowCount+']'+'.'+tableId+'	 style="width:165px;margin:10px 0px 0px 10px" placeholder='+placeHolder2+'></td >'+
		'<td><input type="text" name='+list+'['+rowCount+']'+'.'+entity+' id="datepicker5" class="form-control date-picker" placeholder='+placeHolder1+' style="width:165px;margin-top:10px"></td>'+
		'<td><input type="hidden" name='+list+'['+rowCount+']'+'.caseId  value='+caseId+'></td></tr>';
		
		$('.date-picker').datepicker({
			autoclose: true,
			todayHighlight: true
		})
		$('#datepicker5').attr('readonly','readonly');
	}

function add_hearingDate(list,tableId,placeHolder) { 
	var table = document.getElementById(tableId);
	var rowCount = table.rows.length-1;
	var caseId='${courtCaseDetailsList[0].caseId}';
	document.getElementById(tableId).insertRow(-1).innerHTML = 
		'<tr><td style="padding-top:15px"><INPUT type="checkbox" name="chk"/ >'+
		'<input type="text"  name='+list+'['+rowCount+']'+'.'+tableId+' id="datepicker7" class="form-control date-picker" style="width:165px;margin:-25px 0px 0px 20px" placeholder='+placeHolder+'></td >'+
		'<td><input type="hidden" name='+list+'['+rowCount+']'+'.caseId  value='+caseId+'></td></tr>';
		
	$('.date-picker').datepicker({
		autoclose: true,
		todayHighlight: true
	})
	$('#datepicker7').attr('readonly','readonly');
		
	}
function deleteRow(tableID) {
	/***We get the table object based on given id ***/
    var objTable = document.getElementById(tableID);

    /*** Get the current row length ***/
    var iRow = objTable.rows.length;

	/*** Initial row counter ***/
	var counter = 0;

    /*** Performing a loop inside the table ***/
	if (objTable.rows.length > 1) {
		for (var i = 0; i < objTable.rows.length; i++) {

			 /*** Get checkbox object ***/
			var chk = objTable.rows[i].cells[0].childNodes[0];
			if (chk.checked) {
				/*** if checked we del ***/
				objTable.deleteRow(i);
				iRow--;
				i--;
				counter = counter + 1;
			}
		}

		/*** Alert user if there is now row is selected to be deleted ***/
		if (counter == 0) {
			alert("Please select the row that you want to delete.");
		}
	}else{
		/*** Alert user if there are no rows being added ***/
		alert("There are no rows being added");
	}
}

</script>





		<!--[if !IE]> -->
		<script src="assets/js/jquery-2.1.4.min.js"></script>
		<script src="assets/js/bootstrap-datepicker.min.js"></script>
		<!-- <![endif]-->

		<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
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
		<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.1/js/select2.min.js"></script>	
		<script src="assets/js/custom.min.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {

				$('[data-rel=tooltip]').tooltip();

				$('.select2').css('width','200px').select2({allowClear:true})
				.on('change', function(){
					$(this).closest('form').validate().element($(this));
				});


				var $validation = false;
				$('#fuelux-wizard-container')
				.ace_wizard({
					//step: 2 //optional argument. wizard will jump to step "2" at first
					//buttons: '.wizard-actions:eq(0)'
				})
				.on('actionclicked.fu.wizard' , function(e, info){
					if(info.step == 1 && $validation) {
						if(!$('#validation-form').valid()) e.preventDefault();
					}
				})
				//.on('changed.fu.wizard', function() {
				//})
				.on('finished.fu.wizard', function(e) {
					bootbox.dialog({
						message: "Nothing Else To Show!",
						buttons: {
							"success" : {
								"label" : "OK",
								"className" : "btn-sm btn-primary"
							}
						}
					});
				}).on('stepclick.fu.wizard', function(e){
					//e.preventDefault();//this will prevent clicking and selecting steps
				});


				//jump to a step
				/**
				var wizard = $('#fuelux-wizard-container').data('fu.wizard')
				wizard.currentStep = 3;
				wizard.setState();
				*/

				//determine selected step
				//wizard.selectedItem().step



				//hide or show the other form which requires validation
				//this is for demo only, you usullay want just one form in your application
				$('#skip-validation').removeAttr('checked').on('click', function(){
					$validation = this.checked;
					if(this.checked) {
						$('#sample-form').hide();
						$('#validation-form').removeClass('hide');
					}
					else {
						$('#validation-form').addClass('hide');
						$('#sample-form').show();
					}
				})



				//documentation : http://docs.jquery.com/Plugins/Validation/validate


				$.mask.definitions['~']='[+-]';
				$('#phone').mask('(999) 999-9999');

				jQuery.validator.addMethod("phone", function (value, element) {
					return this.optional(element) || /^\(\d{3}\) \d{3}\-\d{4}( x\d{1,6})?$/.test(value);
				}, "Enter a valid phone number.");

				$('#validation-form').validate({
					errorElement: 'div',
					errorClass: 'help-block',
					focusInvalid: false,
					ignore: "",
					rules: {
						email: {
							required: true,
							email:true
						},
						password: {
							required: true, 
							minlength: 5
						},
						password2: {
							required: true,
							minlength: 5,
							equalTo: "#password"
						},
						name: {
							required: true
						},
						phone: {
							required: true,
							phone: 'required'
						},
						url: {
							required: true,
							url: true
						},
						comment: {
							required: true
						},
						state: {
							required: true
						},
						platform: {
							required: true
						},
						subscription: {
							required: true
						},
						gender: {
							required: true,
						},
						agree: {
							required: true,
						}
					},

					messages: {
						email: {
							required: "Please provide a valid email.",
							email: "Please provide a valid email."
						},
						password: {
							required: "Please specify a password.",
							minlength: "Please specify a secure password."
						},
						state: "Please choose state",
						subscription: "Please choose at least one option",
						gender: "Please choose gender",
						agree: "Please accept our policy"
					},


					highlight: function (e) {
						$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
					},

					success: function (e) {
						$(e).closest('.form-group').removeClass('has-error');//.addClass('has-info');
						$(e).remove();
					},

					errorPlacement: function (error, element) {
						if(element.is('input[type=checkbox]') || element.is('input[type=radio]')) {
							var controls = element.closest('div[class*="col-"]');
							if(controls.find(':checkbox,:radio').length > 1) controls.append(error);
							else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
						}
						else if(element.is('.select2')) {
							error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
						}
						else if(element.is('.chosen-select')) {
							error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
						}
						else error.insertAfter(element.parent());
					},

					submitHandler: function (form) {
					},
					invalidHandler: function (form) {
					}
				});




				$('.date-picker').datepicker({
					autoclose: true,
					todayHighlight: true
				})
				
				//show datepicker when clicking on the icon
				.next().on(ace.click_event, function(){
					$(this).prev().focus();
				});
				$('#datepicker').attr('readonly','readonly');
				$('#datepicker1').attr('readonly','readonly');
				$('#datepicker2').attr('readonly','readonly');
				$('#datepicker3').attr('readonly','readonly');
				$('#datepicker4').attr('readonly','readonly');
				//or change it into a date range picker
				$('.input-daterange').datepicker({autoclose:true});
				
				
				/**
				$('#date').datepicker({autoclose:true}).on('changeDate', function(ev) {
					$(this).closest('form').validate().element($(this));
				});

				$('#mychosen').chosen().on('change', function(ev) {
					$(this).closest('form').validate().element($(this));
				});
				*/


				$(document).one('ajaxloadstart.page', function(e) {
					//in ajax mode, remove remaining elements before leaving page
					$('[class*=select2]').remove();
				});
				
				$(document).ready(function() {
					
					 var data = document.getElementById(selectCat);
				       $("#selectCat").select2({
				    	   allowClear: true,
				    	   placeholderOption: function () { return 'Please select...';},
							  data: data	  
							 
							});
				});
				

				$(document).ready(function() {
					
					 var data = document.getElementById(selectCat1);
				       $("#selectCat1").select2({
				    	   allowClear: true,
				    	   placeholderOption: function () { return 'Please select...';},
							  data: data	  
							 
							});
				});
				

				$(document).ready(function() {
					
					 var data = document.getElementById(selectCat2);
				       $("#selectCat2").select2({
				    	   allowClear: true,
				    	   placeholderOption: function () { return 'Please select...';},
							  data: data	  
							 
							});
				});
				

				$(document).ready(function() {
					
					 var data = document.getElementById(selectCat3);
				       $("#selectCat3").select2({
				    	   allowClear: true,
				    	   placeholderOption: function () { return 'Please select...';},
							  data: data	  
							 
							});
				});
				

				$(document).ready(function() {
					
					 var data = document.getElementById(selectCat4);
				       $("#selectCat4").select2({
				    	   allowClear: true,
				    	   placeholderOption: function () { return 'Please select...';},
							  data: data	  
							 
							});
				});
				$(document).ready(function() {
					
					 var data = document.getElementById(selectCat5);
				       $("#selectCat5").select2({
				    	   allowClear: true,
				    	   placeholderOption: function () { return 'Please select...';},
							  data: data	  
							 
							});
				});
				$(document).ready(function() {
					
					 var data = document.getElementById(selectCat6);
				       $("#selectCat6").select2({
				    	   allowClear: true,
				    	   placeholderOption: function () { return 'Please select...';},
							  data: data	  
							 
							});
				});
				$(document).ready(function() {
					
					 var data = document.getElementById(selectCat7);
				       $("#selectCat7").select2({
				    	   allowClear: true,
				    	   placeholderOption: function () { return 'Please select...';},
							  data: data	  
							 
							});
				});
				$(document).ready(function() {
					
					 var data = document.getElementById(selectCat8);
				       $("#selectCat8").select2({
				    	   allowClear: true,
				    	   placeholderOption: function () { return 'Please select...';},
							  data: data	  
							 
							});
				});
				$(document).ready(function() {
					
					 var data = document.getElementById(selectCat9);
				       $("#selectCat9").select2({
				    	   allowClear: true,
				    	   placeholderOption: function () { return 'Please select...';},
							  data: data	  
							 
							});
				});
				$(document).ready(function() {
					
					 var data = document.getElementById(selectCat10);
				       $("#selectCat10").select2({
				    	   allowClear: true,
				    	   placeholderOption: function () { return 'Please select...';},
							  data: data	  
							 
							});
				});
               
				<c:set var="var" value="${courtCaseDetailsList[0].similarCasesList}"/>
					 <c:choose>
					 <c:when test="${var==null}">
				$(document).ready(function() {
					
					 var data = document.getElementById(selectCat13);
				       $("#selectCat13").select2({
				    	   allowClear: true,
				    	   placeholderOption: function () { return 'Please select...';},
							  data: data	  
							 
							});
				});
				 </c:when>
				 </c:choose>
				
				 
				 $(document).ready(function() {					
					 var data = document.getElementById(selectCat15);
				       $("#selectCat15").select2({
				    	   allowClear: true,
				    	   placeholderOption: function () { return 'Please select...';},
							  data: data	  							 
							});
				});
				 
				       $(document).ready(function() {					
							 var data = document.getElementById(selectCat16);
						       $("#selectCat16").select2({
						    	   allowClear: true,
						    	   placeholderOption: function () { return 'Please select...';},
									  data: data	  							 
									});
						});
			})
		</script>
	</body>
</html>
