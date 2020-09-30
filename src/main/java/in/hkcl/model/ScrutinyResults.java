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
@Table(name = "scrutinyResults")
public class ScrutinyResults implements Serializable{

	
	private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "scrutinyResultsId", unique = true, nullable = false)
	private Integer scrutinyResultsId;
	
	@Column(name = "sRNo")
	private Integer sRNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="scrutinyResults")
	private Date scrutinyResults;
	
	@Column(name = "comments")
	private String comments;

	public Integer getScrutinyResultsId() {
		return scrutinyResultsId;
	}

	public void setScrutinyResultsId(Integer scrutinyResultsId) {
		this.scrutinyResultsId = scrutinyResultsId;
	}

	public Integer getsRNo() {
		return sRNo;
	}

	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}

	public Date getScrutinyResults() {
		return scrutinyResults;
	}

	public void setScrutinyResults(Date scrutinyResults) {
		this.scrutinyResults = scrutinyResults;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	

}
