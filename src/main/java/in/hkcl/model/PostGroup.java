package in.hkcl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "postgroup")
public class PostGroup implements Serializable{
	
	private static final long serialVersionUID = -3391237942726892259L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "postgroupId", unique = true, nullable = false)
	private Integer postgroupId;
	
	@Column(name="postgroupName")
	private String postgroupName;

	public Integer getPostgroupId() {
		return postgroupId;
	}

	public void setPostgroupId(Integer postgroupId) {
		this.postgroupId = postgroupId;
	}

	public String getPostgroupName() {
		return postgroupName;
	}

	public void setPostgroupName(String postgroupName) {
		this.postgroupName = postgroupName;
	}
}
