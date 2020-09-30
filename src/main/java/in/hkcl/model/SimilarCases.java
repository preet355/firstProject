package in.hkcl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "similarCases")
public class SimilarCases implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "similarCaseId", unique = true, nullable = false)	
	private Integer similarCaseId;
	
	@Column(name = "caseId")
	private Integer caseId;
	
	@Column(name = "year")
	private String year;
	
	@Column(name = "similarCaseType")
	private String similarCaseType;
	
	@Column(name = "caseNo")
	private Integer caseNo;

	public Integer getSimilarCaseId() {
		return similarCaseId;
	}

	public void setSimilarCaseId(Integer similarCaseId) {
		this.similarCaseId = similarCaseId;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	
	public String getSimilarCaseType() {
		return similarCaseType;
	}

	public void setSimilarCaseType(String similarCaseType) {
		this.similarCaseType = similarCaseType;
	}

	public Integer getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(Integer caseNo) {
		this.caseNo = caseNo;
	}
	
	

}
