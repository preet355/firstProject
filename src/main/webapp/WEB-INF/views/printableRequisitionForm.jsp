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
<style type="text/css">
div.print-content article.node .node-blog .clearfix div.item-body p a { display: none; }
</style>		
		
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


			<div class="main-content">
				<div class="main-content-inner">
					<div class="page-content">

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="page-header">
									<h1>
									  Requisition Form 
									</h1>
								</div>
								<form:form name="requisitionForm" id="requisitionForm" method="post" enctype="multipart/form-data" accept-charset="UTF-8"  action="saveRequisitionForm">
									<input type="hidden" id="idRequisition" name="idRequisition"/>
										    <table id="simple-table" class="table  table-bordered table-hover">
										      <tbody>
										         <tr>
										            <td>
										             <label class="pos-rel" style="font-weight:600;font-size:12px;">
															Department Name
														</label>
										            </td>
										            <td>
										              ${requisitionForm[0].deptObj.dEpartment}
										            </td>
										            <td>
										             <label class="pos-rel" style="font-weight:600;font-size:12px;">
														  User ID
														</label>
										            </td>
										            <td>
										              ${user.email}
										            </td>
										         </tr>
												<tr>
													<td>
														<label class="pos-rel" style="font-weight:600;font-size:12px;">
															Designation of the post
														</label>
													</td>
													<td >
														 <label class="pos-rel" style="font-weight:0;font-size:12px;">
															${requisitionForm[0].postObj.postName}
														</label>
													</td>
													<td>
													<label class="pos-rel" style="font-weight:600;font-size:12px;">
														 Number of posts to be filled
												    </label>
													</td>
													<td>
													 <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].numberOfPostToBeFilled}
												    </label>
													</td>
													
												</tr>
												<tr>
													<td>
														<label class="pos-rel" style="font-weight:600;font-size:12px;">
															Class & service to which the post belongs
														</label>
													</td>

													<td >
														<label class="pos-rel" style="font-weight:0;font-size:12px;">
															${requisitionForm[0].classAndServiceOfPost}
														</label>
													</td>
													<td>
													<label class="pos-rel" style="font-weight:600;font-size:12px;">
														Whether there are any published Rules  for this service/post?
												    </label>
													</td>
													<td>
													   <label class="pos-rel" style="font-weight:;font-size:12px;">
														${requisitionForm[0].anyPublishedRulesForService}
												    </label> 
													 </td>
													
												</tr>
												<tr>
													<td>
														<label class="pos-rel" style="font-weight:600;font-size:12px;">
															Provide the link for service rules on Department's website or upload here
                                                            (Signed and Stamped copy to be uploaded/attached)
														</label>
													</td>
                                                      		 
													<td >
													
													${requisitionForm[0].requisitionDocsList[0].fileName}
													 
													</td>
													<td>
													<label class="pos-rel" style="font-weight:600;font-size:12px;">
														Whether post is  permanent or temporary?
												    </label>
													</td>
													<td>
													   <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].isPostPermanentOrTemporary}
												      </label>		
													</td>
													
												</tr>
												<tr>
												    <td>
													<label class="pos-rel" style="font-weight:600;font-size:12px;">
														Job Description
												    </label>
													</td>
													<td colspan='3'>
													   <label class="pos-rel" style="font-weight:;font-size:12px;">
														${requisitionForm[0].jobDescription}
												    </label> 
													 </td>
												</tr>
												<tr>
												   <td colspan="4">
												       <label style="font-weight:900;font-size:14px;">
												          Scale of pay
												       </label>
												   </td>
												</tr>
												<tr>
												  <td>
												  <label style="font-weight:600;font-size:12px;">
												          (a)  For direct recruits
												       </label>
												  </td>
												  <td >
												  <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].scaleOfPayForDirectRecruits} 
												      </label>	
												  </td>
												  <td rowspan="3">
												   <label style="font-weight:600;font-size:12px;">
												            Will any special concessions be given to  a candidate of non-Asiatic domicile ?
												       </label>
												  </td >
												  <td rowspan="3">
												    <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].anySpecialConcessionsForNonAsiaticDomicile}
												      </label>
												  </td>											
												</tr>
												<tr>
												  <td >
												  <label style="font-weight:600;font-size:12px;">
												         (b)  For persons already in Government service, if Government servants are eligible
												       </label>
												  </td>
												  <td >
												   <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].scaleOfPayForPersonsAlreadyInGovernmentService} 
												      </label>
												  </td>
												</tr>
												<tr>
												  <td >
												  <label style="font-weight:600;font-size:12px;">
												         (c) Can higher initial pay be granted for specially well-qualified candidates? if so, please specify the limit
												       </label>
												  </td>
												  <td>
												  <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].higherInitialPayBeGranted} 
												      </label>
												  </td>
												</tr>
												<tr>
												  <td colspan="4">
												      <label style="font-weight:900;font-size:14px;">
												          Qualification
												       </label>
												  </td>
												</tr>
												<tr>
												   <td>
												      <label style="font-weight:600;font-size:12px;">
												         Academic. (If more than one  qualifications  are prescribed, it should  be stated which is considered to be most  important )
												       </label>
												   </td>
												   <td>
														 <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].academicQualifications}
												      </label>
												   </td>
												   <td>
												     <label style="font-weight:600;font-size:12px;">
                                                        Training
												      </label>
												   </td>
												   <td>
														<label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].training}
												      </label>
												   </td>
												</tr>
												<tr>
												  <td>
												    <label style="font-weight:600;font-size:12px;">
                                                        Hindi qualification
												      </label>
												  </td>
												  <td>
												     <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].hindiQualification}
												      </label>
												  </td>
												  <td>
												     <label style="font-weight:600;font-size:12px;">
                                                        Experience (in years)
												      </label>
												  </td>
												  <td>
												     <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].experience}
												      </label>
												  </td>
												</tr>
												<tr>
												  <td>
												     <label style="font-weight:600;font-size:12px;">
                                                        State clearly whether the experience  gained by a candidate after acquiring the  minimum basic qualification (s)  prescribed against clause (a) above is to  be taken into consideration
												      </label>
												  </td>
												  <td>
												     <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].isExperienceTakenIntoConsidration}
												      </label>
												  </td>
												  <td>
												    <label style="font-weight:600;font-size:12px;">
                                                       Will equivalent qualifications be  accepted? If so, equivalents should be  stated
												      </label>
												</td>
												<td>
												  <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].equivalentQualifications}
												      </label>
												 </td>
												</tr>
												<tr>
												 <td>
												    <label style="font-weight:600;font-size:12px;">
                                                       Any other qualifications
												      </label>
												 </td>
												 <td>
												    <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].anyOtherQualifications}
												      </label>
												 </td>
												 <td>
												   <label style="font-weight:600;font-size:12px;">
                                                       State which of the above requirements  will be strictly adhered.
												      </label>
												</td>
												<td>
												    <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].requirementsStrictlyAthered}
												      </label>
												</td>
												</tr>
											    <tr>
											     <td colspan="4">
											        <label style="font-weight:900;font-size:14px;">
												           Age-limit
												       </label>
											     </td>
											    </tr>
											    <tr>
											    <td>
											       <label style="font-weight:600;font-size:12px;">
                                                       Lower (in Years)
												      </label>
											    </td>
											    <td>
											       <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].lowerAgeLimit}
												      </label>
											    </td>
											    <td>
											       <label style="font-weight:600;font-size:12px;">
                                                       Upper (in Years)
												      </label>
											    </td>
											    <td>
											        <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].upperAgeLimit}
												      </label>
											    </td>
											    </tr>
											    <tr> 
											      <td>
											      <label style="font-weight:600;font-size:12px;">
                                                       Exact date on which the age is to be determined
												      </label>
											    </td>
											    <td>
											        <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].dateOnWhichAgeIsDetermined}
												      </label>
											    </td>
											    <td>
											      <label style="font-weight:600;font-size:12px;">
                                                      Are Government servants eligible?
												      </label>
											    </td>
											    <td>
											     <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].areGovServantsEligible}
												      </label>
											    </td>
											    </tr>
											    <tr>
											      <td colspan="4">
											         <label style="font-weight:800;font-size:12px;color:blue;">
												           Whether any relaxation is admissible for:
												       </label>
											      </td>
											    </tr> 	
											    <tr>
											      <td>
											      <label style="font-weight:600;font-size:12px;">
                                                      (i) Government servants
												      </label>
											      </td>
											      <td>
											      <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].anyRelaxationForGovServents}
												      </label>
											      </td>
											      <td>
											         <label style="font-weight:600;font-size:12px;">
                                                      (ii) Otherwise suitable candidates
												      </label>
											      </td>
											      <td>
											      <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].anyRelaxationForSutaibleCandidates}
												      </label>
											      </td>
											    </tr>
											     <tr>
											       <td colspan="4">
											          <label style="font-weight:900;font-size:14px;">
												          Total Vacancies and vertical/horizontal reservation as per state policy
												       </label>
												       <br>
											          <label style="font-weight:400;font-size:12px;color:red">
