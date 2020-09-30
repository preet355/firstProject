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
@Table(name = "announcementOfResults")
public class AnnouncementOfResults implements Serializable{

	
	private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "announcementOfResultsId", unique = true, nullable = false)
	private Integer announcementOfResultsId;
	
	@Column(name = "sRNo")
	private Integer sRNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="announcementOfResults")
	private Date announcementOfResults;
	
	@Column(name = "comments")
	private String comments;

	 

	public Integer getAnnouncementOfResultsId() {
		return announcementOfResultsId;
	}

	public void setAnnouncementOfResultsId(Integer announcementOfResultsId) {
		this.announcementOfResultsId = announcementOfResultsId;
	}

	public Integer getsRNo() {
		return sRNo;
	}

	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}

	public Date getAnnouncementOfResults() {
		return announcementOfResults;
	}

	public void setAnnouncementOfResults(Date announcementOfResults) {
		this.announcementOfResults = announcementOfResults;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}


   

}
