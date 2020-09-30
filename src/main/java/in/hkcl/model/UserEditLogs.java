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
@Table(name = "userCourtCaseEditLogs")
public class UserEditLogs implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userLogId", unique = true, nullable = false)
	private Integer userLogId;
	
	@Column(name = "userId")
	private Integer userId;
	
	   
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dateOfEdit")
    private Date dateOfEdit;

	public Integer getUserLogId() {
		return userLogId;
	}

	public void setUserLogId(Integer userLogId) {
		this.userLogId = userLogId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getDateOfEdit() {
		return dateOfEdit;
	}

	public void setDateOfEdit(Date dateOfEdit) {
		this.dateOfEdit = dateOfEdit;
	}
	
	

}
