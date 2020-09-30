package in.hkcl.service;

import java.util.Date;
import java.util.List;

import javax.management.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.hkcl.dao.RequisitionDao;
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

@Repository("requisitionService")
public class RequisitionServiceImpl implements RequisitionService {

	@Autowired
	RequisitionDao requisitiondao;

	@Override
	public RequisitionInfo saveRequisitionForm(RequisitionInfo reqObj) throws Exception {

		return requisitiondao.saveRequisitionForm(reqObj);
	}

	@Override
	public ExtendedPaginatedList getAllRegisteredRequisitions(Integer dEpartmentId,
			ExtendedPaginatedList paginatedListFromRequest, String status, RequisitionInfo reqObj) throws Exception {
		List<RequisitionInfo> list = requisitiondao.getAllRegisteredRequisitions(dEpartmentId,
				paginatedListFromRequest.getFirstRecordIndex(), paginatedListFromRequest.getPageSize(),
				paginatedListFromRequest.getSortDirection(), paginatedListFromRequest.getSortCriterion(), status,reqObj);
		paginatedListFromRequest.setList(list);
		paginatedListFromRequest.setTotalNumberOfRows(requisitiondao.getAllRegisteredRequisitionsCount(dEpartmentId, status,reqObj));
		return paginatedListFromRequest;
	}
	
	@Override
	public ExtendedPaginatedList getRequisitionListByIdRequisition(Integer idRequisition,
			ExtendedPaginatedList paginatedListFromRequest) throws Exception {
		List<RequisitionInfo> list = requisitiondao.getRequisitionListByIdRequisition(idRequisition,
				paginatedListFromRequest.getFirstRecordIndex(), paginatedListFromRequest.getPageSize(),
				paginatedListFromRequest.getSortDirection(), paginatedListFromRequest.getSortCriterion());
		paginatedListFromRequest.setList(list);
		paginatedListFromRequest.setTotalNumberOfRows(requisitiondao.getRequisitionListByIdRequisition(idRequisition));
		return paginatedListFromRequest;
	}
	
	@Override
	public ExtendedPaginatedList getAllRequisitionsRequests(ExtendedPaginatedList paginatedListFromRequest)
			throws Exception {
		List<RequisitionInfo> list = requisitiondao.getAllRequisitionsRequests(
				paginatedListFromRequest.getFirstRecordIndex(), paginatedListFromRequest.getPageSize(),
				paginatedListFromRequest.getSortDirection(), paginatedListFromRequest.getSortCriterion());
		paginatedListFromRequest.setList(list);
		paginatedListFromRequest.setTotalNumberOfRows(requisitiondao.getAllRequisitionsRequestsCount());
		return paginatedListFromRequest;
	}

	@Override
	public List<RequisitionInfo> getRequisitionFormByRequisitionId(Integer idRequisition) throws Exception {
		
		return requisitiondao.getRequisitionFormByRequisitionId(idRequisition);
	}

/*	@Override
	public int getvalueAfterSeatBifurcation(int num, String category, String subCategory) throws Exception {
		
		return requisitiondao.getvalueAfterSeatBifurcation(num,category, subCategory);
	}*/

	@Override
	public HsscConfig getHSSCConfig() throws Exception {
		
		return requisitiondao.getHSSCConfig();
	}

	@Override
	public RequisitionInfo updateRequisition(RequisitionInfo reqObj) throws Exception {
		
		return requisitiondao.updateRequisition(reqObj);
	}
	@Override
	public List<BifurcationHelper> getBifuractionHelperList(Integer idRequisition) {
		return requisitiondao.getBifuractionHelperList(idRequisition);
	}
	
	

	@Override
	public void savePathObjectByIdRequisition(RequisitionDocs docsObj) {
		 requisitiondao.savePathObjectByIdRequisition(docsObj);
		
	}

	@Override
	public void updateRequisitionStatus(RequisitionInfo reqObj) {
		requisitiondao.updateRequisitionStatus(reqObj);
		
	}

	@Override
	public List<RequisitionDocs> getDocsByRequisitionId(Integer idRequisition) throws Exception {
		
		return requisitiondao.getDocsByRequisitionId(idRequisition);
	}

	@Override
	public List<BifurcationHelper> getBifucatedValues(String noOfPosts, String prevRosterPoint) throws Exception {
		// TODO Auto-generated method stub
		return requisitiondao.getBifucatedValues(noOfPosts, prevRosterPoint);
	}

	@Override
	public List<RequisitionInfo> getAllRequisitioData(Integer dEpartmentId) throws Exception {
		
		return requisitiondao.getAllRequisitioData(dEpartmentId);
	}

