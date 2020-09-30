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
            
            <link rel="stylesheet" href="assets/css/jquery.gritter.min.css" />
            
            
            <style>
			/* some elements used in demo only */
			.spinner-preview {
				width: 100px;
				height: 100px;
				text-align: center;
				margin-top: 60px;
			}

			.dropdown-preview {
				margin: 0 5px;
				display: inline-block;
			}
			.dropdown-preview  > .dropdown-menu {
				display: block;
				position: static;
				margin-bottom: 5px;
			}
		</style>
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
					<li class="active">
					<a href="<c:url value="allHSSCPostname"/>">
						
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text"> Search Advt Details </span>

						</a>
					</li>
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
                                  <c:choose>
                                     <c:when test="${error!=''}">
                                          <c:choose>
                                             <c:when test="${error!='File Uploaded Successfully!!'}">
                                                   <div class="alert alert-block alert-danger">
														<button type="button" class="close" data-dismiss="alert">
															<i class="ace-icon fa fa-times"></i>
														</button>
														<strong class="Red">
														    ${error}
													     </strong>
													      <div class="space-4"></div>   
										           </div>
                                             </c:when>
                                             <c:otherwise>
                                              <div class="alert alert-block alert-success">
														<button type="button" class="close" data-dismiss="alert">
															<i class="ace-icon fa fa-times"></i>
														</button>
														<strong class="Red">
														    ${error}
													     </strong>
													      <div class="space-4"></div>   
										           </div>
                                             </c:otherwise>
                                          </c:choose>                                   
                                     </c:when>
                                  </c:choose>
								<div class="hr hr-18 hr-double dotted"></div>

								<div class="widget-box">
									<div class="widget-header widget-header-blue widget-header-flat">
										<h4 class="widget-title lighter">Advertisement Details</h4>

										
									</div>

									<div class="widget-body">
										<div class="widget-main">
											<div id="fuelux-wizard-container">
												<div>
													<ul class="steps">
														<li data-step="1" class="active">
															<span class="step">1</span>
															<span class="title">General Information</span>
														</li>

														<li data-step="2">
															<span class="step">2</span>
															<span class="title">Application Details</span>
														</li>

														<li data-step="3">
															<span class="step">3</span>
															<span class="title">Written Exam Details</span>
														</li>

														<li data-step="4">
															<span class="step">4</span>
															<span class="title">Scrutiny Details</span>
														</li>
														<li data-step="5">
															<span class="step">5</span>
															<span class="title">Interview & Final Result</span>
														</li>
													</ul>
												</div>

												<hr />

												<div class="step-content pos-rel">
													<div class="step-pane active" data-step="1">
														 <table id="postDetailstbl" class="table  table-bordered table-hover">
									          												
											<tr>
													<th class="blue">Name of Department</th>
													<td> ${deptName}</td>
											</tr>
											<tr>
													<th class="blue">Name of Post</th>
													<td>${postDetailsList[0].nAmeOfPost}</td>
											</tr>
											<tr>	
													<th class="blue">Advt. No.</th>
													<td>${postDetailsList[0].aDvtNo}</td>													
											</tr>
											<tr>
													<th class="blue">Cat. No.</th>
													<td>${postDetailsList[0].cAtNo}</td>
											</tr>
											<tr>		
													<th class="blue">No. of Posts</th>
													<td>${postDetailsList[0].nOOfPosts}</td>
                                            </tr>
                                            <tr>    
                                                    <th class="blue">Macro Status</th>
													<td>${postDetailsList[0].mAcroStatus}</td>
										    </tr>
												
												</table>
													</div>

													<div class="step-pane" data-step="2">
													<table id="postDetailstbl" class="table  table-bordered table-hover">
													<tr>
													<th class="blue">Current Step</th>
													<td>${postDetailsList[0].currentStep}</td>
													</tr>
													<tr>
													<th class="blue">Next Step</th>
													<td>${postDetailsList[0].nExtStep}</td>
													</tr>
													<tr>
													<th class="blue">Candidates Recommended</th>
													<td>${postDetailsList[0].cAndidatesRecommended}</td>
													</tr>
													<tr>
													<th class="blue">Total No. Of Applications</th>
													<td>${postDetailsList[0].tOtalNoOfApplications}</td>
													</tr>
													<tr>
													<th class="blue">No. Of People Attending Exam</th>
													<td>${postDetailsList[0].nOOfPeopleAttendingExam}</td>
													</tr>
				
				<tr>
				<th class="blue">Advertisement Posted</th>											
			    <td>
				<table>
				<c:forEach items="${postDetailsList[0].advtPostedDateList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.advertisementPosted}</td>
				<td>
				 <a class="dateInfos">
				<i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				</tr>
				</c:forEach>
				</table>
				</td>
				</tr>	
				
				
				
				<tr>
				<tr>
				<th class="blue">Applications Open</th>
				<td>
				 <table>
				<c:forEach items="${postDetailsList[0].applicationOpenList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.applicationopen}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>
				 </td>
				</tr>
				
				
				<tr>
				<th class="blue">Applications Close</th>
				<td>
				<table>
				<c:forEach items="${postDetailsList[0].applicationClosedList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.applicationclosed}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>
				</td>
				</tr>
				
												
				<tr>
				<th class="blue">Admit Cards</th>
				<td>
				<table>
				<c:forEach items="${postDetailsList[0].admitCardsList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.admitcard}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>												
			    </td>
				</tr>
				
				
				<c:choose>
      		    <c:when test="${user.idDept==48 || user.isAdmin=='Y'}"> 
				<tr>
				<th class="blue">PST Start (For Police only)</th>
				 <td>
				 
				 <table>
				<c:forEach items="${postDetailsList[0].pstStartList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.pststart}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>		
				</td>
				</tr>
				
				
				<tr>
				<th class="blue">PST End (For Police only)</th>
				<td>
				<table>
				<c:forEach items="${postDetailsList[0].pstEndList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.pstend}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>	
				</td>		
				</tr>
												
				
				<tr>
				<th class="blue">Result of PST (For Police only)</th>
				<td>
				<table>
				<c:forEach items="${postDetailsList[0].resultOfPstList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.resultofpst}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>	
				</td>
				</tr>
				</c:when>
				</c:choose>
				</table>	
				</div>

				
				<div class="step-pane" data-step="3">
				<table id="postDetailstbl" class="table  table-bordered table-hover">
				<tr>	
				<th class="blue">Written Exam</th>
				<td>
				
				<table>
				<c:forEach items="${postDetailsList[0].writtenExamList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.writtenExam}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>								         
			    </td>
				</tr>
				
				
				<tr>	
				<th class="blue">Written Exam Session</th>
				<td>${postDetailsList[0].wRittenExamSession}</td>	
				</tr>
				<tr>
				<th class="blue">Uploading Answer Key</th>
				<td>
				
				<table>
				<c:forEach items="${postDetailsList[0].uploadingAnswerKeyList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.uploadingAnswerKey}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>													  
				</td>
				</tr>
				
				
				<tr>
				<th class="blue">Objections Open</th>
				<td>
				
				<table>
				<c:forEach items="${postDetailsList[0].objectionsOpenList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.objectionsOpen}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>														 
				</td>
				</tr>
				
				
				<tr>
				<th class="blue">Objections Close</th>
				<td>
				<table>
				<c:forEach items="${postDetailsList[0].objectionsClosedList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.objectionsClosed}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>					
				</td>
				</tr>
											
				<tr>
				<th class="blue">Uploaded Revised Answer Key</th>
				<td>
				<table>
				<c:forEach items="${postDetailsList[0].uploadedRevisedAnswerKeyList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.uploadedRevisedAnswerKey}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>	
				</td>
				</tr>
				
				
				<tr><th class="blue">Result of Written Exam</th>
				<td>
				<table>
				<c:forEach items="${postDetailsList[0].resultOfWrittenExamList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.resultOfWrittenExam}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>												  
				</td>
				</tr>
				</table>
			</div>

													
													
			<div class="step-pane" data-step="4">
			<table id="postDetailstbl" class="table  table-bordered table-hover">
			<tr>
			<th class="blue">Scrutiny Start Date</th>
			<td>
			<table>
				<c:forEach items="${postDetailsList[0].scrutinyStartDateList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.scrutinyStartDate}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>										      	
			 </td>
			 </tr>
			 
			 
			 <tr>
			<th class="blue">Scrutiny End Date</th>
			 <td>
			   <table>
				<c:forEach items="${postDetailsList[0].scrutinyEndDateList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.scrutinyEndDate}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>													   
			    </td>
				</tr>	
												
												
				<tr>
				<th class="blue">Scrutiny Results</th>
				<td>
				<table>
				<c:forEach items="${postDetailsList[0].scrutinyResultsList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.scrutinyResults}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>										   
				</td>
				</tr>
				
				
				<c:choose>
      		     <c:when test="${user.idDept==48 || user.isAdmin=='Y'}">
				<tr>	<th class="blue">PMT Height-Chest (For Police only)</th>
				<td>
				<table>
				<c:forEach items="${postDetailsList[0].pMTHeightChestList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.pmtHeightChest}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>	
			   </td>
				</tr>
											
											
				<tr>
				<th class="blue">Result of PMT Height-Chest (For Police only)</th>
				<td>
				
				<table>
				<c:forEach items="${postDetailsList[0].resultOfPmtHeightChestList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.resultOfPmtHeightChest}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>														   
				</td>
				</tr>
												
				</c:when>
				</c:choose>
				<tr>	<th class="blue">Admit Cards (for Interview)</th>
				<td>
				<table>
				<c:forEach items="${postDetailsList[0].admitCardsForInterviewList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.admitCardsForInterview}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>
				</td>
               </tr>
               </table>
               
               
				</div>
				<div class="step-pane" data-step="5">
				<table id="postDetailstbl" class="table  table-bordered table-hover">
				<tr>  
				<th class="blue">Interviews Start Date</th>
				<td>
				<table>
				<c:forEach items="${postDetailsList[0].interviewStartDateList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.interviewStartDate}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>										 
				</td>	
				</tr>
											
											
				<tr>
				<th class="blue">Interviews End Date</th>
				<td>
				<table>
				<c:forEach items="${postDetailsList[0].interviewEndDateList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.interviewEndDate}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>												
				</td>
				</tr>
				
				
				<tr>
				<th class="blue">Announcement of Final Result </th>
				<td>
				<table>
				<c:forEach items="${postDetailsList[0].announcementOfResultsList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.announcementOfResults}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>										     
				</td>
				</tr>
				
				
										
				<tr>		
				<th class="blue">Recommended Date</th>
				<td>
				<table>
				<c:forEach items="${postDetailsList[0].recommendedDateList}" var="tag" varStatus="loop">
				<tr>
				<td>
				${tag.recommendedDate}</td>
				 <td>
				 <a class="dateInfos">
				 <i class="ace-icon fa fa-info-circle"></i>
				<span class="tooltiptextComments">
				${tag.comments}	
				</span>
				 </a></td>
				 </tr>
				</c:forEach>
				 </table>	
				</td>						
				</tr>
								
								
			  <tr>
			  <th class="blue">Detailed Status</th>
				<td>${postDetailsList[0].dEtailedStatus}</td>										
			 </tr>
			 <c:choose>
			  <c:when test="${user.isAdmin=='Y' && not empty user.idRole}">
			 <c:choose>
			   <c:when test="${postDetailsList[0].nExtStep=='Joining'}">
			      <tr>
			         <th class="blue">
			            upload recommended candidates list 
			         </th>
			         <td>
			             <form:form  action="uploadFile" method="post" enctype="multipart/form-data" accept-charset="UTF-8" id="uploadForm">	
			                <input type="hidden" id="dEpartmentId" name="dEpartmentId" value="${postDetailsList[0].dEpartmentId}">
			                <input type="hidden" id="sRNo" name="sRNo" value="${postDetailsList[0].sRNo}">
			            <div class="form-group">
							<div class="col-xs-8">
								<input type="file" name="file" id="id-input-file-2" />
							</div>
							<button type="submit" class="btn btn-minier btn-yellow" style="height:28px;" onclick="javascript:uploadCandidatesList('${postDetailsList[0].dEpartmentId}','${postDetailsList[0].sRNo}');">Upload</button>
						   <i class="ace-icon fa fa-spinner fa-spin orange bigger-125" id="idSpinner" style="display:none;" ></i>
						</div>
						<span id="lblError" style="color:red"></span>
						</form:form>
			         </td>
			      </tr>
			   </c:when>
			   </c:choose>
			   </c:when>
			 </c:choose>
			  <c:choose>
			          <c:when test="${postDetailsList[0].nExtStep=='Joining'}">
			          <tr>
			             <form:form name="docDownload" id="docDownload" method="post" enctype="multipart/form-data" accept-charset="UTF-8" >
			              <input type="hidden" name="sRNoForDownload" id="sRNoForDownload">
			              <input type="hidden" name="dEpartmentIdForDownload" id="dEpartmentIdForDownload">
			               <input type="hidden" name="docType" id="docType">
			            <th class="blue">
			               Recommended Candidates List For Joining 
			            </th>
			            <td >
			                <a  title="Download File" href="javascript:downloadDoc('${postDetailsList[0].departmentDocsList[0].sRNo}','${postDetailsList[0].departmentDocsList[0].docType}','${postDetailsList[0].departmentDocsList[0].dEpartmentId}');">
									${postDetailsList[0].departmentDocsList[0].fileName}
					    	 </a>
			            </td>
			            </form:form>
			          </tr>
			             </c:when>
			          </c:choose>
			</table>
			</div>	
			</div>
			</div>
			<hr />
											<div class="wizard-actions">
												<button class="btn btn-prev">
													<i class="ace-icon fa fa-arrow-left"></i>
													Prev
												</button>
												<button class="btn btn-success btn-next" data-last="END">
													Next
													<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
												</button>
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
		
		<script src="assets/js/jquery-ui.custom.min.js"></script>
		<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="assets/js/jquery.easypiechart.min.js"></script>
		<script src="assets/js/jquery.gritter.min.js"></script>
		<script src="assets/js/spin.js"></script>

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
				
				


				$('#id-input-file-2').ace_file_input({
					no_file:'No File ...',
					btn_choose:'Choose',
					btn_change:'Change',
					droppable:false,
					onchange:null,
					thumbnail:false
					
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
		<script type="text/javascript">
		function uploadCandidatesList(dEpartmentId,sRNo){
			var allowedFiles = [".xls",".xlsx"];
			var regex= new RegExp("([a-zA-Z0-9\s_\\.\-:])+(.xls|.xlsx)$");
			document.getElementById("idSpinner").style.display = "inline-block";
			var fileUpload= document.getElementById("id-input-file-2");
			var files = fileUpload.files[0];
			var formData = new FormData();
			formData.append('file', files);
			  if(fileUpload.value==""){
				  lblError.innerHTML = "Please select the file to upload";
				  document.getElementById("idSpinner").style.display = "none";
			  }
			  else  if (!regex.test(fileUpload.value.toLowerCase())) {
			            lblError.innerHTML = "Please upload files having extensions: <b>" + allowedFiles.join(', ') + "</b> only.";
			            document.getElementById("idSpinner").style.display = "none";
			            return false;
			        }
			  else
				  if(fileUpload.files[0].size > 10485760){
					   lblError.innerHTML = "Maximum file size to be uploaded should not be greater than 10mb";
			            document.getElementById("idSpinner").style.display = "none";
			            return false;
				  }
			  else{  
				  document.getElementById('dEpartmentId').value=dEpartmentId;
				  document.getElementById('sRNo').value=sRNo;
				  document.getElementById("uploadForm").submit;		
			   }
			 }
		
		function downloadDoc(sRNoForDownload,docType,dEpartmentIdForDownload){
			document.getElementById('docType').value=docType;
			document.getElementById('sRNoForDownload').value=sRNoForDownload;
			document.getElementById('dEpartmentIdForDownload').value=dEpartmentIdForDownload;
			document.getElementById('docDownload').action="downloadCandidateList";
			document.getElementById('docDownload').submit();
		}

		</script>
		
		
	</body>
</html>
