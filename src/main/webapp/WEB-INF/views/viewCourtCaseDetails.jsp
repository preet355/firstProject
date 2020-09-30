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
					<%-- <c:choose>
					  <c:when test="${user.module=='mis' && user.idRole!='3'}"> --%>
					<li class="active">
					<a href="<c:url value="courtCaseSearch"/>">
						
							<i class="menu-icon fa fa-fw fa-bank"></i>
							<span class="menu-text"> Search Court Case</span>

						</a>
					</li>
					<%-- </c:when>
					</c:choose> --%>
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
									    View Court Case
										<small>
											<i class="ace-icon fa fa-angle-double-right"></i>
											Writ No. ${courtCaseDetailsList[0].writNo}
										</small>
									   
									  
									</h1>
								</div><!-- /.page-header -->

								<div class="hr hr-18 hr-double dotted"></div>

								<div class="widget-box">
									<div class="widget-header widget-header-blue widget-header-flat">
										<h4 class="widget-title lighter">Section A</h4>
                                             <small>
												<i class="ace-icon fa fa-angle-double-right"></i>
												General Information
											</small>
										
									</div>

									<div class="widget-body">
										<div class="widget-main">
											<div id="fuelux-wizard-container">
			                                    <div class="step-content pos-rel">
			                                         <table id="postDetailstbl" class="table  table-bordered table-hover">
									          												
											<tr>
													<th class="blue">Name of Department</th>
													<td class="center">${policeDetailsList[0].deptObj.dEpartment}</td>
											</tr>
											<tr>	
													<th class="blue">Advt. No.</th>
													<td class="center">${policeDetailsList[0].aDvtNo}</td>													
											</tr>
											<tr>
													<th class="blue">Name of Post</th>
													<td class="center">${policeDetailsList[0].nAmeOfPost}</td>
											</tr>
											
											<tr>
													<th class="blue">Cat. No.</th>
													<td class="center">${policeDetailsList[0].cAtNo}</td>
											</tr>
                                            <tr>    
                                                    <th class="blue">Status</th>
													<td class="center">${courtCaseDetailsList[0].caseStatus}</td>
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
													<td class="center">${courtCaseDetailsList[0].caseType}</td>
                                            </tr>
											<tr>	
													<th class="blue">Case No.</th>
													<td class="center">${courtCaseDetailsList[0].writNo}</td>													
											</tr>
											<tr>
													<th class="blue">Year</th>
													<td class="center">${courtCaseDetailsList[0].year}</td>
											</tr>
											
											<tr>
													<th class="blue">CM No. And Year</th>
