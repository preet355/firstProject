package in.hkcl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emailLogs")
public class EmailLogs implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="emailId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer emailId;
	
	@Column
	private String emailSender;
	
	@Column
	private String emailrecipient;
	
	@Column
	private String emailCC;
	
	@Column
	private String emailBCC;
	
	@Column 
	private String emailSubject;
	
	@Column
	private String emailBody;

	public Integer getEmailId() {
		return emailId;
	}

	public void setEmailId(Integer emailId) {
		this.emailId = emailId;
	}

	public String getEmailSender() {
		return emailSender;
	}

	public void setEmailSender(String emailSender) {
		this.emailSender = emailSender;
	}

	public String getEmailrecipient() {
		return emailrecipient;
	}

	public void setEmailrecipient(String emailrecipient) {
		this.emailrecipient = emailrecipient;
	}

	public String getEmailCC() {
		return emailCC;
	}

	public void setEmailCC(String emailCC) {
		this.emailCC = emailCC;
	}

	public String getEmailBCC() {
		return emailBCC;
	}

	public void setEmailBCC(String emailBCC) {
		this.emailBCC = emailBCC;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}
	
	

}
