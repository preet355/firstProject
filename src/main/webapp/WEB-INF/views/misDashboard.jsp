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

<meta name="description" content="overview &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<link rel="stylesheet" href="assets/css/bootstrap-datepicker3.min.css" />

<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />  
<link rel="stylesheet" href="assets/css/select2.min.css" />  
<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />
<link rel="stylesheet" href="assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />
<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="assets/css/searchAlign.css" />
<link rel="stylesheet" href="assets/css/searchAlign.css" />
<script src="assets/js/ace-extra.min.js"></script>
<script src="assets/js/jquery-2.1.4.min.js"></script>
<script src="assets/js/canvasjs.min.js"></script>


<style>
#chartdiv {
	width: 80%;        
	height: 400px;
}
</style>

<!-- Resources -->
<script src="assets/js/histogram.js"></script>
<script src="https://www.amcharts.com/lib/3/serial.js"></script>
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>


<!-- Chart code -->
<script>    
	function generateChartData() {
		var data = [];
		if ('${advtPostedCount}' != 0) {
			data.push({
				"country" : "Advertisement Posted",
				"visits" : '${advtPostedCount}',
				"NoOfPosts" : '${advtPostdNoOfPostCount}',
				"color" : "#62cf73"
			});
		}
		if ('${applicationOpenCount}' != 0) {
			data.push({
				"country" : "Applications Open",
				"visits" : '${applicationOpenCount}',
				"NoOfPosts" : '${aplOpenNoOfPostCount}',
				"color" : "#62cf73"
			});
		}
		if ('${applicationClosedCount}' != 0) {
			data.push({
				"country" : "Applications Close",
				"visits" : '${applicationClosedCount}',
				"NoOfPosts" : '${aplCloseNoOfPostCount}',
				"color" : "#62cf73"
			});
		}
		if ('${admitCardsCount}' != 0) {
			data.push({
				"country" : "Admit Cards",
				"visits" : '${admitCardsCount}',
				"NoOfPosts" : '${admtCardNoOfPostCount}',
				"color" : "#62cf73"
			});
		}
		if ('${pstStartCount}' != 0) {
			data.push({
				"country" : "PST Start",
				"visits" : '${pstStartCount}',
				"NoOfPosts" : '${pstStrtNoOfPostCount}',
				"color" : "#62cf73"
			});
		}
		if ('${pstEndCount}' != 0) {
			data.push({
				"country" : "PST End",
				"visits" : '${pstEndCount}',
				"NoOfPosts" : '${pstEndNoOfPostCount}',
				"color" : "#62cf73"
			});
		}
		if ('${pstResultCount}' != 0) {
			data.push({
				"country" : "Result of PST",
				"visits" : '${pstResultCount}',
				"NoOfPosts" : '${resultOfPstNoOfPostCount}',
				"color" : "#62cf73"
			});
		}
		if ('${writtenExamCount}' != 0) {
			data.push({
				"country" : "Written Exam",
				"visits" : '${writtenExamCount}',
				"NoOfPosts" : '${wrtnExmNoOfPostCount}',
				"color" : "#62cf73"
			});
		}
		if ('${uploadAnsKeyCount}' != 0) {
			data.push({
				"country" : "Uploading Answer Key",
				"visits" : '${uploadAnsKeyCount}',
				"NoOfPosts" : '${uplAnsKeyNoOfPostCount}',
				"color" : "#62cf73"
			});
		}
		if ('${objectionOpenCount}' != 0) {
			data.push({
				"country" : "Objections Open",
				"visits" : '${objectionOpenCount}',
				"NoOfPosts" : '${objectionOpenNoOfPostCount}',
				"color" : "#62cf73"
			});
		}
		if ('${objectionClosedCount}' != 0) {
			data.push({
				"country" : "Objections Close",
				"visits" : '${objectionClosedCount}',
				"NoOfPosts" : '${objectionCloseNoOfPostCount}',
				"color" : "#62cf73"
			});
		}
		if ('${uploadRevisedAnsKeyCount}' != 0) {
			data.push({
				"country" : "Upload Revised Answer Key",
				"visits" : '${uploadRevisedAnsKeyCount}',
				"NoOfPosts" : '${uplRevAnskeyNoOfPostCount}',
				"color" : "#62cf73"
			});
		}
		if ('${resultOfWrittenExamCount}' != 0) {
			data.push({
				"country" : "Result of Written Exam",
				"visits" : '${resultOfWrittenExamCount}',
				"NoOfPosts" : '${resOfWrtnExamNoOfPostCount}',
				"color" : "#62cf73"
			});
		}
		if ('${scrutinyCount}' != 0) {
			data.push({
				"country" : "Scrutiny",
				"visits" : '${scrutinyCount}',
				"NoOfPosts" : '${scrutinyNoOfPostCount}',
				"color" : "#62cf73"
			});
		}
		if ('${scrutinyResultCount}' != 0) {
			data.push({
				"country" : "Scrutiny Results",
				"visits" : '${scrutinyResultCount}',
				"NoOfPosts" : '${scrutinyResNoOfPostCount}',
				"color" : "#62cf73"
			});
		}
		if ('${pmtHeightChestCount}' != 0) {
			data.push({
				"country" : "PMT Height-Chest",
				"visits" : '${pmtHeightChestCount}',
				"NoOfPosts" : '${pmtHeightChestNoOfPostCount}',
				"color" : "#62cf73"
			});
		}
		if ('${admitCardsForInterviewCount}' != 0) {
			data.push({
				"country" : "Admit Cards (for Interview)",
				"visits" : '${admitCardsForInterviewCount}',
				"NoOfPosts" : '${admtCardForIntrNoOfPostCount}',
				"color" : "#62cf73"
			});
		}
		if ('${interviewsCount}' != 0) {
			data.push({
				"country" : "Interviews",
				"visits" : '${interviewsCount}',
				"NoOfPosts" : '${IntrNoOfPostCount}',
				"color" : "#62cf73"
			});
		}
		if ('${announcementOfFinalResultCount}' != 0) {
			data.push({
				"country" : "Announcement of Final Result",
				"visits" : '${announcementOfFinalResultCount}',
				"NoOfPosts" : '${announcemntOfFinlResNoOfPostCount}',
				"color" : "#62cf73"
			});
		}

		if ('${recommendCount}' != 0) {
			data.push({
				"country" : "Recommend",
				"visits" : '${recommendCount}',
				"NoOfPosts" : '${RecNoOfPostCount}',
				"color" : "#62cf73"
			});
		}
		if ('${joiningCount}' != 0) {
			data.push({
				"country" : "Joining",
				"visits" : '${joiningCount}',
				"NoOfPosts" : '${joiningNoOfPostCount}',
				"color" : "#62cf73"
			});
		}
		return data;
	}

	var chart = AmCharts
			.makeChart(
					"chartdiv",
					{
						"theme" : "light",
						"type" : "serial",
						"startDuration" : 2,
						plotOptions : {
							dataProvider : {
								cursor : 'pointer',
								point : {
									events : {
										click : function() {
											alert("hello");
										}
									}
								}
							}
						},
						"dataProvider" : generateChartData(),
						"valueAxes" : [ {
							"id" : "v1",
							"title" : "Requisition Count",
							"gridAlpha" : 0,
							"position" : "left",
							"autoGridCount" : false,

						}, {
							"id" : "v2",
							"title" : "No Of Posts",
							"gridAlpha" : 0,
							"position" : "right",
							"autoGridCount" : false
						} ],
						"graphs" : [
								{
									"balloonText" : "[[category]]: <b style='font-size: 110%'>[[value]]</b>",
									"fillColorsField" : "color",
									"lineColor" : "#62cf73",
									"fillAlphas" : 1,
									"lineAlpha" : 0.1,
									"type" : "column",
									"title" : "No Of Requisitions",
									"valueField" : "visits",
									"columnWidth" : 0.6
								},
								{
									"id" : "g4",
									"valueAxis" : "v2",
									"lineColor" : "#e1ede9",
									"fillColors" : "#e1ede9",
									"fillAlphas" : 1,
									"type" : "column",
									"title" : "No Of Posts",
									"valueField" : "NoOfPosts",
									"clustered" : false,
									"columnWidth" : 0.3,
									"balloonText" : "[[title]]:<b style='font-size: 130%'>[[value]]</b>"
								} ],
						"depth3D" : 0,
						"angle" : 30,
						"gridAboveGraphs" : true,
						"chartCursor" : {
							"pan" : true,
							"valueLineEnabled" : false,
							"valueLineBalloonEnabled" : false,

						},
						"categoryField" : "country",
						"categoryAxis" : {
							"gridPosition" : "start",
							"labelRotation" : 45,
							"minorGridEnabled" : true,
							"dashLength" : 1,
						},
						"balloon" : {
							"borderThickness" : 1,
							"shadowAlpha" : 0
						},
						"legend" : {
							"useGraphSettings" : true,
							"position" : "bottom"
						},
						"listeners" : [ {
							"event" : "clickGraphItem",
							"method" : function(event) {
								// alert(event.item.category);
								myFunction(event.item.category);
							}
						} ]

					});
