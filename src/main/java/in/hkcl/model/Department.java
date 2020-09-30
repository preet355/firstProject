package in.hkcl.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department implements Serializable {
	

   private static final long serialVersionUID = 1L;

		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dEpartmentId", unique = true, nullable = false)
	private Integer dEpartmentId;
	
	@Column(name = "dEpartment")
	private String dEpartment;
	
	@Column(name="onlyPwdAllowed")
	private boolean onlyPwdAllowed;
	
	@Column(name="pwdAllowed")
	private boolean pwdAllowed;
	
	@Column(name="createdDate")
	private Date createdDate;
	
	@Column(name="hasSpe")
	private boolean hasSpe;	

	public Integer getdEpartmentId() {
		return dEpartmentId;
	}

	public void setdEpartmentId(Integer dEpartmentId) {
		this.dEpartmentId = dEpartmentId;
	}

	public String getdEpartment() {
		return dEpartment;
	}

	public void setdEpartment(String dEpartment) {
		this.dEpartment = dEpartment;
	}

	public boolean isOnlyPwdAllowed() {
		return onlyPwdAllowed;
	}

	public void setOnlyPwdAllowed(boolean onlyPwdAllowed) {
		this.onlyPwdAllowed = onlyPwdAllowed;
	}

	public boolean isPwdAllowed() {
		return pwdAllowed;
	}

	public void setPwdAllowed(boolean pwdAllowed) {
		this.pwdAllowed = pwdAllowed;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isHasSpe() {
		return hasSpe;
	}

	public void setHasSpe(boolean hasSpe) {
		this.hasSpe = hasSpe;
	}

	

}
