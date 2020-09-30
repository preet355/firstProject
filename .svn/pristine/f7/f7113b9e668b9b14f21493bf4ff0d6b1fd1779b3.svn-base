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
@Table(name = "examinvigilatordetails")
public class ExamInvigilatorsDetails implements Serializable{
	
private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "invigilatorId", unique = true, nullable = false)
	private Integer invigilatorId;
	
	@Column(name="invigilatorName")
	private String invigilatorName;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name = "examId")
	private Integer examId;
	
	@Column(name = "idDistrict")
	private Integer idDistrict;
	
	@Column(name = "zoneId")
	private Integer zoneId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdDate")
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updatedDate")
	private Date updatedDate;
	
	
	@OneToOne(targetEntity = District.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "idDistrict", referencedColumnName = "idDistrict", nullable = false, insertable = false, updatable = false)
	private District districtObj;
	
	@OneToOne(targetEntity = ZoneMaster.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "zoneId", referencedColumnName = "zoneId", nullable = false, insertable = false, updatable = false)
	private ZoneMaster zoneObj;

	public Integer getInvigilatorId() {
		return invigilatorId;
	}

	public void setInvigilatorId(Integer invigilatorId) {
		this.invigilatorId = invigilatorId;
	}

	public String getInvigilatorName() {
		return invigilatorName;
	}

	public void setInvigilatorName(String invigilatorName) {
		this.invigilatorName = invigilatorName;
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

	public Integer getZoneId() {
		return zoneId;
	}

	public void setZoneId(Integer zoneId) {
		this.zoneId = zoneId;
	}

	public ZoneMaster getZoneObj() {
		return zoneObj;
	}

	public void setZoneObj(ZoneMaster zoneObj) {
		this.zoneObj = zoneObj;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}



}
