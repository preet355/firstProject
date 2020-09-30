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
@Table(name = "applicationopendate")
public class ApplicationOpen implements Serializable{

	
	private static final long serialVersionUID = -3391237942726892259L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "applicationopenId", unique = true, nullable = false)
	private Integer applicationopenId;
	
	@Column(name = "sRNo")
	private Integer sRNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="applicationopen")
	private Date applicationopen;
	
	@Column(name = "comments")
	private String comments;

	public Integer getApplicationopenId() {
		return applicationopenId;
	}

	public void setApplicationopenId(Integer applicationopenId) {
		this.applicationopenId = applicationopenId;
	}

	public Integer getsRNo() {
		return sRNo;
	}

	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}

	public Date getApplicationopen() {
		return applicationopen;
	}

	public void setApplicationopen(Date applicationopen) {
		this.applicationopen = applicationopen;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
}
