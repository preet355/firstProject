package in.hkcl.db;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.displaytag.properties.SortOrderEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import in.hkcl.dao.BaseDataDao;
import in.hkcl.dao.CourtCaseDao;
import in.hkcl.model.CMDashboardJSONRequestData;
import in.hkcl.model.CountHelper;
import in.hkcl.model.Department;
import in.hkcl.model.DepartmentDocs;
import in.hkcl.model.DepartmentVO;
import in.hkcl.model.EmailLogs;
import in.hkcl.model.EmailTemplate;
import in.hkcl.model.HearingDateGraphHelper;
import in.hkcl.model.HsscConfig;
import in.hkcl.model.NextStepsAdvt;
import in.hkcl.model.Notifications;
import in.hkcl.model.PasswordResetToken;
import in.hkcl.model.Police;
import in.hkcl.model.RequisitionInfo;
import in.hkcl.model.SmsReceivers;
import in.hkcl.model.UserEditLogsMIS;
import in.hkcl.model.UserHistory;
import in.hkcl.model.UserLogin;
import in.hkcl.pagination.ExtendedPaginatedList;
import in.hkcl.pagination.PaginatedListImpl;
import in.hkcl.service.BaseDataService;
import in.hkcl.service.CourtCaseService;
import in.hkcl.service.EmailService;
import in.hkcl.service.RequisitionService;
import in.hkcl.smsIntegration.SmsSender;
import in.hkcl.utils.ApplicationLogFactory;
import in.hkcl.utils.ApplicationLogger;
import in.hkcl.utils.CommonUtils;

@Controller
public class MISController {

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
	
	@Autowired
	RequisitionService requisitionService;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	SmsSender smsSender;
	
	
	private static ApplicationLogger logger = ApplicationLogFactory.getLogger(MISController.class);
	
	List<CountHelper> cnthlprForAplOpenListGlobal=new ArrayList<CountHelper>();
	List<CountHelper> cnthlprForWrtnExmListGlobal=new ArrayList<CountHelper>();
	List<CountHelper> cnthlprForScrutinyListGlobal=new ArrayList<CountHelper>();
	List<CountHelper> cnthlprForInterviewListGlobal=new ArrayList<CountHelper>();
	List<CountHelper> cnthlprForRecommendListGlobal=new ArrayList<CountHelper>();

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "login";
	}

	@ModelAttribute
	public void setDropDownValues(Model model, HttpServletRequest request, HttpSession session) {
		try {
			List<UserEditLogsMIS> userMISLogObj= baseDataService.getMISLastUpdateTime();
			List<Department> departmentList = baseDataService.loadAllDepartments();
			model.addAttribute("deptList", departmentList);
			Integer dEpartmentId = (Integer) session.getAttribute("idDept");
			   if(CommonUtils.isNotEmpty(dEpartmentId)) {
				   List<Department> deptList= baseDataService.getDepartmentList();
				     if(CommonUtils.isNotEmpty(deptList)) {
				    	 for(Department obj:deptList) {
				    		 if(obj.getdEpartmentId().equals(dEpartmentId)) {
				    			 String deptInfo=obj.getdEpartment();
				    			 model.addAttribute("deptInfo",deptInfo);
				    		 }
				    	 }
				     }
			   }
			List<NextStepsAdvt> allNextSteps=baseDataService.getAllNextSteps();
			List<String> allHsscPostListForADVTNO = baseDataService.getDistinctAdvtNo(dEpartmentId);
			List<String> allHsscNextStepList = baseDataService.getDistinctNextStep(dEpartmentId);
			List<Police> allHsscPostListForDept = baseDataService.getAllHsscPostListForDept(dEpartmentId);
			List<Police> allDistinctPostName=baseDataService.getAllDistinctPostName();
			model.addAttribute("allHsscNextStepList", allHsscNextStepList);
			model.addAttribute("allHsscPostListForDeptForSearch", allHsscPostListForDept);
			model.addAttribute("allDistinctPostName", allDistinctPostName);
			model.addAttribute("allHsscPostListForADVTNOForSearch", allHsscPostListForADVTNO);
			model.addAttribute("userMISLogObj",userMISLogObj);
			model.addAttribute("allNextSteps",allNextSteps);
		} catch (Exception e) {
			logger.logError("setDropDownValues", "exception while getting drop down data", e);
		}

	}
	
	@ModelAttribute
	public void getNotificationForDepartment(Model model, HttpServletRequest request, HttpSession session) throws Exception
	{  
		Integer notificationCount=0;
		Integer dEpartmentId = (Integer) session.getAttribute("idDept");
		List<Notifications> allNotifications =requisitionService.getAllNotificationsByDepartment(dEpartmentId);
		 if(CommonUtils.isNotEmpty(allNotifications)) {
		 for(Notifications n:allNotifications) {
			 if(n.isReadUnreadStatus()==false) {
				 notificationCount=notificationCount+1;
			 }
		 }
		 Collections.reverse(allNotifications);
	  }
		model.addAttribute("allNotifications",allNotifications);
		model.addAttribute("notificationCount",notificationCount);
	}


