package in.hkcl.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import in.hkcl.model.CourtCaseDetails;
import in.hkcl.model.DepartmentVO;
import in.hkcl.model.DepartmentWiseCountHelper;
import in.hkcl.model.District;
import in.hkcl.model.HearingDateGraphHelper;
import in.hkcl.model.HearingDetails;
import in.hkcl.model.ImpactGraphHelper;
import in.hkcl.model.YearWiseCountHelper;
import in.hkcl.pagination.ExtendedPaginatedList;

public interface CourtCaseService {
	
	public List<CourtCaseDetails> getCaseDetails(Integer srNo) throws Exception;
	
	public List<CourtCaseDetails> getAllHsscCourtCasesForDept() throws Exception;
	
	public List<String> getAllHsscPetitionerNames() throws Exception;
	
	public CourtCaseDetails updateCourtCaseDetails(CourtCaseDetails courtCase);
	
	public ExtendedPaginatedList getAllCourtCaseData(CourtCaseDetails courtCaseDetailsObj, ExtendedPaginatedList paginatedList) throws Exception;

	public List<CourtCaseDetails> getAllCourtCasesDataForDropDown();

	public List<CourtCaseDetails> editCourtCaseDetails(Integer caseId) throws Exception;

	public List<CourtCaseDetails> getAllCourtCaseDataListForCount() throws Exception;
	
	public List<String> getdistinctWritNoList();

	public List<String> getdistinctCaseStatusList();

	public List<String> getdistinctCaseTypeList();

	public List<String> getdistinctYearList();

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
