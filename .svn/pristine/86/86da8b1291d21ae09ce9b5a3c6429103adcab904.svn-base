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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="requisitioninforemarks")
public class RequisitionInfoRemarks implements Serializable{
	
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idRequisitionRemark", unique = true, nullable = false)
	private Integer idRequisitionRemark;
	
	@Column(name = "idRequisition")
	private Integer idRequisition;
	
	@Column(name="designationOfPostRemark")
	private String designationOfPostRemark;
	
	@Column(name="numberOfPostToBeFilledRemark")
	private String numberOfPostToBeFilledRemark;
	
	@Column(name="classAndServiceOfPostRemark")
	private String classAndServiceOfPostRemark;
	
	@Column(name="anyPublishedRulesForServiceRemark")
	private String anyPublishedRulesForServiceRemark;
	
	@Column(name="linkForServiceRulesRemark")
	private String linkForServiceRulesRemark;
	
	@Column(name="isPostPermanentOrTemporaryRemark")
	private String isPostPermanentOrTemporaryRemark;
	
	@Column(name="scaleOfPayForDirectRecruitsRemark")
	private String scaleOfPayForDirectRecruitsRemark;

	@Column(name="scaleOfPayForPersonsAlreadyInGovernmentServiceRemark")
	private String scaleOfPayForPersonsAlreadyInGovernmentServiceRemark;
	
	@Column(name="higherInitialPayBeGrantedRemark")
	private String higherInitialPayBeGrantedRemark;
	
	@Column(name="anySpecialConcessionsForNonAsiaticDomicileRemark")
	private String anySpecialConcessionsForNonAsiaticDomicileRemark;
	
	@Column(name="academicQualificationsRemark")
	private String academicQualificationsRemark;
	
	@Column(name="trainingRemark")
	private String trainingRemark;
	
	@Column(name="hindiQualificationRemark")
	private String hindiQualificationRemark;
	
	@Column(name="experienceRemark")
	private String experienceRemark;
	
	@Column(name="isExperienceTakenIntoConsidrationRemark")
	private String isExperienceTakenIntoConsidrationRemark;
	
	@Column(name="anyOtherQualificationsRemark")
	private String anyOtherQualificationsRemark;
	
	@Column(name="requirementsStrictlyAtheredRemark")
	private String requirementsStrictlyAtheredRemark;
	
	@Column(name="equivalentQualificationsRemark")
	private  String equivalentQualificationsRemark; 
	
	@Column(name="lowerAgeLimitRemark")
	private String lowerAgeLimitRemark;
	
	@Column(name="upperAgeLimitRemark")
	private String upperAgeLimitRemark;
	
	@Column(name="dateOnWhichAgeIsDeterminedRemark")
	private String dateOnWhichAgeIsDeterminedRemark;
	
	@Column(name="anyRelaxationForGovServentsRemark")
	private String anyRelaxationForGovServentsRemark;
	
	@Column(name="anyRelaxationForSutaibleCandidatesRemark")
	private String anyRelaxationForSutaibleCandidatesRemark;
	
	@Column(name="areGovServantsEligibleRemark")
	private String areGovServantsEligibleRemark;
	
	
	@Column(name="nameOfOfficerForAdvisoryCapacityRemark")
	private String nameOfOfficerForAdvisoryCapacityRemark;
	
	@Column(name="nameOfNodalOfficerRemark")
	private String nameOfNodalOfficerRemark;
	
	@Column(name="phoneNumberOfNodelOfficerRemark")
	private String phoneNumberOfNodelOfficerRemark;
	
	@Column(name="conditionOrQualificationNotCoveredAboveRemark")
	private String conditionOrQualificationNotCoveredAboveRemark;
	
	@Column(name="backlogRemark")
	private String backlogRemark;
	
	@Column(name="requisitionReservationInfoRemark")
	private String requisitionReservationInfoRemark;
	
	@Column(name="requisitionDocsRemark")
	private String requisitionDocsRemark;
	
	@Column(name="isRequisitionApprovedOrNot")
	private boolean isRequisitionApprovedOrNot;
	
