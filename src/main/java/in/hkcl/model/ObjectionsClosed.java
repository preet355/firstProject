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
@Table(name = "objectionsclosed")
public class ObjectionsClosed implements Serializable{

	
	private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "objectionsClosedId", unique = true, nullable = false)
	private Integer objectionsClosedId;
	
	@Column(name = "sRNo")
	private Integer sRNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="objectionsClosed")
	private Date objectionsClosed;
	
	@Column(name = "comments")
	private String comments;

	public Integer getObjectionsClosedId() {
		return objectionsClosedId;
	}

	public void setObjectionsClosedId(Integer objectionsClosedId) {
		this.objectionsClosedId = objectionsClosedId;
	}

	public Integer getsRNo() {
		return sRNo;
	}

	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}

	public Date getObjectionsClosed() {
		return objectionsClosed;
	}

	public void setObjectionsClosed(Date objectionsClosed) {
		this.objectionsClosed = objectionsClosed;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}




}
