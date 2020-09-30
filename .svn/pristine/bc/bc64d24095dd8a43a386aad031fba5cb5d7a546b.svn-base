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
<link rel="stylesheet" href="assets/css/select2.min.css" /> 
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />    
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

<!-- Resources -->
<script src="assets/js/histogram.js"></script>
<script src="https://www.amcharts.com/lib/3/serial.js"></script>
<script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>

<!-- Styles -->
<style>
#chartdiv {
	width		: 100%;
	height		: 500px;
	font-size	: 11px;
}	
#deptdiv {
	width		: 100%;
	height		: 500px;
	font-size	: 11px;
}					
</style>
<!-- Chart code -->
<script>
var chart = AmCharts.makeChart( "chartdiv", {
  "type": "serial",
  "theme": "light",
  "dataProvider":populateYearWiseData() ,
  "valueAxes": [ {
    "gridColor": "#FFFFFF",
    "gridAlpha": 0.2,
    "dashLength": 0,
    "title" : "Year Wise Count"
  } ],
  "gridAboveGraphs": true,
  "startDuration": 1, 
  "titles" : [ {
		"id" : "Title-1",
		"size" : 15,
		"text" : "Year wise Summary"
	} ],
  "graphs": [ {
    "balloonText": "[[category]]: <b>[[value]]</b>",
    "fillAlphas": 0.8,
    "lineAlpha": 0.2,
    "type": "column",
    "valueField": "count"
  } ],
  "chartCursor": {
    "categoryBalloonEnabled": false,
    "cursorAlpha": 0,
    "zoomable": false
  },
  "categoryField": "year",
  "categoryAxis": {
    "gridPosition": "start",
    "gridAlpha": 0,
    "tickPosition": "start",
    "tickLength": 20
  }  

} );

function populateYearWiseData(){
	var data = [];
	 <c:forEach items="${yearWiseCountList}" var="tag"  varStatus="loop">
	 data.push({	
			"year" : '${tag.year}',
			"count": '${tag.count}',
		});
     </c:forEach>
     return data;
}
</script>
<script>
var chart2 = AmCharts.makeChart("deptdiv", {
	"type" : "serial",
	"categoryField" : "dept",
	"angle" : 30,
	"depth3D" : 0,
	"startDuration" : 1,
	"color" : "#000000",
	"categoryAxis" : {
		"gridPosition" : "start",
		"labelRotation" : 20
	},
	"graphs" : [ {
		"balloonText" : "[[title]] [[category]]:[[value]]",
		"fillAlphas" : 1,
		"id" : "AmGraph-1",
		"type" : "column",
		"fillColors" : "#62cf73",
		"valueField" : "count"
	}],
	"valueAxes" : [ {
		"id" : "ValueAxis-1",
		"stackType" : "regular",
		"title" : "Department Wise Count"
	} ],
	"legend" : {
		"enabled" : false,
		"useGraphSettings" : false
	},
	"titles" : [ {
		"id" : "Title-1",
		"size" : 15,
		"text" : "No. of Court cases- Department wise"
	} ],
	"dataProvider" : populateDeptWiseData()

});

function populateDeptWiseData(){
	var data = [];
	 <c:forEach items="${deptWiseCount}" var="tag"  varStatus="loop">
	 data.push({	
			"dept" : '${tag.deptName}',
			"count": '${tag.count}',
		});
     </c:forEach>
     return data;
}
</script>
<script>
var chart = AmCharts
.makeChart(
		"impactdiv",
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
			"dataProvider" :generateImpactData(),
			"valueAxes" : [ {
				"id" : "v1",
				"title" : "Court Cases Count",
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
						"lineColor" : "#DB4C3C",
						"fillAlphas" : 1,
						"lineAlpha" : 0.1,
						"type" : "column",
						"title" : "Count Of Unique Court Cases",
						"valueField" : "countOfCases",
						"columnWidth" : 0.6
					},
					{
						"id" : "g4",
						"valueAxis" : "v2",
						"lineColor" : "#e1ede9",
						"fillColors" : "#e1ede9",
						"fillAlphas" : 1,
						"type" : "column",
						"title" : "Sum Of No. of Posts",
						"valueField" : "sumOfNoOfPosts",
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
			"categoryField" : "year",
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
					//myFunction(event.item.category);
				}
			} ],
			"titles" : [ {
				"id" : "Title-1",
				"size" : 15,
				"text" : "No. of Posts impacted because of Court Cases"
			} ],

		});
		
	function generateImpactData(){
		var data = [];
		 <c:forEach items="${impactGraphCountList}" var="tag"  varStatus="loop">
		 data.push({	
			 	"year" : '${tag.year}',
				"countOfCases" : '${tag.count}',
				"sumOfNoOfPosts" : '${tag.sumOfNoOfPost}',
				"color" : "#DB4C3C"
			});
	     </c:forEach>
	     return data;	
	}	
