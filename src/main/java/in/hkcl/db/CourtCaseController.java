package in.hkcl.db;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.displaytag.properties.SortOrderEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.hkcl.dao.BaseDataDao;
import in.hkcl.dao.CourtCaseDao;
import in.hkcl.model.CourtCaseDetails;
import in.hkcl.model.Department;
import in.hkcl.model.DepartmentVO;
import in.hkcl.model.DepartmentWiseCountHelper;
import in.hkcl.model.District;
import in.hkcl.model.HearingDetails;
import in.hkcl.model.ImpactGraphHelper;
import in.hkcl.model.PetitionerDetails;
import in.hkcl.model.Police;
import in.hkcl.model.UserEditLogs;
import in.hkcl.model.YearWiseCountHelper;
import in.hkcl.pagination.ExtendedPaginatedList;
import in.hkcl.pagination.PaginatedListImpl;
import in.hkcl.service.BaseDataService;
import in.hkcl.service.CourtCaseService;
import in.hkcl.utils.ApplicationLogFactory;
import in.hkcl.utils.ApplicationLogger;
import in.hkcl.utils.CommonUtils;
import in.hkcl.utils.DateFormatterUtility;

@Controller
public class CourtCaseController {
	
	@Autowired
	BaseDataDao baseDataDao;
	
	@Autowired
	CourtCaseDao courtCaseDao;

	@Autowired
	ServletContext context;

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	ApplicationEventPublisher eventPublisher;

	@Autowired
	BaseDataService baseDataService;
	
	@Autowired
	CourtCaseService courtCaseService;

	private static ApplicationLogger logger = ApplicationLogFactory.getLogger(MISController.class);
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@ModelAttribute
	public void setDropDownValues(Model model, HttpServletRequest request, HttpSession session) {
		try {
			List<UserEditLogs> userLogObj= baseDataService.getLastUpdateTime();
			List<Department> departmentList = baseDataService.loadAllDepartments();
			model.addAttribute("deptList", departmentList);
			Integer dEpartmentId = (Integer) session.getAttribute("idDept");
			List<String> distinctWritNoList= courtCaseService.getdistinctWritNoList();
			List<String> distinctCaseStatusList=courtCaseService.getdistinctCaseStatusList();
			List<String> distinctCaseTypeList=courtCaseService.getdistinctCaseTypeList();
			List<String> distinctYearList=courtCaseService.getdistinctYearList();
			//List<CourtCaseDetails> allCourtCasesDataForDropDown = courtCaseService.getAllCourtCasesDataForDropDown();
			List<String> allHsscPostListForADVTNO = baseDataService.getDistinctAdvtNo(dEpartmentId);
			List<String> allHSSCPetitionerNames = courtCaseService.getAllHsscPetitionerNames();
			model.addAttribute("distinctWritNoList", distinctWritNoList);
			model.addAttribute("distinctCaseStatusList",distinctCaseStatusList);
			model.addAttribute("distinctCaseTypeList",distinctCaseTypeList);
			model.addAttribute("distinctYearList",distinctYearList);
			model.addAttribute("allHsscPostListForADVTNOForSearch", allHsscPostListForADVTNO);
			model.addAttribute("allHSSCPetitionerNames", allHSSCPetitionerNames);
			model.addAttribute("userLogObj",userLogObj);
		} catch (Exception e) {
			logger.logError("setDropDownValues", "exception while getting drop down data", e);
		}

	}
	
	
	@RequestMapping(value="/allHsscCourtCaseData", method={RequestMethod.GET,RequestMethod.POST})
	public String allHsscCourtCaseData(Model model, @ModelAttribute("sRNo") String sRNo, @ModelAttribute("caseId") String caseId){
		try{
			List<CourtCaseDetails> courtCaseDetailsList = courtCaseService.editCourtCaseDetails(Integer.parseInt(caseId));
			List<Police> policeDetailsList = baseDataService.getPostDetails(Integer.parseInt(sRNo));
			model.addAttribute("policeDetailsList", policeDetailsList);
			model.addAttribute("courtCaseDetailsList", courtCaseDetailsList);
		
		}catch(Exception e){
			logger.logError("allHsscCourtCaseData", "exception while getting data", e);
		}
		return "viewCourtCaseDetails";
	}
	
