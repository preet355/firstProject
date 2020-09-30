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
@Table(name = "interviewEndDate")
public class InterviewEndDate implements Serializable{

	
	private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "interviewEndDateId", unique = true, nullable = false)
	private Integer interviewEndDateId;
	
	@Column(name = "sRNo")
	private Integer sRNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="interviewEndDate")
	private Date interviewEndDate;
	
	@Column(name = "comments")
	private String comments;

	public Integer getInterviewEndDateId() {
		return interviewEndDateId;
	}

	public void setInterviewEndDateId(Integer interviewEndDateId) {
		this.interviewEndDateId = interviewEndDateId;
	}

	public Integer getsRNo() {
		return sRNo;
	}

	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}

	public Date getInterviewEndDate() {
		return interviewEndDate;
	}

	public void setInterviewEndDate(Date interviewEndDate) {
		this.interviewEndDate = interviewEndDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}


	

}
