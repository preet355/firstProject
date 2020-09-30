package in.hkcl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emailtemplate")
public class EmailTemplate implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idTemplate", unique = true, nullable = false)
	private Integer idTemplate;
	
	private String emailType;
	private String emailHeadOne;
	private String emailCss;
	private String emailHeadTwo;
	private String emailBodyOne;
	private String emailBodyTwo;
	private String emailBodyThree;
	private String emailBodyFour;
	private String emailFooter;
	public Integer getIdTemplate() {
		return idTemplate;
	}
	public void setIdTemplate(Integer idTemplate) {
		this.idTemplate = idTemplate;
	}
	public String getEmailHeadOne() {
		return emailHeadOne;
	}
	public void setEmailHeadOne(String emailHeadOne) {
		this.emailHeadOne = emailHeadOne;
	}
	public String getEmailCss() {
		return emailCss;
	}
	public void setEmailCss(String emailCss) {
		this.emailCss = emailCss;
	}
	public String getEmailHeadTwo() {
		return emailHeadTwo;
	}
	public void setEmailHeadTwo(String emailHeadTwo) {
		this.emailHeadTwo = emailHeadTwo;
	}
	
	
	public String getEmailBodyOne() {
		return emailBodyOne;
	}
	public void setEmailBodyOne(String emailBodyOne) {
		this.emailBodyOne = emailBodyOne;
	}
	public String getEmailBodyTwo() {
		return emailBodyTwo;
	}
	
	public void setEmailBodyTwo(String emailBodyTwo) {
		this.emailBodyTwo = emailBodyTwo;
	}
	public String getEmailFooter() {
		return emailFooter;
	}
	public void setEmailFooter(String emailFooter) {
		this.emailFooter = emailFooter;
	}
	public String getEmailType() {
		return emailType;
	}
	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}
	public String getEmailBodyThree() {
		return emailBodyThree;
	}
	public void setEmailBodyThree(String emailBodyThree) {
		this.emailBodyThree = emailBodyThree;
	}
	public String getEmailBodyFour() {
		return emailBodyFour;
	}
	public void setEmailBodyFour(String emailBodyFour) {
		this.emailBodyFour = emailBodyFour;
	}
	
	

}