	@Override
	public List<RequisitionInfo> getAllDistinctStatusList() throws Exception {
		
		return requisitiondao.getAllDistinctStatusList();
	}

	@Override
	public RequisitionInfoRemarks saveRequisitionsRemark(RequisitionInfoRemarks reqRemarkObj) throws Exception {
		// TODO Auto-generated method stub
		return requisitiondao.saveRequisitionsRemark(reqRemarkObj);
	}

	@Override
	public RequisitionInfoRemarks getRequisitionRemarksInfoByIdRequisition(Integer idRequisition) throws Exception {
		// TODO Auto-generated method stub
		return requisitiondao.getRequisitionRemarksInfoByIdRequisition(idRequisition);
	}

	@Override
	public Notifications saveNotificaton(Notifications notifyObj) throws Exception {
		// TODO Auto-generated method stub
		return requisitiondao.saveNotificaton(notifyObj);
	}

	@Override
	public List<Notifications> getAllNotificationsByDepartment(Integer dEpartmentId) throws Exception {
		// TODO Auto-generated method stub
		return requisitiondao.getAllNotificationsByDepartment(dEpartmentId);
	}

	@Override
	public Notifications getAllNotificationsByGeneratedTime(Date date) throws Exception {
		// TODO Auto-generated method stub
		return requisitiondao.getAllNotificationsByGeneratedTime(date);
	}

	@Override
	public void updateNotificationStatus(Integer notificationId) throws Exception {
		// TODO Auto-generated method stub
		requisitiondao.updateNotificationStatus(notificationId);
	}

	public List<BifurcationHelper> getSecondBifuractionHelperList(Integer idRequisition){
		return requisitiondao.getSecondBifuractionHelperList(idRequisition);
	}

	public List<PostMaster> getAllDesignations(Integer postGroupId) throws Exception {
		return requisitiondao.getAllDesignations(postGroupId);
	}

	@Override
	public ValidateBifurcation saveValidateBifurcationObj(ValidateBifurcation validateBifurcationObj) {
		return requisitiondao.saveValidateBifurcationObj(validateBifurcationObj);
		
	}

	@Override
	public void saveValidateBifurcationCounts(List<ValidateBifurcationCounts> validateCountList) {
	requisitiondao.saveValidateBifurcationCounts(validateCountList);
		
	}

	@Override
	public List<RequisitionReport> getAllDepartmentRequisitions(String group) throws Exception {
		
		return requisitiondao.getAllDepartmentRequisitions(group);
	}

	@Override
	public List<UserLogin> getAllReqRegisteredUsers() throws Exception {
		
		return requisitiondao.getAllReqRegisteredUsers();
	}

	@Override
	public Department getdepartmentData(Integer dEpartmentId) throws Exception {
		// TODO Auto-generated method stub
		return requisitiondao.getdepartmentData(dEpartmentId);
	}

	@Override
	public List<RequisitionInfo> getAllDuplicateRecords(Integer dEpartmentId, Integer postmasterId ,Integer postmasterId2) throws Exception {
		
		return requisitiondao.getAllDuplicateRecords(dEpartmentId,postmasterId,postmasterId2);
	}
	
	public List<SmsReceivers> getReceiversList(SmsReceivers receiverObj) throws Exception{
		return requisitiondao.getReceiversList(receiverObj);
	}

	@Override
	public PostGroup getPostGroup(String classAndServiceOfPost) throws Exception{
		// TODO Auto-generated method stub
		return requisitiondao.getPostGroup(classAndServiceOfPost);
	}

	@Override
	public List<RequisitionInfo> getAllDistinctGroupList() throws Exception {
		
		return requisitiondao.getAllDistinctGroupList();
	}

	@Override
	public AdvtStatusForSPE saveAdvtStatusForSpe(AdvtStatusForSPE advtStatusReq) throws Exception {
		// TODO Auto-generated method stub
		return requisitiondao.saveAdvtStatusForSpe(advtStatusReq);
	}

	@Override
	public ExtendedPaginatedList getAllAdvtForSPE(Integer dEpartmentId, ExtendedPaginatedList paginatedListFromRequest)
			throws Exception {
		List<AdvtStatusForSPE> list = requisitiondao.getAllAdvtForSPE(dEpartmentId,
				paginatedListFromRequest.getFirstRecordIndex(), paginatedListFromRequest.getPageSize(),
				paginatedListFromRequest.getSortDirection(), paginatedListFromRequest.getSortCriterion());
		paginatedListFromRequest.setList(list);
		paginatedListFromRequest.setTotalNumberOfRows(requisitiondao.getAllAdvtForSPECount(dEpartmentId));
		return paginatedListFromRequest;
	}

}
