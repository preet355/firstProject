package in.hkcl.db;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.displaytag.properties.SortOrderEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.hkcl.model.ExamCenterAllocation;
import in.hkcl.model.ExamCenterDetails;
import in.hkcl.model.ExamDetails;
import in.hkcl.model.ExamInvigilatorsDetails;
import in.hkcl.pagination.ExtendedPaginatedList;
import in.hkcl.pagination.PaginatedListImpl;
import in.hkcl.service.ExamDataService;
import in.hkcl.utils.ApplicationLogFactory;
import in.hkcl.utils.ApplicationLogger;
import in.hkcl.utils.CommonUtils;

@Controller
public class ExamCenterController {
	
	@Autowired
	ExamDataService examDataService;
	
	
private static ApplicationLogger logger = ApplicationLogFactory.getLogger(ExamCenterController.class);
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	
	private static final String EXAMS_DETAILS="examsDetails";
	private static final String EXAM_CENTER_LIST="examCenterList";
	private static final String EXAM_INVIGILATOR_LIST="examInvigilatorList";
	private static final String EXAM_CENTER_ALLOCATION="examCenterAllocation";
	private static final String ALLOCATION_LIST="allocationList";
	private static final String CENTER_ALLOTMENT_LIST="centerAllotmentList";
	
	private ExtendedPaginatedList getPaginatedListFromRequest(HttpServletRequest request) {
		int pageSize = 10;
		String thePage = null;
		String sortCriterion = null;
		ExtendedPaginatedList paginatedList = new PaginatedListImpl();
		if (request != null) {
			sortCriterion = request.getParameter(ExtendedPaginatedList.IRequestParameters.SORT);
			paginatedList.setSortDirection(ExtendedPaginatedList.IRequestParameters.DESC.equals(
					request.getParameter(ExtendedPaginatedList.IRequestParameters.DIRECTION)) ? SortOrderEnum.DESCENDING
							: SortOrderEnum.ASCENDING);
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

	@SuppressWarnings("unchecked")
	@RequestMapping(value = EXAMS_DETAILS, method = { RequestMethod.GET, RequestMethod.POST })
	public String examsDetails(ModelMap model, @ModelAttribute("examId") String examId,String response, HttpSession session, HttpServletRequest request) {
		try {	
			final ExtendedPaginatedList pageList = examDataService.getAllExams(getPaginatedListFromRequest(request));
			
			if(CommonUtils.isNotEmpty(examId)) {
				if(CommonUtils.isNotEmpty(pageList)) {
					for(ExamDetails obj:(List<ExamDetails>) pageList.getList()) {
						if(Integer.parseInt(examId)==obj.getExamId().intValue()) {
							obj.setBgcolor("#c1dee7;");
						}
					}
				}
			}
			model.addAttribute("examList", pageList);
		
		} catch (Exception e) {
			logger.logError("examsDetails", "Error while getting exams details", e);
		}
		return EXAMS_DETAILS;
	}

	@RequestMapping(value = EXAM_CENTER_LIST, method = { RequestMethod.GET, RequestMethod.POST })
	public String examCenterList(ModelMap model,String response, HttpSession session, HttpServletRequest request,
			@ModelAttribute("examId") String examId) {
		try {	
			List<ExamCenterDetails> examCenterList=examDataService.getExamCenterList(Integer.parseInt(examId));
			model.addAttribute("examCenterList", examCenterList);
		} catch (Exception e) {
			logger.logError("examCenterList", "Error while getting exam center details", e);
		}
		return EXAM_CENTER_LIST;
	}
	
	@RequestMapping(value = EXAM_INVIGILATOR_LIST, method = { RequestMethod.GET, RequestMethod.POST })
	public String examInvigilatorList(ModelMap model,String response, HttpSession session, HttpServletRequest request,
			@ModelAttribute("examId") String examId) {
		try {	
			List<ExamInvigilatorsDetails> invigilatorsList=examDataService.getInvigilatorsList(Integer.parseInt(examId));
			model.addAttribute("invigilatorsList", invigilatorsList);
		} catch (Exception e) {
			logger.logError("examInvigilatorList", "Error while getting Invigilator details", e);
		}
		return EXAM_INVIGILATOR_LIST;
	}
	
	
	@RequestMapping(value = EXAM_CENTER_ALLOCATION, method = { RequestMethod.GET, RequestMethod.POST })
	public String examCenterAllocation(ModelMap model,String response, HttpSession session, HttpServletRequest request,
			@ModelAttribute("examId") String examId, RedirectAttributes redirectAttributes) {
		try {	
			examDataService.AllocateInvigilators(Integer.parseInt(examId));
			redirectAttributes.addFlashAttribute("examId", examId);
		} catch (Exception e) {
			logger.logError("examCenterList", "Error while allcating invigilators", e);
		}
		return "redirect:"+EXAMS_DETAILS;
	}
	
	@RequestMapping(value = ALLOCATION_LIST, method = { RequestMethod.GET, RequestMethod.POST })
	public String allocationList(ModelMap model,String response, HttpSession session, HttpServletRequest request,
			@ModelAttribute("examId") String examId, RedirectAttributes redirectAttributes) {
		try {	
			List<ExamCenterAllocation> allocationList=examDataService.getAllocationList(Integer.parseInt(examId));
			model.addAttribute("allocationList", allocationList);
		} catch (Exception e) {
			logger.logError("examCenterList", "Error while getting allcation data", e);
		}
		return ALLOCATION_LIST;
	}
	
	
	@RequestMapping(value = CENTER_ALLOTMENT_LIST, method = { RequestMethod.GET, RequestMethod.POST })
	public String centerAllotmentList(ModelMap model,String response, HttpSession session, HttpServletRequest request,
			@ModelAttribute("examId") String examId, RedirectAttributes redirectAttributes) {
		try {	
			ExamDetails examObj=examDataService.getCenterAllotmentData(Integer.parseInt(examId));
			model.addAttribute("examObj", examObj);
		} catch (Exception e) {
			logger.logError("centerAllotmentList", "Error while getting Center Allotment List", e);
		}
		return CENTER_ALLOTMENT_LIST;
	}
}
