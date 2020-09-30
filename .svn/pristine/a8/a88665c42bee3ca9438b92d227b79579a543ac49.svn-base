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
				                Requisition Registration	
							</li>
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
									     Requisition Registration
									    </c:otherwise>
									    </c:choose>
									</h1>
									<c:choose>
									 <c:when test="${requisitionForm[0].status=='back referred'}">
									  <a style="float:right;margin-top: -25px;margin-right: 10%;" class="btn btn-sm btn-grey" href="javascript:showBackReferredForm('${requisitionForm[0].idRequisition}')">Back Referred Info</a>
								     </c:when>
								    </c:choose>
								</div>
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
								</c:choose>
								 <div class="row">
							         <div class="col-xs-12">
										 <form:form name="registerRequisitionForm" id="requisitionForm" method="post" enctype="multipart/form-data" accept-charset="UTF-8"  action="saveRequisitionForm" commandname="reqObj">
										    <input type="hidden" name="idRequisition" id="idRequisition" value="${requisitionForm[0].idRequisition}"/>
										    <input type="hidden" name="status" id="status" value="${requisitionForm[0].status}"/>
										     <input type="hidden" name="createdatetime" id="createdatetime" value="${requisitionForm[0].createdatetime}"/>
										     <input type="hidden" name="desigId" id="desigId" value="${requisitionForm[0].postmasterId}"/>
										     
										    <input type="hidden" name="totalFilled" id="totalFilled"/>
										    <table id="simple-table" class="table  table-bordered table-hover">
										      <tbody>
										      <tr>
										        <td colspan="3">
										         <label style="font-weight:900;font-size:14px;">
												         General
												       </label>
<%-- 												     <label style="font-size:12px;color:red"><b>${failed}</b></label>   --%>
	                                            </td>
	                                            <td>
	                                              <strong><a class="btn btn-sm btn-primary" href="javascript:validateCount()">Validate Bifurcation Count (Group-D)</a></strong>   
	                                            </td>

	                                            
										      </tr>
												<tr>
												     <td>
														<label class="pos-rel" style="font-weight:0;font-size:12px;">
															Class & service to which the post belongs &nbsp<sup style="color:red;">*</sup>
														</label>
													</td>

													<td>
														<select  name="classAndServiceOfPost" id="selectClass"  style="width:100%;"
														 onchange="SelectChanged(this,'desigDropDown')" data-placeholder="select...">
						                             <option value=""></option>
													<c:set var="var" value="${requisitionForm[0].classAndServiceOfPost}"/>
													
					                         		<option
													 <c:choose>
					                           		<c:when test="${'Group-B'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Group-B</option>
					                         		 <option
													 <c:choose>
					                           		<c:when test="${'Group-C'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Group-C</option>
					                         		 <option
													 <c:choose>
					                           		<c:when test="${'Group-D'==var}">
					                        		   selected
					                         		  </c:when>
					                         		 </c:choose>>Group-D</option>
													</select>
													</td>
													<td>
														<label class="pos-rel" style="font-weight:0;font-size:12px;">
															Designation of the post &nbsp<sup style="color:red;">*</sup>
														</label>
														 <i class="ace-icon fa fa-spinner fa-spin orange bigger-125" id="idSpinner" style="display:none;float:right;font-size: 150%!important;" ></i>
													</td>

													<td>

														<div id="postMasterAjaxList">
														<select name="postmasterId" class="formControl" id="desigDropDown" style="width:200px;"  data-placeholder="Search Designation...">
																	   <option value="0">Search Designation...</option>
																	  <c:forEach items="${desigList}" var="tag3" varStatus="loop">
											                          <option value="${tag3.postmasterId}" 
											                          <c:set var="var1" value="${requisitionForm[0].postmasterId}"/><c:choose>
											                           <c:when test="${tag3.postmasterId==var1}">
											                           selected
											                           </c:when>
											                          </c:choose>>${tag3.postName}</option>	
											                          </c:forEach>
														 </select>											
														</div>			
														<%-- <input:select type="text" style="width:100%" name="designationOfPost" value="${requisitionForm[0].designationOfPost}"> --%>
													</td>
													<!-- <td>&nbsp;
													</td> -->
													
												</tr>										
												<tr>
													<td>
													<label class="pos-rel" style="font-weight:0;font-size:12px;">
														 Number of posts to be filled &nbsp<sup style="color:red;">*</sup><b><br>(including backlogs)</b> &nbsp
												    </label>
													</td>
													<td>
													  <input type="text" style="width:100%" id="noOfPostForBifurcation" name="numberOfPostToBeFilled" 
													  onkeypress="return isNumberKey(event,'characters not allowed','Error1')" 
													  <c:if test="${deptInfo.onlyPwdAllowed==false && deptInfo.pwdAllowed==true}">onchange="pwdTotal();espCalculate()"</c:if>   
													  value="${requisitionForm[0].numberOfPostToBeFilled}">
													  <br>
													  <span style="color:red;" id="Error1"></span>
													</td>
													<td>
													<label class="pos-rel" style="font-weight:0;font-size:12px;">
														Whether there are any published Rules  for this service/post? &nbsp<sup style="color:red;">*</sup>
												    </label>
													</td>
													<td>
													  <div class="col-xs-12 col-sm-9">
																	<div>
																		<label class="line-height-1" style="font-weight:0;font-size:12px;"> 
																			<input name="anyPublishedRulesForService" value="Yes" <c:if test='${requisitionForm[0].anyPublishedRulesForService == "Yes"}'>checked</c:if> type="radio">
																			<span class="lbl">Yes</span>
																		</label>
																	</div>

																	<div>
																		<label class="line-height-1" style="font-weight:0;font-size:12px;">
																			<input name="anyPublishedRulesForService" value="No" <c:if test='${requisitionForm[0].anyPublishedRulesForService == "No"}'>checked</c:if> type="radio">
																			<span class="lbl"> No</span>
																		</label>
																	</div>
																</div>													</td>
													
												</tr>
												<tr>
													<td>
														<label class="pos-rel" style="font-weight:0;font-size:12px;">
															Provide the link for service rules on Department's website or upload here
                                                            (Signed and Stamped copy to be uploaded/attached) &nbsp<sup style="color:red;">*</sup>
														</label>
													</td>
                                                      		 
													<td >
														 <div class="form-group">
															<div class="col-xs-12">
																<input type="file" name="file" id="id-input-file-2" />
															</div>
														</div>
														 <input type="text" style="width:100%" name="linkForServiceRules" value="${requisitionForm[0].linkForServiceRules}">
													</td>
													<td>
													<label class="pos-rel" style="font-weight:0;font-size:12px;">
														Whether post is  permanent or temporary? &nbsp<sup style="color:red;">*</sup>
												    </label>
													</td>
													<td>
													  <div class="col-xs-12 col-sm-9">
																	<div>
																		<label class="line-height-1" style="font-weight:0;font-size:12px;"> 
																			<input name="isPostPermanentOrTemporary" value="Permanent" <c:if test='${requisitionForm[0].isPostPermanentOrTemporary == "Permanent"}'>checked</c:if> type="radio">
																			<span class="lbl">Permanent</span>
																		</label>
																	</div>

																	<div>
																		<label class="line-height-1" style="font-weight:0;font-size:12px;">
																			<input name="isPostPermanentOrTemporary" value="Temporary" <c:if test='${requisitionForm[0].isPostPermanentOrTemporary == "Temporary"}'>checked</c:if> type="radio">
																			<span class="lbl">Temporary</span>
																		</label>
																	</div>
																	<div>
																		<label class="line-height-1" style="font-weight:0;font-size:12px;"> 
																			<input name="isPostPermanentOrTemporary" value="PermanentAndTemorary(both)" <c:if test='${requisitionForm[0].isPostPermanentOrTemporary == "PermanentAndTemorary(both)"}'>checked</c:if> type="radio">
																			<span class="lbl">Permanent And Temorary (both)</span>
																		</label>
																	</div>
																</div>		
													</td>
													
												</tr>
												<tr>
												  <td>
												    <label class="pos-rel" style="font-weight:0;font-size:12px;">
														Job Description
												    </label>
												  </td>
												  <td colspan='3'>
												       <textarea
														maxlength="1000"
														style='width: 250px; height: 70px; resize: none;'
														name="jobDescription" id="idJobDescription">${requisitionForm[0].jobDescription}</textarea>
												       <br>
													  <span style="color:red;" id="Error2"></span>
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
												  <label style="font-weight:0;font-size:12px;">
												          (a)  For direct recruits &nbsp<sup style="color:red;">*</sup>
												       </label>
												  </td>
												  <td >
												  <input name="scaleOfPayForDirectRecruits" style="width:100%" type="text" value="${requisitionForm[0].scaleOfPayForDirectRecruits}">
												   <br>
													  <span style="color:red;" id="Error2"></span>
												  </td>
												  <td rowspan="3">
												   <label style="font-weight:0;font-size:12px;">
												            Will any special concessions be given to  a candidate of non-Asiatic domicile ? &nbsp<sup style="color:red;">*</sup>
												       </label>
												  </td >
												  <td rowspan="3">
												    <div class="col-xs-12 col-sm-9">
																	<div>
																		<label class="line-height-1" style="font-weight:0;font-size:12px;"> 
																			<input name="anySpecialConcessionsForNonAsiaticDomicile" value="Yes" <c:if test='${requisitionForm[0].anySpecialConcessionsForNonAsiaticDomicile== "Yes"}'>checked</c:if> type="radio">
																			<span class="lbl">Yes</span>
																		</label>
																	</div>

																	<div>
																		<label class="line-height-1" style="font-weight:0;font-size:12px;">
																			<input name="anySpecialConcessionsForNonAsiaticDomicile" value="No" <c:if test='${requisitionForm[0].anySpecialConcessionsForNonAsiaticDomicile== "No"}'>checked</c:if> type="radio">
																			<span class="lbl">No</span>
																		</label>
																	</div>
																</div>	
												  </td>											
												</tr>
												<tr>
												  <td >
												  <label style="font-weight:0;font-size:12px;">
												         (b)  For persons already in Government service, if Government servants are eligible &nbsp<sup style="color:red;">*</sup>
												       </label>
												  </td>
												  <td >
												  <input name="scaleOfPayForPersonsAlreadyInGovernmentService" style="width:100%" type="text"  value="${requisitionForm[0].scaleOfPayForPersonsAlreadyInGovernmentService}">
												    <br>
													  <span style="color:red;" id="Error3"></span>
												  </td>
												</tr>
												<tr>
												  <td >
												  <label style="font-weight:0;font-size:12px;">
												         (c) Can higher initial pay be granted for specially well-qualified candidates? if so, please specify the limit &nbsp<sup style="color:red;">*</sup>
												       </label>
												  </td>
												  <td>
												  <input name="higherInitialPayBeGranted" style="width:100%" type="text"  value="${requisitionForm[0].higherInitialPayBeGranted}">
												    <br>
													  <span style="color:red;" id="Error4"></span>
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
												      <label style="font-weight:0;font-size:12px;">
												         Academic. (If more than one  qualifications  are prescribed, it should  be stated which is considered to be most  important ) &nbsp
