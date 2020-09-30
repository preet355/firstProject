package in.hkcl.service;

import java.util.Date;
import java.util.List;

import javax.management.Notification;

import in.hkcl.model.AdvtStatusForSPE;
import in.hkcl.model.BifurcationHelper;
import in.hkcl.model.Department;
import in.hkcl.model.HsscConfig;
import in.hkcl.model.Notifications;
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

public interface RequisitionService {

	public RequisitionInfo saveRequisitionForm(RequisitionInfo reqObj) throws Exception ;

	public ExtendedPaginatedList getAllRegisteredRequisitions(Integer idDepartment,
			ExtendedPaginatedList paginatedListFromRequest, String status, RequisitionInfo reqObj) throws Exception;

	public List<RequisitionInfo> getRequisitionFormByRequisitionId(Integer idRequisition) throws Exception;

	public HsscConfig getHSSCConfig() throws Exception;
	
	//public int getvalueAfterSeatBifurcation(int num, String category, String subCategory) throws Exception;

	public List<BifurcationHelper> getBifuractionHelperList(Integer idRequisition);

	public void savePathObjectByIdRequisition(RequisitionDocs docsObj);
	
	public RequisitionInfo updateRequisition(RequisitionInfo reqObj) throws Exception;

	public ExtendedPaginatedList getAllRequisitionsRequests(ExtendedPaginatedList paginatedListFromRequest) throws Exception;

	public void updateRequisitionStatus(RequisitionInfo reqObj);

	public List<RequisitionDocs> getDocsByRequisitionId(Integer idRequisition) throws Exception;

	public List<BifurcationHelper> getBifucatedValues(String noOfPosts, String prevRosterPoint) throws Exception;

	public List<RequisitionInfo> getAllRequisitioData(Integer dEpartmentId) throws Exception;

	public List<RequisitionInfo> getAllDistinctStatusList() throws Exception;

	public RequisitionInfoRemarks saveRequisitionsRemark(RequisitionInfoRemarks reqRemarkObj) throws Exception;

	public RequisitionInfoRemarks getRequisitionRemarksInfoByIdRequisition(Integer idRequisition) throws Exception;

	public Notifications saveNotificaton(Notifications notifyObj) throws Exception;

	public List<Notifications> getAllNotificationsByDepartment(Integer dEpartmentId) throws Exception;

	public Notifications getAllNotificationsByGeneratedTime(Date date) throws Exception;

	public ExtendedPaginatedList getRequisitionListByIdRequisition(Integer idRequisition,
			ExtendedPaginatedList paginatedListFromRequest) throws Exception;

	public void updateNotificationStatus(Integer notificationId) throws Exception;

	public List<BifurcationHelper> getSecondBifuractionHelperList(Integer idRequisition); 
	
	public List<PostMaster> getAllDesignations(Integer postGroupId) throws Exception;

	public ValidateBifurcation saveValidateBifurcationObj(ValidateBifurcation validateBifurcationObj);

	public void saveValidateBifurcationCounts(List<ValidateBifurcationCounts> validateCountList);

	public List<RequisitionReport> getAllDepartmentRequisitions(String Group) throws Exception;

	public List<UserLogin> getAllReqRegisteredUsers() throws Exception;

	public Department getdepartmentData(Integer dEpartmentId) throws Exception;

	public List<RequisitionInfo> getAllDuplicateRecords(Integer dEpartmentId, Integer postmasterId, Integer postmasterId2) throws Exception;

	public List<SmsReceivers> getReceiversList(SmsReceivers receiverObj) throws Exception;

	public PostGroup getPostGroup(String classAndServiceOfPost)throws Exception;

	public List<RequisitionInfo> getAllDistinctGroupList() throws Exception;

	public AdvtStatusForSPE saveAdvtStatusForSpe(AdvtStatusForSPE advtStatusReq) throws Exception;

	public ExtendedPaginatedList getAllAdvtForSPE(Integer dEpartmentId, ExtendedPaginatedList paginatedListFromRequest) throws Exception ;
 

}
