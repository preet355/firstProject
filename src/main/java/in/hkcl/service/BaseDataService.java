package in.hkcl.service;

import java.util.List;

import in.hkcl.model.AdvtStatusForSPE;
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



public interface BaseDataService {
		
	public List<Police> getAllHsscPostListForDept(Integer dEpartmentId)throws Exception;
	public List<Police> getAllHsscStatusListForDept(String mAcroStatus)throws Exception;
	public List<Police> getPostDetails(Integer srNo) throws Exception;
	public List<Police> getpostNameById(String sRNo, String aDvtNo, String status, Integer depId)throws Exception;
	public List<String> getDistinctAdvtNo(Integer dEpartmentId)throws Exception;
	public ExtendedPaginatedList getAllPostData(Integer dEpartmentId, ExtendedPaginatedList paginatedList) throws Exception;
	public ExtendedPaginatedList getAllPostData(Integer sessionDepart,Police police, ExtendedPaginatedList paginatedList) throws Exception;
	public List<String> getDistinctNextStep(Integer dEpartmentId)throws Exception;
	void createVerificationToken(UserLogin user, String token);
	public List<Police> getHsscDataForAdmin() throws Exception;
	public Police updatePostDetails(Police post) throws Exception;
	public List<Department> loadAllDepartments() throws Exception;
	public ExtendedPaginatedList getAllDepartData(ExtendedPaginatedList paginatedList) throws Exception;
	public ExtendedPaginatedList getAllSearchedData(String mAcroStatus,
			ExtendedPaginatedList paginatedList)throws Exception;
	
	public List<Police> getCountsForRecommendedForAdmin();
	public List<Police> getCountsForcourtStayForAdmin();
	public List<Police> getCountsForinProcessCountForAdmin();
	public Department addNewDepartment(Department department) throws Exception ;
	
	public List<DepartmentVO> getGroupedPostListForDept(Integer dEpartmentId) throws Exception;
	public List<DepartmentVO> getUniqueNextStep(Integer dEpartmentId) throws Exception;
	public List<Police> getAllHsscPostList() throws Exception;
	public List<DepartmentVO> getStatusCountValue(String status, Integer dEpartmentId);
	public List<String> getUniqueMacroStatusList();
	public List<Police> getHsscPostList(String dEpartmentId, String mAcroStatus, String nameOfPost, String startDate, String endDate);
	public List<Department> getDepartmentList();
	public List<String> getUniqueNameOfPostList();
	/*public List<CourtCaseDetails> getCourtCasebySNo(Integer getsRNo) throws Exception;*/
	public List<DepartmentVO> getAllRequisitionData(Integer sessionDepart, Police searcPolice) throws Exception;
	public void savePathForDepartmentDocs(DepartmentDocs deptObj) throws Exception;
	public EmailTemplate getemailTemplateCode(String emailtype) throws Exception;
	public List<UserEditLogs> getLastUpdateTime() throws Exception;
	public List<UserEditLogsMIS> getMISLastUpdateTime() throws Exception;
	public UserLogin saveUserInfo(UserLogin userObj) throws Exception;
	public UserLogin getVerifiedUserByDeptId(Integer idDept) throws Exception;
	public void saveLoginHistory(UserHistory userHisObj) throws Exception;
	public void saveLogOutHistory(UserHistory userHisObj) throws Exception;
	public List<Police> getAllDistinctPostName() throws Exception;
	public List<NextStepsAdvt> getAllNextSteps() throws Exception;
	public Department getdepartmentByDepartmentId(Integer idDept) throws Exception;
	
}
