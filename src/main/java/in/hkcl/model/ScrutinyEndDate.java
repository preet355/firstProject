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
@Table(name = "scrutinyEndDate")
public class ScrutinyEndDate implements Serializable{

	
	private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "scrutinyEndDateId", unique = true, nullable = false)
	private Integer scrutinyEndDateId;
	
	@Column(name = "sRNo")
	private Integer sRNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="scrutinyEndDate")
	private Date scrutinyEndDate;
	
	@Column(name = "comments")
	private String comments;

	public Integer getScrutinyEndDateId() {
		return scrutinyEndDateId;
	}

	public void setScrutinyEndDateId(Integer scrutinyEndDateId) {
		this.scrutinyEndDateId = scrutinyEndDateId;
	}

	public Integer getsRNo() {
		return sRNo;
	}

	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}

	public Date getScrutinyEndDate() {
		return scrutinyEndDate;
	}

	public void setScrutinyEndDate(Date scrutinyEndDate) {
		this.scrutinyEndDate = scrutinyEndDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}


  

}