<!-- 												         <label style="font-weight:400;font-size:12px;color:red"><i>As per Group D Act</i></label> -->
												       </label>
												   </td>
												   <td>
												      
														 <input name="academicQualifications" style="width:100%" type="text"  value="${requisitionForm[0].academicQualifications}">
												   </td>
												   <td>
												     <label style="font-weight:0;font-size:12px;">
                                                        Training &nbsp<sup style="color:red;">*</sup>
												      </label>
												   </td>
												   <td>
												      <!-- <div>
															<select  class="chosen-select form-control" id="form-field-select-4" data-placeholder="Choose a State...">
																<option value="AL">Alabama</option>
																<option value="AK">Alaska</option>
																<option value="AZ">Arizona</option>
															</select>
														</div> -->
														<input name="training" style="width:100%" type="text" value="${requisitionForm[0].training}">
												   </td>
												</tr>
												<tr>
												  <td>
												    <label style="font-weight:0;font-size:12px;">
                                                        Hindi qualification &nbsp<sup style="color:red;">*</sup>
												      </label>
												  </td>
												  <td>
												     <!-- <div>
															<select  class="chosen-select form-control" id="form-field-select-4" data-placeholder="Choose a State...">
																<option value="AL">Alabama</option>
																<option value="AK">Alaska</option>
																<option value="AZ">Arizona</option>
															</select>
														</div> -->
														<input name="hindiQualification" style="width:100%" type="text" value="hindi/sanskrit upto matriculation as one of the subject" readonly>
												  </td>
												  <td>
												     <label style="font-weight:0;font-size:12px;">
                                                        Experience (in years and Months) &nbsp<sup style="color:red;">*</sup>
												      </label>
												  </td>
												  <td>
												    <input name="experience" style="width:20%" type="text" onkeypress="return isNumberKey(event,'characters not allowed','Error7')" value="${requisitionForm[0].experience}"><input name="experienceInMonths" style="margin-left:5px;width:20%" type="text" onkeypress="return isNumberKey(event,'characters not allowed','Error7')"  onchange='validateMonths( this)' value="${requisitionForm[0].experienceInMonths}" maxlength=2>    
												   <br>
													  <span style="color:red;" id="Error7"></span>
												  </td>
												</tr>
												<tr>
												  <td>
												     <label style="font-weight:0;font-size:12px;">
                                                        State clearly whether the experience  gained by a candidate after acquiring the  minimum basic qualification (s)  prescribed against clause (a) above is to  be taken into consideration &nbsp<sup style="color:red;">*</sup>
												      </label>
												  </td>
												  <td>
												     <div class="col-xs-12 col-sm-9">
																	<div>
																		<label class="line-height-1" style="font-weight:0;font-size:12px;"> 
																			<input name="isExperienceTakenIntoConsidration" value="Yes" <c:if test='${requisitionForm[0].isExperienceTakenIntoConsidration== "Yes"}'>checked</c:if> type="radio">
																			<span class="lbl">Yes</span>
																		</label>
																	</div>

																	<div>
																		<label class="line-height-1" style="font-weight:0;font-size:12px;">
																			<input name="isExperienceTakenIntoConsidration" value="No" <c:if test='${requisitionForm[0].isExperienceTakenIntoConsidration== "No"}'>checked</c:if> type="radio">
																			<span class="lbl">No</span>
																		</label>
																	</div>
																</div>	
												  </td>
												  <td>
												    <label style="font-weight:0;font-size:12px;">
                                                       Will equivalent qualifications be  accepted? If so, equivalents should be  stated &nbsp<sup style="color:red;">*</sup>
												      </label>
												</td>
												<td>
												    <input name="equivalentQualifications" style="width:100%" type="text" value="${requisitionForm[0].equivalentQualifications}">
												 </td>
												</tr>
												<tr>
												 <td>
												    <label style="font-weight:0;font-size:12px;">
                                                       Any other qualifications &nbsp<sup style="color:red;">*</sup>
												      </label>
												 </td>
												 <td>
												    <input name="anyOtherQualifications" style="width:100%" type="text" value="${requisitionForm[0].anyOtherQualifications}">
												 </td>
												 <td>
												   <label style="font-weight:0;font-size:12px;">
                                                       State which of the above requirements  will be strictly adhered. &nbsp<sup style="color:red;">*</sup>
												      </label>
												</td>
												<td>
												   <input name="requirementsStrictlyAthered" style="width:100%" type="text" value="${requisitionForm[0].requirementsStrictlyAthered}">
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
											       <label style="font-weight:0;font-size:12px;">
                                                       Lower (in Years) &nbsp
												      </label>
