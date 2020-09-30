package in.hkcl.db;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.displaytag.properties.SortOrderEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import in.hkcl.model.AdvtStatusForSPE;
import in.hkcl.model.BifurcationHelper;
import in.hkcl.model.Department;
import in.hkcl.model.HsscConfig;
import in.hkcl.model.Notifications;
import in.hkcl.model.Police;
import in.hkcl.model.PostGroup;
import in.hkcl.model.PostMaster;
import in.hkcl.model.RequisitionDocs;
import in.hkcl.model.RequisitionInfo;
import in.hkcl.model.RequisitionInfoRemarks;
import in.hkcl.model.RequisitionReport;
import in.hkcl.model.RequisitionReservationInfo;
import in.hkcl.model.SmsReceivers;
import in.hkcl.model.UserLogin;
import in.hkcl.model.ValidateBifurcation;
import in.hkcl.model.ValidateBifurcationCounts;
import in.hkcl.pagination.ExtendedPaginatedList;
import in.hkcl.pagination.PaginatedListImpl;
import in.hkcl.service.BaseDataService;
import in.hkcl.service.RequisitionService;
import in.hkcl.smsIntegration.SmsSender;
import in.hkcl.utils.ApplicationLogFactory;
import in.hkcl.utils.ApplicationLogger;
import in.hkcl.utils.CommonUtils;
import in.hkcl.utils.DateFormatterUtility;

@Controller
public class RequisitionController {

	@Autowired
	RequisitionService requisitionService;
	
	@Autowired
	BaseDataService baseDataService;
	
	@Autowired
	SmsSender smsSender;

	private static ApplicationLogger logger = ApplicationLogFactory.getLogger(RequisitionController.class);