</script>
<script>   

	var chart = AmCharts
			.makeChart(
					"chartHearingdiv",
					{
						"theme" : "light",
						"type" : "serial",
						"startDuration" : 2,
						plotOptions : {
							dataProvider : {
								cursor : 'pointer',
								point : {
									events : {
										click : function() {
											alert("hello");
										}
									}
								}
							}
						},
						"dataProvider" : [
							
							{
								"country" : "1 month or less",
								"visits" : '${betweenOneMonth}',
								"NoOfPosts" : '${betweenOneMonthNoOfPostCount}',
								"color" : "#646496"
							},
							{
								"country" : "1-2 months",
								"visits" : '${betweenOneToTwoMonth}',
								"NoOfPosts" : '${betweenOneToTwoMonthNoOfPostCount}',
								"color" : "#646496"
							},
							{
								"country" : "3-4 months",
								"visits" : '${betweenThreeToFourMonth}',
								"NoOfPosts" : '${betweenThreeToFourMonthNoOfPostCount}',
								"color" : "#646496"
							},
							{
								"country" : "6 months or more",
								"visits" : '${sixMonthOrMore}',
								"NoOfPosts" : '${sixMonthOrMoreNoOfPostCount}',
								"color" : "#646496"
							}
							
						],
						"valueAxes" : [ {
							"id" : "v1",
							"title" : "Count of name of post",
							"gridAlpha" : 0,
							"position" : "left",
							"autoGridCount" : false,

						}, {
							"id" : "v2",
							"title" : "No Of Posts",
							"gridAlpha" : 0,
							"position" : "right",
							"autoGridCount" : false
						} ],
						"graphs" : [
								{
									"balloonText" : "[[category]]: <b style='font-size: 110%'>[[value]]</b>",
									"fillColorsField" : "color",
									"lineColor" : "#646496",
									"fillAlphas" : 1,
									"lineAlpha" : 0.1,
									"type" : "column",
									"title" : "Count Of Name Of Post",
									"valueField" : "visits",
									"columnWidth" : 0.6
								},
								{
									"id" : "g4",
									"valueAxis" : "v2",
									"lineColor" : "#e1ede9",
									"fillColors" : "#e1ede9",
									"fillAlphas" : 1,
									"type" : "column",
									"title" : "Sum Of No Of Posts",
									"valueField" : "NoOfPosts",
									"clustered" : false,
									"columnWidth" : 0.3,
									"balloonText" : "[[title]]:<b style='font-size: 130%'>[[value]]</b>"
								} ],
						"depth3D" : 0,
						"angle" : 30,
						"gridAboveGraphs" : true,
						"chartCursor" : {
							"pan" : true,
							"valueLineEnabled" : false,
							"valueLineBalloonEnabled" : false,

						},
						"categoryField" : "country",
						"categoryAxis" : {
							"gridPosition" : "start",
							"labelRotation" : 45,
							"minorGridEnabled" : true,
							"dashLength" : 1,
						},
						"balloon" : {
							"borderThickness" : 1,
							"shadowAlpha" : 0
						},
						"legend" : {
							"useGraphSettings" : true,
							"position" : "bottom"
						},
						"titles" : [ {
							"id" : "Title-1",
							"size" : 15,
							"text" : "Interval of time for next hearing date of court stays and positions"
						} ],
						"listeners" : [ {
							"event" : "clickGraphItem",
							"method" : function(event) {
								// alert(event.item.category);
								myFunction(event.item.category);
							}
						} ]

					});