<!--  														<label style="font-weight:400;font-size:12px;color:red"><i>As per Group D Act</i></label>												       -->
											    </td>
											    <td>
											        <input name="lowerAgeLimit" style="width:100%" type="text" 
											        onkeypress="return isNumberKey(event,'characters not allowed','Error5')"  value="${requisitionForm[0].lowerAgeLimit}">
											      <br>
													  <span style="color:red;" id="Error5"></span>
											    </td>
											    <td>
											       <label style="font-weight:0;font-size:12px;">
                                                       Upper (in Years) &nbsp
												      </label>
<!--  														<label style="font-weight:400;font-size:12px;color:red"><i>As per Group D Act</i></label>												       -->
											    </td>
											    <td>
											      <input name="upperAgeLimit" style="width:100%" type="text" 
											      onkeypress="return isNumberKey(event,'characters not allowed','Error6')" value="${requisitionForm[0].upperAgeLimit}">
											     <br>
													  <span style="color:red;" id="Error6"></span>
											    </td>
											    </tr>
											    <tr> 
											      <td>
											      <label style="font-weight:0;font-size:12px;"> 
                                                       Exact date on which the age is to be determined &nbsp
												      </label>
												  <label style="font-weight:400;font-size:12px;color:red"><i>Age will be determined on the last date of receipe of applications, as advertised by Commission</i></label>	 
											    </td>
											    <td>
											       <input name="dateOnWhichAgeIsDetermined" class="form-control date-picker" id="id-date-picker-1" style="width:50%" type="text" value="${requisitionForm[0].dateOnWhichAgeIsDetermined}">
											    </td>
											    <td>
											      <label style="font-weight:0;font-size:12px;">
                                                      Are Government servants eligible? &nbsp<sup style="color:red;">*</sup>
												      </label>
											    </td>
											    <td>
											    <div class="col-xs-12 col-sm-9">
																	<div>
																		<label class="line-height-1" style="font-weight:0;font-size:12px;"> 
																			<input name="areGovServantsEligible" value="Yes" <c:if test='${requisitionForm[0].areGovServantsEligible== "Yes"}'>checked</c:if> type="radio">
																			<span class="lbl">Yes</span>
																		</label>
																	</div>

																	<div>
																		<label class="line-height-1" style="font-weight:0;font-size:12px;">
																			<input name="areGovServantsEligible" value="No" <c:if test='${requisitionForm[0].areGovServantsEligible== "No"}'>checked</c:if> type="radio">
																			<span class="lbl">No</span>
																		</label>
																	</div>
																</div>	
											    </td>
											    </tr>
											    <tr>
											      <td colspan="4">
											         <label style="font-weight:600;font-size:12px;">
												           Whether any relaxation is admissible for: 
												       </label>
											      </td>
											    </tr> 	
											    <tr>
											      <td>
											      <label style="font-weight:0;font-size:12px;">
                                                      (i) Government servants &nbsp<sup style="color:red;">*</sup>
												      </label>
											      </td>
											      <td>
											      <div class="col-xs-12 col-sm-9">
																	<div>
																		<label class="line-height-1" style="font-weight:0;font-size:12px;"> 
																			<input name="anyRelaxationForGovServents" value="Yes" <c:if test='${requisitionForm[0].anyRelaxationForGovServents== "Yes"}'>checked</c:if> type="radio">
																			<span class="lbl">Yes</span>
																		</label>
																	</div>

																	<div>
																		<label class="line-height-1" style="font-weight:0;font-size:12px;">
																			<input name="anyRelaxationForGovServents" value="No" <c:if test='${requisitionForm[0].anyRelaxationForGovServents== "No"}'>checked</c:if> type="radio">
																			<span class="lbl">No</span>
																		</label>
																	</div>
																</div>
											      </td>
											      <td>
											         <label style="font-weight:0;font-size:12px;">
                                                      (ii) Otherwise suitable candidates &nbsp<sup style="color:red;">*</sup>
												      </label>
											      </td>
											      <td>
											      <div class="col-xs-12 col-sm-9">
																	<div>
																		<label class="line-height-1" style="font-weight:0;font-size:12px;"> 
																			<input name="anyRelaxationForSutaibleCandidates" value="Yes" <c:if test='${requisitionForm[0].anyRelaxationForSutaibleCandidates== "Yes"}'>checked</c:if> type="radio">
																			<span class="lbl">Yes</span>
																		</label>
																	</div>

																	<div>
																		<label class="line-height-1" style="font-weight:0;font-size:12px;">
																			<input name="anyRelaxationForSutaibleCandidates" value="No"  <c:if test='${requisitionForm[0].anyRelaxationForSutaibleCandidates== "No"}'>checked</c:if>  type="radio">
																			<span class="lbl">No</span>
																		</label>
																	</div>
																</div>
											      </td>
											    </tr>
                             <!-- *************************************For Group C and D******************************************************-->
											     <tr>
											       <td colspan="4">
											          <label style="font-weight:900;font-size:14px;">
												          Total Vacancies and vertical/horizontal reservation as per state policy 
												       </label>
												        <span style="color:red;margin-left:100px" id="Error10"></span>
												       <br>
											          <label style="font-weight:400;font-size:12px;color:red">