</script>

<script>
var chart = AmCharts
.makeChart(
		"impactdivbylegalissue",
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
			"dataProvider" :generateImpactLegalData(),
			"valueAxes" : [ {
				"id" : "v1",
				"title" : "Court Cases Count",
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
						"lineColor" : "#AE85C9",
						"fillAlphas" : 1,
						"lineAlpha" : 0.1,
						"type" : "column",
						"title" : "Count Of Unique Court Cases",
						"valueField" : "countOfCases",
						"columnWidth" : 0.6
					},
					{
						"id" : "g4",
						"valueAxis" : "v2",
						"lineColor" : "#e1ede9",
						"fillColors" : "#e1ede9",
						"fillAlphas" : 1,
						"type" : "column",
						"title" : "Sum Of No. of Posts",
						"valueField" : "sumOfNoOfPosts",
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
			"categoryField" : "legalIssue",
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
					//myFunction(event.item.category);
				}
			} ],
			"titles" : [ {
				"id" : "Title-1",
				"size" : 15,
				"text" : "Legal Issue-wise Court Cases and posts corresponding to them"
			} ],

		});
		
	function generateImpactLegalData(){
		var data = [];
		 <c:forEach items="${impactGraphLegalIssueCountList}" var="tag"  varStatus="loop">
		 data.push({	
			 	"legalIssue" : '${tag.legalIssue}',
				"countOfCases" : '${tag.count}',
				"sumOfNoOfPosts" : '${tag.sumOfNoOfPost}',
				"color" : "#AE85C9"
			});
	     </c:forEach>
	     return data;	
	}	
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
					<a href="<c:url value="dashboardForCourtCase"/>">
					 <i	class="menu-icon fa fa-tachometer"></i> <span class="menu-text">
					Dashboard </span></a><b class="arrow"></b>
				</li>



				<li class=""><a href="<c:url value="allHSSCPostname"/>">
						<i class="menu-icon fa fa-list"></i>
						<span class="menu-text">Add New Court Case </span></a></li>
				<c:set var="var" value="${module}" />
				<c:choose>
					<c:when test="${var=='mis' && user.idRole=='2'}">
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
							</c:when>
						</c:choose>
                 
				<li class=""> 
							<a href="<c:url value="courtCaseSearch"/>"> <i
								class="menu-icon fa fa-fw fa-bank"></i> <span class="menu-text">
									Search Court Case</span>

							</a>
						</li>
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
								${deptName}
								</c:when>
							</c:choose></li>
					</ul>
					<ul class="breadcrumb" style="float: right;margin-top: 15px;">
					  <li>
					     Last Updated On:
					  </li>
					  <li>
					     ${userLogObj}
					  </li>
					</ul>
					<!-- /.breadcrumb -->
				</div>

				<div class="page-content">

					<div class="page-header">
						<h1>Court Case Status</h1>
						
					</div>
					<!-- /.page-header -->
					<form:form method="post" id="courtCaseForm" commandName="user">
						<input type="hidden" name="mAcroStatus" id="mAcroStatus" />
						<input type="hidden" name="caseStatus" id="caseStatus" />
						<input type="hidden" name="nameOfPost" id="nameOfPost"/>
						<input type="hidden" name="deptId" id="deptId" />
						<input type="hidden" name="caseStatus" id="caseStatus" />
						<input type="hidden" name="legalIssue" id="legalIssue" />
						<input type="hidden" name="cAtNo" id="cAtNo" />
						<input type="hidden" name="advtNo" id="advtNo" />
						<input type="hidden" name="year" id="year" />
						<input type="hidden" name="legalIssueyear" id="legalIssueyear" />
						<input type="hidden" name="departId" id="departId" />
						<input type="hidden" name="caseStatusForImpact" id="caseStatusForImpact" />
						<input type="hidden" name="departIdForLegal" id="departIdForLegal" />
						
						<div class="widgetbox" style="height: 205px;">
								<div class="center">
									<a class="btn btn-app btn-grey btn-sm1 btn"
										href="<c:url value="courtCaseSearch "/>"> <span
										class="line-height-1 smaller-90">Total Court Cases</span> <br />
										<span class="line-height-1 bigger-170 ">${fn:length(allCourtCaseDataList)}</span>
									</a>

								</div>
								<br>
								<div class="center">
									<a class="btn btn-app btn-sm btn btn-success no-hover"
										href="javascript:statusForCourtCase('Disposed off')"> <span
										class="line-height-1 bigger-170 ">${fn:length(disposedOfCount)}</span>
										<br /> <span class="line-height-1 smaller-90">Disposed
											off</span>

									</a> <a class="btn btn-app btn btn-sm btn-danger no-hover"
										style="color: #960303;"
										href="javascript:statusForCourtCase('Dismissed')"> <span
										class="line-height-1 bigger-170">${fn:length(dismissedCount)}</span>

										<br /> <span class="line-height-1 smaller-90">Dismissed</span>

									</a> <a class="btn btn-app btn-sm btn-warning no-hover"
										href="javascript:statusForCourtCase('Allowed')"> <span
										class="line-height-1 bigger-170 ">${fn:length(allowedCount)}</span>

										<br /> <span class="line-height-1 smaller-90">Allowed</span>

									</a> <a class="btn btn-app btn-sm btn-purple no-hover"
										href="javascript:statusForCourtCase('In Process(In Hearing)')">
										<span class="line-height-1 bigger-170 ">
											${fn:length(inProcessCourtCount)}</span> <br /> <span
										class="line-height-1 smaller-90">In Process</span>

									</a> <a class="btn btn-app btn-sm btn-light no-hover"
										href="javascript:statusForCourtCase('Admitted')"> <span
										class="line-height-1 bigger-170 ">
											${fn:length(admittedCount)}</span> <br /> <span
										class="line-height-1 smaller-90">Admitted</span>

									</a>

								</div>
							
				</div>
				</form:form>	
		<div id="abx" class="widgetbox">
		<div class="searchContainer">
                 <div class="searchBoxes">
		<select class="formControl select2-hidden-accessible" id="selectDept" name="selectDept" 
		style="width:200px;height=10px; " data-placeholder="Filter by Department..." >
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
			style="width:200px;height=10px;" data-placeholder="Filter by Name Of Post..." >
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
		<select class="formControl select2-hidden-accessible" id="selectStatus" name="selectStatus" 
			style="width:200px;height=10px;" data-placeholder="status..." >
			<option>status...</option>
			<c:forEach items="${uniqueStatusList}" var="tag" varStatus="loop">
			 <option value="${tag}" 
			 <c:set var="var" value="${caseStatusForDropDown}"/><c:choose>
			 <c:when test="${tag==var}">
			 selected
			</c:when>
			</c:choose>
			 >${tag}</option>	
			</c:forEach>
		</select>
		</div>
		<button class="btn btn-sm btn-warning" onclick="applyFilter()">Apply Filter</button>
		
		 </div>
		  <center>
		      <p style="color:red;">${failed}</p>
		  </center>
		 <center>
				<!-- HTML -->
			<div id="chartdiv" style="width: 80%; height: 350px; background-color: #FFFFFF;"></div>	
			</center>
		 
		 </div>
			<div  class="widgetbox">
			<%-- <div class="searchContainer">
			 <div class="searchBoxes">
		<select class="formControl select2-hidden-accessible" id="selectAdvt" name="selectAdvt" 
			style="width:200px;height=10px;" data-placeholder="Filter by status..." >
			<option>Advt...</option>
			<c:forEach items="${uniqueAdvtList}" var="tag" varStatus="loop">
			 <option value="${tag}" 
			 <c:set var="var" value="${advtNoForDropDown}"/><c:choose>
			 <c:when test="${tag==var}">
			 selected
			</c:when>
			</c:choose>
			 >${tag}</option>	
			</c:forEach>
		</select> 
		<select class="formControl select2-hidden-accessible" id="selectCat" name="selectCat" 
			style="width:200px;height=10px;" data-placeholder="Filter by status..." >
			<option>CatNo...</option>
			<c:forEach items="${uniqueCatNoList}" var="tag" varStatus="loop">
			 <option value="${tag}" 
			 <c:set var="var" value="${cAtNoForDropDown}"/><c:choose>
			 <c:when test="${tag==var}">
			 selected
			</c:when>
			</c:choose>
			 >${tag}</option>	
			</c:forEach>
		</select>
		<select class="formControl select2-hidden-accessible" id="selectImpactDept" name="selectDept" 
		style="width:200px;height=10px; " data-placeholder="Filter by Department..." >
		<option >Department...</option>
		<c:forEach items="${deptListForDropDown}" var="tag" varStatus="loop">
		<option value="${tag.dEpartmentId}" 
		 <c:set var="var" value="${deptDropDownForImpactGraph}"/><c:choose>
		 <c:when test="${tag.dEpartmentId==var}">
		 selected
		</c:when>
		 </c:choose>
		 >${tag.dEpartment}</option>	
		 </c:forEach>
		</select>
		<select class="formControl select2-hidden-accessible" id="selectImpactStatus" name="selectStatus" 
			style="width:200px;height=10px;" data-placeholder="Status..." >
			<option >Status...</option>
			<c:forEach items="${uniqueStatusList}" var="tag" varStatus="loop">
			 <option value="${tag}" 
			 <c:set var="var" value="${caseStatusForImpactDropDown}"/><c:choose>
			 <c:when test="${tag==var}">
			 selected
			</c:when>
			</c:choose>
			 >${tag}</option>	
			</c:forEach>
		</select>
			</div>
				<button class="btn btn-sm btn-warning" onclick="appyFilterForImpactGraph()">Apply Filter</button>
			</div> --%>
			<center>
		      <p style="color:red;">${failedImapactGraph}</p>
		  </center>
		
			<center>
				<!-- HTML -->
			<div id="impactdiv" style="width: 80%; height: 350px; background-color: #FFFFFF;"></div>	
			</center>
			</div>
		
		<div  class="widgetbox">
		<div class="searchContainer" >
                 <div class="searchBoxes">
		<select class="formControl select2-hidden-accessible" id="selectYear" name="selectYear" 
		style="width:150px;height=10px;" data-placeholder="Filter by Department..." >
		<option >Year...</option>
		<c:forEach items="${uniqueYearList}" var="tag" varStatus="loop">
		<option value="${tag}" 
		 <c:set var="var" value="${yearForDropDown}"/><c:choose>
		 <c:when test="${tag==var}">
		 selected
		</c:when>
		 </c:choose>
		 >${tag}</option>	
		 </c:forEach>
		</select>
		<select class="formControl select2-hidden-accessible" id="selectLegalIssue" name="selectLegalIssue" 
		style="width:150px;height=10px;" data-placeholder="LegalIssue..." >
		<option >LegalIssue...</option>
		<c:forEach items="${uniqueLegalIssuesList}" var="tag" varStatus="loop">
		<option value="${tag}" 
		 <c:set var="var" value="${legalIssueForDropDown}"/><c:choose>
		 <c:when test="${tag==var}">
		 selected
		</c:when>
		 </c:choose>
		 >${tag}</option>	
		 </c:forEach>
		</select>
		</div>
			<button class="btn btn-sm btn-warning" onclick="appyFilterForDeptWiseGraph()">Apply Filter</button>
			</div>
			<center>
		      <p style="color:red;">${failedDepartment}</p>
		  </center>
			<center>
				<!-- HTML -->
			<div id="deptdiv" style="width:100%; height: 500px; background-color: #FFFFFF;"></div>	
			</center>
		</div>
		
		
		<div  class="widgetbox">
		 <div class="searchContainer" >
                 <div class="searchBoxes">
		<select class="formControl select2-hidden-accessible" id="selectYearForLegalIssue" name="selectYearForLegalIssue" 
		style="width:150px;height=10px;" data-placeholder="Filter by Department..." >
		<option >Year...</option>
		<c:forEach items="${uniqueYearListForLegalGraph}" var="tag2" varStatus="loop">
		<option value="${tag2}" 
		 <c:set var="var" value="${yearForLegalGraphDropDown}"/><c:choose>
		 <c:when test="${tag2==var}">
		 selected
		</c:when>
		 </c:choose>
		 >${tag2}</option>	
		 </c:forEach>
		</select>
		<select class="formControl select2-hidden-accessible" id="selectDeptForLegal" name="selectDept" 
		style="width:200px;height=10px; " data-placeholder="Filter by Department..." >
		<option >Department...</option>
		<c:forEach items="${deptListForDropDown}" var="tag" varStatus="loop">
		<option value="${tag.dEpartmentId}" 
		 <c:set var="var" value="${deptDropDownForImpactLegalGraph}"/><c:choose>
		 <c:when test="${tag.dEpartmentId==var}">
		 selected
		</c:when>
		 </c:choose>
		 >${tag.dEpartment}</option>	
		 </c:forEach>
		</select>
		   </div>
		    <button class="btn btn-sm btn-warning" onclick="appyFilterForImpactLegalIssueGraph()">Apply Filter</button>
		</div>
		     <center>
		       <p style="color:red;">${failedLegalIssueImpactgraph}</p>
		     </center>
		    <center>
				<!-- HTML -->
			<div id="impactdivbylegalissue" style="width: 80%; height: 500px; background-color: #FFFFFF;"></div>	
			</center>
		</div>
				
				
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
<script>
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
	
	 var data = document.getElementById(selectStatus);
   $("#selectStatus").select2({
	   allowClear: true,
	   placeholderOption: function () { return 'Please select...';},
			  data: data	  
			 
			});
});

