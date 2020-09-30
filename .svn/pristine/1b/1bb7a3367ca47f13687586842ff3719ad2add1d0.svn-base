package in.hkcl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cAtId", unique = true, nullable = false)
	private Integer cAtId;
	
	@Column(name="aDvtNo")
	private String aDvtNo;
	
	@Column(name="aDvtid")
	private Integer aDvtid;

	@Column(name="cAtNo")
	private String cAtNo;

	public Integer getcAtId() {
		return cAtId;
	}

	public void setcAtId(Integer cAtId) {
		this.cAtId = cAtId;
	}

	public String getaDvtNo() {
		return aDvtNo;
	}

	public void setaDvtNo(String aDvtNo) {
		this.aDvtNo = aDvtNo;
	}

	public Integer getaDvtid() {
		return aDvtid;
	}

	public void setaDvtid(Integer aDvtid) {
		this.aDvtid = aDvtid;
	}

	public String getcAtNo() {
		return cAtNo;
	}

	public void setcAtNo(String cAtNo) {
		this.cAtNo = cAtNo;
	}
	
	
}
