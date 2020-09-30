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
@Table(name = "applicationclosedate")
public class ApplicationClosed implements Serializable{

	
	private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "applicationcloseId", unique = true, nullable = false)
	private Integer applicationcloseId;
	
	@Column(name = "sRNo")
	private Integer sRNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="applicationclosed")
	private Date applicationclosed;
	
	@Column(name = "comments")
	private String comments;

	public Integer getApplicationcloseId() {
		return applicationcloseId;
	}

	public void setApplicationcloseId(Integer applicationcloseId) {
		this.applicationcloseId = applicationcloseId;
	}

	public Integer getsRNo() {
		return sRNo;
	}

	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}

	public Date getApplicationclosed() {
		return applicationclosed;
	}

	public void setApplicationclosed(Date applicationclosed) {
		this.applicationclosed = applicationclosed;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	

}
