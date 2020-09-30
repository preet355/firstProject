package in.hkcl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="requisitionreservationinfo")
public class RequisitionReservationInfo implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idRequisitionreservationinfo", unique = true, nullable = false)
	private Integer idRequisitionreservationinfo;
	
	@Column(name = "idRequisition")
	private Integer idRequisition; 
	
	@Column(name="uniqueRequisitionNumber")
	private String uniqueRequisitionNumber;
	
	@Column(name="category")
	private String category;
	
	@Column(name="subCategory")
	private String subCategory;
	
	@Column(name="totalSeats")
	private Integer totalSeatsForCategory;
	
	@Column(name="backlog")
	private Integer backlog;
	
	@Column(name="status")
	private String status;

	public Integer getIdRequisitionreservationinfo() {
		return idRequisitionreservationinfo;
	}

	public void setIdRequisitionreservationinfo(Integer idRequisitionreservationinfo) {
		this.idRequisitionreservationinfo = idRequisitionreservationinfo;
	}

	public String getUniqueRequisitionNumber() {
		return uniqueRequisitionNumber;
	}

	public void setUniqueRequisitionNumber(String uniqueRequisitionNumber) {
		this.uniqueRequisitionNumber = uniqueRequisitionNumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public Integer getTotalSeatsForCategory() {
		return totalSeatsForCategory;
	}

	public void setTotalSeatsForCategory(Integer totalSeatsForCategory) {
		this.totalSeatsForCategory = totalSeatsForCategory;
	}

	public Integer getBacklog() {
		return backlog;
	}

	public void setBacklog(Integer backlog) {
		this.backlog = backlog;
	}

	public Integer getIdRequisition() {
		return idRequisition;
	}

	public void setIdRequisition(Integer idRequisition) {
		this.idRequisition = idRequisition;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
