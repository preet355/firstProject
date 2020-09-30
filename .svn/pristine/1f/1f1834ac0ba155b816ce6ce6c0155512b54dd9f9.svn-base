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
							</c:when>
						</c:choose>
						
						<c:choose>
						   <c:when test="${user.isAdmin=='Y'}">
						        <li class="active"><a href="<c:url value="allRegisteredRequisitions"/>">

								<i class="menu-icon fa fa-list"></i> <span
								class="menu-text">All Requisitions</span>

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
								Department
							</li>

							<li>
							 <c:choose>
      		                          <c:when test="${user.isAdmin=='Y'}"> 
      		                          All Departments
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
								<div class="page-header">
									<h1>
									    View Requisition Remarks Form For <b>${requisitionForm[0].uniqueRequisitionNumber}</b>
									</h1>
									<a style="float:right;margin-top: -25px;margin-right: 10%;" class="btn btn-sm btn-warning" href="javascript:saveRemarks('back referred','${requisitionForm[0].idRequisition}');">Back Refer</a>
									<a style="float:right;margin-top: -25px;margin-right:15px;" class="btn btn-sm btn-success" href="javascript:saveRemarks('approved','${requisitionForm[0].idRequisition}');">Approve</a>
								</div>
								<form:form name="requisitionForm" id="requisitionForm" method="post" enctype="multipart/form-data" accept-charset="UTF-8" >
								<input type="hidden" id="idRequisition" name="idRequisition">
								<input type="hidden" id="docType" name="docType">
								<input type="hidden" id="status" name="status">
								<input type="hidden" id="idRequisition" name="idRequisition">
										    <table id="simple-table" class="table  table-bordered table-hover">
										      <tbody>
												<tr>
													<td>
														<label class="pos-rel" style="font-weight:600;font-size:12px;">
															Designation of the post
														</label>
													</td>
													<td >
														 <label class="pos-rel" style="font-weight:0;font-size:12px;">
															${requisitionForm[0].postObj.postName}
														</label>
														<br>
														<input type="text" name="designationOfPostRemark" value="ok">
													</td>
													<td>
													<label class="pos-rel" style="font-weight:600;font-size:12px;">
														 Number of posts to be filled
												    </label>
													</td>
													<td>
													 <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].numberOfPostToBeFilled}
												    </label>
												     <br>
														<input type="text" name="numberOfPostToBeFilledRemark" value="ok">
													</td>
													
												</tr>
												<tr>
													<td>
														<label class="pos-rel" style="font-weight:600;font-size:12px;">
															Class & service to which the post belongs
														</label>
													</td>

													<td >
														<label class="pos-rel" style="font-weight:0;font-size:12px;">
															${requisitionForm[0].classAndServiceOfPost}
														</label>
														 <br>
														<input type="text" name="classAndServiceOfPostRemark" value="ok">
													</td>
													<td>
													<label class="pos-rel" style="font-weight:600;font-size:12px;">
														Whether there are any published Rules  for this service/post?
												    </label>
													</td>
													<td>
													   <label class="pos-rel" style="font-weight:;font-size:12px;">
														${requisitionForm[0].anyPublishedRulesForService}
												    </label> 
												     <br>
														<input type="text" name="anyPublishedRulesForServiceRemark" value="ok">
													 </td>
													
												</tr>
												<tr>
													<td>
														<label class="pos-rel" style="font-weight:600;font-size:12px;">
															Provide the link for service rules on Department's website or upload here
                                                            (Signed and Stamped copy to be uploaded/attached)
														</label>
													</td>
                                                      		 
													<td >
													 <a  title="Download pdf" href="javascript:downloadDoc('${requisitionForm[0].idRequisition}','service')">
													${serviceDoc}
													 </a> 
													 <br>
													 ${requisitionForm[0].linkForServiceRules}
                                                       <br>
														<input type="text" name="linkForServiceRulesRemark" value="ok">
													<td>
													<label class="pos-rel" style="font-weight:600;font-size:12px;">
														Whether post is  permanent or temporary?
												    </label>
													</td>
													<td>
													   <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].isPostPermanentOrTemporary}
												      </label>	
												       <br>
														<input type="text" name="isPostPermanentOrTemporaryRemark" value="ok">	
													</td>
													
												</tr>
												<tr>
												    <td>
													<label class="pos-rel" style="font-weight:600;font-size:12px;">
														Job Description
												    </label>
													</td>
													<td colspan='3'>
													   <label class="pos-rel" style="font-weight:;font-size:12px;">
														${requisitionForm[0].jobDescription}
												    </label> 
												    <br>
														<input type="text" name="jobDescriptionRemark" value="ok">
													 </td>
												</tr>
												<tr>
												   <td colspan="4">
												       <label style="font-weight:900;font-size:14px;">
												          Scale of pay
												       </label>
												   </td>
												</tr>
												<tr>
												  <td>
												  <label style="font-weight:600;font-size:12px;">
												          (a)  For direct recruits
												       </label>
												  </td>
												  <td >
												  <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].scaleOfPayForDirectRecruits}
												      </label>	
												       <br>
														<input type="text" name="scaleOfPayForDirectRecruitsRemark" value="ok">
												  </td>
												  <td rowspan="3">
												   <label style="font-weight:600;font-size:12px;">
												            Will any special concessions be given to  a candidate of non-Asiatic domicile ?
												       </label>
												  </td >
												  <td rowspan="3">
												    <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].anySpecialConcessionsForNonAsiaticDomicile}
												      </label>
												       <br>
														<input type="text" name="anySpecialConcessionsForNonAsiaticDomicileRemark" value="ok">
												  </td>											
												</tr>
												<tr>
												  <td >
												  <label style="font-weight:600;font-size:12px;">
												         (b)  For persons already in Government service, if Government servants are eligible
												       </label>
												  </td>
												  <td >
												   <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].scaleOfPayForPersonsAlreadyInGovernmentService}
												      </label>
												       <br>
														<input type="text" name="scaleOfPayForPersonsAlreadyInGovernmentServiceRemark" value="ok">
												  </td>
												</tr>
												<tr>
												  <td >
												  <label style="font-weight:600;font-size:12px;">
												         (c) Can higher initial pay be granted for specially well-qualified candidates? if so, please specify the limit
												       </label>
												  </td>
												  <td>
												  <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].higherInitialPayBeGranted}
												      </label>
												       <br>
														<input type="text" name="higherInitialPayBeGrantedRemark" value="ok">
												  </td>
												</tr>
												<tr>
												  <td colspan="4">
												      <label style="font-weight:900;font-size:14px;">
												          Qualification
												       </label>
												  </td>
												</tr>
												<tr>
												   <td>
												      <label style="font-weight:600;font-size:12px;">
												         Academic. (If more than one  qualifications  are prescribed, it should  be stated which is considered to be most  important )
												       </label>
												   </td>
												   <td>
														 <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].academicQualifications}
												      </label>
												       <br>
														<input type="text" name="academicQualificationsRemark" value="ok">
												   </td>
												   <td>
												     <label style="font-weight:600;font-size:12px;">
                                                        Training
												      </label>
												   </td>
												   <td>
														<label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].training}
												      </label>
												       <br>
														<input type="text" name="trainingRemark" value="ok">
												   </td>
												</tr>
												<tr>
												  <td>
												    <label style="font-weight:600;font-size:12px;">
                                                        Hindi qualification
												      </label>
												  </td>
												  <td>
												     <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].hindiQualification}
												      </label>
												       <br>
														<input type="text" name="hindiQualificationRemark" value="ok">
												  </td>
												  <td>
												     <label style="font-weight:600;font-size:12px;">
                                                        Experience (in years)
												      </label>
												  </td>
												  <td>
												     <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].experience}
												      </label>
												       <br>
														<input type="text" name="experienceRemark" value="ok">
												  </td>
												</tr>
												<tr>
												  <td>
												     <label style="font-weight:600;font-size:12px;">
                                                        State clearly whether the experience  gained by a candidate after acquiring the  minimum basic qualification (s)  prescribed against clause (a) above is to  be taken into consideration
												      </label>
												  </td>
												  <td>
												     <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].isExperienceTakenIntoConsidration}
												      </label>
												       <br>
														<input type="text" name="isExperienceTakenIntoConsidrationRemark" value="ok">
												  </td>
												  <td>
												    <label style="font-weight:600;font-size:12px;">
                                                       Will equivalent qualifications be  accepted? If so, equivalents should be  stated
												      </label>
												</td>
												<td>
												  <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].equivalentQualifications}
												      </label>
												       <br>
														<input type="text" name="equivalentQualificationsRemark" value="ok">
												 </td>
												</tr>
												<tr>
												 <td>
												    <label style="font-weight:600;font-size:12px;">
                                                       Any other qualifications
												      </label>
												 </td>
												 <td>
												    <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].anyOtherQualifications}
												      </label>
												       <br>
														<input type="text" name="anyOtherQualificationsRemark" value="ok">
												 </td>
												 <td>
												   <label style="font-weight:600;font-size:12px;">
                                                       State which of the above requirements  will be strictly adhered.
												      </label>
												</td>
												<td>
												    <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].requirementsStrictlyAthered}
												      </label>
												       <br>
														<input type="text" name="requirementsStrictlyAtheredRemark" value="ok">
												</td>
												</tr>
											    <tr>
											     <td colspan="4">
											        <label style="font-weight:900;font-size:14px;">
												           Age-limit
												       </label>
											     </td>
											    </tr>
											    <tr>
											    <td>
											       <label style="font-weight:600;font-size:12px;">
                                                       Lower (in Years)
												      </label>
											    </td>
											    <td>
											       <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].lowerAgeLimit}
												      </label>
												       <br>
														<input type="text" name="lowerAgeLimitRemark" value="ok">
											    </td>
											    <td>
											       <label style="font-weight:600;font-size:12px;">
                                                       Upper (in Years)
												      </label>
											    </td>
											    <td>
											        <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].upperAgeLimit}
												      </label>
												       <br>
														<input type="text" name="upperAgeLimitRemark" value="ok">
											    </td>
											    </tr>
											    <tr> 
											      <td>
											      <label style="font-weight:600;font-size:12px;">
                                                       Exact date on which the age is to be determined
												      </label>
											    </td>
											    <td>
											        <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].dateOnWhichAgeIsDetermined}
												      </label>
												       <br>
														<input type="text" name="dateOnWhichAgeIsDeterminedRemark" value="ok">
											    </td>
											    <td>
											      <label style="font-weight:600;font-size:12px;">
                                                      Are Government servants eligible?
												      </label>
											    </td>
											    <td>
											     <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].areGovServantsEligible}
												      </label>
												       <br>
														<input type="text" name="areGovServantsEligibleRemark" value="ok">
											    </td>
											    </tr>
											    <tr>
											      <td colspan="4">
											         <label style="font-weight:800;font-size:12px;color:blue;">
												           Whether any relaxation is admissible for:
												       </label>
											      </td>
											    </tr> 	
											    <tr>
											      <td>
											      <label style="font-weight:600;font-size:12px;">
                                                      (i) Government servants
												      </label>
											      </td>
											      <td>
											      <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].anyRelaxationForGovServents}
												      </label>
												       <br>
														<input type="text" name="anyRelaxationForGovServentsRemark" value="ok">
											      </td>
											      <td>
											         <label style="font-weight:600;font-size:12px;">
                                                      (ii) Otherwise suitable candidates
												      </label>
											      </td>
											      <td>
											      <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].anyRelaxationForSutaibleCandidates}
												      </label>
												       <br>
														<input type="text" name="anyRelaxationForSutaibleCandidatesRemark" value="ok">
											      </td>
											    </tr>
											     <tr>
											       <td colspan="4">
											          <label style="font-weight:900;font-size:14px;">
												          Total Vacancies and vertical/horizontal reservation as per state policy
												       </label>
												       <br>
											          <label style="font-weight:400;font-size:12px;color:red">
