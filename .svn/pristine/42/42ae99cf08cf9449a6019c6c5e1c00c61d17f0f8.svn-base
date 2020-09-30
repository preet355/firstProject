package in.hkcl.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "postmaster")
public class PostMaster implements Serializable{

	
	private static final long serialVersionUID = -3391237942726892259L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "postmasterId", unique = true, nullable = false)
	private Integer postmasterId;
	
	@Column(name = "postgroupId")
	private Integer postgroupId;
	
	
	@Column(name = "postName")
	private String postName;
	
	@Column(name="status")
	private Boolean status; 
	
	@OneToOne(targetEntity = PostGroup.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "postgroupId", referencedColumnName = "postgroupId", nullable = false, insertable = false, updatable = false)
	private PostGroup postGroupObj;


	public Integer getPostmasterId() {
		return postmasterId;
	}


	public void setPostmasterId(Integer postmasterId) {
		this.postmasterId = postmasterId;
	}


	public Integer getPostgroupId() {
		return postgroupId;
	}


	public void setPostgroupId(Integer postgroupId) {
		this.postgroupId = postgroupId;
	}


	public String getPostName() {
		return postName;
	}


	public void setPostName(String postName) {
		this.postName = postName;
	}


	public PostGroup getPostGroupObj() {
		return postGroupObj;
	}


	public void setPostGroupObj(PostGroup postGroupObj) {
		this.postGroupObj = postGroupObj;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}



	
	
}
