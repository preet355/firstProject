
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
					<li class="active">
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
					<li>
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
					
					<c:set var="var" value="${module}"/>
					     <c:choose>
					    <c:when test="${var=='mis' && (user.idRole=='2' || user.idRole=='3')}">
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
						<%-- <li class=""><a href="<c:url value="javascript:validateCount()"/>">

								<i class="menu-icon fa fa-check-square"></i> <span
								class="menu-text">Validate Bifurcation</span>

						</a></li> --%>
							</c:when>
						</c:choose>
					<li class="">
					<c:set var="var" value="${module}"/>
					<c:choose>
					<c:when test="${var=='cc'}">
					  <a href="<c:url value="courtCaseSearch"/>">
						
							<i class="menu-icon fa fa-fw fa-bank"></i>
							<span class="menu-text"> Search Court Case</span>

						</a>
					</c:when>
					</c:choose>
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
								Department
							</li>

							<li>
							 <c:choose>
      		                          <c:when test="${user.isAdmin=='Y'}"> 
      		                          All Departments
      		                          </c:when></c:choose>
      		                          <c:choose>
      		                           <c:when test="${user.isAdmin=='N'}">
								${deptInfo}
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
										  <form:form method="post" id="postListForm" action="allHSSCPostname">
										  <%-- <input type="hidden" id="aDvtNo" name="aDvtNo" value="${aDvtNo }"/>
										  <input type="hidden" id="mAcroStatus" name="mAcroStatus" value="${mAcroStatus }"/>
										  <input type="hidden" id="nExtStep" name="nExtStep" value="${nExtStep }"/>
									 	  <input type="hidden" id="dEpartmentId" name="dEpartmentId" value="${dEpartmentId }"/>	
									 	  <input type="hidden" id="nAmeOfPost" name="nAmeOfPost" value="${nAmeOfPost }"/> --%>

 										<input type="hidden" id="srNo" name="srNo" />  
										  <input type="hidden" id="pageNo" name="pageNo" />
										  <input type="hidden" id="pagination" name="pagination" />
     							     	  <input type="hidden" id="page" name="page" value="" /> 
     							     	  <input type="hidden" id="sort" name="sort" value="${sort}" />  
     							     	  <input type="hidden" id="sortDirection" name="sortDirection" value="${sortDirection}" /> 
     							     	  <input type="hidden" id="pageSizeTotal" name="pageSizeTotal" value="${pageSizeTotal }" />
     							     	  <input type="hidden" id="actionString" name="actionString" value=""/>
     							     	  <input type="hidden" id="toformat" name="toformat" />
     							     	  <input type="hidden" id="writNo" name="writNo"/>
     							     	  
     							     	  
										 
										   
     							     	  
     							     	  
                                        <div class="searchContainer">
                                             <div class="searchBoxes">
                                             <c:choose>
      		                                 <c:when test="${user.isAdmin=='Y'}"> 
                                             <select name="dEpartmentId" class="formControl" id="selectCat3" style="width:200px;" onChange="javascript:test()" data-placeholder="Search Department...">
											   <option value="0">Search Department...</option>
											  <c:forEach items="${deptList}" var="tag3" varStatus="loop">
					                          <option value="${tag3.dEpartmentId}" 
					                          <c:set var="var" value="${dEpartmentId}"/><c:choose>
					                           <c:when test="${tag3.dEpartmentId==var}">
					                           selected
					                           </c:when>
					                          </c:choose>>${tag3.dEpartment}</option>	
					                          </c:forEach>
											 </select>
											 </c:when>
											 </c:choose>
											 <select name="nAmeOfPost" class="formControl" id="selectCat" style="width:200px;" data-placeholder="Search Post Name...">
											    <option>Search Post Name...</option>
											  <c:forEach items="${allDistinctPostName}" var="tag" varStatus="loop">
					                          <option value="${tag.nAmeOfPost}" 
					                          <c:set var="var" value="${nAmeOfPost}"/><c:choose>
					                           <c:when test="${tag.nAmeOfPost==var}">
					                           selected
					                           </c:when>
					                          </c:choose>
					                          >${tag.nAmeOfPost}</option>	
					                          </c:forEach>
											 </select> 
									    
									    <select name="aDvtNo" class="formControl" id="selectCat1" style="width:200px;" onChange="javascript:test()" data-placeholder="Search Advertisement Number...">
											   <option>Search Advertisement Number...</option>
											  <c:forEach items="${allHsscPostListForADVTNOForSearch}" var="tag2" varStatus="loop">
					                          <option value="${tag2}" 
					                          <c:set var="var" value="${aDvtNo}"/><c:choose>
					                           <c:when test="${tag2==var}">
					                           selected
					                           </c:when>
					                          </c:choose>
					                          >${tag2}</option>	
					                          </c:forEach>
											 </select>
											 
										   <c:set var="var" value="${module}"/>
										   <c:choose>
      		              				 <c:when test="${var=='mis'}">
      		              				    <select name="mAcroStatus" class="formControl" id="selectCat2" style="width:200px;" onChange="javascript:test()" data-placeholder="Search Macro Status...">
      		              				       <option>Search Macro Status...</option>
      		              				      
      		              				       <option  <c:set var="var" value="${mAcroStatus}"/> <c:choose>
					                           <c:when test="${'Recommended'==var}">
					                           selected
					                           </c:when>
					                          </c:choose>>Recommended</option>
      		              				      
      		              				      <option <c:choose>
					                           <c:when test="${'Court Stay'==var}">
					                           selected
					                           </c:when>
					                          </c:choose>>Court Stay </option>
							                   <option 
							                   <c:choose>
					                           <c:when test="${'In Process'==var}">
					                           selected
					                           </c:when>
					                          </c:choose>>In Process </option>
					                          
					                           <option 
							                   <c:choose>
					                           <c:when test="${'Withdrawn'==var}">
					                           selected
					                           </c:when>
					                          </c:choose>>Withdrawn</option>
      		              				    </select>
      		              				    
      		              				    <select name="nExtStep" class="formControl" id="selectCat4"] style="width:200px;" 
											  onChange="javascript:test()" data-placeholder="Search Next Step...">
											   <option>Search Next Step...</option>
											  <c:forEach items="${allHsscNextStepList}" var="tag4"  varStatus="loop">
					                          <option value="${tag4}" 
					                           <c:set var="var" value="${nExtStep}"/><c:choose>
					                           <c:when test="${tag4==var}">
					                           selected
					                           </c:when>
					                          </c:choose>
					                          >${tag4}</option>	
					                          </c:forEach>
											 </select>
      		              				 </c:when>
										</c:choose>	 
									    </div>
									    <a class="btn btn-sm btn-warning" href="javascript:searchPostDetails();" >Search</a> 
										 </div>
										   
                        			 	 	
