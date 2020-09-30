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
@Table(name = "resultofpst")
public class ResultOfPst implements Serializable{

	
	private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "resultofpstId", unique = true, nullable = false)
	private Integer resultofpstId;
	
	@Column(name = "sRNo")
	private Integer sRNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="resultofpst")
	private Date resultofpst;
	
	@Column(name = "comments")
	private String comments;

	public Integer getResultofpstId() {
		return resultofpstId;
	}

	public void setResultofpstId(Integer resultofpstId) {
		this.resultofpstId = resultofpstId;
	}

	public Integer getsRNo() {
		return sRNo;
	}

	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}

	public Date getResultofpst() {
		return resultofpst;
	}

	public void setResultofpst(Date resultofpst) {
		this.resultofpst = resultofpst;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}





}