<!-- 												        <i> Recruitment for SBC/EBPGC category has been stayed as per orders from High Court.</i><br> -->
												        <i><b>ESP (3% of Group B, 3% of Group C and 10% of Group D)</b> as per instruction No. 22/10/2013-1GSIII dated 30.04.2019</i>
												       </label>
												       
											       </td>
											     </tr>
											      <tr> 
											        <td colspan="4">
											        <c:choose>
											          <c:when test="${empty requisitionForm[0].idRequisition}">
											         
											             <table id="simple" class="table  table-bordered table-hover">
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
											                 <tr>
											                   <td colspan="2">
											                     <label>
											                        GENERAL
											                     </label>
											                     <input type="hidden" name="bifurcationList[0].category" value="GENERAL">
											                   </td>
											                   <td>
											                     <input type="text" name="bifurcationList[0].totalCount" onchange='validateTotal( this)' readonly >
											                   </td>
											                    <td>
											                     <input type="text" name="bifurcationList[0].nonEsmEspCount" onchange='validateTotal( this)' 
											                     value="${requisitionForm[0].bifurcationList[0].nonEsmEspCount}" onkeypress="return isNumberKey(event,'characters not allowed','Error10')"
											                     <c:if test="${deptInfo.onlyPwdAllowed==true}">readonly</c:if>>
											                   </td>
											                    <td>
											                     <input type="text" name="bifurcationList[0].esmCount" onchange='validateTotal( this)' 
											                     value="${requisitionForm[0].bifurcationList[0].esmCount}" onkeypress="return isNumberKey(event,'characters not allowed','Error10')"
											                    <c:if test="${deptInfo.onlyPwdAllowed==true}">readonly</c:if>>
											                   </td>
											                   <td>
											                      <input type="text" name="bifurcationList[0].espCount" onchange='validateTotal( this)' 
											                      value="${requisitionForm[0].bifurcationList[0].espCount}" onkeypress="return isNumberKey(event,'characters not allowed','Error10')"
											                      <c:if test="${deptInfo.onlyPwdAllowed==true}">readonly</c:if>>
											                   </td>
											                 </tr>
											                 <tr>
											                   <td colspan="2">
											                     <label >
											                        SC
											                     </label>
											                      <input type="hidden" name="bifurcationList[1].category" value="SC">
											                   </td>
											                   <td>
											                     <input type="text" name="bifurcationList[1].totalCount" onchange='validateTotal( this)' readonly>
											                   </td>
											                    <td>
											                     <input type="text" name="bifurcationList[1].nonEsmEspCount" value="${requisitionForm[0].bifurcationList[1].nonEsmEspCount}" 
											                     onchange='validateTotal( this)' onkeypress="return isNumberKey(event,'characters not allowed','Error10')"
											                    <c:if test="${deptInfo.onlyPwdAllowed==true}">readonly</c:if>>
											                   </td>
											                    <td>
											                     <input type="text" name="bifurcationList[1].esmCount" value="${requisitionForm[0].bifurcationList[1].esmCount}" 
											                     onchange='validateTotal( this)' onkeypress="return isNumberKey(event,'characters not allowed','Error10')"
											                    <c:if test="${deptInfo.onlyPwdAllowed==true}">readonly</c:if>>
											                   </td>
											                    <td>
											                      <input type="text" name="bifurcationList[1].espCount" value="${requisitionForm[0].bifurcationList[1].espCount}" 
											                      onchange='validateTotal( this)' onkeypress="return isNumberKey(event,'characters not allowed','Error10')"
											                      <c:if test="${deptInfo.onlyPwdAllowed==true}">readonly</c:if>>
											                   </td> 
											                 </tr>
											                 <tr>
											                   <td colspan="2">
											                     <label>
											                       BCA
											                     </label>
											                     <input type="hidden" name="bifurcationList[2].category"  value="BCA">
											                   </td>
											                   <td>
											                     <input type="text" name="bifurcationList[2].totalCount" onchange='validateTotal( this)' readonly>
											                   </td>
											                    <td>
											                     <input type="text" name="bifurcationList[2].nonEsmEspCount" value="${requisitionForm[0].bifurcationList[2].nonEsmEspCount}" 
											                     onchange='validateTotal( this)' onkeypress="return isNumberKey(event,'characters not allowed','Error10')"
											                     <c:if test="${deptInfo.onlyPwdAllowed==true}">readonly</c:if>>
											                   </td>
											                    <td>
											                     <input type="text" name="bifurcationList[2].esmCount" value="${requisitionForm[0].bifurcationList[2].esmCount}" 
											                     onchange='validateTotal( this)' onkeypress="return isNumberKey(event,'characters not allowed','Error10')"
											                    <c:if test="${deptInfo.onlyPwdAllowed==true}">readonly</c:if>>
											                   </td>
											                    <td>
											                      <input type="text" name="bifurcationList[2].espCount" value="${requisitionForm[0].bifurcationList[2].espCount}" 
											                      onchange='validateTotal( this)' onkeypress="return isNumberKey(event,'characters not allowed','Error10')"
											                     <c:if test="${deptInfo.onlyPwdAllowed==true}">readonly</c:if>>
											                   </td> 
											                 </tr>
											                 <tr>
											                   <td colspan="2">
											                     <label>
											                        BCB
											                     </label>
											                      <input type="hidden" name="bifurcationList[3].category" value="BCB" >
											                   </td>
											                   <td>
											                     <input type="text" name="bifurcationList[3].totalCount"  onchange='validateTotal( this)' readonly>
											                   </td>
											                    <td>
											                     <input type="text" name="bifurcationList[3].nonEsmEspCount" value="${requisitionForm[0].bifurcationList[3].nonEsmEspCount}" 
											                     onchange='validateTotal( this)' onkeypress="return isNumberKey(event,'characters not allowed','Error10')"
											                     <c:if test="${deptInfo.onlyPwdAllowed==true}">readonly</c:if>>
											                   </td>
											                    <td>
											                     <input type="text" name="bifurcationList[3].esmCount" value="${requisitionForm[0].bifurcationList[3].esmCount}" 
											                     onchange='validateTotal( this)' onkeypress="return isNumberKey(event,'characters not allowed','Error10')"
											                     <c:if test="${deptInfo.onlyPwdAllowed==true}">readonly</c:if>>
											                   </td>
											                    <td>
											                      <input type="text" name="bifurcationList[3].espCount" value="${requisitionForm[0].bifurcationList[3].espCount}" 
											                      onchange='validateTotal( this)' onkeypress="return isNumberKey(event,'characters not allowed','Error10')"
											                      <c:if test="${deptInfo.onlyPwdAllowed==true}">readonly</c:if>>
											                   </td> 
											                 </tr>
											                 <%-- <tr>
											                   <td colspan="2">
											                     <label>
											                        SBC
											                     </label>
											                     <input type="hidden" name="bifurcationList[4].category" value="SBC">
											                   </td>
											                   <td>
											                     <input type="text" name="bifurcationList[4].totalCount"  onchange='validateTotal( this)'  readonly>
											                   </td>
											                    <td>
											                     <input type="text" name="bifurcationList[4].nonEsmEspCount" value="${requisitionForm[0].bifurcationList[4].nonEsmEspCount}" onchange='validateTotal( this)' onkeypress="return isNumberKey(event,'characters not allowed','Error10')" readonly>
											                   </td>
											                    <td>
											                     <input type="text" name="bifurcationList[4].esmCount" value="${requisitionForm[0].bifurcationList[4].esmCount}" onchange='validateTotal( this)' onkeypress="return isNumberKey(event,'characters not allowed','Error10')" readonly>
											                   </td>
											                    <td>
											                      <input type="text" name="bifurcationList[4].espCount" value="${requisitionForm[0].bifurcationList[4].espCount}" onchange='validateTotal( this)' onkeypress="return isNumberKey(event,'characters not allowed','Error10')" readonly>
											                   </td> 
											                 </tr> --%>
											                 <tr>
											                   <td colspan="2">
											                     <label>
											                        EWS
											                     </label>
											                   <input type="hidden" name="bifurcationList[4].category" value="EWS">
											                   </td>
											                   <td>
											                     <input type="text" name="bifurcationList[4].totalCount" onchange='validateTotal( this)' readonly> 
											                   </td>
											                    <td>
											                     <input type="text" name="bifurcationList[4].nonEsmEspCount" value="${requisitionForm[0].bifurcationList[5].nonEsmEspCount}" onchange='validateTotal( this)' onkeypress="return isNumberKey(event,'characters not allowed','Error10')" >
											                   </td>
											                    <td>
											                     <input type="text" name="bifurcationList[4].esmCount" value="${requisitionForm[0].bifurcationList[5].esmCount}" onchange='validateTotal( this)' onkeypress="return isNumberKey(event,'characters not allowed','Error10')" >
											                   </td>
											                   <td>
											                      <input type="text" name="bifurcationList[4].espCount" value="${requisitionForm[0].bifurcationList[5].espCount}" onchange='validateTotal( this)' onkeypress="return isNumberKey(event,'characters not allowed','Error10')" >
											                   </td> 
											                 </tr>
											                  <tr>
											                   <td>
											                     <label>
											                        <b>Total Calculated</b>
											                     </label>
											                   </td>
											                   <td>
											                      <input type="text" name="totalSeatsFilled" value="${totalFilled}" readonly>
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
											                      <input type="text" name="espSeats" id="totalesp" value="${requisitionForm[0].espSeats}" onchange='validateESP()'>
											                   </td> --%>
											                   </tr>
											                   <tr>
											                       <td>
                                                                <b>PWD (4% of Total Seats) The	computation of 4% reservation is on the basis of total no of posts in the cadre minus existing strength of PwD (Person with Disability)</b>