</script>
<style>
path {
	stroke: #fff;
}

path:hover {
	opacity: 0.9;
}

rect:hover {
	fill: blue;
}

.axis {
	font: 10px sans-serif;
}

.legend tr {
	border-bottom: 1px solid grey;
}

.legend tr:first-child {
	border-top: 1px solid grey;
}

.axis path, .axis line {
	fill: none;
	stroke: #000;
	shape-rendering: crispEdges;
}

.x.axis path {
	display: none;
}

.legend {
	margin-bottom: 76px;
	display: inline-block;
	border-collapse: collapse;
	border-spacing: 0px;
}

.legend td {
	padding: 4px 5px;
	vertical-align: bottom;
}

.legendFreq, .legendPerc {
	align: right;
	width: 40px;
}
</style>



<!-- Deadline Histogram -->
<script type="text/javascript"
	src="https://www.amcharts.com/lib/3/serial.js"></script>
<style>
#Histodiv {
	width: 28%;
	height: 400px;
}
</style>

<!-- Deadline Histogram -->
<script>
	var chart2 = AmCharts.makeChart("Histodiv", {
		"type" : "serial",
		"categoryField" : "category",
		"angle" : 30,
		"depth3D" : 20,
		"startDuration" : 1,
		"color" : "#000000",
		"categoryAxis" : {
			"gridPosition" : "start"
		},
		"trendLines" : [],
		"graphs" : [ {
			"balloonText" : "[[title]] of [[category]]:[[value]]",
			"fillAlphas" : 1,
			"id" : "AmGraph-1",
			"title" : "within Ideal days",
			"type" : "column",
			"fillColors" : "#FCD202",
			"valueField" : "column-1"
		}, {
			"balloonText" : "[[title]] of [[category]]:[[value]]",
			"fillAlphas" : 1,
			"id" : "AmGraph-2",
			"title" : "Above Ideal days",
			"type" : "column",
			"fillColors" : "#FF6600",
			"valueField" : "column-2"
		} ],
		"guides" : [],
		"valueAxes" : [ {
			"id" : "ValueAxis-1",
			"stackType" : "regular",
			"title" : "Ideal/Non-Ideal Count"
		} ],
		"allLabels" : [],
		"balloon" : {},
		"legend" : {
			"enabled" : true,
			"useGraphSettings" : true
		},
		"titles" : [ {
			"id" : "Title-1",
			"size" : 15,
			"text" : "Ideal Time Chart"
		} ],
		"dataProvider" : [ {
			"category" : "Applications",
			"column-1" : '${aplOpenYellowCount}',
			"column-2" : '${aplOpenRedCount}'
		}, {
			"category" : "Written Exam",
			"column-1" : '${wrtExamYellowCount}',
			"column-2" : '${wrtExamRedCount}'
		}, {
			"category" : "Scrutiny Of Documents",
			"column-1" : '${scrutinyYellowCount}',
			"column-2" : '${scrutinyRedCount}'
		}, {
			"category" : "Interviews",
			"column-1" : '${interviewYellowCount}',
			"column-2" : '${interviewRedCount}'
		}, {
			"category" : "Result & Recommendations",
			"column-1" : '${recommendYellowCount}',
			"column-2" : '${recommendRedCount}'
		} ],
		"categoryAxis" : {
			"gridPosition" : "start",
			"labelRotation" : 45
		},
		"listeners" : [ {
			"event" : "clickGraphItem",
			"method" : function(event) {
				// alert(event.item.category);
				graphTwoData(event.item.category);
			}
		} ]

	});
