package in.hkcl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "petitionerdetails")
public class PetitionerDetails implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "petitionerId", unique = true, nullable = false)
	private Integer petitionerId;
	
	@Column(name = "caseId")
	private Integer caseId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "rollNo")
	private String rollNo;
	
	@Column(name = "versus")
	private String versus;

	public Integer getPetitionerId() {
		return petitionerId;
	}

	public void setPetitionerId(Integer petitionerId) {
		this.petitionerId = petitionerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getVersus() {
		return versus;
	}

	public void setVersus(String versus) {
		this.versus = versus;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	
	

}
