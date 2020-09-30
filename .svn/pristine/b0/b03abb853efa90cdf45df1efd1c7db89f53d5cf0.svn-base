<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="org.apache.commons.beanutils.*"%>
<html>
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
								Court Case
							</li>

							<li>
							 <c:choose>
      		                          <c:when test="${user.isAdmin=='Y'}"> 
      		                          All Court Cases
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
                                     
								<div class="row">
									<div class="col-xs-12">
										

										<div class="clearfix">
											<div class="pull-right tableTools-container"></div>
										</div>
										  <form:form method="post" name="courtCaseForm" id="courtCaseForm" action="courtCaseSearch">	
										  <input type="hidden" id="pageSizeTotal" name="pageSizeTotal" value="${pageSizeTotal}" />
										  <input type="hidden" id="pageNo" name="pageNo" />
     							     	  <input type="hidden" id="page" name="page" value="" /> 	
     							     	  <input type="hidden" id="caseId" name="caseId"/>	
     							     	  <input type="hidden" id="sRNo" name="sRNo"/>
     							     	  
     							     	  <input type="hidden" id="pagination" name="pagination" />
										  <input type="hidden" id="sort" name="sort" value="${sort}" />  
										  <input type="hidden" id="sortDirection" name="sortDirection" value="${sortDirection}" />  
     							     	  
                                         <div class="searchContainer">
                                             <div class="searchBoxes">
                                              
                                                <select name="aDvtNo" id="selectCat5" class="formControl"  style="width:140px;" 
											   onChange="javascript:test()" data-placeholder="Search by year...">
											   <option>Search Advertisement Number...</option>
											  <c:forEach items="${allHsscPostListForADVTNOForSearch}" var="tag2" varStatus="loop">
					                          <option value="${tag2}" 
					                          <c:set var="var" value="${advtForDropdown}"/><c:choose>
					                           <c:when test="${tag2==var}">
					                           selected
					                           </c:when>
					                          </c:choose>
					                          >${tag2}</option>	
					                          </c:forEach>
											 </select>	
											 
											  <select name="writNo" id="selectCat" class="formControl"  style="width:140px;" 
											  onChange="javascript:test()" data-placeholder="Search by writNo...">
											   <option>Search Case No...</option>
											  <c:forEach items="${distinctWritNoList}" var="tag"  varStatus="loop">
					                          <option value="${tag}"   
					                          <c:set var="var" value="${writNoForDropDown}"/><c:choose>
					                           <c:when test="${tag==var}">
					                           selected
					                           </c:when>
					                          </c:choose>
					                          >${tag}</option>	
					                          </c:forEach>
											 </select>
											 											 
											  <select name="caseStatus" id="selectCat2" class="formControl"  style="width:140px;" 
											   onChange="javascript:test()" data-placeholder="Search by caseStatus...">
											   <option>Search by caseStatus...</option>
											  <c:forEach items="${distinctCaseStatusList}" var="tag"  varStatus="loop">
					                          <option value="${tag}"
					                          <c:set var="var" value="${caseStatusForDropDown}"/><c:choose>
					                           <c:when test="${tag==var}">
					                           selected
					                           </c:when>
					                          </c:choose>
					                          
					                          >${tag}</option>	
					                          </c:forEach>
											 </select>
											 
									 <select name="petitionerName" id="selectCat3" class="formControl"  style="width:140px;" 
											 onChange="javascript:test()"  data-placeholder="Search by Petitioner name..."> 
										  <option>Search by Petitioner name...</option>
											  <c:forEach items="${allHSSCPetitionerNames}" var="tag"  varStatus="loop">
				                          <option value="${tag}"
				                           <c:set var="var" value="${petitionerName}"/><c:choose> 
					                           <c:when test="${tag==var}"> 
					                           selected 
					                           </c:when> 
					                          </c:choose> 
					                          >${tag}</option>	
 					                          </c:forEach>
										 </select>
											 
											  <select name="caseType" id="selectCat4" class="formControl"  style="width:140px;" 
											   onChange="javascript:test()" data-placeholder="Search by case Type...">
											  <option>Search by case Type...</option>
											  <c:forEach items="${distinctCaseTypeList}" var="tag"  varStatus="loop">
					                          <option value="${tag}"
					                          
					                          <c:set var="var" value="${caseTypeForDropDown}"/><c:choose>
					                           <c:when test="${tag==var}">
					                           selected
					                           </c:when>
					                          </c:choose>
					                          
					                          >${tag}</option>	
					                          </c:forEach>
											 </select>
											 
											 <select name="year" id="selectCat1" class="formControl"  style="width:140px;" 
											   onChange="javascript:test()" data-placeholder="Search by year...">
											   <option>Search by year...</option>
											  <c:forEach items="${distinctYearList}" var="tag"  varStatus="loop">
					                          <option value="${tag}"
					                          
					                          <c:set var="var" value="${yearForDropDown}"/><c:choose>
					                           <c:when test="${tag==var}">
					                           selected
					                           </c:when>
					                          </c:choose>
					                          
					                          >${tag}</option>	
					                          </c:forEach>
											 </select>
											 
											  <select name="hearingDate" id="selectHearingDate" class="formControl"  style="width:140px;" 
											   onChange="javascript:test()" data-placeholder="Search by Hearing Date...">
											   <option>Search by Hearing Date...</option>
											  <c:forEach items="${hearingDetailsUniqueDateList}" var="tag"  varStatus="loop">
					                          <option value="${tag}" 
					                          <c:set var="var" value="${hearingDateForDropDown}"/>
					                          <c:choose>
					                           <c:when test="${tag==var}">
					                           selected
					                           </c:when>
					                          </c:choose>
					                          >${tag}</option>	
					                          </c:forEach>
											 </select>
											 
									    </div>
									    <a class="btn btn-sm btn-warning" href="javascript:searchCourtCaseDetails();" >Search</a> 
										 </div>
 	

									  <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline no-footer">
									 <display:table  id="dynamic-table" class="table table-striped table-bordered table-hover" excludedParams="*" 
									  requestURI="" name="allCourtCaseDataList"  
									   pagesize="${pageSize}" uid="tblCourtList" cellspacing="0" >
									    
									    <display:column   property="policeDetailsObj.deptObj.dEpartment" title="Department Name" sortable="true"  ></display:column>
									    <display:column   property="policeDetailsObj.aDvtNo" title="Advertisement Number" sortable="true"></display:column>
									    <display:column   property="policeDetailsObj.nAmeOfPost" title="Name Of Post" sortable="true" ></display:column>
									    <display:column   property="policeDetailsObj.cAtNo" title="Cat No." sortable="true"></display:column>
									    <display:column   property="petitioners" title="Name of Petitioner" sortable="true"></display:column>
									    <display:column   property="caseStatus" title="Status" sortable="true"></display:column>
									    <display:column   property="caseType" title="Type of Case" sortable="true"></display:column>
									    <display:column   property="writNo" title="Case No." sortable="true"></display:column>
									    <display:column   property="year" title="Year" sortable="true"></display:column>
									    <display:column   property="stay" title="Stay Status" sortable="true"></display:column>
									    <display:column   property="legalIssue" title="Legal Issue" sortable="true"></display:column>
									    <display:column   property="otherLegalIssue" title="Other Issue" sortable="true"></display:column>
									    <display:column   property="dateList" title="Next Date Of Hearing" sortable="true"></display:column>
									  <c:choose>
      		                          <c:when test="${user.idRole!='3'}">     
									 <display:column> 
									 <c:set var="var" value="${module}"/>
									  <c:choose>
      		                          <c:when test="${user.isAdmin=='Y' && (var=='mis' || var=='cc') && user.idRole!='3'}">     
									 &nbsp&nbsp  <a  href="javascript:editDetails('${tblCourtList.caseId}','${tblCourtList.sRNo}');" title="Edit Details"> <i class="ace-icon fa fa-pencil bigger-120"></i></a> &nbsp; 
									  </c:when>
									  </c:choose>
									   &nbsp <a  href="javascript:viewDetails('${tblCourtList.caseId}','${tblCourtList.sRNo}');" title="View Details"><img  src="resources/photos/show.png"  /> </a> &nbsp; 
										  </display:column> 
									</c:when>
									</c:choose>	  
										  
									   </display:table>
										 </div>	
										 <c:choose>
      		                              <c:when test="${user.isAdmin=='Y' && (var=='mis' || var=='cc') && user.idRole!='3'}">    
										<a href="javascript:exportPage('${pageSizeTotal }','${writNo}','${caseStatus}','${petitionerName}','${caseType}','${year}','${aDvtNo}','${hearingDate}')"  class="btn btn-sm btn-warning" >
										Export Page
										</a>
										<a href="javascript:showUniqueAdvtData()"  class="btn btn-sm btn-warning" >
										Unique Advt Wise Cases
										</a>
										</c:when>
										</c:choose>
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
<script>