<!-- 												        <i> Recruitment for SBC/EBPGC category has been stayed as per orders from High Court.</i><br> -->
												        <i><b>ESP (3% of Group B, 3% of Group C and 10% of Group D)</b> as per instruction No. 22/10/2013-1GSIII dated 30.04.2019</i>
												       </label>
											       </td>
											     </tr>
											    <%--  <tr>
											      <td>
											         <label style="font-weight:600;font-size:12px;">
                                                      Total Number of Seats 
												      </label>
											      </td>
											      <td>
											         <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].totalNumberOfSeats}
												      </label>
											      </td>
											     </tr>--%>
											     <tr> 
											        <td colspan="4">
											           <table id="simple-table" class="table  table-bordered table-hover">
											               <thead>
											                  <tr>
											                  <c:forEach items="${headersArr}" var="var" varStatus="loop">
											                  <th <c:if test="${var=='Category'}">colspan="2"</c:if>>
											                      <c:out value="${var}"/> 
											                     </th>
											                  </c:forEach>
											                  </tr>
											               </thead>											            
											               <tbody>											                 
											                 <c:forEach items="${bifurcationList}" var="req">
        														<tr>
          												  <td colspan="2"> <c:out value="${req.category}"/></td>  
          												 <td> <c:out value="${req.totalCount}"/></td>
          												 <td> <c:out value="${req.nonEsmEspCount}"/></td>
          												 <td> <c:out value="${req.esmCount}"/></td>
          												 <td> <c:out value="${req.espCount}"/></td>          												 
          												          												          												  
        													</tr>
  															  </c:forEach>
  														<tr>
  															    <td>
  															       <b>Total</b>		
  															    </td>
  															    <td>
  															      ${requisitionForm[0].numberOfPostToBeFilled}
  															    </td>
  															     <%-- <td>
											                   
											                     <label>
											                        <b>ESP</b>
											                     </label></br>
											                      <label style="font-weight:400;font-size:12px;color:red">
												                   <i>3% for Group C and 10% for Group D</i>
												                  </label>
											                   </td>
											                   <td>
											                     ${requisitionForm[0].espSeats}
											                   </td> --%>
  															  </tr>
  															   <tr>
  															    <td> 
  															       <b>PWD -(4% of Total Seats) The computation of 4% reservation is on the basis of total no of posts in the cadre minus existing strength of PwD (Person with Disability)</b>
  															    </td>
  															   <td>
                                                                   Blindness and low vision  - ${requisitionForm[0].pwd1}
                                                             </td>
                                                             <td>
                                                                   Deaf and hard of hearing -${requisitionForm[0].pwd2}
                                                             </td>
                                                             <td>
                                                                    locomotor disability including cerebral palsy, leprosy cured, dwarfism, 
                                                                    acid attack victims and muscular dystrophy - ${requisitionForm[0].pwd3}
                                                             </td>
                                                             <td colspan="2">
                                                                  autism, intellectual disability, specific learning disability and mental illness <br><b>AND</b><br>
                                                                    multiple disabilities from amongst person under all clauses including deaf-blindness in the posts identified for each disabilities -  ${requisitionForm[0].pwd4}
                                                             </td>
  															  </tr>
  															    <tr>
											                      <td colspan="6">
											                         <i><b>Note:</b> If the posts are not identified, no need to fill up the column of bifurcation.</i>
											                      </td>
											                   </tr>
  															   <c:if test="${not empty requisitionForm[0].pwd1}">
  															      <tr >
												                      <td>
												                        <b>
												                         Visual Handicap Bifurcation
												                        </b>
												                      </td>
											                         <td colspan="2">
											                          Blind (B) - ${requisitionForm[0].pwdB}
											                           
											                         </td>
											                         <td colspan="3">
											                           Low Vision (LV)  - ${requisitionForm[0].pwdL}
											                           
											                         </td>
											                      </tr>
  															  </c:if>
  															  
  															  <c:if test="${not empty requisitionForm[0].pwd2}">
  															      <tr >
											                      <td>
												                        <b>
												                         Hearing Handicap Bifurcation
												                        </b>
												                      </td>
											                         <td colspan="2">
											                           Fully Deaf (FD) - ${requisitionForm[0].pwdFD}
											                         
											                         </td>
											                         <td colspan="3">
											                           Hard of  Hearing/Partial Deaf (HH/PD) - ${requisitionForm[0].pwdHH}
											                         </td>
											                      </tr>
											                      
  															  </c:if>
  															  <c:if test="${not empty requisitionForm[0].pwd3}">
  															  <tr >
											                          <td colspan="6" >
											                              <b>locomotor disability including cerebral palsy, leprosy cured, dwarfism, acid attack victims and muscular dystrophy</b>
											                          </td>
											                       </tr>
											                      <tr >
											                         <td >
											                           One Leg (OL) - ${requisitionForm[0].pwdOL}
											                         </td>
											                         <td >
											                           One Arm (OA) - ${requisitionForm[0].pwdOA}
											                         </td>
											                         <td >
											                           Both Arms (BA) - ${requisitionForm[0].pwdBA}											                         </td>
											                         <td >
											                           Both Hands (BH) - ${requisitionForm[0].pwdBH}
											                         </td>
											                         <td colspan="2">
											                           Muscular Weakness (MW) - ${requisitionForm[0].pwdMW}
											                         </td>
											                        
											                      </tr>
											                      <tr>
											                         <td >
											                           One Arm One Leg (OAL) - ${requisitionForm[0].pwdOAL}
											                         </td>
											                         <td >
											                           Both Legs and Arms (BLA) - ${requisitionForm[0].pwdBLA}
											                         </td>
											                         <td >
											                           Both Legs One Arm (BLOA) - ${requisitionForm[0].pwdBLOA}
											                         </td>
											                         <td >
											                           Cerebral paisy - ${requisitionForm[0].pwdCPaisy}
											                         </td>
											                         <td colspan="2">
											                           leprosy cured - ${requisitionForm[0].pwdLCured}
											                         </td>
											                      </tr>
											                      <tr>
											                         <td >
											                           dwarfism - ${requisitionForm[0].pwdDwarfism}
											                         </td>
											                         <td >
											                           acid attack victims - ${requisitionForm[0].pwdAAVictims}
											                         </td>
											                         <td >
											                           muscular dystrophy - ${requisitionForm[0].pwdMDystrophy}
											                         </td>
											                         <td colspan="3">
											                           others - ${requisitionForm[0].pwdOthers}
											                         </td>
											                      </tr>
  															  
  															  </c:if>
											               </tbody>
											           
											           </table>
											            <input type="text" name="requisitionReservationInfoRemark" value="ok">
											        </td>
											     </tr>
											     <tr>
											       <td>
											         <label style="font-weight:600;font-size:12px;">
				                                                     Name of officer of the Department whom  Government would like the  Commission to invite to be present to  assist them in an advisory capacity.
															  </label>
											       </td>
											       <td>
											            <label style="font-weight:0;font-size:12px;">
				                                                    ${requisitionForm[0].nameOfOfficerForAdvisoryCapacity}
													    </label>
													     <br>
														<input type="text" name="nameOfOfficerForAdvisoryCapacityRemark" value="ok">
											       </td>
											         
											       <td>
											         <label style="font-weight:600;font-size:12px;">
													   Name of Nodal Officer		  
													</label>
											       </td>
											       <td>
											         <label style="font-weight:0;font-size:12px;">
				                                                    ${requisitionForm[0].nameOfNodalOfficer}
													    </label>
													     <br>
														<input type="text" name="nameOfNodalOfficerRemark" value="ok">
											       </td>
											     </tr>
											     <tr>
											       <td>
											         <label style="font-weight:600;font-size:12px;">
													   Phone Number of Nodal Officer	  
													</label>
											       </td>
											       <td>
											         <label style="font-weight:0;font-size:12px;">
				                                                    ${requisitionForm[0].phoneNumberOfNodelOfficer}
													    </label>
													     <br>
														<input type="text" name="phoneNumberOfNodelOfficerRemark" value="ok">
											       </td>
											       <td>
											          <label style="font-weight:600;font-size:12px;">
													   Any other condition or qualification not covered by the above questions.  
													</label>
											       </td>
											       <td> 
											          <label style="font-weight:0;font-size:12px;">
				                                                    ${requisitionForm[0].conditionOrQualificationNotCoveredAbove}
													    </label>
													     <br>
														<input type="text" name="conditionOrQualificationNotCoveredAboveRemark" value="ok">
											       </td>
											     </tr>
											     <tr>
											       <td>
											       <label style="font-weight:600;font-size:12px;">
													   Signed and Stamped Form PDF
													</label>
											          
											       </td>
											       <td>
											         <a  title="Download pdf" href="javascript:downloadDoc('${requisitionForm[0].idRequisition}','form')">
													${formTypeDocFileName}
													 </a> 
													    <br>
														<input type="text" name="requisitionDocsRemark" value="ok">
											       </td>
											     </tr>
										    </table >
										   <%--  <c:set var="var" value="${module}"/>
										    <c:choose>
										    <c:when test="${var!='req'}">
										       <c:choose>
										       <c:when test="${requisitionForm[0].status!='submitted'}">
										    <table id="simple-table" class="table  table-bordered table-hover">
										       <tr>
										         <td>
										            <input type="file" name="formfile" id=id-input-file-2 />
										         </td>
										         <td>
										             <a class="btn btn-sm btn-grey" href="javascript:editRequisitionForm('${requisitionForm[0].idRequisition}')">Edit</a>
										         </td>
										         <td>
										            <a class="btn btn-sm btn-warning" href="javascript:popUpPreview('${requisitionForm[0].idRequisition}');">Print</a>
										         </td>
										         <td>
										           <a class="btn btn-sm btn-success" href="javascript:secondUpload('${requisitionForm[0].idRequisition}');">Submit</a>
										         </td>
										       </tr>
										    </table>
										      </c:when>	
										     </c:choose>	
										    </c:when>		
						                  	</c:choose> --%>
						                 </form:form>		
							</div>
						</div>
					</div>
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

