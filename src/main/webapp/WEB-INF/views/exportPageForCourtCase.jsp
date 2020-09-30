<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="org.apache.commons.beanutils.*"%>
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
        <link rel="stylesheet" href="assets/css/displaytag.css" />
		<!-- page specific plugin styles -->
			<link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
		    <link rel="stylesheet" href="assets/css/chosen.min.css" />
            <link rel="stylesheet" href="assets/css/select2.min.css" />
		<!-- text fonts -->
		<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />


		<link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
		<script src="assets/js/jquery-2.1.4.min.js"></script>
		<script src="assets/js/ace-extra.min.js"></script>

 		<link href="assets/css/select2.min.css" rel="stylesheet" />
	</head>
<body style="background-color: white;">
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


			<div class="main-content">
				<div class="main-content-inner">
					

					<div class="page-content">

						<div class="row">
							<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
                                     
								<div class="row">
									<div class="col-xs-12">
										

										<div class="clearfix">
											<div class="pull-right tableTools-container"></div>
										</div>
<form method="post" id="exportForm">
<input type="hidden" id="pageNo" name="pageNo" />
 <input type="hidden" id="page" name="page" value="" /> 
<input type="hidden" id="pageSizeTotal" name="pageSizeTotal" value="${pageSizeTotal }" />
 <input type="hidden" id="action" name="action" value=""/> 
										 									  
  <display:table  id="dynamic-table" class="table table-striped table-bordered table-hover" excludedParams="*" name="allCourtCaseDataList"  
	  uid="tblCourtList" cellspacing="0"
	 requestURI="exportCourtCaseData?pageSizeTotal=${pageSizeTotal}&&writNo=${writNo}&&caseStatus=${caseStatus}&&caseIdForPName=${caseIdForPName}&&caseType=${caseType}&&year=${year}&&hearingDate=${hearingDate}" export="true" >
	<display:column property="uniqueCaseId" title="Unique Case Id"   ></display:column>
	<display:column property="policeDetailsObj.deptObj.dEpartment" title="Department Name"   ></display:column>
	<display:column   property="policeDetailsObj.aDvtNo" title="Advertisement Number" format="ADVT {0}"></display:column>
	<display:column   property="policeDetailsObj.nAmeOfPost" title="Name Of Post" ></display:column>
	 <display:column   property="policeDetailsObj.cAtNo" title="Cat No." ></display:column>
	<display:column   property="petitioners" title="Name of Petitioner" ></display:column>
	 <display:column   property="caseStatus" title="Status" ></display:column>
	 <display:column   property="dateList" title="Hearing Dates" ></display:column>
	<display:column   property="caseType" title="Type of Case" ></display:column>
	<display:column   property="writNo" title="Writ No." ></display:column>
	<display:column   property="year" title="Year" sortable="false"></display:column>
<%-- 	<display:column   property="diaryNo" title="Diary No" ></display:column> --%>
	<display:column   property="fileNo" title="File No" ></display:column>
	<display:column   property="caseIn" title="Case In" ></display:column>
	<display:column   property="concernedAssistant" title="Concerned Assistant" ></display:column>
	<display:column   property="legalIssue" title="Legal Issue" ></display:column>
	<display:column   property="otherLegalIssue" title="Other Legal Issue" ></display:column>
	<display:column   property="main_similarCase" title="Main/Similar Case" ></display:column>
<%-- 	<display:column   property="vettingDate" title="Vetting Date" ></display:column> --%>
    <display:column   property="replyFrom_Ag_Lr" title="Whether Reply Filed or Not" ></display:column>
	<display:column   property="stay" title="Stay" ></display:column>
	<display:column   property="priority" title="Priority" ></display:column>
	<display:column   property="detailedStatus" title="Detailed Status" ></display:column>
									   
<display:setProperty name="export.pdf" value="true"/>
<display:setProperty name="export.decorated" value="true" />
<display:setProperty name="export.pdf.filename" value="HsscCourtCase.pdf" /> 
<display:setProperty name="export.excel.filename" value="HsscCourtCase.xls"/>
<display:setProperty name="export.excel" value="true"/>
<display:setProperty name="export.csv" value="false" />
<display:setProperty name="export.xml" value="false" />
				
</display:table>
</form>	
</div>
								    </div>



								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->


			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->
		
<script src="assets/js/bootstrap.min.js"></script>
		<script type="text/javascript">
		$(function()
				  {
					
				  // Placement on top.#row is display tag id
				  $( ".exportlinks" ).insertBefore( "#tblCourtList" );
		
				});
		</script>	 		

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
