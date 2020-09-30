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
@Table(name = "resultOfPmtHeightChest")
public class ResultOfPmtHeightChest implements Serializable{

	
	private static final long serialVersionUID = 2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "resultOfPmtHeightChestId", unique = true, nullable = false)
	private Integer resultOfPmtHeightChestId;
	
	@Column(name = "sRNo")
	private Integer sRNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="resultOfPmtHeightChest")
	private Date resultOfPmtHeightChest;
	
	@Column(name = "comments")
	private String comments;

	public Integer getResultOfPmtHeightChestId() {
		return resultOfPmtHeightChestId;
	}

	public void setResultOfPmtHeightChestId(Integer resultOfPmtHeightChestId) {
		this.resultOfPmtHeightChestId = resultOfPmtHeightChestId;
	}

	public Integer getsRNo() {
		return sRNo;
	}

	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}

	public Date getResultOfPmtHeightChest() {
		return resultOfPmtHeightChest;
	}

	public void setResultOfPmtHeightChest(Date resultOfPmtHeightChest) {
		this.resultOfPmtHeightChest = resultOfPmtHeightChest;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}



}
