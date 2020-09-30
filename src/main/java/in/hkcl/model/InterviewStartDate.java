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
@Table(name = "interviewStartDate")
public class InterviewStartDate implements Serializable{

	
	private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "interviewStartDateId", unique = true, nullable = false)
	private Integer interviewStartDateId;
	
	@Column(name = "sRNo")
	private Integer sRNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="interviewStartDate")
	private Date interviewStartDate;
	
	@Column(name = "comments")
	private String comments;

	public Integer getInterviewStartDateId() {
		return interviewStartDateId;
	}

	public void setInterviewStartDateId(Integer interviewStartDateId) {
		this.interviewStartDateId = interviewStartDateId;
	}

	public Integer getsRNo() {
		return sRNo;
	}

	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}

	public Date getInterviewStartDate() {
		return interviewStartDate;
	}

	public void setInterviewStartDate(Date interviewStartDate) {
		this.interviewStartDate = interviewStartDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	

}
