package in.hkcl.dao;

import java.util.List;

import org.displaytag.properties.SortOrderEnum;

import in.hkcl.model.ExamCenterAllocation;
import in.hkcl.model.ExamCenterDetails;
import in.hkcl.model.ExamDetails;
import in.hkcl.model.ExamInvigilatorsDetails;
import in.hkcl.model.ZoneDistrictMapping;

public interface ExamCenterDao {

	public List<ExamCenterDetails> getExamCentersList(Integer examId) throws Exception;

	public List<ExamInvigilatorsDetails> getInvigilatorsList(Integer examId) throws Exception;

	public List<ZoneDistrictMapping> getZoneDistrictMapping() throws Exception;

	public void saveExamCenterAllocation(ExamCenterAllocation value) throws Exception;

	public ZoneDistrictMapping getZoneID(Integer idDistrict) throws Exception;

	public List<ExamDetails> getAllExams(int firstRecordIndex, int pageSize, SortOrderEnum sortDirection,
			String sortCriterion) throws Exception;

	public int getAllExamsCount() throws Exception;

	public void deleteExamCenterAllocation(Integer examId) throws Exception;

	public int getAllocationCount(int examId) throws Exception;

	public List<ExamCenterAllocation> getAllocationList(int examId)  throws Exception;

	public ExamDetails getCenterAllotmentData(int examId) throws Exception;


}