<%--                                        <c:forEach items="${allHsscPostListForDept.writNoList}" var="tag6"  varStatus="loop"></c:forEach> --%>
									  <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline no-footer">
									 <display:table  id="dynamic-table" class="table table-striped table-bordered table-hover" excludedParams="*" 
									  requestURI="" name="allHsscPostListForDept"  
									   pagesize="${pageSize}" uid="tblPostList" cellspacing="0" >
									    
									    <display:column property="deptObj.dEpartment" title="Department"  sortable="true" ></display:column>
									    <display:column   property="aDvtNo" title="Advertisement Number" sortable="true"></display:column>
									    <display:column   property="cAtNo" title="Category Number" sortable="true"></display:column>
									    <display:column   property="nAmeOfPost" title="Name Of Post" sortable="true"></display:column>
									     <c:set var="var" value="${module}"/>
                        			 	 <c:choose>
      		              				 <c:when test="${var=='mis'}">
									    <display:column   property="nOOfPosts" title="No. Of Posts" sortable="true"></display:column>
									    <display:column   property="mAcroStatus" title="Macro Status" sortable="true"></display:column>
									     <display:column   property="currentStep" title="Current Step" sortable="true"></display:column>  
									     <display:column   property="nExtStep" title="Next Step" sortable="true"></display:column> 
									     <display:column   property="advtpostDates" title="Advertisement Posted Date" sortable="true"></display:column>  
									      <c:choose>
									        <c:when test="${var=='mis' && (user.idRole=='2' || user.idRole=='3')}">
									        <display:column  title="Case No" sortable="false">
									          <c:forEach items="${tblPostList.writNo}" var="tag4"  varStatus="loop">
									          <a href="javascript:searchCourtCase('${tag4}');" >${tag4}</a>
									          </c:forEach>
									        </display:column> 
									     </c:when>   
									     <c:otherwise>
									         <display:column   property="writNo" title="Case No" sortable="false"></display:column> 
									     </c:otherwise>
									     </c:choose>			     
									     </c:when></c:choose>	
									 <c:choose>
      		                          <c:when test="${user.idRole!='3'}">  						  
										 <display:column > 
										 
										 <c:set var="var" value="${module}"/>
	                        			 	 <c:choose>
	      		              				 <c:when test="${var=='mis'}">
										 
										  <c:choose>
	      		                          <c:when test="${user.isAdmin=='Y' && user.idRole=='1' || user.idRole=='2'}">     
										 &nbsp&nbsp  <a  href="javascript:editDetails('${tblPostList.sRNo}');" title="Edit Details"> <i class="ace-icon fa fa-pencil bigger-120"></i></a> &nbsp; 
										  </c:when>
										  </c:choose>
										   &nbsp <a  href="javascript:viewDetails('${tblPostList.sRNo}');" title="View Details"><img  src="resources/photos/show.png"  /> </a> &nbsp; 
										</c:when></c:choose>	
										<c:choose>
										<c:when test="${var=='cc'}">
										<a  class="modelButton" href="javascript:addCourtCaseDetails('${tblPostList.sRNo}');" title="Court Case"><i class="fa fa-fw fa-bank"></i>Court Case </a>
										</c:when>
										</c:choose> 
										</display:column>
									 </c:when>
									</c:choose>
									<c:set var="var" value="${module}"/>
									     <c:choose>
									    <c:when test="${var=='mis' && user.idRole=='2'}">
									    <display:column title="Add New Case">
										<a class="modelButton" href="javascript:addCourtCaseDetails('${tblPostList.sRNo}');" title="Court Case"><i class="fa fa-fw fa-bank" ></i></a>							    
									   </display:column> 
									    </c:when>
									   </c:choose>
										 
										   
									   </display:table>
									   
										 </div>	
										  <label style="margin-right: 15px; margin-left: -50PX;">
									   	    <b>Total Posts</b> : ${totalNoOfPosts}
										 </label>
										 <c:set var="var" value="${module}"/>
                        			 	 <c:choose>
      		              				 <c:when test="${var=='mis' && user.idRole!='3'}">
										 <c:choose>
      		                             <c:when test="${user.isAdmin=='Y' && user.idRole=='1' || user.idRole=='2'}">     
										 <a class="btn btn-sm btn-warning" href="addNewAdvertisement">Add Advertisement</a>
										 </c:when>
										 </c:choose>
										<a href="javascript:exportPage('${pageSizeTotal }','${nAmeOfPost}','${nExtStep}','${aDvtNo}','${mAcroStatus}','${dEpartmentId}')"  class="btn btn-sm btn-warning" >
										Export Pdf
										</a>
										<a href="javascript:exportPageToExcel('${pageSizeTotal }','${nAmeOfPost}','${nExtStep}','${aDvtNo}','${mAcroStatus}','${dEpartmentId}')" class="btn btn-sm btn-warning" >
										
									Export Excel
								</a>