$(document).ready(function() {
	
	 var data = document.getElementById(selectYear);
  $("#selectYear").select2({
	   allowClear: true,
	   placeholderOption: function () { return 'Please select...';},
			  data: data	  
			 
			});
});

$(document).ready(function() {
	
	 var data = document.getElementById(selectLegalIssue);
 $("#selectLegalIssue").select2({
	   allowClear: true,
	   placeholderOption: function () { return 'Please select...';},
			  data: data	  
			 
			});
});

/* $(document).ready(function() {
	
	 var data = document.getElementById(selectAdvt);
$("#selectAdvt").select2({
	   allowClear: true,
	   placeholderOption: function () { return 'Please select...';},
			  data: data	  
			 
			});
});

$(document).ready(function() {
	
	 var data = document.getElementById(selectCat);
$("#selectCat").select2({
	   allowClear: true,
	   placeholderOption: function () { return 'Please select...';},
			  data: data	  
			 
			});
}); */

$(document).ready(function() {
	
	 var data = document.getElementById(selectYearForLegalIssue);
$("#selectYearForLegalIssue").select2({
	   allowClear: true,
	   placeholderOption: function () { return 'Please select...';},
			  data: data	  
			 
			});
});
/* $(document).ready(function() {
	
	 var data = document.getElementById(selectImpactDept);
$("#selectImpactDept").select2({
	   allowClear: true,
	   placeholderOption: function () { return 'Please select...';},
			  data: data	  
			 
			});
});
$(document).ready(function() {
	
	 var data = document.getElementById(selectImpactStatus);
$("#selectImpactStatus").select2({
	   allowClear: true,
	   placeholderOption: function () { return 'Please select...';},
			  data: data	  
			 
			});
}); */
$(document).ready(function() {
	
	 var data = document.getElementById(selectDeptForLegal);
$("#selectDeptForLegal").select2({
	   allowClear: true,
	   placeholderOption: function () { return 'Please select...';},
			  data: data	  
			 
			});
});


