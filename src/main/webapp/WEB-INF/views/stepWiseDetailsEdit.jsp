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
		<link rel="stylesheet" href="assets/css/jquery-ui.min.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-datepicker3.min.css" />
			
			<link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
		    <link rel="stylesheet" href="assets/css/chosen.min.css" />
            <link rel="stylesheet" href="assets/css/select2.min.css" /> 
            
            <link rel="stylesheet" href="assets/css/ui.theme.css" />
		    <link rel="stylesheet" href="assets/css/jquery-ui2.css" />
		    
		    
		    <link rel="stylesheet" href="assets/css/ui.jqgrid.min.css" /> 
            
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
									<div class="alert alert-block alert-success">
											<button type="button" class="close" data-dismiss="alert">
												<i class="ace-icon fa fa-times"></i>
											</button>
											<strong class="green">
											    <c:set var="var" value="${postDetailsList[0].sRNo}"/>
												    <c:choose>
										              <c:when test="${var==null}"> 
												          Add New Requisition
												      </c:when>
												      <c:otherwise>
												         Edit Requisition
												      </c:otherwise>
												    </c:choose>
												    
										    </strong>
										 <div class="space-4"></div>
										     ${success}
										     
										     <p style="color:red;">${failed}</p>
										</div>
										
								<!-- PAGE CONTENT BEGINS -->

								<div class="hr hr-18 hr-double dotted"></div>

								<div class="widget-box">
									<div class="widget-header widget-header-blue widget-header-flat">
										<h4 class="widget-title lighter">Advertisement Details</h4>
										<span id="Error7"></span>
										
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
<form:form name="postForm" id="editDetailsForm" method="post"  action="updatePostDetails" commandName="policeObj">
<input type="hidden" name="dEpartmentId" id="dEpartmentId" value="${postDetailsList[0].dEpartmentId}"/>
<input type="hidden" name="sRNo" id="sRNo" value="${postDetailsList[0].sRNo}"/>
<%-- <input type="hidden" name="currentStep" id="currentStep" value="${postDetailsList[0].currentStep}"/> --%>

												<div class="step-content pos-rel">
													<div class="step-pane active" data-step="1">
														 <table id="postDetailstbl" class="table  table-bordered table-hover">
									          												
		<tr>
		
		<th class="blue">Name of Department</th>
		
		<td>  <select name="department" style="width:250px" class="formControl" id="selectDepart" data-placeholder="Select Department..."> 
		 <option value=""></option>
		 <c:forEach items="${deptList}" var="tag3" varStatus="loop">
		 <option value="${tag3.dEpartmentId}"
		 
		 <c:set var="var" value="${dEpartmentIdDropDown}"/><c:choose>
					                           <c:when test="${tag3.dEpartmentId==var}">
					                           selected
					                           </c:when>
					                          </c:choose>
		 >${tag3.dEpartment}</option>	
		 </c:forEach>
		</select>
		<input type="hidden" name="dEpartmentId" id="dEpartmentId" value="${tag3.dEpartmentId}" />
		<span id="Error"></span>
		  <c:set var="var" value="${postDetailsList[0].sRNo}"/>
		    <c:choose>
              <c:when test="${var==null}"> 
		         <a class="modelButton" href="#modal-form" role="button" class="blue" data-toggle="modal">Add New Department</a>
		      </c:when>
		    </c:choose>
		</td>
		</tr>
		<tr>
		<th class="blue">Name of Post</th>
		<td><input type="text" name="nAmeOfPost" value="${postDetailsList[0].nAmeOfPost}" onKeypress="return ischarKey(event,'Joining','nxtstep')">
		<span id="Error1"></span>
		</td>
		</tr>
		<tr>
		<th class="blue">Advt. No.</th>
		<td><input type="text" name="aDvtNo" value="${postDetailsList[0].aDvtNo}" onKeypress="return ischarKey(event,'Advertisement Posted','nxtstep','more_fields')">

		<span id="Error2"></span>
		    <c:if test="${postDetailsList[0].aDvtNo!=null}">
				             <style>
				       		      #more_fields{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
		</td>													
	    </tr>
	    
	    
		<tr>
		<th class="blue">Cat. No.</th>
		<td><input type="text" name="cAtNo" value="${postDetailsList[0].cAtNo}" onkeypress="return isNumberKey(event,'characters not allowed','Error3')">
		<span id="Error3"></span>
		</td>
		</tr>
		<tr>
		<th class="blue">No. of Posts</th>
		<td><input type="text" name="nOOfPosts" value="${postDetailsList[0].nOOfPosts}" onkeypress="return isNumberKey(event,'characters not allowed','Error4')">
		<span id="Error4"></span>
		</td>
		</tr>
		<tr>
        <th class="blue">Macro Status</th>
												<td><select name="mAcroStatus" class="formControl" id="selectStatus" data-placeholder="Select Status...">
													<option value=""></option>
											   <option <c:set var="var" value="${mAcroStatus}"/><c:choose>
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
					                          </c:choose>>In Process 
					                          </option>
					                           <option 
							                   <c:choose>
					                           <c:when test="${'Withdrawn'==var}">
					                           selected
					                           </c:when>
					                          </c:choose>>Withdrawn 
					                          </option>
					                          <option 
							                   <c:choose>
					                           <c:when test="${'Process Halted'==var}">
					                           selected
					                           </c:when>
					                          </c:choose>>Process Halted 
					                          </option>
					                          </select>
					                          </td>
		</tr>
											
											
		
	</table>
	</div>

								<div class="step-pane" data-step="2">
								<table id="postDetailstbl" class="table  table-bordered table-hover">
				<!-- <tr>
				  <td>
				     <input type="text"  id="advtPostedDate">
				     <input type="text" id="applicationOpenDate" >
				  </td>
				</tr> -->
				<tr>
		<th class="blue">Current Status</th>
		<td>