<!--                                                                  <input type="text" id="totalPwd" name="totalPWDSeats" readonly> -->
                                                                <input type="hidden" id="totalPwd" name="totalPWDSeats" value=" ${requisitionForm[0].totalPWDSeats}" >   
                                                             </td>
                                                             <td>
                                                                   Blindness and low vision <br><input type="text" id="blVision" onchange="showPHBifurcation()" name="pwd1" value=" ${requisitionForm[0].pwd1}" 
<%--                                                                     <c:if test="${deptInfo.onlyPwdAllowed==false && deptInfo.pwdAllowed==true}">onchange='validateTotalPWD( this)'</c:if>  --%>
                                                                    <c:if test="${deptInfo.pwdAllowed==false}">readonly</c:if>
                                                                    onkeypress="return isNumberKey(event,'characters not allowed','Error10')">
                                                             </td>
                                                             <td>
                                                                   Deaf	and hard of hearing <br><input type="text" id="hhVision" onchange="showPHBifurcation()" name="pwd2" value=" ${requisitionForm[0].pwd2}" 
<%--                                                                      <c:if test="${deptInfo.onlyPwdAllowed==false && deptInfo.pwdAllowed==true}">onchange='validateTotalPWD( this)'</c:if>  --%>
                                                                     <c:if test="${deptInfo.pwdAllowed==false}">readonly</c:if>
                                                                    onkeypress="return isNumberKey(event,'characters not allowed','Error10')">
                                                             </td>
                                                             <td>
                                                                    locomotor disability including cerebral palsy, leprosy cured, dwarfism, 
                                                                    acid attack victims and muscular dystrophy <br><input type="text" id="ohVision" onchange="showPHBifurcation()" name="pwd3" value=" ${requisitionForm[0].pwd3}"  
