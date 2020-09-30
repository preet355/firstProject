package in.hkcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.hkcl.dao.BaseDataDao;
import in.hkcl.model.Department;
import in.hkcl.model.DepartmentDocs;
import in.hkcl.model.DepartmentVO;
import in.hkcl.model.EmailTemplate;
import in.hkcl.model.NextStepsAdvt;
import in.hkcl.model.Police;
import in.hkcl.model.UserEditLogs;
import in.hkcl.model.UserEditLogsMIS;
import in.hkcl.model.UserHistory;
import in.hkcl.model.UserLogin;
import in.hkcl.pagination.ExtendedPaginatedList;

@Repository("baseDataService")
@Transactional
public class BaseDataServiceImpl implements BaseDataService {

	@Autowired
	BaseDataDao baseDataDao;

	@Override
	public List<Police> getAllHsscPostListForDept(Integer dEpartmentId) throws Exception {

		return baseDataDao.getAllHsscPostListForDept(dEpartmentId);
	}

	public List<String> getDistinctNextStep(Integer dEpartmentId)throws Exception{
		return baseDataDao.getDistinctNextStep(dEpartmentId);
	}
	
	@Override
	public List<Police> getPostDetails(Integer srNo) throws Exception {

		return baseDataDao.getPostDetails(srNo);
	}

	@Override
	public List<Police> getpostNameById(String sRNo, String aDvtNo, String status, Integer dEpartmentId)
			throws Exception {

		return baseDataDao.getpostNameById(sRNo, aDvtNo, status, dEpartmentId);
	}

	@Override
	public List<String> getDistinctAdvtNo(Integer dEpartmentId) throws Exception {

		return baseDataDao.getDistinctAdvtNo(dEpartmentId);
	}

	@Override
	public ExtendedPaginatedList getAllPostData(Integer dEpartmentId, ExtendedPaginatedList paginatedList)
			throws Exception {
		List<Police> objList = baseDataDao.getAllPostData(dEpartmentId, paginatedList.getFirstRecordIndex(),
				paginatedList.getPageSize(), paginatedList.getSortDirection(), paginatedList.getSortCriterion());
		if (objList != null) {
			paginatedList.setList(objList);
			paginatedList.setTotalNumberOfRows(baseDataDao.getTotalPostDataCount(dEpartmentId));
			return paginatedList;
		} else {
			return null;
		}
	}

	public ExtendedPaginatedList getAllDepartData(ExtendedPaginatedList paginatedList) throws Exception {
		List<Police> objList = baseDataDao.getAllDepartData(paginatedList.getFirstRecordIndex(),
				paginatedList.getPageSize(), paginatedList.getSortDirection(), paginatedList.getSortCriterion());
		if (objList != null) {
			paginatedList.setList(objList);
			paginatedList.setTotalNumberOfRows(baseDataDao.getTotalDepartDataCount());
			return paginatedList;
		} else {
			return null;
		}
	}

	public ExtendedPaginatedList getAllSearchedData(String mAcroStatus, ExtendedPaginatedList paginatedList)
			throws Exception {
		List<Police> objList = baseDataDao.getAllSearchedData(mAcroStatus, paginatedList.getFirstRecordIndex(),
				paginatedList.getPageSize(), paginatedList.getSortDirection(), paginatedList.getSortCriterion());
		if (objList != null) {
			paginatedList.setList(objList);
			paginatedList.setTotalNumberOfRows(baseDataDao.getTotalPostStatusCount(mAcroStatus));
			return paginatedList;
		} else {
			return null;
		}
	}

	@Override
	public void createVerificationToken(UserLogin user, String token) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Police> getHsscDataForAdmin() throws Exception {
		return baseDataDao.getHsscDataForAdmin();
	}

	@Override
	public Police updatePostDetails(Police post) throws Exception {

		return baseDataDao.updatePostDetails(post);
	}

	@Override
	public List<Department> loadAllDepartments() throws Exception {

		return baseDataDao.loadAllDepartments();
	}

	@Override
	public List<Police> getAllHsscStatusListForDept(String mAcroStatus) throws Exception {

		return baseDataDao.getAllHsscStatusListForDept(mAcroStatus);
	}

	public ExtendedPaginatedList getAllPostData(Integer sessionDepart,Police police, ExtendedPaginatedList paginatedList) throws Exception {
		List<Police> searchList = baseDataDao.getAllPostData(sessionDepart,police, paginatedList.getFirstRecordIndex(), paginatedList.getPageSize(),
				paginatedList.getSortDirection(), paginatedList.getSortCriterion());
		if (searchList != null) {
			paginatedList.setList(searchList);
			paginatedList.setTotalNumberOfRows(baseDataDao.getAllPostDataCount(sessionDepart,police));
			return paginatedList;
		} else {
			return null;
		}
		
	}

