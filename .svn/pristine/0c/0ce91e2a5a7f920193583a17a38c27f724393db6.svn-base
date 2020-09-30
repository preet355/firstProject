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
@Table(name = "resultOfWrittenExam")
public class ResultOfWrittenExam implements Serializable{

	
	private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "resultOfWrittenExamId", unique = true, nullable = false)
	private Integer resultOfWrittenExamId;
	
	@Column(name = "sRNo")
	private Integer sRNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="resultOfWrittenExam")
	private Date resultOfWrittenExam;
	
	@Column(name = "comments")
	private String comments;

	public Integer getResultOfWrittenExamId() {
		return resultOfWrittenExamId;
	}

	public void setResultOfWrittenExamId(Integer resultOfWrittenExamId) {
		this.resultOfWrittenExamId = resultOfWrittenExamId;
	}

	public Integer getsRNo() {
		return sRNo;
	}

	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}

	public Date getResultOfWrittenExam() {
		return resultOfWrittenExam;
	}

	public void setResultOfWrittenExam(Date resultOfWrittenExam) {
		this.resultOfWrittenExam = resultOfWrittenExam;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}



}