@SuppressWarnings("unchecked")
       @RequestMapping(value = "/allHSSCPostname", method = { RequestMethod.GET, RequestMethod.POST })
       public String getFrontPage(UserLogin user, Model model, HttpServletRequest request, HttpSession session,
                     @ModelAttribute("nAmeOfPost") String nAmeOfPost, @ModelAttribute("aDvtNo") String aDvtNo,
                     @ModelAttribute("mAcroStatus") String mAcroStatus, @ModelAttribute("dEpartmentId") String dEpartmentId,
                     @ModelAttribute("nExtStep") String nExtStep, @ModelAttribute("pageSizeTotal") String pageSizeTotal,
                     @ModelAttribute("pagination") String pagination,@ModelAttribute("sort") String sort,
                     @ModelAttribute("sortDirection") String sortDirection)
                     throws Exception {
              try {
                     Integer totalCountOfPost=0;
                     long totalNoOfPosts=0;
                     Integer sessionDepart = (Integer) session.getAttribute("idDept");
                     List<Department> departmentNameListObj = new ArrayList<Department>();

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
                     
                     Police searcPolice = new Police();
                     searcPolice.setnAmeOfPost(nAmeOfPost);
                     searcPolice.setaDvtNo(aDvtNo);
                     searcPolice.setmAcroStatus(mAcroStatus);
                     searcPolice.setnExtStep(nExtStep);
                     if (CommonUtils.isEmpty(sessionDepart)) {
                           if (CommonUtils.isNotEmpty(dEpartmentId) && !dEpartmentId.contains("Search Department...")) {
                                  searcPolice.setdEpartmentId(Integer.parseInt(dEpartmentId));
                           }
                     }

                     paginatedList = baseDataService.getAllPostData(sessionDepart, searcPolice, paginatedList);
                     model.addAttribute("allHsscPostListForDept", paginatedList);
                     if (CommonUtils.isNotEmpty(paginatedList)) {
                           
                           model.addAttribute("pageSize", paginatedList.getPageSize());
                           List<Police> allHsscPostListForDept = paginatedList.getList();
                           model.addAttribute("deptName", allHsscPostListForDept.get(0).getDeptObj().getdEpartment());
                     }
                     
                     List<DepartmentVO> policeObj=baseDataService.getAllRequisitionData(sessionDepart,searcPolice);
                     
                     for(DepartmentVO d:policeObj) {
                           totalCountOfPost=totalCountOfPost+1;
                           totalNoOfPosts=totalNoOfPosts+d.getnOOfPosts();
                     }

                     model.addAttribute("totalCountOfPost",totalCountOfPost);
                     model.addAttribute("totalNoOfPosts",totalNoOfPosts);
                     model.addAttribute("departmentNameListObj", departmentNameListObj);
                     model.addAttribute("pageSizeTotal", paginatedList.getTotalNumberOfRows());
                     model.addAttribute("nAmeOfPost", nAmeOfPost);
                     model.addAttribute("aDvtNo", aDvtNo);
                     model.addAttribute("mAcroStatus", mAcroStatus);
                     model.addAttribute("dEpartmentId", dEpartmentId);
                     model.addAttribute("nExtStep", nExtStep);

              } catch (Exception e) {
                     logger.logError("getDash", "exception while getting AllPostData", e);
              }

              return "allHSSCPostname";

       }

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/exportContents", method = { RequestMethod.GET, RequestMethod.POST })
	public String exportContents(UserLogin user, Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("nAmeOfPost") String nAmeOfPost, @ModelAttribute("aDvtNo") String aDvtNo,
			@ModelAttribute("mAcroStatus") String mAcroStatus, @ModelAttribute("dEpartmentId") String dEpartmentId,
			@ModelAttribute("nExtStep") String nExtStep, @ModelAttribute("pageSizeTotal") String pageSizeTotal,
			@ModelAttribute("toformat") String format) throws Exception {
		try {
			Integer sessionDepart = (Integer) session.getAttribute("idDept");
			List<Department> departmentNameListObj = new ArrayList<Department>();

			ExtendedPaginatedList paginatedList = getPaginatedListFromRequest(request);
			if (CommonUtils.isNotEmpty(pageSizeTotal)) {
				paginatedList.setPageSize(Integer.parseInt(pageSizeTotal));
			}

			Police searcPolice = new Police();
			searcPolice.setnAmeOfPost(nAmeOfPost);
			searcPolice.setaDvtNo(aDvtNo);
			searcPolice.setmAcroStatus(mAcroStatus);
			searcPolice.setnExtStep(nExtStep);
			if (CommonUtils.isEmpty(sessionDepart)) {
				
				if (CommonUtils.isNotEmpty(dEpartmentId)) {
					searcPolice.setdEpartmentId(Integer.parseInt(dEpartmentId));
				}
			}

			paginatedList = baseDataService.getAllPostData(sessionDepart, searcPolice, paginatedList);
			model.addAttribute("allHsscPostListForDept", paginatedList);
			if (CommonUtils.isNotEmpty(paginatedList)) {
				model.addAttribute("pageSize", paginatedList.getPageSize());
				List<Police> allHsscPostListForDept = paginatedList.getList();
				model.addAttribute("deptName", allHsscPostListForDept.get(0).getDeptObj().getdEpartment());
			}

			model.addAttribute("departmentNameListObj", departmentNameListObj);
			model.addAttribute("pageSizeTotal", paginatedList.getTotalNumberOfRows());
			model.addAttribute("nAmeOfPost", nAmeOfPost);
			model.addAttribute("aDvtNo", aDvtNo);
			model.addAttribute("mAcroStatus", mAcroStatus);
			model.addAttribute("dEpartmentId", dEpartmentId);
			model.addAttribute("nExtStep", nExtStep);

		} catch (Exception e) {
			logger.logError("getDash", "exception while getting AllPostData", e);
		}

		if (format.contains("Excel")) {
			return "popUpExcel";
		} else {
			return "popUp";
		}

	}

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

	@RequestMapping(value = "/showPostDetails", method = { RequestMethod.GET, RequestMethod.POST })
	public String getPostDetails(Model model, @ModelAttribute("srNo") Integer srNo, @ModelAttribute("error") String error) throws Exception {
		List<Police> postDetailsList = baseDataService.getPostDetails(srNo);
		String deptName = postDetailsList.get(0).getDeptObj().getdEpartment();
		model.addAttribute("postDetailsList", postDetailsList);
		model.addAttribute("deptName", deptName);
		model.addAttribute("error",error);

		return "stepWiseDetailsShow";
	}

	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			model.put("UserData", new UserLogin());
			return "login";
		} else {
			return "login";
		}
	}*/

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginFailed(Model model, UserLogin userData) {
		model.addAttribute("error", true);
		model.addAttribute("loginAttribute", userData);
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model, HttpSession session) throws Exception {
		UserLogin sessionDepart = (UserLogin) session.getAttribute("user");
		UserHistory userHisObj=new UserHistory();
	    userHisObj.setUserId(sessionDepart.getUserId());
	    userHisObj.setLoggedOutTime(new Date());
	    baseDataService.saveLogOutHistory(userHisObj);
		session.removeAttribute("user");
		model.put("Success", "Logged out Successfully");
		return "login";
	}

	@RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
	public String doLogin(ModelMap model, @ModelAttribute("UserData") UserLogin verifiedUser, @ModelAttribute("browserNameAndVersion") String browserNameAndVersion,  HttpSession session,
			HttpServletRequest request) throws Exception {
		UserLogin user = new UserLogin();
		try {
			if (verifiedUser.getEmail() != null && verifiedUser.getUserPassword() != null
					&& request.getSession(true).getAttribute("verifiedUser") == null) {
				user = baseDataDao.loginUser(verifiedUser);
				if (user == null) {
					model.put("failed", "Email or Password Incorrect");
					model.addAttribute("userData", user);
					return "login";
				} else {
					UserLogin userEnable = baseDataDao.getVerifiedUser(user.getEmail());
					  if(CommonUtils.isNotEmpty(userEnable.getIdDept())) {
						  Department deptObj=baseDataService.getdepartmentByDepartmentId(userEnable.getIdDept());
						  user.setHasSpe(deptObj.isHasSpe());
					  }
					user.setEnabled(userEnable.isEnabled());
					user.setIdDept(userEnable.getIdDept());
					user.setIsAdmin(userEnable.getIsAdmin());
					user.setIdRole(userEnable.getIdRole());
					user.setModule(userEnable.getModule());
					user.setUserId(userEnable.getUserId());
		
				}

				if (user.isEnabled() == false) {
					model.put("failed", "Entries on HSSC Requisition Module have been withheld till further notice");
					model.addAttribute("userData", user);
					return "login";
				} else {
					//smsSender.sendSms();
					request.getSession(true).setAttribute("user", user);
					request.getSession(true).setAttribute("idDept", user.getIdDept());
					request.getSession(true).setAttribute("IsAdmin", user.getIsAdmin());
					request.getSession(true).setAttribute("module", user.getModule());
					request.getSession(true).setAttribute("userId", user.getUserId());
					String username = user.getUserName();
					model.put("Welcome", username);
					 
				    UserHistory userHisObj=new UserHistory();
				    userHisObj.setUserId(user.getUserId());
 					userHisObj.setLoggedInTime(new Date());
 					userHisObj.setBrowserNameAndVersion(browserNameAndVersion);
 					
 					baseDataService.saveLoginHistory(userHisObj);
 					
 					
					if (user.getModule().contains("mis")) {
						return "redirect:dashboard";
					}
					else if(user.getModule().contains("req")) {
						return "redirect:requisitionDashboard";
					}  
					else {
						return "redirect:dashboardForCourtCase";
					}

				}
			} else {

				System.out.println("previous session is not closed yet");

				if (user.getModule().contains("mis")) {

					return "redirect:dashboard";
				}else if(user.getModule().contains("req")) {
					return "redirect:requisitionDashboard";
				} 
				else {
					return "redirect:dashboardForCourtCase";
				}

			}

		} catch (Exception e) {
			logger.logError("loginUser", "exception while login to department", e);
		}

		if (user.getModule() == "mis") {

			return "redirect:dashboard";
		} else {
			return "redirect:dashboardForCourtCase";
		}

	}

	@RequestMapping(value = "contact", method = RequestMethod.GET)
	public String getContact(Model model) {

		return "contact";
	}

	@RequestMapping(value = "dashboard", method = {RequestMethod.GET,RequestMethod.POST})
	public String getDashboard(Model model, HttpSession session, HttpServletRequest request,@ModelAttribute("mAcroStatus") String mAcroStatus,
			@ModelAttribute("deptId") String deptId,@ModelAttribute("nameOfPost") String nameOfPost,@ModelAttribute("startDate") String startDate,
			@ModelAttribute("endDate") String endDate, @ModelAttribute("deptIdForHearingGraph") String deptIdForHearingGraph,@ModelAttribute("nameOfPostForHearingGraph") String nameOfPostForHearingGraph) {
		try {
			long inProcessTotalNoOfPosts = 0;
			long recommendedTotalNoOfPosts = 0;
			long courtStayTotalNoOfPosts = 0;
			long allTotalNoOfPosts = 0;
			long withdrawnTotalNoOfPost = 0;
			long ProcessHaltedTotalNoOfPost=0;

			session.setAttribute("isExport", "");
			String isAdmin = (String) session.getAttribute("IsAdmin");
			Integer dEpartmentId = (Integer) session.getAttribute("idDept");
			String module = (String) session.getAttribute("module");

			List<Police> recommendedCount = new ArrayList<Police>();
			List<Police> courtStayCount = new ArrayList<Police>();
			List<Police> inProcessCount = new ArrayList<Police>();
			List<Police> withdrawnCount = new ArrayList<Police>();
			List<Police> ProcessHaltedCount = new ArrayList<Police>();

			List<Police> allHsscPostListForDept = baseDataService.getAllHsscPostListForDept(dEpartmentId);
			if (CommonUtils.isNotEmpty(allHsscPostListForDept)) {
				for (Police pol : allHsscPostListForDept) {
					allTotalNoOfPosts = allTotalNoOfPosts + pol.getnOOfPosts();
					if (CommonUtils.isNotEmpty(pol.getmAcroStatus())) {
						if (pol.getmAcroStatus().equalsIgnoreCase("Recommended")) {
							recommendedCount.add(pol);
							recommendedTotalNoOfPosts = recommendedTotalNoOfPosts + pol.getnOOfPosts();
						} else if (pol.getmAcroStatus().equalsIgnoreCase("Court Stay")) {
							courtStayCount.add(pol);
							courtStayTotalNoOfPosts = courtStayTotalNoOfPosts + pol.getnOOfPosts();
						} else if (pol.getmAcroStatus().equalsIgnoreCase("In Process")) {
							inProcessCount.add(pol);
							inProcessTotalNoOfPosts = inProcessTotalNoOfPosts + pol.getnOOfPosts();
						} else if (pol.getmAcroStatus().equalsIgnoreCase("Withdrawn")) {
							withdrawnCount.add(pol);
							withdrawnTotalNoOfPost = withdrawnTotalNoOfPost + pol.getnOOfPosts();
						}else if (pol.getmAcroStatus().equalsIgnoreCase("Process Halted")) {
							ProcessHaltedCount.add(pol);
							ProcessHaltedTotalNoOfPost = ProcessHaltedTotalNoOfPost + pol.getnOOfPosts();
						}
					}
				}
			}
			
			List<RequisitionInfo> allRequisitiondata=requisitionService.getAllRequisitioData(dEpartmentId);
			 Integer totalRequisitionCount=0;
			 Integer totalApprovedCount=0;
			 long totalApprovedNoOfPostsCount=0;
			 long totalRequisitionNoOFPostsCount=0;
		      for(RequisitionInfo r:allRequisitiondata) {
		    	  if(r.getStatus().equalsIgnoreCase("saved")) {
		    	  totalRequisitionNoOFPostsCount=totalRequisitionNoOFPostsCount+r.getNumberOfPostToBeFilled();
		    	  totalRequisitionCount=totalRequisitionCount+1;
		    	  }
		    	  if(r.getStatus().equalsIgnoreCase("approved")) {
		    		  totalApprovedCount=totalApprovedCount+1;
		    		  totalApprovedNoOfPostsCount=totalApprovedNoOfPostsCount+r.getNumberOfPostToBeFilled();
		    	  }
		      }
		      model.addAttribute("totalApprovedCount",totalApprovedCount);
		      model.addAttribute("totalRequisitionCount",totalRequisitionCount);
		      model.addAttribute("totalRequisitionNoOFPostsCount",totalRequisitionNoOFPostsCount);
		      model.addAttribute("totalApprovedNoOfPostsCount",totalApprovedNoOfPostsCount);
/*-----------------------------------------------Requisition NextStep Graph Start-----------------------------------------------------*/
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
			 String d1=null,d2=null;
			  if(CommonUtils.isNotEmpty(startDate)) {
			   d1 = sdf1.format(sdf2.parse(startDate));
			  }
			  if(CommonUtils.isNotEmpty(endDate)) {
			   d2= sdf1.format(sdf2.parse(endDate));
			  }
			List<Police> HsscPostList = baseDataService.getHsscPostList(deptId,mAcroStatus,nameOfPost,d1,d2);
	
			
			int joiningCount = 0, advtPostedCount = 0, applicationOpenCount = 0, applicationClosedCount = 0;
			int admitCardsCount = 0, pstStartCount = 0, pstEndCount = 0, pstResultCount = 0;
			int writtenExamCount = 0, uploadAnsKeyCount = 0, objectionOpenCount = 0, objectionClosedCount = 0;
			int uploadRevisedAnsKeyCount = 0, resultOfWrittenExamCount = 0, scrutinyCount = 0, scrutinyResultCount = 0;
			int pmtHeightChestCount = 0, admitCardsForInterviewCount = 0, announcementOfFinalResultCount = 0;
			int recommendCount = 0, interviewsCount = 0;
			long announcemntOfFinlResNoOfPostCount = 0, RecNoOfPostCount = 0, IntrNoOfPostCount = 0,
					admtCardForIntrNoOfPostCount = 0, pmtHeightChestNoOfPostCount = 0, scrutinyResNoOfPostCount = 0,
					scrutinyNoOfPostCount = 0, resOfWrtnExamNoOfPostCount = 0, uplRevAnskeyNoOfPostCount = 0,
					objectionCloseNoOfPostCount = 0, objectionOpenNoOfPostCount = 0, uplAnsKeyNoOfPostCount = 0,
					wrtnExmNoOfPostCount = 0, resultOfPstNoOfPostCount = 0, pstEndNoOfPostCount = 0,
					pstStrtNoOfPostCount = 0, admtCardNoOfPostCount = 0, aplCloseNoOfPostCount = 0,
					aplOpenNoOfPostCount = 0, advtPostdNoOfPostCount = 0, joiningNoOfPostCount = 0;
			if (CommonUtils.isNotEmpty(HsscPostList)) {
				for (Police p : HsscPostList) {
					if (CommonUtils.isNotEmpty(p.getnExtStep())) {
						if (p.getnExtStep().equalsIgnoreCase("Joining")) {
							joiningCount = joiningCount + 1;
							joiningNoOfPostCount = joiningNoOfPostCount + p.getnOOfPosts();
						}
						if (p.getnExtStep().equalsIgnoreCase("Advertisement Posted")) {
							advtPostedCount = advtPostedCount + 1;
							advtPostdNoOfPostCount = advtPostdNoOfPostCount + p.getnOOfPosts();
						}
						if (p.getnExtStep().equalsIgnoreCase("Applications Open")) {
							applicationOpenCount = applicationOpenCount + 1;
							aplOpenNoOfPostCount = aplOpenNoOfPostCount + p.getnOOfPosts();
						}
						if (p.getnExtStep().equalsIgnoreCase("Applications Close")) {
							applicationClosedCount = applicationClosedCount + 1;
							aplCloseNoOfPostCount = aplCloseNoOfPostCount + p.getnOOfPosts();
						}
						if (p.getnExtStep().equalsIgnoreCase("Admit Cards")) {
							admitCardsCount = admitCardsCount + 1;
							admtCardNoOfPostCount = admtCardNoOfPostCount + p.getnOOfPosts();
						}
						if (p.getnExtStep().equalsIgnoreCase("PST Start(For Police only)")) {
							pstStartCount = pstStartCount + 1;
							pstStrtNoOfPostCount = pstStrtNoOfPostCount + p.getnOOfPosts();
						}
						if (p.getnExtStep().equalsIgnoreCase("PST End(For Police only)")) {
							pstEndCount = pstEndCount + 1;
							pstEndNoOfPostCount = pstEndNoOfPostCount + p.getnOOfPosts();
						}
						if (p.getnExtStep().equalsIgnoreCase("Result of PST(For Police only)")) {
							pstResultCount = pstResultCount + 1;
							resultOfPstNoOfPostCount = resultOfPstNoOfPostCount + p.getnOOfPosts();
						}
						if (p.getnExtStep().equalsIgnoreCase("Written Exam")) {
							writtenExamCount = writtenExamCount + 1;
							wrtnExmNoOfPostCount = wrtnExmNoOfPostCount + p.getnOOfPosts();
						}
						if (p.getnExtStep().equalsIgnoreCase("Uploading Answer Key")) {
							uploadAnsKeyCount = uploadAnsKeyCount + 1;
							uplAnsKeyNoOfPostCount = uplAnsKeyNoOfPostCount + p.getnOOfPosts();
						}
						if (p.getnExtStep().equalsIgnoreCase("Objections Open")) {
							objectionOpenCount = objectionOpenCount + 1;
							objectionOpenNoOfPostCount = objectionOpenNoOfPostCount + p.getnOOfPosts();
						}
						if (p.getnExtStep().equalsIgnoreCase("Objections Close")) {
							objectionClosedCount = objectionClosedCount + 1;
							objectionCloseNoOfPostCount = objectionCloseNoOfPostCount + p.getnOOfPosts();
						}
						if (p.getnExtStep().equalsIgnoreCase("Upload Revised Answer Key")) {
							uploadRevisedAnsKeyCount = uploadRevisedAnsKeyCount + 1;
							uplRevAnskeyNoOfPostCount = uplRevAnskeyNoOfPostCount + p.getnOOfPosts();
						}
						if (p.getnExtStep().equalsIgnoreCase("Result of Written Exam")) {
							resultOfWrittenExamCount = resultOfWrittenExamCount + 1;
							resOfWrtnExamNoOfPostCount = resOfWrtnExamNoOfPostCount + p.getnOOfPosts();
						}
						if (p.getnExtStep().equalsIgnoreCase("Scrutiny")) {
							scrutinyCount = scrutinyCount + 1;
							scrutinyNoOfPostCount = scrutinyNoOfPostCount + p.getnOOfPosts();
						}
						if (p.getnExtStep().equalsIgnoreCase("Scrutiny Results")) {
							scrutinyResultCount = scrutinyResultCount + 1;
							scrutinyResNoOfPostCount = scrutinyResNoOfPostCount + p.getnOOfPosts();
						}
						if (p.getnExtStep().equalsIgnoreCase("PMT Height-Chest (For Police only)")) {
							pmtHeightChestCount = pmtHeightChestCount + 1;
							pmtHeightChestNoOfPostCount = pmtHeightChestNoOfPostCount + p.getnOOfPosts();
						}
						if (p.getnExtStep().equalsIgnoreCase("Admit Cards(for Interview)")) {
							admitCardsForInterviewCount = admitCardsForInterviewCount + 1;
							admtCardForIntrNoOfPostCount = admtCardForIntrNoOfPostCount + p.getnOOfPosts();
						}
						if (p.getnExtStep().equalsIgnoreCase("Interviews")) {
							interviewsCount = interviewsCount + 1;
							IntrNoOfPostCount = IntrNoOfPostCount + p.getnOOfPosts();
						}
						if (p.getnExtStep().equalsIgnoreCase("Recommend")) {
							recommendCount = recommendCount + 1;
							RecNoOfPostCount = RecNoOfPostCount + p.getnOOfPosts();
						}
						if (p.getnExtStep().equalsIgnoreCase("Announcement of Final Result")) {
							announcementOfFinalResultCount = announcementOfFinalResultCount + 1;
							announcemntOfFinlResNoOfPostCount = announcemntOfFinlResNoOfPostCount + p.getnOOfPosts();
						}

					}

				}
			}
			else {
				model.addAttribute("failed","nothing found to display");
			}
//***************************************************** Requisition Next Step Graph Ends ****************************************************
			/*if(CommonUtils.isNotEmpty(allHsscPostListForDept)) {
				for(Police p: allHsscPostListForDept) {
				   List<CourtCaseDetails> allCourtCases=baseDataService.getCourtCasebySNo(p.getsRNo());	
				     for(CourtCaseDetails c: allCourtCases) {
				    	 List<HearingDetails> allHearingDates=courtCaseService.getAllHearingDatesByCaseId(c.getCaseId());
				    	 List<Date> dtList=new ArrayList<Date>();
				    	 for (HearingDetails s : allHearingDates)
						  {	
						    if(CommonUtils.isNotEmpty(s.getDate()))
							 {
							   dtList.add(s.getDate());
						     }
						  }
						   Collections.sort(dtList, Collections.reverseOrder());
						   
				     }
				 }
		     }*/
			
			List<HearingDateGraphHelper> hearingDateWiseGraphData=courtCaseService.getHearingDateGraphData(deptIdForHearingGraph,nameOfPostForHearingGraph);
			Date cal = Calendar.getInstance().getTime();
			int betweenOneMonth=0;
			long betweenOneMonthNoOfPostCount=0;
			int betweenOneToTwoMonth=0;
			long betweenOneToTwoMonthNoOfPostCount=0;
			int betweenThreeToFourMonth=0;
			long betweenThreeToFourMonthNoOfPostCount=0;
			int sixMonthOrMore=0;
			long sixMonthOrMoreNoOfPostCount=0;
			  if(CommonUtils.isNotEmpty(hearingDateWiseGraphData)) {
				  for(HearingDateGraphHelper h: hearingDateWiseGraphData) {
					  Date maxHearingDate=h.getDate();
					  long dateDiff=maxHearingDate.getTime()-cal.getTime();
					  float daysBetween = (dateDiff / (1000 * 60 * 60 * 24));
					   if(daysBetween>0 && daysBetween<=30) {
						   betweenOneMonth=betweenOneMonth+1;
						   betweenOneMonthNoOfPostCount=betweenOneMonthNoOfPostCount+h.getnOOfPosts();
					   }
					   else if(daysBetween>30 && daysBetween<=60) {
						   betweenOneToTwoMonth=betweenOneToTwoMonth+1;
						   betweenOneToTwoMonthNoOfPostCount=betweenOneToTwoMonthNoOfPostCount+h.getnOOfPosts();
					   }
					   else if(daysBetween>60 && daysBetween<=120) {
						   betweenThreeToFourMonth=betweenThreeToFourMonth+1;
						   betweenThreeToFourMonthNoOfPostCount=betweenThreeToFourMonthNoOfPostCount+h.getnOOfPosts();
					   }
					   else {
						   sixMonthOrMore=sixMonthOrMore+1;
						   sixMonthOrMoreNoOfPostCount=sixMonthOrMoreNoOfPostCount+h.getnOOfPosts();
					   }
				  }
				   model.addAttribute("betweenOneMonth",betweenOneMonth);
				   model.addAttribute("betweenOneToTwoMonth",betweenOneToTwoMonth);
				   model.addAttribute("betweenThreeToFourMonth",betweenThreeToFourMonth);
				   model.addAttribute("sixMonthOrMore",sixMonthOrMore);
				   
				   model.addAttribute("betweenOneMonthNoOfPostCount",betweenOneMonthNoOfPostCount);
				   model.addAttribute("betweenOneToTwoMonthNoOfPostCount",betweenOneToTwoMonthNoOfPostCount);
				   model.addAttribute("betweenThreeToFourMonthNoOfPostCount",betweenThreeToFourMonthNoOfPostCount);
				   model.addAttribute("sixMonthOrMoreNoOfPostCount",sixMonthOrMoreNoOfPostCount);
			  }   
			  else {
				  model.addAttribute("failedHearingGraph","nothing found to display");
			  }
			   
//************************************************HearingDates graph ends*****************************************************************			   
			
			List<Department> deptList=baseDataService.getDepartmentList();
			List<String> uniqueNameOfPost=baseDataService.getUniqueNameOfPostList();
			model.addAttribute("startDate",startDate);
			model.addAttribute("endDate",endDate);
			model.addAttribute("uniqueNameOfPostList",uniqueNameOfPost);
			model.addAttribute("nameOfPostForDropDown",nameOfPost);	
			model.addAttribute("nameOfPostForHearingGraphDropDown",nameOfPostForHearingGraph);	
			model.addAttribute("deptListForDropDown",deptList);
			if(!deptId.contains("Department...") && CommonUtils.isNotEmpty(deptId)) {
			model.addAttribute("deptDropDown",Integer.parseInt(deptId));
			}
		
			model.addAttribute("deptDropDownForHearingGraph",deptIdForHearingGraph);
			model.addAttribute("macroForDropDown",mAcroStatus);
			model.addAttribute("announcemntOfFinlResNoOfPostCount", announcemntOfFinlResNoOfPostCount);
			model.addAttribute("RecNoOfPostCount", RecNoOfPostCount);
			model.addAttribute("IntrNoOfPostCount", IntrNoOfPostCount);
			model.addAttribute("admtCardForIntrNoOfPostCount", admtCardForIntrNoOfPostCount);
			model.addAttribute("pmtHeightChestNoOfPostCount", pmtHeightChestNoOfPostCount);
			model.addAttribute("scrutinyResNoOfPostCount", scrutinyResNoOfPostCount);
			model.addAttribute("scrutinyNoOfPostCount", scrutinyNoOfPostCount);
			model.addAttribute("resOfWrtnExamNoOfPostCount", resOfWrtnExamNoOfPostCount);
			model.addAttribute("uplRevAnskeyNoOfPostCount", uplRevAnskeyNoOfPostCount);
			model.addAttribute("objectionCloseNoOfPostCount", objectionCloseNoOfPostCount);
			model.addAttribute("objectionOpenNoOfPostCount", objectionOpenNoOfPostCount);
			model.addAttribute("uplAnsKeyNoOfPostCount", uplAnsKeyNoOfPostCount);
			model.addAttribute("wrtnExmNoOfPostCount", wrtnExmNoOfPostCount);
			model.addAttribute("resultOfPstNoOfPostCount", resultOfPstNoOfPostCount);
			model.addAttribute("pstEndNoOfPostCount", pstEndNoOfPostCount);
			model.addAttribute("pstStrtNoOfPostCount", pstStrtNoOfPostCount);
			model.addAttribute("admtCardNoOfPostCount", admtCardNoOfPostCount);
			model.addAttribute("aplCloseNoOfPostCount", aplCloseNoOfPostCount);
			model.addAttribute("aplOpenNoOfPostCount", aplOpenNoOfPostCount);
			model.addAttribute("advtPostdNoOfPostCount", advtPostdNoOfPostCount);
			model.addAttribute("joiningNoOfPostCount", joiningNoOfPostCount);
/*------------------------------------------------Requisition NextStep Graph End-----------------------------------------------------*/
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			List<Police> policeAllDataList = baseDataService.getAllHsscPostList();
			HashMap<Integer, Police> uniquePoliceMap = new HashMap<Integer, Police>();
			if (CommonUtils.isNotEmpty(policeAllDataList)) {
				for (Police pol : policeAllDataList) {
					if (!uniquePoliceMap.containsKey(pol.getsRNo())) {
						uniquePoliceMap.put(pol.getsRNo(), pol);
					}
				}
			}
			List<CountHelper> cnthlprForAplOpenList = new ArrayList<CountHelper>();
			List<CountHelper> cnthlprForWrtnExmList = new ArrayList<CountHelper>();
			List<CountHelper> cnthlprForScrutinyList = new ArrayList<CountHelper>();
			List<CountHelper> cnthlprForInterviewList = new ArrayList<CountHelper>();
			List<CountHelper> cnthlprForRecommendList = new ArrayList<CountHelper>();

			for (Police pol : uniquePoliceMap.values()) {
				if (CommonUtils.isNotEmpty(pol.getnExtStep())) {

					if (pol.getnExtStep().equalsIgnoreCase("Applications Close")) {
						CountHelper hlpr = new CountHelper();
						int red = 0;
						int yellow = 0;
						hlpr.setCurrentStatus("Admit Cards");
						hlpr.setsRNo(pol.getsRNo());
						hlpr.setAdvtNo(pol.getaDvtNo());
						hlpr.setPostName(pol.getnAmeOfPost());
						hlpr.setCatNo(pol.getcAtNo());
						hlpr.setDeptName(pol.getDeptName());
						if (CommonUtils.isNotEmpty(pol.getApplicationOpenList())
								&& CommonUtils.isNotEmpty(pol.getAdmitCardsList())) {

							Date dateBefore = sdf
									.parse(pol.getApplicationOpenList().get(0).getApplicationopen().toString());
							Date dateAfter = sdf.parse(pol.getAdmitCardsList().get(0).getAdmitcard().toString());
							long difference = dateAfter.getTime() - dateBefore.getTime();
							float daysBetween = (difference / (1000 * 60 * 60 * 24));
							if (daysBetween > 7) {
								red = red + 1;
							} else {
								yellow = yellow + 1;
							}

						} else {
							yellow = yellow + 1;
						}
						hlpr.setRedCount(red);
						hlpr.setYellowCount(yellow);
						cnthlprForAplOpenList.add(hlpr);
					}

					if (pol.getnExtStep().equalsIgnoreCase("Admit Cards")) {
						CountHelper hlpr = new CountHelper();
						int red = 0;
						int yellow = 0;
						hlpr.setCurrentStatus("Applications Close");
						hlpr.setsRNo(pol.getsRNo());
						hlpr.setAdvtNo(pol.getaDvtNo());
						hlpr.setPostName(pol.getnAmeOfPost());
						hlpr.setCatNo(pol.getcAtNo());
						hlpr.setDeptName(pol.getDeptName());
						if (CommonUtils.isNotEmpty(pol.getApplicationOpenList())
								&& CommonUtils.isNotEmpty(pol.getApplicationClosedList())) {

							Date dateBefore = sdf
									.parse(pol.getApplicationOpenList().get(0).getApplicationopen().toString());
							Date dateAfter = sdf
									.parse(pol.getApplicationClosedList().get(0).getApplicationclosed().toString());
							long difference = dateAfter.getTime() - dateBefore.getTime();
							float daysBetween = (difference / (1000 * 60 * 60 * 24));
							if (daysBetween > 7) {
								red = red + 1;
							} else {
								yellow = yellow + 1;
							}

						} else {
							yellow = yellow + 1;
						}
						hlpr.setRedCount(red);
						hlpr.setYellowCount(yellow);
						cnthlprForAplOpenList.add(hlpr);
					}

					if (pol.getnExtStep().equalsIgnoreCase("PST Start(For Police only)")) {
						CountHelper hlpr = new CountHelper();
						int red = 0;
						int yellow = 0;
						hlpr.setCurrentStatus("Admit Cards");
						hlpr.setsRNo(pol.getsRNo());
						hlpr.setAdvtNo(pol.getaDvtNo());
						hlpr.setPostName(pol.getnAmeOfPost());
						hlpr.setCatNo(pol.getcAtNo());
						hlpr.setDeptName(pol.getDeptName());
						if (CommonUtils.isNotEmpty(pol.getApplicationOpenList())
								&& CommonUtils.isNotEmpty(pol.getAdmitCardsList())) {

							Date dateBefore = sdf
									.parse(pol.getApplicationOpenList().get(0).getApplicationopen().toString());
							Date dateAfter = sdf.parse(pol.getAdmitCardsList().get(0).getAdmitcard().toString());
							long difference = dateAfter.getTime() - dateBefore.getTime();
							float daysBetween = (difference / (1000 * 60 * 60 * 24));
							if (daysBetween > 7) {
								red = red + 1;
							} else {
								yellow = yellow + 1;
							}

						} else {
							yellow = yellow + 1;
						}
						hlpr.setRedCount(red);
						hlpr.setYellowCount(yellow);
						cnthlprForAplOpenList.add(hlpr);
					}

					if (pol.getnExtStep().equalsIgnoreCase("PST End(For Police only)")) {
						CountHelper hlpr = new CountHelper();
						int red = 0;
						int yellow = 0;
						hlpr.setCurrentStatus("PST Start(For Police only)");
						hlpr.setsRNo(pol.getsRNo());
						hlpr.setAdvtNo(pol.getaDvtNo());
						hlpr.setPostName(pol.getnAmeOfPost());
						hlpr.setCatNo(pol.getcAtNo());
						hlpr.setDeptName(pol.getDeptName());
						if (CommonUtils.isNotEmpty(pol.getApplicationOpenList())
								&& CommonUtils.isNotEmpty(pol.getPstStartList())) {

							Date dateBefore = sdf
									.parse(pol.getApplicationOpenList().get(0).getApplicationopen().toString());
							Date dateAfter = sdf.parse(pol.getPstStartList().get(0).getPststart().toString());
							long difference = dateAfter.getTime() - dateBefore.getTime();
							float daysBetween = (difference / (1000 * 60 * 60 * 24));
							if (daysBetween > 7) {
								red = red + 1;
							} else {
								yellow = yellow + 1;
							}

						} else {
							yellow = yellow + 1;
						}
						hlpr.setRedCount(red);
						hlpr.setYellowCount(yellow);
						cnthlprForAplOpenList.add(hlpr);
					}

					if (pol.getnExtStep().equalsIgnoreCase("Result of PST(For Police only)")) {
						CountHelper hlpr = new CountHelper();
						int red = 0;
						int yellow = 0;
						hlpr.setCurrentStatus("PST End(For Police only)");
						hlpr.setsRNo(pol.getsRNo());
						hlpr.setAdvtNo(pol.getaDvtNo());
						hlpr.setPostName(pol.getnAmeOfPost());
						hlpr.setCatNo(pol.getcAtNo());
						hlpr.setDeptName(pol.getDeptName());
						if (CommonUtils.isNotEmpty(pol.getApplicationOpenList())
								&& CommonUtils.isNotEmpty(pol.getPstEndList())) {

							Date dateBefore = sdf
									.parse(pol.getApplicationOpenList().get(0).getApplicationopen().toString());
							Date dateAfter = sdf.parse(pol.getPstEndList().get(0).getPstend().toString());
							long difference = dateAfter.getTime() - dateBefore.getTime();
							float daysBetween = (difference / (1000 * 60 * 60 * 24));
							if (daysBetween > 7) {
								red = red + 1;
							} else {
								yellow = yellow + 1;
							}

						} else {
							yellow = yellow + 1;
						}
						hlpr.setRedCount(red);
						hlpr.setYellowCount(yellow);
						cnthlprForAplOpenList.add(hlpr);
					}

					if (pol.getnExtStep().equalsIgnoreCase("Uploading Answer Key")) {
						CountHelper hlpr = new CountHelper();
						int red = 0;
						int yellow = 0;
						hlpr.setCurrentStatus("Written Exam");
						hlpr.setsRNo(pol.getsRNo());
						hlpr.setAdvtNo(pol.getaDvtNo());
						hlpr.setPostName(pol.getnAmeOfPost());
						hlpr.setCatNo(pol.getcAtNo());
						hlpr.setDeptName(pol.getDeptName());
						if (CommonUtils.isNotEmpty(pol.getApplicationOpenList())
								&& CommonUtils.isNotEmpty(pol.getWrittenExamList())) {

							Date dateBefore = sdf
									.parse(pol.getApplicationOpenList().get(0).getApplicationopen().toString());
							Date dateAfter = sdf.parse(pol.getWrittenExamList().get(0).getWrittenExam().toString());
							long difference = dateAfter.getTime() - dateBefore.getTime();
							float daysBetween = (difference / (1000 * 60 * 60 * 24));
							if (daysBetween > 7) {
								red = red + 1;
							} else {
								yellow = yellow + 1;
							}

						} else {
							yellow = yellow + 1;
						}
						hlpr.setRedCount(red);
						hlpr.setYellowCount(yellow);
						cnthlprForAplOpenList.add(hlpr);
					}

					if (pol.getnExtStep().equalsIgnoreCase("Written Exam")) {
						CountHelper hlpr = new CountHelper();
						int red = 0;
						int yellow = 0;
						hlpr.setCurrentStatus("Applications Open");
						hlpr.setsRNo(pol.getsRNo());
						hlpr.setAdvtNo(pol.getaDvtNo());
						hlpr.setPostName(pol.getnAmeOfPost());
						hlpr.setCatNo(pol.getcAtNo());
						hlpr.setDeptName(pol.getDeptName());
						if (CommonUtils.isNotEmpty(pol.getAdvtPostedDateList())
								&& CommonUtils.isNotEmpty(pol.getApplicationOpenList())) {

							Date dateBefore = sdf
									.parse(pol.getAdvtPostedDateList().get(0).getAdvertisementPosted().toString());
							Date dateAfter = sdf
									.parse(pol.getApplicationOpenList().get(0).getApplicationopen().toString());
							long difference = dateAfter.getTime() - dateBefore.getTime();
							float daysBetween = (difference / (1000 * 60 * 60 * 24));
							if (daysBetween > 7) {
								red = red + 1;
							} else {
								yellow = yellow + 1;
							}

						} else {
							yellow = yellow + 1;
						}
						hlpr.setRedCount(red);
						hlpr.setYellowCount(yellow);
						cnthlprForAplOpenList.add(hlpr);
					}

					if (pol.getnExtStep().equalsIgnoreCase("Scrutiny")) {
						CountHelper hlpr = new CountHelper();
						int red = 0;
						int yellow = 0;
						hlpr.setCurrentStatus("Written Exam");
						hlpr.setsRNo(pol.getsRNo());
						hlpr.setAdvtNo(pol.getaDvtNo());
						hlpr.setPostName(pol.getnAmeOfPost());
						hlpr.setCatNo(pol.getcAtNo());
						hlpr.setDeptName(pol.getDeptName());
						if (CommonUtils.isNotEmpty(pol.getWrittenExamList())
								&& CommonUtils.isNotEmpty(pol.getApplicationOpenList())) {
							Date dateBefore = sdf
									.parse(pol.getApplicationOpenList().get(0).getApplicationopen().toString());
							Date dateAfter = sdf.parse(pol.getWrittenExamList().get(0).getWrittenExam().toString());
							long difference = dateAfter.getTime() - dateBefore.getTime();
							float daysBetween = (difference / (1000 * 60 * 60 * 24));
							if (daysBetween > 60) {
								red = red + 1;
							} else {
								yellow = yellow + 1;
							}

						} else {
							yellow = yellow + 1;
						}
						hlpr.setRedCount(red);
						hlpr.setYellowCount(yellow);
						cnthlprForWrtnExmList.add(hlpr);
					}

					if (pol.getnExtStep().equalsIgnoreCase("Objections Open")) {
						CountHelper hlpr = new CountHelper();
						int red = 0;
						int yellow = 0;
						hlpr.setCurrentStatus("Uploading Answer Key");
						hlpr.setsRNo(pol.getsRNo());
						hlpr.setAdvtNo(pol.getaDvtNo());
						hlpr.setPostName(pol.getnAmeOfPost());
						hlpr.setCatNo(pol.getcAtNo());
						hlpr.setDeptName(pol.getDeptName());
						if (CommonUtils.isNotEmpty(pol.getWrittenExamList())
								&& CommonUtils.isNotEmpty(pol.getUploadingAnswerKeyList())) {
							Date dateBefore = sdf.parse(pol.getWrittenExamList().get(0).getWrittenExam().toString());
							Date dateAfter = sdf
									.parse(pol.getUploadingAnswerKeyList().get(0).getUploadingAnswerKey().toString());
							long difference = dateAfter.getTime() - dateBefore.getTime();
							float daysBetween = (difference / (1000 * 60 * 60 * 24));
							if (daysBetween > 60) {
								red = red + 1;
							} else {
								yellow = yellow + 1;
							}

						} else {
							yellow = yellow + 1;
						}
						hlpr.setRedCount(red);
						hlpr.setYellowCount(yellow);
						cnthlprForWrtnExmList.add(hlpr);
					}

					if (pol.getnExtStep().equalsIgnoreCase("Objections Close")) {
						CountHelper hlpr = new CountHelper();
						int red = 0;
						int yellow = 0;
						hlpr.setCurrentStatus("Objections Open");
						hlpr.setsRNo(pol.getsRNo());
						hlpr.setAdvtNo(pol.getaDvtNo());
						hlpr.setPostName(pol.getnAmeOfPost());
						hlpr.setCatNo(pol.getcAtNo());
						hlpr.setDeptName(pol.getDeptName());
						if (CommonUtils.isNotEmpty(pol.getWrittenExamList())
								&& CommonUtils.isNotEmpty(pol.getObjectionsOpenList())) {
							Date dateBefore = sdf.parse(pol.getWrittenExamList().get(0).getWrittenExam().toString());
							Date dateAfter = sdf
									.parse(pol.getObjectionsOpenList().get(0).getObjectionsOpen().toString());
							long difference = dateAfter.getTime() - dateBefore.getTime();
							float daysBetween = (difference / (1000 * 60 * 60 * 24));
							if (daysBetween > 60) {
								red = red + 1;
							} else {
								yellow = yellow + 1;
							}

						} else {
							yellow = yellow + 1;
						}
						hlpr.setRedCount(red);
						hlpr.setYellowCount(yellow);
						cnthlprForWrtnExmList.add(hlpr);
					}

					if (pol.getnExtStep().equalsIgnoreCase("Upload Revised Answer Key")) {
						CountHelper hlpr = new CountHelper();
						int red = 0;
						int yellow = 0;
						hlpr.setCurrentStatus("Objections Close");
						hlpr.setsRNo(pol.getsRNo());
						hlpr.setAdvtNo(pol.getaDvtNo());
						hlpr.setPostName(pol.getnAmeOfPost());
						hlpr.setCatNo(pol.getcAtNo());
						hlpr.setDeptName(pol.getDeptName());
						if (CommonUtils.isNotEmpty(pol.getWrittenExamList())
								&& CommonUtils.isNotEmpty(pol.getObjectionsClosedList())) {
							Date dateBefore = sdf.parse(pol.getWrittenExamList().get(0).getWrittenExam().toString());
							Date dateAfter = sdf
									.parse(pol.getObjectionsClosedList().get(0).getObjectionsClosed().toString());
							long difference = dateAfter.getTime() - dateBefore.getTime();
							float daysBetween = (difference / (1000 * 60 * 60 * 24));
							if (daysBetween > 60) {
								red = red + 1;
							} else {
								yellow = yellow + 1;
							}

						} else {
							yellow = yellow + 1;
						}
						hlpr.setRedCount(red);
						hlpr.setYellowCount(yellow);
						cnthlprForWrtnExmList.add(hlpr);
					}

					if (pol.getnExtStep().equalsIgnoreCase("Result of Written Exam")) {
						CountHelper hlpr = new CountHelper();
						int red = 0;
						int yellow = 0;
						hlpr.setCurrentStatus("Upload Revised Answer Key");
						hlpr.setsRNo(pol.getsRNo());
						hlpr.setAdvtNo(pol.getaDvtNo());
						hlpr.setPostName(pol.getnAmeOfPost());
						hlpr.setCatNo(pol.getcAtNo());
						hlpr.setDeptName(pol.getDeptName());
						if (CommonUtils.isNotEmpty(pol.getWrittenExamList())
								&& CommonUtils.isNotEmpty(pol.getUploadedRevisedAnswerKeyList())) {
							Date dateBefore = sdf.parse(pol.getWrittenExamList().get(0).getWrittenExam().toString());
							Date dateAfter = sdf.parse(pol.getUploadedRevisedAnswerKeyList().get(0)
									.getUploadedRevisedAnswerKey().toString());
							long difference = dateAfter.getTime() - dateBefore.getTime();
							float daysBetween = (difference / (1000 * 60 * 60 * 24));
							if (daysBetween > 60) {
								red = red + 1;
							} else {
								yellow = yellow + 1;
							}

						} else {
							yellow = yellow + 1;
						}
						hlpr.setRedCount(red);
						hlpr.setYellowCount(yellow);
						cnthlprForWrtnExmList.add(hlpr);
					}

					if (pol.getnExtStep().equalsIgnoreCase("Scrutiny Results")) {
						CountHelper hlpr = new CountHelper();
						int red = 0;
						int yellow = 0;
						hlpr.setCurrentStatus("Scrutiny");
						hlpr.setsRNo(pol.getsRNo());
						hlpr.setAdvtNo(pol.getaDvtNo());
						hlpr.setPostName(pol.getnAmeOfPost());
						hlpr.setCatNo(pol.getcAtNo());
						hlpr.setDeptName(pol.getDeptName());
						if (CommonUtils.isNotEmpty(pol.getWrittenExamList())
								&& CommonUtils.isNotEmpty(pol.getScrutinyStartDateList())) {
							Date dateBefore = sdf.parse(pol.getWrittenExamList().get(0).getWrittenExam().toString());
							Date dateAfter = sdf
									.parse(pol.getScrutinyStartDateList().get(0).getScrutinyStartDate().toString());
							long difference = dateAfter.getTime() - dateBefore.getTime();
							float daysBetween = (difference / (1000 * 60 * 60 * 24));
							if (daysBetween > 60) {
								red = red + 1;
							} else {
								yellow = yellow + 1;
							}

						} else {
							yellow = yellow + 1;
						}
						hlpr.setRedCount(red);
						hlpr.setYellowCount(yellow);
						cnthlprForWrtnExmList.add(hlpr);
					}

					if (pol.getnExtStep().equalsIgnoreCase("Interviews")) {
						CountHelper hlpr = new CountHelper();
						int red = 0;
						int yellow = 0;
						hlpr.setCurrentStatus("Scrutiny");
						hlpr.setsRNo(pol.getsRNo());
						hlpr.setAdvtNo(pol.getaDvtNo());
						hlpr.setPostName(pol.getnAmeOfPost());
						hlpr.setCatNo(pol.getcAtNo());
						hlpr.setDeptName(pol.getDeptName());
						if (CommonUtils.isNotEmpty(pol.getScrutinyStartDateList())
								&& CommonUtils.isNotEmpty(pol.getWrittenExamList())) {
							Date dateBefore = sdf.parse(pol.getWrittenExamList().get(0).getWrittenExam().toString());
							Date dateAfter = sdf
									.parse(pol.getScrutinyStartDateList().get(0).getScrutinyStartDate().toString());
							long difference = dateAfter.getTime() - dateBefore.getTime();
							float daysBetween = (difference / (1000 * 60 * 60 * 24));
							if (daysBetween > 37) {
								red = red + 1;
							} else {
								yellow = yellow + 1;
							}

						} else {
							yellow = yellow + 1;
						}

						hlpr.setRedCount(red);
						hlpr.setYellowCount(yellow);
						cnthlprForScrutinyList.add(hlpr);
					}

					if (pol.getnExtStep().equalsIgnoreCase("PMT Height-Chest (For Police only)")) {
						CountHelper hlpr = new CountHelper();
						int red = 0;
						int yellow = 0;
						hlpr.setCurrentStatus("Scrutiny Results");
						hlpr.setsRNo(pol.getsRNo());
						hlpr.setAdvtNo(pol.getaDvtNo());
						hlpr.setPostName(pol.getnAmeOfPost());
						hlpr.setCatNo(pol.getcAtNo());
						hlpr.setDeptName(pol.getDeptName());
						if (CommonUtils.isNotEmpty(pol.getScrutinyStartDateList())
								&& CommonUtils.isNotEmpty(pol.getScrutinyResultsList())) {
							Date dateBefore = sdf
									.parse(pol.getScrutinyStartDateList().get(0).getScrutinyStartDate().toString());
							Date dateAfter = sdf
									.parse(pol.getScrutinyResultsList().get(0).getScrutinyResults().toString());
							long difference = dateAfter.getTime() - dateBefore.getTime();
							float daysBetween = (difference / (1000 * 60 * 60 * 24));
							if (daysBetween > 37) {
								red = red + 1;
							} else {
								yellow = yellow + 1;
							}

						} else {
							yellow = yellow + 1;
						}

						hlpr.setRedCount(red);
						hlpr.setYellowCount(yellow);
						cnthlprForScrutinyList.add(hlpr);
					}

					if (pol.getnExtStep().equalsIgnoreCase("Admit Cards(for Interview)")) {
						CountHelper hlpr = new CountHelper();
						int red = 0;
						int yellow = 0;
						hlpr.setCurrentStatus("PMT Height-Chest (For Police only)");
						hlpr.setsRNo(pol.getsRNo());
						hlpr.setAdvtNo(pol.getaDvtNo());
						hlpr.setPostName(pol.getnAmeOfPost());
						hlpr.setCatNo(pol.getcAtNo());
						hlpr.setDeptName(pol.getDeptName());
						if (CommonUtils.isNotEmpty(pol.getScrutinyStartDateList())
								&& CommonUtils.isNotEmpty(pol.getpMTHeightChestList())) {
							Date dateBefore = sdf
									.parse(pol.getScrutinyStartDateList().get(0).getScrutinyStartDate().toString());
							Date dateAfter = sdf
									.parse(pol.getpMTHeightChestList().get(0).getPmtHeightChest().toString());
							long difference = dateAfter.getTime() - dateBefore.getTime();
							float daysBetween = (difference / (1000 * 60 * 60 * 24));
							if (daysBetween > 37) {
								red = red + 1;
							} else {
								yellow = yellow + 1;
							}

						} else {
							yellow = yellow + 1;
						}

						hlpr.setRedCount(red);
						hlpr.setYellowCount(yellow);
						cnthlprForScrutinyList.add(hlpr);
					}

					if (pol.getnExtStep().equalsIgnoreCase("Interviews")) {
						CountHelper hlpr = new CountHelper();
						int red = 0;
						int yellow = 0;
						hlpr.setCurrentStatus("Admit Cards(for Interview)");
						hlpr.setsRNo(pol.getsRNo());
						hlpr.setAdvtNo(pol.getaDvtNo());
						hlpr.setPostName(pol.getnAmeOfPost());
						hlpr.setCatNo(pol.getcAtNo());
						hlpr.setDeptName(pol.getDeptName());
						if (CommonUtils.isNotEmpty(pol.getScrutinyStartDateList())
								&& CommonUtils.isNotEmpty(pol.getAdmitCardsForInterviewList())) {
							Date dateBefore = sdf
									.parse(pol.getScrutinyStartDateList().get(0).getScrutinyStartDate().toString());
							Date dateAfter = sdf.parse(
									pol.getAdmitCardsForInterviewList().get(0).getAdmitCardsForInterview().toString());
							long difference = dateAfter.getTime() - dateBefore.getTime();
							float daysBetween = (difference / (1000 * 60 * 60 * 24));
							if (daysBetween > 37) {
								red = red + 1;
							} else {
								yellow = yellow + 1;
							}

						} else {
							yellow = yellow + 1;
						}

						hlpr.setRedCount(red);
						hlpr.setYellowCount(yellow);
						cnthlprForScrutinyList.add(hlpr);
					}

					/*
					 * if(pol.getnExtStep().equalsIgnoreCase("Announcement of Final Result")){
					 * CountHelper hlpr=new CountHelper(); int red=0; int yellow=0;
					 * hlpr.setCurrentStatus("Interviews"); hlpr.setsRNo(pol.getsRNo());
					 * if(CommonUtils.isNotEmpty(pol.getScrutinyStartDateList())&&
					 * CommonUtils.isNotEmpty(pol.getInterviewStartDateList())){ Date
					 * dateBefore=sdf.parse(pol.getScrutinyStartDateList().get(0).
					 * getScrutinyStartDate().toString()); Date
					 * dateAfter=sdf.parse(pol.getInterviewStartDateList().get(0).
					 * getInterviewStartDate().toString()); long difference = dateAfter.getTime() -
					 * dateBefore.getTime(); float daysBetween = (difference / (1000*60*60*24));
					 * if(daysBetween>37) { red=red+1; }else{ yellow=yellow+1; }
					 * 
					 * }else{ yellow=yellow+1; }
					 * 
					 * hlpr.setRedCount(red); hlpr.setYellowCount(yellow);
					 * cnthlprForScrutinyList.add(hlpr); }
					 */

					if (pol.getnExtStep().equalsIgnoreCase("Recommend")) {
						CountHelper hlpr = new CountHelper();
						int red = 0;
						int yellow = 0;
						hlpr.setCurrentStatus("Interviews");
						hlpr.setsRNo(pol.getsRNo());
						hlpr.setAdvtNo(pol.getaDvtNo());
						hlpr.setPostName(pol.getnAmeOfPost());
						hlpr.setCatNo(pol.getcAtNo());
						hlpr.setDeptName(pol.getDeptName());
						if (CommonUtils.isNotEmpty(pol.getInterviewStartDateList())
								&& CommonUtils.isNotEmpty(pol.getScrutinyStartDateList())) {
							Date dateBefore = sdf
									.parse(pol.getScrutinyStartDateList().get(0).getScrutinyStartDate().toString());
							Date dateAfter = sdf
									.parse(pol.getInterviewStartDateList().get(0).getInterviewStartDate().toString());
							long difference = dateAfter.getTime() - dateBefore.getTime();
							float daysBetween = (difference / (1000 * 60 * 60 * 24));
							if (daysBetween > 28) {
								red = red + 1;
							} else {
								yellow = yellow + 1;
							}
						} else {
							yellow = yellow + 1;
						}
						System.out.println(yellow);
						hlpr.setRedCount(red);
						hlpr.setYellowCount(yellow);
						cnthlprForInterviewList.add(hlpr);
					}

					if (pol.getnExtStep().equalsIgnoreCase("Joining")) {
						CountHelper hlpr = new CountHelper();
						int red = 0;
						int yellow = 0;
						hlpr.setCurrentStatus("Recommend");
						hlpr.setsRNo(pol.getsRNo());
						hlpr.setAdvtNo(pol.getaDvtNo());
						hlpr.setPostName(pol.getnAmeOfPost());
						hlpr.setCatNo(pol.getcAtNo());
						hlpr.setDeptName(pol.getDeptName());
						if (CommonUtils.isNotEmpty(pol.getRecommendedDateList())
								&& CommonUtils.isNotEmpty(pol.getInterviewStartDateList())) {
							Date dateBefore = sdf
									.parse(pol.getInterviewStartDateList().get(0).getInterviewStartDate().toString());
							Date dateAfter = sdf
									.parse(pol.getRecommendedDateList().get(0).getRecommendedDate().toString());
							long difference = dateAfter.getTime() - dateBefore.getTime();
							float daysBetween = (difference / (1000 * 60 * 60 * 24));
							if (daysBetween > 2) {
								red = red + 1;
							} else {
								yellow = yellow + 1;
							}

						} else {
							yellow = yellow + 1;
						}
						hlpr.setRedCount(red);
						hlpr.setYellowCount(yellow);
						cnthlprForRecommendList.add(hlpr);
					}

				}
			}
			int aplOpenRedCount = 0;
			int aplOpenYellowCount = 0;
			int interviewRedCount = 0;
			int interviewYellowCount = 0;
			int recommendRedCount = 0;
			int recommendYellowCount = 0;
			int scrutinyRedCount = 0;
			int scrutinyYellowCount = 0;
			int wrtExamRedCount = 0;
			int wrtExamYellowCount = 0;
			cnthlprForAplOpenListGlobal = cnthlprForAplOpenList;
			cnthlprForInterviewListGlobal = cnthlprForInterviewList;
			cnthlprForRecommendListGlobal = cnthlprForRecommendList;
			cnthlprForScrutinyListGlobal = cnthlprForScrutinyList;
			cnthlprForWrtnExmListGlobal = cnthlprForWrtnExmList;

			for (int i = 0; i < cnthlprForAplOpenList.size(); i++) {
				aplOpenRedCount = aplOpenRedCount + cnthlprForAplOpenList.get(i).getRedCount();
				aplOpenYellowCount = aplOpenYellowCount + cnthlprForAplOpenList.get(i).getYellowCount();
			}
			for (int i = 0; i < cnthlprForInterviewList.size(); i++) {
				interviewRedCount = interviewRedCount + cnthlprForInterviewList.get(i).getRedCount();
				interviewYellowCount = interviewYellowCount + cnthlprForInterviewList.get(i).getYellowCount();
			}
			for (int i = 0; i < cnthlprForRecommendList.size(); i++) {
				recommendRedCount = recommendRedCount + cnthlprForRecommendList.get(i).getRedCount();
				recommendYellowCount = recommendYellowCount + cnthlprForRecommendList.get(i).getYellowCount();
			}
			for (int i = 0; i < cnthlprForScrutinyList.size(); i++) {
				scrutinyRedCount = scrutinyRedCount + cnthlprForScrutinyList.get(i).getRedCount();
				scrutinyYellowCount = scrutinyYellowCount + cnthlprForScrutinyList.get(i).getYellowCount();
			}
			for (int i = 0; i < cnthlprForWrtnExmList.size(); i++) {
				wrtExamRedCount = wrtExamRedCount + cnthlprForWrtnExmList.get(i).getRedCount();
				wrtExamYellowCount = wrtExamYellowCount + cnthlprForWrtnExmList.get(i).getYellowCount();
			}
			 
			  
  
			model.addAttribute("wrtExamYellowCount", wrtExamYellowCount);
			model.addAttribute("wrtExamRedCount", wrtExamRedCount);
			model.addAttribute("scrutinyYellowCount", scrutinyYellowCount);
			model.addAttribute("scrutinyRedCount", scrutinyRedCount);
			model.addAttribute("recommendRedCount", recommendRedCount);
			model.addAttribute("recommendYellowCount", recommendYellowCount);
			model.addAttribute("interviewYellowCount", interviewYellowCount);
			model.addAttribute("interviewRedCount", interviewRedCount);
			model.addAttribute("aplOpenYellowCount", aplOpenYellowCount);
			model.addAttribute("aplOpenRedCount", aplOpenRedCount);
			model.addAttribute("recommendCount", recommendCount);
			model.addAttribute("announcementOfFinalResultCount", announcementOfFinalResultCount);
			model.addAttribute("admitCardsForInterviewCount", admitCardsForInterviewCount);
			model.addAttribute("pmtHeightChestCount", pmtHeightChestCount);
			model.addAttribute("scrutinyResultCount", scrutinyResultCount);
			model.addAttribute("scrutinyCount", scrutinyCount);
			model.addAttribute("resultOfWrittenExamCount", resultOfWrittenExamCount);
			model.addAttribute("uploadRevisedAnsKeyCount", uploadRevisedAnsKeyCount);
			model.addAttribute("objectionClosedCount", objectionClosedCount);
			model.addAttribute("objectionOpenCount", objectionOpenCount);
			model.addAttribute("uploadAnsKeyCount", uploadAnsKeyCount);
			model.addAttribute("writtenExamCount", writtenExamCount);
			model.addAttribute("pstResultCount", pstResultCount);
			model.addAttribute("pstEndCount", pstEndCount);
			model.addAttribute("pstStartCount", pstStartCount);
			model.addAttribute("admitCardsCount", admitCardsCount);
			model.addAttribute("applicationClosedCount", applicationClosedCount);
			model.addAttribute("applicationOpenCount", applicationOpenCount);
			model.addAttribute("advtPostedCount", advtPostedCount);
			model.addAttribute("joiningCount", joiningCount);
			model.addAttribute("interviewsCount", interviewsCount);

			if(isAdmin.contains("Y")) {
			List<DepartmentVO> depVoList = baseDataService.getGroupedPostListForDept(dEpartmentId);
			HashMap<String, DepartmentVO> groupedMap = new HashMap<String, DepartmentVO>();
			if (CommonUtils.isNotEmpty(depVoList)) {
				for (DepartmentVO dep : depVoList) {
					if (groupedMap.containsKey(dep.getDepartmentName())) {
						HashMap<String, Integer> depNextStepMap = groupedMap.get(dep.getDepartmentName())
								.getNextStepCount();
						depNextStepMap.put(dep.getStatus(), dep.getCount());
					} else {
						DepartmentVO depVo = new DepartmentVO();
						depVo.setDepartmentName(dep.getDepartmentName());
						HashMap<String, Integer> depNextStepMap = new HashMap<String, Integer>();
						depNextStepMap.put(dep.getStatus(), dep.getCount());
						depVo.setNextStepCount(depNextStepMap);
						groupedMap.put(dep.getDepartmentName(), depVo);
					}
				}
			}
			List<DepartmentVO> uniqueStatusList = baseDataService.getUniqueNextStep(dEpartmentId);

			List<String> uniqueStatusStrList = new ArrayList<String>();
			for (DepartmentVO dep : uniqueStatusList) {
				if (CommonUtils.isNotEmpty(dep.getStatus())) {
					uniqueStatusStrList.add(dep.getStatus());
				}
			}
			model.addAttribute("uniqueStatusStrList", new Gson().toJson(uniqueStatusStrList));

			model.addAttribute("uniqueStatusStr", uniqueStatusStrList);

			List<List<String>> depStatusCount = new LinkedList<List<String>>();
			List<String> depNameList = new LinkedList<String>();
			if (CommonUtils.isNotEmpty(uniqueStatusList)) {

				Iterator it = groupedMap.entrySet().iterator();

				while (it.hasNext()) {
					Map.Entry pair = (Map.Entry) it.next();
					List<String> depAllStatusList = new LinkedList<String>();
					for (DepartmentVO dep : uniqueStatusList) {
						if (CommonUtils.isNotEmpty(dep.getStatus())) {
							if (!((DepartmentVO) pair.getValue()).getNextStepCount().containsKey(dep.getStatus())) {
								((DepartmentVO) pair.getValue()).getNextStepCount().put(dep.getStatus(), 0);
								depAllStatusList.add("0");
							} else {
								depAllStatusList.add(
										((DepartmentVO) pair.getValue()).getNextStepCount().get(dep.getStatus()) + "");
							}
						}
					}
					depNameList.add(((DepartmentVO) pair.getValue()).getDepartmentName());
					depStatusCount.add(depAllStatusList);
				}
			}
			
			
			model.addAttribute("depNameList", new Gson().toJson(depNameList));
			model.addAttribute("depStatusCount", new Gson().toJson(depStatusCount));
			model.addAttribute("depNames", depNameList);
			model.addAttribute("depStatuses", depStatusCount);
			model.addAttribute("groupedStatusMap", groupedMap);
			}
			
			Integer reqSize=allHsscPostListForDept.size();
			Integer withdrawReqSize=withdrawnCount.size();
			Integer totalReqWithoutWithdrawn=reqSize-withdrawReqSize;
			Long totalNoOfPostsWithoutWithdrawn=allTotalNoOfPosts-withdrawnTotalNoOfPost;
			
			List<String> uniqueMacroStatusList= baseDataService.getUniqueMacroStatusList();
			model.addAttribute("uniqueMacroStatusList",uniqueMacroStatusList);
			model.addAttribute("allTotalNoOfPosts", allTotalNoOfPosts);
			model.addAttribute("recommendedTotalNoOfPosts", recommendedTotalNoOfPosts);
			model.addAttribute("courtStayTotalNoOfPosts", courtStayTotalNoOfPosts);
			model.addAttribute("inProcessTotalNoOfPosts", inProcessTotalNoOfPosts);
			model.addAttribute("allHsscPostListForDept", allHsscPostListForDept);
			model.addAttribute("recommendedCount", recommendedCount);
			model.addAttribute("courtStayCount", courtStayCount);
			model.addAttribute("inProcessCount", inProcessCount);
			model.addAttribute("withdrawnCount", withdrawnCount);
			model.addAttribute("withdrawnTotalNoOfPost", withdrawnTotalNoOfPost);
			model.addAttribute("ProcessHaltedCount",ProcessHaltedCount);
			model.addAttribute("ProcessHaltedTotalNoOfPost",ProcessHaltedTotalNoOfPost);
			model.addAttribute("module", module);
			
			model.addAttribute("totalReqWithoutWithdrawn", totalReqWithoutWithdrawn);
			model.addAttribute("totalNoOfPostsWithoutWithdrawn", totalNoOfPostsWithoutWithdrawn);

		} catch (Exception e) {
			logger.logError("getDashboard", "exception while loading to dahsboard", e);
		}

		return "misDashboard";
	}

	@RequestMapping(value = "/showPostDetailsForAdmin", method = { RequestMethod.GET, RequestMethod.POST })
	public String getPostDetailsForAdmin(Model model, @ModelAttribute("srNo") Integer srNo) throws Exception {
		List<Police> postDetailsList = baseDataService.getPostDetails(srNo);
		String deptName = postDetailsList.get(0).getDeptObj().getdEpartment();
		model.addAttribute("postDetailsList", postDetailsList);
		model.addAttribute("deptName", deptName);
		model.addAttribute("mAcroStatus", postDetailsList.get(0).getmAcroStatus());
		model.addAttribute("dEpartmentIdDropDown", postDetailsList.get(0).getdEpartmentId());

		return "stepWiseDetailsEdit";
	}

	@RequestMapping(value = "/updatePostDetails", method = { RequestMethod.GET, RequestMethod.POST })
	public String updatePostDetailsForAdmin(Model model, @ModelAttribute("policeObj") Police post, String Department, HttpSession session, HttpServletRequest request)
			throws Exception {
		 UserLogin user=new UserLogin();
		 String pageSize=null;
		try {
			nextStepAllocate(post);
			Integer userId = (Integer) session.getAttribute("userId");
			post.setUserId(userId);
			String nxtStep = post.getnExtStep();
			if (nxtStep.equalsIgnoreCase("Recommend")) {
				post.setmAcroStatus("Recommended");
			}
			baseDataDao.updatePostDetails(post);
		} catch (Exception e) {
			logger.logError("updatePostDetailsForAdmin", "exception while updating details", e);
		}
		return getFrontPage(user,model,request,session,post.getnAmeOfPost(),post.getaDvtNo(),post.getmAcroStatus(),post.getdEpartmentId().toString(),post.getnExtStep(),pageSize,null,null,null);

	}

	private void nextStepAllocate(Police post) throws ParseException {
		/*SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
		List<Date> dates = new ArrayList<Date>();
		String maxdate = new String();

		if (CommonUtils.isNotEmpty(post.getnExtStep())) {
			if (post.getnExtStep().equalsIgnoreCase("Applications Open")) {
				CountHelper hlp = new CountHelper();
				hlp.setCurrentStatus("Advertisement Posted");
				hlp.setsRNo(post.getsRNo());
				if (CommonUtils.isNotEmpty(post.getAdvtPostedDateList())) {
					for (int i = 0; i < post.getAdvtPostedDateList().size(); i++) {
						dates.add(i, post.getAdvtPostedDateList().get(i).getAdvertisementPosted());
					}
					maxdate = fmt.format(Collections.max(dates));
					Date conMaxDate = fmt.parse(maxdate);
					Calendar cal = Calendar.getInstance();
					Date currentDate = cal.getTime();

					if (conMaxDate.getTime() < currentDate.getTime()) {
						post.setnExtStep(hlp.getCurrentStatus());
					} else {
						post.setCurrentStep("Advertisement Posted");
					}
				}

			}
			if (post.getnExtStep().equalsIgnoreCase("Applications Close")) {
				CountHelper hlp = new CountHelper();
				hlp.setCurrentStatus("Applications Open");
				hlp.setsRNo(post.getsRNo());
				if (CommonUtils.isNotEmpty(post.getApplicationOpenList())) {
					for (int i = 0; i < post.getApplicationOpenList().size(); i++) {
						dates.add(i, post.getApplicationOpenList().get(i).getApplicationopen());
					}
					maxdate = fmt.format(Collections.max(dates));
					Date conMaxDate = fmt.parse(maxdate);
					Calendar cal = Calendar.getInstance();
					Date currentDate = cal.getTime();

					if (conMaxDate.getTime() < currentDate.getTime()) {
						post.setCurrentStep("Advertisement Posted");
						post.setnExtStep(hlp.getCurrentStatus());
					} else {
						post.setCurrentStep("Applications Open");
					}
				}

			}
			if (post.getnExtStep().equalsIgnoreCase("Admit Cards")) {
				CountHelper hlp = new CountHelper();
				hlp.setCurrentStatus("Applications Close");
				hlp.setsRNo(post.getsRNo());
				if (CommonUtils.isNotEmpty(post.getApplicationClosedList())) {
					for (int i = 0; i < post.getApplicationClosedList().size(); i++) {
						dates.add(i, post.getApplicationClosedList().get(i).getApplicationclosed());
					}
					maxdate = fmt.format(Collections.max(dates));
					Date conMaxDate = fmt.parse(maxdate);
					Calendar cal = Calendar.getInstance();
					Date currentDate = cal.getTime();

					if (conMaxDate.getTime() < currentDate.getTime()) {
						post.setnExtStep(hlp.getCurrentStatus());
						post.setCurrentStep("Applications Open");
					} else {
						post.setCurrentStep("Applications Close");
					}
				}

			}
			
			if (post.getnExtStep().equalsIgnoreCase("PST Start(For Police only)")) {
				CountHelper hlp = new CountHelper();
				hlp.setCurrentStatus("Admit Cards");
				hlp.setsRNo(post.getsRNo());
				if (CommonUtils.isNotEmpty(post.getAdmitCardsList())) {
					for (int i = 0; i < post.getAdmitCardsList().size(); i++) {
						dates.add(i, post.getAdmitCardsList().get(i).getAdmitcard());
					}
					maxdate = fmt.format(Collections.max(dates));
					Date conMaxDate = fmt.parse(maxdate);
					Calendar cal = Calendar.getInstance();
					Date currentDate = cal.getTime();

					if (conMaxDate.getTime() < currentDate.getTime()) {
						post.setnExtStep(hlp.getCurrentStatus());
						post.setCurrentStep("Applications Close");
					} else {
						post.setCurrentStep("Admit Cards");
					}
				}

			}
			
			if (post.getnExtStep().equalsIgnoreCase("PST End(For Police only)")) {
				CountHelper hlp = new CountHelper();
				hlp.setCurrentStatus("PST Start(For Police only)");
				hlp.setsRNo(post.getsRNo());
				if (CommonUtils.isNotEmpty(post.getPstStartList())) {
					for (int i = 0; i < post.getPstStartList().size(); i++) {
						dates.add(i, post.getPstStartList().get(i).getPststart());
					}
					maxdate = fmt.format(Collections.max(dates));
					Date conMaxDate = fmt.parse(maxdate);
					Calendar cal = Calendar.getInstance();
					Date currentDate = cal.getTime();

					if (conMaxDate.getTime() < currentDate.getTime()) {
						post.setnExtStep(hlp.getCurrentStatus());
						post.setCurrentStep("Admit Cards");
					} else {
						post.setCurrentStep("PST Start(For Police only)");
					}
				}

			}
			if (post.getnExtStep().equalsIgnoreCase("Result of PST(For Police only)")) {
				CountHelper hlp = new CountHelper();
				hlp.setCurrentStatus("PST End(For Police only)");
				hlp.setsRNo(post.getsRNo());
				if (CommonUtils.isNotEmpty(post.getPstEndList())) {
					for (int i = 0; i < post.getPstEndList().size(); i++) {
						dates.add(i, post.getPstEndList().get(i).getPstend());
					}
					maxdate = fmt.format(Collections.max(dates));
					Date conMaxDate = fmt.parse(maxdate);
					Calendar cal = Calendar.getInstance();
					Date currentDate = cal.getTime();

					if (conMaxDate.getTime() < currentDate.getTime()) {
						post.setnExtStep(hlp.getCurrentStatus());
						post.setCurrentStep("PST Start(For Police only)");
					} else {
						post.setCurrentStep("PST End(For Police only)");
					}
				}

			}
			if (post.getnExtStep().equalsIgnoreCase("Written Exam")) {
				CountHelper hlp = new CountHelper();
				hlp.setCurrentStatus("Result of PST(For Police only)");
				hlp.setsRNo(post.getsRNo());
				if (CommonUtils.isNotEmpty(post.getResultOfPstList())) {
					for (int i = 0; i < post.getResultOfPstList().size(); i++) {
						dates.add(i, post.getResultOfPstList().get(i).getResultofpst());
					}
					maxdate = fmt.format(Collections.max(dates));
					Date conMaxDate = fmt.parse(maxdate);
					Calendar cal = Calendar.getInstance();
					Date currentDate = cal.getTime();

					if (conMaxDate.getTime() < currentDate.getTime()) {
						post.setnExtStep(hlp.getCurrentStatus());
						post.setCurrentStep("PST End(For Police only)");
					} else {
						post.setCurrentStep("Result of PST(For Police only)");
					}
				}

			}
			if (post.getnExtStep().equalsIgnoreCase("Uploading Answer Key")) {
				CountHelper hlp = new CountHelper();
				hlp.setCurrentStatus("Written Exam");
				hlp.setsRNo(post.getsRNo());
				if (CommonUtils.isNotEmpty(post.getWrittenExamList())) {
					for (int i = 0; i < post.getWrittenExamList().size(); i++) {
						dates.add(i, post.getWrittenExamList().get(i).getWrittenExam());
					}
					maxdate = fmt.format(Collections.max(dates));
					Date conMaxDate = fmt.parse(maxdate);
					Calendar cal = Calendar.getInstance();
					Date currentDate = cal.getTime();

					if (conMaxDate.getTime() < currentDate.getTime()) {
						post.setnExtStep(hlp.getCurrentStatus());
						post.setCurrentStep("Result of PST(For Police only)");
					} else {
						post.setCurrentStep("Written Exam");
					}
				}

			}
			
			if (post.getnExtStep().equalsIgnoreCase("Objections Open")) {
				CountHelper hlp = new CountHelper();
				hlp.setCurrentStatus("Uploading Answer Key");
				hlp.setsRNo(post.getsRNo());
				if (CommonUtils.isNotEmpty(post.getUploadingAnswerKeyList())) {
					for (int i = 0; i < post.getUploadingAnswerKeyList().size(); i++) {
						dates.add(i, post.getUploadingAnswerKeyList().get(i).getUploadingAnswerKey());
					}
					maxdate = fmt.format(Collections.max(dates));
					Date conMaxDate = fmt.parse(maxdate);
					Calendar cal = Calendar.getInstance();
					Date currentDate = cal.getTime();

					if (conMaxDate.getTime() < currentDate.getTime()) {
						post.setnExtStep(hlp.getCurrentStatus());
						post.setCurrentStep("Written Exam");
					} else {
						post.setCurrentStep("Uploading Answer Key");
					}
				}

			}
			
			if (post.getnExtStep().equalsIgnoreCase("Objections Close")) {
				CountHelper hlp = new CountHelper();
				hlp.setCurrentStatus("Objections Open");
				hlp.setsRNo(post.getsRNo());
				if (CommonUtils.isNotEmpty(post.getObjectionsOpenList())) {
					for (int i = 0; i < post.getObjectionsOpenList().size(); i++) {
						dates.add(i, post.getObjectionsOpenList().get(i).getObjectionsOpen());
					}
					maxdate = fmt.format(Collections.max(dates));
					Date conMaxDate = fmt.parse(maxdate);
					Calendar cal = Calendar.getInstance();
					Date currentDate = cal.getTime();

					if (conMaxDate.getTime() < currentDate.getTime()) {
						post.setnExtStep(hlp.getCurrentStatus());
						post.setCurrentStep("Uploading Answer Key");
					} else {
						post.setCurrentStep("Objections Open");
					}
				}

			}
			
			if (post.getnExtStep().equalsIgnoreCase("Upload Revised Answer Key")) {
				CountHelper hlp = new CountHelper();
				hlp.setCurrentStatus("Objections Close");
				hlp.setsRNo(post.getsRNo());
				if (CommonUtils.isNotEmpty(post.getObjectionsClosedList())) {
					for (int i = 0; i < post.getObjectionsClosedList().size(); i++) {
						dates.add(i, post.getObjectionsClosedList().get(i).getObjectionsClosed());
					}
					maxdate = fmt.format(Collections.max(dates));
					Date conMaxDate = fmt.parse(maxdate);
					Calendar cal = Calendar.getInstance();
					Date currentDate = cal.getTime();

					if (conMaxDate.getTime() < currentDate.getTime()) {
						post.setnExtStep(hlp.getCurrentStatus());
						post.setCurrentStep("Objections Open");
					} else {
						post.setCurrentStep("Objections Close");
					}
				}

			}
			
			if (post.getnExtStep().equalsIgnoreCase("Result of Written Exam")) {
				CountHelper hlp = new CountHelper();
				hlp.setCurrentStatus("Upload Revised Answer Key");
				hlp.setsRNo(post.getsRNo());
				if (CommonUtils.isNotEmpty(post.getUploadedRevisedAnswerKeyList())) {
					for (int i = 0; i < post.getUploadedRevisedAnswerKeyList().size(); i++) {
						dates.add(i, post.getUploadedRevisedAnswerKeyList().get(i).getUploadedRevisedAnswerKey());
					}
					maxdate = fmt.format(Collections.max(dates));
					Date conMaxDate = fmt.parse(maxdate);
					Calendar cal = Calendar.getInstance();
					Date currentDate = cal.getTime();

					if (conMaxDate.getTime() < currentDate.getTime()) {
						post.setnExtStep(hlp.getCurrentStatus());
						post.setCurrentStep("Objections Close");
					} else {
						post.setCurrentStep("Upload Revised Answer Key");
					}
				}

			}
			
			if (post.getnExtStep().equalsIgnoreCase("Scrutiny")) {
				CountHelper hlp = new CountHelper();
				hlp.setCurrentStatus("Result of Written Exam");
				hlp.setsRNo(post.getsRNo());
				if (CommonUtils.isNotEmpty(post.getResultOfWrittenExamList())) {
					for (int i = 0; i < post.getResultOfWrittenExamList().size(); i++) {
						dates.add(i, post.getResultOfWrittenExamList().get(i).getResultOfWrittenExam());
					}
					maxdate = fmt.format(Collections.max(dates));
					Date conMaxDate = fmt.parse(maxdate);
					Calendar cal = Calendar.getInstance();
					Date currentDate = cal.getTime();

					if (conMaxDate.getTime() < currentDate.getTime()) {
						post.setnExtStep(hlp.getCurrentStatus());
						post.setCurrentStep("Upload Revised Answer Key");
					} else {
						post.setCurrentStep("Result of Written Exam");
					}
				}

			}
			
			if (post.getnExtStep().equalsIgnoreCase("Scrutiny Results")) {
				CountHelper hlp = new CountHelper();
				hlp.setCurrentStatus("Scrutiny");
				hlp.setsRNo(post.getsRNo());
				if (CommonUtils.isNotEmpty(post.getScrutinyEndDateList())) {
					for (int i = 0; i < post.getScrutinyEndDateList().size(); i++) {
						dates.add(i, post.getScrutinyEndDateList().get(i).getScrutinyEndDate());
					}
					maxdate = fmt.format(Collections.max(dates));
					Date conMaxDate = fmt.parse(maxdate);
					Calendar cal = Calendar.getInstance();
					Date currentDate = cal.getTime();

					if (conMaxDate.getTime() < currentDate.getTime()) {
						post.setnExtStep(hlp.getCurrentStatus());
						post.setCurrentStep("Result of Written Exam");
					} else {
						post.setCurrentStep("Scrutiny");
					}
				}

			}
			if (post.getnExtStep().equalsIgnoreCase("PMT Height-Chest (For Police only)")) {
				CountHelper hlp = new CountHelper();
				hlp.setCurrentStatus("Scrutiny Results");
				hlp.setsRNo(post.getsRNo());
				if (CommonUtils.isNotEmpty(post.getScrutinyResultsList())) {
					for (int i = 0; i < post.getScrutinyResultsList().size(); i++) {
						dates.add(i, post.getScrutinyResultsList().get(i).getScrutinyResults());
					}
					maxdate = fmt.format(Collections.max(dates));
					Date conMaxDate = fmt.parse(maxdate);
					Calendar cal = Calendar.getInstance();
					Date currentDate = cal.getTime();

					if (conMaxDate.getTime() < currentDate.getTime()) {
						post.setnExtStep(hlp.getCurrentStatus());
						post.setCurrentStep("Scrutiny");
					} else {
						post.setCurrentStep("Scrutiny Results");
					}
				}

			}
			
			if (post.getnExtStep().equalsIgnoreCase("Admit Cards(for Interview)")) {
				CountHelper hlp = new CountHelper();
				hlp.setCurrentStatus("PMT Height-Chest (For Police only)");
				hlp.setsRNo(post.getsRNo());
				if (CommonUtils.isNotEmpty(post.getpMTHeightChestList())) {
					for (int i = 0; i < post.getpMTHeightChestList().size(); i++) {
						dates.add(i, post.getpMTHeightChestList().get(i).getPmtHeightChest());
					}
					maxdate = fmt.format(Collections.max(dates));
					Date conMaxDate = fmt.parse(maxdate);
					Calendar cal = Calendar.getInstance();
					Date currentDate = cal.getTime();

					if (conMaxDate.getTime() < currentDate.getTime()) {
						post.setnExtStep(hlp.getCurrentStatus());
						post.setCurrentStep("Scrutiny Results");
					} else {
						post.setCurrentStep("PMT Height-Chest (For Police only)");
					}
				}

			}
			
			if (post.getnExtStep().equalsIgnoreCase("Interviews")) {
				CountHelper hlp = new CountHelper();
				hlp.setCurrentStatus("Admit Cards(for Interview)");
				hlp.setsRNo(post.getsRNo());
				if (CommonUtils.isNotEmpty(post.getAdmitCardsForInterviewList())) {
					for (int i = 0; i < post.getAdmitCardsForInterviewList().size(); i++) {
						dates.add(i, post.getAdmitCardsForInterviewList().get(i).getAdmitCardsForInterview());
					}
					maxdate = fmt.format(Collections.max(dates));
					Date conMaxDate = fmt.parse(maxdate);
					Calendar cal = Calendar.getInstance();
					Date currentDate = cal.getTime();

					if (conMaxDate.getTime() < currentDate.getTime()) {
						post.setnExtStep(hlp.getCurrentStatus());
						post.setCurrentStep("PMT Height-Chest (For Police only)");
					} else {
						post.setCurrentStep("Admit Cards(for Interview)");
					}
				}

			}
			
			if (post.getnExtStep().equalsIgnoreCase("Announcement of Final Result")) {
				CountHelper hlp = new CountHelper();
				hlp.setCurrentStatus("Interviews");
				hlp.setsRNo(post.getsRNo());
				if (CommonUtils.isNotEmpty(post.getInterviewEndDateList())) {
					for (int i = 0; i < post.getInterviewEndDateList().size(); i++) {
						dates.add(i, post.getInterviewEndDateList().get(i).getInterviewEndDate());
					}
					maxdate = fmt.format(Collections.max(dates));
					Date conMaxDate = fmt.parse(maxdate);
					Calendar cal = Calendar.getInstance();
					Date currentDate = cal.getTime();

					if (conMaxDate.getTime() < currentDate.getTime()) {
						post.setnExtStep(hlp.getCurrentStatus());
						post.setCurrentStep("Admit Cards(for Interview)");
					} else {
						post.setCurrentStep("Interviews");
					}
				}

			}
			
			if (post.getnExtStep().equalsIgnoreCase("Recommend")) {
				CountHelper hlp = new CountHelper();
				hlp.setCurrentStatus("Announcement of Final Result");
				hlp.setsRNo(post.getsRNo());
				if (CommonUtils.isNotEmpty(post.getAnnouncementOfResultsList())) {
					for (int i = 0; i < post.getAnnouncementOfResultsList().size(); i++) {
						dates.add(i, post.getAnnouncementOfResultsList().get(i).getAnnouncementOfResults());
					}
					maxdate = fmt.format(Collections.max(dates));
					Date conMaxDate = fmt.parse(maxdate);
					Calendar cal = Calendar.getInstance();
					Date currentDate = cal.getTime();

					if (conMaxDate.getTime() < currentDate.getTime()) {
						post.setnExtStep(hlp.getCurrentStatus());
						post.setCurrentStep("Interviews");
					} else {
						post.setCurrentStep("Announcement of Final Result");
					}
				}

			}
			
			if (post.getnExtStep().equalsIgnoreCase("Joining")) {
				CountHelper hlp = new CountHelper();
				hlp.setCurrentStatus("Recommend");
				hlp.setsRNo(post.getsRNo());
				if (CommonUtils.isNotEmpty(post.getRecommendedDateList())) {
					for (int i = 0; i < post.getRecommendedDateList().size(); i++) {
						dates.add(i, post.getRecommendedDateList().get(i).getRecommendedDate());
					}
					maxdate = fmt.format(Collections.max(dates));
					Date conMaxDate = fmt.parse(maxdate);
					Calendar cal = Calendar.getInstance();
					Date currentDate = cal.getTime();

					if (conMaxDate.getTime() < currentDate.getTime()) {
						post.setnExtStep(hlp.getCurrentStatus());
						post.setCurrentStep("Announcement of Final Result");
					} else {
						post.setCurrentStep("Recommend");
					}
				}

			}

		}*/
	}

	@RequestMapping(value = "/addDepartment", method = { RequestMethod.GET, RequestMethod.POST })
	public String addNewDepartment(Model model, @ModelAttribute("deptObj") Department department) throws Exception {
		try {
			if (department.getdEpartment() == "") {
				model.addAttribute("failed", "department should not be blank");
				return "stepWiseDetailsEdit";
			}
			baseDataService.addNewDepartment(department);
			List<Department> departmentList = baseDataService.loadAllDepartments();
			model.addAttribute("deptList", departmentList);
			model.addAttribute("success",
					"New Department has been Added please select the department name from dropdown List");
		} catch (Exception e) {
			logger.logError("addDepartment", "exception while adding details", e);
		}
		return "stepWiseDetailsEdit";

	}

	@RequestMapping(value = "/addNewAdvertisement", method = { RequestMethod.GET, RequestMethod.POST })
	public String addPostDetailsForAdmin(Model model) throws Exception {

		List<Department> departmentList = baseDataService.loadAllDepartments();
		model.addAttribute("deptList", departmentList);
		return "stepWiseDetailsEdit";
	}

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public String forgotPassword(ModelMap model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			model.put("UserData", new UserLogin());
			return "forgotPassword";
		} else {
			return "forgotPassword";
		}
	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public String resetPassword(Model model, HttpServletRequest request, @RequestParam("email") String Email) {
		try {

			UserLogin user = baseDataDao.getVerifiedUser(Email);
			if (user == null) {
				model.addAttribute("noUser", "Email does not exist");
				return "forgotPassword";
			}

			EmailTemplate obj = baseDataService.getemailTemplateCode("ResetPassword");
			String emailTxt=null;
			
			String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort()+ request.getContextPath();
			String token = UUID.randomUUID().toString();
			baseDataDao.createPasswordResetToken(user, token);
			String url = appUrl + "/changePassword?id=" + user.getUserId() + "&token=" + token;
			
			if(obj.getEmailType().contains("ResetPassword")){
				emailTxt=obj.getEmailHeadOne()+obj.getEmailCss()+obj.getEmailHeadTwo()+obj.getEmailBodyOne()+user.getCandidateName()
				+obj.getEmailBodyTwo()+url+obj.getEmailBodyThree()+obj.getEmailFooter();
				}
			
			EmailLogs emailObj = new EmailLogs();
			emailObj.setEmailrecipient(user.getEmail());
			emailObj.setEmailSubject("Reset Password");
			emailObj.setEmailBody(emailTxt);
			
			EmailLogs sentEmail = emailService.sendEmail(emailObj);
			
			emailService.saveEmailLogs(sentEmail);
			model.addAttribute("Success", "check your email for reset password link");
		} catch (Exception e) {
			logger.logError("resendToken", "Exception while sending the token", e);
		}
		return "forgotPassword";
	}
	
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String showChangePasswordPage(Locale locale, Model model, @RequestParam("id") long id,
			@RequestParam("token") String token) {
		try {
			PasswordResetToken passToken = baseDataDao.getPasswordResetUser(token);

			if ((passToken == null) || (passToken.getUserId() != id)) {
				return "invalidToken";
			}

			Calendar cal = Calendar.getInstance();
			if ((passToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
				model.addAttribute("failed", "Your Reset password Link has been Exipired request for new link");
				return "forgotPassword";
			}
			Integer userId = passToken.getUserId();
			UserLogin user=baseDataDao.getChangedPasswordUserData(userId);
			model.addAttribute("userList", user);
		} catch (Exception e) {
			logger.logError("changePassword", "Exception while getting user", e);
		}
		model.addAttribute("Success", "You Email has been Verified");
		return "/updatePassword";
	}

	@RequestMapping(value = "/saveNewPassword", method = RequestMethod.POST)
	public String saveNewPassword(Locale locale, Model model, @ModelAttribute("UserData") UserLogin passwordDto) {
		try {

			String password = passwordDto.getUserPassword();
			if (password.equalsIgnoreCase("")) {
				model.addAttribute("failed1", "password feild Should not be blank");
				model.addAttribute("userList", passwordDto);
				return "updatePassword";

			}

			String hexPassword = passwordEncryptor(password);
			passwordDto.setUserPassword(hexPassword);

			baseDataDao.updateUserPassword(passwordDto);
			model.addAttribute("passwordChanged", "Your Password has been successfully changed");
		} catch (Exception e) {
			logger.logError("saveNewPassword", "Exception while saving new Password", e);
		}

		return "login";
	}

	public String passwordEncryptor(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte byteData[] = md.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				String hex = Integer.toHexString(0xff & byteData[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
				password = hexString.toString();
			}
			System.out.println("Digest(in hex format):: " + hexString.toString());

		} catch (Exception e) {
			logger.logError("passwordEncryptor", "Exception while encrypting password", e);
		}
		return password;
	}

	@RequestMapping(value = "/changePasswordInSession", method = RequestMethod.GET)
	public String changePassword(ModelMap model, HttpSession session) {
		UserLogin user = (UserLogin) session.getAttribute("user");
		if (session.getAttribute("user") == null) {
			model.put("UserData", new UserLogin());
			return "login";
		} else {
			model.addAttribute("userDetails", user);
			return "changePassword";
		}
	}

	@RequestMapping(value = "changePasswordInSession", method = RequestMethod.POST)
	public String savePassword(ModelMap model, UserLogin user, HttpSession session) {
		try {
			if (user.getOldPassword() == "" || user.getUserPassword() == "") {
				model.addAttribute("failed", " password Feilds cannot be blank");
				model.addAttribute("userDetails", user);
				return "changePassword";
			}
			UserLogin userDetails = (UserLogin) session.getAttribute("user");
			Integer userId = userDetails.getUserId();
			String password = user.getOldPassword();
			String hexPassword = passwordEncryptor(password);
			user.setOldPassword(hexPassword);

			String oldPasswordFront = user.getOldPassword();

			UserLogin changePasswordUserData = baseDataDao.getChangedPasswordUserData(userId);
			user.setEmail(changePasswordUserData.getEmail());
			String oldPasswordBack = changePasswordUserData.getUserPassword();

			if (oldPasswordFront.equalsIgnoreCase(oldPasswordBack)) {
				String newPassword = user.getUserPassword();
				hexPassword = passwordEncryptor(newPassword);
				user.setUserPassword(hexPassword);
				baseDataDao.saveLastPasswords(user);
			} else {
				model.addAttribute("failed", " old Password is wrong");
				model.addAttribute("userDetails", user);
				return "changePassword";
			}
		} catch (Exception e) {
			logger.logError("changeExpiredPassword", "Exception while saving new Password", e);
		}
		model.addAttribute("Success", "Your password has been successfully changed");
		session.removeAttribute("user");
		return "login";
	}

	@RequestMapping(value = "exportPage", method = { RequestMethod.GET, RequestMethod.POST })
	public String exportPage(UserLogin user, Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("nAmeOfPost") String nAmeOfPost, @ModelAttribute("aDvtNo") String aDvtNo,
			@ModelAttribute("mAcroStatus") String mAcroStatus, @ModelAttribute("dEpartmentId") String dEpartmentId,
			@ModelAttribute("nExtStep") String nExtStep, @ModelAttribute("pageSizeTotal") String pageSizeTotal,
			String action) throws Exception {
		try {
			Integer sessionDepart = (Integer) session.getAttribute("idDept");
			List<Department> departmentNameListObj = new ArrayList<Department>();

			ExtendedPaginatedList paginatedList = getPaginatedListFromRequest(request);
			if (CommonUtils.isNotEmpty(action) && action.equalsIgnoreCase("export")) {
				if (CommonUtils.isNotEmpty(pageSizeTotal)) {
					paginatedList.setPageSize(Integer.parseInt(pageSizeTotal));
				}
			}

			/*
			 * if(CommonUtils.isNotEmpty(paginatedList.getSortCriterion())){ nAmeOfPost =
			 * (String)session.getAttribute("nAmeOfPostSess"); aDvtNo =
			 * (String)session.getAttribute("aDvtNoSess"); mAcroStatus =
			 * (String)session.getAttribute("mAcroStatusSess"); dEpartmentId =
			 * (String)session.getAttribute("dEpartmentIdSess"); nExtStep =
			 * (String)session.getAttribute("nExtStepSess"); }
			 */
			Police searcPolice = new Police();
			searcPolice.setnAmeOfPost(nAmeOfPost);
			searcPolice.setaDvtNo(aDvtNo);
			searcPolice.setmAcroStatus(mAcroStatus);
			if (CommonUtils.isEmpty(sessionDepart)) {
				if (CommonUtils.isNotEmpty(dEpartmentId)) {
					searcPolice.setdEpartmentId(Integer.parseInt(dEpartmentId));
				}
			}

			paginatedList = baseDataService.getAllPostData(sessionDepart, searcPolice, paginatedList);
			model.addAttribute("allHsscPostListForDept", paginatedList);
			if (CommonUtils.isNotEmpty(paginatedList)) {
				model.addAttribute("pageSize", paginatedList.getPageSize());
				List<Police> allHsscPostListForDept = paginatedList.getList();
				model.addAttribute("deptName", allHsscPostListForDept.get(0).getDeptObj().getdEpartment());
			}

			model.addAttribute("departmentNameListObj", departmentNameListObj);
			model.addAttribute("pageSizeTotal", paginatedList.getTotalNumberOfRows());
			model.addAttribute("nAmeOfPost", nAmeOfPost);
			model.addAttribute("aDvtNo", aDvtNo);
			model.addAttribute("mAcroStatus", mAcroStatus);
			model.addAttribute("dEpartmentId", dEpartmentId);
			model.addAttribute("nExtStep", nExtStep);

			/*
			 * session.setAttribute("nAmeOfPostSess", nAmeOfPost);
			 * session.setAttribute("aDvtNoSess", aDvtNo);
			 * session.setAttribute("mAcroStatusSess", mAcroStatus);
			 * session.setAttribute("dEpartmentIdSess", dEpartmentId);
			 * session.setAttribute("nExtStepSess", nExtStep);
			 */

		} catch (Exception e) {
			logger.logError("getDash", "exception while getting AllPostData", e);
		}
         
		return "popUp";

	}

	@RequestMapping(value = "macroStatusWiseGraph", method = { RequestMethod.GET, RequestMethod.POST })
	public String test(Model model,@ModelAttribute("mAcroStatus") String mAcroStatus) {
		return "misDashboard";
	}

	@RequestMapping(value = "getStatusCountValue", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<DepartmentVO> Submit(@RequestParam("stat") String status, HttpSession session,
			ModelMap model) {
		long total = 0, totalNoOfPost = 0;
		Integer dEpartmentId = (Integer) session.getAttribute("idDept");
		List<DepartmentVO> statusCountValueList = baseDataService.getStatusCountValue(status, dEpartmentId);
		for (DepartmentVO d : statusCountValueList) {
			totalNoOfPost += d.getnOOfPosts();
		}
		statusCountValueList.get(0).setTotal(total);
		statusCountValueList.get(0).setTotalNoOfPosts(totalNoOfPost);
		return statusCountValueList;
	}

	@RequestMapping(value = "getDeadlineGraphValues", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CountHelper> SubmitResponse(@RequestParam("stat") String status, HttpSession session,
			ModelMap model) {

		if (status.equalsIgnoreCase("Applications")) {
			return cnthlprForAplOpenListGlobal;
		}
		if (status.equalsIgnoreCase("Written Exam")) {
			return cnthlprForWrtnExmListGlobal;
		}
		if (status.equalsIgnoreCase("Scrutiny Of Documents")) {
			return cnthlprForScrutinyListGlobal;
		}
		if (status.equalsIgnoreCase("Interviews")) {
			return cnthlprForInterviewListGlobal;
		}
		if (status.equalsIgnoreCase("Result & Recommendations")) {
			return cnthlprForRecommendListGlobal;
		}

		return null;
	}
	
	
	@RequestMapping(value = "/uploadFile", method = {RequestMethod.POST, RequestMethod.GET})
	public String uploadFile(Model model,@RequestParam("file") MultipartFile file, @RequestParam("dEpartmentId")String dEpartmentId, @RequestParam("sRNo") String sRNo) throws NumberFormatException, Exception {
		   String strErrorMessage="";
		try {
			strErrorMessage = validateUploadedFile(file);
			  if("".equals(strErrorMessage)){
				  File uploadFile = writeFile(file,Integer.parseInt(dEpartmentId), Integer.parseInt(sRNo));		
				  
				  if (uploadFile != null) {
						strErrorMessage = "File Uploaded Successfully!!";
					} else {
						strErrorMessage = "An error occur while uploading file.";
					}
			  }
			  else {
				  return getPostDetails(model,Integer.parseInt(sRNo),strErrorMessage);
			  }
		} catch (Exception e) {
			logger.logError("uploadFile", "exception in uploadFile Controller.", e);
			throw e;
		}
		return getPostDetails(model,Integer.parseInt(sRNo),strErrorMessage);
	}
	
	private String validateUploadedFile(final MultipartFile file) {
		String errorMessage = "";
		if (file != null && file.getSize() > 0) {
			if (file.getSize() <= 10485760) {
				try {
					final String strFileName = file.getOriginalFilename();
					int dotPos = strFileName.indexOf(".");
					if (dotPos != -1) {
						final String strFileType = strFileName.substring(dotPos + 1);
						if (!CommonUtils.validateUploadFileName(strFileName)) {
							errorMessage = "Special characters are not allowed in file name.";
						} else if (!"xls".equalsIgnoreCase(strFileType) && !"xlsx".equalsIgnoreCase(strFileType))
								 {
							errorMessage = "Please upload files having extensions: .xls or .xlsx";
						}
					} else {
						errorMessage = "Please select valid file.";
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					errorMessage = "An error occur while uploading file.";
				}
			} else {
				errorMessage = "Maximum file size to be uploaded should not be greater than 10mb.";
			}
		} else {
			errorMessage = "Please select a file to upload.";
		}
		return errorMessage;
	}
	
	private File writeFile(final MultipartFile file, final Integer dEpartmentId, final Integer sRNo) {
		OutputStream outputStream = null;
		InputStream inputStream = null;
		File diskFile=null;
		DepartmentDocs deptObj=new DepartmentDocs();
		if (!file.getOriginalFilename().equalsIgnoreCase("")) {
			try {
				byte[] bytes = file.getBytes();
				final String strFileName = file.getOriginalFilename();
				final int dotPos = strFileName.indexOf(".");
				if (dotPos != -1) {
					HsscConfig config = requisitionService.getHSSCConfig();
					String strFilePath = config.getHsscBaseFolderPath() + File.separator + "Department" + File.separator
							+ sRNo;
					final File path = new File(strFilePath);
					if (!path.exists()){
						path.mkdirs();
					}
					diskFile = new File(path + File.separator + "candidateList" + dEpartmentId +sRNo+"." + "xlsx");
					deptObj.setDocType("candidateList");
					deptObj.setDocUrl(strFilePath + File.separator + "candidateList" + dEpartmentId +sRNo+ "." + "xlsx");
					deptObj.setFileName("candidateList" + dEpartmentId +sRNo+ "." + "xlsx");
					
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(diskFile));
					stream.write(bytes);
					stream.close();
					
					deptObj.setdEpartmentId(dEpartmentId);
					deptObj.setsRNo(sRNo);
					baseDataService.savePathForDepartmentDocs(deptObj);	
				} else {
					diskFile = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
				diskFile = null;
				this.clearResource(outputStream, inputStream);
			} finally {
				this.clearResource(outputStream, inputStream);
			}
		}
		return diskFile;
	}

	private void clearResource(final OutputStream outputStream, final InputStream inputStream) {
		if (outputStream != null) {
			try {
				outputStream.close();
				outputStream.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(value = "/downloadCandidateList", method = { RequestMethod.GET, RequestMethod.POST })
	public void downLoadDocument(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("sRNoForDownload") String sRNoForDownload,@RequestParam("dEpartmentIdForDownload") String dEpartmentIdForDownload, @RequestParam("docType") String docType)
			throws Exception {
		FileInputStream inputStream = null;
		ServletOutputStream outStream = null;
		try {
			HsscConfig hssscObj = requisitionService.getHSSCConfig();
			File CandidateList = new File(
					hssscObj.getHsscBaseFolderPath() + File.separator + "Department" + File.separator + 
					sRNoForDownload + File.separator + docType +dEpartmentIdForDownload+ sRNoForDownload + ".xlsx");
			if (CandidateList.exists()) {
				inputStream = new FileInputStream(CandidateList);
				response.setContentType("application/force-download");
				response.setHeader("Content-Disposition",
						"attachment; filename=" + docType +dEpartmentIdForDownload+ sRNoForDownload + ".xlsx");
				outStream = response.getOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}
				System.out.println("Downloading.");
			} else {
				System.out.println("Sorry! File could not be downloaded.");
			}
		} catch (Exception e) {
			logger.logError("downloadDocument", "error while downloading document", e);
			throw e;
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				if (outStream != null) {
					outStream.close();
				}
			} catch (Exception e2) {
				logger.logError("download", "Finally", e2);
			}
		}
	}
	
	public List<CMDashboardJSONRequestData> getRequestData(HttpSession session){
		     List<CMDashboardJSONRequestData> dashBoardData=new ArrayList<CMDashboardJSONRequestData>();
		     CMDashboardJSONRequestData dashBoardObj=new CMDashboardJSONRequestData();
		 try {   
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				List<Police> policeAllDataList = baseDataService.getAllHsscPostList();
				HashMap<Integer, Police> uniquePoliceMap = new HashMap<Integer, Police>();
				if (CommonUtils.isNotEmpty(policeAllDataList)) {
					for (Police pol : policeAllDataList) {
						if (!uniquePoliceMap.containsKey(pol.getsRNo())) {
							uniquePoliceMap.put(pol.getsRNo(), pol);
						}
					}
				}
				List<CountHelper> cnthlprForAplOpenList = new ArrayList<CountHelper>();
				List<CountHelper> cnthlprForWrtnExmList = new ArrayList<CountHelper>();
				List<CountHelper> cnthlprForScrutinyList = new ArrayList<CountHelper>();
				List<CountHelper> cnthlprForInterviewList = new ArrayList<CountHelper>();
				List<CountHelper> cnthlprForRecommendList = new ArrayList<CountHelper>();

				for (Police pol : uniquePoliceMap.values()) {
					if (CommonUtils.isNotEmpty(pol.getnExtStep())) {

						if (pol.getnExtStep().equalsIgnoreCase("Applications Close")) {
							CountHelper hlpr = new CountHelper();
							int red = 0;
							int yellow = 0;
							hlpr.setCurrentStatus("Admit Cards");
							hlpr.setsRNo(pol.getsRNo());
							hlpr.setAdvtNo(pol.getaDvtNo());
							hlpr.setPostName(pol.getnAmeOfPost());
							hlpr.setCatNo(pol.getcAtNo());
							hlpr.setDeptName(pol.getDeptName());
							if (CommonUtils.isNotEmpty(pol.getApplicationOpenList())
									&& CommonUtils.isNotEmpty(pol.getAdmitCardsList())) {

								Date dateBefore = sdf
										.parse(pol.getApplicationOpenList().get(0).getApplicationopen().toString());
								Date dateAfter = sdf.parse(pol.getAdmitCardsList().get(0).getAdmitcard().toString());
								long difference = dateAfter.getTime() - dateBefore.getTime();
								float daysBetween = (difference / (1000 * 60 * 60 * 24));
								if (daysBetween > 7) {
									red = red + 1;
								} else {
									yellow = yellow + 1;
								}

							} else {
								yellow = yellow + 1;
							}
							hlpr.setRedCount(red);
							hlpr.setYellowCount(yellow);
							cnthlprForAplOpenList.add(hlpr);
						}

						if (pol.getnExtStep().equalsIgnoreCase("Admit Cards")) {
							CountHelper hlpr = new CountHelper();
							int red = 0;
							int yellow = 0;
							hlpr.setCurrentStatus("Applications Close");
							hlpr.setsRNo(pol.getsRNo());
							hlpr.setAdvtNo(pol.getaDvtNo());
							hlpr.setPostName(pol.getnAmeOfPost());
							hlpr.setCatNo(pol.getcAtNo());
							hlpr.setDeptName(pol.getDeptName());
							if (CommonUtils.isNotEmpty(pol.getApplicationOpenList())
									&& CommonUtils.isNotEmpty(pol.getApplicationClosedList())) {

								Date dateBefore = sdf
										.parse(pol.getApplicationOpenList().get(0).getApplicationopen().toString());
								Date dateAfter = sdf
										.parse(pol.getApplicationClosedList().get(0).getApplicationclosed().toString());
								long difference = dateAfter.getTime() - dateBefore.getTime();
								float daysBetween = (difference / (1000 * 60 * 60 * 24));
								if (daysBetween > 7) {
									red = red + 1;
								} else {
									yellow = yellow + 1;
								}

							} else {
								yellow = yellow + 1;
							}
							hlpr.setRedCount(red);
							hlpr.setYellowCount(yellow);
							cnthlprForAplOpenList.add(hlpr);
						}

						if (pol.getnExtStep().equalsIgnoreCase("PST Start(For Police only)")) {
							CountHelper hlpr = new CountHelper();
							int red = 0;
							int yellow = 0;
							hlpr.setCurrentStatus("Admit Cards");
							hlpr.setsRNo(pol.getsRNo());
							hlpr.setAdvtNo(pol.getaDvtNo());
							hlpr.setPostName(pol.getnAmeOfPost());
							hlpr.setCatNo(pol.getcAtNo());
							hlpr.setDeptName(pol.getDeptName());
							if (CommonUtils.isNotEmpty(pol.getApplicationOpenList())
									&& CommonUtils.isNotEmpty(pol.getAdmitCardsList())) {

								Date dateBefore = sdf
										.parse(pol.getApplicationOpenList().get(0).getApplicationopen().toString());
								Date dateAfter = sdf.parse(pol.getAdmitCardsList().get(0).getAdmitcard().toString());
								long difference = dateAfter.getTime() - dateBefore.getTime();
								float daysBetween = (difference / (1000 * 60 * 60 * 24));
								if (daysBetween > 7) {
									red = red + 1;
								} else {
									yellow = yellow + 1;
								}

							} else {
								yellow = yellow + 1;
							}
							hlpr.setRedCount(red);
							hlpr.setYellowCount(yellow);
							cnthlprForAplOpenList.add(hlpr);
						}

						if (pol.getnExtStep().equalsIgnoreCase("PST End(For Police only)")) {
							CountHelper hlpr = new CountHelper();
							int red = 0;
							int yellow = 0;
							hlpr.setCurrentStatus("PST Start(For Police only)");
							hlpr.setsRNo(pol.getsRNo());
							hlpr.setAdvtNo(pol.getaDvtNo());
							hlpr.setPostName(pol.getnAmeOfPost());
							hlpr.setCatNo(pol.getcAtNo());
							hlpr.setDeptName(pol.getDeptName());
							if (CommonUtils.isNotEmpty(pol.getApplicationOpenList())
									&& CommonUtils.isNotEmpty(pol.getPstStartList())) {

								Date dateBefore = sdf
										.parse(pol.getApplicationOpenList().get(0).getApplicationopen().toString());
								Date dateAfter = sdf.parse(pol.getPstStartList().get(0).getPststart().toString());
								long difference = dateAfter.getTime() - dateBefore.getTime();
								float daysBetween = (difference / (1000 * 60 * 60 * 24));
								if (daysBetween > 7) {
									red = red + 1;
								} else {
									yellow = yellow + 1;
								}

							} else {
								yellow = yellow + 1;
							}
							hlpr.setRedCount(red);
							hlpr.setYellowCount(yellow);
							cnthlprForAplOpenList.add(hlpr);
						}

						if (pol.getnExtStep().equalsIgnoreCase("Result of PST(For Police only)")) {
							CountHelper hlpr = new CountHelper();
							int red = 0;
							int yellow = 0;
							hlpr.setCurrentStatus("PST End(For Police only)");
							hlpr.setsRNo(pol.getsRNo());
							hlpr.setAdvtNo(pol.getaDvtNo());
							hlpr.setPostName(pol.getnAmeOfPost());
							hlpr.setCatNo(pol.getcAtNo());
							hlpr.setDeptName(pol.getDeptName());
							if (CommonUtils.isNotEmpty(pol.getApplicationOpenList())
									&& CommonUtils.isNotEmpty(pol.getPstEndList())) {

								Date dateBefore = sdf
										.parse(pol.getApplicationOpenList().get(0).getApplicationopen().toString());
								Date dateAfter = sdf.parse(pol.getPstEndList().get(0).getPstend().toString());
								long difference = dateAfter.getTime() - dateBefore.getTime();
								float daysBetween = (difference / (1000 * 60 * 60 * 24));
								if (daysBetween > 7) {
									red = red + 1;
								} else {
									yellow = yellow + 1;
								}

							} else {
								yellow = yellow + 1;
							}
							hlpr.setRedCount(red);
							hlpr.setYellowCount(yellow);
							cnthlprForAplOpenList.add(hlpr);
						}

						if (pol.getnExtStep().equalsIgnoreCase("Uploading Answer Key")) {
							CountHelper hlpr = new CountHelper();
							int red = 0;
							int yellow = 0;
							hlpr.setCurrentStatus("Written Exam");
							hlpr.setsRNo(pol.getsRNo());
							hlpr.setAdvtNo(pol.getaDvtNo());
							hlpr.setPostName(pol.getnAmeOfPost());
							hlpr.setCatNo(pol.getcAtNo());
							hlpr.setDeptName(pol.getDeptName());
							if (CommonUtils.isNotEmpty(pol.getApplicationOpenList())
									&& CommonUtils.isNotEmpty(pol.getWrittenExamList())) {

								Date dateBefore = sdf
										.parse(pol.getApplicationOpenList().get(0).getApplicationopen().toString());
								Date dateAfter = sdf.parse(pol.getWrittenExamList().get(0).getWrittenExam().toString());
								long difference = dateAfter.getTime() - dateBefore.getTime();
								float daysBetween = (difference / (1000 * 60 * 60 * 24));
								if (daysBetween > 7) {
									red = red + 1;
								} else {
									yellow = yellow + 1;
								}

							} else {
								yellow = yellow + 1;
							}
							hlpr.setRedCount(red);
							hlpr.setYellowCount(yellow);
							cnthlprForAplOpenList.add(hlpr);
						}

						if (pol.getnExtStep().equalsIgnoreCase("Written Exam")) {
							CountHelper hlpr = new CountHelper();
							int red = 0;
							int yellow = 0;
							hlpr.setCurrentStatus("Applications Open");
							hlpr.setsRNo(pol.getsRNo());
							hlpr.setAdvtNo(pol.getaDvtNo());
							hlpr.setPostName(pol.getnAmeOfPost());
							hlpr.setCatNo(pol.getcAtNo());
							hlpr.setDeptName(pol.getDeptName());
							if (CommonUtils.isNotEmpty(pol.getAdvtPostedDateList())
									&& CommonUtils.isNotEmpty(pol.getApplicationOpenList())) {

								Date dateBefore = sdf
										.parse(pol.getAdvtPostedDateList().get(0).getAdvertisementPosted().toString());
								Date dateAfter = sdf
										.parse(pol.getApplicationOpenList().get(0).getApplicationopen().toString());
								long difference = dateAfter.getTime() - dateBefore.getTime();
								float daysBetween = (difference / (1000 * 60 * 60 * 24));
								if (daysBetween > 7) {
									red = red + 1;
								} else {
									yellow = yellow + 1;
								}

							} else {
								yellow = yellow + 1;
							}
							hlpr.setRedCount(red);
							hlpr.setYellowCount(yellow);
							cnthlprForAplOpenList.add(hlpr);
						}

						if (pol.getnExtStep().equalsIgnoreCase("Scrutiny")) {
							CountHelper hlpr = new CountHelper();
							int red = 0;
							int yellow = 0;
							hlpr.setCurrentStatus("Written Exam");
							hlpr.setsRNo(pol.getsRNo());
							hlpr.setAdvtNo(pol.getaDvtNo());
							hlpr.setPostName(pol.getnAmeOfPost());
							hlpr.setCatNo(pol.getcAtNo());
							hlpr.setDeptName(pol.getDeptName());
							if (CommonUtils.isNotEmpty(pol.getWrittenExamList())
									&& CommonUtils.isNotEmpty(pol.getApplicationOpenList())) {
								Date dateBefore = sdf
										.parse(pol.getApplicationOpenList().get(0).getApplicationopen().toString());
								Date dateAfter = sdf.parse(pol.getWrittenExamList().get(0).getWrittenExam().toString());
								long difference = dateAfter.getTime() - dateBefore.getTime();
								float daysBetween = (difference / (1000 * 60 * 60 * 24));
								if (daysBetween > 60) {
									red = red + 1;
								} else {
									yellow = yellow + 1;
								}

							} else {
								yellow = yellow + 1;
							}
							hlpr.setRedCount(red);
							hlpr.setYellowCount(yellow);
							cnthlprForWrtnExmList.add(hlpr);
						}

						if (pol.getnExtStep().equalsIgnoreCase("Objections Open")) {
							CountHelper hlpr = new CountHelper();
							int red = 0;
							int yellow = 0;
							hlpr.setCurrentStatus("Uploading Answer Key");
							hlpr.setsRNo(pol.getsRNo());
							hlpr.setAdvtNo(pol.getaDvtNo());
							hlpr.setPostName(pol.getnAmeOfPost());
							hlpr.setCatNo(pol.getcAtNo());
							hlpr.setDeptName(pol.getDeptName());
							if (CommonUtils.isNotEmpty(pol.getWrittenExamList())
									&& CommonUtils.isNotEmpty(pol.getUploadingAnswerKeyList())) {
								Date dateBefore = sdf.parse(pol.getWrittenExamList().get(0).getWrittenExam().toString());
								Date dateAfter = sdf
										.parse(pol.getUploadingAnswerKeyList().get(0).getUploadingAnswerKey().toString());
								long difference = dateAfter.getTime() - dateBefore.getTime();
								float daysBetween = (difference / (1000 * 60 * 60 * 24));
								if (daysBetween > 60) {
									red = red + 1;
								} else {
									yellow = yellow + 1;
								}

							} else {
								yellow = yellow + 1;
							}
							hlpr.setRedCount(red);
							hlpr.setYellowCount(yellow);
							cnthlprForWrtnExmList.add(hlpr);
						}

						if (pol.getnExtStep().equalsIgnoreCase("Objections Close")) {
							CountHelper hlpr = new CountHelper();
							int red = 0;
							int yellow = 0;
							hlpr.setCurrentStatus("Objections Open");
							hlpr.setsRNo(pol.getsRNo());
							hlpr.setAdvtNo(pol.getaDvtNo());
							hlpr.setPostName(pol.getnAmeOfPost());
							hlpr.setCatNo(pol.getcAtNo());
							hlpr.setDeptName(pol.getDeptName());
							if (CommonUtils.isNotEmpty(pol.getWrittenExamList())
									&& CommonUtils.isNotEmpty(pol.getObjectionsOpenList())) {
								Date dateBefore = sdf.parse(pol.getWrittenExamList().get(0).getWrittenExam().toString());
								Date dateAfter = sdf
										.parse(pol.getObjectionsOpenList().get(0).getObjectionsOpen().toString());
								long difference = dateAfter.getTime() - dateBefore.getTime();
								float daysBetween = (difference / (1000 * 60 * 60 * 24));
								if (daysBetween > 60) {
									red = red + 1;
								} else {
									yellow = yellow + 1;
								}

							} else {
								yellow = yellow + 1;
							}
							hlpr.setRedCount(red);
							hlpr.setYellowCount(yellow);
							cnthlprForWrtnExmList.add(hlpr);
						}

						if (pol.getnExtStep().equalsIgnoreCase("Upload Revised Answer Key")) {
							CountHelper hlpr = new CountHelper();
							int red = 0;
							int yellow = 0;
							hlpr.setCurrentStatus("Objections Close");
							hlpr.setsRNo(pol.getsRNo());
							hlpr.setAdvtNo(pol.getaDvtNo());
							hlpr.setPostName(pol.getnAmeOfPost());
							hlpr.setCatNo(pol.getcAtNo());
							hlpr.setDeptName(pol.getDeptName());
							if (CommonUtils.isNotEmpty(pol.getWrittenExamList())
									&& CommonUtils.isNotEmpty(pol.getObjectionsClosedList())) {
								Date dateBefore = sdf.parse(pol.getWrittenExamList().get(0).getWrittenExam().toString());
								Date dateAfter = sdf
										.parse(pol.getObjectionsClosedList().get(0).getObjectionsClosed().toString());
								long difference = dateAfter.getTime() - dateBefore.getTime();
								float daysBetween = (difference / (1000 * 60 * 60 * 24));
								if (daysBetween > 60) {
									red = red + 1;
								} else {
									yellow = yellow + 1;
								}

							} else {
								yellow = yellow + 1;
							}
							hlpr.setRedCount(red);
							hlpr.setYellowCount(yellow);
							cnthlprForWrtnExmList.add(hlpr);
						}

						if (pol.getnExtStep().equalsIgnoreCase("Result of Written Exam")) {
							CountHelper hlpr = new CountHelper();
							int red = 0;
							int yellow = 0;
							hlpr.setCurrentStatus("Upload Revised Answer Key");
							hlpr.setsRNo(pol.getsRNo());
							hlpr.setAdvtNo(pol.getaDvtNo());
							hlpr.setPostName(pol.getnAmeOfPost());
							hlpr.setCatNo(pol.getcAtNo());
							hlpr.setDeptName(pol.getDeptName());
							if (CommonUtils.isNotEmpty(pol.getWrittenExamList())
									&& CommonUtils.isNotEmpty(pol.getUploadedRevisedAnswerKeyList())) {
								Date dateBefore = sdf.parse(pol.getWrittenExamList().get(0).getWrittenExam().toString());
								Date dateAfter = sdf.parse(pol.getUploadedRevisedAnswerKeyList().get(0)
										.getUploadedRevisedAnswerKey().toString());
								long difference = dateAfter.getTime() - dateBefore.getTime();
								float daysBetween = (difference / (1000 * 60 * 60 * 24));
								if (daysBetween > 60) {
									red = red + 1;
								} else {
									yellow = yellow + 1;
								}

							} else {
								yellow = yellow + 1;
							}
							hlpr.setRedCount(red);
							hlpr.setYellowCount(yellow);
							cnthlprForWrtnExmList.add(hlpr);
						}

						if (pol.getnExtStep().equalsIgnoreCase("Scrutiny Results")) {
							CountHelper hlpr = new CountHelper();
							int red = 0;
							int yellow = 0;
							hlpr.setCurrentStatus("Scrutiny");
							hlpr.setsRNo(pol.getsRNo());
							hlpr.setAdvtNo(pol.getaDvtNo());
							hlpr.setPostName(pol.getnAmeOfPost());
							hlpr.setCatNo(pol.getcAtNo());
							hlpr.setDeptName(pol.getDeptName());
							if (CommonUtils.isNotEmpty(pol.getWrittenExamList())
									&& CommonUtils.isNotEmpty(pol.getScrutinyStartDateList())) {
								Date dateBefore = sdf.parse(pol.getWrittenExamList().get(0).getWrittenExam().toString());
								Date dateAfter = sdf
										.parse(pol.getScrutinyStartDateList().get(0).getScrutinyStartDate().toString());
								long difference = dateAfter.getTime() - dateBefore.getTime();
								float daysBetween = (difference / (1000 * 60 * 60 * 24));
								if (daysBetween > 60) {
									red = red + 1;
								} else {
									yellow = yellow + 1;
								}

							} else {
								yellow = yellow + 1;
							}
							hlpr.setRedCount(red);
							hlpr.setYellowCount(yellow);
							cnthlprForWrtnExmList.add(hlpr);
						}

						if (pol.getnExtStep().equalsIgnoreCase("Interviews")) {
							CountHelper hlpr = new CountHelper();
							int red = 0;
							int yellow = 0;
							hlpr.setCurrentStatus("Scrutiny");
							hlpr.setsRNo(pol.getsRNo());
							hlpr.setAdvtNo(pol.getaDvtNo());
							hlpr.setPostName(pol.getnAmeOfPost());
							hlpr.setCatNo(pol.getcAtNo());
							hlpr.setDeptName(pol.getDeptName());
							if (CommonUtils.isNotEmpty(pol.getScrutinyStartDateList())
									&& CommonUtils.isNotEmpty(pol.getWrittenExamList())) {
								Date dateBefore = sdf.parse(pol.getWrittenExamList().get(0).getWrittenExam().toString());
								Date dateAfter = sdf
										.parse(pol.getScrutinyStartDateList().get(0).getScrutinyStartDate().toString());
								long difference = dateAfter.getTime() - dateBefore.getTime();
								float daysBetween = (difference / (1000 * 60 * 60 * 24));
								if (daysBetween > 37) {
									red = red + 1;
								} else {
									yellow = yellow + 1;
								}

							} else {
								yellow = yellow + 1;
							}

							hlpr.setRedCount(red);
							hlpr.setYellowCount(yellow);
							cnthlprForScrutinyList.add(hlpr);
						}

						if (pol.getnExtStep().equalsIgnoreCase("PMT Height-Chest (For Police only)")) {
							CountHelper hlpr = new CountHelper();
							int red = 0;
							int yellow = 0;
							hlpr.setCurrentStatus("Scrutiny Results");
							hlpr.setsRNo(pol.getsRNo());
							hlpr.setAdvtNo(pol.getaDvtNo());
							hlpr.setPostName(pol.getnAmeOfPost());
							hlpr.setCatNo(pol.getcAtNo());
							hlpr.setDeptName(pol.getDeptName());
							if (CommonUtils.isNotEmpty(pol.getScrutinyStartDateList())
									&& CommonUtils.isNotEmpty(pol.getScrutinyResultsList())) {
								Date dateBefore = sdf
										.parse(pol.getScrutinyStartDateList().get(0).getScrutinyStartDate().toString());
								Date dateAfter = sdf
										.parse(pol.getScrutinyResultsList().get(0).getScrutinyResults().toString());
								long difference = dateAfter.getTime() - dateBefore.getTime();
								float daysBetween = (difference / (1000 * 60 * 60 * 24));
								if (daysBetween > 37) {
									red = red + 1;
								} else {
									yellow = yellow + 1;
								}

							} else {
								yellow = yellow + 1;
							}

							hlpr.setRedCount(red);
							hlpr.setYellowCount(yellow);
							cnthlprForScrutinyList.add(hlpr);
						}

						if (pol.getnExtStep().equalsIgnoreCase("Admit Cards(for Interview)")) {
							CountHelper hlpr = new CountHelper();
							int red = 0;
							int yellow = 0;
							hlpr.setCurrentStatus("PMT Height-Chest (For Police only)");
							hlpr.setsRNo(pol.getsRNo());
							hlpr.setAdvtNo(pol.getaDvtNo());
							hlpr.setPostName(pol.getnAmeOfPost());
							hlpr.setCatNo(pol.getcAtNo());
							hlpr.setDeptName(pol.getDeptName());
							if (CommonUtils.isNotEmpty(pol.getScrutinyStartDateList())
									&& CommonUtils.isNotEmpty(pol.getpMTHeightChestList())) {
								Date dateBefore = sdf
										.parse(pol.getScrutinyStartDateList().get(0).getScrutinyStartDate().toString());
								Date dateAfter = sdf
										.parse(pol.getpMTHeightChestList().get(0).getPmtHeightChest().toString());
								long difference = dateAfter.getTime() - dateBefore.getTime();
								float daysBetween = (difference / (1000 * 60 * 60 * 24));
								if (daysBetween > 37) {
									red = red + 1;
								} else {
									yellow = yellow + 1;
								}

							} else {
								yellow = yellow + 1;
							}

							hlpr.setRedCount(red);
							hlpr.setYellowCount(yellow);
							cnthlprForScrutinyList.add(hlpr);
						}

						if (pol.getnExtStep().equalsIgnoreCase("Interviews")) {
							CountHelper hlpr = new CountHelper();
							int red = 0;
							int yellow = 0;
							hlpr.setCurrentStatus("Admit Cards(for Interview)");
							hlpr.setsRNo(pol.getsRNo());
							hlpr.setAdvtNo(pol.getaDvtNo());
							hlpr.setPostName(pol.getnAmeOfPost());
							hlpr.setCatNo(pol.getcAtNo());
							hlpr.setDeptName(pol.getDeptName());
							if (CommonUtils.isNotEmpty(pol.getScrutinyStartDateList())
									&& CommonUtils.isNotEmpty(pol.getAdmitCardsForInterviewList())) {
								Date dateBefore = sdf
										.parse(pol.getScrutinyStartDateList().get(0).getScrutinyStartDate().toString());
								Date dateAfter = sdf.parse(
										pol.getAdmitCardsForInterviewList().get(0).getAdmitCardsForInterview().toString());
								long difference = dateAfter.getTime() - dateBefore.getTime();
								float daysBetween = (difference / (1000 * 60 * 60 * 24));
								if (daysBetween > 37) {
									red = red + 1;
								} else {
									yellow = yellow + 1;
								}

							} else {
								yellow = yellow + 1;
							}

							hlpr.setRedCount(red);
							hlpr.setYellowCount(yellow);
							cnthlprForScrutinyList.add(hlpr);
						}

						/*
						 * if(pol.getnExtStep().equalsIgnoreCase("Announcement of Final Result")){
						 * CountHelper hlpr=new CountHelper(); int red=0; int yellow=0;
						 * hlpr.setCurrentStatus("Interviews"); hlpr.setsRNo(pol.getsRNo());
						 * if(CommonUtils.isNotEmpty(pol.getScrutinyStartDateList())&&
						 * CommonUtils.isNotEmpty(pol.getInterviewStartDateList())){ Date
						 * dateBefore=sdf.parse(pol.getScrutinyStartDateList().get(0).
						 * getScrutinyStartDate().toString()); Date
						 * dateAfter=sdf.parse(pol.getInterviewStartDateList().get(0).
						 * getInterviewStartDate().toString()); long difference = dateAfter.getTime() -
						 * dateBefore.getTime(); float daysBetween = (difference / (1000*60*60*24));
						 * if(daysBetween>37) { red=red+1; }else{ yellow=yellow+1; }
						 * 
						 * }else{ yellow=yellow+1; }
						 * 
						 * hlpr.setRedCount(red); hlpr.setYellowCount(yellow);
						 * cnthlprForScrutinyList.add(hlpr); }
						 */

						if (pol.getnExtStep().equalsIgnoreCase("Recommend")) {
							CountHelper hlpr = new CountHelper();
							int red = 0;
							int yellow = 0;
							hlpr.setCurrentStatus("Interviews");
							hlpr.setsRNo(pol.getsRNo());
							hlpr.setAdvtNo(pol.getaDvtNo());
							hlpr.setPostName(pol.getnAmeOfPost());
							hlpr.setCatNo(pol.getcAtNo());
							hlpr.setDeptName(pol.getDeptName());
							if (CommonUtils.isNotEmpty(pol.getInterviewStartDateList())
									&& CommonUtils.isNotEmpty(pol.getScrutinyStartDateList())) {
								Date dateBefore = sdf
										.parse(pol.getScrutinyStartDateList().get(0).getScrutinyStartDate().toString());
								Date dateAfter = sdf
										.parse(pol.getInterviewStartDateList().get(0).getInterviewStartDate().toString());
								long difference = dateAfter.getTime() - dateBefore.getTime();
								float daysBetween = (difference / (1000 * 60 * 60 * 24));
								if (daysBetween > 28) {
									red = red + 1;
								} else {
									yellow = yellow + 1;
								}
							} else {
								yellow = yellow + 1;
							}
							System.out.println(yellow);
							hlpr.setRedCount(red);
							hlpr.setYellowCount(yellow);
							cnthlprForInterviewList.add(hlpr);
						}

						if (pol.getnExtStep().equalsIgnoreCase("Joining")) {
							CountHelper hlpr = new CountHelper();
							int red = 0;
							int yellow = 0;
							hlpr.setCurrentStatus("Recommend");
							hlpr.setsRNo(pol.getsRNo());
							hlpr.setAdvtNo(pol.getaDvtNo());
							hlpr.setPostName(pol.getnAmeOfPost());
							hlpr.setCatNo(pol.getcAtNo());
							hlpr.setDeptName(pol.getDeptName());
							if (CommonUtils.isNotEmpty(pol.getRecommendedDateList())
									&& CommonUtils.isNotEmpty(pol.getInterviewStartDateList())) {
								Date dateBefore = sdf
										.parse(pol.getInterviewStartDateList().get(0).getInterviewStartDate().toString());
								Date dateAfter = sdf
										.parse(pol.getRecommendedDateList().get(0).getRecommendedDate().toString());
								long difference = dateAfter.getTime() - dateBefore.getTime();
								float daysBetween = (difference / (1000 * 60 * 60 * 24));
								if (daysBetween > 2) {
									red = red + 1;
								} else {
									yellow = yellow + 1;
								}

							} else {
								yellow = yellow + 1;
							}
							hlpr.setRedCount(red);
							hlpr.setYellowCount(yellow);
							cnthlprForRecommendList.add(hlpr);
						}

					}
				}
				int aplOpenRedCount = 0;
				int aplOpenYellowCount = 0;
				int interviewRedCount = 0;
				int interviewYellowCount = 0;
				int recommendRedCount = 0;
				int recommendYellowCount = 0;
				int scrutinyRedCount = 0;
				int scrutinyYellowCount = 0;
				int wrtExamRedCount = 0;
				int wrtExamYellowCount = 0;
				cnthlprForAplOpenListGlobal = cnthlprForAplOpenList;
				cnthlprForInterviewListGlobal = cnthlprForInterviewList;
				cnthlprForRecommendListGlobal = cnthlprForRecommendList;
				cnthlprForScrutinyListGlobal = cnthlprForScrutinyList;
				cnthlprForWrtnExmListGlobal = cnthlprForWrtnExmList;

				for (int i = 0; i < cnthlprForAplOpenList.size(); i++) {
					aplOpenRedCount = aplOpenRedCount + cnthlprForAplOpenList.get(i).getRedCount();
					aplOpenYellowCount = aplOpenYellowCount + cnthlprForAplOpenList.get(i).getYellowCount();
				}
				for (int i = 0; i < cnthlprForInterviewList.size(); i++) {
					interviewRedCount = interviewRedCount + cnthlprForInterviewList.get(i).getRedCount();
					interviewYellowCount = interviewYellowCount + cnthlprForInterviewList.get(i).getYellowCount();
				}
				for (int i = 0; i < cnthlprForRecommendList.size(); i++) {
					recommendRedCount = recommendRedCount + cnthlprForRecommendList.get(i).getRedCount();
					recommendYellowCount = recommendYellowCount + cnthlprForRecommendList.get(i).getYellowCount();
				}
				for (int i = 0; i < cnthlprForScrutinyList.size(); i++) {
					scrutinyRedCount = scrutinyRedCount + cnthlprForScrutinyList.get(i).getRedCount();
					scrutinyYellowCount = scrutinyYellowCount + cnthlprForScrutinyList.get(i).getYellowCount();
				}
				for (int i = 0; i < cnthlprForWrtnExmList.size(); i++) {
					wrtExamRedCount = wrtExamRedCount + cnthlprForWrtnExmList.get(i).getRedCount();
					wrtExamYellowCount = wrtExamYellowCount + cnthlprForWrtnExmList.get(i).getYellowCount();
				}
				 
				Integer  totalYellowCount=wrtExamYellowCount+scrutinyYellowCount+scrutinyYellowCount+interviewYellowCount+aplOpenYellowCount;
				Integer  totalRequisitioncount=wrtExamYellowCount+wrtExamRedCount+scrutinyYellowCount+scrutinyRedCount+recommendRedCount+recommendYellowCount+
						 interviewYellowCount+interviewRedCount+aplOpenYellowCount+aplOpenRedCount;
			    
				long recommendedTotalNoOfPosts = 0;
				long inProcessTotalNoOfPosts = 0;
				long courtStayTotalNoOfPosts = 0;
				long backReferredTotalNoOfPosts=0;
				float percentageOfRequisitionsInIdealTime;
				Integer recommendedCount=0;
				Integer inProcessCount=0;
				Integer courtStayCount=0;
				Integer backReferredCount=0;
				Integer dEpartmentId = (Integer) session.getAttribute("idDept");
				  List<Police> allHsscPostListForDept = baseDataService.getAllHsscPostListForDept(dEpartmentId);
				     if (CommonUtils.isNotEmpty(allHsscPostListForDept)) {
				    	 for (Police pol : allHsscPostListForDept) {
								if (CommonUtils.isNotEmpty(pol.getmAcroStatus())) {
									if (pol.getmAcroStatus().equalsIgnoreCase("Recommended")) {
										recommendedCount=recommendedCount+1;
										recommendedTotalNoOfPosts = recommendedTotalNoOfPosts + pol.getnOOfPosts();
									}
									else if (pol.getmAcroStatus().equalsIgnoreCase("In Process")) {
										inProcessCount=inProcessCount+1;
										inProcessTotalNoOfPosts = inProcessTotalNoOfPosts + pol.getnOOfPosts();
									} 
									else if (pol.getmAcroStatus().equalsIgnoreCase("Court Stay")) {
											courtStayCount=courtStayCount+1;
											courtStayTotalNoOfPosts = courtStayTotalNoOfPosts + pol.getnOOfPosts();
									}
				               }
				          }
				     }
				   List<RequisitionInfo> allRequisitiondata = requisitionService.getAllRequisitioData(dEpartmentId);    
				     if(CommonUtils.isNotEmpty(allRequisitiondata)) {
				    		for (RequisitionInfo r : allRequisitiondata) {
				    			if (r.getStatus().equalsIgnoreCase("back referred")) {
				    				backReferredCount = backReferredCount + 1;
				    				backReferredTotalNoOfPosts = backReferredTotalNoOfPosts	+ r.getNumberOfPostToBeFilled();
								}
				    		}
				     }
				     
				     percentageOfRequisitionsInIdealTime=(float) (totalYellowCount*100)/totalRequisitioncount;
				     float roundOff = (float) (Math.round(percentageOfRequisitionsInIdealTime*100.0)/100.0);
				     
				     dashBoardObj.setDate(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
				     dashBoardObj.setTime(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));
				     dashBoardObj.setNoOfRecommendedPosts(recommendedTotalNoOfPosts);
				     dashBoardObj.setNoOfRecommendedRequisitions(recommendedCount);
				     dashBoardObj.setNoOfInprocessPosts(inProcessTotalNoOfPosts);
				     dashBoardObj.setNoOfInprocessRequisitions(inProcessCount);
				     dashBoardObj.setNoOfRequisitionsInCourtStay(courtStayCount);
				     dashBoardObj.setNoOfPostsImpactedBecauseOfCourtStay(courtStayTotalNoOfPosts);
				     dashBoardObj.setNoOfBackReferredRequisitions(backReferredCount);
				     dashBoardObj.setNoOfBackReferredPosts(backReferredTotalNoOfPosts);
				     dashBoardObj.setPerOfRequisitionsProcessInIdealTime(roundOff);
				     dashBoardData.add(0, dashBoardObj);
			 
		 }catch(Exception e) {
			 logger.logError("getRequestData", "error while getting data", e);
		 }       
		return dashBoardData;
		
	}
	
	@RequestMapping(value = "/hsscRequisitionJsonInfo", produces = MediaType.APPLICATION_JSON_VALUE, method= {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<Object> hsscRequisitionJsonInfo(Model model,HttpSession session) throws Exception{ 
	
		try {
			String finalJson = "{"+"\""+"result"+"\""+":"+"[";
			CMDashboardJSONRequestData dashBoardObj=getRequestData(session).get(0);
			LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("date", dashBoardObj.getDate());
		    map.put("time", dashBoardObj.getTime());
		    map.put("No. of  Recommended requisitions", dashBoardObj.getNoOfRecommendedRequisitions().toString());
		    map.put("No. of  Recommended Posts", dashBoardObj.getNoOfRecommendedPosts().toString());
		    map.put("No. of Inprocess requisitions", dashBoardObj.getNoOfInprocessRequisitions().toString());
		    map.put("No. of Inprocess posts", dashBoardObj.getNoOfInprocessPosts().toString());
		    map.put("% of requisitions process in Ideal time", String.valueOf(dashBoardObj.getPerOfRequisitionsProcessInIdealTime()));
		    map.put("No. of requisitions in court stays", dashBoardObj.getNoOfRequisitionsInCourtStay().toString());
		    map.put("No. of posts impacted because of court Stay", dashBoardObj.getNoOfPostsImpactedBecauseOfCourtStay().toString());
		    map.put("No. of Back-referred requisitions", dashBoardObj.getNoOfBackReferredRequisitions().toString());
		    map.put("No. of Back-referred posts", dashBoardObj.getNoOfBackReferredPosts().toString());
		                                      
		    String jsonString = new Gson().toJson(map);
		    
			finalJson =finalJson + jsonString;
			finalJson=finalJson+"]"+"}";
	
		 return new ResponseEntity<Object>(finalJson, HttpStatus.OK);  
	  }catch(Exception e) {
		  logger.logError("hsscRequisitionJsonInfo", "error while getting data", e);
		  throw e;
	  }   
          
    } 
	
	@RequestMapping(value = "signUp", method = RequestMethod.GET)
	public String signUpPage(Locale locale, Model model) throws Exception {
		

		return "signUp";
	}
	
	@RequestMapping(value = "signUp", method = RequestMethod.POST)
	public String signIn(Locale locale, Model model, @ModelAttribute("userObj") UserLogin userObj) throws Exception {
		try {
//			String passwordGenerator=null;
			  if(CommonUtils.isNotEmpty(userObj)) {
				  
				  UserLogin verifiedUser=baseDataDao.getVerifiedUser(userObj.getEmail());
				  UserLogin deptuser=baseDataService.getVerifiedUserByDeptId(userObj.getIdDept());
				  if(CommonUtils.isNotEmpty(verifiedUser)) {
						  model.addAttribute("failed","Email Already Exist");
						  return "signUp";
				  }
				  else if(CommonUtils.isNotEmpty(deptuser)) {
					  model.addAttribute("failed","User With selected Departement Already Exist");
					  return "signUp";
				  }
				  else {
//				  passwordGenerator=CommonUtils.randomPasswordGenerator();
				  userObj.setIsAdmin("N");
				  userObj.setEnabled(true);
				  userObj.setModule("mis");
				  userObj.setPasswordCreatedOn(new Date());
//				  userObj.setUserPassword(passwordGenerator);
				  Calendar cal = Calendar.getInstance();
				  cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+3));
				  
				  userObj.setPasswordExpireOn(cal.getTime());
				  
				 UserLogin savedUser= baseDataService.saveUserInfo(userObj);
				 
					if(CommonUtils.isNotEmpty(savedUser)) {
						model.addAttribute("Success","You have registered Successfully");	
					}
					
					else {
						model.addAttribute("failed","error in registration");	
						return "signUp";
					}
				 
				/*if(CommonUtils.isNotEmpty(savedUser)) {
				
				EmailTemplate obj = baseDataService.getemailTemplateCode("LoginDetails");
				String emailTxt=null;
				
				
				if(obj.getEmailType().contains("LoginDetails")){
					emailTxt=obj.getEmailHeadOne()+obj.getEmailCss()+obj.getEmailHeadTwo()+obj.getEmailBodyOne()+savedUser.getCandidateName()
					+obj.getEmailBodyTwo()+passwordGenerator+obj.getEmailBodyThree()+obj.getEmailFooter();
					}
				
				EmailLogs emailObj = new EmailLogs();
				emailObj.setEmailrecipient(savedUser.getEmail());
				emailObj.setEmailSubject("Login Details");
				emailObj.setEmailBody(emailTxt);
				
				EmailLogs sentEmail = emailService.sendEmail(emailObj);  
				
				if(CommonUtils.isNotEmpty(sentEmail)) {
				     model.addAttribute("Success","Check your email for LoginId and Password");	
				}
				else {
					model.addAttribute("failed","error in sending credentials to your email");	
					return "signUp";
				}
			  }
				else {
					model.addAttribute("failed","error in registration");	
					return "signUp";
				}*/
		    }
		  }   
			return "login";
		}catch(Exception e) {
			 logger.logError("signIn", "error while saving UserData", e);
			  throw e;
		}
	}
  

	@RequestMapping(value = "emailTemplate", method = RequestMethod.GET)
	public String emailTemplate(Locale locale, Model model) {
  
		return "emailTemplate";
	}
	
	@RequestMapping(value="recommendedCandidatesReport", method= {RequestMethod.POST,RequestMethod.GET})
	public String candidatesJoiningConsent(Model model) throws Exception {
		try {
			
		}catch(Exception e) {
			 logger.logError("recommendedCandidatesReport", "error While getting recommended Advertisements", e);
			  throw e;
		}
		return "candidatesJoiningStatus";
	}
		
	/*@RequestMapping(value = "/cmLogin/{userName}/{password}", method = {RequestMethod.GET})
	public  String externalLogin(@PathVariable String userName, @PathVariable String password, ModelMap model, 
			HttpServletRequest request,HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		try {
			UserLogin user=new UserLogin();
			if(CommonUtils.isNotEmpty(userName)) {
				user.setEmail(userName);
			}
            if(CommonUtils.isNotEmpty(password)) {
				user.setUserPassword(password);
			}
			String referrer = request.getHeader("referer");
			 if(referrer.equalsIgnoreCase("http://localhost:8080/MinesAndGeology/contractorEravaanaTransaction")) {
				  redirectAttributes.addFlashAttribute("UserData", user);
		          return "redirect:/login";
			 }else {
				 return "login";
			 }
		}catch(Exception e) {
			logger.logError("externalLogin", "error While login", e);
			  throw e;
		}
	}*/
	
	@RequestMapping(value = "/httpReferrer", method = {RequestMethod.GET})
	public  String externalLogin(ModelMap model, 
			HttpServletRequest request,HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		try {
			 UserLogin user=new UserLogin();
			 String referrer = request.getHeader("referer");
			 if(referrer.equalsIgnoreCase("http://cmdashboardhry.nic.in/IndexHSSC.aspx")) {
				  user.setEmail("cmLogin");
				  user.setUserPassword("Hkcl@123");
				  redirectAttributes.addFlashAttribute("UserData", user);
		          return "redirect:/login";
			 }else {
				 return "login";
			 }
		}catch(Exception e) {
			logger.logError("externalLogin", "error While login", e);
			  throw e;
		}
	}
	@RequestMapping(value="testSmsUtility", method= {RequestMethod.GET})
		String testsmsUtility(Model model) {
			try {
				SmsReceivers receiverObj=new SmsReceivers();	
			    receiverObj.setReceiverRole("REQ");
			      List<SmsReceivers> receiversList=new ArrayList<SmsReceivers>();
			      receiverObj.setReceiverMobile("8076568971");
			      receiversList.add(receiverObj);
			      String senderId=URLEncoder.encode("RQHSSC", "UTF-8");
			      smsSender.sendSms(receiversList, "Test",senderId);
				
			}catch(Exception e) {
				logger.logError("testSmsUtility", "error While Testing", e);
			}
			return null;
			
		
	    }
	
}
