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
@Table(name = "advertisementposteddate")
public class AdvertisementPosted implements Serializable{

	
	private static final long serialVersionUID = -906082622314531952L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "advtPostedId", unique = true, nullable = false)
	private Integer advtPostedId;
	
	@Column(name = "sRNo")
	private Integer sRNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="advertisementPosted")
	private Date advertisementPosted;
	
	@Column(name = "comments")
	private String comments;

	public Integer getAdvtPostedId() {
		return advtPostedId;
	}

	public void setAdvtPostedId(Integer advtPostedId) {
		this.advtPostedId = advtPostedId;
	}

	public Integer getsRNo() {
		return sRNo;
	}

	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}

	public Date getAdvertisementPosted() {
		return advertisementPosted;
	}

	public void setAdvertisementPosted(Date advertisementPosted) {
		this.advertisementPosted = advertisementPosted;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	

}
