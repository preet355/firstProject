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
@Table(name = "uploadinganswerkey")
public class UploadingAnswerKey implements Serializable{

	
	private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uploadingAnswerKeyId", unique = true, nullable = false)
	private Integer uploadingAnswerKeyId;
	
	@Column(name = "sRNo")
	private Integer sRNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="uploadingAnswerKey")
	private Date uploadingAnswerKey;
	
	@Column(name = "comments")
	private String comments;

	public Integer getUploadingAnswerKeyId() {
		return uploadingAnswerKeyId;
	}

	public void setUploadingAnswerKeyId(Integer uploadingAnswerKeyId) {
		this.uploadingAnswerKeyId = uploadingAnswerKeyId;
	}

	public Integer getsRNo() {
		return sRNo;
	}

	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}

	public Date getUploadingAnswerKey() {
		return uploadingAnswerKey;
	}

	public void setUploadingAnswerKey(Date uploadingAnswerKey) {
		this.uploadingAnswerKey = uploadingAnswerKey;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}


	


}
