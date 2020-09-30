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
@Table(name = "notifications")
public class Notifications implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "notificationId", unique = true, nullable = false)
	private Integer notificationId;
	
	@Column(name = "dEpartmentId")
	private Integer dEpartmentId;
	
	@Column(name = "idRequisition")
	private Integer idRequisition;
	
	@Column(name="notificationMsg")
	private String notificationMsg;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="notificationGeneratedDateAndTime")
    private Date notificationGeneratedDateAndTime;
    
    @Column(name="readUnreadStatus")
    private boolean readUnreadStatus;

	public Integer getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	public Integer getdEpartmentId() {
		return dEpartmentId;
	}

	public void setdEpartmentId(Integer dEpartmentId) {
		this.dEpartmentId = dEpartmentId;
	}

	public Integer getIdRequisition() {
		return idRequisition;
	}

	public void setIdRequisition(Integer idRequisition) {
		this.idRequisition = idRequisition;
	}

	public String getNotificationMsg() {
		return notificationMsg;
	}

	public void setNotificationMsg(String notificationMsg) {
		this.notificationMsg = notificationMsg;
	}

	public Date getNotificationGeneratedDateAndTime() {
		return notificationGeneratedDateAndTime;
	}

	public void setNotificationGeneratedDateAndTime(Date notificationGeneratedDateAndTime) {
		this.notificationGeneratedDateAndTime = notificationGeneratedDateAndTime;
	}

	public boolean isReadUnreadStatus() {
		return readUnreadStatus;
	}

	public void setReadUnreadStatus(boolean readUnreadStatus) {
		this.readUnreadStatus = readUnreadStatus;
	}
    
    
}