	@Override
	public List<Police> getCountsForRecommendedForAdmin() {
		return baseDataDao.getCountsForRecommendedForAdmin();
	}

	public List<Police> getCountsForcourtStayForAdmin(){
		return baseDataDao.getCountsForcourtStayForAdmin();
	}
	
	public List<Police> getCountsForinProcessCountForAdmin(){
		return baseDataDao.getCountsForinProcessCountForAdmin();
	}

	@Override
	public Department addNewDepartment(Department department) throws Exception {
		
		return baseDataDao.addNewDepartment(department);
	}
	public List<DepartmentVO> getGroupedPostListForDept(Integer dEpartmentId) throws Exception{
		return baseDataDao.getGroupedPostListForDept(dEpartmentId);
	}
	
	public List<DepartmentVO> getUniqueNextStep(Integer dEpartmentId) throws Exception{
		return baseDataDao.getUniqueNextStep(dEpartmentId);
	}

	@Override
	public List<Police> getAllHsscPostList() throws Exception {
		// TODO Auto-generated method stub
		return baseDataDao.getAllHsscPostList();
	}

	@Override
	public List<DepartmentVO> getStatusCountValue(String status, Integer dEpartmentId) {
		// TODO Auto-generated method stub
		return baseDataDao.getStatusCountValue(status,dEpartmentId);
	}

	@Override
	public List<String> getUniqueMacroStatusList() {
		
		return baseDataDao.getUniqueMacroStatusList();
	}

	@Override
	public List<Police> getHsscPostList(String dEpartmentId, String mAcroStatus, String nameOfPost,String startDate,String endDate) {
		
		return baseDataDao.getHsscPostList(dEpartmentId,mAcroStatus, nameOfPost,startDate,endDate);
	}

	@Override
	public List<Department> getDepartmentList() {
		
		return baseDataDao.getDepartmentList();
	}

	@Override
	public List<String> getUniqueNameOfPostList() {
		
		return baseDataDao.getUniqueNameOfPostList();
	}

	public List<DepartmentVO> getAllRequisitionData(Integer sessionDepart, Police searcPolice) throws Exception {
		return baseDataDao.getAllRequisitionData(sessionDepart,searcPolice);
	}

	@Override
	public void savePathForDepartmentDocs(DepartmentDocs deptObj) throws Exception {
		baseDataDao.savePathForDepartmentDocs(deptObj);
	}

	@Override
	public EmailTemplate getemailTemplateCode(String emailtype) throws Exception {
		// TODO Auto-generated method stub
		return baseDataDao.getemailTemplateCode(emailtype);
	}

	@Override
	public List<UserEditLogs> getLastUpdateTime() throws Exception {
		// TODO Auto-generated method stub
		return baseDataDao.getLastUpdateTime();
	}

	@Override
	public List<UserEditLogsMIS> getMISLastUpdateTime() throws Exception {
		// TODO Auto-generated method stub
		return baseDataDao.getMISLastUpdateTime();
	}

	@Override
	public UserLogin saveUserInfo(UserLogin userObj) throws Exception {
		// TODO Auto-generated method stub
		return baseDataDao.saveUserInfo(userObj);
	}


	public UserLogin getVerifiedUserByDeptId(Integer idDept) throws Exception{
		return baseDataDao.getVerifiedUserByDeptId(idDept);
	}

	@Override
	public void saveLoginHistory(UserHistory userHisObj) throws Exception {
		// TODO Auto-generated method stub
		baseDataDao.saveLoginHistory(userHisObj);
	}

	@Override
	public void saveLogOutHistory(UserHistory userHisObj) throws Exception {
		// TODO Auto-generated method stub
		baseDataDao.saveLogOutHistory(userHisObj);
	}

	@Override
	public List<Police> getAllDistinctPostName() throws Exception {
		// TODO Auto-generated method stub
		return baseDataDao.getAllDistinctPostName();
	}

	@Override
	public List<NextStepsAdvt> getAllNextSteps() throws Exception {
		
		return baseDataDao.getAllNextSteps();
	}

	@Override
	public Department getdepartmentByDepartmentId(Integer idDept) throws Exception {
		// TODO Auto-generated method stub
		return baseDataDao.getdepartmentByDepartmentId(idDept);
	}

	
}