<%-- 								     <a href="<c:url value ="/httpReferrer"/>" class="btn btn-sm btn-warning" > Http Referrer</a>   --%>
								</c:when></c:choose>
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
									
		
<script>
    
   function viewDetails(srNo){
	   document.getElementById('srNo').value=srNo;
	   document.getElementById('postListForm').action="showPostDetails";
	   document.getElementById('postListForm').submit();
      // window.location.href='/TelephoneDirectoryApi/showDept?idDepartment='+idDepartment
   }
   function editDetails(srNo){
	   document.getElementById('srNo').value=srNo;
	   document.getElementById('postListForm').action="showPostDetailsForAdmin";
	   document.getElementById('postListForm').submit();
      // window.location.href='/TelephoneDirectoryApi/showDept?idDepartment='+idDepartment
   }
   
   function addCourtCaseDetails(srNo){
	   document.getElementById('srNo').value=srNo;
	   document.getElementById('postListForm').action="addCourtCase"; 	
	   document.getElementById('postListForm').submit();
    
   }
   
   function searchCourtCase(writNo){
	   document.getElementById('writNo').value=writNo;
	   document.getElementById('postListForm').action="courtCaseSearch"; 	
	   document.getElementById('postListForm').submit();
	   
   }
   
   
   function exportPage(pageSizeTotal,postName,nextStep, advNo, macroStatus, depId ){
	   document.getElementById('toformat').value='Pdf';
	   document.getElementById('postListForm').action="exportContents?pageSizeTotal="+pageSizeTotal+"&&nAmeOfPost="+postName+"&&nExtStep="+nextStep+"&&aDvtNo="+advNo
		   +"&&mAcroStatus="+macroStatus+"&&dEpartmentId="+depId;
    	document.getElementById('postListForm').target='print_popup';
    	document.getElementById('postListForm').onsubmit = window.open("about:blank","print_popup", "width=1000,height=600");
    	document.getElementById('postListForm').submit();
	}
   
   function exportPageToExcel(pageSizeTotal,postName,nextStep, advNo, macroStatus, depId ){
	   document.getElementById('toformat').value='Excel';
	   document.getElementById('postListForm').action="exportContents?pageSizeTotal="+pageSizeTotal+"&&nAmeOfPost="+postName+"&&nExtStep="+nextStep+"&&aDvtNo="+advNo
		   +"&&mAcroStatus="+macroStatus+"&&dEpartmentId="+depId;
    	document.getElementById('postListForm').target='print_popup';  	
    	document.getElementById('postListForm').onsubmit = window.open("about:blank","print_popup", "width=1000,height=600");
    	document.getElementById('postListForm').submit();
	}
   
   
   
   function searchPostDetails(){   
	   //document.getElementById('sort').value='';
	   //document.getElementById('action').value='allHSSCPostname';
	    document.getElementById('postListForm').action='allHSSCPostname';
	    document.getElementById('postListForm').target='';
	    document.getElementById('postListForm').onsubmit = '';
           document.getElementById('postListForm').submit();
       
      
   } 

   function goToPage(pageNo){
		//clicker();
		//var formName = document.getElementsByTagName('form')[0].id;
		document.getElementById('page').value=pageNo;
		document.getElementById('pagination').value="yes";
	    document.getElementById('postListForm').action='allHSSCPostname';
	    document.getElementById('postListForm').target='';
	    document.getElementById('postListForm').onsubmit = '';
		
		document.getElementsByTagName('form')[0].submit();
	}

	function nextPrev(pageNo){
		//clicker();
		pageNumber = pageNo.substring(pageNo.lastIndexOf('=')+1);
		document.getElementById('page').value=pageNumber;
		document.getElementById('pagination').value="yes";
	    document.getElementById('postListForm').action='allHSSCPostname';
	    document.getElementById('postListForm').target='';
	    document.getElementById('postListForm').onsubmit = '';
		
		//var formName = document.getElementsByTagName('form')[3].id;
		document.getElementsByTagName('form')[0].submit();
	}
	
	function validateCount(){
		document.getElementById('postListForm').target='Validate Requisitions';	
		document.getElementById('postListForm').onsubmit = window.open("about:blank","Validate Requisitions", "width=1000,height=600");
		document.getElementById('postListForm').action = "readOnlyReq";
		document.getElementById('postListForm').submit();
		}
	
