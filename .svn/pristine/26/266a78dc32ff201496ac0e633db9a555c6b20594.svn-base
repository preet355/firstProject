package in.hkcl.dao;


import java.util.List;

import org.displaytag.properties.SortOrderEnum;

import in.hkcl.model.Department;
import in.hkcl.model.DepartmentDocs;
import in.hkcl.model.DepartmentVO;
import in.hkcl.model.EmailTemplate;
import in.hkcl.model.NextStepsAdvt;
import in.hkcl.model.PasswordResetToken;
import in.hkcl.model.Police;
import in.hkcl.model.UserEditLogs;
import in.hkcl.model.UserEditLogsMIS;
import in.hkcl.model.UserHistory;
import in.hkcl.model.UserLogin;



public interface BaseDataDao {
	

	public List<Police> getAllHsscPostList() throws Exception;

	public List<Police> getAllHsscPostListForDept(Integer dEpartmentId) throws Exception;

	public List<Police> getPostDetails(Integer srNo)throws Exception;

	public List<Police> getpostNameById(String sRNo,String aDvtNo, String status, Integer dEpartmentId)throws Exception;

	public List<String> getDistinctAdvtNo(Integer dEpartmentId)throws Exception;
	
	public List<String> getDistinctNextStep(Integer dEpartmentId)throws Exception;

	public List<Police> getAllPostData(int dEpartmentId,int firstRecordIndex, int pageSize, SortOrderEnum sortDirection,
			String sortCriterion) throws Exception;

	public UserLogin loginUser(UserLogin user)throws Exception;

	UserLogin getVerifiedUser(String Email) throws Exception;

	int getTotalPostDataCount(Integer departmentId) throws Exception;

	public Department getDeptName(Integer dEpartmentId) throws Exception;

	public List<Police> getCountsForRecommended(Integer dEpartmentId) throws Exception;

	public List<Police> getCountsForcourtStay(Integer dEpartmentId)throws Exception;

	public List<Police> getCountsForinProcessCount(Integer dEpartmentId)throws Exception;

	public List<Police> getHsscDataForAdmin()throws Exception;

	public List<Police> getCountsForRecommendedForAdmin();

	public List<Police> getCountsForcourtStayForAdmin();

	public List<Police> getCountsForinProcessCountForAdmin();

	public Police updatePostDetails(Police post)throws Exception;
	
	public List<Department> loadAllDepartments() throws Exception;

	public List<Police> getAllDepartData(int firstRecordIndex, int pageSize, SortOrderEnum sortDirection,
			String sortCriterion) throws Exception;
	int getTotalDepartDataCount() throws Exception;

	public List<Police> getAllSearchedData(String mAcroStatus, int firstRecordIndex,
			int pageSize, SortOrderEnum sortDirection, String sortCriterion)throws Exception ;
	int getTotalPostStatusCount(String mAcroStatus) throws Exception;

	public List<Police> getAllHsscStatusListForDept(String mAcroStatus) throws Exception;
	
	public	void createPasswordResetToken(UserLogin user, String token)throws Exception;
	
	public PasswordResetToken getPasswordResetUser(String passwordResetToken)throws Exception;
	
	public UserLogin updateUserPassword(UserLogin user) throws Exception;
	
	public UserLogin getChangedPasswordUserData(Integer userId)throws Exception;
    
	public UserLogin saveLastPasswords(UserLogin user);
	
	public List<Police> getpostNameById(String sRNo,String aDvtNo, String status,String dEpartment, Integer dEpartmentId, String nExtStep) throws Exception;
	
	public List<Police> getAllPostData(Integer sessionDepart,Police police, int firstRecordIndex, int pageSize, SortOrderEnum sortDirection, String sortCriterion) throws Exception;
    
	public int getAllPostDataCount(Integer sessionDepart,Police police) throws Exception;
  
	public Department addNewDepartment(Department department) throws Exception; 
	
public List<DepartmentVO> getGroupedPostListForDept(Integer dEpartmentId) throws Exception;
	
	public List<DepartmentVO> getUniqueNextStep(Integer dEpartmentId) throws Exception;

	public List<DepartmentVO> getStatusCountValue(String status, Integer dEpartmentId);

	public List<String> getUniqueMacroStatusList();

	public List<Police> getHsscPostList(String dEpartmentId, String mAcroStatus, String nameOfPost, String startDate, String endDate);

	public List<Department> getDepartmentList();

	public List<String> getUniqueNameOfPostList();

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