<%-- 	     <span>${postDetailsList[0].currentStep}</span> --%>
	     <select name="currentStep" style="width:250px" class="formControl" id="selectCurrStatus" data-placeholder="Select Current Status..."> 
		 <option value=""></option>
		 <c:forEach items="${allNextSteps}" var="tag3" varStatus="loop">
		 <option value="${tag3.nextStep}"
		 
		 <c:set var="var" value="${postDetailsList[0].currentStep}"/><c:choose>
					                           <c:when test="${tag3.nextStep==var}">
					                           selected
					                           </c:when>
					                          </c:choose>
		 >${tag3.nextStep}</option>	
		 </c:forEach>
		</select>
		</td>
		</tr>
		<tr>
		<th class="blue">Next Step</th>
		<td>
	    <%--  <span id="nxtstep">${postDetailsList[0].nExtStep}</span>
	    <input type="hidden" id="nExtStepvalue" name="nExtStep" value="${postDetailsList[0].nExtStep}"> --%>
	    <select name="nExtStep" style="width:250px" class="formControl" id="selectNextStep" data-placeholder="Select Next Step..."> 
		 <option value=""></option>
		 <c:forEach items="${allNextSteps}" var="tag3" varStatus="loop">
		 <option value="${tag3.nextStep}"
		 
		 <c:set var="var" value="${postDetailsList[0].nExtStep}"/><c:choose>
					                           <c:when test="${tag3.nextStep==var}">
					                           selected
					                           </c:when>
					                          </c:choose>
		 >${tag3.nextStep}</option>	
		 </c:forEach>
		</select>
		</td>
		</tr>
		<tr>
		<th class="blue">Total No. Of Applications</th>
		<td><input type="text" name="tOtalNoOfApplications" value="${postDetailsList[0].tOtalNoOfApplications}" onkeypress="return isNumberKey(event,'characters not allowed','Error6')">
		<span id="Error6"></span>
		</td>
		</tr>
		<%-- <tr>
		<th class="blue">No. Of People Attending Exam</th>
		<td><input type="text" name="nOOfPeopleAttendingExam" value="${postDetailsList[0].nOOfPeopleAttendingExam}" onkeypress="return isNumberKey(event,'characters not allowed','Error8')">
		<span id="Error8"></span>
		</td>										
		</tr> --%>	
							
				<tr>
				<th class="blue">Advertisement Posted</th>
				<td>
				<table id="advertisementPosted">
				<tr><td style="display:inline-block;"><a  id="more_fields" class="nofreeze" href="javascript:add_fields('advtPostedDateList','advertisementPosted','Applications Open','nxtstep','${advtPostedMin}','more_fields2');"  /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
				&nbsp<a id="more_fields" href="javascript:deleteRow('advertisementPosted');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
				</td></tr>
				<c:forEach items="${postDetailsList[0].advtPostedDateList}" var="tag" varStatus="loop">  
				        <c:if test="${tag.advertisementPosted!=null}">
				             <style>
				                  #more_fields{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				       		      #more_fields2{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if>  
				<tr>													
				<td><INPUT type="checkbox" name="chk"/></td>
				<td>												
				<input type="date" name="advtPostedDateList[${loop.index}].advertisementPosted" value="${tag.advertisementPosted}" min="${advtPostedMin}">
				</td>
				<td><input type="text" name="advtPostedDateList[${loop.index}].comments"  value="${tag.comments}"/>
				<input type="hidden" name="advtPostedDateList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>										
				</tr>
				</c:forEach></table>	
				</td>
				</tr>
													
													
													
				<tr>
				<th class="blue">Applications Open</th>
				<td>
				<table id="applicationopen">
				<tr>
				<td style="display:inline-block;"><a  id="more_fields2" class="nofreeze"  href="javascript:add_fields('applicationOpenList','applicationopen','Applications Close','nxtstep','${applicationOpenMin}','more_fields3');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
				&nbsp<a id="more_fields" href="javascript:deleteRow('applicationopen');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
				</td></tr>
				<c:forEach items="${postDetailsList[0].applicationOpenList}" var="tag" varStatus="loop">
				    <c:if test="${tag.applicationopen!=null}">
				             <style>
				       		      #more_fields3{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
				<tr>			
				<td><INPUT type="checkbox" name="chk"/></td>
				<td>												
				<input type="date" name="applicationOpenList[${loop.index}].applicationopen" value="${tag.applicationopen}" min="${applicationOpenMin}">
				</td>
				<td><input type="text" name="applicationOpenList[${loop.index}].comments" value="${tag.comments}"/>
				<input type="hidden" name="applicationOpenList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td></td>
				</tr>
				</c:forEach>
				</table>
				</td>
				</tr>
													
													
													
													
			<tr>
			<th class="blue">Applications Close</th>
			<td>
			<table id="applicationclosed">
			<tr><td style="display:inline-block;"><a  id="more_fields3" class="nofreeze" href="javascript:add_fields('applicationClosedList','applicationclosed','Admit Cards','nxtstep','${applicationClosedMin}','more_fields4');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('applicationclosed');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
				</td></tr>
	
			<c:forEach items="${postDetailsList[0].applicationClosedList}" var="tag" varStatus="loop">
			<c:if test="${tag.applicationclosed!=null}">
				             <style>
				       		      #more_fields4{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<td>												
			<input type="date" name="applicationClosedList[${loop.index}].applicationclosed" value="${tag.applicationclosed}" min="${applicationClosedMin}">
			</td><td>	<input type="text" name="applicationClosedList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="applicationClosedList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
			</tr>
			</c:forEach>
			</table>
			</td>
			</tr>
												
			<tr>
			<th class="blue">Admit Cards</th>
			<td>
			<table id="admitcard">
			<tr>
			<td style="display:inline-block;"><a  id="more_fields4" class="nofreeze" href="javascript:add_fields('admitCardsList','admitcard','PST Start(For Police only)','nxtstep','${admitCardMin}','more_fields5');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('admitcard');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
			</td></tr>
			<c:forEach items="${postDetailsList[0].admitCardsList}" var="tag" varStatus="loop">
			     <c:if test="${tag.admitcard!=null}">
				             <style>
				       		      #more_fields5{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<td>												
			<input type="date" name="admitCardsList[${loop.index}].admitcard" value="${tag.admitcard}" min="${admitCardMin}">
			</td><td><input type="text" name="admitCardsList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="admitCardsList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
			</tr>
			</c:forEach>
			</table>
			</td>
			</tr>
												
			<c:choose>
			 <c:when test="${postDetailsList[0].dEpartmentId=='48' || postDetailsList[0].dEpartmentId=='49' || postDetailsList[0].dEpartmentId=='73'}">
			<tr>
			<th class="blue">PST Start (For Police only)</th>
			<td>
			<table id="pststart">
			<tr>
			<td style="display:inline-block;"><a  id="more_fields5" class="nofreeze" href="javascript:add_fields('pstStartList','pststart','PST End(For Police only)','nxtstep','${pststartMin}','more_fields6');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('pststart');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
			</td></tr>
			<c:forEach items="${postDetailsList[0].pstStartList}" var="tag" varStatus="loop">
			      <c:if test="${tag.pststart!=null}">
				             <style>
				       		      #more_fields6{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<th>												
			<input type="date" name="pstStartList[${loop.index}].pststart" value="${tag.pststart}" min="${pststartMin}">
			</th><td>	<input type="text" name="pstStartList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="pstStartList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
			</tr>
			</c:forEach>
			</table>
			</td>
			</tr>
													
													
													
			<tr>
			<th class="blue">PST End (For Police only)</th>
			<td>
			<table id="pstend">
			<tr>
			<td style="display:inline-block;"><a  id="more_fields6" class="nofreeze" href="javascript:add_fields('pstEndList','pstend','Result of PST(For Police only)','nxtstep','${pstEndMin}','more_fields7');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('pstend');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
			</td></tr>
			<c:forEach items="${postDetailsList[0].pstEndList}" var="tag" varStatus="loop">
			       <c:if test="${tag.pstend!=null}">
				             <style>
				       		      #more_fields7{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<th>												
			<input type="date" name="pstEndList[${loop.index}].pstend" value="${tag.pstend}" min="${pstEndMin}">
			</th><td>	<input type="text" name="pstEndList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="pstEndList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
			</tr>
			</c:forEach>
			</table>
			</td>
			</tr>
												
												
												
			<tr>
			<th class="blue">Result of PST (For Police only)</th>
			<td>
			<table id="resultofpst">
			<tr>
			<td style="display:inline-block;"><a  id="more_fields7" class="nofreeze" href="javascript:add_fields('resultOfPstList','resultofpst','Written Exam','nxtstep','${resultofpstMin}','more_fields8');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('resultofpst');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
			</td></tr>
			<c:forEach items="${postDetailsList[0].resultOfPstList}" var="tag" varStatus="loop">
			       <c:if test="${tag.resultofpst!=null}">
				             <style>
				       		      #more_fields8{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<th>												
			<input type="date" name="resultOfPstList[${loop.index}].resultofpst" value="${tag.resultofpst}" min="${resultofpstMin}">
			</th><td>	<input type="text" name="resultOfPstList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="resultOfPstList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
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
			<table id="writtenExam">
			<tr>
			<td style="display:inline-block;"><a  id="more_fields8" class="nofreeze" href="javascript:add_fields('writtenExamList','writtenExam','Uploading Answer Key','nxtstep','${writtenExamMin}','more_fields9');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('writtenExam');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
			</td></tr>
			<c:forEach items="${postDetailsList[0].writtenExamList}" var="tag" varStatus="loop">
			     <c:if test="${tag.writtenExam!=null}">
				             <style>
				       		      #more_fields9{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<th>												
			<input type="date" name="writtenExamList[${loop.index}].writtenExam" value="${tag.writtenExam}" min="${writtenExamMin}">
			</th><td>	<input type="text" name="writtenExamList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="writtenExamList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
			</tr>
			</c:forEach>
			</table>
			</td>
			</tr>
			
			
													
			<tr>
			<th class="blue">Written Exam Session</th>
			<td>
			<input type="text" name="wRittenExamSession" value="${postDetailsList[0].wRittenExamSession}">
			</td>	
			</tr>
			
			
			<tr>
			<th class="blue">Uploading Answer Key</th>
			<td>
			<table id="uploadingAnswerKey">
			<tr>
			<td style="display:inline-block;"><a  id="more_fields9" class="nofreeze" href="javascript:add_fields('uploadingAnswerKeyList','uploadingAnswerKey','Objections Open','nxtstep','${uploadingAnswerKeyMin}','more_fields10');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('uploadingAnswerKey');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
			</td></tr>
			<c:forEach items="${postDetailsList[0].uploadingAnswerKeyList}" var="tag" varStatus="loop">
			     <c:if test="${tag.uploadingAnswerKey!=null}">
				             <style>
				       		      #more_fields10{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<th>												
			<input type="date" name="uploadingAnswerKeyList[${loop.index}].uploadingAnswerKey" value="${tag.uploadingAnswerKey}" min="${uploadingAnswerKeyMin}">
			</th><td>	<input type="text" name="uploadingAnswerKeyList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="uploadingAnswerKeyList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
			</tr>
			</c:forEach>
			</table>
			</td>
			</tr>
			
			
			<tr>
			<th class="blue">Objections Open</th>
			<td>
			<table id="objectionsOpen">
			<tr>
			<td style="display:inline-block;"><a  id="more_fields10" class="nofreeze" href="javascript:add_fields('objectionsOpenList','objectionsOpen','Objections Close','nxtstep','${objectionsOpenMin}','more_fields11');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('objectionsOpen');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
			</td></tr>
			<c:forEach items="${postDetailsList[0].objectionsOpenList}" var="tag" varStatus="loop">
			      <c:if test="${tag.objectionsOpen!=null}">
				             <style>
				       		      #more_fields11{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
			     
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<th>												
			<input type="date" id="objOpen" name="objectionsOpenList[${loop.index}].objectionsOpen" value="${tag.objectionsOpen}" min="${objectionsOpenMin}">
			</th><td>	<input type="text" name="objectionsOpenList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="objectionsOpenList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
			</tr>
			</c:forEach>
			</table>
			</td>
			</tr>
			
			
			<tr>
			<th class="blue">Objections Close</th>
			<td>
			<table id="objectionsClosed">
			<tr>
			<td style="display:inline-block;"><a  id="more_fields11" class="nofreeze" href="javascript:add_fields('objectionsClosedList','objectionsClosed','Upload Revised Answer Key','nxtstep','${objectionsclosedMin}','more_fields12');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('objectionsClosed');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
			</td></tr>
			<c:forEach items="${postDetailsList[0].objectionsClosedList}" var="tag" varStatus="loop">
			      <c:if test="${tag.objectionsClosed!=null}">
				             <style>
				       		      #more_fields12{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<th>												
			<input type="date" name="objectionsClosedList[${loop.index}].objectionsClosed" value="${tag.objectionsClosed}" min="${objectionsclosedMin}">
			</th><td>	<input type="text" name="objectionsClosedList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="objectionsClosedList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
			</tr>
			</c:forEach>
			</table>
			</td>
			</tr>
			
				
			<tr>
			<th class="blue">Uploaded Revised Answer Key</th>
			<td>
			<table id="uploadedRevisedAnswerKey">
			<tr>
			<td style="display:inline-block;"><a  id="more_fields12" class="nofreeze" href="javascript:add_fields('uploadedRevisedAnswerKeyList','uploadedRevisedAnswerKey','Result of Written Exam','nxtstep','${uploadedRevisedAnswerKeyMin}','more_fields13');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('uploadedRevisedAnswerKey');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
			</td></tr>
			<c:forEach items="${postDetailsList[0].uploadedRevisedAnswerKeyList}" var="tag" varStatus="loop">
			    <c:if test="${tag.uploadedRevisedAnswerKey!=null}">
				             <style>
				       		      #more_fields13{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<th>												
			<input type="date" name="uploadedRevisedAnswerKeyList[${loop.index}].uploadedRevisedAnswerKey" value="${tag.uploadedRevisedAnswerKey}" min="${uploadedRevisedAnswerKeyMin}">
			</th><td>	<input type="text" name="uploadedRevisedAnswerKeyList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="uploadedRevisedAnswerKeyList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
			</tr>
			</c:forEach>
			</table>
			</td>
			</tr>
											
											
		    <tr>
		    <th class="blue">Result of Written Exam</th>
			<td>
			<table id="resultOfWrittenExam">
			<tr>
			<td style="display:inline-block;"><a  id="more_fields13" class="nofreeze" href="javascript:add_fields('resultOfWrittenExamList','resultOfWrittenExam','Scrutiny','nxtstep','${resultOfWrittenExamMin}','more_fields14');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('resultOfWrittenExam');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
			</td></tr>
			<c:forEach items="${postDetailsList[0].resultOfWrittenExamList}" var="tag" varStatus="loop">
			     <c:if test="${tag.resultOfWrittenExam!=null}">
				             <style>
				       		      #more_fields14{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<th>												
			<input type="date" name="resultOfWrittenExamList[${loop.index}].resultOfWrittenExam" value="${tag.resultOfWrittenExam}" min="${resultOfWrittenExamMin}">
			</th><td>	<input type="text" name="resultOfWrittenExamList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="resultOfWrittenExamList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
			</tr>
			</c:forEach>
			</table>
			</td>
			</tr>
			
											
			
			</table>
			</div>

													<div class="step-pane" data-step="4">
														<table id="postDetailstbl" class="table  table-bordered table-hover">
			
			<tr><th class="blue">Scrutiny Start Date</th>
			<td>
			<table id="scrutinyStartDate">
			<tr>
			<td style="display:inline-block;"><a  id="more_fields14" class="nofreeze" href="javascript:add_fields('scrutinyStartDateList','scrutinyStartDate','Scrutiny','nxtstep','${scrutinyStartDateMin}','more_fields15');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('scrutinyStartDate');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
			</td></tr>
			<c:forEach items="${postDetailsList[0].scrutinyStartDateList}" var="tag" varStatus="loop">
			    <c:if test="${tag.scrutinyStartDate!=null}">
				             <style>
				       		      #more_fields15{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<th>												
			<input type="date" name="scrutinyStartDateList[${loop.index}].scrutinyStartDate" value="${tag.scrutinyStartDate}" min="${scrutinyStartDateMin}">
			</th><td>	<input type="text" name="scrutinyStartDateList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="scrutinyStartDateList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
			</tr>
			</c:forEach>
			</table>
			</td>				
			</tr>
												
												
			<tr>
			<th class="blue">Scrutiny End Date</th>
			<td>
			<table id="scrutinyEndDate">
			<tr>
			<td style="display:inline-block;"><a  id="more_fields15" class="nofreeze" href="javascript:add_fields('scrutinyEndDateList','scrutinyEndDate','Scrutiny Results','nxtstep','${scrutinyEndDateMin}','more_fields16');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('scrutinyEndDate');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
			</td></tr>
			<c:forEach items="${postDetailsList[0].scrutinyEndDateList}" var="tag" varStatus="loop">
			    <c:if test="${tag.scrutinyEndDate!=null}">
				             <style>
				       		      #more_fields16{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<th>												
			<input type="date" name="scrutinyEndDateList[${loop.index}].scrutinyEndDate" value="${tag.scrutinyEndDate}" min="${scrutinyEndDateMin}">
			</th><td>	<input type="text" name="scrutinyEndDateList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="scrutinyEndDateList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
			</tr>
			</c:forEach>
			</table>
			</td>
			</tr>											
														
														
			<tr>
			<th class="blue">Scrutiny Results</th>
			<td>
			<table id="scrutinyResults">
			<tr>
			<td style="display:inline-block;"><a  id="more_fields16" class="nofreeze" href="javascript:add_fields('scrutinyResultsList','scrutinyResults','PMT Height-Chest (For Police only)','nxtstep','${scrutinyResultsMin}','more_fields17');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('scrutinyResults');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
			</td></tr>
			<c:forEach items="${postDetailsList[0].scrutinyResultsList}" var="tag" varStatus="loop">
			     <c:if test="${tag.scrutinyResults!=null}">
				             <style>
				       		      #more_fields17{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<th>												
			<input type="date" name="scrutinyResultsList[${loop.index}].scrutinyResults" value="${tag.scrutinyResults}" min="${scrutinyResultsMin}">
			</th><td>	<input type="text" name="scrutinyResultsList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="scrutinyResultsList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
			</tr>
			</c:forEach>
			</table>
			</td>
			</tr>
												
			<c:choose>
			 <c:when test="${postDetailsList[0].dEpartmentId=='48' || postDetailsList[0].dEpartmentId=='49' || postDetailsList[0].dEpartmentId=='73'}">	
			<tr>	<th class="blue">PMT Height-Chest (For Police only)</th>
			<td>
			<table id="pmtHeightChest">
			<tr>
			<td style="display:inline-block;"><a  id="more_fields17" class="nofreeze" href="javascript:add_fields('pMTHeightChestList','pmtHeightChest','PMT Height-Chest (For Police only)','nxtstep','${pmtHeightChestMin}','more_fields18');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('pmtHeightChest');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
			</td></tr>
			<c:forEach items="${postDetailsList[0].pMTHeightChestList}" var="tag" varStatus="loop">
			    <c:if test="${tag.pmtHeightChest!=null}">
				             <style>
				       		      #more_fields18{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<th>												
			<input type="date" name="pMTHeightChestList[${loop.index}].pmtHeightChest" value="${tag.pmtHeightChest}" min="${pmtHeightChestMin}">
			</th><td>	<input type="text" name="pMTHeightChestList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="pMTHeightChestList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
			</tr>
			</c:forEach>
			</table>
			</td>										
			</tr>
												
												
			<tr>
			<th class="blue">Result of PMT Height-Chest (For Police only)</th>
			<td>
			<table id="resultOfPmtHeightChest">
			<tr>
			<td style="display:inline-block;"><a  id="more_fields18" class="nofreeze" href="javascript:add_fields('resultOfPmtHeightChestList','resultOfPmtHeightChest','Admit Cards(for Interview)','nxtstep','${resultOfPmtHeightChestMin}','more_fields19');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('resultOfPmtHeightChest');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
			</td></tr>
			<c:forEach items="${postDetailsList[0].resultOfPmtHeightChestList}" var="tag" varStatus="loop">
			     <c:if test="${tag.resultOfPmtHeightChest!=null}">
				             <style>
				       		      #more_fields19{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<th>												
			<input type="date" name="resultOfPmtHeightChestList[${loop.index}].resultOfPmtHeightChest" value="${tag.resultOfPmtHeightChest}" min="${resultOfPmtHeightChestMin}">
			</th><td>	<input type="text" name="resultOfPmtHeightChestList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="resultOfPmtHeightChestList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
			</tr>
			</c:forEach>
			</table>
			</td>
			</tr>
			</c:when>
			</c:choose>
												
			<tr><th class="blue">Admit Cards (for Interview)</th>
			<td>
			<table id="admitCardsForInterview">
			<tr>
			<td style="display:inline-block;"><a  id="more_fields19" class="nofreeze" href="javascript:add_fields('admitCardsForInterviewList','admitCardsForInterview','Interviews','nxtstep','${admitCardForIntrMin}','more_fields20');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('admitCardsForInterview');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
			</td></tr>
			<c:forEach items="${postDetailsList[0].admitCardsForInterviewList}" var="tag" varStatus="loop">
			     <c:if test="${tag.admitCardsForInterview!=null}">
				             <style>
				       		      #more_fields20{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<th>												
			<input type="date" name="admitCardsForInterviewList[${loop.index}].admitCardsForInterview" value="${tag.admitCardsForInterview}" min="${admitCardForIntrMin}">
			</th><td>	<input type="text" name="admitCardsForInterviewList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="admitCardsForInterviewList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
			</tr>
			</c:forEach>
			</table>
			</td>
            </tr>
              
                                              
            
			</table>
			</div>
			
												<div class="step-pane" data-step="5">
												<table id="postDetailstbl" class="table  table-bordered table-hover">
												
			<tr>  <th class="blue">Interviews Start Date</th>
			<td>
			<table id="interviewStartDate">
			<tr>
			<td style="display:inline-block;"><a  id="more_fields20" class="nofreeze" href="javascript:add_fields('interviewStartDateList','interviewStartDate','Interviews','nxtstep','${interviewStartDateMin}','more_fields21');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('interviewStartDate');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
			</td></tr>
			<c:forEach items="${postDetailsList[0].interviewStartDateList}" var="tag" varStatus="loop">
			    <c:if test="${tag.interviewStartDate!=null}">
				             <style>
				       		      #more_fields21{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<th>												
			<input type="date" name="interviewStartDateList[${loop.index}].interviewStartDate" value="${tag.interviewStartDate}" min="${interviewStartDateMin}">
			</th><td><input type="text" name="interviewStartDateList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="interviewStartDateList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
			</tr>
			</c:forEach>
			</table>
			</td>
			</tr>
						
						
			<tr>
			<th class="blue">Interviews End Date</th>
			<td>
			<table id="interviewEndDate">
			<tr>
			<td style="display:inline-block;"><a  id="more_fields21" class="nofreeze" href="javascript:add_fields('interviewEndDateList','interviewEndDate','Announcement of Final Result','nxtstep','${interviewEndDateMin}','more_fields22');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('interviewEndDate');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
			</td></tr>
			<c:forEach items="${postDetailsList[0].interviewEndDateList}" var="tag" varStatus="loop">
			     <c:if test="${tag.interviewEndDate!=null}">
				             <style>
				       		      #more_fields22{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<th>												
			<input type="date" name="interviewEndDateList[${loop.index}].interviewEndDate" value="${tag.interviewEndDate}" min="${interviewEndDateMin}">
			</th><td>	<input type="text" name="interviewEndDateList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="interviewEndDateList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
			</tr>
			</c:forEach>
			</table>
			</td>
			</tr>
			
											
			<tr><th class="blue">Announcement of Final Result </th>
			<td>
			<table id="announcementOfResults">
			<tr>
			<td style="display:inline-block;"><a  id="more_fields22" class="nofreeze" href="javascript:add_fields('announcementOfResultsList','announcementOfResults','Recommend','nxtstep','${announcementOfResultMin}','more_fields23');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('announcementOfResults');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
			</td></tr>
			<c:forEach items="${postDetailsList[0].announcementOfResultsList}" var="tag" varStatus="loop">
			    <c:if test="${tag.announcementOfResults!=null}">
				             <style>
				       		      #more_fields23{
				       		           pointer-events: auto;
                                       cursor: pointer;
                                    }
				             </style>
				        </c:if> 
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<th>												
			<input type="date" name="announcementOfResultsList[${loop.index}].announcementOfResults" value="${tag.announcementOfResults}" min="${announcementOfResultMin}">
			</th><td>	<input type="text" name="announcementOfResultsList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="announcementOfResultsList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
			</tr>
			</c:forEach>
			</table>
			</td>
			</tr>
											
											
			<tr><th class="blue">Recommended Date</th>
			<td>
			<table id="recommendedDate">
			<tr>
			<td style="display:inline-block;"><a  id="more_fields23" class="nofreeze" href="javascript:add_fields('recommendedDateList','recommendedDate','Joining','nxtstep','${recommendedDateMin}');" /><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			&nbsp<a id="more_fields" href="javascript:deleteRow('recommendedDate');" ><i class="fa fa-minus-square" aria-hidden="true"></i></a>
			</td></tr>
			<c:forEach items="${postDetailsList[0].recommendedDateList}" var="tag" varStatus="loop">
			<tr>
			<td><INPUT type="checkbox" name="chk"/></td>
			<th>												
			<input type="date" name="recommendedDateList[${loop.index}].recommendedDate" value="${tag.recommendedDate}" min="${recommendedDateMin}">
			</th><td>	<input type="text" name="recommendedDateList[${loop.index}].comments" value="${tag.comments}"/>
			<input type="hidden" name="recommendedDateList[${loop.index}].sRNo" value="${postDetailsList[0].sRNo}"/></td>
			</tr>
			</c:forEach>
			</table>
			</td>					
			</tr>
			<tr>
			<th class="blue">Candidates Recommended</th>
			<td><input type="text" name="cAndidatesRecommended" value="${postDetailsList[0].cAndidatesRecommended}" onkeypress="return isNumberKey(event,'characters not allowed','Error5')">
			<span id="Error5"></span>
			</td>
			</tr>
												
			<tr>
			<th class="blue">Detailed Status</th>
			<td colspan="3"><input type="text" name="dEtailedStatus" value="${postDetailsList[0].dEtailedStatus}"></td>
			</tr>
			
			</table>
			</div>	
												
			</form:form>							
												</div>
											</div>

											<hr />
											<div class="wizard-actions">
												<button class="btn btn-prev">
													<i class="ace-icon fa fa-arrow-left"></i>
													Prev
												</button>

												<button class="btn btn-success btn-next"  data-last="Finish">
													Next
													<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
												</button>
											</div>
										</div><!-- /.widget-main -->
									</div><!-- /.widget-body -->
								</div>
                               <div id="modal-form" class="modal" tabindex="-1">
									<div class="modal-dialog">
										<div class="modal-content">
		           						 <form:form name="departForm" id="addDetailsForm" method="post"  action="addDepartment" commandName="deptObj">
										
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="blue bigger">Add New Department</h4>
											</div>

											<div class="modal-body">
												<div class="row">
													<div class="col-xs-12 col-sm-7">
														<div class="form-group">
															<label for="form-field-first"> Department Name</label>

															<div>
																<input type="text" id="form-field-last" placeholder="Department Name" name="dEpartment" />
															</div>
															
														</div>
													</div>
												</div>
											</div>

											<div class="modal-footer">
												<button class="btn btn-sm" data-dismiss="modal">
													<i class="ace-icon fa fa-times"></i>
													Cancel
												</button>

												<button class="btn btn-sm btn-primary" data-last="Finish">
													<i class="ace-icon fa fa-check"></i>
													Save
												</button>
											</div>
											</form:form>
										</div>
									</div>
								</div>
								

											
									
								</div><!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
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
		<script src="assets/js/jquery-1.7.1.js"></script>
		

		<!--[if !IE]> -->
		<script src="assets/js/jquery-2.1.4.min.js"></script>

		<!-- <![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="assets/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->
		<script src="assets/js/wizard.min.js"></script>
		<script src="assets/js/wizard.min.js"></script>
		<script src="assets/js/jquery.validate.min.js"></script>
		<script src="assets/js/jquery-additional-methods.min.js"></script>
		<script src="assets/js/bootbox.js"></script>
		<script src="assets/js/jquery.maskedinput.min.js"></script>
		<script src="assets/js/select2.min.js"></script>
<!-- 		<script src="assets/js/bootstrap-datepicker.min.js"></script> -->
		<script src="assets/js/jquery-ui.min2.js"></script>
	

		
     
		<!-- ace scripts -->
		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		
		
		<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.1/js/select2.min.js"></script>
		  <script src="assets/js/custom.min.js"></script>
		


<script>

function addValues(){
	
	  document.getElementById('editDetailsForm').action="updatePostDetails";
	  document.getElementById('editDetailsForm').submit();
}

function add_fields(list,tableId,msg,nxtStepID,minDate,aTag,inputId) { 
	var table = document.getElementById(tableId);
	var rowCount = table.rows.length-1;
	var srno='${postDetailsList[0].sRNo}';
	var inputNode=document.getElementById(tableId).insertRow(-1).innerHTML = 
		'<tr><th><INPUT type="checkbox" name="chk"/></th>'+
		'<td><input type="date"  name='+list+'['+rowCount+']'+'.'+tableId+' style="width:165px;" min='+minDate+'></td >'+
		'<td><input type="text" name='+list+'['+rowCount+']'+'.comments></td>'+
		'<td><input type="hidden" name='+list+'['+rowCount+']'+'.sRNo value='+srno+'></td></tr>';
	
	//$('inputNode').focus(isDatekey(event,msg,nxtStepID,aTag));
		
	}

function deleteRow(tableID) {
	/***We get the table object based on given id ***/
    var objTable = document.getElementById(tableID);

    /*** Get the current row length ***/
    var iRow = objTable.rows.length;

	/*** Initial row counter ***/
	var counter = 0;

    /*** Performing a loop inside the table ***/
	if (objTable.rows.length > 1) {
		for (var i = 0; i < objTable.rows.length; i++) {

			 /*** Get checkbox object ***/
			var chk = objTable.rows[i].cells[0].childNodes[0];
			if (chk.checked) {
				/*** if checked we del ***/
				objTable.deleteRow(i);
				iRow--;
				i--;
				counter = counter + 1;
			}
		}

		/*** Alert user if there is now row is selected to be deleted ***/
		if (counter == 0) {
			alert("Please select the row that you want to delete.");
		}
	}else{
		/*** Alert user if there are no rows being added ***/
		alert("There are no rows being added");
	}
}

function isNumberKey(evt,msg,errId){
    var charCode = (evt.which) ? evt.which : event.keyCode
    var id=errId;
    if (charCode > 31 && (charCode< 48 || charCode>57)){
    	 document.getElementById(errId).innerHTML = msg;
        return false;
        }
    else{
    	document.getElementById(errId).innerHTML = "";
         return true;
    
    }
    
}

function ischarKey(evt,msg,errId,aTag){
	 var charCode = (evt.which) ? evt.which : event.keyCode
    	 document.getElementById(errId).innerHTML = msg;
    	 document.getElementById('nExtStepvalue').value=msg;
    	    if(charCode){
    	 document.getElementById(aTag).style.pointerEvents="auto";
    	 document.getElementById(aTag).style.cursor="pointer";
    	 document.getElementById(aTag).style.opacity="default";
          return true;
   }
    }

/* function isDatekey(evt,msg,errId,aTag){
		document.getElementById(errId).innerHTML = msg;
		document.getElementById('nExtStepvalue').value=msg;
		document.getElementById(aTag).style.pointerEvents="auto";
	    document.getElementById(aTag).style.cursor="pointer";      
	     return true;
	   } */
</script>
		
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
					
					
					var selectedValue = selectDepart.value
					
					document.getElementById('dEpartmentId').value=selectedValue;
					
					 var postName=document.postForm.nAmeOfPost.value;
					    var advtNo=document.postForm.aDvtNo.value;
					    var catNo=document.postForm.cAtNo.value;
// 					    var objectionOpen=document.postForm.objectionsOpenList[${loop.index}].objectionsOpen.value
// 					    var i;    
// 					    var allObjOpen;
// 					    for(i=0; i<=objectionOpen.length; i++){
// 					    	allObjOpen=objectionOpen[i];
// 					        }
					    /*  if(departName==""){
					    	  document.getElementById("Error").innerHTML = "Please Enter the department";
					    	  departName.focus();
					          return false;
					     } */
					     if(postName==""){
					    	  document.getElementById("Error1").innerHTML = "Please Enter the post name";
					    	  document.getElementById("Error7").innerHTML = "(Error in General Information)";
					    	  postName.focus();
					    	  return false;
					     }
					     else if(advtNo==""){
					    	 document.getElementById("Error2").innerHTML = "Please Enter the Advertisement number";
					    	  document.getElementById("Error7").innerHTML = "(Error in General Information)";
					    	 advtNo.focus();
					    	 return false;
					     }
					     else if(catNo==""){
					    	 document.getElementById("Error3").innerHTML = "Please Enter the category number";
					    	  document.getElementById("Error7").innerHTML = "(Error in General Information)";
					    	 advtNo.focus();
					    	 return false;
					     }
					    else{
					    	/* document.getElementById('dEpartmentId').value=dEpartmentId;
					 	   document.getElementById('editDetailsForm').action="updatePostDetails"; */
					 	   document.getElementById('editDetailsForm').submit();
					    }					
					/*  document.getElementById('editDetailsForm').submit(); */
					
					   
					
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
				
				
				$(document).ready(function() {
					 var data = document.getElementById(selectDepart);
				       $("#selectDepart").select2({
							  data: data
							});
				});
				
				
				$(document).ready(function() {
					 var data = document.getElementById(selectStatus);
				       $("#selectStatus").select2({
							  data: data
							});
				});
				
				$(document).ready(function() {
					 var data = document.getElementById(selectCurrStatus);
				       $("#selectCurrStatus").select2({
							  data: data
							});
				});
				$(document).ready(function() {
					 var data = document.getElementById(selectNextStep);
				       $("#selectNextStep").select2({
							  data: data
							});
				});
				$(document).ready(function(){
				   
				});
			})
		</script>
	</body>
</html>