<%--                                                                       <c:if test="${deptInfo.onlyPwdAllowed==false && deptInfo.pwdAllowed==true}">onchange='validateTotalPWD( this)'</c:if>  --%>
                                                                      <c:if test="${deptInfo.pwdAllowed==false}">readonly</c:if>
                                                                    onkeypress="return isNumberKey(event,'characters not allowed','Error10')"> 
                                                             </td>
                                                             <td colspan="2">
                                                                   autism, intellectual disability, specific learning disability and mental illness <br><b>AND</b><br>
                                                                    multiple disabilities from amongst person under all clauses including deaf-blindness in the posts identified for each disabilities 
                                                                    <br> <input type="text" name="pwd4" value=" ${requisitionForm[0].pwd4}"  
<%--                                                                     <c:if test="${deptInfo.onlyPwdAllowed==false && deptInfo.pwdAllowed==true}">onchange='validateTotalPWD( this)'</c:if>  --%>
                                                                    <c:if test="${deptInfo.pwdAllowed==false}">readonly</c:if>
                                                                   onkeypress="return isNumberKey(event,'characters not allowed','Error10')">
                                                             </td>
                                                             
											                   </tr>
											                   <tr>
											                      <td colspan="6">
											                         <i><b>Note:</b> If the posts are not identified, no need to fill up the column of bifurcation.</i>
											                      </td>
											                   </tr>
											                      <tr id="vh" style="display:none">
												                      <td>
												                        <b>
												                         Visual Handicap Bifurcation
												                        </b>
												                      </td>
											                         <td colspan="2">
											                           Blind (B)<br>
											                           <input name="pwdB" type="text">
											                         </td>
											                         <td colspan="3">
											                          Low Vision (LV) <br>
											                           <input name="pwdL" type="text">
											                         </td>
											                      </tr>
											                      <tr id="hh" style="display:none">
											                      <td>
												                        <b>
												                         Hearing Handicap Bifurcation
												                        </b>
												                      </td>
											                         <td colspan="2">
											                           Fully Deaf (FD)<br>
											                           <input name="pwdFD" type="text">
											                         </td>
											                         <td colspan="3">
											                          Hard of  Hearing/Partial Deaf (HH/PD)<br>
											                           <input name="pwdHH" type="text">
											                         </td>
											                      </tr>
											                       <tr id="orthoHed"  style="display:none">
											                          <td colspan="6" >
											                              <b>locomotor disability including cerebral palsy, leprosy cured, dwarfism, acid attack victims and muscular dystrophy</b>
											                          </td>
											                       </tr>
											                      <tr id="oh" style="display:none">
											                         <td >
											                           One Leg (OL)<br>
											                           <input name="pwdOL" type="text">
											                         </td>
											                         <td >
											                           One Arm (OA)<br>
											                           <input name="pwdOA" type="text">
											                         </td>
											                         <td >
											                           Both Arms (BA)<br>
											                           <input name="pwdBA" type="text">
											                         </td>
											                         <td >
											                           Both Hands (BH)<br>
											                           <input name="pwdBH" type="text">
											                         </td>
											                         <td colspan="2">
											                          Muscular Weakness (MW)<br>
											                           <input name="pwdMW" type="text">
											                         </td>
											                        
											                      </tr>
											                      <tr id="oh1" style="display:none">
											                         <td >
											                           One Arm One Leg (OAL)<br>
											                           <input name="pwdOAL" type="text">
											                         </td>
											                         <td >
											                           Both Legs and Arms (BLA)<br>
											                           <input name="pwdBLA" type="text">
											                         </td>
											                         <td >
											                           Both Legs One Arm (BLOA)<br>
											                           <input name="pwdBLOA" type="text">
											                         </td>
											                         <td >
											                           Cerebral paisy<br>
											                           <input name="pwdCPaisy" type="text">
											                         </td>
											                         <td colspan="2">
											                           leprosy cured<br>
											                           <input  name="pwdLCured" type="text">
											                         </td>
											                      </tr>
											                      <tr id="oh2" style="display:none">
											                         <td >
											                           dwarfism<br>
											                           <input  name="pwdDwarfism" type="text">
											                         </td>
											                         <td >
											                           acid attack victims<br>
											                           <input name="pwdAAVictims" type="text">
											                         </td>
											                         <td >
											                           muscular dystrophy<br>
											                           <input  name="pwdMDystrophy"type="text">
											                         </td>
											                         <td colspan="3">
											                           others<br>
											                           <input name="pwdOthers" type="text">
											                         </td>
											                      </tr>
											               </tbody>
											               </table>
											           </c:when>
											        </c:choose>     
											         <c:choose>
											        <c:when test="${not empty requisitionForm[0].idRequisition || not empty helperList}">
											        <div id="secondTable">
											       <table id="simple" class="table  table-bordered table-hover">
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
											                 <c:forEach items="${helperList}" var="req" varStatus="loop">
        														<tr>
          												  <td colspan="2"> <c:out value="${req.category}"/>
          												   <input type="hidden" class="readOnly" name="bifurcationList[${loop.index}].category" value="<c:out value="${req.category}"/>">
          												   </td>  
          												 <td> 
          												  <%-- <c:out value="${req.totalCount}"/> --%>
          												  <input type="text" name="bifurcationList[${loop.index}].totalCount" value="<c:out value="${req.totalCount}"/>" 
          												  onchange='validateTotal( this)'
          												 readonly></td>     												 
          												 <td>
															<input type="text" name="bifurcationList[${loop.index}].nonEsmEspCount" 
															value="<c:out value="${req.nonEsmEspCount}"/>" onchange='validateTotal( this)' 
															onkeypress="return isNumberKey(event,'characters not allowed','Error10')"
																 <c:if test="${req.category == 'SBC' || deptInfo.onlyPwdAllowed==true}">readonly</c:if>
															>
          												    
          												 </td>
          												 <td> 
          												 	<input type="text" name="bifurcationList[${loop.index}].esmCount" 
          												 	value="<c:out value="${req.esmCount}"/>" onchange='validateTotal( this)' 
          												 	onkeypress="return isNumberKey(event,'characters not allowed','Error10')"
          												 	 <c:if test="${req.category == 'SBC' || deptInfo.onlyPwdAllowed==true}">readonly</c:if>
          												 	 >
          												  <td> 
          												 <input type="text" name="bifurcationList[${loop.index}].espCount" 
          												 value="<c:out value="${req.espCount}"/>" 
          												 onchange='validateTotal( this)' 
          												 onkeypress="return isNumberKey(event,'characters not allowed','Error10')"
          													 <c:if test="${req.category == 'SBC' || req.category == 'EBPGC' || deptInfo.onlyPwdAllowed==true}">readonly</c:if>
          												 ></td> 
        													</tr>
       														<%-- <tr>
          												 <td> 
          												 <input type="text" id = "bifurcationList[${loop.index}].totalCountBackLog" name="bifurcationList[${loop.index}].totalCountBackLog" value=" <c:out value="${req.totalCountBackLog}"/>" readonly>  
          												 </td>
          												 <td> 
          												  <input type="text" id="bifurcationList[${loop.index}].nonEsmEspCountBackLog" name="bifurcationList[${loop.index}].nonEsmEspCountBackLog" value=" <c:out value="${req.nonEsmEspCountBackLog}"/>" onchange='javascript:fnTotalFilled()'>
          												 
          												 </td>
          												 <td> 
          												 <input type="text" id="bifurcationList[${loop.index}].espCountBackLog" name="bifurcationList[${loop.index}].espCountBackLog" value=" <c:out value="${req.espCountBackLog}"/>" onchange='javascript:fnTotalFilled()'>
          												 </td>
          												 <td>
          												 <input type="text" id ="bifurcationList[${loop.index}].esmCountBackLog" name="bifurcationList[${loop.index}].esmCountBackLog" value=" <c:out value="${req.esmCountBackLog}"/>" onchange='javascript:fnTotalFilled()'>
          												   </td>          												 
        													</tr> --%>
        													
  															  </c:forEach>
                                                            <tr> 
                                                             <td>
                                                                <b>Total Calculated</b>
                                                             </td>
                                                             <td>
                                                               <input type="text" name="totalSeatsFilled" value="${requisitionForm[0].totalFilled}" readonly /> 
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
                                                               <input type="text" name="espSeats" id="totalesp" value="${requisitionForm[0].espSeats}" onchange='validateESP()'/> 
                                                             </td> --%>
                                                            </tr>
                                                            <%-- <tr>
                                                             <td>
                                                                <b>Total Backlogs</b>
                                                             </td>
                                                             <td>
                                                                <input type="text" name="totalFilled" value="${requisitionForm[0].totalFilled}" readonly />
                                                             </td>
															</tr> --%>
															<tr>                                                            
                                                             <td>
                                                                <b>PWD (4% of Total Seats) The computation of 4% reservation is on the basis of total no of posts in the cadre minus existing strength of PwD (Person with Disability)</b>
