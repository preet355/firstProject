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
@Table(name = "pMTHeightChest")
public class PMTHeightChest implements Serializable{

	
	private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pMTHeightChestId", unique = true, nullable = false)
	private Integer pMTHeightChestId;
	
	@Column(name = "sRNo")
	private Integer sRNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="pmtHeightChest")
	private Date pmtHeightChest;
	
	@Column(name = "comments")
	private String comments;

	public Integer getpMTHeightChestId() {
		return pMTHeightChestId;
	}

	public void setpMTHeightChestId(Integer pMTHeightChestId) {
		this.pMTHeightChestId = pMTHeightChestId;
	}

	public Integer getsRNo() {
		return sRNo;
	}

	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}

	public Date getPmtHeightChest() {
		return pmtHeightChest;
	}

	public void setPmtHeightChest(Date pmtHeightChest) {
		this.pmtHeightChest = pmtHeightChest;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	

}
