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
@Table(name="userhistory")
public class UserHistory implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="userHistoryId",unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userHistoryId;
	
	@Column(name="userId")
	private Integer userId;
	
	@Column(name="loggedInTime")
	private Date loggedInTime;
	
	@Column(name="loggedOutTime")
	private Date loggedOutTime;
	
    @Column(name="browserNameAndVersion")
    private String browserNameAndVersion;

	public Integer getUserHistoryId() {
		return userHistoryId;
	}

	public void setUserHistoryId(Integer userHistoryId) {
		this.userHistoryId = userHistoryId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getLoggedInTime() {
		return loggedInTime;
	}

	public void setLoggedInTime(Date loggedInTime) {
		this.loggedInTime = loggedInTime;
	}

	public Date getLoggedOutTime() {
		return loggedOutTime;
	}

	public void setLoggedOutTime(Date loggedOutTime) {
		this.loggedOutTime = loggedOutTime;
	}

	public String getBrowserNameAndVersion() {
		return browserNameAndVersion;
	}

	public void setBrowserNameAndVersion(String browserNameAndVersion) {
		this.browserNameAndVersion = browserNameAndVersion;
	}
    
    
}