function viewDetails(caseId,sRNo){
	   document.getElementById('caseId').value=caseId;
	   document.getElementById('sRNo').value=sRNo;
	   document.getElementById('courtCaseForm').action="allHsscCourtCaseData";
	   document.getElementById('courtCaseForm').submit();
   // window.location.href='/TelephoneDirectoryApi/showDept?idDepartment='+idDepartment
}
function editDetails(caseId,sRNo){
	   document.getElementById('caseId').value=caseId;
	   document.getElementById('sRNo').value=sRNo;
	   document.getElementById('courtCaseForm').action="editCourtCase";
	   document.getElementById('courtCaseForm').submit();
  
}
function showUniqueAdvtData(){
	  document.getElementById('courtCaseForm').action="uniqueAdvtWithNoOfCases";
	   document.getElementById('courtCaseForm').submit();
}

function searchCourtCaseDetails(){
	document.getElementById('courtCaseForm').action='courtCaseSearch';
    document.getElementById('courtCaseForm').target='';
    document.getElementById('courtCaseForm').onsubmit = '';
    document.getElementById('courtCaseForm').submit();
}

function goToPage(pageNo){
	
	document.getElementById('page').value=pageNo;
	document.getElementById('pagination').value="yes";
    document.getElementById('courtCaseForm').action='courtCaseSearch';
    document.getElementById('courtCaseForm').target='';
    document.getElementById('courtCaseForm').onsubmit = '';
	
	document.getElementsByTagName('form')[0].submit();
}