	@RequestMapping(value = "/addCourtCase", method = { RequestMethod.GET, RequestMethod.POST })
	public String addCourtCaseDetails(Model model,@ModelAttribute("srNo") Integer srNo) throws Exception {
		List<Police> policeDetailsList = baseDataService.getPostDetails(srNo);
		List<District> districtList =courtCaseService.getAllDistrict();
		model.addAttribute("policeDetailsList", policeDetailsList);
		model.addAttribute("districtList", districtList);
		return "editCourtCaseDetails";
	}
	
	
	
	@RequestMapping(value = "/editCourtCase", method = { RequestMethod.GET, RequestMethod.POST })
	public String editCourtCaseDetails(Model model,@ModelAttribute("caseId") String caseId,@ModelAttribute("sRNo") String sRNo) throws Exception {
		List<CourtCaseDetails> courtCaseDetailsList = courtCaseService.editCourtCaseDetails(Integer.parseInt(caseId));
		List<Police> policeDetailsList = baseDataService.getPostDetails(Integer.parseInt(sRNo));
		List<District> districtList =courtCaseService.getAllDistrict();
		model.addAttribute("policeDetailsList", policeDetailsList);
		model.addAttribute("courtCaseDetailsList", courtCaseDetailsList);
		model.addAttribute("locaton", courtCaseDetailsList.get(0).getCourtLocation());
		model.addAttribute("districtList", districtList);
		return "editCourtCaseDetails";	
	}
	
	@RequestMapping(value = "/updateCourtCaseDetails", method= { RequestMethod.GET, RequestMethod.POST })
	public String updateCourtCaseDetails(Model model,@ModelAttribute("advtNo") String advtNo, @ModelAttribute("courtCaseObj") CourtCaseDetails courtCase , @ModelAttribute("uniqueCaseId") String uniqueCaseId , HttpServletRequest request, HttpSession session) throws Exception{
		CourtCaseDetails updatedCourtCase=new CourtCaseDetails();
		   
		try{
			List<Police> policeDetailsList = baseDataService.getPostDetails(courtCase.getsRNo());
			List<District> districtList =courtCaseService.getAllDistrict();
			List<CourtCaseDetails> courtCaseDetailsList = courtCaseService.editCourtCaseDetails(courtCase.getCaseId());
			
			   if(CommonUtils.isNotEmpty(courtCase.getHearingDetailsList())){
				   
				   for(HearingDetails h: courtCase.getHearingDetailsList()){
					   if(h.getDate()==null){
						   model.addAttribute("districtList", districtList);
						   model.addAttribute("policeDetailsList", policeDetailsList);
						   model.addAttribute("locaton", courtCase.getCourtLocation());
						   model.addAttribute("courtCaseDetailsList", courtCaseDetailsList);
						   model.addAttribute("hearingDateFailed","hearing Date column should not be null");
						   return "editCourtCaseDetails";
					   }
				   }
			   }
                
		    Integer userId = (Integer) session.getAttribute("userId");
		    
		    courtCase.setUserId(userId);
		
		    updatedCourtCase= courtCaseService.updateCourtCaseDetails(courtCase);		    
		    courtCaseService.updateMacroStatusinMis(courtCase.getsRNo(),courtCase.getStay());	
		  
		}catch(Exception e){
			logger.logError("updatePostDetailsForAdmin", "exception while updating details", e);	
		}
	   if(updatedCourtCase.getCaseId()==null){
		   model.addAttribute("failed","Case No. already Exist");
		   return addCourtCaseDetails(model,courtCase.getsRNo());
	   }
		
	 return courtCaseSearch(model,request, null, null, null, null, null, null, null,null,null,null,null);
	
	}
	
