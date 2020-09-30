package in.hkcl.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "advtstatusforspe")
public class AdvtStatusForSPE implements Serializable{
	
	private static final long serialVersionUID=2984400292715752126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "advtstatusforspeId", unique = true, nullable = false)
	private Integer advtstatusforspeId;
	
	@Column(name ="dEpartmentId")
	private Integer dEpartmentId;
	
	@Column(name ="postmasterId")
	private Integer postmasterId;
	
	@Column(name ="noOfPostInDirectQuata")
	private Integer noOfPostInDirectQuata;
	
	@Column(name ="noOfVacantPostInDirectQuata")
	private Integer noOfVacantPostInDirectQuata;
	
	@Column(name ="noOfPostSentToHSSC")
	private Integer noOfPostSentToHSSC;
	
	@Column(name="hasAdvtIssued")
	private String hasAdvtIssued;

	@Column(name="dateOfAdvertisement")
	private String dateOfAdvertisement;
	
	@Column(name="hasHsscProvidedSelectionList")
	private String hasHsscProvidedSelectionList;
	
	@Column(name="hasOfferOfAppoIssued")
	private String hasOfferOfAppoIssued;
	
	@Column(name ="noOfPostForWhichLetterIssued")
	private Integer noOfPostForWhichLetterIssued;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name ="createdDate")
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name ="updatedDate")
	private Date updatedDate;
	
	@ManyToOne(targetEntity = PostMaster.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "postmasterId", referencedColumnName = "postmasterId", nullable = false, insertable = false, updatable = false)
	private PostMaster postObj;

	public Integer getAdvtstatusforspeId() {
		return advtstatusforspeId;
	}

	public void setAdvtstatusforspeId(Integer advtstatusforspeId) {
		this.advtstatusforspeId = advtstatusforspeId;
	}

	public Integer getdEpartmentId() {
		return dEpartmentId;
	}

	public void setdEpartmentId(Integer dEpartmentId) {
		this.dEpartmentId = dEpartmentId;
	}

	public Integer getPostmasterId() {
		return postmasterId;
	}

	public void setPostmasterId(Integer postmasterId) {
		this.postmasterId = postmasterId;
	}

	public Integer getNoOfPostInDirectQuata() {
		return noOfPostInDirectQuata;
	}

	public void setNoOfPostInDirectQuata(Integer noOfPostInDirectQuata) {
		this.noOfPostInDirectQuata = noOfPostInDirectQuata;
	}

	public Integer getNoOfVacantPostInDirectQuata() {
		return noOfVacantPostInDirectQuata;
	}

	public void setNoOfVacantPostInDirectQuata(Integer noOfVacantPostInDirectQuata) {
		this.noOfVacantPostInDirectQuata = noOfVacantPostInDirectQuata;
	}

	public Integer getNoOfPostSentToHSSC() {
		return noOfPostSentToHSSC;
	}

	public void setNoOfPostSentToHSSC(Integer noOfPostSentToHSSC) {
		this.noOfPostSentToHSSC = noOfPostSentToHSSC;
	}

	public String getHasAdvtIssued() {
		return hasAdvtIssued;
	}

	public void setHasAdvtIssued(String hasAdvtIssued) {
		this.hasAdvtIssued = hasAdvtIssued;
	}

	public String getDateOfAdvertisement() {
		return dateOfAdvertisement;
	}

	public void setDateOfAdvertisement(String dateOfAdvertisement) {
		this.dateOfAdvertisement = dateOfAdvertisement;
	}

	public String getHasHsscProvidedSelectionList() {
		return hasHsscProvidedSelectionList;
	}

	public void setHasHsscProvidedSelectionList(String hasHsscProvidedSelectionList) {
		this.hasHsscProvidedSelectionList = hasHsscProvidedSelectionList;
	}

	public String getHasOfferOfAppoIssued() {
		return hasOfferOfAppoIssued;
	}

	public void setHasOfferOfAppoIssued(String hasOfferOfAppoIssued) {
		this.hasOfferOfAppoIssued = hasOfferOfAppoIssued;
	}

	public Integer getNoOfPostForWhichLetterIssued() {
		return noOfPostForWhichLetterIssued;
	}

	public void setNoOfPostForWhichLetterIssued(Integer noOfPostForWhichLetterIssued) {
		this.noOfPostForWhichLetterIssued = noOfPostForWhichLetterIssued;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public PostMaster getPostObj() {
		return postObj;
	}

	public void setPostObj(PostMaster postObj) {
		this.postObj = postObj;
	}
	
	
}
