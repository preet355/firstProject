package in.hkcl.dao;

import java.util.Date;
import java.util.List;

import javax.management.Notification;

import org.displaytag.properties.SortOrderEnum;

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
import in.hkcl.model.SmsReceivers;
import in.hkcl.model.UserLogin;
import in.hkcl.model.ValidateBifurcation;
import in.hkcl.model.ValidateBifurcationCounts;


public interface RequisitionDao {

	public RequisitionInfo saveRequisitionForm(RequisitionInfo reqObj) throws Exception;

	public List<RequisitionInfo> getAllRegisteredRequisitions(Integer dEpartmentId, int firstRecordIndex, int pageSize,
			SortOrderEnum sortDirection, String sortCriterion, String status,RequisitionInfo reqObj) throws Exception;

	public int getAllRegisteredRequisitionsCount(Integer dEpartmentId, String status, RequisitionInfo reqObj) throws Exception;

	public List<RequisitionInfo> getRequisitionFormByRequisitionId(Integer idRequisition) throws Exception;

	public HsscConfig getHSSCConfig() throws Exception;

	public int getvalueAfterSeatBifurcation(int prevRosterPoint, int num, String category, String subCategory);

	public List<BifurcationHelper> getBifuractionHelperList(Integer idRequisition);

	public RequisitionInfo updateRequisition(RequisitionInfo reqObj) throws Exception;

	public List<RequisitionInfo> getAllRequisitionsRequests(int firstRecordIndex, int pageSize,
			SortOrderEnum sortDirection, String sortCriterion) throws Exception;

	public int getAllRequisitionsRequestsCount() throws Exception;
	
	public void savePathObjectByIdRequisition(RequisitionDocs docsObj);

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

	public List<RequisitionInfo> getRequisitionListByIdRequisition(Integer idRequisition, int firstRecordIndex,
			int pageSize, SortOrderEnum sortDirection, String sortCriterion) throws Exception;

	public int getRequisitionListByIdRequisition(Integer idRequisition) throws Exception;

	public void updateNotificationStatus(Integer notificationId) throws Exception;

	public List<BifurcationHelper> getSecondBifuractionHelperList(Integer idRequisition);
	
	public List<PostMaster> getAllDesignations(Integer postGroupId) throws Exception ;

	public ValidateBifurcation saveValidateBifurcationObj(ValidateBifurcation validateBifurcationObj);

	public void saveValidateBifurcationCounts(List<ValidateBifurcationCounts> validateCountList);

	public List<RequisitionReport> getAllDepartmentRequisitions(String group) throws Exception;

	public List<UserLogin> getAllReqRegisteredUsers() throws Exception;

	public Department getdepartmentData(Integer dEpartmentId) throws Exception;

	public List<RequisitionInfo> getAllDuplicateRecords(Integer dEpartmentId, Integer postmasterId, Integer postmasterId2) throws Exception;

	public List<SmsReceivers> getReceiversList(SmsReceivers receiverObj) throws Exception;

	public PostGroup getPostGroup(String classAndServiceOfPost) throws Exception;

	public List<RequisitionInfo> getAllDistinctGroupList() throws Exception;

	public AdvtStatusForSPE saveAdvtStatusForSpe(AdvtStatusForSPE advtStatusReq) throws Exception;

	public List<AdvtStatusForSPE> getAllAdvtForSPE(Integer dEpartmentId, int firstRecordIndex, int pageSize,
			SortOrderEnum sortDirection, String sortCriterion) throws Exception;

	public int getAllAdvtForSPECount(Integer dEpartmentId) throws Exception;


}
