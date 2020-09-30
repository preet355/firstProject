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
@Table(name = "admitCardsForInterview")
public class AdmitCardsForInterview implements Serializable{

	
	private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "admitCardsForInterviewId", unique = true, nullable = false)
	private Integer admitCardsForInterviewId;
	
	@Column(name = "sRNo")
	private Integer sRNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="admitCardsForInterview")
	private Date admitCardsForInterview;
	
	@Column(name = "comments")
	private String comments;

	public Integer getAdmitCardsForInterviewId() {
		return admitCardsForInterviewId;
	}

	public void setAdmitCardsForInterviewId(Integer admitCardsForInterviewId) {
		this.admitCardsForInterviewId = admitCardsForInterviewId;
	}

	public Integer getsRNo() {
		return sRNo;
	}

	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}

	public Date getAdmitCardsForInterview() {
		return admitCardsForInterview;
	}

	public void setAdmitCardsForInterview(Date admitCardsForInterview) {
		this.admitCardsForInterview = admitCardsForInterview;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

   

}
