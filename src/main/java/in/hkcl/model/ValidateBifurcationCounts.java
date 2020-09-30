package in.hkcl.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="validatebifurcationcounts")
public class ValidateBifurcationCounts implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idReqreservationrecords", unique = true, nullable = false)
	private Integer idReqreservationrecords;
	 
	@Column(name="idvalidatebifurcation")
	private Integer idvalidatebifurcation;
	
	@Column(name="category")
	private String category;
	
	@Column(name="subCategory")
	private String subCategory;
	
	@Column(name="totalSeats")
	private Integer totalSeatsForCategory;
	
	
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


	public Integer getIdReqreservationrecords() {
		return idReqreservationrecords;
	}

	public void setIdReqreservationrecords(Integer idReqreservationrecords) {
		this.idReqreservationrecords = idReqreservationrecords;
	}


	public Integer getIdvalidatebifurcation() {
		return idvalidatebifurcation;
	}

	public void setIdvalidatebifurcation(Integer idvalidatebifurcation) {
		this.idvalidatebifurcation = idvalidatebifurcation;
	}
	
	
}