<%--                                                                 <input type="text" id="totalPwd" name="totalPWDSeats" value="${requisitionForm[0].totalPWDSeats}" readonly> --%>
                                                                <input type="hidden" id="totalPwd" name="totalPWDSeats" value=" ${requisitionForm[0].totalPWDSeats}" readonly >   
                                                             </td>
                                                             <td>
                                                                   Blindness and low vision <br><input type="text" name="pwd1" id="bl1Vision" onchange="showPHBifurcation1()" value=" ${requisitionForm[0].pwd1}"  
<%--                                                                    <c:if test="${deptInfo.onlyPwdAllowed==false && deptInfo.pwdAllowed==true}">onchange='validateTotalPWD( this)'</c:if>  --%>
                                                                   <c:if test="${deptInfo.pwdAllowed==false}">readonly</c:if>
                                                                   onkeypress="return isNumberKey(event,'characters not allowed','Error10')">
                                                             </td>
                                                             <td>
                                                                   Deaf and hard of hearing <br><input type="text" name="pwd2" id="hh1Vision" onchange="showPHBifurcation1()" value=" ${requisitionForm[0].pwd2}"  
<%--                                                                   <c:if test="${deptInfo.onlyPwdAllowed==false && deptInfo.pwdAllowed==true}">onchange='validateTotalPWD( this)'</c:if> --%>
                                                                  <c:if test="${deptInfo.pwdAllowed==false}">readonly</c:if>  
                                                                   onkeypress="return isNumberKey(event,'characters not allowed','Error10')">
                                                             </td>
                                                             <td>
                                                                    locomotor disability including cerebral palsy, leprosy cured, dwarfism, 
                                                                    acid attack victims and muscular dystrophy <br><input type="text" id="oh1Vision" onchange="showPHBifurcation1()" name="pwd3" value=" ${requisitionForm[0].pwd3}"  
<%--                                                                    <c:if test="${deptInfo.onlyPwdAllowed==false && deptInfo.pwdAllowed==true}">onchange='validateTotalPWD( this)'</c:if>  --%>
                                                                   <c:if test="${deptInfo.pwdAllowed==false}">readonly</c:if>
                                                                    onkeypress="return isNumberKey(event,'characters not allowed','Error10')">
                                                             </td>
                                                             <td colspan="2">
                                                                   autism, intellectual disability, specific learning disability and mental illness <br><b>AND</b><br>
                                                                    multiple disabilities from amongst person under all clauses including deaf-blindness in the posts identified for each disabilities  <br><input type="text" name="pwd4" value=" ${requisitionForm[0].pwd4}"  