</script>
	<script src="assets/js/jquery-2.1.4.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery-ui.custom.min.js"></script>
	<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.1/js/select2.min.js"></script>
	
	<script>
	function applyFilter(){
	var deptId=document.getElementById('selectDept').value;	
	var nameOfPost=document.getElementById('selectNameOfPost').value;
	var status=document.getElementById('selectStatus').value;
	document.getElementById('caseStatus').value=status;
	document.getElementById('nameOfPost').value=nameOfPost;
	document.getElementById('deptId').value = deptId;
	document.getElementById('courtCaseForm').action = 'dashboardForCourtCase';
	document.getElementById('courtCaseForm').submit();	
	}
	
	function statusForCourtCase(status) {
		document.getElementById('caseStatus').value = status;
		document.getElementById('courtCaseForm').action = 'courtCaseSearch';
		document.getElementById('courtCaseForm').submit();
	}
	
	function appyFilterForDeptWiseGraph(){
		var year=document.getElementById('selectYear').value;
		var legalIssue=document.getElementById('selectLegalIssue').value;
		document.getElementById('legalIssue').value=legalIssue;
		document.getElementById('year').value=year;
		document.getElementById('courtCaseForm').action = 'dashboardForCourtCase';
		document.getElementById('courtCaseForm').submit();
	}
	
	function appyFilterForImpactGraph(){
		var advtNo=document.getElementById('selectAdvt').value;
		var catNo=document.getElementById('selectCat').value;
		var departId=document.getElementById('selectImpactDept').value;
		var caseStatusForImpact=document.getElementById('selectImpactStatus').value;
		document.getElementById('advtNo').value=advtNo;
		document.getElementById('cAtNo').value=catNo;
		document.getElementById('departId').value=departId;
		document.getElementById('caseStatusForImpact').value=caseStatusForImpact;
		document.getElementById('courtCaseForm').action = 'dashboardForCourtCase';
		document.getElementById('courtCaseForm').submit();
	}
	
	function appyFilterForImpactLegalIssueGraph(){
		var legalIssueyear=document.getElementById('selectYearForLegalIssue').value;
		var departIdForLegal=document.getElementById('selectDeptForLegal').value;
		document.getElementById('legalIssueyear').value=legalIssueyear;
		document.getElementById('departIdForLegal').value=departIdForLegal;
		document.getElementById('courtCaseForm').action = 'dashboardForCourtCase';
		document.getElementById('courtCaseForm').submit();
	}
	</script>

</body>
</html>