function nextPrev(pageNo){
	//clicker();
	
	pageNumber = pageNo.substring(pageNo.lastIndexOf('=')+1);
	document.getElementById('pagination').value="yes";
	document.getElementById('page').value=pageNumber;
    document.getElementById('courtCaseForm').action='courtCaseSearch';
    document.getElementById('courtCaseForm').target='';
    document.getElementById('courtCaseForm').onsubmit = '';
	
	//var formName = document.getElementsByTagName('form')[3].id;
	document.getElementsByTagName('form')[0].submit();
}

function exportPage(pageSizeTotal,writNo,caseStatus, petitionerName, caseType, year, aDvtNo,hearingDate){
	   document.getElementById('courtCaseForm').action="exportCourtCaseData?pageSizeTotal="+pageSizeTotal+"&&writNo="+writNo+"&&caseStatus="+caseStatus+"&&petitionerName="+petitionerName
		   +"&&caseType="+caseType+"&&year="+year+"&&aDvtNo="+aDvtNo+"&&hearingDate"+hearingDate;
 	document.getElementById('courtCaseForm').target='print_popup';
 	document.getElementById('courtCaseForm').onsubmit = window.open("about:blank","print_popup", "width=1000,height=600");
 	document.getElementById('courtCaseForm').submit();
	}


