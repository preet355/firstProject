package in.hkcl.service;

import java.util.List;

import in.hkcl.model.ExamCenterAllocation;
import in.hkcl.model.ExamCenterDetails;
import in.hkcl.model.ExamDetails;
import in.hkcl.model.ExamInvigilatorsDetails;
import in.hkcl.pagination.ExtendedPaginatedList;

public interface ExamDataService {
	
	public String AllocateInvigilators(Integer ExamId) throws Exception;

	public ExtendedPaginatedList getAllExams(ExtendedPaginatedList paginatedListFromRequest) throws Exception;

	public List<ExamCenterDetails> getExamCenterList(int examId) throws Exception;

	public List<ExamInvigilatorsDetails> getInvigilatorsList(int examId)throws Exception;

	public int getAllocationCount(int examId) throws Exception;

	public List<ExamCenterAllocation> getAllocationList(int examId) throws Exception;

	public ExamDetails getCenterAllotmentData(int examId) throws Exception;

}
