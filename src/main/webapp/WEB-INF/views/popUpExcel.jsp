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


			<div>
				<div >
					

					<div class="page-content">

						<div class="row">
							<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
                                     
								<div class="row">
									<div class="col-xs-12">
										

										<div class="clearfix">
											<div class="pull-right tableTools-container"></div>
											</div>

<div class="content">										
<form method="post" id="exportForm">
 
										 									  
 <input type="hidden" id="pageNo" name="pageNo" />
 <input type="hidden" id="page" name="page" value="" /> 
<input type="hidden" id="pageSizeTotal" name="pageSizeTotal" value="${pageSizeTotal }" />
 <input type="hidden" id="action" name="action" value=""/>
 <display:table   class="table table-striped table-bordered table-hover" excludedParams="*" 
 name="allHsscPostListForDept"   
 id="tblPostListExport" cellspacing="0" requestURI="exportContents?pageSizeTotal=${pageSizeTotal}&&nAmeOfPost=${nAmeOfPost}&&nExtStep=${nExtStep}&&aDvtNo=${aDvtNo}&&mAcroStatus=${mAcroStatus}&&dEpartmentId=${dEpartmentId}&&toformat=Excel"   export="true" defaultsort="1" sort="list" >

 <display:column property="deptObj.dEpartment" title="Department"  ></display:column>
 <display:column   property="aDvtNo" title="Advertisement Number" format="ADVT {0}"></display:column>
 <display:column   property="cAtNo" title="Category Number" ></display:column>
 <display:column   property="nAmeOfPost" title="Name Of Post" ></display:column>
 <display:column   property="nOOfPosts" title="No. Of Posts" ></display:column>
 <display:column   property="mAcroStatus" title="Macro Status" ></display:column>
 <display:column   property="nExtStep" title="Next Step" ></display:column>
 <display:column   property="cAndidatesRecommended" title="Candidates Recommended" ></display:column>
 <display:column   property="tOtalNoOfApplications" title="Total No Of Applications" ></display:column>
 <display:column   property="nOOfPeopleAttendingExam" title="No Of People Attending Exams" ></display:column>
 <display:column   property="advtPostedTrans" title="Advertisement Posted"  ></display:column>
 <display:column   property="appOpenTrans" title="Applications Open" ></display:column>
 <display:column   property="appCloseTrans" title="Applications Closed" ></display:column>
 <display:column   property="admitCardTrans" title="AdmitCards" ></display:column>
 <display:column   property="pstStartTrans" title="Pst Start" ></display:column>
 <display:column   property="pstEndTrans" title="Pst End" ></display:column>
 <display:column   property="resultOfPstTrans" title="Result Of Pst" ></display:column>
 <display:column   property="writtenExamTrans" title="Written Exam" ></display:column>
 <display:column   property="wRittenExamSession" title="Written Exam Session" ></display:column>
 <display:column   property="uploadingAnswerKeyTrans" title="Uploading AnswerKey" ></display:column>
 <display:column   property="objectionOpenTrans" title="Objections Open" ></display:column>
 <display:column   property="objectionCloseTrans" title="Objections Closed" ></display:column>
 <display:column   property="uploadedRevisedAnswerKeyTrans" title="Uploaded Revised Answer Key" ></display:column>
 <display:column   property="resultOfWrittenExamTrans" title="Result Of Written Exam" ></display:column>
 <display:column   property="scrutinyStartTrans" title="Scrutiny Start Date" ></display:column>
 <display:column   property="scrutinyEndTrans" title="Scrutiny End Date" ></display:column>
 <display:column   property="sCrutinyResultsTrans" title="Scrutiny Results" ></display:column>
 <display:column   property="pMtHeightChestTrans" title="PMT HeightChest" ></display:column>
 <display:column   property="rEsultOfPmtHeightChestTrans" title="Result Of Pmt HeightChest" ></display:column>
 <display:column   property="aDmitCardsForInterviewTrans" title="AdmitCards For Interview" ></display:column>
 <display:column   property="iNterviewsStartDateTrans" title="Interview Start Date" ></display:column>
 <display:column   property="iNterviewsEndDateTrans" title="Interview End Date" ></display:column>
 <display:column   property="aNnouncementOfFinalResultTrans" title="Annoucement Of Final Result" ></display:column>
 <display:column   property="rEcommendedDateTrans" title="Recommended Date" ></display:column>
 <display:column   property="dEtailedStatus" title="Detailed Status" ></display:column>
 								   
<display:setProperty name="export.pdf" value="false"/>
<display:setProperty name="export.decorated" value="true" />
<%-- <display:setProperty name="decorator.media.pdf" value="in.hkcl.displayProperties.ItextTotalWrapper"/>   --%>
<display:setProperty name="export.pdf.filename" value="HsscData.pdf" /> 
<display:setProperty name="export.excel.filename" value="HsscData.xls"/>
<display:setProperty name="export.excel" value="true"/>
<display:setProperty name="export.csv" value="false" />
<display:setProperty name="export.xml" value="false" />
				
</display:table>
</form>	
</div>
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
				  $( ".exportlinks" ).insertBefore( "#tblPostListExport" );
		
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
