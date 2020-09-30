package in.hkcl.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "examcenterdetails")
public class ExamCenterDetails  implements Serializable{
	
	private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "examCenterId", unique = true, nullable = false)
	private Integer examCenterId;
	
	@Column(name = "examCenterName")
	private String examCenterName;
	
	@Column(name = "idDistrict")
	private Integer idDistrict;
	
	@Column(name = "examId")
	private Integer examId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdDate")
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updatedDate")
	private Date updatedDate;
	
	@OneToOne(targetEntity = District.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "idDistrict", referencedColumnName = "idDistrict", nullable = false, insertable = false, updatable = false)
	private District districtObj;
	
	

	public Integer getExamCenterId() {
		return examCenterId;
	}

	public void setExamCenterId(Integer examCenterId) {
		this.examCenterId = examCenterId;
	}

	

	public String getExamCenterName() {
		return examCenterName;
	}

	public void setExamCenterName(String examCenterName) {
		this.examCenterName = examCenterName;
	}

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getIdDistrict() {
		return idDistrict;
	}

	public void setIdDistrict(Integer idDistrict) {
		this.idDistrict = idDistrict;
	}

	public District getDistrictObj() {
		return districtObj;
	}

	public void setDistrictObj(District districtObj) {
		this.districtObj = districtObj;
	}
	

}