<%--                                                                    <c:if test="${deptInfo.onlyPwdAllowed==false && deptInfo.pwdAllowed==true}">onchange='validateTotalPWD( this)'</c:if>  --%>
                                                                   <c:if test="${deptInfo.pwdAllowed==false}">readonly</c:if>
                                                                   onkeypress="return isNumberKey(event,'characters not allowed','Error10')">
                                                             </td>
                                                                 
                                                           </tr>
                                                            <tr>
											                      <td colspan="6">
											                         <i><b>Note:</b> If the posts are not identified, no need to fill up the column of bifurcation.</i>
											                      </td>
											                   </tr>
                                                           
                                                               <tr id="vh1" <c:if test="${ empty requisitionForm[0].pwd1}">style="display:none" </c:if>>
												                      <td>
												                        <b>
												                         Visual Handicap Bifurcation
												                        </b>
												                      </td>
											                         <td colspan="2">
											                           Blind (B)<br>
											                           <input name="pwdB" type="text" value="${requisitionForm[0].pwdB}">
											                         </td>
											                         <td colspan="3">
											                           Low Vision (LV) <br>
											                           <input name="pwdL" type="text" value="${requisitionForm[0].pwdL}">
											                         </td>
											                      </tr>
                                                          
                                                            
                                                                 <tr id="hh1"<c:if test="${empty requisitionForm[0].pwd2}"> style="display:none"</c:if>>
											                      <td>
												                        <b>
												                         Hearing Handicap Bifurcation
												                        </b>
												                      </td>
											                         <td colspan="2">
											                           Fully Deaf (FD<br>
											                           <input name="pwdFD" type="text" value="${requisitionForm[0].pwdFD}">
											                         </td>
											                         <td colspan="3">
											                           Hard of  Hearing/Partial Deaf    (HH/PD)<br>
											                           <input name="pwdHH" type="text" value="${requisitionForm[0].pwdHH}">
											                         </td>
											                      </tr>
                                                            
                                                            
                                                                <tr id="orthoHed1"  <c:if test="${empty requisitionForm[0].pwd3}"> style="display:none" </c:if>>
											                          <td colspan="6" >
											                              <b>locomotor disability including cerebral palsy, leprosy cured, dwarfism, acid attack victims and muscular dystrophy</b>
											                          </td>
											                       </tr>
											                      <tr id="oh0" <c:if test="${empty requisitionForm[0].pwd3}"> style="display:none" </c:if>>
											                         <td >
											                           One Leg (OL)<br>
											                           <input name="pwdOL" type="text" value="${requisitionForm[0].pwdOL}">
											                         </td>
											                         <td >
											                           One Arm (OA)<br>
											                           <input name="pwdOA" type="text" value="${requisitionForm[0].pwdOA}">
											                         </td>
											                         <td >
											                           Both Arms (BA)<br>
											                           <input name="pwdBA" type="text" value="${requisitionForm[0].pwdBA}">
											                         </td>
											                         <td >
											                          Both Hands (BH)<br>
											                           <input name="pwdBH" type="text" value="${requisitionForm[0].pwdBH}" >
											                         </td>
											                         <td colspan="2">
											                           Muscular Weakness (MW)<br>
											                           <input name="pwdMW" type="text" value="${requisitionForm[0].pwdMW}">
											                         </td>
											                        
											                      </tr>
											                      <tr id="oh11" <c:if test="${empty requisitionForm[0].pwd3}"> style="display:none" </c:if>>
											                         <td >
											                           One Arm One Leg (OAL)<br>
											                           <input name="pwdOAL" type="text" value="${requisitionForm[0].pwdOAL}">
											                         </td>
											                         <td >
											                           Both Legs and Arms (BLA<br>
											                           <input name="pwdBLA" type="text" value="${requisitionForm[0].pwdBLA}">
											                         </td>
											                         <td >
											                           Both Legs One Arm (BLOA)<br>
											                           <input name="pwdBLOA" type="text" value="${requisitionForm[0].pwdBLOA}">
											                         </td>
											                         <td >
											                           Cerebral paisy<br>
											                           <input name="pwdCPaisy" type="text" value="${requisitionForm[0].pwdCPaisy}">
											                         </td>
											                         <td colspan="2">
											                           leprosy cured<br>
											                           <input  name="pwdLCured" type="text" value="${requisitionForm[0].pwdLCured}">
											                         </td>
											                      </tr>
											                      <tr id="oh21" <c:if test="${empty requisitionForm[0].pwd3}"> style="display:none" </c:if>>
											                         <td >
											                           dwarfism<br>
											                           <input  name="pwdDwarfism" type="text" value="${requisitionForm[0].pwdDwarfism}">
											                         </td>
											                         <td >
											                           acid attack victims<br>
											                           <input name="pwdAAVictims" type="text" value="${requisitionForm[0].pwdAAVictims}">
											                         </td>
											                         <td >
											                           muscular dystrophy<br>
											                           <input  name="pwdMDystrophy"type="text" value="${requisitionForm[0].pwdMDystrophy}">
											                         </td>
											                         <td colspan="3">
											                           others<br>
											                           <input name="pwdOthers" type="text" value="${requisitionForm[0].pwdOthers}">
											                         </td>
											                      </tr>
                                                            
											               </tbody>
											           
											           </table>
											           </div>
											           </c:when>
											           </c:choose>  
											        </td>
											     </tr>
							  <!-- *************************************For Group C and D End******************************************************--> 
							  
											     <tr>
											       <td>
											         <label style="font-weight:0;font-size:12px;">
				                                                     Name of officer of the Department whom  Government would like the  Commission to invite to be present to  assist them in an advisory capacity. &nbsp<sup style="color:red;">*</sup>
															  </label>
											       </td>
											       <td>
											         <input name="nameOfOfficerForAdvisoryCapacity" style="width:100%" type="text" value="${requisitionForm[0].nameOfOfficerForAdvisoryCapacity}">
											       </td>
											         
											       <td>
											         <label style="font-weight:0;font-size:12px;">
													   Name of Nodal Officer &nbsp<sup style="color:red;">*</sup>		   
													</label>
											       </td>
											       <td>
											         <input name="nameOfNodalOfficer" style="width:100%" type="text" value="${requisitionForm[0].nameOfNodalOfficer}">
											       </td>
											     </tr>
											     <tr>
											       <td>
											         <label style="font-weight:0;font-size:12px;">
													   Phone Number of Nodal Officer &nbsp<sup style="color:red;" >*</sup>	   
													</label>
											       </td>
											       <td>
											         <input name="phoneNumberOfNodelOfficer" style="width:100%" type="text" onkeypress="return isNumberKey(event,'characters not allowed','Error9')" value="${requisitionForm[0].phoneNumberOfNodelOfficer}" maxlength="10">
											         <br>
													  <span style="color:red;" id="Error9"></span>
											       </td>
											       <td>
											          <label style="font-weight:0;font-size:12px;">
													   Any other condition or qualification not covered by the above questions.  &nbsp<sup style="color:red;">*</sup>  
													</label>
											       </td>
											       <td> 
											          <input name="conditionOrQualificationNotCoveredAbove" style="width:100%" type="text" value="${requisitionForm[0].conditionOrQualificationNotCoveredAbove}">
											       </td>
											     </tr>
										    </table>				
						                   <center> <a class="btn btn-sm btn-warning" href="javascript:saveRequisitionForm('${deptInfo.onlyPwdAllowed}','${deptInfo.pwdAllowed}');">SAVE</a></center>		
						                    <center><span style="color:red;" id="Error"></span></center>
						                 </form:form>
									  </div>
								 </div>
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
		<script src="assets/customJS/custom.js"></script>
		


		<!-- inline scripts related to this page -->
	</body>
	</html>