function test(){
	
	var thArray = [];
	var tab = document.getElementById('tblCourtList');
	var col1 = tab.rows[0].cells[0].getElementsByTagName('a')[0].getAttribute("href");
	var col2 = tab.rows[0].cells[1].getElementsByTagName('a')[0].getAttribute("href");
	var col3 = tab.rows[0].cells[2].getElementsByTagName('a')[0].getAttribute("href");
	var col4 = tab.rows[0].cells[3].getElementsByTagName('a')[0].getAttribute("href");
	var col5 = tab.rows[0].cells[4].getElementsByTagName('a')[0].getAttribute("href");
	var col6 = tab.rows[0].cells[5].getElementsByTagName('a')[0].getAttribute("href");
	var col7 = tab.rows[0].cells[6].getElementsByTagName('a')[0].getAttribute("href");
	var col8 = tab.rows[0].cells[7].getElementsByTagName('a')[0].getAttribute("href");
	var col9 = tab.rows[0].cells[8].getElementsByTagName('a')[0].getAttribute("href");
	var col10= tab.rows[0].cells[9].getElementByTagName('a')[0].getAttribute("href");
	var col11= tab.rows[0].cells[10].getElementByTagName('a')[0].getAttribute("href");
	var col12= tab.rows[0].cells[11].getElementByTagName('a')[0].getAttribute("href");
	var col13= tab.rows[0].cells[12].getElementByTagName('a')[0].getAttribute("href");
	
	
	col1 = col1.concat('&&writNo=').concat(document.getElementById('selectCat').value).
	concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
	.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
			.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
					.concat('&&year=').concat(document.getElementById('selectCat1').value)
					   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
					   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
	
	col2 = col2.concat('&&writNo=').concat(document.getElementById('selectCat').value).
	concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
	.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
			.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
					.concat('&&year=').concat(document.getElementById('selectCat1').value)
					   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
					   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
	
	col3 = col3.concat('&&writNo=').concat(document.getElementById('selectCat').value).
	concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
	.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
			.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
					.concat('&&year=').concat(document.getElementById('selectCat1').value)
					   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
					   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
	
	col4 = col4.concat('&&writNo=').concat(document.getElementById('selectCat').value).
	concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
	.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
			.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
					.concat('&&year=').concat(document.getElementById('selectCat1').value)
					   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
					   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
	
	col5 = col5.concat('&&writNo=').concat(document.getElementById('selectCat').value).
	concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
	.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
			.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
					.concat('&&year=').concat(document.getElementById('selectCat1').value)
					   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
					   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
	
	col6 = col6.concat('&&writNo=').concat(document.getElementById('selectCat').value).
	concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
	.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
			.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
					.concat('&&year=').concat(document.getElementById('selectCat1').value)
					   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
					   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
	
	col7 = col7.concat('&&writNo=').concat(document.getElementById('selectCat').value).
	concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
	.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
			.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
					.concat('&&year=').concat(document.getElementById('selectCat1').value)
					   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
					   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
	
	col8 = col8.concat('&&writNo=').concat(document.getElementById('selectCat').value).
	concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
	.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
			.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
					.concat('&&year=').concat(document.getElementById('selectCat1').value)
					   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
					   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
	
	col9 = col9.concat('&&writNo=').concat(document.getElementById('selectCat').value).
	concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
	.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
			.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
					.concat('&&year=').concat(document.getElementById('selectCat1').value)
					   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
					   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
	
col10 = col10.concat('&&writNo=').concat(document.getElementById('selectCat').value).
concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
		.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
				.concat('&&year=').concat(document.getElementById('selectCat1').value)
				   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
				   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
				   
col11 = col11.concat('&&writNo=').concat(document.getElementById('selectCat').value).
concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
		.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
				.concat('&&year=').concat(document.getElementById('selectCat1').value)
				   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
				   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);

col12 = col12.concat('&&writNo=').concat(document.getElementById('selectCat').value).
concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
		.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
				.concat('&&year=').concat(document.getElementById('selectCat1').value)
				   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
				   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
				   
				   