</script>
</head>

<body class="skin-1">
	<div id="navbar"
		class="navbar navbar-default ace-save-state navbar-fixed-top">
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
		<!-- /.navbar-container -->
	</div>

	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.loadState('main-container')
			} catch (e) {
			}
		</script>

		<div id="sidebar"
			class="sidebar     responsive     ace-save-state sidebar-fixed sidebar-scroll">
			<script type="text/javascript">
				try {
					ace.settings.loadState('sidebar')
				} catch (e) {
				}
			</script>

			<ul class="nav nav-list">
				<li class="active">
							<a href="<c:url value="dashboard"/>"> <i
								class="menu-icon fa fa-tachometer"></i> <span class="menu-text">
									Dashboard </span>
							</a>
							<b class="arrow"></b>
				</li>



				<li class=""><a href="<c:url value="allHSSCPostname"/>"> <c:set
							var="var" value="${module}" />							
								<i class="menu-icon fa fa-list"></i>
								<span class="menu-text">Search Advt Details </span>												
				</a></li>
				
				<li class="">
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
					<c:set var="var" value="${module}" />
					<c:choose>
						<c:when test="${var=='mis' && (user.idRole=='2' || user.idRole=='3')}">
							<li class=""><a href="<c:url value="courtCaseSearch"/>">
									<i class="menu-icon fa fa-fw fa-bank"></i> <span
									class="menu-text"> Search Court Case</span>
	
							</a></li>
						</c:when>
					</c:choose>
				<c:choose>
						   <c:when test="${user.isAdmin=='N'}">
							  <li class=""><a href="<c:url value="requisitionRegistration"/>">

								<i class="menu-icon fa fa-fw fa-plus-square-o"></i><span
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
                 
			</ul>
			<!-- /.nav-list -->

			<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
				<i id="sidebar-toggle-icon"
					class="ace-icon fa fa-angle-double-left ace-save-state"
					data-icon1="ace-icon fa fa-angle-double-left"
					data-icon2="ace-icon fa fa-angle-double-right"></i>
			</div>
		</div>

		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state breadcrumbs-fixed"
					id="breadcrumbs">
					<div class="navbar-buttons navbar-header pull-right"
						role="navigation">
						<ul class="nav ace-nav">
						<c:set var="var" value="${module}"/>
						   <c:choose>
						    <c:when test="${var=='mis' && user.isAdmin=='N'}">
						  	<li class="purple dropdown-modal">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-bell icon-animated-bell"></i>
								<span class="badge badge-important">${notificationCount}</span>
							</a>

							<ul class="dropdown-menu-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="ace-icon fa fa-exclamation-triangle"></i>
									${notificationCount} New Notifications
								</li>
                                 
								<li class="dropdown-content">
									<ul class="dropdown-menu dropdown-navbar navbar-pink">
									<c:forEach items="${allNotifications}" var="tag4"  varStatus="loop">
										<li>
											<a href="javascript:openNotification('${tag4.notificationGeneratedDateAndTime}');">
												<div class="clearfix">
													<span class="pull-left">
														<i class="btn btn-xs no-hover btn-pink fa fa-comment"></i>
														   <span class="msg-body" style="margin-top: -13%;">
														   ${tag4.notificationMsg}	
														    </span>
														   <br>
														     <c:choose> 
														       <c:when test="${tag4.readUnreadStatus=='0'}">
																<span class="msg-time" style="float:right;">
																	<i class="ace-icon fa fa-clock-o"></i>
																	<span Style="color:red;">${tag4.notificationGeneratedDateAndTime}</span>
																</span>
																</c:when>
																<c:otherwise>
																    <span class="msg-time" style="float:right;">
																	<i class="ace-icon fa fa-clock-o"></i>
																	<span>${tag4.notificationGeneratedDateAndTime}</span>
																</span>
																</c:otherwise>
															</c:choose>
														
													</span>
												</div>
											</a>
										</li>
										</c:forEach>
									</ul>
								</li>
							</ul>
						</li>
						</c:when>
						</c:choose>
							<li class="light-blue dropdown-modal"><a
								data-toggle="dropdown" href="#" class="dropdown-toggle"> <img
									class="nav-user-photo" src="assets/images/avatars/avatar2.png" />
									<span class="user-info"> <small>Welcome,</small>
										${user.userName}
								</span> <i class="ace-icon fa fa-caret-down"></i>
							</a>

								<ul
									class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
									<li><a href="<c:url value="changePasswordInSession"/>">
											<i class="ace-icon fa fa-lock"></i> change Password
									</a></li>
									<li><a href="<c:url value="logout "/>"> <i
											class="ace-icon fa fa-power-off"></i> Logout
									</a></li>
								</ul></li>
						</ul>
					</div>
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> Department
						</li>

						<li><c:choose>
								<c:when test="${user.isAdmin=='Y'}"> 
      		                          All Departments
      		                          </c:when>
							</c:choose> <c:choose>
								<c:when test="${user.isAdmin=='N'}">
								${deptInfo}
								</c:when>
							</c:choose></li>
					</ul>
					<c:choose>
					  <c:when test="${user.isAdmin=='Y' && user.idRole!='3'}">
					<ul class="breadcrumb" style="float: right;margin-top: 15px;">
					  <li>
					     Last Updated On:
					  </li>
					  <li>
					     ${userMISLogObj}
					  </li>
					</ul>
					 </c:when>
					</c:choose>
					<!-- /.breadcrumb -->
				</div>

				<div class="page-content">

					<div class="page-header">
									<h1>Advertisement Status</h1>
				
					</div>
					<!-- /.page-header -->
					<form:form method="post" id="depListForm" commandName="user">
						<input type="hidden" name="mAcroStatus" id="mAcroStatus" />
						<input type="hidden" name="nameOfPost" id="nameOfPost"/>
						<input type="hidden" name="deptId" id="deptId" />
						<input type="hidden" name="startDate" id="startDate" />
						<input type="hidden" name="endDate" id="endDate" />
						<input type="hidden" name="caseStatus" id="caseStatus" />
						<input type="hidden" name="nameOfPostForHearingGraph" id="nameOfPostForHearingGraph"/>
						<input type="hidden" name="deptIdForHearingGraph" id="deptIdForHearingGraph" />
						<input type="hidden" name="notificationGeneratedDateAndTime" id="notificationGeneratedDateAndTime" />
						<input type="hidden" name="status" id="status" />
						
						 
						<div class="widgetbox" style="height: 280px;">
						      <c:choose>
						        <c:when test="${user.idRole!='3' && module=='mis'}">
									<div class="center">
										<a class="btn btn-app btn-grey btn-sm1 btn"
											href="<c:url value="allHSSCPostname "/>"> <span
											class="line-height-1 smaller-90">Total Requisitions</span> <br />
											<span class="line-height-1 bigger-170 ">
												${totalReqWithoutWithdrawn}</span> <span
											class="tooltiptext"> <b>Total No. of Posts</b> <br>
												<span class="line-height-1"> ${totalNoOfPostsWithoutWithdrawn} </span>
										</span>
										</a>	

									</div>
									 </c:when>
						      </c:choose>
									<br>
									<div class="center">
										<a class="btn btn-app btn-sm btn btn-success no-hover"
											href="javascript:showStatusSearch('Recommended')"> <span
											class="line-height-1 bigger-170 ">
												${fn:length(recommendedCount)} </span> <br /> <span
											class="line-height-1 smaller-90">Recommended</span> <span
											class="tooltiptextReccom"> <b>Total No. of Posts</b> <br>
												<span class="line-height-1">
													${recommendedTotalNoOfPosts} </span>
										</span>
										</a> <a class="btn btn-app btn btn-sm btn-danger no-hover"
											style="color: #960303;"
											href="javascript:showStatusSearch('Court Stay')"> <span
											class="line-height-1 bigger-170">
												${fn:length(courtStayCount)}</span> <br /> <span
											class="line-height-1 smaller-90">Court Stay</span> <span
											class="tooltiptextReccom"> <b>Total No. of Posts</b> <br>
												<span class="line-height-1">
													${courtStayTotalNoOfPosts} </span>
										</span>
										</a> <a class="btn btn-app btn-sm btn-yellow no-hover"
											href="javascript:showStatusSearch('In Process')"> <span
											class="line-height-1 bigger-170 ">
												${fn:length(inProcessCount)} </span> <br /> <span
											class="line-height-1 smaller-90">In Process</span> <span
											class="tooltiptextReccom"> <b>Total No. of Posts</b> <br>
												<span class="line-height-1">
													${inProcessTotalNoOfPosts} </span>
										</span>
										</a> 
										    <%--  <c:choose>
										      <c:when test="${user.idRole=='3' && module=='mis'}">
										      <a class="btn btn-app btn-sm btn-orange no-hover"
											href="javascript:showStatusSearch('Withdrawn')"> <span
											class="line-height-1 bigger-170 ">
												${fn:length(withdrawnCount)} </span> <br /> <span
											class="line-height-1 smaller-90">Total Court Cases</span> <span
											class="tooltiptextReccom"> <b>Total No. of Posts</b> <br>
												<span class="line-height-1">
													${withdrawnTotalNoOfPost} </span>
										</span>
										</a>
										 </c:when>
										</c:choose> --%>
										 <c:choose>
						                   <c:when test="${user.idRole!='3' && module=='mis'}">
										<a class="btn btn-app btn-sm btn-light no-hover"
											href="javascript:showStatusSearch('Process Halted')"> <span
											class="line-height-1 bigger-170 ">
												${fn:length(ProcessHaltedCount)} </span> <br /> <span
											class="line-height-1 smaller-90">Process Halted</span> <span
											class="tooltiptextReccom"> <b>Total No. of Posts</b> <br>
												<span class="line-height-1">
													${ProcessHaltedTotalNoOfPost} </span>
										</span>
										</a>
										</c:when>
										</c:choose>
										<c:set var="var" value="${module}" />
					                     <c:choose>
					                     	<c:when test="${var=='mis' && user.idRole=='1' && user.isAdmin=='Y'}">
										<span class="btn btn-app btn-sm btn-light no-hover"> <span
											class="line-height-1 bigger-170 ">
												${totalApprovedCount} </span> <br /> <span
											class="line-height-1 smaller-90">Not Advertised</span> <span
											class="tooltiptextReccom"> <b>Total No. of Posts</b> <br>
												<span class="line-height-1">
													${totalApprovedNoOfPostsCount} </span>
										</span>
										</span>
										  </c:when>
										</c:choose>
										
										<c:set var="var" value="${module}" />
										<c:choose>
										<c:when test="${user.isAdmin=='N'}">
										<a class="btn btn-app btn-sm btn-pink no-hover"
											href="javascript:showStatusSearchForReq('saved')"> <span
											class="line-height-1 bigger-170 ">
												${totalRequisitionCount} </span> <br /> <span
											class="line-height-1 smaller-90">New</span> <span
											class="tooltiptextReccom"> <b>Total No. of Posts</b> <br>
												<span class="line-height-1">
													${totalRequisitionNoOFPostsCount} </span>
										</span>
										</a>
										
										<a class="btn btn-app btn-sm btn-info no-hover"
											href="javascript:showStatusSearchForReq('approved')"> <span
											class="line-height-1 bigger-170 ">
												${totalApprovedCount} </span> <br /> <span
											class="line-height-1 smaller-90">Process Not Initiated</span> <span
											class="tooltiptextReccom"> <b>Total No. of Posts</b> <br>
												<span class="line-height-1">
													${totalApprovedNoOfPostsCount} </span>
										</span>
										</a>
										</c:when>
										</c:choose>
										
									</div >
									<div class="center" style="margin-top:20px">
									   <a style="width:500px" class="btn btn-app btn-sm btn-purple no-hover"
											href="javascript:showStatusSearch('Withdrawn')"> <span
											class="line-height-1 smaller-90">Show Withdrawn Requisitions</span>
										</a>
									</div>
									<br>
									<br>
						</div>
						<c:choose>
							<c:when test="${user.isAdmin=='Y' && user.idRole!='3'}">
								<!-- Histogram -->
								<div id="bcx" class="widgetbox" onclick="toggleTable('demo')">
									<!-- <h2 style="text-align:center">Next Step Status Count</h2> -->
									
									<br>
									<div class="searchContainer" style="display:inline;">
                                             <div class="searchBoxes">
									<select class="formControl select2-hidden-accessible" id="selectMacro" name="selectMacro" 
									style="width:170px;height=10px;" data-placeholder="Filter by MacroStatus..." >
									<option >MacroStatus...</option>
									<c:forEach items="${uniqueMacroStatusList}" var="tag" varStatus="loop">
					                          <option value="${tag}" 
					                          <c:set var="var" value="${macroForDropDown}"/><c:choose>
					                           <c:when test="${tag==var}">
					                           selected
					                           </c:when>
					                          </c:choose>
					                          >${tag}</option>	
					                 </c:forEach>
									</select>
									<select class="formControl select2-hidden-accessible" id="selectDept" name="selectDept" 
									style="width:170px;height=10px;" data-placeholder="Filter by Department..." >
									<option >Department...</option>
									<c:forEach items="${deptListForDropDown}" var="tag" varStatus="loop">
					                          <option value="${tag.dEpartmentId}" 
					                          <c:set var="var" value="${deptDropDown}"/><c:choose>
					                           <c:when test="${tag.dEpartmentId==var}">
					                           selected
					                           </c:when>
					                          </c:choose>
					                          >${tag.dEpartment}</option>	
					                 </c:forEach>
									</select>
									<select class="formControl select2-hidden-accessible" id="selectNameOfPost" name="selectNameOfPost" 
									style="width:170px;height=10px;" data-placeholder="Filter by Name Of Post..." >
									<option>Name Of Post...</option>
									<c:forEach items="${uniqueNameOfPostList}" var="tag" varStatus="loop">
					                          <option value="${tag}" 
					                          <c:set var="var" value="${nameOfPostForDropDown}"/><c:choose>
					                           <c:when test="${tag==var}">
					                           selected
					                           </c:when>
					                          </c:choose>
					                          >${tag}</option>	
					                 </c:forEach>
									</select>
									<div class="input-group" style="width:19%;margin:10px 0px 10px 10px;top:-43px;left:46.7%">
									<input type="text" id="datepicker1" class="form-control date-picker" name="selectStartDate" value="${startDate}" placeholder="Process Start date" >
									<span class="input-group-addon">
									<i class="fa fa-calendar bigger-110"></i></span>
									</div>
									<div class="input-group" style="width:19%;margin:10px 0px 10px 10px;top:-87px;left:66.2%">
									<input type="text" id="datepicker2" class="form-control date-picker" name="selectEndDate" value="${endDate}" placeholder="Process End date" >
									<span class="input-group-addon">
									<i class="fa fa-calendar bigger-110"></i></span>
									</div>
											<button class="btn btn-sm btn-warning" style="top:-131px;left:87%" onclick="macrostatusWiseData()">Apply Filter</button>				
									</div>
								
								</div>
								 <center>
								       <p style="color:red;">${failed}</p>
								 </center>
									
									<center>
										<div id="chartdiv" ></div>
									</center>
								</div>
								<div id="tablePrint"></div>

								<!-- Deadline histogram-->
								<div id="abx" class="widgetbox" onclick="toggleTable('secondTable')">
									<center>
										<div id="Histodiv" style="width: 50%; height: 500px; background-color: #FFFFFF;"></div>
									</center>
								</div>

								<div id="secondTable"></div>
								<!-- Deadline histogram-->
								
								<div class="widgetbox">
								   <div class="searchContainer">
                                          <div class="searchBoxes">
                                          <select class="formControl select2-hidden-accessible" id="selectDeptForHearingDates" name="selectDept" 
									style="width:170px;height=10px;" data-placeholder="Filter by Department..." >
									<option >Department For Hearing...</option>
									<c:forEach items="${deptListForDropDown}" var="tag" varStatus="loop">
					                          <option value="${tag.dEpartment}" 
					                          <c:set var="var" value="${deptDropDownForHearingGraph}"/><c:choose>
					                           <c:when test="${tag.dEpartment==var}">
					                           selected
					                           </c:when>
					                          </c:choose>
					                          >${tag.dEpartment}</option>	
					                 </c:forEach>
									</select>
                                             <select class="formControl select2-hidden-accessible" id="selectNameOfPostForHearingDates" name="selectNameOfPost" 
								  	style="width:170px;height=10px;" data-placeholder="Filter by Name Of Post..." >
									<option>Name Of Post for Hearing...</option>
									<c:forEach items="${uniqueNameOfPostList}" var="tag" varStatus="loop">
					                          <option value="${tag}" 
					                          <c:set var="var" value="${nameOfPostForHearingGraphDropDown}"/><c:choose>
					                           <c:when test="${tag==var}">
					                           selected
					                           </c:when>
					                          </c:choose>
					                          >${tag}</option>	
					                 </c:forEach>
									</select>
									  				
                                          </div>
                                           <button class="btn btn-sm btn-warning"  onclick="hearingDatesWiseData()">Apply Filter</button>
                                             
                                   </div>
                                   <center>
								       <p style="color:red;">${failedHearingGraph}</p>
								     </center>
									<center>
										<div id="chartHearingdiv" style="width: 70%; height: 500px; background-color: #FFFFFF;"></div>
									</center>
									
								</div>
						
						</c:when>
						</c:choose>						
								
				</form:form>
				<!-- PAGE CONTENT ENDS -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /.page-content -->
	</div>

	<div class="footer">
		<div class="footer-inner">
			<div class="footer-contentDash">
				<span class="bigger-120"> <span class="blue bolder">HKCL</span>
					Application
				</span> &nbsp; &nbsp; <span class="action-buttons"> <a
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

	<!-- basic scripts -->

	<!--[if !IE]> -->

	<script src="assets/js/jquery-2.1.4.min.js"></script>
	<script src="assets/js/bootstrap-datepicker.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.1/js/select2.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/moment.min.js"></script>	
	<script src="assets/js/daterangepicker.min.js"></script>	
	<script src="assets/js/jquery-ui.custom.min.js"></script>
	<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>
	<script type="text/javascript">
		function myFunction(status) {

			$
					.ajax({
						type : "POST",
						url : "getStatusCountValue",
						data : {
							stat : status
						},
						success : function(response) {
							var tableStr = " <center><table id='demo' class='table  table-bordered table-hover' style='width:800px;'>";
							tableStr += "<thead bgcolor='#FFB6C1' style='display:block;'><tr><th style='width:392px;'>Advt No</th><th style='width:392px;'>Cat No</th><th style='width:392px;'>Name Of Post</th><th style='width:390px;'>"
									+ response[0].status
									+ "</th>"
									+ "<th style='width:400px;'>No Of Posts</th><th style='width:400px;'>Last Step Date</th><th style='width:18px;'></th></tr></thead>";
							tableStr += "<tbody style='display:block;height:250px;overflow:auto;width:800px;'>";
							for (i = 0; i < response.length; i++) {
								tableStr += "<tr><td align='center' style='width:380px;'>"
										+ response[i].advtNo
										+ "</td><td align='center' style='width:400px;'>"
										+ response[i].catNo + "</td>"
										+ "<td align='center' style='width:400px;'>"
										+ response[i].nAmeOfPost + "</td>"
										+ "<td align='center' style='width:400px;'>"
										+ response[i].status + "</td>"
										+ "<td align='center' style='width:400px;'>"
										+ response[i].nOOfPosts + "</td>"
										+ "<td align='center' style='width:400px;'>"
										+response[i].nextStepDate + "</td></tr>";
							}
							tableStr += "<tr bgcolor='#F5F5DC'><td colspan='3' align='center'><b>Total No of Posts<b></td><td colspan='3' align='center'><b>"
									+ response[0].totalNoOfPosts
									+ "<b></td></tr></tbody></table></center>";
							document.getElementById('tablePrint').innerHTML = tableStr;

						}
					});

		}

		function graphTwoData(status) {
			$
					.ajax({
						type : "POST",
						url : "getDeadlineGraphValues",
						data : {
							stat : status
						},
						success : function(response) {
							var table = " <center><table id='secondTable' class='table  table-bordered table-hover' style='width:800px;'>";
							table += "<thead bgcolor='#FFB6C1' style='display:block;'><tr><th align='center'  style='width:392px;'>AdvtNo</th><th align='center'  style='width:390px;'>PostName</th><th align='center'  style='width:390px;'>CatNo</th><th align='center' style='width:390px;'>Department</th>"
									+ "<th align='center'  style='width:220px;'>AboveIdealDays</th><th align='center'  style='width:390px;'>BelowIdealDays</th><th style='width:18px;'></th></tr></thead>";
							table += "<tbody style='display:block;height:250px;overflow-y:auto;'>";
							for (i = 0; i < response.length; i++) {
								table += "<tr><td align='center' style='min-width:117px;'>"
										+ response[i].advtNo
										+ "</td><td align='center' style='min-width:90px;'>"
										+ response[i].postName + "</td>"
										+ "<td align='center' style='min-width:110px;'>"
										+ response[i].catNo
										+ "</td><td align='center' style='min-width:138px;'>"
										+ response[i].deptName + "</td>"
										+ "<td align='center' style='min-width:135px;'>"
										+ response[i].redCount
										+ "</td><td align='center' style='min-width:165px;'>"
										+ response[i].yellowCount
										+ "</td></tr>";
							}
							table += "</tbody></table></center>";
							document.getElementById('secondTable').innerHTML = table;
						}
					});
		}

		function toggleTable(tableId) {
			//var lTable = document.getElementById(tableId);
			if (document.getElementById(tableId).style.display == 'none') {
				document.getElementById(tableId).style.display = '';
			} else {
				document.getElementById(tableId).style.display = 'none';
			}
		}

		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");

		function showStatusSearch(status) {
			document.getElementById('mAcroStatus').value = status;
			document.getElementById('depListForm').action = "allHSSCPostname";
			document.getElementById('depListForm').submit();
		}
		
		function showStatusSearchForReq(status) {
			document.getElementById('status').value = status;
			document.getElementById('depListForm').action = "allRegisteredRequisitions";
			document.getElementById('depListForm').submit();
		}

		function statusForCourtCase(status) {
			document.getElementById('caseStatus').value = status;
			document.getElementById('depListForm').action = 'courtCaseSearch';
			document.getElementById('depListForm').submit();
		}
		
		function openNotification(notificationGeneratedDateAndTime)
		{
			document.getElementById('notificationGeneratedDateAndTime').value = notificationGeneratedDateAndTime;
			document.getElementById('depListForm').action = 'openNotification';
			document.getElementById('depListForm').submit();
			
		}
	</script>
	
