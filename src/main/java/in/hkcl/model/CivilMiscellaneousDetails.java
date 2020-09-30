package in.hkcl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "civilmiscellaneousdetails")
public class CivilMiscellaneousDetails implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cmId", unique = true, nullable = false)
	private Integer cmId;
	
	@Column(name = "caseId")
	private Integer caseId;
	
	@Column(name="cmNo")
	private Integer cmNo;
	
	@Column(name="cmYear")
    private Integer cmYear;

	public Integer getCmId() {
		return cmId;
	}

	public void setCmId(Integer cmId) {
		this.cmId = cmId;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public Integer getCmNo() {
		return cmNo;
	}

	public void setCmNo(Integer cmNo) {
		this.cmNo = cmNo;
	}

	public Integer getCmYear() {
		return cmYear;
	}

	public void setCmYear(Integer cmYear) {
		this.cmYear = cmYear;
	}

	
	
	
}