function test(){
	
	var thArray = [];
	var tab = document.getElementById('tblPostList');
	var col1 = tab.rows[0].cells[0].getElementsByTagName('a')[0].getAttribute("href");
	var col2 = tab.rows[0].cells[1].getElementsByTagName('a')[0].getAttribute("href");
	var col3 = tab.rows[0].cells[2].getElementsByTagName('a')[0].getAttribute("href");
	var col4 = tab.rows[0].cells[3].getElementsByTagName('a')[0].getAttribute("href");
	var col5 = tab.rows[0].cells[4].getElementsByTagName('a')[0].getAttribute("href");
	var col6 = tab.rows[0].cells[5].getElementsByTagName('a')[0].getAttribute("href");
	var col7 = tab.rows[0].cells[6].getElementsByTagName('a')[0].getAttribute("href");
	var col8 = tab.rows[0].cells[7].getElementsByTagName('a')[0].getAttribute("href");
	var col9 = tab.rows[0].cells[8].getElementsByTagName('a')[0].getAttribute("href");
	
	//alert(col1);
	col1 = col1.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	col2 = col2.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	col3 = col3.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	col4 = col4.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	col5 = col5.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	col6 = col6.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	col7 = col7.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	
	col8 = col8.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	
	col9 = col9.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);


	tab.rows[0].cells[0].getElementsByTagName('a')[0].setAttribute("href",col1);
	tab.rows[0].cells[1].getElementsByTagName('a')[0].setAttribute("href",col2);
	tab.rows[0].cells[2].getElementsByTagName('a')[0].setAttribute("href",col3);
	tab.rows[0].cells[3].getElementsByTagName('a')[0].setAttribute("href",col4);
	tab.rows[0].cells[4].getElementsByTagName('a')[0].setAttribute("href",col5);
	tab.rows[0].cells[5].getElementsByTagName('a')[0].setAttribute("href",col6);
	tab.rows[0].cells[6].getElementsByTagName('a')[0].setAttribute("href",col7);
	tab.rows[0].cells[7].getElementsByTagName('a')[0].setAttribute("href",col8);
	tab.rows[0].cells[8].getElementsByTagName('a')[0].setAttribute("href",col9);
}


  </script>
 
 
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
		  data: data,
		  placeholderOption: function () { return 'Please select...';}
		});
});