	@RequestMapping(value = "/courtCaseSearch", method = { RequestMethod.GET, RequestMethod.POST })
    public String courtCaseSearch(Model model, HttpServletRequest request,
                  @ModelAttribute("pageSizeTotal") String pageSizeTotal, @ModelAttribute("writNo") String writNo,
                  @ModelAttribute("caseStatus") String caseStatus, @ModelAttribute("petitionerName") String petitionerName,
                  @ModelAttribute("caseType") String caseType, @ModelAttribute("year") String year, @ModelAttribute("aDvtNo") String aDvtNo,
                  @ModelAttribute("hearingDate") String hearingDate,@ModelAttribute("pagination") String pagination,
                  @ModelAttribute("sort") String sort,@ModelAttribute("sortDirection") String sortDirection) throws Exception {
           

           try{
        long totalNoOfPostImpacted=0;
           ExtendedPaginatedList paginatedList = getPaginatedListFromRequest(request);
           
           if(CommonUtils.isEmpty(pagination)) {
                  paginatedList.setSortCriterion(sort);
                  model.addAttribute("sort",paginatedList.getSortCriterion());
                  model.addAttribute("sortDirection",paginatedList.getSortDirection());
                  }else {
                  model.addAttribute("sort",sort);
                  model.addAttribute("sortDirection",sortDirection);
                  paginatedList.setSortCriterion(sort);
                  if(sortDirection.equalsIgnoreCase("DESCENDING")) {
                  paginatedList.setSortDirection(SortOrderEnum.DESCENDING);
                  }else {
                        paginatedList.setSortDirection(SortOrderEnum.ASCENDING);   
                  }
                  }
           
           CourtCaseDetails courtCaseDetailsObj = new CourtCaseDetails();
           if (CommonUtils.isNotEmpty(hearingDate)&& !hearingDate.contains("Search by Hearing Date...")) {
                  List<HearingDetails> list = new ArrayList<HearingDetails>();  
                  HearingDetails pet = new HearingDetails();
                  pet.setDate(DateFormatterUtility.stringtoDateConversion(hearingDate, "dd/MM/yyyy"));
                  list.add(pet);
                  courtCaseDetailsObj.setHearingDetailsList(list);
           }
           if (CommonUtils.isNotEmpty(writNo)) {
                  if (writNo.contains("Search Case No...")) {
                  } else {
                        courtCaseDetailsObj.setWritNo(Integer.parseInt(writNo));
                  }
           }
           if (CommonUtils.isNotEmpty(caseStatus)) {
                  courtCaseDetailsObj.setCaseStatus(caseStatus);
           }
           if (CommonUtils.isNotEmpty(caseType)) {
                  courtCaseDetailsObj.setCaseType(caseType);
           }
           if (CommonUtils.isNotEmpty(year)) {
                  courtCaseDetailsObj.setYear(year);
           }
           /*if(CommonUtils.isNotEmpty(petitionerName)&& !petitionerName.contains("Search by Petitioner name...")) {
                  
                  courtCaseDetailsObj.getPetitionerDetailsList().get(0).setName(petitionerName);
                  
           }*/
           if (CommonUtils.isNotEmpty(petitionerName)&& !petitionerName.contains("Search by Petitioner name...")) {
                  List<PetitionerDetails> petitionerDetailsList = new ArrayList<PetitionerDetails>();
                  PetitionerDetails pet = new PetitionerDetails();
                  pet.setName(petitionerName);
                  petitionerDetailsList.add(pet);
                  courtCaseDetailsObj.setPetitionerDetailsList(petitionerDetailsList);
           }
           if (CommonUtils.isNotEmpty(aDvtNo)&& !aDvtNo.contains("Search Advertisement Number...")) {
                  
                  Police advt = new Police();
                  advt.setaDvtNo(aDvtNo);
                  courtCaseDetailsObj.setPoliceDetailsObj(advt);
           }
           paginatedList = courtCaseService.getAllCourtCaseData(courtCaseDetailsObj, paginatedList); 
           List<Date> hearingDetailsUniqueDateList=courtCaseService.getHearingDetailsUniqueDateList();
           List<String> hearingDetailsUniqueDates=new ArrayList<String>();
              for(Date h: hearingDetailsUniqueDateList){
                     String ds2=null;
                     if(CommonUtils.isNotEmpty(h))
                        {
                           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
                           String strDate = dateFormat.format(h);  
                           
                           SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                           SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                           
                            ds2 = sdf2.format(sdf1.parse(strDate));
                       }
                     hearingDetailsUniqueDates.add(ds2);
              }
           model.addAttribute("hearingDetailsUniqueDateList",hearingDetailsUniqueDates);
           model.addAttribute("allCourtCaseDataList", paginatedList);
           model.addAttribute("pageSizeTotal", paginatedList.getTotalNumberOfRows());
           model.addAttribute("pageSize", paginatedList.getPageSize());
           if (!writNo.contains("Search Case No...")&& !writNo.equalsIgnoreCase("")) {
           model.addAttribute("writNoForDropDown",Integer.parseInt(writNo)); }
           model.addAttribute("caseStatusForDropDown",caseStatus);
           model.addAttribute("petitionerName",petitionerName);
           model.addAttribute("caseTypeForDropDown",caseType);
           model.addAttribute("hearingDateForDropDown", hearingDate);
           model.addAttribute("advtForDropdown",aDvtNo);
           model.addAttribute("yearForDropDown",year);
           }catch(Exception e){
                  logger.logError("courtCaseSearch", "exception while searching details", e);       
           }
           return "courtCaseSearch";
    }

	
	private ExtendedPaginatedList getPaginatedListFromRequest(HttpServletRequest request) {
		int pageSize = 10;
		String thePage = null;
		String sortCriterion = null;
		ExtendedPaginatedList paginatedList = new PaginatedListImpl();
		if (request != null) {
			sortCriterion = request.getParameter(ExtendedPaginatedList.IRequestParameters.SORT);
			paginatedList.setSortDirection(ExtendedPaginatedList.IRequestParameters.DESC
					.equals(request.getParameter(ExtendedPaginatedList.IRequestParameters.DIRECTION))
							? SortOrderEnum.DESCENDING : SortOrderEnum.ASCENDING);
			thePage = request.getParameter(ExtendedPaginatedList.IRequestParameters.PAGE);
			String size = request.getParameter("pageSize");
			if (!CommonUtils.isEmpty(size)) {
				pageSize = Integer.parseInt(size);
			} else if (null != request.getSession().getAttribute("pageSize")) {
				pageSize = (Integer) request.getSession().getAttribute("pageSize");
			}

		}
		paginatedList.setSortCriterion(sortCriterion);
		paginatedList.setPageSize(pageSize);
		if (CommonUtils.isNotEmpty(thePage)) {
			int index = Integer.parseInt(thePage) - 1;
			paginatedList.setIndex(index);
		} else {
			paginatedList.setIndex(0);
		}
		return paginatedList;
	}
	
	
	
