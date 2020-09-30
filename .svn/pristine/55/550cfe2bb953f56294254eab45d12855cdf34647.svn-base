package in.hkcl.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
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

import in.hkcl.dao.CourtCaseDaoImpl;
import in.hkcl.utils.ApplicationLogFactory;
import in.hkcl.utils.ApplicationLogger;
import in.hkcl.utils.CommonUtils;

@Entity
@Table(name = "courtcasedetails")
public class CourtCaseDetails implements Serializable{

	private static ApplicationLogger logger = ApplicationLogFactory.getLogger(CourtCaseDetails.class);
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "caseId", unique = true, nullable = false)	
	private Integer caseId;
	
	@Column(name = "sRNo")
	private Integer sRNo;
	
	@Column(name = "writNo")
	private Integer writNo;
	
	@Column(name="advtNo")
	private String advtNo;
	
	@Column(name = "caseType")
	private String caseType;
	
	@Column(name = "fileNo")
	private Integer fileNo;
	
	@Column(name = "caseStatus")
	private String caseStatus;
	
	@Column(name = "caseIn")
	private String caseIn;
	
	@Column(name = "year")
	private String year;
	
	@Column(name = "concernedAssistant")
	private String concernedAssistant;
	
	@Column(name = "legalIssue")
	private String legalIssue;
	
	@Column(name = "otherLegalIssue")
	private String otherLegalIssue;
	
	@Column(name = "main_similarCase")
	private String main_similarCase;
	
	@Column (name = "letterReceivedFrom_Ag_Lr")
	private String letterReceivedFrom_Ag_Lr;
	
	
	@Column (name = "letterDate")
	 private String letterDate;
	
	@Column (name = "replyFiledDate")
	 private String replyFiledDate;
	
	@Column(name="replyFrom_Ag_Lr")
	private String replyFrom_Ag_Lr;
	
	
	@Column(name="replyFrom_Ag_LrStatus")
	private String replyFrom_Ag_LrStatus;
	
	@Column(name="detailedReplyFrom_Ag_Lr")
	private String detailedReplyFrom_Ag_Lr;
	
	
	@Column(name = "paperBookReceived")
	private String paperBookReceived;
	
	@Column(name = "stay")
	private String stay;
	
	@Column(name = "stayDetails")
	private String stayDetails;
	
	@Column(name = "remarks_InterimOrder")
	private String remarks_InterimOrder;
	
	@Column(name = "priority")
	private String priority;
	
	@Column(name = "detailedStatus")
	private String detailedStatus;
	
	@Column(name="commissionRespondentNo ")
	private Integer commissionRespondentNo;
	
	@Column(name="courtLocation")
	private String courtLocation;
	
	@Column(name="purposeOfLetter")
	private String purposeOfLetter;
	
	@Column(name="versus")
	private String versus;
	
	@Column(name="uniqueCaseId")
	private String uniqueCaseId;
	
	@Transient
	private String petitioners;
	
	@Transient
	private String dateList;
	
	@Transient
	private Integer userId;

	
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "caseId", targetEntity = PetitionerDetails.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<PetitionerDetails> petitionerDetailsList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "caseId", targetEntity = HearingDetails.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<HearingDetails> hearingDetailsList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "caseId", targetEntity = CivilMiscellaneousDetails.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<CivilMiscellaneousDetails> civilMiscellaneousDetailsList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "caseId", targetEntity = SimilarCases.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<SimilarCases> similarCasesList;
	
	@LazyCollection(LazyCollectionOption.FALSE)	
	@OneToMany(mappedBy = "caseId", targetEntity = InterimOrderDetails.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<InterimOrderDetails> interimOrderList;
	
	@OneToOne(targetEntity = Police.class)
	@JoinColumn(name = "sRNo", referencedColumnName = "sRNo", nullable = false, insertable = false, updatable = false)
	private Police policeDetailsObj;
	
	

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public Integer getsRNo() {
		return sRNo;
	}

	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}

	public Integer getWritNo() {
		return writNo;
	}

	public void setWritNo(Integer writNo) {
		this.writNo = writNo;
	}


	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public Integer getFileNo() {
		return fileNo;
	}

	public void setFileNo(Integer fileNo) {
		this.fileNo = fileNo;
	}

	public String getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}

	public String getCaseIn() {
		return caseIn;
	}

	public void setCaseIn(String caseIn) {
		this.caseIn = caseIn;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getConcernedAssistant() {
		return concernedAssistant;
	}

	public void setConcernedAssistant(String concernedAssistant) {
		this.concernedAssistant = concernedAssistant;
	}

	public String getLegalIssue() {
		return legalIssue;
	}

	public void setLegalIssue(String legalIssue) {
		this.legalIssue = legalIssue;
	}

	public String getMain_similarCase() {
		return main_similarCase;
	}

	public void setMain_similarCase(String main_similarCase) {
		this.main_similarCase = main_similarCase;
	}

	public String getLetterReceivedFrom_Ag_Lr() {
		return letterReceivedFrom_Ag_Lr;
	}

	public void setLetterReceivedFrom_Ag_Lr(String letterReceivedFrom_Ag_Lr) {
		this.letterReceivedFrom_Ag_Lr = letterReceivedFrom_Ag_Lr;
	}

	

	public String getReplyFrom_Ag_Lr() {
		return replyFrom_Ag_Lr;
	}

	public void setReplyFrom_Ag_Lr(String replyFrom_Ag_Lr) {
		this.replyFrom_Ag_Lr = replyFrom_Ag_Lr;
	}

	
	public String getReplyFrom_Ag_LrStatus() {
		return replyFrom_Ag_LrStatus;
	}

	public void setReplyFrom_Ag_LrStatus(String replyFrom_Ag_LrStatus) {
		this.replyFrom_Ag_LrStatus = replyFrom_Ag_LrStatus;
	}

	public String getDetailedReplyFrom_Ag_Lr() {
		return detailedReplyFrom_Ag_Lr;
	}

	public void setDetailedReplyFrom_Ag_Lr(String detailedReplyFrom_Ag_Lr) {
		this.detailedReplyFrom_Ag_Lr = detailedReplyFrom_Ag_Lr;
	}
	

	public String getPaperBookReceived() {
		return paperBookReceived;
	}

	public void setPaperBookReceived(String paperBookReceived) {
		this.paperBookReceived = paperBookReceived;
	}

	public String getStay() {
		return stay;
	}

	public void setStay(String stay) {
		this.stay = stay;
	}

	public String getStayDetails() {
		return stayDetails;
	}

	public void setStayDetails(String stayDetails) {
		this.stayDetails = stayDetails;
	}

	public String getRemarks_InterimOrder() {
		return remarks_InterimOrder;
	}

	public void setRemarks_InterimOrder(String remarks_InterimOrder) {
		this.remarks_InterimOrder = remarks_InterimOrder;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDetailedStatus() {
		return detailedStatus;
	}

	public void setDetailedStatus(String detailedStatus) {
		this.detailedStatus = detailedStatus;
	}

	public List<PetitionerDetails> getPetitionerDetailsList() {
		return petitionerDetailsList;
	}

	public void setPetitionerDetailsList(List<PetitionerDetails> petitionerDetailsList) {
		this.petitionerDetailsList = petitionerDetailsList;
	}

	public List<HearingDetails> getHearingDetailsList() {
		return hearingDetailsList;
	}

	public void setHearingDetailsList(List<HearingDetails> hearingDetailsList) {
		this.hearingDetailsList = hearingDetailsList;
	}

	public Police getPoliceDetailsObj() {
		return policeDetailsObj;
	}

	public void setPoliceDetailsObj(Police policeDetailsObj) {
		this.policeDetailsObj = policeDetailsObj;
	}

	public String getLetterDate() {
		return letterDate;
	}

	public void setLetterDate(String letterDate) {
		this.letterDate = letterDate;
	}
	public String getReplyFiledDate() {
		return replyFiledDate;
	}

	public void setReplyFiledDate(String replyFiledDate) {
		this.replyFiledDate = replyFiledDate;
	}
	
	

	public Integer getCommissionRespondentNo() {
		return commissionRespondentNo;
	}

	public void setCommissionRespondentNo(Integer commissionRespondentNo) {
		this.commissionRespondentNo = commissionRespondentNo;
	}

	
	public String getCourtLocation() {
		return courtLocation;
	}

	public void setCourtLocation(String courtLocation) {
		this.courtLocation = courtLocation;
	}

	public String getPetitioners() {
		String result="";
		List<String> nameList=new ArrayList<String>();
		if (CommonUtils.isNotEmpty(this.petitionerDetailsList)) {
		
		for (PetitionerDetails s : this.petitionerDetailsList)
		{	if(CommonUtils.isNotEmpty(s.getName())){
			nameList.add(s.getName());
		}
		}
	}
		Iterator<String> it = nameList.iterator();
		if (it.hasNext()) {
			result += it.next();
			
		}
		while (it.hasNext()) {
			result +=  ",\n"+it.next() ;
			
		}
		return result;
	}

	public void setPetitioners(String petitioners) {
		this.petitioners = petitioners;
	}

	public String getDateList() throws ParseException {
		List<Date> dtList=new ArrayList<Date>();
		try {
		String ds2=null;
		if (CommonUtils.isNotEmpty(hearingDetailsList))
		{
		 for (HearingDetails s : hearingDetailsList)
		  {	
		    if(CommonUtils.isNotEmpty(s.getDate()))
			 {
			   dtList.add(s.getDate());
		     }
		  }
		   Collections.sort(dtList, Collections.reverseOrder());
		   
		   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		   String strDate = dateFormat.format(dtList.get(0));  

		   SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		   SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		   
		    ds2 = sdf2.format(sdf1.parse(strDate));		 		
	    }  
		
		if(CommonUtils.isNotEmpty(ds2)){
		return ds2;
		}else{
			return null;
		}
		}catch(Exception e) {
			logger.logError("error in courtCaseDetails Model", e);
			System.out.println(this.caseId);
		}
		return null;
	}
	

	public void setDateList(String dateList) {
		this.dateList = dateList;
	}

	public List<CivilMiscellaneousDetails> getCivilMiscellaneousDetailsList() {
		return civilMiscellaneousDetailsList;
	}

	public void setCivilMiscellaneousDetailsList(List<CivilMiscellaneousDetails> civilMiscellaneousDetailsList) {
		this.civilMiscellaneousDetailsList = civilMiscellaneousDetailsList;
	}

	public List<SimilarCases> getSimilarCasesList() {
		return similarCasesList;
	}

	public void setSimilarCasesList(List<SimilarCases> similarCasesList) {
		this.similarCasesList = similarCasesList;
	}

	public String getPurposeOfLetter() {
		return purposeOfLetter;
	}

	public void setPurposeOfLetter(String purposeOfLetter) {
		this.purposeOfLetter = purposeOfLetter;
	}

	public List<InterimOrderDetails> getInterimOrderList() {
		return interimOrderList;
	}

	public void setInterimOrderList(List<InterimOrderDetails> interimOrderList) {
		this.interimOrderList = interimOrderList;
	}

	public String getVersus() {
		return versus;
	}

	public void setVersus(String versus) {
		this.versus = versus;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAdvtNo() {
		return advtNo;
	}

	public void setAdvtNo(String advtNo) {
		this.advtNo = advtNo;
	}

	public String getHearingTrans() {
		String hearingDetailsTransList = "";
		if (CommonUtils.isNotEmpty(this.hearingDetailsList)) {
			for (HearingDetails s : this.hearingDetailsList)
			{
				hearingDetailsTransList += s.getDate() + ",";
			}
		}
		return hearingDetailsTransList;
	}

	

	public String getOtherLegalIssue() {
		return otherLegalIssue;
	}

	public void setOtherLegalIssue(String otherLegalIssue) {
		this.otherLegalIssue = otherLegalIssue;
	}

	public String getUniqueCaseId() {
		return uniqueCaseId;
	}

	public void setUniqueCaseId(String uniqueCaseId) {
		this.uniqueCaseId = uniqueCaseId;
	}	

	
	
}
