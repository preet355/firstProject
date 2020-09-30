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
@Table(name = "zonedistrictmapping")
public class ZoneDistrictMapping implements Serializable{
	
private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idMapping", unique = true, nullable = false)
	private Integer idMapping;
	
	@Column(name = "zoneId")
	private Integer zoneId;
	
	@Column(name = "idDistrict")
	private Integer idDistrict;
	
	@Column(name = "districtOrder")
	private String districtOrder;
	
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

	public Integer getIdMapping() {
		return idMapping;
	}

	public void setIdMapping(Integer idMapping) {
		this.idMapping = idMapping;
	}

	public Integer getZoneId() {
		return zoneId;
	}

	public void setZoneId(Integer zoneId) {
		this.zoneId = zoneId;
	}

	public Integer getIdDistrict() {
		return idDistrict;
	}

	public void setIdDistrict(Integer idDistrict) {
		this.idDistrict = idDistrict;
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

	public String getDistrictOrder() {
		return districtOrder;
	}

	public void setDistrictOrder(String districtOrder) {
		this.districtOrder = districtOrder;
	}

	public District getDistrictObj() {
		return districtObj;
	}

	public void setDistrictObj(District districtObj) {
		this.districtObj = districtObj;
	}

	public ZoneMaster getZoneObj() {
		return zoneObj;
	}

	public void setZoneObj(ZoneMaster zoneObj) {
		this.zoneObj = zoneObj;
	}
	
	
	

}