<!-- 												        <i> Recruitment for SBC/EBPGC category has been stayed as per orders from High Court.</i><br> -->
												        <i><b>ESP (3% of Group B, 3% of Group C and 10% of Group D)</b> as per instruction No. 22/10/2013-1GSIII dated 30.04.2019</i>
												       </label>
											       </td>
											     </tr>
											    <%--  <tr>
											      <td>
											         <label style="font-weight:600;font-size:12px;">
                                                      Total Number of Seats 
												      </label>
											      </td>
											      <td>
											         <label class="pos-rel" style="font-weight:0;font-size:12px;">
														${requisitionForm[0].totalNumberOfSeats}
												      </label>
											      </td>
											     </tr> --%>
											    <%--  <tr>
											     <td colspan="4">
											           <table id="simple-table" class="table  table-bordered table-hover">
											               <thead>
											                  <tr>
											                  <c:forEach items="${headersArr}" var="var" varStatus="loop">
											                  <th>
											                      <c:out value="${var}"/> 
											                     </th>
											                  </c:forEach>
											                  </tr>
											               </thead>											            
											               <tbody>											                 
											                 <c:forEach items="${bifurcationList}" var="req">
        														<tr>
          												  <td> <c:out value="${req.category}"/></td>  
          												 <td> <c:out value="${req.totalCount}"/></td>
          												 <td> <c:out value="${req.nonEsmEspCount}"/></td>
          												 <td> <c:out value="${req.esmCount}"/></td>
          												 <td> <c:out value="${req.espCount}"/></td>          												 
          												 <td> <c:out value="${req.backLogCount}"/></td> 
          												          												  
        													</tr>
  															  </c:forEach>

											               </tbody>
											           
											           </table>
											        </td>
											        </tr> --%>
											         <tr> 
											        <td colspan="4">
											           <table id="simple-table" class="table  table-bordered table-hover">
											               <thead>
											                  <tr>
											                  <c:forEach items="${headersArr}" var="var" varStatus="loop">
											                  <th <c:if test="${var=='Category'}">colspan="2"</c:if>>
											                      <c:out value="${var}"/> 
											                     </th>
											                  </c:forEach>
											                  </tr>
											               </thead>											            
											               <tbody>											                 
											                 <c:forEach items="${bifurcationList}" var="req">
        														<tr>
          												  <td colspan="2"> <c:out value="${req.category}"/></td>  
          												 <td> <c:out value="${req.totalCount}"/></td>
          												 <td> <c:out value="${req.nonEsmEspCount}"/></td>
          												 <td> <c:out value="${req.esmCount}"/></td>
          												 <td> <c:out value="${req.espCount}"/></td>  
          												         												 
          												          												          												  
        													</tr>
       													<%-- 	<tr>
          												 <td> <c:out value="${req.totalCountBackLog}"/></td>
          												 <td> <c:out value="${req.nonEsmEspCountBackLog}"/></td>
          												 <td> <c:out value="${req.esmCountBackLog}"/></td>
          												 <td> <c:out value="${req.espCountBackLog}"/></td>
          												           												 
          												          												          												  
        													</tr> --%>
        													
  															  </c:forEach>
  															  <tr>
  															    <td>
  															       <b>Total</b>		
  															    </td>
  															    <td>
  															      ${requisitionForm[0].numberOfPostToBeFilled}
  															    </td>
  															     <%-- <td>
											                   
											                     <label>
											                        <b>ESP</b>
											                     </label></br>
											                      <label style="font-weight:400;font-size:12px;color:red">
												                   <i>3% for Group C and 10% for Group D</i>
												                  </label>
											                   </td>
											                   <td>
											                     ${requisitionForm[0].espSeats}
											                   </td> --%>
  															  </tr>
  															  <tr>
  															    <td> 
  															       <b>PWD -(4% of Total Seats) The computation of 4% reservation is on the basis of total no of posts in the cadre minus existing strength of PwD (Person with Disability)</b>
  															    </td>
  															   <td>
                                                                   Blindness and low vision  - ${requisitionForm[0].pwd1}
                                                             </td>
                                                             <td>
                                                                   Deaf and hard of hearing -${requisitionForm[0].pwd2}
                                                             </td>
                                                             <td>
                                                                    locomotor disability including cerebral palsy, leprosy cured, dwarfism, 
                                                                    acid attack victims and muscular dystrophy - ${requisitionForm[0].pwd3}
                                                             </td>
                                                             <td colspan="6">
                                                                  autism, intellectual disability, specific learning disability and mental illness <br><b>AND</b><br>
                                                                    multiple disabilities from amongst person under all clauses including deaf-blindness in the posts identified for each disabilities -  ${requisitionForm[0].pwd4}
                                                             </td>
  															  </tr>
  															  <tr>
											                      <td colspan="6">
											                         <i><b>Note:</b> If the posts are not identified, no need to fill up the column of bifurcation.</i>
											                      </td>
											                   </tr>
  															   <c:if test="${not empty requisitionForm[0].pwd1}">
  															      <tr >
												                      <td>
												                        <b>
												                         Visual Handicap Bifurcation
												                        </b>
												                      </td>
											                         <td colspan="2">
											                          Blind (B) - ${requisitionForm[0].pwdB}
											                           
											                         </td>
											                         <td colspan="3">
											                           Low Vision (LV)  - ${requisitionForm[0].pwdL}
											                           
											                         </td>
											                      </tr>
  															  </c:if>
  															  
  															  <c:if test="${not empty requisitionForm[0].pwd2}">
  															      <tr >
											                      <td>
												                        <b>
												                         Hearing Handicap Bifurcation
												                        </b>
												                      </td>
											                         <td colspan="2">
											                           Fully Deaf (FD) - ${requisitionForm[0].pwdFD}
											                         
											                         </td>
											                         <td colspan="3">
											                           Hard of  Hearing/Partial Deaf (HH/PD) - ${requisitionForm[0].pwdHH}
											                         </td>
											                      </tr>
											                      
  															  </c:if>
  															  <c:if test="${not empty requisitionForm[0].pwd3}">
  															  <tr >
											                          <td colspan="6" >
											                              <b>locomotor disability including cerebral palsy, leprosy cured, dwarfism, acid attack victims and muscular dystrophy</b>
											                          </td>
											                       </tr>
											                      <tr >
											                         <td >
											                           One Leg (OL) - ${requisitionForm[0].pwdOL}
											                         </td>
											                         <td >
											                           One Arm (OA) - ${requisitionForm[0].pwdOA}
											                         </td>
											                         <td >
											                           Both Arms (BA) - ${requisitionForm[0].pwdBA}											                         </td>
											                         <td >
											                           Both Hands (BH) - ${requisitionForm[0].pwdBH}
											                         </td>
											                         <td colspan="2">
											                           Muscular Weakness (MW) - ${requisitionForm[0].pwdMW}
											                         </td>
											                        
											                      </tr>
											                      <tr>
											                         <td >
											                           One Arm One Leg (OAL) - ${requisitionForm[0].pwdOAL}
											                         </td>
											                         <td >
											                           Both Legs and Arms (BLA) - ${requisitionForm[0].pwdBLA}
											                         </td>
											                         <td >
											                           Both Legs One Arm (BLOA) - ${requisitionForm[0].pwdBLOA}
											                         </td>
											                         <td >
											                           Cerebral paisy - ${requisitionForm[0].pwdCPaisy}
											                         </td>
											                         <td colspan="2">
											                           leprosy cured - ${requisitionForm[0].pwdLCured}
											                         </td>
											                      </tr>
											                      <tr>
											                         <td >
											                           dwarfism - ${requisitionForm[0].pwdDwarfism}
											                         </td>
											                         <td >
											                           acid attack victims - ${requisitionForm[0].pwdAAVictims}
											                         </td>
											                         <td >
											                           muscular dystrophy - ${requisitionForm[0].pwdMDystrophy}
											                         </td>
											                         <td colspan="3">
											                           others - ${requisitionForm[0].pwdOthers}
											                         </td>
											                      </tr>
  															  
  															  </c:if>