<script>

/* $('#datepicker1').attr('readonly','readonly');
$('#datepicker2').attr('readonly','readonly'); */

$('.date-picker').datepicker({
	autoclose: true,
	todayHighlight: true
})

//show datepicker when clicking on the icon
.next().on(ace.click_event, function(){
	$(this).prev().focus();
});


function macrostatusWiseData(){
	var macro = document.getElementById("selectMacro").value;
	var deptId = document.getElementById("selectDept").value;
	var nameOfPost=document.getElementById("selectNameOfPost").value;
	var strtDate=document.getElementById("datepicker1").value;
	var endDate=document.getElementById("datepicker2").value;
	document.getElementById('nameOfPost').value=nameOfPost;
	document.getElementById('mAcroStatus').value = macro;
	document.getElementById('deptId').value = deptId;
	document.getElementById('startDate').value = strtDate;
	document.getElementById('endDate').value = endDate;
	document.getElementById('depListForm').action = "dashboard";
	document.getElementById('depListForm').submit();
	
}

function hearingDatesWiseData(){
	var nameOfPostForHearingGraph=document.getElementById("selectNameOfPostForHearingDates").value;
	var deptIdForHearingGraph = document.getElementById("selectDeptForHearingDates").value;
	document.getElementById('nameOfPostForHearingGraph').value=nameOfPostForHearingGraph;
	document.getElementById('deptIdForHearingGraph').value = deptIdForHearingGraph;
	document.getElementById('depListForm').action = "dashboard";
	document.getElementById('depListForm').submit();
}

