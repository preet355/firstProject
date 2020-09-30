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
@Table(name = "objectionsopen")
public class ObjectionsOpen implements Serializable{

	
	private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "objectionsOpenId", unique = true, nullable = false)
	private Integer objectionsOpenId;
	
	@Column(name = "sRNo")
	private Integer sRNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="objectionsOpen")
	private Date objectionsOpen;
	
	@Column(name = "comments")
	private String comments;

	public Integer getObjectionsOpenId() {
		return objectionsOpenId;
	}

	public void setObjectionsOpenId(Integer objectionsOpenId) {
		this.objectionsOpenId = objectionsOpenId;
	}

	public Integer getsRNo() {
		return sRNo;
	}

	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}

	public Date getObjectionsOpen() {
		return objectionsOpen;
	}

	public void setObjectionsOpen(Date objectionsOpen) {
		this.objectionsOpen = objectionsOpen;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}




}
