package in.hkcl.dao;

import java.util.Date;
import java.util.List;

import org.displaytag.properties.SortOrderEnum;

import in.hkcl.model.CourtCaseDetails;
import in.hkcl.model.DepartmentVO;
import in.hkcl.model.DepartmentWiseCountHelper;
import in.hkcl.model.District;
import in.hkcl.model.HearingDateGraphHelper;
import in.hkcl.model.HearingDetails;
import in.hkcl.model.ImpactGraphHelper;
import in.hkcl.model.YearWiseCountHelper;

public interface CourtCaseDao {
	
	public List<CourtCaseDetails> getAllCourtCaseDataListForCount() throws Exception;

	public List<CourtCaseDetails> getCaseDetails(Integer srNo) throws Exception;

	public List<CourtCaseDetails> getAllHsscCourtCasesForDept();

	public List<String> getAllHsscPetitionerNames();
	
	public CourtCaseDetails updateCourtCaseDetails(CourtCaseDetails courtCase);
	
	public List<CourtCaseDetails> getAllCourtCaseData(CourtCaseDetails courtCaseDetailsObj, int firstRecordIndex, int pageSize, SortOrderEnum sortDirection,
			String sortCriterion) throws Exception;

	public int getAllCourtCaseDataCount(CourtCaseDetails courtCaseDetailsObj);

	public List<CourtCaseDetails> getAllCourtCasesDataForDropDown();

	public List<CourtCaseDetails> editCourtCaseDetails(Integer caseId);
	
	public List<String> getdistinctYearList();
	
	public List<String> getdistinctCaseTypeList();
	
	public List<String> getdistinctCaseStatusList();
	
	public List<String> getdistinctWritNoList();
	
	public List<CourtCaseDetails> getAllWritNo();

	public List<District> getAllDistrict();

	public List<Date> getHearingDetailsUniqueDateList();

	public void updateMacroStatusinMis(Integer sRNo, String macro);

	public List<String> getUniqueYearList();

	public List<YearWiseCountHelper> getyearWiseCountList(List<String> uniqueYearList, String deptId, String nameOfPost, String caseStatus);

	public List<DepartmentWiseCountHelper> getdeptWiseCount(String year, String legalIssue);

	public List<String> getUniqueStatusList();

	public List<String> getUniqueLegalIssuesList();

	public List<ImpactGraphHelper> getImpactGraphCount(String advtNo, String cAtNo, String departId, String caseStatusForImpact);

	public List<String> getUniqueAdvtList();

	public List<String> getuniqueCatNoList();

	public List<ImpactGraphHelper> getImpactGraphLegalIssueCount(String year, String departIdForLegal);

	public List<HearingDateGraphHelper> getHearingDateGraphData(String deptIdForHearingGraph, String nameOfPostForHearingGraph);

	public List<DepartmentVO> getUniqueAdvtWithCasesList() throws Exception;

	public List<HearingDetails> getAllHearingDates(Date yesterdayDate) throws Exception;

	public CourtCaseDetails getCourtCaseByCaseId(Integer caseId) throws Exception;

	/*public List<HearingDetails> getAllHearingDatesByCaseId(Integer caseId) throws Exception;*/

	
}