col13 = col13.concat('&&writNo=').concat(document.getElementById('selectCat').value).
concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
		.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
				.concat('&&year=').concat(document.getElementById('selectCat1').value)
				   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
				   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);


	tab.rows[0].cells[0].getElementsByTagName('a')[0].setAttribute("href",col1);
	tab.rows[0].cells[1].getElementsByTagName('a')[0].setAttribute("href",col2);
	tab.rows[0].cells[2].getElementsByTagName('a')[0].setAttribute("href",col3);
	tab.rows[0].cells[3].getElementsByTagName('a')[0].setAttribute("href",col4);
	tab.rows[0].cells[4].getElementsByTagName('a')[0].setAttribute("href",col5);
	tab.rows[0].cells[5].getElementsByTagName('a')[0].setAttribute("href",col6);
	tab.rows[0].cells[6].getElementsByTagName('a')[0].setAttribute("href",col7);
	tab.rows[0].cells[7].getElementsByTagName('a')[0].setAttribute("href",col8);
	tab.rows[0].cells[8].getElementsByTagName('a')[0].setAttribute("href",col9);
    tab.rows[0].cells[9].getElementByTagName('a')[0].getAttribute("href",col10);
    tab.rows[0].cells[10].getElementByTagName('a')[0].getAttribute("href",col11);
    tab.rows[0].cells[11].getElementByTagName('a')[0].getAttribute("href",col12);
    tab.rows[0].cells[12].getElementByTagName('a')[0].getAttribute("href",col13);
	
}




</script>


<script type="text/javascript">
		
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
				
			 var data = document.getElementById(selectCat5);
		       $("#selectCat5").select2({
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
			
			 var data = document.getElementById(selectHearingDate);
		       $("#selectHearingDate").select2({
		    	   allowClear: true,
		    	   placeholderOption: function () { return 'Please select...';},
					  data: data	  
					 
					});
		});
		
		
		
		
		