	@RequestMapping(value = "/exportCourtCaseData", method = { RequestMethod.GET, RequestMethod.POST })
	public String exportCourtCasePage(Model model, HttpServletRequest request,
			@ModelAttribute("pageSizeTotal") String pageSizeTotal, @ModelAttribute("writNo") String writNo,
			@ModelAttribute("caseStatus") String caseStatus, @ModelAttribute("petitionerName") String petitionerName,
			@ModelAttribute("caseType") String caseType, @ModelAttribute("year") String year, @ModelAttribute("aDvtNo") String aDvtNo,
			@ModelAttribute("hearingDate") String hearingDate)  throws Exception {
		
		
		try{
			CourtCaseDetails courtCaseDetailsObj = new CourtCaseDetails();
		ExtendedPaginatedList paginatedList = getPaginatedListFromRequest(request);
			
		if (CommonUtils.isNotEmpty(hearingDate)&& !hearingDate.contains("Search by Hearing Date...")) {
			List<HearingDetails> list = new ArrayList<HearingDetails>();
			HearingDetails pet = new HearingDetails();
			pet.setDate(DateFormatterUtility.stringtoDateConversion(hearingDate, "dd/MM/yyyy"));
			list.add(pet);
			courtCaseDetailsObj.setHearingDetailsList(list);
		}
		if(CommonUtils.isNotEmpty(pageSizeTotal)){
			paginatedList.setPageSize(Integer.parseInt(pageSizeTotal));
		}
		
		if (CommonUtils.isNotEmpty(writNo)) {
			if (writNo.contains("Search Case No...")) {
			} else {
				courtCaseDetailsObj.setWritNo(Integer.parseInt(writNo));
			}
		}
		if (CommonUtils.isNotEmpty(caseStatus)) {
			courtCaseDetailsObj.setCaseStatus(caseStatus);
		}
		if (CommonUtils.isNotEmpty(caseType)) {
			courtCaseDetailsObj.setCaseType(caseType);
		}
		if (CommonUtils.isNotEmpty(year)) {
			courtCaseDetailsObj.setYear(year);
		}
		if (CommonUtils.isNotEmpty(petitionerName)&& !petitionerName.contains("Search by Petitioner name...")) {
			List<PetitionerDetails> petitionerDetailsList = new ArrayList<PetitionerDetails>();
			PetitionerDetails pet = new PetitionerDetails();
			pet.setName(petitionerName);
			petitionerDetailsList.add(pet);
			courtCaseDetailsObj.setPetitionerDetailsList(petitionerDetailsList);
		}
        if (CommonUtils.isNotEmpty(aDvtNo)&& !aDvtNo.contains("Search Advertisement Number...")) {
			
			Police advt = new Police();
			advt.setaDvtNo(aDvtNo);
			courtCaseDetailsObj.setPoliceDetailsObj(advt);
		}
		
		paginatedList = courtCaseService.getAllCourtCaseData(courtCaseDetailsObj, paginatedList);
		model.addAttribute("allCourtCaseDataList", paginatedList);
		model.addAttribute("pageSizeTotal", paginatedList.getTotalNumberOfRows());
		model.addAttribute("pageSize", paginatedList.getPageSize());
		if (!writNo.contains("Search Writ No...")&& !writNo.equalsIgnoreCase("")) {
		model.addAttribute("writNoForDropDown",Integer.parseInt(writNo)); }
		model.addAttribute("caseStatusForDropDown",caseStatus);
		model.addAttribute("hearingDateForDropDown", hearingDate);
		model.addAttribute("petitionerName",petitionerName);
		model.addAttribute("caseTypeForDropDown",caseType);
		model.addAttribute("advtForDropdown",aDvtNo);
		model.addAttribute("yearForDropDown",year);
		}catch(Exception e){
			logger.logError("courtCaseSearch", "exception while searching details", e);	
		}
		return "exportPageForCourtCase";
	}
	
	
	@RequestMapping(value = "dashboardForCourtCase", method = {RequestMethod.GET,RequestMethod.POST})
	public String getDashboardCourtCase(Model model, HttpSession session,@ModelAttribute("deptId") String deptId,@ModelAttribute("departId") String departId,
		@ModelAttribute("nameOfPost") String nameOfPost,@ModelAttribute("caseStatus") String caseStatus,@ModelAttribute("caseStatusForImpact") String caseStatusForImpact,
		@ModelAttribute("year") String year,@ModelAttribute("legalIssueyear") String legalIssueyear,@ModelAttribute("legalIssue") String legalIssue,
		@ModelAttribute("advtNo") String advtNo,@ModelAttribute("cAtNo") String cAtNo, @ModelAttribute("departIdForLegal") String departIdForLegal) throws Exception {
		try{
			
		List<CourtCaseDetails> disposedOfCount=new ArrayList<CourtCaseDetails>();
		List<CourtCaseDetails> dismissedCount=new ArrayList<CourtCaseDetails>();
		List<CourtCaseDetails> allowedCount=new ArrayList<CourtCaseDetails>();
		List<CourtCaseDetails> inProcessCourtCount=new ArrayList<CourtCaseDetails>();
		List<CourtCaseDetails> admittedCount=new ArrayList<CourtCaseDetails>();
		
		List<CourtCaseDetails> allCourtCaseDataList=courtCaseService.getAllCourtCaseDataListForCount();
		 
		if(CommonUtils.isNotEmpty(allCourtCaseDataList)){
			for(CourtCaseDetails ccd: allCourtCaseDataList){
				if(CommonUtils.isNotEmpty(ccd.getCaseStatus())){
				if(ccd.getCaseStatus().equalsIgnoreCase("Disposed Off")){
					disposedOfCount.add(ccd);	
				}
				if(ccd.getCaseStatus().equalsIgnoreCase("Dismissed")){
					dismissedCount.add(ccd);
				}
				if(ccd.getCaseStatus().equalsIgnoreCase("Allowed")){
					allowedCount.add(ccd);
				}
				if(ccd.getCaseStatus().equalsIgnoreCase("In Process(In Hearing)")){
					inProcessCourtCount.add(ccd);
				}
				if(ccd.getCaseStatus().equalsIgnoreCase("Admitted")){
					admittedCount.add(ccd);
				}
				}
			}
		}
	/*---------------------------------------------Graphs-----------------------------------------*/
	List<String> uniqueYearList=courtCaseService.getUniqueYearList();	
	List<YearWiseCountHelper> yearWiseCountList=courtCaseService.getyearWiseCountList(uniqueYearList,deptId,nameOfPost,caseStatus);	
	List<DepartmentWiseCountHelper> deptWiseCount=courtCaseService.getdeptWiseCount(year,legalIssue);
	List<ImpactGraphHelper> impactGraphCountList=courtCaseService.getImpactGraphCount(advtNo,cAtNo,departId,caseStatusForImpact);
	List<ImpactGraphHelper> impactGraphLegalIssueCountList=courtCaseService.getImpactGraphLegalIssueCount(legalIssueyear,departIdForLegal);
	List<Department> deptList=baseDataService.getDepartmentList();
	List<String> uniqueNameOfPost=baseDataService.getUniqueNameOfPostList();
	List<String> uniqueStatusList=courtCaseService.getUniqueStatusList();
	List<String> uniqueLegalIssuesList=courtCaseService.getUniqueLegalIssuesList();
	List<String> uniqueAdvtList=courtCaseService.getUniqueAdvtList();
	List<String> uniqueCatNoList=courtCaseService.getuniqueCatNoList();
	model.addAttribute("cAtNoForDropDown",cAtNo);
	model.addAttribute("uniqueCatNoList",uniqueCatNoList);
	model.addAttribute("uniqueAdvtList",uniqueAdvtList);
	model.addAttribute("advtNoForDropDown",advtNo);
	 if(CommonUtils.isNotEmpty(impactGraphCountList)) {
		 model.addAttribute("impactGraphCountList",impactGraphCountList);
	 }
	 else {
	     model.addAttribute("failedImapactGraph","nothing found to display");
	 }
	 if(CommonUtils.isNotEmpty(impactGraphLegalIssueCountList)) {
	    model.addAttribute("impactGraphLegalIssueCountList",impactGraphLegalIssueCountList);
	 }
	 else {
		 model.addAttribute("failedLegalIssueImpactgraph","nothing found to display");
	 }
	
	if(CommonUtils.isNotEmpty(deptWiseCount)) {
      model.addAttribute("deptWiseCount",deptWiseCount);
	}
	else {
		 model.addAttribute("failedDepartment","nothing found to display");
	}
      if(CommonUtils.isNotEmpty(yearWiseCountList)) {
	     model.addAttribute("yearWiseCountList",yearWiseCountList);
	 }
	 else {
		 model.addAttribute("failed","nothing found to display");
	 }
    model.addAttribute("deptListForDropDown",deptList);
	model.addAttribute("uniqueYearList",uniqueYearList);
	model.addAttribute("uniqueYearListForLegalGraph",uniqueYearList);
	model.addAttribute("uniqueLegalIssuesList",uniqueLegalIssuesList);
	model.addAttribute("uniqueStatusList",uniqueStatusList);
	model.addAttribute("uniqueNameOfPostList",uniqueNameOfPost);
	model.addAttribute("nameOfPostForDropDown",nameOfPost);
	model.addAttribute("caseStatusForDropDown",caseStatus);
	model.addAttribute("caseStatusForImpactDropDown",caseStatusForImpact);
	model.addAttribute("legalIssueForDropDown",legalIssue);
	model.addAttribute("yearForDropDown",year);
	model.addAttribute("yearForLegalGraphDropDown",legalIssueyear);
	if(CommonUtils.isNotEmpty(deptId) && !deptId.contains("Department...")) {
	model.addAttribute("deptDropDown",Integer.parseInt(deptId));
	}
	if(CommonUtils.isNotEmpty(departId) && !departId.contains("Department...")) {
		model.addAttribute("deptDropDownForImpactGraph",Integer.parseInt(departId));
		}
	if(CommonUtils.isNotEmpty(departIdForLegal) && !departIdForLegal.contains("Department...")) {
		model.addAttribute("deptDropDownForImpactLegalGraph",Integer.parseInt(departIdForLegal));
		}
	
	/*---------------------------------------------Graphs-----------------------------------------*/
		
		model.addAttribute("disposedOfCount",disposedOfCount);
		model.addAttribute("dismissedCount",dismissedCount);
		model.addAttribute("allowedCount",allowedCount);
		model.addAttribute("inProcessCourtCount",inProcessCourtCount);
		model.addAttribute("admittedCount",admittedCount);
		model.addAttribute("allCourtCaseDataList",allCourtCaseDataList);
	}catch(Exception e){
		logger.logError("getDashboardCourtCase", "exception while login", e);
	}
		
		return "courtCaseDashboard";
	
	}
  	
	 @RequestMapping(value="uniqueAdvtWithNoOfCases", method= {RequestMethod.GET,RequestMethod.POST})
	 private String uniqueAdvtWithNoOfCases(Model model) {
		 try {
			  List<DepartmentVO> uniqueAdvtListWithCases=courtCaseService.getUniqueAdvtWithCasesList();
			  model.addAttribute("uniqueAdvtListWithCases",uniqueAdvtListWithCases);
		 }catch(Exception e) {
			 logger.logError("uniqueAdvtWithNoOfCases", "exception while getting Unique Advt and their Cases", e);
		 }
		 return "uniqueAdvtWithCases";
	 }
	
}
