<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
		<div id="navbar" class="navbar navbar-default          ace-save-state">
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

			<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
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
				</ul><!-- /.nav-list -->

				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
			</div>

			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
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
						<b style="font-size: 15px;">Advertisement Details</b>
						</ul><!-- /.breadcrumb -->
					</div>
					<div class="page-content">

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
                                     
								<div class="row">
									<div class="col-xs-12" style="font-size:12px">
									 <form:form method="post" id="postDetailsForm" commandName=""> 
									   <table id="postDetailstbl" class="table  table-bordered table-hover">
									          												
											<tr>
													<th class="blue">Name of Department</th>
													<td> ${deptName} </td>
													<th class="blue">Name of Post</th>
													<td>${postDetailsList[0].nAmeOfPost}</td>
													<th class="blue">Advt. No.</th>
													<td>${postDetailsList[0].aDvtNo}</td>													
													

												</tr>
												<tr>
													<th class="blue">Cat. No.</th>
													<td>${postDetailsList[0].cAtNo}</td>
													<th class="blue">No. of Posts</th>
													<td>${postDetailsList[0].nOOfPosts}</td>
                                                    <th class="blue">Macro Status</th>
													<td>${postDetailsList[0].mAcroStatus}</td>
													
												</tr>
												<tr>
													<th class="blue">Next Step</th>
													<td>${postDetailsList[0].nExtStep}</td>
													<th class="blue">Candidates Recommended</th>
													<td>${postDetailsList[0].cAndidatesRecommended}</td>
													<th class="blue">Total No. Of Applications</th>
													<td>${postDetailsList[0].tOtalNoOfApplications}</td>
													
												</tr>
												<tr>
													<th class="blue">Advertisement Posted</th>
													<td>${postDetailsList[0].aDvertisementPosted}</td>
													<th class="blue">Applications Open</th>
													<td>${postDetailsList[0].aPplicationsOpen}</td>
													<th class="blue">Applications Close</th>
													<td>${postDetailsList[0].aPplicationsClose}</td>
													
												</tr>
												<tr>
													<th class="blue">Admit Cards</th>
													<td>${postDetailsList[0].aDmitCards}</td>
													<th class="blue">PST Start (For Police only)</th>
													<td>${postDetailsList[0].pStStart}</td>
													<th class="blue">PST End (For Police only)</th>
													<td>${postDetailsList[0].pStEnd}</td>
													
												</tr>
												<tr>
													<th class="blue">Result of PST (For Police only)</th>
													<td>${postDetailsList[0].rEsultOfPst}</td>
													<th class="blue">Written Exam</th>
													<td>${postDetailsList[0].wRittenExam}</td>
													<th class="blue">Written Exam Session</th>
													<td>${postDetailsList[0].wRittenExamSession}</td>
													
												</tr>
												<tr>
													<th class="blue">Uploading Answer Key</th>
													<td>${postDetailsList[0].uPloadingAnswerKey}</td>
													<th class="blue">Objections Open</th>
													<td>${postDetailsList[0].oBjectionsOpen}</td>
													<th class="blue">Objections Close</th>
													<td>${postDetailsList[0].oBjectionsClose}</td>
													
												</tr>
												<tr>
													<th class="blue">Uploaded Revised Answer Key</th>
													<td>${postDetailsList[0].uPloadedRevisedAnswerKey}</td>
													<th class="blue">Result of Written Exam</th>
													<td>${postDetailsList[0].rEsultOfWrittenExam}</td>
													<th class="blue">Scrutiny Start Date</th>
													<td>${postDetailsList[0].sCrutinyStartDate}</td>
													
												</tr>
												<tr>
													<th class="blue">Scrutiny End Date</th>
													<td>${postDetailsList[0].sCrutinyEndDate}</td>
													<th class="blue">Scrutiny Results</th>
													<td>${postDetailsList[0].sCrutinyResults}</td>
													<th class="blue">PMT Height-Chest (For Police only)</th>
													<td>${postDetailsList[0].pMtHeightChest}</td>
													
												</tr>
												<tr>
													<th class="blue">Result of PMT Height-Chest (For Police only)</th>
													<td>${postDetailsList[0].rEsultOfPmtHeightChest}</td>
													<th class="blue">Admit Cards (for Interview)</th>
													<td>${postDetailsList[0].aDmitCardsForInterview}</td>
                                                    <th class="blue">Interviews Start Date</th>
													<td>${postDetailsList[0].iNterviewsStartDate}</td>
													
												</tr>
												<tr>
													<th class="blue">Interviews End Date</th>
													<td>${postDetailsList[0].iNterviewsEndDate}</td>
													<th class="blue">Announcement of Final Result </th>
													<td>${postDetailsList[0].aNnouncementOfFinalResult}</td>
													<th class="blue">Recommended Date</th>
													<td>${postDetailsList[0].rEcommendedDate}</td>					
													
												</tr>
												<tr>
											    <th class="blue">Detailed Status</th>
												 <td colspan="3">${postDetailsList[0].dEtailedStatus}</td>
											     <th class="blue">No. Of People Attending Exam</th>
											     <td>${postDetailsList[0].nOOfPeopleAttendingExam}</td>	
													
												</tr>
												</table>
                                      
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

	</body>
</html>
