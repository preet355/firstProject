package in.hkcl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "examcenterallocation")
public class ExamCenterAllocation implements Serializable{
	
	private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idAllocation", unique = true, nullable = false)
	private Integer idAllocation;
	
	@Column(name = "examId")
	private Integer examId;
	
	@Column(name = "allotedExamCenterName")
	private String allotedExamCenterName;
	
	@Column(name = "allotedExamCenterDistrict")
	private String allotedExamCenterDistrict;
	
	@Column(name = "allotedZoneName")
	private String allotedZoneName;
	
	@Column(name = "invigilatorDistrict")
	private String invigilatorDistrict;
	
	@Column(name = "invigilatorZone")
	private String invigilatorZone;
	
	@Column(name = "invigilatorName")
	private String invigilatorName;
	
	@Column(name = "uniqueExamCenterCode")
	private String uniqueExamCenterCode;
	
	@Column(name = "uniqueInvigilatorCode")
	private String uniqueInvigilatorCode;

	public Integer getIdAllocation() {
		return idAllocation;
	}

	public void setIdAllocation(Integer idAllocation) {
		this.idAllocation = idAllocation;
	}

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public String getAllotedExamCenterName() {
		return allotedExamCenterName;
	}

	public void setAllotedExamCenterName(String allotedExamCenterName) {
		this.allotedExamCenterName = allotedExamCenterName;
	}

	public String getAllotedExamCenterDistrict() {
		return allotedExamCenterDistrict;
	}

	public void setAllotedExamCenterDistrict(String allotedExamCenterDistrict) {
		this.allotedExamCenterDistrict = allotedExamCenterDistrict;
	}

	public String getAllotedZoneName() {
		return allotedZoneName;
	}

	public void setAllotedZoneName(String allotedZoneName) {
		this.allotedZoneName = allotedZoneName;
	}

	public String getInvigilatorDistrict() {
		return invigilatorDistrict;
	}

	public void setInvigilatorDistrict(String invigilatorDistrict) {
		this.invigilatorDistrict = invigilatorDistrict;
	}

	public String getInvigilatorZone() {
		return invigilatorZone;
	}

	public void setInvigilatorZone(String invigilatorZone) {
		this.invigilatorZone = invigilatorZone;
	}

	public String getInvigilatorName() {
		return invigilatorName;
	}

	public void setInvigilatorName(String invigilatorName) {
		this.invigilatorName = invigilatorName;
	}

	public String getUniqueExamCenterCode() {
		return uniqueExamCenterCode;
	}

	public void setUniqueExamCenterCode(String uniqueExamCenterCode) {
		this.uniqueExamCenterCode = uniqueExamCenterCode;
	}

	public String getUniqueInvigilatorCode() {
		return uniqueInvigilatorCode;
	}

	public void setUniqueInvigilatorCode(String uniqueInvigilatorCode) {
		this.uniqueInvigilatorCode = uniqueInvigilatorCode;
	}
	
	

}