	@Column(name="jobDescriptionRemark")
	private String jobDescriptionRemark;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="lastUpdateDateAndTime") 
	private Date lastUpdateDateAndTime;
	
	@OneToOne(targetEntity = RequisitionInfo.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "idRequisition", referencedColumnName = "idRequisition", nullable = false, insertable = false, updatable = false)
	private RequisitionInfo reqObj;

	public Integer getIdRequisitionRemark() {
		return idRequisitionRemark;
	}

	public void setIdRequisitionRemark(Integer idRequisitionRemark) {
		this.idRequisitionRemark = idRequisitionRemark;
	}

	public Integer getIdRequisition() {
		return idRequisition;
	}

	public void setIdRequisition(Integer idRequisition) {
		this.idRequisition = idRequisition;
	}

	public String getDesignationOfPostRemark() {
		return designationOfPostRemark;
	}

	public void setDesignationOfPostRemark(String designationOfPostRemark) {
		this.designationOfPostRemark = designationOfPostRemark;
	}

	public String getNumberOfPostToBeFilledRemark() {
		return numberOfPostToBeFilledRemark;
	}

	public void setNumberOfPostToBeFilledRemark(String numberOfPostToBeFilledRemark) {
		this.numberOfPostToBeFilledRemark = numberOfPostToBeFilledRemark;
	}

	public String getClassAndServiceOfPostRemark() {
		return classAndServiceOfPostRemark;
	}

	public void setClassAndServiceOfPostRemark(String classAndServiceOfPostRemark) {
		this.classAndServiceOfPostRemark = classAndServiceOfPostRemark;
	}

	public String getAnyPublishedRulesForServiceRemark() {
		return anyPublishedRulesForServiceRemark;
	}

	public void setAnyPublishedRulesForServiceRemark(String anyPublishedRulesForServiceRemark) {
		this.anyPublishedRulesForServiceRemark = anyPublishedRulesForServiceRemark;
	}

	public String getLinkForServiceRulesRemark() {
		return linkForServiceRulesRemark;
	}

	public void setLinkForServiceRulesRemark(String linkForServiceRulesRemark) {
		this.linkForServiceRulesRemark = linkForServiceRulesRemark;
	}

	public String getIsPostPermanentOrTemporaryRemark() {
		return isPostPermanentOrTemporaryRemark;
	}

	public void setIsPostPermanentOrTemporaryRemark(String isPostPermanentOrTemporaryRemark) {
		this.isPostPermanentOrTemporaryRemark = isPostPermanentOrTemporaryRemark;
	}

	public String getScaleOfPayForDirectRecruitsRemark() {
		return scaleOfPayForDirectRecruitsRemark;
	}

	public void setScaleOfPayForDirectRecruitsRemark(String scaleOfPayForDirectRecruitsRemark) {
		this.scaleOfPayForDirectRecruitsRemark = scaleOfPayForDirectRecruitsRemark;
	}

	public String getScaleOfPayForPersonsAlreadyInGovernmentServiceRemark() {
		return scaleOfPayForPersonsAlreadyInGovernmentServiceRemark;
	}

	public void setScaleOfPayForPersonsAlreadyInGovernmentServiceRemark(
			String scaleOfPayForPersonsAlreadyInGovernmentServiceRemark) {
		this.scaleOfPayForPersonsAlreadyInGovernmentServiceRemark = scaleOfPayForPersonsAlreadyInGovernmentServiceRemark;
	}

	public String getHigherInitialPayBeGrantedRemark() {
		return higherInitialPayBeGrantedRemark;
	}

	public void setHigherInitialPayBeGrantedRemark(String higherInitialPayBeGrantedRemark) {
		this.higherInitialPayBeGrantedRemark = higherInitialPayBeGrantedRemark;
	}

	public String getAnySpecialConcessionsForNonAsiaticDomicileRemark() {
		return anySpecialConcessionsForNonAsiaticDomicileRemark;
	}

	public void setAnySpecialConcessionsForNonAsiaticDomicileRemark(
			String anySpecialConcessionsForNonAsiaticDomicileRemark) {
		this.anySpecialConcessionsForNonAsiaticDomicileRemark = anySpecialConcessionsForNonAsiaticDomicileRemark;
	}

	public String getAcademicQualificationsRemark() {
		return academicQualificationsRemark;
	}

	public void setAcademicQualificationsRemark(String academicQualificationsRemark) {
		this.academicQualificationsRemark = academicQualificationsRemark;
	}

	public String getTrainingRemark() {
		return trainingRemark;
	}

	public void setTrainingRemark(String trainingRemark) {
		this.trainingRemark = trainingRemark;
	}

	public String getHindiQualificationRemark() {
		return hindiQualificationRemark;
	}

	public void setHindiQualificationRemark(String hindiQualificationRemark) {
		this.hindiQualificationRemark = hindiQualificationRemark;
	}

	public String getExperienceRemark() {
		return experienceRemark;
	}

	public void setExperienceRemark(String experienceRemark) {
		this.experienceRemark = experienceRemark;
	}

	public String getIsExperienceTakenIntoConsidrationRemark() {
		return isExperienceTakenIntoConsidrationRemark;
	}

	public void setIsExperienceTakenIntoConsidrationRemark(String isExperienceTakenIntoConsidrationRemark) {
		this.isExperienceTakenIntoConsidrationRemark = isExperienceTakenIntoConsidrationRemark;
	}

	public String getAnyOtherQualificationsRemark() {
		return anyOtherQualificationsRemark;
	}

	public void setAnyOtherQualificationsRemark(String anyOtherQualificationsRemark) {
		this.anyOtherQualificationsRemark = anyOtherQualificationsRemark;
	}

	public String getRequirementsStrictlyAtheredRemark() {
		return requirementsStrictlyAtheredRemark;
	}

	public void setRequirementsStrictlyAtheredRemark(String requirementsStrictlyAtheredRemark) {
		this.requirementsStrictlyAtheredRemark = requirementsStrictlyAtheredRemark;
	}

	public String getEquivalentQualificationsRemark() {
		return equivalentQualificationsRemark;
	}

	public void setEquivalentQualificationsRemark(String equivalentQualificationsRemark) {
		this.equivalentQualificationsRemark = equivalentQualificationsRemark;
	}

	public String getLowerAgeLimitRemark() {
		return lowerAgeLimitRemark;
	}

	public void setLowerAgeLimitRemark(String lowerAgeLimitRemark) {
		this.lowerAgeLimitRemark = lowerAgeLimitRemark;
	}

	public String getUpperAgeLimitRemark() {
		return upperAgeLimitRemark;
	}

	public void setUpperAgeLimitRemark(String upperAgeLimitRemark) {
		this.upperAgeLimitRemark = upperAgeLimitRemark;
	}

	public String getDateOnWhichAgeIsDeterminedRemark() {
		return dateOnWhichAgeIsDeterminedRemark;
	}

	public void setDateOnWhichAgeIsDeterminedRemark(String dateOnWhichAgeIsDeterminedRemark) {
		this.dateOnWhichAgeIsDeterminedRemark = dateOnWhichAgeIsDeterminedRemark;
	}

	public String getAnyRelaxationForGovServentsRemark() {
		return anyRelaxationForGovServentsRemark;
	}

	public void setAnyRelaxationForGovServentsRemark(String anyRelaxationForGovServentsRemark) {
		this.anyRelaxationForGovServentsRemark = anyRelaxationForGovServentsRemark;
	}

	public String getAnyRelaxationForSutaibleCandidatesRemark() {
		return anyRelaxationForSutaibleCandidatesRemark;
	}

	public void setAnyRelaxationForSutaibleCandidatesRemark(String anyRelaxationForSutaibleCandidatesRemark) {
		this.anyRelaxationForSutaibleCandidatesRemark = anyRelaxationForSutaibleCandidatesRemark;
	}

	public String getAreGovServantsEligibleRemark() {
		return areGovServantsEligibleRemark;
	}

	public void setAreGovServantsEligibleRemark(String areGovServantsEligibleRemark) {
		this.areGovServantsEligibleRemark = areGovServantsEligibleRemark;
	}

	public String getNameOfOfficerForAdvisoryCapacityRemark() {
		return nameOfOfficerForAdvisoryCapacityRemark;
	}

	public void setNameOfOfficerForAdvisoryCapacityRemark(String nameOfOfficerForAdvisoryCapacityRemark) {
		this.nameOfOfficerForAdvisoryCapacityRemark = nameOfOfficerForAdvisoryCapacityRemark;
	}

	public String getNameOfNodalOfficerRemark() {
		return nameOfNodalOfficerRemark;
	}

	public void setNameOfNodalOfficerRemark(String nameOfNodalOfficerRemark) {
		this.nameOfNodalOfficerRemark = nameOfNodalOfficerRemark;
	}

	public String getPhoneNumberOfNodelOfficerRemark() {
		return phoneNumberOfNodelOfficerRemark;
	}

	public void setPhoneNumberOfNodelOfficerRemark(String phoneNumberOfNodelOfficerRemark) {
		this.phoneNumberOfNodelOfficerRemark = phoneNumberOfNodelOfficerRemark;
	}

	public String getConditionOrQualificationNotCoveredAboveRemark() {
		return conditionOrQualificationNotCoveredAboveRemark;
	}

	public void setConditionOrQualificationNotCoveredAboveRemark(String conditionOrQualificationNotCoveredAboveRemark) {
		this.conditionOrQualificationNotCoveredAboveRemark = conditionOrQualificationNotCoveredAboveRemark;
	}

	public String getBacklogRemark() {
		return backlogRemark;
	}

	public void setBacklogRemark(String backlogRemark) {
		this.backlogRemark = backlogRemark;
	}

	public String getRequisitionReservationInfoRemark() {
		return requisitionReservationInfoRemark;
	}

	public void setRequisitionReservationInfoRemark(String requisitionReservationInfoRemark) {
		this.requisitionReservationInfoRemark = requisitionReservationInfoRemark;
	}

	public String getRequisitionDocsRemark() {
		return requisitionDocsRemark;
	}

	public void setRequisitionDocsRemark(String requisitionDocsRemark) {
		this.requisitionDocsRemark = requisitionDocsRemark;
	}

	public RequisitionInfo getReqObj() {
		return reqObj;
	}

	public void setReqObj(RequisitionInfo reqObj) {
		this.reqObj = reqObj;
	}

	public boolean isRequisitionApprovedOrNot() {
		return isRequisitionApprovedOrNot;
	}

	public void setRequisitionApprovedOrNot(boolean isRequisitionApprovedOrNot) {
		this.isRequisitionApprovedOrNot = isRequisitionApprovedOrNot;
	}

	public Date getLastUpdateDateAndTime() {
		return lastUpdateDateAndTime;
	}

	public void setLastUpdateDateAndTime(Date lastUpdateDateAndTime) {
		this.lastUpdateDateAndTime = lastUpdateDateAndTime;
	}

	public String getJobDescriptionRemark() {
		return jobDescriptionRemark;
	}

	public void setJobDescriptionRemark(String jobDescriptionRemark) {
		this.jobDescriptionRemark = jobDescriptionRemark;
	}

	

	

	
	
	
}