<script>

function downloadDoc(idRequisition,docType){
	document.getElementById('docType').value=docType;
	document.getElementById('idRequisition').value=idRequisition;
	document.getElementById('requisitionForm').action="downloadForm";
	document.getElementById('requisitionForm').submit();
}

function editRequisitionForm(idRequisition){
	document.getElementById('idRequisition').value=idRequisition;
	document.getElementById('requisitionForm').action="editRegisteredRequisitionForm";
	document.getElementById('requisitionForm').submit();
	}

	function popUpPreview(idRequisition) {
    Id=idRequisition;
      window.open("/HSSCList/printPreview"+Id, 'window', 'width=800,height=600');
    }
	
	function secondUpload(idRequisition){	
		document.getElementById('idRequisition').value=idRequisition;
		document.getElementById('requisitionForm').action="secondUpload";
		document.getElementById('requisitionForm').submit();
	}
	function saveRemarks(status,idRequisition){	
		document.getElementById('status').value=status;
		document.getElementById('idRequisition').value=idRequisition;
		document.getElementById('requisitionForm').action="statusForRequisition";
		document.getElementById('requisitionForm').submit();
	}
		
		
		$('#id-input-file-2').ace_file_input({
			no_file:'No File ...',
			btn_choose:'Choose',
			btn_change:'Change',
			droppable:false,
			onchange:null,
			thumbnail:false
			
		});

</script>		
		

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




				$('#modal-wizard-container').ace_wizard();
				$('#modal-wizard .wizard-actions .btn[data-dismiss=modal]').removeAttr('disabled');


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
			})
		</script>
	</body>
</html>
