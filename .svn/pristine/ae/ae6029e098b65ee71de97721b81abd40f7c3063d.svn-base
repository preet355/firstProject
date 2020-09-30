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
@Table(name = "uploadedRevisedAnswerKey")
public class UploadedRevisedAnswerKey implements Serializable{

	
	private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uploadedRevisedAnswerKeyId", unique = true, nullable = false)
	private Integer uploadedRevisedAnswerKeyId;
	
	@Column(name = "sRNo")
	private Integer sRNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="uploadedRevisedAnswerKey")
	private Date uploadedRevisedAnswerKey;
	
	@Column(name = "comments")
	private String comments;

	public Integer getUploadedRevisedAnswerKeyId() {
		return uploadedRevisedAnswerKeyId;
	}

	public void setUploadedRevisedAnswerKeyId(Integer uploadedRevisedAnswerKeyId) {
		this.uploadedRevisedAnswerKeyId = uploadedRevisedAnswerKeyId;
	}

	public Integer getsRNo() {
		return sRNo;
	}

	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}

	public Date getUploadedRevisedAnswerKey() {
		return uploadedRevisedAnswerKey;
	}

	public void setUploadedRevisedAnswerKey(Date uploadedRevisedAnswerKey) {
		this.uploadedRevisedAnswerKey = uploadedRevisedAnswerKey;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}




}
