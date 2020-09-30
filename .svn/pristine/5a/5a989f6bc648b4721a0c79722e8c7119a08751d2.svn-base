package in.hkcl.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.hkcl.dao.CourtCaseDao;
import in.hkcl.model.CourtCaseDetails;
import in.hkcl.model.DepartmentVO;
import in.hkcl.model.DepartmentWiseCountHelper;
import in.hkcl.model.District;
import in.hkcl.model.HearingDateGraphHelper;
import in.hkcl.model.HearingDetails;
import in.hkcl.model.ImpactGraphHelper;
import in.hkcl.model.YearWiseCountHelper;
import in.hkcl.pagination.ExtendedPaginatedList;
import in.hkcl.utils.CommonUtils;
import in.hkcl.utils.DateFormatterUtility;

@Repository("courtCaseService")
@Transactional
public  class CourtCaseServiceImpl implements CourtCaseService{
	
	@Autowired
	CourtCaseDao courtCaseDao;

	@Override
	public List<CourtCaseDetails> getCaseDetails(Integer srNo) throws Exception {
		return courtCaseDao.getCaseDetails(srNo);
	}

	@Override
	public List<CourtCaseDetails> getAllHsscCourtCasesForDept() throws Exception {
	
		return courtCaseDao.getAllHsscCourtCasesForDept();
	}

	@Override
	public List<String> getAllHsscPetitionerNames() throws Exception {

		return courtCaseDao.getAllHsscPetitionerNames();
	}

	@Override
	public CourtCaseDetails updateCourtCaseDetails(CourtCaseDetails courtCase) {

		return courtCaseDao.updateCourtCaseDetails(courtCase);
	}

	@Override
	public ExtendedPaginatedList getAllCourtCaseData(CourtCaseDetails courtCaseDetailsObj,
			ExtendedPaginatedList paginatedList) throws Exception {
		List<CourtCaseDetails> searchList = courtCaseDao.getAllCourtCaseData(courtCaseDetailsObj,
				paginatedList.getFirstRecordIndex(), paginatedList.getPageSize(), paginatedList.getSortDirection(),
				paginatedList.getSortCriterion());
		if (searchList != null) {
			if (CommonUtils.isNotEmpty(courtCaseDetailsObj.getDateList())) {
				List<CourtCaseDetails> indexList1=new ArrayList<CourtCaseDetails>();
				for (CourtCaseDetails courtCaseDetails : searchList) {
					Date dt = DateFormatterUtility.stringtoDateConversion(courtCaseDetailsObj.getDateList(),
							DateFormatterUtility.FORMAT_PATTERN_16);
					Date courtCaseDt = DateFormatterUtility.stringtoDateConversion(courtCaseDetails.getDateList(),
							DateFormatterUtility.FORMAT_PATTERN_16);
					if (courtCaseDt.compareTo(dt) != 0) {
						indexList1.add(courtCaseDetails);
					}
				}
				if (CommonUtils.isNotEmpty(indexList1)) {
					
					searchList.removeAll(indexList1);
				}
			}
			paginatedList.setList(searchList);
			paginatedList.setTotalNumberOfRows(courtCaseDao.getAllCourtCaseDataCount(courtCaseDetailsObj));
			return paginatedList;
		} else {
			return null;
		}
	}

	@Override
	public List<CourtCaseDetails> getAllCourtCasesDataForDropDown() {

		return courtCaseDao.getAllCourtCasesDataForDropDown();
	}

	@Override
	public List<CourtCaseDetails> editCourtCaseDetails(Integer caseId) throws Exception {

		return courtCaseDao.editCourtCaseDetails(caseId);
	}

	@Override
	public List<CourtCaseDetails> getAllCourtCaseDataListForCount() throws Exception {

		return courtCaseDao.getAllCourtCaseDataListForCount();
	}

	@Override
	public List<String> getdistinctWritNoList() {

		return courtCaseDao.getdistinctWritNoList();
	}

	@Override
	public List<String> getdistinctCaseStatusList() {
		// TODO Auto-generated method stub
		return courtCaseDao.getdistinctCaseStatusList();
	}

	@Override
	public List<String> getdistinctCaseTypeList() {
		// TODO Auto-generated method stub
		return courtCaseDao.getdistinctCaseTypeList();
	}

	@Override
	public List<String> getdistinctYearList() {
		// TODO Auto-generated method stub
		return courtCaseDao.getdistinctYearList();
	}

	@Override
	public List<District> getAllDistrict() {

		return courtCaseDao.getAllDistrict();
	}

	@Override
	public List<Date> getHearingDetailsUniqueDateList() {

		return courtCaseDao.getHearingDetailsUniqueDateList();
	}

	@Override
	public void updateMacroStatusinMis(Integer sRNo, String macro) {
		courtCaseDao.updateMacroStatusinMis(sRNo, macro);

	}

	@Override
	public List<String> getUniqueYearList() {
		return courtCaseDao.getUniqueYearList();
	}

	@Override
	public List<YearWiseCountHelper> getyearWiseCountList(List<String> uniqueYearList,String deptId,String nameOfPost,String caseStatus) {
		
		return courtCaseDao.getyearWiseCountList(uniqueYearList,deptId,nameOfPost,caseStatus);
	}

	@Override
	public List<DepartmentWiseCountHelper> getdeptWiseCount(String year,String legalIssue) {
		
		return courtCaseDao.getdeptWiseCount(year,legalIssue);
	}

	@Override
	public List<String> getUniqueStatusList() {
		
		return courtCaseDao.getUniqueStatusList();
	}

	@Override
	public List<String> getUniqueLegalIssuesList() {
		
		return courtCaseDao.getUniqueLegalIssuesList();
	}

	@Override
	public List<ImpactGraphHelper> getImpactGraphCount(String advtNo, String cAtNo, String departId, String caseStatusForImpact) {
		return courtCaseDao.getImpactGraphCount(advtNo,cAtNo,departId,caseStatusForImpact);
	}
	
	public List<ImpactGraphHelper> getImpactGraphLegalIssueCount(String year, String departIdForLegal){
		return courtCaseDao.getImpactGraphLegalIssueCount(year,departIdForLegal);
	}

	@Override
	public List<String> getUniqueAdvtList() {
		
		return courtCaseDao.getUniqueAdvtList();
	}

	@Override
	public List<String> getuniqueCatNoList() {
		
		return courtCaseDao.getuniqueCatNoList();
	}

	@Override
	public List<HearingDateGraphHelper> getHearingDateGraphData(String deptIdForHearingGraph, String nameOfPostForHearingGraph) {
		
		return courtCaseDao.getHearingDateGraphData(deptIdForHearingGraph,nameOfPostForHearingGraph);
	}
	
	public List<DepartmentVO> getUniqueAdvtWithCasesList() throws Exception{
		
		return courtCaseDao.getUniqueAdvtWithCasesList();
	}

	@Override
	public List<HearingDetails> getAllHearingDates(Date yesterdayDate) throws Exception {
		// TODO Auto-generated method stub
		return courtCaseDao.getAllHearingDates(yesterdayDate);
	}

	@Override
	public CourtCaseDetails getCourtCaseByCaseId(Integer caseId) throws Exception {
		// TODO Auto-generated method stub
		return courtCaseDao.getCourtCaseByCaseId(caseId);
	}

	/*@Override
	public List<HearingDetails> getAllHearingDatesByCaseId(Integer caseId) throws Exception {
		
		return courtCaseDao.getAllHearingDatesByCaseId(caseId);
	}*/
	

}
