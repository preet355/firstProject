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
@Table(name = "writtenexam")
public class WrittenExam implements Serializable{

	
	private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "writtenExamId", unique = true, nullable = false)
	private Integer writtenExamId;
	
	@Column(name = "sRNo")
	private Integer sRNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="writtenExam")
	private Date writtenExam;
	
	@Column(name = "comments")
	private String comments;

	public Integer getWrittenExamId() {
		return writtenExamId;
	}

	public void setWrittenExamId(Integer writtenExamId) {
		this.writtenExamId = writtenExamId;
	}

	public Integer getsRNo() {
		return sRNo;
	}

	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}

	public Date getWrittenExam() {
		return writtenExam;
	}

	public void setWrittenExam(Date writtenExam) {
		this.writtenExam = writtenExam;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}




}
