package in.hkcl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="smsreceivers")
public class SmsReceivers implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idMobileNumber", unique = true, nullable = false)
	private Integer idMobileNumber;
	
	@Column(name="receiverName")
	private String receiverName;
	
	@Column(name="receiverMobile")
	private String receiverMobile;
	
	@Column(name="receiverRole")
	private String receiverRole;

	public Integer getIdMobileNumber() {
		return idMobileNumber;
	}

	public void setIdMobileNumber(Integer idMobileNumber) {
		this.idMobileNumber = idMobileNumber;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public String getReceiverRole() {
		return receiverRole;
	}

	public void setReceiverRole(String receiverRole) {
		this.receiverRole = receiverRole;
	}

	
}
