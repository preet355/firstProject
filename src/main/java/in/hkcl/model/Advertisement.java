package in.hkcl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "advertise")
public class Advertisement implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "aDvtId", unique = true, nullable = false)
	private Integer aDvtId;


	@Column(name = "aDvtNo")
	private String aDvtNo;
	
	@Column(name = "Remarks")
	private String remarks;

	public Integer getaDvtId() {
		return aDvtId;
	}

	public void setaDvtId(Integer aDvtId) {
		this.aDvtId = aDvtId;
	}

	public String getaDvtNo() {
		return aDvtNo;
	}

	public void setaDvtNo(String aDvtNo) {
		this.aDvtNo = aDvtNo;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
	
	
}
