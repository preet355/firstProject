package in.hkcl.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="requisitioninfo")
public class RequisitionInfo implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idRequisition", unique = true, nullable = false)
	private Integer idRequisition;
	
	@Column(name="dEpartmentId")
	private Integer dEpartmentId;
	
	@Column(name="uniqueRequisitionNumber")
	private String uniqueRequisitionNumber;
	
	@Column(name="postmasterId")
	private Integer postmasterId;
	
	@Column(name="numberOfPostToBeFilled")
	private Integer numberOfPostToBeFilled;
	
	@Column(name="classAndServiceOfPost")
	private String classAndServiceOfPost;
	
	@Column(name="anyPublishedRulesForService")
	private String anyPublishedRulesForService;
	
	@Column(name="linkForServiceRules")
	private String linkForServiceRules;
	
	@Column(name="isPostPermanentOrTemporary")
	private String isPostPermanentOrTemporary;
	
	@Column(name="scaleOfPayForDirectRecruits")
	private String scaleOfPayForDirectRecruits;

	@Column(name="scaleOfPayForPersonsAlreadyInGovernmentService")
	private String scaleOfPayForPersonsAlreadyInGovernmentService;
	
	@Column(name="higherInitialPayBeGranted")
	private String higherInitialPayBeGranted;
	
	@Column(name="anySpecialConcessionsForNonAsiaticDomicile")
	private String anySpecialConcessionsForNonAsiaticDomicile;
	
	@Column(name="academicQualifications")
	private String academicQualifications;
	
	@Column(name="training")
	private String training;
	
	@Column(name="hindiQualification")
	private String hindiQualification;
	
	@Column(name="experience")
	private Integer experience;
	
	@Column(name="experienceInMonths")
	private Integer experienceInMonths;
	
	@Column(name="isExperienceTakenIntoConsidration")
	private String isExperienceTakenIntoConsidration;
	
	@Column(name="anyOtherQualifications")
	private String anyOtherQualifications;
	
	@Column(name="requirementsStrictlyAthered")
	private String requirementsStrictlyAthered;
	
	@Column(name="equivalentQualifications")
	private  String equivalentQualifications; 
	
	@Column(name="lowerAgeLimit")
	private Integer lowerAgeLimit;
	
	@Column(name="upperAgeLimit")
	private Integer upperAgeLimit;
	
	@Column(name="dateOnWhichAgeIsDetermined")
	private String dateOnWhichAgeIsDetermined;
	
	@Column(name="anyRelaxationForGovServents")
	private String anyRelaxationForGovServents;
	
	@Column(name="anyRelaxationForSutaibleCandidates")
	private String anyRelaxationForSutaibleCandidates;
	
	@Column(name="areGovServantsEligible")
	private String areGovServantsEligible;
	
	
	@Column(name="nameOfOfficerForAdvisoryCapacity")
	private String nameOfOfficerForAdvisoryCapacity;
	
	@Column(name="nameOfNodalOfficer")
	private String nameOfNodalOfficer;
	
	@Column(name="phoneNumberOfNodelOfficer")
	private Long phoneNumberOfNodelOfficer;
	
	@Column(name="conditionOrQualificationNotCoveredAbove")
	private String conditionOrQualificationNotCoveredAbove;
	
	@Column(name="status")
	private String status;	
	

	@Column(name="backlog")
	private Integer backlog;
	
	@Column(name="previosuRosterPoint")
	private Integer previosuRosterPoint;

	@Column(name="totalPWDSeats")
	private Integer totalPWDSeats;

	@Column(name="pwd1")
	private Integer pwd1;

	@Column(name="pwd2")
	private Integer pwd2;

	@Column(name="pwd3")
	private Integer pwd3;

	@Column(name="pwd4")
	private Integer pwd4;
	
	@Column(name="pwdB")
	private Integer pwdB;
	
	@Column(name="pwdL")
	private Integer pwdL;
	
	@Column(name="pwdFD")
	private Integer pwdFD;
	
	@Column(name="pwdHH")
	private Integer pwdHH;
	
	@Column(name="pwdOL")
	private Integer pwdOL;
	
	@Column(name="pwdOA")
	private Integer pwdOA;
	
	@Column(name="pwdBA")
	private Integer pwdBA;
	
	@Column(name="pwdBH")
	private Integer pwdBH;
	
	@Column(name="pwdMW")
	private Integer pwdMW;
	
	@Column(name="pwdOAL")
	private Integer pwdOAL;
	
	@Column(name="pwdBLA")
	private Integer pwdBLA;
	
	@Column(name="pwdBLOA")
	private Integer pwdBLOA;
	
	@Column(name="pwdCPaisy")
	private Integer pwdCPaisy;
	
	@Column(name="pwdLCured")
	private Integer pwdLCured;
	
	@Column(name="pwdDwarfism")
	private Integer pwdDwarfism;
	
	@Column(name="pwdAAVictims")
	private Integer pwdAAVictims;
	
	@Column(name="pwdMDystrophy")
	private Integer pwdMDystrophy;
	
	@Column(name="pwdOthers")
	private Integer pwdOthers;
	
	@Column(name="createdatetime")
	private Date createdatetime;
	
	@Column(name="updatedatetime")
	private Date updatedatetime;
	
	@Column(name="espSeats")
	private Integer espSeats;
	
	@Column(name="jobDescription")
	private String jobDescription;

	
	@OneToOne(targetEntity = Department.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dEpartmentId", referencedColumnName = "dEpartmentId", nullable = false, insertable = false, updatable = false)
	private Department deptObj;
	
	@OneToOne(targetEntity = PostMaster.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "postmasterId", referencedColumnName = "postmasterId", nullable = false, insertable = false, updatable = false)
	private PostMaster postObj;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "idRequisition", targetEntity = RequisitionReservationInfo.class, cascade = { CascadeType.ALL })
	private List<RequisitionReservationInfo> requisitionReservationInfoList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "idRequisition", targetEntity = RequisitionDocs.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<RequisitionDocs> requisitionDocsList;
	
	@Transient
	List<BifurcationHelper> bifurcationList;

	@Transient
	Integer totalFilled;



	public Integer getIdRequisition() {
		return idRequisition;
	}

	public void setIdRequisition(Integer idRequisition) {
		this.idRequisition = idRequisition;
	}


	public Integer getdEpartmentId() {
		return dEpartmentId;
	}

	public void setdEpartmentId(Integer dEpartmentId) {
		this.dEpartmentId = dEpartmentId;
	}

	public Department getDeptObj() {
		return deptObj;
	}

	public void setDeptObj(Department deptObj) {
		this.deptObj = deptObj;
	}

	public String getUniqueRequisitionNumber() {
		return uniqueRequisitionNumber;
	}

	public void setUniqueRequisitionNumber(String uniqueRequisitionNumber) {
		this.uniqueRequisitionNumber = uniqueRequisitionNumber;
	}


	public Integer getPostmasterId() {
		return postmasterId;
	}

	public void setPostmasterId(Integer postmasterId) {
		this.postmasterId = postmasterId;
	}

	public Integer getNumberOfPostToBeFilled() {
		return numberOfPostToBeFilled;
	}

	public void setNumberOfPostToBeFilled(Integer numberOfPostToBeFilled) {
		this.numberOfPostToBeFilled = numberOfPostToBeFilled;
	}

	public String getClassAndServiceOfPost() {
		return classAndServiceOfPost;
	}

	public void setClassAndServiceOfPost(String classAndServiceOfPost) {
		this.classAndServiceOfPost = classAndServiceOfPost;
	}

	public String getAnyPublishedRulesForService() {
		return anyPublishedRulesForService;
	}

	public void setAnyPublishedRulesForService(String anyPublishedRulesForService) {
		this.anyPublishedRulesForService = anyPublishedRulesForService;
	}

	public String getLinkForServiceRules() {
		return linkForServiceRules;
	}

	public void setLinkForServiceRules(String linkForServiceRules) {
		this.linkForServiceRules = linkForServiceRules;
	}

	public String getIsPostPermanentOrTemporary() {
		return isPostPermanentOrTemporary;
	}

	public void setIsPostPermanentOrTemporary(String isPostPermanentOrTemporary) {
		this.isPostPermanentOrTemporary = isPostPermanentOrTemporary;
	}

	public String getScaleOfPayForDirectRecruits() {
		return scaleOfPayForDirectRecruits;
	}

	public void setScaleOfPayForDirectRecruits(String scaleOfPayForDirectRecruits) {
		this.scaleOfPayForDirectRecruits = scaleOfPayForDirectRecruits;
	}

	public String getScaleOfPayForPersonsAlreadyInGovernmentService() {
		return scaleOfPayForPersonsAlreadyInGovernmentService;
	}

	public void setScaleOfPayForPersonsAlreadyInGovernmentService(String scaleOfPayForPersonsAlreadyInGovernmentService) {
		this.scaleOfPayForPersonsAlreadyInGovernmentService = scaleOfPayForPersonsAlreadyInGovernmentService;
	}

	public String getHigherInitialPayBeGranted() {
		return higherInitialPayBeGranted;
	}

	public void setHigherInitialPayBeGranted(String higherInitialPayBeGranted) {
		this.higherInitialPayBeGranted = higherInitialPayBeGranted;
	}

	public String getAcademicQualifications() {
		return academicQualifications;
	}

	public void setAcademicQualifications(String academicQualifications) {
		this.academicQualifications = academicQualifications;
	}

	public String getTraining() {
		return training;
	}

	public void setTraining(String training) {
		this.training = training;
	}

	public String getHindiQualification() {
		return hindiQualification;
	}

	public void setHindiQualification(String hindiQualification) {
		this.hindiQualification = hindiQualification;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}


	public String getIsExperienceTakenIntoConsidration() {
		return isExperienceTakenIntoConsidration;
	}

	public void setIsExperienceTakenIntoConsidration(String isExperienceTakenIntoConsidration) {
		this.isExperienceTakenIntoConsidration = isExperienceTakenIntoConsidration;
	}

	public String getAnyOtherQualifications() {
		return anyOtherQualifications;
	}

	public void setAnyOtherQualifications(String anyOtherQualifications) {
		this.anyOtherQualifications = anyOtherQualifications;
	}

	public String getRequirementsStrictlyAthered() {
		return requirementsStrictlyAthered;
	}

	public void setRequirementsStrictlyAthered(String requirementsStrictlyAthered) {
		this.requirementsStrictlyAthered = requirementsStrictlyAthered;
	}

	public String getEquivalentQualifications() {
		return equivalentQualifications;
	}

	public void setEquivalentQualifications(String equivalentQualifications) {
		this.equivalentQualifications = equivalentQualifications;
	}

	public Integer getLowerAgeLimit() {
		return lowerAgeLimit;
	}

	public void setLowerAgeLimit(Integer lowerAgeLimit) {
		this.lowerAgeLimit = lowerAgeLimit;
	}

	public Integer getUpperAgeLimit() {
		return upperAgeLimit;
	}

	public void setUpperAgeLimit(Integer upperAgeLimit) {
		this.upperAgeLimit = upperAgeLimit;
	}

	public String getDateOnWhichAgeIsDetermined() {
		return dateOnWhichAgeIsDetermined;
	}

	public void setDateOnWhichAgeIsDetermined(String dateOnWhichAgeIsDetermined) {
		this.dateOnWhichAgeIsDetermined = dateOnWhichAgeIsDetermined;
	}

	
	public String getAnyRelaxationForGovServents() {
		return anyRelaxationForGovServents;
	}

	public void setAnyRelaxationForGovServents(String anyRelaxationForGovServents) {
		this.anyRelaxationForGovServents = anyRelaxationForGovServents;
	}

	public String getAnyRelaxationForSutaibleCandidates() {
		return anyRelaxationForSutaibleCandidates;
	}

	public void setAnyRelaxationForSutaibleCandidates(String anyRelaxationForSutaibleCandidates) {
		this.anyRelaxationForSutaibleCandidates = anyRelaxationForSutaibleCandidates;
	}

	public String getAreGovServantsEligible() {
		return areGovServantsEligible;
	}

	public void setAreGovServantsEligible(String areGovServantsEligible) {
		this.areGovServantsEligible = areGovServantsEligible;
	}

	

	

	public String getNameOfOfficerForAdvisoryCapacity() {
		return nameOfOfficerForAdvisoryCapacity;
	}

	public void setNameOfOfficerForAdvisoryCapacity(String nameOfOfficerForAdvisoryCapacity) {
		this.nameOfOfficerForAdvisoryCapacity = nameOfOfficerForAdvisoryCapacity;
	}

	public String getNameOfNodalOfficer() {
		return nameOfNodalOfficer;
	}

	public void setNameOfNodalOfficer(String nameOfNodalOfficer) {
		this.nameOfNodalOfficer = nameOfNodalOfficer;
	}

	

	public Long getPhoneNumberOfNodelOfficer() {
		return phoneNumberOfNodelOfficer;
	}

	public void setPhoneNumberOfNodelOfficer(Long phoneNumberOfNodelOfficer) {
		this.phoneNumberOfNodelOfficer = phoneNumberOfNodelOfficer;
	}

	public String getConditionOrQualificationNotCoveredAbove() {
		return conditionOrQualificationNotCoveredAbove;
	}

	public void setConditionOrQualificationNotCoveredAbove(String conditionOrQualificationNotCoveredAbove) {
		this.conditionOrQualificationNotCoveredAbove = conditionOrQualificationNotCoveredAbove;
	}


	public String getAnySpecialConcessionsForNonAsiaticDomicile() {
		return anySpecialConcessionsForNonAsiaticDomicile;
	}

	public void setAnySpecialConcessionsForNonAsiaticDomicile(String anySpecialConcessionsForNonAsiaticDomicile) {
		this.anySpecialConcessionsForNonAsiaticDomicile = anySpecialConcessionsForNonAsiaticDomicile;
	}

	


	public Integer getBacklog() {
		return backlog;
	}

	public void setBacklog(Integer backlog) {
		this.backlog = backlog;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<RequisitionReservationInfo> getRequisitionReservationInfoList() {
		return requisitionReservationInfoList;
	}

	public void setRequisitionReservationInfoList(List<RequisitionReservationInfo> requisitionReservationInfoList) {
		this.requisitionReservationInfoList = requisitionReservationInfoList;
	}

	public List<RequisitionDocs> getRequisitionDocsList() {
		return requisitionDocsList;
	}

	public void setRequisitionDocsList(List<RequisitionDocs> requisitionDocsList) {
		this.requisitionDocsList = requisitionDocsList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<BifurcationHelper> getBifurcationList() {
		return bifurcationList;
	}

	public void setBifurcationList(List<BifurcationHelper> bifurcationList) {
		this.bifurcationList = bifurcationList;
	}

	public Integer getPreviosuRosterPoint() {
		return previosuRosterPoint;
	}

	public void setPreviosuRosterPoint(Integer previosuRosterPoint) {
		this.previosuRosterPoint = previosuRosterPoint;
	}

	public Integer getTotalFilled() {
		return totalFilled;
	}

	public void setTotalFilled(Integer totalFilled) {
		this.totalFilled = totalFilled;
	}

	public Integer getTotalPWDSeats() {
		return totalPWDSeats;
	}

	public void setTotalPWDSeats(Integer totalPWDSeats) {
		this.totalPWDSeats = totalPWDSeats;
	}

	public Integer getPwd1() {
		return pwd1;
	}

	public void setPwd1(Integer pwd1) {
		this.pwd1 = pwd1;
	}

	public Integer getPwd2() {
		return pwd2;
	}

	public void setPwd2(Integer pwd2) {
		this.pwd2 = pwd2;
	}

	public Integer getPwd3() {
		return pwd3;
	}

	public void setPwd3(Integer pwd3) {
		this.pwd3 = pwd3;
	}

	public Integer getPwd4() {
		return pwd4;
	}

	public void setPwd4(Integer pwd4) {
		this.pwd4 = pwd4;
	}

	public Integer getExperienceInMonths() {
		return experienceInMonths;
	}

	public void setExperienceInMonths(Integer experienceInMonths) {
		this.experienceInMonths = experienceInMonths;
	}

	public PostMaster getPostObj() {
		return postObj;
	}

	public void setPostObj(PostMaster postObj) {
		this.postObj = postObj;
	}

	public Date getCreatedatetime() {
		return createdatetime;
	}

	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}

	public Date getUpdatedatetime() {
		return updatedatetime;
	}

	public void setUpdatedatetime(Date updatedatetime) {
		this.updatedatetime = updatedatetime;
	}

	public Integer getEspSeats() {
		return espSeats;
	}

	public void setEspSeats(Integer espSeats) {
		this.espSeats = espSeats;
	}

	public Integer getPwdB() {
		return pwdB;
	}

	public void setPwdB(Integer pwdB) {
		this.pwdB = pwdB;
	}

	public Integer getPwdL() {
		return pwdL;
	}

	public void setPwdL(Integer pwdL) {
		this.pwdL = pwdL;
	}

	public Integer getPwdFD() {
		return pwdFD;
	}

	public void setPwdFD(Integer pwdFD) {
		this.pwdFD = pwdFD;
	}

	public Integer getPwdHH() {
		return pwdHH;
	}

	public void setPwdHH(Integer pwdHH) {
		this.pwdHH = pwdHH;
	}

	public Integer getPwdOL() {
		return pwdOL;
	}

	public void setPwdOL(Integer pwdOL) {
		this.pwdOL = pwdOL;
	}

	public Integer getPwdOA() {
		return pwdOA;
	}

	public void setPwdOA(Integer pwdOA) {
		this.pwdOA = pwdOA;
	}

	public Integer getPwdBA() {
		return pwdBA;
	}

	public void setPwdBA(Integer pwdBA) {
		this.pwdBA = pwdBA;
	}

	public Integer getPwdBH() {
		return pwdBH;
	}

	public void setPwdBH(Integer pwdBH) {
		this.pwdBH = pwdBH;
	}

	public Integer getPwdMW() {
		return pwdMW;
	}

	public void setPwdMW(Integer pwdMW) {
		this.pwdMW = pwdMW;
	}

	public Integer getPwdOAL() {
		return pwdOAL;
	}

	public void setPwdOAL(Integer pwdOAL) {
		this.pwdOAL = pwdOAL;
	}

	public Integer getPwdBLA() {
		return pwdBLA;
	}

	public void setPwdBLA(Integer pwdBLA) {
		this.pwdBLA = pwdBLA;
	}

	public Integer getPwdBLOA() {
		return pwdBLOA;
	}

	public void setPwdBLOA(Integer pwdBLOA) {
		this.pwdBLOA = pwdBLOA;
	}

	public Integer getPwdCPaisy() {
		return pwdCPaisy;
	}

	public void setPwdCPaisy(Integer pwdCPaisy) {
		this.pwdCPaisy = pwdCPaisy;
	}

	public Integer getPwdLCured() {
		return pwdLCured;
	}

	public void setPwdLCured(Integer pwdLCured) {
		this.pwdLCured = pwdLCured;
	}

	public Integer getPwdDwarfism() {
		return pwdDwarfism;
	}

	public void setPwdDwarfism(Integer pwdDwarfism) {
		this.pwdDwarfism = pwdDwarfism;
	}

	public Integer getPwdAAVictims() {
		return pwdAAVictims;
	}

	public void setPwdAAVictims(Integer pwdAAVictims) {
		this.pwdAAVictims = pwdAAVictims;
	}

	public Integer getPwdMDystrophy() {
		return pwdMDystrophy;
	}

	public void setPwdMDystrophy(Integer pwdMDystrophy) {
		this.pwdMDystrophy = pwdMDystrophy;
	}

	public Integer getPwdOthers() {
		return pwdOthers;
	}

	public void setPwdOthers(Integer pwdOthers) {
		this.pwdOthers = pwdOthers;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}



	
	
}