$(document).ready(function() {
	
	 var data = document.getElementById(selectMacro);
      $("#selectMacro").select2({
   	   allowClear: true,
   	   placeholderOption: function () { return 'Please select...';},
			  data: data	  
			 
			});
});

$(document).ready(function() {
	
	 var data = document.getElementById(selectDept);
     $("#selectDept").select2({
  	   allowClear: true,
  	   placeholderOption: function () { return 'Please select...';},
			  data: data	  
			 
			});
});

$(document).ready(function() {
	
	 var data = document.getElementById(selectNameOfPost);
    $("#selectNameOfPost").select2({
 	   allowClear: true,
 	   placeholderOption: function () { return 'Please select...';},
			  data: data	  
			 
			});
});

$(document).ready(function() {
	
	 var data = document.getElementById(selectDeptForHearingDates);
   $("#selectDeptForHearingDates").select2({
	   allowClear: true,
	   placeholderOption: function () { return 'Please select...';},
			  data: data	  
			 
			});
});

$(document).ready(function() {
	
	 var data = document.getElementById(selectNameOfPostForHearingDates);
  $("#selectNameOfPostForHearingDates").select2({
	   allowClear: true,
	   placeholderOption: function () { return 'Please select...';},
			  data: data	  
			 
			});
});

function validateCount(){
	document.getElementById('depListForm').target='Validate Requisitions';	
	document.getElementById('depListForm').onsubmit = window.open("about:blank","Validate Requisitions", "width=1000,height=600");
	document.getElementById('depListForm').action = "readOnlyReq";
	document.getElementById('depListForm').submit();
	}

/* //to translate the daterange picker, please copy the "examples/daterange-fr.js" contents here before initialization
$('input[name=date-range-picker]').daterangepicker({
	'applyClass' : 'btn-sm btn-success',
	'cancelClass' : 'btn-sm btn-default',
	locale: {
		applyLabel: 'Apply',
		cancelLabel: 'Cancel',
	}
}) */
/* .prev().on(ace.click_event, function(){
	$(this).next().focus();
}); */



</script>
	

</body>
</html>