<c:set var="var" value="${module}"/>
	 <c:choose>
	 <c:when test="${var=='mis'}">
$(document).ready(function() {
var data = document.getElementById(selectCat2);
   $("#selectCat2").select2({
	   allowClear: true,
		  data: data,
		  placeholderOption: function () { return 'Please select...';}
		});
});

$(document).ready(function() {
var data = document.getElementById(selectCat4);
   $("#selectCat4").select2({
	   allowClear: true,
		  data: data,
		  placeholderOption: function () { return 'Please select...';}
		});
});
</c:when></c:choose>


if(document.getElementById('selectCat3')!=null){ 
$(document).ready(function() {
var data = document.getElementById(selectCat3);
   $("#selectCat3").select2({
	   allowClear: true,
		  data: data,
		  placeholderOption: function () { return "choose..";}
		});
});
}

$(document).ready(function() {
	var thArray = [];
	var tab = document.getElementById('tblPostList');
	var col1 = tab.rows[0].cells[0].getElementsByTagName('a')[0].getAttribute("href");
	var col2 = tab.rows[0].cells[1].getElementsByTagName('a')[0].getAttribute("href");
	var col3 = tab.rows[0].cells[2].getElementsByTagName('a')[0].getAttribute("href");
	var col4 = tab.rows[0].cells[3].getElementsByTagName('a')[0].getAttribute("href");
	var col5 = tab.rows[0].cells[4].getElementsByTagName('a')[0].getAttribute("href");
	var col6 = tab.rows[0].cells[5].getElementsByTagName('a')[0].getAttribute("href");
	var col7 = tab.rows[0].cells[6].getElementsByTagName('a')[0].getAttribute("href");
	var col8 = tab.rows[0].cells[7].getElementsByTagName('a')[0].getAttribute("href");
	var col9 = tab.rows[0].cells[8].getElementsByTagName('a')[0].getAttribute("href");
	
	//alert(col1);
	col1 = col1.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	col2 = col2.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	col3 = col3.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	col4 = col4.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	col5 = col5.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	col6 = col6.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	col7 = col7.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	
	col8 = col8.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);
	
	col9 = col9.concat('&&nAmeOfPost=').concat(document.getElementById('selectCat').value).
	concat('&&nExtStep=').concat(document.getElementById('selectCat4').value)
			.concat('&&aDvtNo=').concat(document.getElementById('selectCat1').value)
					.concat('&&mAcroStatus=').concat(document.getElementById('selectCat2').value)
							.concat('&&dEpartmentId=').concat(document.getElementById('selectCat3').value);

	tab.rows[0].cells[0].getElementsByTagName('a')[0].setAttribute("href",col1);
	tab.rows[0].cells[1].getElementsByTagName('a')[0].setAttribute("href",col2);
	tab.rows[0].cells[2].getElementsByTagName('a')[0].setAttribute("href",col3);
	tab.rows[0].cells[3].getElementsByTagName('a')[0].setAttribute("href",col4);
	tab.rows[0].cells[4].getElementsByTagName('a')[0].setAttribute("href",col5);
	tab.rows[0].cells[5].getElementsByTagName('a')[0].setAttribute("href",col6);
    tab.rows[0].cells[6].getElementsByTagName('a')[0].setAttribute("href",col7);
	tab.rows[0].cells[7].getElementsByTagName('a')[0].setAttribute("href",col8);
	tab.rows[0].cells[8].getElementsByTagName('a')[0].setAttribute("href",col9);});

</script>
	</body>
</html>