$(document).ready(function() {
	var thArray = [];
	var tab = document.getElementById('tblCourtList');
	var col1 = tab.rows[0].cells[0].getElementsByTagName('a')[0].getAttribute("href");
	var col2 = tab.rows[0].cells[1].getElementsByTagName('a')[0].getAttribute("href");
	var col3 = tab.rows[0].cells[2].getElementsByTagName('a')[0].getAttribute("href");
	var col4 = tab.rows[0].cells[3].getElementsByTagName('a')[0].getAttribute("href");
	var col5 = tab.rows[0].cells[4].getElementsByTagName('a')[0].getAttribute("href");
	var col6 = tab.rows[0].cells[5].getElementsByTagName('a')[0].getAttribute("href");
	var col7 = tab.rows[0].cells[6].getElementsByTagName('a')[0].getAttribute("href");
	var col8 = tab.rows[0].cells[7].getElementsByTagName('a')[0].getAttribute("href");
	var col9 = tab.rows[0].cells[8].getElementsByTagName('a')[0].getAttribute("href");
	var col10 = tab.rows[0].cells[6].getElementsByTagName('a')[0].getAttribute("href");
	var col11 = tab.rows[0].cells[6].getElementsByTagName('a')[0].getAttribute("href");
	var col12 = tab.rows[0].cells[6].getElementsByTagName('a')[0].getAttribute("href");
	var col13 = tab.rows[0].cells[6].getElementsByTagName('a')[0].getAttribute("href");
	
	//alert(col1);
	col1 = col1.concat('&&writNo=').concat(document.getElementById('selectCat').value).
	concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
	.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
			.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
					.concat('&&year=').concat(document.getElementById('selectCat1').value)
					   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
					   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
	
	col2 = col2.concat('&&writNo=').concat(document.getElementById('selectCat').value).
	concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
	.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
			.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
					.concat('&&year=').concat(document.getElementById('selectCat1').value)
					   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
					   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
	
	col3 = col3.concat('&&writNo=').concat(document.getElementById('selectCat').value).
	concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
	.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
			.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
					.concat('&&year=').concat(document.getElementById('selectCat1').value)
					   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
					   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
	
	col4 = col4.concat('&&writNo=').concat(document.getElementById('selectCat').value).
	concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
	.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
			.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
					.concat('&&year=').concat(document.getElementById('selectCat1').value)
					   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
					   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
	
	col5 = col5.concat('&&writNo=').concat(document.getElementById('selectCat').value).
	concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
	.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
			.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
					.concat('&&year=').concat(document.getElementById('selectCat1').value)
					   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
					   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
	
	col6 = col6.concat('&&writNo=').concat(document.getElementById('selectCat').value).
	concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
	.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
			.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
					.concat('&&year=').concat(document.getElementById('selectCat1').value)
					   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
					   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
	
	col7 = col7.concat('&&writNo=').concat(document.getElementById('selectCat').value).
	concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
	.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
			.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
					.concat('&&year=').concat(document.getElementById('selectCat1').value)
					   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
					   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
	
	col8 = col8.concat('&&writNo=').concat(document.getElementById('selectCat').value).
	concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
	.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
			.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
					.concat('&&year=').concat(document.getElementById('selectCat1').value)
					   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
					   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
	
	col9 = col9.concat('&&writNo=').concat(document.getElementById('selectCat').value).
	concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
	.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
			.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
					.concat('&&year=').concat(document.getElementById('selectCat1').value)
					   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
					   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
	
col10 = col10.concat('&&writNo=').concat(document.getElementById('selectCat').value).
concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
		.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
				.concat('&&year=').concat(document.getElementById('selectCat1').value)
				   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
				   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
				   
				   
col11 = col11.concat('&&writNo=').concat(document.getElementById('selectCat').value).
concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
		.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
				.concat('&&year=').concat(document.getElementById('selectCat1').value)
				   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
				   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);


col12 = col12.concat('&&writNo=').concat(document.getElementById('selectCat').value).
concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
		.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
				.concat('&&year=').concat(document.getElementById('selectCat1').value)
				   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
				   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);
				   
col13 = col13.concat('&&writNo=').concat(document.getElementById('selectCat').value).
concat('&&caseStatus=').concat(document.getElementById('selectCat2').value)
.concat('&&petitionerName=').concat(document.getElementById('selectCat3').value)
		.concat('&&caseType=').concat(document.getElementById('selectCat4').value)
				.concat('&&year=').concat(document.getElementById('selectCat1').value)
				   .concat('&&aDvtNo=').concat(document.getElementById('selectCat5').value)
				   .concat('&&hearingDate=').concat(document.getElementById('selectHearingDate').value);				   


tab.rows[0].cells[0].getElementsByTagName('a')[0].setAttribute("href",col1);
tab.rows[0].cells[1].getElementsByTagName('a')[0].setAttribute("href",col2);
tab.rows[0].cells[2].getElementsByTagName('a')[0].setAttribute("href",col3);
tab.rows[0].cells[3].getElementsByTagName('a')[0].setAttribute("href",col4);
tab.rows[0].cells[4].getElementsByTagName('a')[0].setAttribute("href",col5);
tab.rows[0].cells[5].getElementsByTagName('a')[0].setAttribute("href",col6);
tab.rows[0].cells[6].getElementsByTagName('a')[0].setAttribute("href",col7);
tab.rows[0].cells[7].getElementsByTagName('a')[0].setAttribute("href",col8);
tab.rows[0].cells[8].getElementsByTagName('a')[0].setAttribute("href",col9);
tab.rows[0].cells[9].getElementsByTagName('a')[0].setAttribute("href",col10);
tab.rows[0].cells[10].getElementsByTagName('a')[0].setAttribute("href",col11);
tab.rows[0].cells[11].getElementsByTagName('a')[0].setAttribute("href",col12);
tab.rows[0].cells[12].getElementsByTagName('a')[0].setAttribute("href",col13);
		
			
});
		
</script>


</body>
</html>