<%-- 													<td class="center">${courtCaseDetailsList[0].civilMiscellaneousDetailsList[0].cmNo}   ${courtCaseDetailsList[0].civilMiscellaneousDetailsList[0].cmYear}</td> --%>
													<td>
													<table>
														<c:forEach items="${courtCaseDetailsList[0].civilMiscellaneousDetailsList}" var="tag" varStatus="loop">
														<tr>
														<td>
														<b>CM No.</b>
														${tag.cmNo}</td>
														 <td> 
														<b>CM Year</b>
														${tag.cmYear}	
														</td>
														 </tr>
														</c:forEach>
														 </table>		
													</td>
											</tr>
											<tr>
													<th class="blue">Paper Book Received</th>
													<td class="center">${courtCaseDetailsList[0].paperBookReceived}</td>
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
													<td class="center">${courtCaseDetailsList[0].fileNo}</td>
											</tr>
											<tr>	
													<th class="blue">Priority</th>
													<td class="center">${courtCaseDetailsList[0].priority}</td>													
											</tr>
											
											<tr>
													<th class="blue">Name Of Court</th>
													<td class="center">${courtCaseDetailsList[0].caseIn}</td>
											</tr>
											<tr>
													<th class="blue">Legal Issue</th>
													<c:choose>
													   <c:when test="${courtCaseDetailsList[0].otherLegalIssue=='' || courtCaseDetailsList[0].otherLegalIssue==null }">
													     <td class="center">${courtCaseDetailsList[0].legalIssue}</td>
													    </c:when>
													    <c:when test="${courtCaseDetailsList[0].legalIssue!='' && courtCaseDetailsList[0].otherLegalIssue!=''}">
													        <td class="center">
													                 ${courtCaseDetailsList[0].legalIssue} -
													                 ${courtCaseDetailsList[0].otherLegalIssue}
													               
													         </td>
													    </c:when>
													    <c:otherwise>
													       <td class="center">${courtCaseDetailsList[0].otherLegalIssue}</td>
													    </c:otherwise>
													</c:choose>
											</tr>
											<tr>		
													<th class="blue">Main/Similar Case</th>
													<td class="center">${courtCaseDetailsList[0].main_similarCase}</td>
                                            </tr>
                                            <tr>		
													<th class="blue">Similar Case Information</th>
													<td class="center">
													  <table>
														<c:forEach items="${courtCaseDetailsList[0].similarCasesList}" var="tag" varStatus="loop">
														<tr>
														<td>
														<b>Case No. -</b>
														${tag.caseNo}</td>
														 <td>
														 <b>Case Type -</b> 
														${tag.similarCaseType}	
														</td>
														 <td> 
														 <b>Year -</b>
														${tag.year}	
														</td>
														 </tr>
														</c:forEach>
														 </table>	
													</td>
                                            </tr>
                                            <tr>    
                                                    <th class="blue">Concerned Assistant</th>
													<td class="center">${courtCaseDetailsList[0].concernedAssistant}</td>
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
													<td class="center">${courtCaseDetailsList[0].letterReceivedFrom_Ag_Lr}</td>
											</tr>
											<tr>
													<th class="blue">Purpose Of Letter</th>
													<td class="center">${courtCaseDetailsList[0].purposeOfLetter}</td>
											</tr>
											<tr>	
													<th class="blue">Letter Date</th>
													<td class="center">${courtCaseDetailsList[0].letterDate}</td>													
											</tr>
											<tr>
													<th class="blue">Whether Reply Filed or Not</th>
													<td class="center">${courtCaseDetailsList[0].replyFrom_Ag_Lr}</td>
											</tr>
											
											<tr>
													<th class="blue">Reply filed Date</th>
													<td class="center">${courtCaseDetailsList[0].replyFiledDate}</td>
											</tr>
											<tr>
													<th class="blue">Reply Status</th>
													<td class="center">${courtCaseDetailsList[0].replyFrom_Ag_LrStatus}</td>
											</tr>
											<tr>
													<th class="blue">Details Of Reply</th>
													<td class="center">${courtCaseDetailsList[0].detailedReplyFrom_Ag_Lr}</td>
											</tr>
											<tr>		
													<th class="blue">Whether Stay or Not</th>
													<td class="center">${courtCaseDetailsList[0].stay}</td>
                                            </tr>
                                            <tr>    
                                                    <th class="blue">Stay Details</th>
													<td class="center">${courtCaseDetailsList[0].stayDetails}</td>
										    </tr>
										    <tr>    
                                                    <th class="blue">Remarks/Interim Order</th>
<%-- 													<td class="center">${courtCaseDetailsList[0].remarks_InterimOrder}</td> --%>
													<td class="center">
													 <table>
														<c:forEach items="${courtCaseDetailsList[0].interimOrderList}" var="tag" varStatus="loop">
														<tr>
														<td>
														<b>Interim Order -</b>
														${tag.fullInterimOrder}</td>
														 <td>
														<b> Date-</b>
														${tag.interimOrderDate}	
														</td>
														 </tr>
														</c:forEach>
														 </table>	
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
													<th class="blue">Petitioner Name</th>
<%-- 													<td class="center">${courtCaseDetailsList[0].petitionerDetailsList[0].name}</td> --%>
													<td>
													 <table>
														<c:forEach items="${courtCaseDetailsList[0].petitionerDetailsList}" var="tag" varStatus="loop">
														<tr>
														<td>
														<b>Petitioner Name -</b>
														${tag.name}</td>
														 <td>
														<b>Roll No</b>
														${tag.rollNo}	
														</td>
														 </tr>
														</c:forEach>
														 </table>
													</td>
											</tr> 		 										
											
											<tr>
													<th class="blue">Versus</th>
													<td class="center">${courtCaseDetailsList[0].versus}</td>
											</tr>
											<tr>
													<th class="blue">Commission Respondent No. </th>
													<td class="center">${courtCaseDetailsList[0].commissionRespondentNo}</td>
											</tr>
												</table>
			                                    </div>
			                                </div>
											
										</div><!-- /.widget-main -->
									</div><!-- /.widget-body -->
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
									         <tr>
													<th class="blue">Date Of Hearing</th>
													<td class="center">${courtCaseDetailsList[0].dateList}</td>
											</tr> 		 										
											<tr>
													<th class="blue">Detailed Status/ Comments from Legal Secretary</th>
													<td class="center">${courtCaseDetailsList[0].detailedStatus}</td>
											</tr>
												</table>
			                                    </div>
			                                </div>
											
										</div><!-- /.widget-main -->
									</div><!-- /.widget-body -->
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