	private static final String REQUISITION_REGISTRATION_FORM = "requisitionRegistration";
	private static final String SAVE_REQUISITION_FORM = "saveRequisitionForm";
	private static final String ALL_REGISTERED_REQUISITIONS = "allRegisteredRequisitions";
	private static final String VIEW_REGISTERED_REQUISITION_FORM = "viewRequisitionForm";
	private static final String EDIT_REGISTERED_REQUISITION_FORM = "editRegisteredRequisitionForm";
	private static final String ALL_REQUISITION_REQUESTS_FOR_ADMIN = "allRequistionRequests";
	private static final String REQUISITION_DASHBOARD = "requisitionDashboard";
	private static final String VIEW_REQUISITION_REMARK_FORM = "viewRequisitionRemarkForm";
	private static final String APPROVE_REJECT_REQUISITION = "statusForRequisition";
	private static final String BACK_REFERRED_REQUISITION_INFO = "backReferred";
	private static final String OPEN_NOTIFICATION = "openNotification";
	private static final String READ_ONLY_REQUISITION="readOnlyReq";
	private static final String SAVE_READ_ONLY_REQUISITION="saveReadOnlyReq";
	private static final String DEPTWISE_REQUISITIONS_AND_BIFURCATION="departmewiseReqReport";
	private static final String ALL_REPORTS="allReports";
	private static final String EXPORT_EXCEL_DEPTWISE_REQUISITION="exportExcelDeptwiseRequisition";
	private static final String FETCH_ALL_POST="fetchAllPosts";
	private static final String ADVT_STATUS_FORM_FOR_SPE="advtStatusFormForSpe";
	private static final String SAVE_ADVT_STATUS_FORM_FOR_SPE="saveAdvtStatusFormForSpe";
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@ModelAttribute
	public void getDepartmentData(Model model, HttpServletRequest request, HttpSession session) {
		Integer dEpartmentId = (Integer) session.getAttribute("idDept");
		try {
			 Department deptInfo=requisitionService.getdepartmentData(dEpartmentId);
			 model.addAttribute("deptInfo",deptInfo);
			 
			 List<Department> departmentList = baseDataService.loadAllDepartments();
			 model.addAttribute("deptList", departmentList);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = REQUISITION_REGISTRATION_FORM, method = { RequestMethod.GET, RequestMethod.POST })
	private String requisitionRegistrationForm(Model model) {
		try {
		String[] headersArr = { "Category", "Total", "NonESMESP", "ESM", "ESP"};
		String[] headerArrGB= {"Category", "Total", "NonESMESP", "ESP"};
			//List<PostMaster> desigList = requisitionService.getAllDesignations();
			//model.addAttribute("desigList", desigList);
			model.addAttribute("reqObj", new RequisitionInfo());
		model.addAttribute("headersArr", headersArr);
		model.addAttribute("headerArrGB", headerArrGB);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return REQUISITION_REGISTRATION_FORM;
	}

	@RequestMapping(value = "/downloadForm", method = { RequestMethod.GET, RequestMethod.POST })
	public void downLoadDocument(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("idRequisition") String idRequisition, @RequestParam("docType") String docType)
			throws Exception {
		FileInputStream inputStream = null;
		ServletOutputStream outStream = null;
		try {
			HsscConfig hssscObj = requisitionService.getHSSCConfig();

			File requisitionFile = new File(
					hssscObj.getHsscBaseFolderPath() + File.separator + "Requisitions" + File.separator + "REQ-"
							+ idRequisition + File.separator + docType + "REQ-" + idRequisition + ".pdf");
			if (requisitionFile.exists()) {
				inputStream = new FileInputStream(requisitionFile);
				response.setContentType("application/force-download");
				response.setHeader("Content-Disposition",
						"attachment; filename=" + docType + "REQ-" + idRequisition + ".pdf");
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

	@RequestMapping(value = "/printPreview{Id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String printPreview(@PathVariable("Id") String idRequisition, Model model) {
		try {
			List<RequisitionInfo> requisitionForm = requisitionService
					.getRequisitionFormByRequisitionId(Integer.parseInt(idRequisition));
			/*List<BifurcationHelper> helperList = requisitionService
					.getBifuractionHelperList(Integer.parseInt(idRequisition));*/
			
			List<BifurcationHelper> helperList = new LinkedList<BifurcationHelper>();
			BifurcationHelper generalBifurcation=new BifurcationHelper();
			generalBifurcation.setCategory("GENERAL");
			BifurcationHelper scBifurcation=new BifurcationHelper();
			scBifurcation.setCategory("SC");
			BifurcationHelper bcaBifurcation=new BifurcationHelper();
			bcaBifurcation.setCategory("BCA");
			BifurcationHelper bcbBifurcation=new BifurcationHelper();
			bcbBifurcation.setCategory("BCB");
			/*BifurcationHelper sbcBifurcation=new BifurcationHelper();
			sbcBifurcation.setCategory("SBC");*/
			BifurcationHelper ebpgcBifurcation=new BifurcationHelper();
			ebpgcBifurcation.setCategory("EWS");
			
			for(RequisitionReservationInfo info : requisitionForm.get(0).getRequisitionReservationInfoList()) {
				if(info.getCategory().contains("GENERAL")) {
					if(info.getSubCategory().contains("Total")){
						generalBifurcation.setTotalCount(info.getTotalSeatsForCategory());
						generalBifurcation.setTotalCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("NonESMESP")){
						generalBifurcation.setNonEsmEspCount(info.getTotalSeatsForCategory());
						generalBifurcation.setNonEsmEspCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESM")){
						generalBifurcation.setEsmCount(info.getTotalSeatsForCategory());
						generalBifurcation.setEsmCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESP")){
						generalBifurcation.setEspCount(info.getTotalSeatsForCategory());
						generalBifurcation.setEspCountBackLog(info.getBacklog());
					}
				}else if(info.getCategory().contains("SC")) {
					if(info.getSubCategory().contains("Total")){
						scBifurcation.setTotalCount(info.getTotalSeatsForCategory());
						scBifurcation.setTotalCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("NonESMESP")){
						scBifurcation.setNonEsmEspCount(info.getTotalSeatsForCategory());
						scBifurcation.setNonEsmEspCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESM")){
						scBifurcation.setEsmCount(info.getTotalSeatsForCategory());
						scBifurcation.setEsmCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESP")){
						scBifurcation.setEspCount(info.getTotalSeatsForCategory());
						scBifurcation.setEspCountBackLog(info.getBacklog());
					}
				}else if(info.getCategory().contains("BCA")) {
					if(info.getSubCategory().contains("Total")){
						bcaBifurcation.setTotalCount(info.getTotalSeatsForCategory());
						bcaBifurcation.setTotalCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("NonESMESP")){
						bcaBifurcation.setNonEsmEspCount(info.getTotalSeatsForCategory());
						bcaBifurcation.setNonEsmEspCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESM")){
						bcaBifurcation.setEsmCount(info.getTotalSeatsForCategory());
						bcaBifurcation.setEsmCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESP")){
						bcaBifurcation.setEspCount(info.getTotalSeatsForCategory());
						bcaBifurcation.setEspCountBackLog(info.getBacklog());
					}
				}else if(info.getCategory().contains("BCB")) {
					if(info.getSubCategory().contains("Total")){
						bcbBifurcation.setTotalCount(info.getTotalSeatsForCategory());
						bcbBifurcation.setTotalCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("NonESMESP")){
						bcbBifurcation.setNonEsmEspCount(info.getTotalSeatsForCategory());
						bcbBifurcation.setNonEsmEspCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESM")){
						bcbBifurcation.setEsmCount(info.getTotalSeatsForCategory());
						bcbBifurcation.setEsmCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESP")){
						bcbBifurcation.setEspCount(info.getTotalSeatsForCategory());
						bcbBifurcation.setEspCountBackLog(info.getBacklog());
					}
				}/*else if(info.getCategory().contains("SBC")) {
					if(info.getSubCategory().contains("Total")){
						sbcBifurcation.setTotalCount(info.getTotalSeatsForCategory());
						sbcBifurcation.setTotalCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("NonESMESP")){
						sbcBifurcation.setNonEsmEspCount(info.getTotalSeatsForCategory());
						sbcBifurcation.setNonEsmEspCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESM")){
						sbcBifurcation.setEsmCount(info.getTotalSeatsForCategory());
						sbcBifurcation.setEsmCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESP")){
						sbcBifurcation.setEspCount(info.getTotalSeatsForCategory());
						sbcBifurcation.setEspCountBackLog(info.getBacklog());
					}
				}*/else if(info.getCategory().contains("EWS")) {
					if(info.getSubCategory().contains("Total")){
						ebpgcBifurcation.setTotalCount(info.getTotalSeatsForCategory());
						ebpgcBifurcation.setTotalCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("NonESMESP")){
						ebpgcBifurcation.setNonEsmEspCount(info.getTotalSeatsForCategory());
						ebpgcBifurcation.setNonEsmEspCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESM")){
						ebpgcBifurcation.setEsmCount(info.getTotalSeatsForCategory());
						ebpgcBifurcation.setEsmCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESP")){
						ebpgcBifurcation.setEspCount(info.getTotalSeatsForCategory());
						ebpgcBifurcation.setEspCountBackLog(info.getBacklog());
					}
				}
				
			}
			
			helperList.add(generalBifurcation);
			helperList.add(scBifurcation);
			helperList.add(bcaBifurcation);
			helperList.add(bcbBifurcation);
//			helperList.add(sbcBifurcation);
			helperList.add(ebpgcBifurcation);
			
			String[] headersArr = { "Category", "Total", "NonESMESP", "ESM","ESP"};
			model.addAttribute("headersArr", headersArr);
			model.addAttribute("bifurcationList", helperList);
			model.addAttribute("requisitionForm", requisitionForm);

		} catch (Exception e) {
			logger.logError("printPreview", "exception while opening print preview", e);
		}

		return "printableRequisitionForm";
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/secondUpload", method = { RequestMethod.GET, RequestMethod.POST })
	public String secondUpload(@ModelAttribute("idRequisition") String idRequisition,
			@ModelAttribute("formfile") MultipartFile formfile, Model model) throws NumberFormatException, Exception {
		String strExactFileName = "";
		String strErrorMessage = "";
		String smsMsg="";
		List<RequisitionInfo> list = requisitionService
				.getRequisitionFormByRequisitionId(Integer.parseInt(idRequisition));
		RequisitionInfo reqObj = list.get(0);
		if (!formfile.getOriginalFilename().equalsIgnoreCase("")) {
			File uploadFile = writeFile(formfile, reqObj.getUniqueRequisitionNumber(), reqObj.getIdRequisition(),
					"Form");
			strExactFileName = formfile.getOriginalFilename();
			if (uploadFile != null) {
				strErrorMessage = "An error occur while uploading file.";
			} else {
				strErrorMessage = "Requisition has been submitted successfully!!";	
			}
		}
		  
		if (reqObj.getStatus().equalsIgnoreCase("back referred")) {
			reqObj.setStatus("re-submitted");
		   
			smsMsg=URLEncoder.encode("Please note that HSSC has received re-submitted online requisition "+reqObj.getUniqueRequisitionNumber()+" for "
					+ "Group "+reqObj.getPostObj().getPostGroupObj().getPostgroupName()+" "
					+ "Post "+reqObj.getPostObj().getPostName()+" with no. of Posts "+reqObj.getNumberOfPostToBeFilled()+" submitted by ["+reqObj.getDeptObj().getdEpartment()+"] through "
					+ "["+reqObj.getNameOfNodalOfficer()+"]","UTF-8");
		} else if (reqObj.getStatus().equalsIgnoreCase("saved")) {
			reqObj.setStatus("submitted");
			
			smsMsg=URLEncoder.encode("Please note that HSSC has received online requisition "+reqObj.getUniqueRequisitionNumber()+" for "
					+ "Group "+reqObj.getPostObj().getPostGroupObj().getPostgroupName()+" "
					+ "Post "+reqObj.getPostObj().getPostName()+" with no. of Posts "+reqObj.getNumberOfPostToBeFilled()+" submitted by ["+reqObj.getDeptObj().getdEpartment()+"] through "
					+ "["+reqObj.getNameOfNodalOfficer()+"]","UTF-8");
		}
		requisitionService.updateRequisitionStatus(reqObj);
		  SmsReceivers receiverObj=new SmsReceivers();	
		    receiverObj.setReceiverRole("REQ");
		      List<SmsReceivers> receiversList=requisitionService.getReceiversList(receiverObj);
		      receiverObj.setReceiverMobile(reqObj.getPhoneNumberOfNodelOfficer().toString());
		      if(CommonUtils.isNotEmpty(receiversList)) {
		    	  receiversList.add(receiverObj);
		      }
		      String senderId=URLEncoder.encode("RQHSSC", "UTF-8");
		      smsSender.sendSms(receiversList, smsMsg,senderId);
		model.addAttribute("Submited Successfully", reqObj);
		return viewRequisitionForm(model, reqObj.getIdRequisition().toString(),strErrorMessage);
	}

	@RequestMapping(value = EDIT_REGISTERED_REQUISITION_FORM, method = { RequestMethod.GET, RequestMethod.POST })
	private String editRegisteredRequisitionForm(Model model, @ModelAttribute("idRequisition") String idRequisition)
			throws Exception {
		try {
			List<PostMaster>  desigList=new ArrayList<PostMaster>();
			String[] headersArr = { "Category", "Total", "NonESMESP", "ESM","ESP"};
			List<RequisitionInfo> requisitionForm = requisitionService
					.getRequisitionFormByRequisitionId(Integer.parseInt(idRequisition));
			PostGroup postGroupObj=requisitionService.getPostGroup(requisitionForm.get(0).getClassAndServiceOfPost());
			if(CommonUtils.isNotEmpty(postGroupObj)) {
		    desigList = requisitionService.getAllDesignations(postGroupObj.getPostgroupId());				
			}
			
			for (RequisitionDocs requisitionObj : requisitionForm.get(0).getRequisitionDocsList()) {
				if (requisitionObj.getDocType().equalsIgnoreCase("service")) {
					model.addAttribute("serviceDoc", requisitionObj.getFileName());
				} else {
					model.addAttribute("formTypeDocFileName", requisitionObj.getFileName());
				}
			}
			Integer totalPWDSeats=Math.round((requisitionForm.get(0).getNumberOfPostToBeFilled()*4)/100);
			
			model.addAttribute("headersArr", headersArr);
			model.addAttribute("requisitionForm", requisitionForm);
			model.addAttribute("headersArr", headersArr);
			model.addAttribute("totalPWDSeats", totalPWDSeats);

			List<BifurcationHelper> helperList = new LinkedList<BifurcationHelper>();
			BifurcationHelper generalBifurcation=new BifurcationHelper();
			generalBifurcation.setCategory("GENERAL");
			BifurcationHelper scBifurcation=new BifurcationHelper();
			scBifurcation.setCategory("SC");
			BifurcationHelper bcaBifurcation=new BifurcationHelper();
			bcaBifurcation.setCategory("BCA");
			BifurcationHelper bcbBifurcation=new BifurcationHelper();
			bcbBifurcation.setCategory("BCB");
			/*BifurcationHelper sbcBifurcation=new BifurcationHelper();
			sbcBifurcation.setCategory("SBC");*/
			BifurcationHelper ebpgcBifurcation=new BifurcationHelper();
			ebpgcBifurcation.setCategory("EWS");

			int totalFilled = 0;
			
			/* if(CommonUtils.isNotEmpty(requisitionForm.get(0))) {
				 totalFilled=totalFilled+requisitionForm.get(0).getEspSeats();
			 }*/
			
			for(RequisitionReservationInfo info : requisitionForm.get(0).getRequisitionReservationInfoList()) {
				if(info.getSubCategory().contains("Total")) {
					totalFilled = totalFilled + info.getTotalSeatsForCategory();	
				}
				
				
				
				if(info.getCategory().contains("GENERAL")) {
					if(info.getSubCategory().contains("Total")){
						generalBifurcation.setTotalCount(info.getTotalSeatsForCategory());
						generalBifurcation.setTotalCountBackLog(info.getBacklog());
						
					}else if(info.getSubCategory().contains("NonESMESP")){
						generalBifurcation.setNonEsmEspCount(info.getTotalSeatsForCategory());
						generalBifurcation.setNonEsmEspCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESM")){
						generalBifurcation.setEsmCount(info.getTotalSeatsForCategory());
						generalBifurcation.setEsmCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESP")){
						generalBifurcation.setEspCount(info.getTotalSeatsForCategory());
						generalBifurcation.setEspCountBackLog(info.getBacklog());
					}
				}else if(info.getCategory().contains("SC")) {
					if(info.getSubCategory().contains("Total")){
						scBifurcation.setTotalCount(info.getTotalSeatsForCategory());
						scBifurcation.setTotalCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("NonESMESP")){
						scBifurcation.setNonEsmEspCount(info.getTotalSeatsForCategory());
						scBifurcation.setNonEsmEspCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESM")){
						scBifurcation.setEsmCount(info.getTotalSeatsForCategory());
						scBifurcation.setEsmCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESP")){
						scBifurcation.setEspCount(info.getTotalSeatsForCategory());
						scBifurcation.setEspCountBackLog(info.getBacklog());
					}
				}else if(info.getCategory().contains("BCA")) {
					if(info.getSubCategory().contains("Total")){
						bcaBifurcation.setTotalCount(info.getTotalSeatsForCategory());
						bcaBifurcation.setTotalCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("NonESMESP")){
						bcaBifurcation.setNonEsmEspCount(info.getTotalSeatsForCategory());
						bcaBifurcation.setNonEsmEspCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESM")){
						bcaBifurcation.setEsmCount(info.getTotalSeatsForCategory());
						bcaBifurcation.setEsmCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESP")){
						bcaBifurcation.setEspCount(info.getTotalSeatsForCategory());
						bcaBifurcation.setEspCountBackLog(info.getBacklog());
					}
				}else if(info.getCategory().contains("BCB")) {
					if(info.getSubCategory().contains("Total")){
						bcbBifurcation.setTotalCount(info.getTotalSeatsForCategory());
						bcbBifurcation.setTotalCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("NonESMESP")){
						bcbBifurcation.setNonEsmEspCount(info.getTotalSeatsForCategory());
						bcbBifurcation.setNonEsmEspCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESM")){
						bcbBifurcation.setEsmCount(info.getTotalSeatsForCategory());
						bcbBifurcation.setEsmCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESP")){
						bcbBifurcation.setEspCount(info.getTotalSeatsForCategory());
						bcbBifurcation.setEspCountBackLog(info.getBacklog());
					}
				}/*else if(info.getCategory().contains("SBC")) {
					if(info.getSubCategory().contains("Total")){
						sbcBifurcation.setTotalCount(info.getTotalSeatsForCategory());
						sbcBifurcation.setTotalCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("NonESMESP")){
						sbcBifurcation.setNonEsmEspCount(info.getTotalSeatsForCategory());
						sbcBifurcation.setNonEsmEspCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESM")){
						sbcBifurcation.setEsmCount(info.getTotalSeatsForCategory());
						sbcBifurcation.setEsmCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESP")){
						sbcBifurcation.setEspCount(info.getTotalSeatsForCategory());
						sbcBifurcation.setEspCountBackLog(info.getBacklog());
					}
				}*/else if(info.getCategory().contains("EWS")) {
					if(info.getSubCategory().contains("Total")){
						ebpgcBifurcation.setTotalCount(info.getTotalSeatsForCategory());
						ebpgcBifurcation.setTotalCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("NonESMESP")){
						ebpgcBifurcation.setNonEsmEspCount(info.getTotalSeatsForCategory());
						ebpgcBifurcation.setNonEsmEspCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESM")){
						ebpgcBifurcation.setEsmCount(info.getTotalSeatsForCategory());
						ebpgcBifurcation.setEsmCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESP")){
						ebpgcBifurcation.setEspCount(info.getTotalSeatsForCategory());
						ebpgcBifurcation.setEspCountBackLog(info.getBacklog());
					}
				}
				
			}
			
			requisitionForm.get(0).setTotalFilled(totalFilled);
			
			helperList.add(generalBifurcation);
			helperList.add(scBifurcation);
			helperList.add(bcaBifurcation);
			helperList.add(bcbBifurcation);
			/*helperList.add(sbcBifurcation);*/
			helperList.add(ebpgcBifurcation);
			
			model.addAttribute("helperList", helperList);
			
			//List<PostMaster> desigList = requisitionService.getAllDesignations();
			model.addAttribute("desigList", desigList);

			return REQUISITION_REGISTRATION_FORM;
		} catch (Exception e) {
			logger.logError("allRegisteredRequisitions", "exception while getting requisitions data", e);
			throw e;
		}
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = SAVE_REQUISITION_FORM, method = { RequestMethod.POST })
	private String saveRequisitionForm(Model model,@ModelAttribute("reqObj") RequisitionInfo reqObj, @RequestParam("file") MultipartFile file,
			HttpSession session, @ModelAttribute("totalFilled") String totalFilled, @ModelAttribute("createdatetime") String createdatetime ,
			@ModelAttribute("desigId") String desigId) throws Exception {
		    String errorMsg=null;
		    String[] headersArr = { "Category", "Total", "NonESMESP", "ESM","ESP"};
		try {
			if (CommonUtils.isNotEmpty(reqObj.getIdRequisition())) {
				
				Integer dEpartmentId = (Integer) session.getAttribute("idDept");
				List<RequisitionInfo> requisitionExist=requisitionService.getAllDuplicateRecords(dEpartmentId,reqObj.getPostmasterId(),Integer.parseInt(desigId));
				if(CommonUtils.isNotEmpty(requisitionExist)) {
					List<RequisitionInfo> requisitionForm=new ArrayList<RequisitionInfo>();
					
					List<RequisitionInfo> requisitionFormNew = requisitionService
							.getRequisitionFormByRequisitionId(reqObj.getIdRequisition());
					reqObj.setPostmasterId(requisitionFormNew.get(0).getPostmasterId());
					
					reqObj.setCreatedatetime(requisitionFormNew.get(0).getCreatedatetime());
					
					requisitionForm.add(reqObj);
					List<PostMaster> desigList = new ArrayList<PostMaster>();
					PostGroup postGroupObj=requisitionService.getPostGroup(requisitionForm.get(0).getClassAndServiceOfPost());
					if(CommonUtils.isNotEmpty(postGroupObj)) {
					 desigList = requisitionService.getAllDesignations(postGroupObj.getPostgroupId());				
					}
					model.addAttribute("desigList", desigList);
					model.addAttribute("requisitionForm",requisitionForm);
					model.addAttribute("failed","Requisition for this post already exist and not Advertised. "
							+ "Department can only submit one requisition for a particular post untill the previously submitted requisition has been Advertised by HSSC.");
					model.addAttribute("totalFilled",totalFilled);
					model.addAttribute("headersArr", headersArr);
					model.addAttribute("helperList", reqObj.getBifurcationList());
					return REQUISITION_REGISTRATION_FORM;
				}
				if (reqObj.getStatus().equalsIgnoreCase("back referred")) {
					if(CommonUtils.isNotEmpty(totalFilled)) {
						if(reqObj.getNumberOfPostToBeFilled()!=Integer.parseInt(totalFilled)) {
							List<RequisitionInfo> requisitionForm=new ArrayList<RequisitionInfo>();
							requisitionForm.add(reqObj);
							List<PostMaster> desigList = new ArrayList<PostMaster>();
							PostGroup postGroupObj=requisitionService.getPostGroup(requisitionForm.get(0).getClassAndServiceOfPost());
							if(CommonUtils.isNotEmpty(postGroupObj)) {
							 desigList = requisitionService.getAllDesignations(postGroupObj.getPostgroupId());				
							}
							model.addAttribute("desigList", desigList);
							model.addAttribute("requisitionForm",requisitionForm);
							model.addAttribute("failed","Total Bifurcation Should be equal to No. of Posts Filled");
							model.addAttribute("totalFilled",totalFilled);
							model.addAttribute("headersArr", headersArr);
							model.addAttribute("helperList", reqObj.getBifurcationList());
							return REQUISITION_REGISTRATION_FORM;
						}
					}
					
					reqObj.setdEpartmentId(dEpartmentId.intValue());
					reqObj.setUpdatedatetime(new Date());
					reqObj = requisitionService.updateRequisition(reqObj);
					if (!file.getOriginalFilename().equalsIgnoreCase("")) {
						String strExactFileName = "";
						String strErrorMessage = "";
						File uploadFile = writeFile(file, reqObj.getUniqueRequisitionNumber(),
								reqObj.getIdRequisition(), "service");
						strExactFileName = file.getOriginalFilename();
						if (uploadFile != null) {
							strErrorMessage = "File Uploaded Successfully!!";
						} else {
							strErrorMessage = "An error occur while uploading file.";
						}
					}
					
					model.addAttribute("Submited Successfully", reqObj);
					errorMsg="Your requisition has been updated successfully, please re-submit your requisition for approval";

				} else {
					
					if(CommonUtils.isNotEmpty(totalFilled)) {
						if(reqObj.getNumberOfPostToBeFilled()!=Integer.parseInt(totalFilled)) {
							List<RequisitionInfo> requisitionForm=new ArrayList<RequisitionInfo>();
							requisitionForm.add(reqObj);
							List<PostMaster> desigList = new ArrayList<PostMaster>();
							PostGroup postGroupObj=requisitionService.getPostGroup(requisitionForm.get(0).getClassAndServiceOfPost());
							if(CommonUtils.isNotEmpty(postGroupObj)) {
							 desigList = requisitionService.getAllDesignations(postGroupObj.getPostgroupId());				
							}
							model.addAttribute("desigList", desigList);
							model.addAttribute("requisitionForm",requisitionForm);
							model.addAttribute("failed","Total Bifurcation Should be equal to No. of Posts Filled");
							model.addAttribute("totalFilled",totalFilled);
							model.addAttribute("headersArr", headersArr);
							model.addAttribute("helperList", reqObj.getBifurcationList());
							return REQUISITION_REGISTRATION_FORM;
						}
					}
					
					
					
					
					reqObj.setStatus("saved");
					reqObj.setdEpartmentId(dEpartmentId.intValue());
					reqObj.setUpdatedatetime(new Date());
					reqObj = requisitionService.updateRequisition(reqObj);
					if (!file.getOriginalFilename().equalsIgnoreCase("")) {
						String strExactFileName = "";
						String strErrorMessage = "";
						File uploadFile = writeFile(file, reqObj.getUniqueRequisitionNumber(),
								reqObj.getIdRequisition(), "service");
						strExactFileName = file.getOriginalFilename();
						if (uploadFile != null) {
							strErrorMessage = "An error occur while uploading file.";
						} else {
							strErrorMessage = "File Uploaded Successfully!!";
							
						}
					}
					model.addAttribute("headersArr", headersArr);
					model.addAttribute("Submited Successfully", reqObj);
					errorMsg="Your requisition has been updated successfully, complete further steps before final submission for HSSC approval";
				}
			} else {
				Integer dEpartmentId = (Integer) session.getAttribute("idDept");
				List<RequisitionInfo> requisitionExist=requisitionService.getAllDuplicateRecords(dEpartmentId,reqObj.getPostmasterId(),null);
				if(CommonUtils.isNotEmpty(requisitionExist)) {
					List<RequisitionInfo> requisitionForm=new ArrayList<RequisitionInfo>();
					requisitionForm.add(reqObj);
					List<PostMaster> desigList = new ArrayList<PostMaster>();
					PostGroup postGroupObj=requisitionService.getPostGroup(requisitionForm.get(0).getClassAndServiceOfPost());
					if(CommonUtils.isNotEmpty(postGroupObj)) {
					 desigList = requisitionService.getAllDesignations(postGroupObj.getPostgroupId());				
					}
					model.addAttribute("desigList", desigList);
					model.addAttribute("requisitionForm",requisitionForm);
					model.addAttribute("failed","Requisition for this post already exist and not Advertised. "
							+ "Department can only submit one requisition for a particular post untill the previously submitted requisition has been Advertised by HSSC.");
					model.addAttribute("totalFilled",totalFilled);
					model.addAttribute("headersArr", headersArr);
					model.addAttribute("helperList", reqObj.getBifurcationList());
					return REQUISITION_REGISTRATION_FORM;
				}
				
				if(CommonUtils.isNotEmpty(totalFilled)) {
					if(reqObj.getNumberOfPostToBeFilled()!=Integer.parseInt(totalFilled)) {
						List<RequisitionInfo> requisitionForm=new ArrayList<RequisitionInfo>();
						requisitionForm.add(reqObj);
						List<PostMaster> desigList = new ArrayList<PostMaster>();
						PostGroup postGroupObj=requisitionService.getPostGroup(requisitionForm.get(0).getClassAndServiceOfPost());
						if(CommonUtils.isNotEmpty(postGroupObj)) {
						 desigList = requisitionService.getAllDesignations(postGroupObj.getPostgroupId());				
						}
						model.addAttribute("desigList", desigList);
						model.addAttribute("requisitionForm",requisitionForm);
						model.addAttribute("failed","Total Bifurcation Should be equal to No. of Posts Filled");
						model.addAttribute("totalFilled",totalFilled);
						model.addAttribute("headersArr", headersArr);
						model.addAttribute("helperList", reqObj.getBifurcationList());
						return REQUISITION_REGISTRATION_FORM; 
					}
				}	
				
				String strExactFileName = "";
				String strErrorMessage = "";
				reqObj.setStatus("saved");
				reqObj.setdEpartmentId(dEpartmentId.intValue());
				reqObj.setCreatedatetime(new Date());
				reqObj = requisitionService.saveRequisitionForm(reqObj);
				if (!file.getOriginalFilename().equalsIgnoreCase("")) {
					File uploadFile = writeFile(file, reqObj.getUniqueRequisitionNumber(), reqObj.getIdRequisition(),
							"service");
					strExactFileName = file.getOriginalFilename();
					if (uploadFile != null) {
						strErrorMessage = "File Uploaded Successfully!!";
					} else {
						strErrorMessage = "An error occur while uploading file.";
					}
				}
				model.addAttribute("Submited Successfully", reqObj);
				model.addAttribute("headersArr", headersArr);
				errorMsg="Your requisition has been saved successfully, complete further steps before final submission for HSSC approval";
			}
		} catch (Exception e) {
			logger.logError("saveRequisitionForm", "exception while saving requisition form", e);
		}
		return viewRequisitionForm(model, reqObj.getIdRequisition().toString(),errorMsg);
	}

	private File writeFile(final MultipartFile file, final String reqNumber, Integer id, String type) throws Exception {
		File destFile = null;
		File diskFile;
		final File path;
		RequisitionDocs docsObj = new RequisitionDocs();
		HsscConfig config = requisitionService.getHSSCConfig();
		if (!file.getOriginalFilename().equalsIgnoreCase("")) {
			String strFilePath = null;
			try {
				byte[] bytes = file.getBytes();
				final String strFileName = file.getOriginalFilename();
				final int dotPos = strFileName.indexOf(".");
				if (dotPos != -1) {
					strFilePath = config.getHsscBaseFolderPath() + File.separator + "Requisitions" + File.separator
							+ reqNumber;
					path = new File(strFilePath);
					if (!path.exists()) {
						path.mkdirs();
					}
					if (type.contains("service")) {
						diskFile = new File(path + File.separator + "service" + reqNumber + "." + "pdf");
						docsObj.setDocType("service");
						docsObj.setDocUrl(strFilePath + File.separator + "service" + reqNumber + "." + "pdf");
						docsObj.setFileName("service" + reqNumber + "." + "pdf");
					} else {
						diskFile = new File(path + File.separator + "form" + reqNumber + "." + "pdf");
						docsObj.setDocType("form");
						docsObj.setDocUrl(strFilePath + File.separator + "form" + reqNumber + "." + "pdf");
						docsObj.setFileName("form" + reqNumber + "." + "pdf");
					}
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(diskFile));
					stream.write(bytes);
					stream.close();

				} else {
					destFile = null;
				}

				docsObj.setIdRequisition(id);
				requisitionService.savePathObjectByIdRequisition(docsObj);
			} catch (Exception e) {
				e.printStackTrace();
				destFile = null;
			}
		} else {
			return destFile;
		}
		return destFile;
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

	@RequestMapping(value = ALL_REGISTERED_REQUISITIONS, method = { RequestMethod.GET, RequestMethod.POST })
	private String allRegisteredRequisitions(Model model, @ModelAttribute("status") String status,@ModelAttribute("reqObj") RequisitionInfo reqObj, HttpSession session,
			HttpServletRequest request) throws Exception {
		try {
			Integer dEpartmentId = (Integer) session.getAttribute("idDept");
			if (CommonUtils.isNotEmpty(dEpartmentId)) {
				final ExtendedPaginatedList pageList = requisitionService.getAllRegisteredRequisitions(dEpartmentId,
						getPaginatedListFromRequest(request), status, reqObj);

				List<RequisitionInfo> allDistinctStatusList = requisitionService.getAllDistinctStatusList();
				List<RequisitionInfo> allDistinctGroupList=requisitionService.getAllDistinctGroupList();
				List<RequisitionInfo> allRequisitiondata = requisitionService.getAllRequisitioData(dEpartmentId);

				model.addAttribute("classAndServiceOfPost", reqObj.getClassAndServiceOfPost());
				model.addAttribute("allDistinctStatusList", allDistinctStatusList);
				model.addAttribute("allDistinctGroupList", allDistinctGroupList);
				model.addAttribute("requisitionsList", pageList);
				model.addAttribute("statusForDropdown", status);
				model.addAttribute("allRequisitiondata",allRequisitiondata);
				model.addAttribute("designation", reqObj.getPostmasterId());
				model.addAttribute("uniqueRequisitionNumber", reqObj.getUniqueRequisitionNumber());
			} else {
				final ExtendedPaginatedList pageList = requisitionService.getAllRegisteredRequisitions(dEpartmentId,
						getPaginatedListFromRequest(request), status,reqObj);

				List<RequisitionInfo> allDistinctStatusList = requisitionService.getAllDistinctStatusList();
				List<RequisitionInfo> allRequisitiondata = requisitionService.getAllRequisitioData(dEpartmentId);
				List<RequisitionInfo> allDistinctGroupList=requisitionService.getAllDistinctGroupList();
				List<RequisitionInfo> allDistinctStatusListforAdmin = new ArrayList<RequisitionInfo>();
				
				List<RequisitionInfo> allUniqueReqforAdmin = new ArrayList<RequisitionInfo>();
				for (RequisitionInfo r : allDistinctStatusList) {
					if (r.getStatus().equalsIgnoreCase("saved")) {
						allDistinctStatusListforAdmin.add(r);
					}
				}
				
				for (RequisitionInfo u : allRequisitiondata) {
					if (!u.getStatus().equalsIgnoreCase("saved")) {
						allUniqueReqforAdmin.add(u);
					}
				}
				allDistinctStatusList.removeAll(allDistinctStatusListforAdmin);
				
				model.addAttribute("classAndServiceOfPost", reqObj.getClassAndServiceOfPost());
				model.addAttribute("allDistinctStatusList", allDistinctStatusList);
				model.addAttribute("allDistinctGroupList", allDistinctGroupList);
				model.addAttribute("requisitionsList", pageList);
				model.addAttribute("statusForDropdown", status);
				model.addAttribute("dEpartmentId", reqObj.getdEpartmentId());
				model.addAttribute("designation", reqObj.getPostmasterId());
				model.addAttribute("allRequisitiondata",allUniqueReqforAdmin);
				model.addAttribute("uniqueRequisitionNumber", reqObj.getUniqueRequisitionNumber());
			}
			 List<PostMaster> desigList = requisitionService.getAllDesignations(null);
			 model.addAttribute("desigList", desigList);
			return ALL_REGISTERED_REQUISITIONS;
		} catch (Exception e) {
			logger.logError("allRegisteredRequisitions", "exception while getting requisitions data", e);
			throw e;
		}
	}

	@RequestMapping(value = VIEW_REGISTERED_REQUISITION_FORM, method = { RequestMethod.GET, RequestMethod.POST })
	private String viewRequisitionForm(Model model, @ModelAttribute("idRequisition") String idRequisition, String errorMsg)
			throws Exception {
		try {
			List<RequisitionInfo> requisitionForm = requisitionService
					.getRequisitionFormByRequisitionId(Integer.parseInt(idRequisition));
			for (RequisitionDocs requisitionObj : requisitionForm.get(0).getRequisitionDocsList()) {
				if (requisitionObj.getDocType().equalsIgnoreCase("service")) {
					model.addAttribute("serviceDoc", requisitionObj.getFileName());
				} else {
					model.addAttribute("formTypeDocFileName", requisitionObj.getFileName());
				}
			}

			String[] headersArr = { "Category", "Total", "NonESMESP", "ESM","ESP"};
			model.addAttribute("headersArr", headersArr);
			model.addAttribute("errorMsg",errorMsg);

/*			List<BifurcationHelper> helperList = requisitionService
					.getBifuractionHelperList(Integer.parseInt(idRequisition));

			model.addAttribute("bifurcationList", helperList);
*/			
			
			List<BifurcationHelper> helperList = new LinkedList<BifurcationHelper>();
			BifurcationHelper generalBifurcation=new BifurcationHelper();
			generalBifurcation.setCategory("GENERAL");
			BifurcationHelper scBifurcation=new BifurcationHelper();
			scBifurcation.setCategory("SC");
			BifurcationHelper bcaBifurcation=new BifurcationHelper();
			bcaBifurcation.setCategory("BCA");
			BifurcationHelper bcbBifurcation=new BifurcationHelper();
			bcbBifurcation.setCategory("BCB");
			/*BifurcationHelper sbcBifurcation=new BifurcationHelper();
			sbcBifurcation.setCategory("SBC");*/
			BifurcationHelper ebpgcBifurcation=new BifurcationHelper();
			ebpgcBifurcation.setCategory("EWS");
			
			int totalFilled = 0;
			
			 /*if(CommonUtils.isNotEmpty(requisitionForm.get(0))) {
				 totalFilled=totalFilled+requisitionForm.get(0).getEspSeats();
			 }*/
			for(RequisitionReservationInfo info : requisitionForm.get(0).getRequisitionReservationInfoList()) {
				
				if(info.getSubCategory().contains("Total")) {
					totalFilled = totalFilled + info.getTotalSeatsForCategory();	
				}
				
				if(info.getCategory().contains("GENERAL")) {
					if(info.getSubCategory().contains("Total")){
						generalBifurcation.setTotalCount(info.getTotalSeatsForCategory());
						generalBifurcation.setTotalCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("NonESMESP")){
						generalBifurcation.setNonEsmEspCount(info.getTotalSeatsForCategory());
						generalBifurcation.setNonEsmEspCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESM")){
						generalBifurcation.setEsmCount(info.getTotalSeatsForCategory());
						generalBifurcation.setEsmCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESP")){
						generalBifurcation.setEspCount(info.getTotalSeatsForCategory());
						generalBifurcation.setEspCountBackLog(info.getBacklog());
					}
				}else if(info.getCategory().contains("SC")) {
					if(info.getSubCategory().contains("Total")){
						scBifurcation.setTotalCount(info.getTotalSeatsForCategory());
						scBifurcation.setTotalCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("NonESMESP")){
						scBifurcation.setNonEsmEspCount(info.getTotalSeatsForCategory());
						scBifurcation.setNonEsmEspCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESM")){
						scBifurcation.setEsmCount(info.getTotalSeatsForCategory());
						scBifurcation.setEsmCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESP")){
						scBifurcation.setEspCount(info.getTotalSeatsForCategory());
						scBifurcation.setEspCountBackLog(info.getBacklog());
					}
				}else if(info.getCategory().contains("BCA")) {
					if(info.getSubCategory().contains("Total")){
						bcaBifurcation.setTotalCount(info.getTotalSeatsForCategory());
						bcaBifurcation.setTotalCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("NonESMESP")){
						bcaBifurcation.setNonEsmEspCount(info.getTotalSeatsForCategory());
						bcaBifurcation.setNonEsmEspCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESM")){
						bcaBifurcation.setEsmCount(info.getTotalSeatsForCategory());
						bcaBifurcation.setEsmCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESP")){
						bcaBifurcation.setEspCount(info.getTotalSeatsForCategory());
						bcaBifurcation.setEspCountBackLog(info.getBacklog());
					}
				}else if(info.getCategory().contains("BCB")) {
					if(info.getSubCategory().contains("Total")){
						bcbBifurcation.setTotalCount(info.getTotalSeatsForCategory());
						bcbBifurcation.setTotalCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("NonESMESP")){
						bcbBifurcation.setNonEsmEspCount(info.getTotalSeatsForCategory());
						bcbBifurcation.setNonEsmEspCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESM")){
						bcbBifurcation.setEsmCount(info.getTotalSeatsForCategory());
						bcbBifurcation.setEsmCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESP")){
						bcbBifurcation.setEspCount(info.getTotalSeatsForCategory());
						bcbBifurcation.setEspCountBackLog(info.getBacklog());
					}
				}/*else if(info.getCategory().contains("SBC")) {
					if(info.getSubCategory().contains("Total")){
						sbcBifurcation.setTotalCount(info.getTotalSeatsForCategory());
						sbcBifurcation.setTotalCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("NonESMESP")){
						sbcBifurcation.setNonEsmEspCount(info.getTotalSeatsForCategory());
						sbcBifurcation.setNonEsmEspCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESM")){
						sbcBifurcation.setEsmCount(info.getTotalSeatsForCategory());
						sbcBifurcation.setEsmCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESP")){
						sbcBifurcation.setEspCount(info.getTotalSeatsForCategory());
						sbcBifurcation.setEspCountBackLog(info.getBacklog());
					}
				}*/else if(info.getCategory().contains("EWS")) {
					if(info.getSubCategory().contains("Total")){
						ebpgcBifurcation.setTotalCount(info.getTotalSeatsForCategory());
						ebpgcBifurcation.setTotalCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("NonESMESP")){
						ebpgcBifurcation.setNonEsmEspCount(info.getTotalSeatsForCategory());
						ebpgcBifurcation.setNonEsmEspCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESM")){
						ebpgcBifurcation.setEsmCount(info.getTotalSeatsForCategory());
						ebpgcBifurcation.setEsmCountBackLog(info.getBacklog());
					}else if(info.getSubCategory().contains("ESP")){
						ebpgcBifurcation.setEspCount(info.getTotalSeatsForCategory());
						ebpgcBifurcation.setEspCountBackLog(info.getBacklog());
					}
				}
				
			}
			
			helperList.add(generalBifurcation);
			helperList.add(scBifurcation);
			helperList.add(bcaBifurcation);
			helperList.add(bcbBifurcation);
			/*helperList.add(sbcBifurcation);*/
			helperList.add(ebpgcBifurcation);
			
			model.addAttribute("requisitionForm", requisitionForm);
			model.addAttribute("bifurcationList", helperList);
			model.addAttribute("totalFilled", totalFilled);
			
			return VIEW_REGISTERED_REQUISITION_FORM;
		} catch (Exception e) {
			logger.logError("viewRequisitionForm", "exception while getting requisition data", e);
			throw e;
		}
	}

	@RequestMapping(value = VIEW_REQUISITION_REMARK_FORM, method = { RequestMethod.GET, RequestMethod.POST })
	private String viewRequisitionRemarkForm(Model model, @ModelAttribute("idRequisition") String idRequisition)
			throws Exception {
		try {
			List<RequisitionInfo> requisitionForm = requisitionService
					.getRequisitionFormByRequisitionId(Integer.parseInt(idRequisition));
			for (RequisitionDocs requisitionObj : requisitionForm.get(0).getRequisitionDocsList()) {
				if (requisitionObj.getDocType().equalsIgnoreCase("service")) {
					model.addAttribute("serviceDoc", requisitionObj.getFileName());
				} else {
					model.addAttribute("formTypeDocFileName", requisitionObj.getFileName());
				}
			}

			List<BifurcationHelper> helperList = requisitionService
					.getBifuractionHelperList(Integer.parseInt(idRequisition));
			String[] headersArr = { "Category", "Total", "NonESMESP", "ESM","ESP"};
			model.addAttribute("headersArr", headersArr);
			model.addAttribute("bifurcationList", helperList);
			model.addAttribute("requisitionForm", requisitionForm);
			return VIEW_REQUISITION_REMARK_FORM;
		} catch (Exception e) {
			logger.logError("viewRequisitionForm", "exception while getting requisition data", e);
			throw e;
		}
	}

	@RequestMapping(value = ALL_REQUISITION_REQUESTS_FOR_ADMIN, method = { RequestMethod.GET, RequestMethod.POST })
	private String allRequistionRequests(Model model, HttpSession session, HttpServletRequest request)
			throws Exception {
		try {
			final ExtendedPaginatedList pageList = requisitionService
					.getAllRequisitionsRequests(getPaginatedListFromRequest(request));
			model.addAttribute("requisitionRequestsList", pageList);
			return ALL_REQUISITION_REQUESTS_FOR_ADMIN;
		} catch (Exception e) {
			logger.logError("allRequistionRequests", "exception while getting requisition requests", e);
			throw e;
		}
	}

	@RequestMapping(value = "populateBifurcatedSeats", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<BifurcationHelper> populateBifurcatedSeats(@RequestParam("noOfPosts") String noOfPosts, @RequestParam("previosuRosterPoint") String previosuRosterPoint)
			throws Exception {
		try {

			List<BifurcationHelper> bifurcatedValues = new ArrayList<BifurcationHelper>();
			bifurcatedValues = requisitionService.getBifucatedValues(noOfPosts, previosuRosterPoint);
			return bifurcatedValues;
		} catch (Exception e) {
			logger.logError("populateBifurcatedSeats", "exception while getting requisition requests", e);
			throw e;
		}
	}

	@RequestMapping(value = REQUISITION_DASHBOARD, method = { RequestMethod.GET, RequestMethod.POST })
	private String requisitionDashboard(Model model, HttpSession session, @ModelAttribute("mAcroStatus") String mAcroStatus,
			@ModelAttribute("deptId") String deptId,@ModelAttribute("nameOfPost") String nameOfPost,@ModelAttribute("startDate") String startDate,
			@ModelAttribute("endDate") String endDate) throws Exception {
		try {
			Integer totalRequisitionCount = 0;
			Integer totalSavedRequisitionCount = 0;
			Integer totalNewRequisitionCount = 0;
			Integer totalApprovedCount = 0;
			Integer totalBackReferredCount =0;
			Integer totalReqRegisteredUsersCount=0;
			Integer totalReSubRequisitionCount=0;
			Integer totalSubReSubCount=0;
			Integer totalReqAdvertisedCount=0;
			long totalRequisitionNoOFPostsCount = 0;
			long totalNewRequisitionNoOfPostsCount = 0;
			long totalApprovedNoOfPostsCount = 0;
			long totalBackReferredPostsCount = 0;
			long totalSavedRequisitionPostsCount = 0;
			long totalReSubRequisitionPostsCount=0;
			long totalSubReSubRequisitionPostsCount=0;
			long totalReqAdvertisedNoOfPostCount=0;
			
			Integer dEpartmentId = (Integer) session.getAttribute("idDept");
			List<RequisitionInfo> allRequisitiondata = requisitionService.getAllRequisitioData(dEpartmentId);

			for (RequisitionInfo r : allRequisitiondata) {
				 if(r.getdEpartmentId()!=90) {
				if (!r.getStatus().equalsIgnoreCase("saved")) {
					totalRequisitionNoOFPostsCount = totalRequisitionNoOFPostsCount + r.getNumberOfPostToBeFilled();
					totalRequisitionCount = totalRequisitionCount + 1;
				}
				if (r.getStatus().equalsIgnoreCase("submitted")) {
					totalNewRequisitionCount = totalNewRequisitionCount + 1;
					totalNewRequisitionNoOfPostsCount = totalNewRequisitionNoOfPostsCount
							+ r.getNumberOfPostToBeFilled();
				}
				if (r.getStatus().equalsIgnoreCase("approved")) {
					totalApprovedCount = totalApprovedCount + 1;
					totalApprovedNoOfPostsCount = totalApprovedNoOfPostsCount + r.getNumberOfPostToBeFilled();
				}
				if (r.getStatus().equalsIgnoreCase("Advertised")) {
					totalReqAdvertisedCount = totalReqAdvertisedCount + 1;
					totalReqAdvertisedNoOfPostCount = totalReqAdvertisedNoOfPostCount + r.getNumberOfPostToBeFilled();
				}
				if (r.getStatus().equalsIgnoreCase("back referred")) {
					totalBackReferredCount = totalBackReferredCount + 1;
					totalBackReferredPostsCount = totalBackReferredPostsCount + r.getNumberOfPostToBeFilled();
				}
				if (r.getStatus().equalsIgnoreCase("saved")) {
					if(r.getPostmasterId()!=0) {
					totalSavedRequisitionPostsCount = totalSavedRequisitionPostsCount + r.getNumberOfPostToBeFilled();
					totalSavedRequisitionCount = totalSavedRequisitionCount + 1;
				    }
				  }
				if (r.getStatus().equalsIgnoreCase("re-submitted")) {
					if(r.getPostmasterId()!=0) {
					totalReSubRequisitionPostsCount = totalReSubRequisitionPostsCount + r.getNumberOfPostToBeFilled();
					totalReSubRequisitionCount = totalReSubRequisitionCount + 1;
				    }
				  }
				if(CommonUtils.isNotEmpty(totalReSubRequisitionCount)) {
					totalSubReSubCount=totalReSubRequisitionCount+totalNewRequisitionCount;
					totalSubReSubRequisitionPostsCount=totalReSubRequisitionPostsCount+totalNewRequisitionNoOfPostsCount;
				}
			   }
			}
			
			List<UserLogin> userList=requisitionService.getAllReqRegisteredUsers();
              if(CommonUtils.isNotEmpty(userList)) {
            	  totalReqRegisteredUsersCount=userList.size();
              }
			
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
			
			

			List<Department> deptList=baseDataService.getDepartmentList();
			List<String> uniqueNameOfPost=baseDataService.getUniqueNameOfPostList();
			model.addAttribute("startDate",startDate);
			model.addAttribute("endDate",endDate);
			model.addAttribute("uniqueNameOfPostList",uniqueNameOfPost);
			model.addAttribute("nameOfPostForDropDown",nameOfPost);	
			model.addAttribute("deptListForDropDown",deptList);
			if(!deptId.contains("Department...") && CommonUtils.isNotEmpty(deptId)) {
			model.addAttribute("deptDropDown",Integer.parseInt(deptId));
			}
		
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
//***************************************************** Requisition Next Step Graph Ends ****************************************************
			model.addAttribute("totalRequisitionCount", totalRequisitionCount);
			model.addAttribute("totalNewRequisitionCount", totalNewRequisitionCount);
			model.addAttribute("totalApprovedCount", totalApprovedCount);
			model.addAttribute("totalRequisitionNoOFPostsCount", totalRequisitionNoOFPostsCount);
			model.addAttribute("totalNewRequisitionNoOfPostsCount", totalNewRequisitionNoOfPostsCount);
			model.addAttribute("totalApprovedNoOfPostsCount", totalApprovedNoOfPostsCount);
			model.addAttribute("totalBackReferredCount", totalBackReferredCount);
			model.addAttribute("totalBackReferredPostsCount", totalBackReferredPostsCount);
			model.addAttribute("totalSavedRequisitionCount", totalSavedRequisitionCount);
			model.addAttribute("totalSavedRequisitionPostsCount", totalSavedRequisitionPostsCount);
			model.addAttribute("totalReqRegisteredUsersCount", totalReqRegisteredUsersCount);  
			model.addAttribute("totalSubReSubCount", totalSubReSubCount);
			model.addAttribute("totalSubReSubRequisitionPostsCount", totalSubReSubRequisitionPostsCount);  
			model.addAttribute("totalReSubRequisitionCount", totalReSubRequisitionCount);
			model.addAttribute("totalReSubRequisitionPostsCount", totalReSubRequisitionPostsCount);
			model.addAttribute("totalReqAdvertisedCount", totalReqAdvertisedCount);
			model.addAttribute("totalReqAdvertisedNoOfPostCount", totalReqAdvertisedNoOfPostCount);
			
			return REQUISITION_DASHBOARD;
		} catch (Exception e) {
			logger.logError("requisitionDashboard", "error while getting requisition data", e);
			throw e;
		}

	}

	@RequestMapping(value = APPROVE_REJECT_REQUISITION, method = { RequestMethod.GET, RequestMethod.POST })
	private String statusForRequisition(Model model, @ModelAttribute("status") String status,
			@ModelAttribute("idRequisition") String idRequisition, RequisitionInfoRemarks reqRemarkObj,
			HttpSession session) throws Exception {
		try {
			if (CommonUtils.isNotEmpty(reqRemarkObj)) {
				List<RequisitionInfo> reqObjToGet = requisitionService
						.getRequisitionFormByRequisitionId(Integer.parseInt(idRequisition));
				RequisitionInfo reqObj = new RequisitionInfo();
				reqObj = reqObjToGet.get(0);
				if (status.equalsIgnoreCase("approved")) {
					reqObj.setStatus("approved");
					requisitionService.updateRequisitionStatus(reqObj);
					reqRemarkObj.setRequisitionApprovedOrNot(true);
					reqRemarkObj.setLastUpdateDateAndTime(new Date());
					reqRemarkObj.setIdRequisition(Integer.parseInt(idRequisition));
					reqRemarkObj = requisitionService.saveRequisitionsRemark(reqRemarkObj);

					Notifications notifyObj = new Notifications();
					notifyObj.setdEpartmentId(reqObj.getdEpartmentId());
					notifyObj.setIdRequisition(reqObj.getIdRequisition());
					notifyObj.setNotificationGeneratedDateAndTime(new Date());
					notifyObj.setReadUnreadStatus(false);
					notifyObj.setNotificationMsg("Your requisition "+reqObj.getUniqueRequisitionNumber()+" has been approved ");
					notifyObj = requisitionService.saveNotificaton(notifyObj);
				} else if (status.equalsIgnoreCase("back referred")) {
					reqObj.setStatus("back referred");
					requisitionService.updateRequisitionStatus(reqObj);
					reqRemarkObj.setLastUpdateDateAndTime(new Date());
					reqRemarkObj.setRequisitionApprovedOrNot(false);
					reqRemarkObj.setIdRequisition(Integer.parseInt(idRequisition));
					reqRemarkObj = requisitionService.saveRequisitionsRemark(reqRemarkObj);

					Notifications notifyObj = new Notifications();
					notifyObj.setdEpartmentId(reqObj.getdEpartmentId());
					notifyObj.setIdRequisition(reqObj.getIdRequisition());
					notifyObj.setNotificationGeneratedDateAndTime(new Date());
					notifyObj.setReadUnreadStatus(false);
					notifyObj
							.setNotificationMsg("Your requisition "+reqObj.getUniqueRequisitionNumber()+" has been back referred, Kindly update and Re-Submit");
					notifyObj = requisitionService.saveNotificaton(notifyObj);
				}
				
				String smsMsg=URLEncoder.encode("Please note that the action taken by HSSC on your requisition ["+reqObj.getUniqueRequisitionNumber()+"] "
						+ "for the post of ["+reqObj.getPostObj().getPostName()+"] is ["+status+"]. If status is Back-referred, "
								+ "correct and re-submit your requisition ["+reqObj.getUniqueRequisitionNumber()+"]. If status is Approved, ignore this message.","UTF-8");
				
				SmsReceivers receiverObj=new SmsReceivers();	
			    receiverObj.setReceiverRole("REQ");
			      List<SmsReceivers> receiversList=requisitionService.getReceiversList(receiverObj);
			      receiverObj.setReceiverMobile(reqObj.getPhoneNumberOfNodelOfficer().toString());
			      receiversList.add(receiverObj);
			      String senderId=URLEncoder.encode("RQHSSC", "UTF-8");
			      smsSender.sendSms(receiversList, smsMsg,senderId);
			}
			model.addAttribute("reqRemarkObj", reqRemarkObj);
			return "redirect:" + ALL_REGISTERED_REQUISITIONS;
		} catch (Exception e) {
			logger.logError("statusForRequisition", "error while defining the status", e);
			throw e;
		}

	}

	@RequestMapping(value = BACK_REFERRED_REQUISITION_INFO, method = { RequestMethod.GET, RequestMethod.POST })
	private String backReferred(Model model, @ModelAttribute("idRequisition") String idRequisition) throws Exception {
		try {
			List<RequisitionInfo> reqObjToGet = requisitionService
					.getRequisitionFormByRequisitionId(Integer.parseInt(idRequisition));
			RequisitionInfo reqObj = new RequisitionInfo();
			reqObj = reqObjToGet.get(0);
			RequisitionInfoRemarks reqRemarkObj = requisitionService
					.getRequisitionRemarksInfoByIdRequisition(Integer.parseInt(idRequisition));
			model.addAttribute("reqRemarkObj", reqRemarkObj);
			model.addAttribute("reqObj", reqObj);
			return BACK_REFERRED_REQUISITION_INFO;
		} catch (Exception e) {
			logger.logError("backReferred", "error while getting backReferred info", e);
			throw e;
		}

	}

	@RequestMapping(value = OPEN_NOTIFICATION, method = { RequestMethod.GET, RequestMethod.POST })
	private String openNotification(Model model,
			@ModelAttribute("notificationGeneratedDateAndTime") String notificationGeneratedDateAndTime, HttpServletRequest request )
			throws Exception {
		try {
			 Date date=DateFormatterUtility.stringtoDateConversion(notificationGeneratedDateAndTime, "yyyy-MM-dd HH:mm:ss.S");
			Notifications notifyObj = requisitionService.getAllNotificationsByGeneratedTime(date);
			List<RequisitionInfo> reqObj=requisitionService.getRequisitionFormByRequisitionId(notifyObj.getIdRequisition());
			RequisitionInfo newReqObj=reqObj.get(0);
			final ExtendedPaginatedList pageList = requisitionService.getRequisitionListByIdRequisition(newReqObj.getIdRequisition(),
					getPaginatedListFromRequest(request));
			   if(CommonUtils.isNotEmpty(pageList.getList())) {
				   requisitionService.updateNotificationStatus(notifyObj.getNotificationId());
			   }

			List<RequisitionInfo> allDistinctStatusList = requisitionService.getAllDistinctStatusList();

			model.addAttribute("allDistinctStatusList", allDistinctStatusList);
			model.addAttribute("requisitionsList", pageList);
			return ALL_REGISTERED_REQUISITIONS;
		} catch (Exception e) {
			logger.logError("openNotification", "error while getting notification Info", e);
			throw e;
		}

	}
	
	@RequestMapping(value = READ_ONLY_REQUISITION, method = { RequestMethod.GET, RequestMethod.POST })
	private String readOnlyRequisition(Model model, HttpServletRequest request) throws Exception {

		List<Department> deptList = baseDataService.getDepartmentList();
		model.addAttribute("deptList", deptList);
		return READ_ONLY_REQUISITION;
	}
	
	
	@RequestMapping(value = SAVE_READ_ONLY_REQUISITION, method = { RequestMethod.GET, RequestMethod.POST })
	private String saveReadOnlyRequisition(Model model, HttpServletRequest request,
			@ModelAttribute("validateBifurcationObj") ValidateBifurcation validateBifurcationObj) throws Exception {
		try {
			List<BifurcationHelper> bifurcationList = requisitionService.getBifucatedValues(
					validateBifurcationObj.getNoofposts().toString(),
					validateBifurcationObj.getPreviousrosterpoint().toString());
			validateBifurcationObj.setViewedon(new Date());
			ValidateBifurcation validateObj=requisitionService.saveValidateBifurcationObj(validateBifurcationObj);
			String[] headersArr = { "Category", "Total", "NonESMESP", "ESM","ESP"};
			List<ValidateBifurcationCounts> validateCountList = new ArrayList<ValidateBifurcationCounts>();
			for (BifurcationHelper bifurcationHelper : bifurcationList) {				
				for (int i = 1; i <= 4; i++) {
					ValidateBifurcationCounts countObj = new ValidateBifurcationCounts();
					countObj.setCategory(bifurcationHelper.getCategory());
					countObj.setSubCategory(headersArr[i]);
					if (headersArr[i].contains("Total")) {
						countObj.setTotalSeatsForCategory(bifurcationHelper.getTotalCount());
					} else if (headersArr[i].contains("NonESMESP")) {
						countObj.setTotalSeatsForCategory(bifurcationHelper.getNonEsmEspCount());
					} else if (headersArr[i].contains("ESM")) {
						countObj.setTotalSeatsForCategory(bifurcationHelper.getEsmCount());
					} else if (headersArr[i].contains("ESP")) {
						countObj.setTotalSeatsForCategory(bifurcationHelper.getEspCount());
					}
					countObj.setIdvalidatebifurcation(validateObj.getIdvalidatebifurcation());
					validateCountList.add(countObj);
				}								
			}
			requisitionService.saveValidateBifurcationCounts(validateCountList);
			List<Department> deptList = baseDataService.getDepartmentList();
			model.addAttribute("deptList", deptList);
			model.addAttribute("headersArr", headersArr);
			model.addAttribute("reqBifurcationList", bifurcationList);
			model.addAttribute("noOfPosts", validateBifurcationObj.getNoofposts());
			model.addAttribute("prevRoasterPoint", validateBifurcationObj.getPreviousrosterpoint());
			model.addAttribute("fieldOffice", validateBifurcationObj.getFieldOfficeName());
			model.addAttribute("deptId", validateBifurcationObj.getdEpartmentId());
		} catch (Exception e) {
			logger.logError("saveReadOnlyRequisition", "error while getting saveReadOnlyRequisition Info", e);
		}
		return READ_ONLY_REQUISITION;
	}
	
	
	@RequestMapping(value=ALL_REPORTS, method=RequestMethod.GET)
	private String  allReports(Model model) {
		try {
			
		}catch(Exception e) {
			logger.logError("deptWiseRequisitions", "error while getting departmentInfo", e);
		}
		return ALL_REPORTS;
	}
	
	@RequestMapping(value=DEPTWISE_REQUISITIONS_AND_BIFURCATION, method= {RequestMethod.POST,RequestMethod.GET})
	private String  departmewiseReqReport(Model model, String Group) {
		try {
			 long totalNoOfPosts=0;
			 long generalTotal=0;
			 long generalNonesmesp=0;
			 long generalesm=0;
			 long generalesp=0;
			 long scTotal=0;
			 long scNonesmesp=0;
			 long scesm=0;
			 long scesp=0;
			 long bcaTotal=0;
			 long bcaNonesmesp=0;
			 long bcaesm=0;
			 long bcaesp=0;
			 long bcbTotal=0;
			 long bcbNonesmesp=0;
			 long bcbesm=0;
			 long bcbesp=0;
			 long sbcTotal=0;
			 long sbcNonesmesp=0;
			 long sbcesm=0;
			 long sbcesp=0;
			 long ebpgcTotal=0;
			 long ebpgcNonesmesp=0;
			 long ebpgcesm=0;
			 long ebpgcesp=0;
			 long pwdTotal=0;
			
			List<RequisitionReport> allDeptRequisitions=requisitionService.getAllDepartmentRequisitions(Group);
			  if(CommonUtils.isNotEmpty(allDeptRequisitions)) {
				  for(RequisitionReport list:allDeptRequisitions) {
					  totalNoOfPosts=totalNoOfPosts+list.getNumberOfPostToBeFilled();
					  generalTotal=generalTotal+list.getGeneralTotal();
					  generalNonesmesp=generalNonesmesp+list.getGeneralNonesmesp();
					  generalesm=generalesm+list.getGeneralEsm();
					  generalesp=generalesp+list.getGeneralEsp();
					  scTotal=scTotal+list.getScTotal();
					  scNonesmesp=scNonesmesp+list.getScNonesmesp();
					  scesm=scesm+list.getScEsm();
					  scesp=scesp+list.getScEsp();
					  bcaTotal=bcaTotal+list.getBcaTotal();
					  bcaNonesmesp=bcaNonesmesp+list.getBcaNonesmesp();
					  bcaesm=bcaesm+list.getBcaEsm();
					  bcaesp=bcaesp+list.getBcaEsp();
					  bcbTotal=bcbTotal+list.getBcbTotal();
					  bcbNonesmesp=bcbNonesmesp+list.getBcbNonesmesp();
					  bcbesm=bcbesm+list.getBcbEsm();
					  bcbesp=bcbesp+list.getBcbEsp();
					  sbcTotal=sbcTotal+list.getSbcTotal();
					  sbcNonesmesp=sbcNonesmesp+list.getSbcNonesmesp();
					  sbcesm=sbcesm+list.getSbcEsm();
					  sbcesp=sbcesp+list.getSbcEsp();
					  ebpgcTotal=ebpgcTotal+list.getEbpgcTotal();
					  ebpgcNonesmesp=ebpgcNonesmesp+list.getEbpgcNonesmesp();
					  ebpgcesm=ebpgcesm+list.getEbpgcEsm();
					  ebpgcesp=ebpgcesp+list.getEbpgcEsp();
					  pwdTotal=pwdTotal+list.getTotalPwd();
							  
				  }
				  model.addAttribute("allDeptRequisitions",allDeptRequisitions);
				  model.addAttribute("generalTotal",generalTotal);
				  model.addAttribute("generalNonesmesp",generalNonesmesp);
				  model.addAttribute("generalesm",generalesm);
				  model.addAttribute("generalesp",generalesp);
				  model.addAttribute("scTotal",scTotal);
				  model.addAttribute("scNonesmesp",scNonesmesp);
				  model.addAttribute("scesm",scesm);
				  model.addAttribute("scesp",scesp);
				  model.addAttribute("bcaTotal",bcaTotal);
				  model.addAttribute("bcaNonesmesp",bcaNonesmesp);
				  model.addAttribute("bcaesm",bcaesm);
				  model.addAttribute("bcaesp",bcaesp);
				  model.addAttribute("bcbTotal",bcbTotal);
				  model.addAttribute("bcbNonesmesp",bcbNonesmesp);
				  model.addAttribute("bcbesm",bcbesm);
				  model.addAttribute("bcbesp",bcbesp);
				  model.addAttribute("sbcTotal",sbcTotal);
				  model.addAttribute("sbcNonesmesp",sbcNonesmesp);
				  model.addAttribute("sbcesm",sbcesm);
				  model.addAttribute("sbcesp",sbcesp);
				  model.addAttribute("ebpgcTotal",ebpgcTotal);
				  model.addAttribute("ebpgcNonesmesp",ebpgcNonesmesp);
				  model.addAttribute("ebpgcesm",ebpgcesm);
				  model.addAttribute("ebpgcesp",ebpgcesp);
				  model.addAttribute("pwdTotal",pwdTotal);
				  model.addAttribute("totalNoOfPosts",totalNoOfPosts);
			  }
			  
		}catch(Exception e) {
			logger.logError("deptWiseRequisitions", "error while getting departmentInfo", e);
		}
		return DEPTWISE_REQUISITIONS_AND_BIFURCATION;
	}
	
	
	@RequestMapping(value=EXPORT_EXCEL_DEPTWISE_REQUISITION, method= {RequestMethod.POST})
	private String exportExcelDeptwiseRequisition(Model model,HttpServletResponse response, String Group) {
		   try {
			   List<RequisitionReport> allDeptRequisitions=requisitionService.getAllDepartmentRequisitions(Group);
			     if(CommonUtils.isNotEmpty(allDeptRequisitions)) {
			    	    XSSFWorkbook workbook = new XSSFWorkbook();
				        XSSFSheet sheet = workbook.createSheet("DepartmentWiseRequisitionReport"+Group);
				        XSSFRow row = sheet.createRow(0);
				        XSSFCell cell;
				        
				        XSSFCellStyle style = workbook.createCellStyle();
				        XSSFFont font = workbook.createFont();
				        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				        style.setFont(font);  
				        style.setFillForegroundColor(new XSSFColor(new java.awt.Color(198, 224, 180)));
				        style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
				        
				        cell=row.createCell(0);
				        cell.setCellValue("Department");
				        cell.setCellStyle(style);
				        cell=row.createCell(1);
				        cell.setCellValue("Post name");
				        cell.setCellStyle(style);
				        cell=row.createCell(2);
				        cell.setCellValue("No. of Posts");
				        cell.setCellStyle(style);
				        cell=row.createCell(3);
				        cell.setCellValue("General Total");
				        cell.setCellStyle(style);
				        cell=row.createCell(4);
				        cell.setCellValue("General NONESMESP");
				        cell.setCellStyle(style);
				        cell=row.createCell(5);
				        cell.setCellValue("General ESM");
				        cell.setCellStyle(style);
				        cell=row.createCell(6);
				        cell.setCellValue("General ESP");
				        cell.setCellStyle(style);
				        cell=row.createCell(7);
				        cell.setCellValue("SC Total");
				        cell.setCellStyle(style);
				        cell=row.createCell(8);
				        cell.setCellValue("SC NONESMESP");
				        cell.setCellStyle(style);
				        cell=row.createCell(9);
				        cell.setCellValue("SC ESM");
				        cell.setCellStyle(style);
				        cell=row.createCell(10);
				        cell.setCellValue("SC ESP");
				        cell.setCellStyle(style);
				        cell=row.createCell(11);
				        cell.setCellValue("BCA Total");
				        cell.setCellStyle(style);
				        cell=row.createCell(12);
				        cell.setCellValue("BCA NONESMESP");
				        cell.setCellStyle(style);
				        cell=row.createCell(13);
				        cell.setCellValue("BCA ESM");
				        cell.setCellStyle(style);
				        cell=row.createCell(14);
				        cell.setCellValue("BCA ESP");
				        cell.setCellStyle(style);
				        cell=row.createCell(15);
				        cell.setCellValue("BCB Total");
				        cell.setCellStyle(style);
				        cell=row.createCell(16);
				        cell.setCellValue("BCB NONESMESP");
				        cell.setCellStyle(style);
				        cell=row.createCell(17);
				        cell.setCellValue("BCB ESM");
				        cell.setCellStyle(style);
				        cell=row.createCell(18);
				        cell.setCellValue("BCB ESP");
				        cell.setCellStyle(style);
				        cell=row.createCell(19);
				        cell.setCellValue("SBC Total");
				        cell.setCellStyle(style);
				        cell=row.createCell(20);
				        cell.setCellValue("SBC NONESMESP");
				        cell.setCellStyle(style);
				        cell=row.createCell(21);
				        cell.setCellValue("SBC ESM");
				        cell.setCellStyle(style);
				        cell=row.createCell(22);
				        cell.setCellValue("SBC ESP");
				        cell.setCellStyle(style);
				        cell=row.createCell(23);
				        cell.setCellValue("EBPGC Total");
				        cell.setCellStyle(style);
				        cell=row.createCell(24);
				        cell.setCellValue("EBPGC NONESMESP");
				        cell.setCellStyle(style);
				        cell=row.createCell(25);
				        cell.setCellValue("EBPGC ESM");
				        cell.setCellStyle(style);
				        cell=row.createCell(26);
				        cell.setCellValue("EBPGC ESP");
				        cell.setCellStyle(style);
				        cell=row.createCell(27);
				        cell.setCellValue("PWD");
				        cell.setCellStyle(style);
				        
				        
				        
				        
				       int rownum=1;
						for(RequisitionReport r:allDeptRequisitions) {
							row = sheet.createRow(rownum++);
							cell=row.createCell(0);
							cell.setCellValue(r.getDepartmentName());
							cell=row.createCell(1);
							cell.setCellValue(r.getPostName());
							cell=row.createCell(2);
							cell.setCellValue(r.getNumberOfPostToBeFilled());	
							cell=row.createCell(3);
							cell.setCellValue(r.getGeneralTotal());
							cell=row.createCell(4);
							cell.setCellValue(r.getGeneralNonesmesp());
							cell=row.createCell(5);
							cell.setCellValue(r.getGeneralEsm());
							cell=row.createCell(6);
							cell.setCellValue(r.getGeneralEsp());
							cell=row.createCell(7);
							cell.setCellValue(r.getScTotal());
							cell=row.createCell(8);
							cell.setCellValue(r.getScNonesmesp());
							cell=row.createCell(9);
							cell.setCellValue(r.getScEsm());
							cell=row.createCell(10);
							cell.setCellValue(r.getScEsp());
							cell=row.createCell(11);
							cell.setCellValue(r.getBcaTotal());
							cell=row.createCell(12);
							cell.setCellValue(r.getBcaNonesmesp());
							cell=row.createCell(13);
							cell.setCellValue(r.getBcaEsm());
							cell=row.createCell(14);
							cell.setCellValue(r.getBcaEsp());
							cell=row.createCell(15);
							cell.setCellValue(r.getBcbTotal());
							cell=row.createCell(16);
							cell.setCellValue(r.getBcbNonesmesp());
							cell=row.createCell(17);
							cell.setCellValue(r.getBcbEsm());
							cell=row.createCell(18);
							cell.setCellValue(r.getBcbEsp());
							cell=row.createCell(19);
							cell.setCellValue(r.getSbcTotal());
							cell=row.createCell(20);
							cell.setCellValue(r.getSbcNonesmesp());
							cell=row.createCell(21);
							cell.setCellValue(r.getSbcEsm());
							cell=row.createCell(22);
							cell.setCellValue(r.getSbcEsp());
							cell=row.createCell(23);
							cell.setCellValue(r.getEbpgcTotal());
							cell=row.createCell(24);
							cell.setCellValue(r.getEbpgcNonesmesp());
							cell=row.createCell(25);
							cell.setCellValue(r.getEbpgcEsm());
							cell=row.createCell(26);
							cell.setCellValue(r.getEbpgcEsp());
							cell=row.createCell(27);
							cell.setCellValue(r.getTotalPwd());
									
						}
						
						FileInputStream inputStream = null;
						OutputStream outStream = null;

						try{

							String home = System.getProperty("user.home");
							File fileToDownload = new File(home+"/Downloads/DepartmentWiseRequisitionReport"+Group+".xlsx"); 
						/*final File fileToDownload = new File(baseDataService.getBaseTransferConfigPath().getTransferBaseFolderPath() + File.separator
											+ user.getDepartment().getDepartmentName() + File.separator +"Designation_"+ empPointsObj.getEmpTransferInfo().getIdDesignation());*/
									if (!fileToDownload.exists())
										fileToDownload.mkdirs();
						OutputStream file = new FileOutputStream(fileToDownload.getAbsolutePath() + File.separator +"DepartmentWiseRequisitionReport"+Group+".xlsx");
						workbook.write(file);

						file.close();

									File excelFile = new File(fileToDownload.getAbsolutePath() + File.separator +"DepartmentWiseRequisitionReport"+Group+".xlsx");
									if (excelFile.exists()) {
										inputStream = new FileInputStream(excelFile);
										response.setContentType("application/vnd.ms-excel");
										response.setHeader("Content-Disposition", "attachment;filename=DepartmentWiseRequisitionReport"+Group+".xlsx");
										outStream = response.getOutputStream();
										byte[] buffer = new byte[4096];
										int bytesRead = -1;

										ByteArrayOutputStream bos = new ByteArrayOutputStream();
										while ((bytesRead = inputStream.read(buffer)) != -1) {
											outStream.write(buffer, 0, bytesRead);
											bos.write(buffer, 0, bytesRead);
										}
									}

						}catch (Exception e) {
									logger.logError("generateExcel", "exception While generating excel for point calculation", e);
								} finally {
									try {
										if (inputStream != null) {
											inputStream.close();
										}
										if (outStream != null) {
											outStream.close();
										}
									} catch (Exception e2) {
										System.out.println("thr is error");
									}
								}
			     }
		   }catch(Exception e) {
			   logger.logError("exportExcelDeptwiseRequisition", "error while getting Requisirion Info", e);
		   }
		   
		return null;
	}
	
	
	@RequestMapping(value = FETCH_ALL_POST, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String fetchAllPosts(@RequestParam("postGroupId") Integer postGroupId, Model model) {
		 List<PostMaster> desigList=new ArrayList<PostMaster>();
		try {
			
			desigList = requisitionService.getAllDesignations(postGroupId);
			model.addAttribute("desigList", desigList);
        
		} catch (Exception e) {
			logger.logError("fetchAllPosts", "exception while fetching corresponding PostMaster Data", e);
		}
		return "designationList";
	}
	
			
	@RequestMapping(value = ADVT_STATUS_FORM_FOR_SPE, method = {RequestMethod.GET,RequestMethod.POST})
	public String advtStatusFormForSpe(Model model,HttpSession session, HttpServletRequest request) {
		
		try {
			Integer dEpartmentId = (Integer) session.getAttribute("idDept");
			
			 List<PostMaster> desigList = requisitionService.getAllDesignations(null);
			 
			 final ExtendedPaginatedList pageList = requisitionService.getAllAdvtForSPE(dEpartmentId,
						getPaginatedListFromRequest(request));
			 model.addAttribute("advtStatusList", pageList);
			 model.addAttribute("desigList", desigList);
			} catch (Exception e) {
				logger.logError("advtStatusFormForSpe", "exception while Opening the form", e);
		}
		return ADVT_STATUS_FORM_FOR_SPE;
		}
		
	@RequestMapping(value = SAVE_ADVT_STATUS_FORM_FOR_SPE, method = RequestMethod.POST)
	public String saveAdvtStatusFormForSpe(Model model, HttpSession session, HttpServletRequest request, @ModelAttribute("advtStatusReq") AdvtStatusForSPE advtStatusReq) {
		try {
			Integer dEpartmentId = (Integer) session.getAttribute("idDept");
			AdvtStatusForSPE newAdvtStatusReq=new AdvtStatusForSPE();
			
			
			
			List<PostMaster> desigList = requisitionService.getAllDesignations(null);
			model.addAttribute("desigList", desigList);
			
			 if(CommonUtils.isNotEmpty(advtStatusReq.getAdvtstatusforspeId())) {
				 advtStatusReq.setUpdatedDate(new Date());
				 newAdvtStatusReq=requisitionService.saveAdvtStatusForSpe(advtStatusReq);
			 }else {
				 advtStatusReq.setdEpartmentId(dEpartmentId);
				 advtStatusReq.setCreatedDate(new Date());
				 newAdvtStatusReq=requisitionService.saveAdvtStatusForSpe(advtStatusReq);
			 }
			if(CommonUtils.isNotEmpty(newAdvtStatusReq)) {
				model.addAttribute("success", "Your response has been submitted successfully");
			}
			else {
				model.addAttribute("failed", "error in submitting the Data");
			}
			 final ExtendedPaginatedList pageList = requisitionService.getAllAdvtForSPE(dEpartmentId,
						getPaginatedListFromRequest(request));
			 model.addAttribute("advtStatusList", pageList);
			
		} catch (Exception e) {
			logger.logError("advtStatusFormForSpe", "exception while Opening the form", e);
			model.addAttribute("failed", "error in submitting the Data");
	}
	return ADVT_STATUS_FORM_FOR_SPE;
	}	
}