<tr>
        													<!--   <td>
        													    <b>Total</b>
        													  </td>
        													  <td>
        													  
        													  </td>
        													  <td>
        													  <b>PWD (4% of Total Seats)</b>
        													  </td>
        													  <td>
        													  </td> -->
        													</tr>
											               </tbody>
											           
											           </table>
											        </td>
											     </tr>
											     <tr>
											       <td>
											         <label style="font-weight:600;font-size:12px;">
				                                                     Name of officer of the Department whom  Government would like the  Commission to invite to be present to  assist them in an advisory capacity.
															  </label>
											       </td>
											       <td>
											            <label style="font-weight:0;font-size:12px;">
				                                                    ${requisitionForm[0].nameOfOfficerForAdvisoryCapacity}
													    </label>
											       </td>
											         
											       <td>
											         <label style="font-weight:600;font-size:12px;">
													   Name of Nodal Officer		  
													</label>
											       </td>
											       <td>
											         <label style="font-weight:0;font-size:12px;">
				                                                    ${requisitionForm[0].nameOfNodalOfficer}
													    </label>
											       </td>
											     </tr>
											     <tr>
											       <td>
											         <label style="font-weight:600;font-size:12px;">
													   Phone Number of Nodal Officer	  
													</label>
											       </td>
											       <td>
											         <label style="font-weight:0;font-size:12px;">
				                                                    ${requisitionForm[0].phoneNumberOfNodelOfficer}
													    </label>
											       </td>
											       <td>
											          <label style="font-weight:600;font-size:12px;">
													   Any other condition or qualification not covered by the above questions.  
													</label>
											       </td>
											       <td> 
											          <label style="font-weight:0;font-size:12px;">
				                                                    ${requisitionForm[0].conditionOrQualificationNotCoveredAbove}
													    </label>
											       </td>
											     </tr>
										    </table>				
						                  
						                 </form:form>		
							</div>
					<div class="box-footer" align="right">
					<center>
                	<button type="submit" class="btn btn-sm btn-grey" onClick="window.close()">Cancel</button>&emsp;
                	<button  class="btn btn-sm btn-warning" onClick="printWindow()">Print</button>
               		 </center>
            	  </div>
						</div>
					</div>
				</div>
			</div><!-- /.main-content -->

			

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

<script>

function printWindow() {

window.print();
}
</script>		
		
	</body>
</html>
