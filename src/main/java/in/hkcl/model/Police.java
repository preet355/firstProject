package in.hkcl.model;

import java.io.Serializable;
import java.text.DateFormat;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import in.hkcl.utils.ApplicationLogFactory;
import in.hkcl.utils.ApplicationLogger;
import in.hkcl.utils.CommonUtils;


@Entity
@Table(name = "police")
public class Police implements Serializable {
	
	private static ApplicationLogger logger = ApplicationLogFactory.getLogger(Police.class);

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sRNo", unique = true, nullable = false)
	private Integer sRNo;

	@Column(name = "aDvtNo")
	private String aDvtNo;

	@Column(name = "aDvtId")
	private Integer aDvtId;

	@Column(name = "cAtNo")
	private Integer cAtNo;

	@Column(name = "cAtId")
	private Integer cAtId;

	@Column(name = "dEpartmentId")
	private Integer dEpartmentId;

	/*
	 * @Column(name ="dEpartment") private String dEpartment;
	 */
	@Column(name = "nAmeOfPost")
	private String nAmeOfPost;

	@Column(name = "nOOfPosts")
	private Integer nOOfPosts;

	@Column(name = "mAcroStatus")
	private String mAcroStatus;

	@Column(name = "nExtStep")
	private String nExtStep;
	
	@Column(name="currentStep")
	private String currentStep;

	@Column(name = "cAndidatesRecommended")
	private Integer cAndidatesRecommended;

	@Column(name = "tOtalNoOfApplications")
	private Integer tOtalNoOfApplications;

	@Column(name="nOOfPeopleAttendingExam")
	private Integer nOOfPeopleAttendingExam;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "aDvertisementPosted")
	private Date aDvertisementPosted;

	@Temporal(TemporalType.DATE)
	@Column(name = "aPplicationsOpen")
	private Date aPplicationsOpen;

	@Temporal(TemporalType.DATE)
	@Column(name = "aPplicationsClose")
	private Date aPplicationsClose;

	@Temporal(TemporalType.DATE)
	@Column(name = "aDmitCards")
	private Date aDmitCards;

	@Temporal(TemporalType.DATE)
	@Column(name = "pStStart")
	private Date pStStart;

	@Temporal(TemporalType.DATE)
	@Column(name = "pStEnd")
	private Date pStEnd;

	@Temporal(TemporalType.DATE)
	@Column(name = "rEsultOfPst")
	private Date rEsultOfPst;

	@Temporal(TemporalType.DATE)
	@Column(name = "wRittenExam")
	private Date wRittenExam;

	@Column(name = "wRittenExamSession")
	private String wRittenExamSession;

	@Temporal(TemporalType.DATE)
	@Column(name = "uPloadingAnswerKey")
	private Date uPloadingAnswerKey;

	@Temporal(TemporalType.DATE)
	@Column(name = "oBjectionsOpen")
	private Date oBjectionsOpen;

	@Temporal(TemporalType.DATE)
	@Column(name = "oBjectionsClose")
	private Date oBjectionsClose;

	@Temporal(TemporalType.DATE)
	@Column(name = "uPloadedRevisedAnswerKey")
	private Date uPloadedRevisedAnswerKey;

	@Temporal(TemporalType.DATE)
	@Column(name = "rEsultOfWrittenExam")
	private Date rEsultOfWrittenExam;

	@Temporal(TemporalType.DATE)
	@Column(name = "sCrutinyStartDate")
	private Date sCrutinyStartDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "sCrutinyEndDate")
	private Date sCrutinyEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "sCrutinyResults")
	private Date sCrutinyResults;

	@Temporal(TemporalType.DATE)
	@Column(name = "pMtHeightChest")
	private Date pMtHeightChest;

	@Temporal(TemporalType.DATE)
	@Column(name = "rEsultOfPmtHeightChest")
	private Date rEsultOfPmtHeightChest;

	@Temporal(TemporalType.DATE)
	@Column(name = "aDmitCardsForInterview")
	private Date aDmitCardsForInterview;

	@Temporal(TemporalType.DATE)
	@Column(name = "iNterviewsStartDate")
	private Date iNterviewsStartDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "iNterviewsEndDate")
	private Date iNterviewsEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "aNnouncementOfFinalResult")
	private Date aNnouncementOfFinalResult;

	@Temporal(TemporalType.DATE)
	@Column(name = "rEcommendedDate")
	private Date rEcommendedDate;

	@Column(name = "dEtailedStatus")
	private String dEtailedStatus;


	@OneToOne(targetEntity = Department.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "dEpartmentId", referencedColumnName = "dEpartmentId", nullable = false, insertable = false, updatable = false)
	private Department deptObj;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = AdvertisementPosted.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<AdvertisementPosted> advtPostedDateList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = AdmitCards.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<AdmitCards> admitCardsList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = AdmitCardsForInterview.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<AdmitCardsForInterview> admitCardsForInterviewList;
	
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = AnnouncementOfResults.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<AnnouncementOfResults> announcementOfResultsList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = ApplicationClosed.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<ApplicationClosed> applicationClosedList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = ApplicationOpen.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<ApplicationOpen> applicationOpenList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = InterviewEndDate.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<InterviewEndDate> interviewEndDateList;


	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = InterviewStartDate.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<InterviewStartDate> interviewStartDateList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = ObjectionsClosed.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<ObjectionsClosed> objectionsClosedList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = ObjectionsOpen.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<ObjectionsOpen> objectionsOpenList;
	
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = PMTHeightChest.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<PMTHeightChest> pMTHeightChestList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = PstEnd.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<PstEnd> pstEndList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = PstStart.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<PstStart> pstStartList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = RecommendedDate.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<RecommendedDate> recommendedDateList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = ResultOfPmtHeightChest.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<ResultOfPmtHeightChest> resultOfPmtHeightChestList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = ResultOfPst.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<ResultOfPst> resultOfPstList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = ResultOfWrittenExam.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<ResultOfWrittenExam> resultOfWrittenExamList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = ScrutinyEndDate.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<ScrutinyEndDate> scrutinyEndDateList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = ScrutinyResults.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<ScrutinyResults> scrutinyResultsList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = ScrutinyStartDate.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<ScrutinyStartDate> scrutinyStartDateList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = UploadedRevisedAnswerKey.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<UploadedRevisedAnswerKey> uploadedRevisedAnswerKeyList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = UploadingAnswerKey.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<UploadingAnswerKey> uploadingAnswerKeyList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = WrittenExam.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<WrittenExam> writtenExamList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = DepartmentDocs.class, cascade = { CascadeType.ALL })
	@OnDelete(action= OnDeleteAction.CASCADE)
	private List<DepartmentDocs> departmentDocsList;
	
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "sRNo", targetEntity = CourtCaseDetails.class)
	private List<CourtCaseDetails> writNoList;
	
	@Transient
	String writNo;
	
	
	@Transient
	String advtPostedTrans;
	
	
	@Transient
	String appOpenTrans;
	
	
	@Transient
	String appCloseTrans;
	
	@Transient
	String admitCardTrans;
	
	@Transient
	String pstStartTrans;
	
	@Transient
	String pstEndTrans;
	
	@Transient
	String resultOfPstTrans;
	
	@Transient
	String writtenExamTrans;
	
	@Transient
	String uploadingAnswerKeyTrans;
	
	@Transient
	String objectionOpenTrans;
	
	@Transient
	String objectionCloseTrans;
	
	@Transient
	String uploadedRevisedAnswerKeyTrans;
	
	@Transient
	String resultOfWrittenExamTrans;
	
	@Transient
	String scrutinyStartTrans;
	
	@Transient
	String scrutinyEndTrans;
	
	@Transient
	String sCrutinyResultsTrans;
	
	@Transient
	String pMtHeightChestTrans;
	
	@Transient
	String rEsultOfPmtHeightChestTrans;
	
	@Transient
	String aDmitCardsForInterviewTrans;
	
	@Transient
	String iNterviewsStartDateTrans;
	
	@Transient
	String iNterviewsEndDateTrans;
	
	@Transient
	String aNnouncementOfFinalResultTrans;
	
	@Transient
	String rEcommendedDateTrans;
	
	@Transient
	String deptName;
	
	@Transient 
	Integer userId;
	
	@Transient
	private String advtpostDates;
	
/*-----------------------------------------------------Transients-------------------------------------------------*/	
	public String getAdvtPostedTrans() {
		
		String advtPostedTransList = "";
		if (CommonUtils.isNotEmpty(this.advtPostedDateList)) {
			for (AdvertisementPosted s : this.advtPostedDateList)
			{
				advtPostedTransList += s.getAdvertisementPosted() + ",";
			}
		}
		return advtPostedTransList;
	}


	public void setAdvtPostedTrans(String advtPostedTrans) {
		this.advtPostedTrans = advtPostedTrans;
	}
	

	public String getAppOpenTrans() {
		String appOpenTransList = "";
		if (CommonUtils.isNotEmpty(this.applicationOpenList)) {
			for (ApplicationOpen s : this.applicationOpenList)
			{
				appOpenTransList += s.getApplicationopen() + ",";
			}
		}
		return appOpenTransList;
	}


	public void setAppOpenTrans(String appOpenTrans) {
		this.appOpenTrans = appOpenTrans;
	}


	public String getAppCloseTrans() {
		String appCloseTransList = "";
		if (CommonUtils.isNotEmpty(this.applicationClosedList)) {
			for (ApplicationClosed s : this.applicationClosedList)
			{
				appCloseTransList += s.getApplicationclosed() + ",";
			}
		}
		return appCloseTransList;
	}


	public void setAppCloseTrans(String appCloseTrans) {
		this.appCloseTrans = appCloseTrans;
	}


	public String getAdmitCardTrans() {
		String admitCardTransList = "";
		if (CommonUtils.isNotEmpty(this.admitCardsList)) {
			for (AdmitCards s : this.admitCardsList)
			{
				admitCardTransList += s.getAdmitcard() + ",";
			}
		}
		return admitCardTransList;
	}


	public void setAdmitCardTrans(String admitCardTrans) {
		this.admitCardTrans = admitCardTrans;
	}


	public String getPstStartTrans() {
		String pststartTransList = "";
		if (CommonUtils.isNotEmpty(this.pstStartList)) {
			for (PstStart s : this.pstStartList)
			{
				pststartTransList += s.getPststart() + ",";
			}
		}
		return pststartTransList;
	}


	public void setPstStartTrans(String pstStartTrans) {
		this.pstStartTrans = pstStartTrans;
	}


	public String getPstEndTrans() {
		String pstEndTransList = "";
		if (CommonUtils.isNotEmpty(this.pstEndList)) {
			for (PstEnd s : this.pstEndList)
			{
				pstEndTransList += s.getPstend() + ",";
			}
		}
		return pstEndTransList;
	}


	public void setPstEndTrans(String pstEndTrans) {
		this.pstEndTrans = pstEndTrans;
	}


	

	public String getResultOfPstTrans() {
		String resultOfPstTransList = "";
		if (CommonUtils.isNotEmpty(this.resultOfPstList)) {
			for (ResultOfPst s : this.resultOfPstList)
			{
				resultOfPstTransList += s.getResultofpst() + ",";
			}
		}
		return resultOfPstTransList;
	}


	public void setResultOfPstTrans(String resultOfPstTrans) {
		this.resultOfPstTrans = resultOfPstTrans;
	}


	public String getWrittenExamTrans() {
		String writtenExamTransList = "";
		if (CommonUtils.isNotEmpty(this.writtenExamList)) {
			for (WrittenExam s : this.writtenExamList)
			{
				writtenExamTransList += s.getWrittenExam() + ",";
			}
		}
		return writtenExamTransList;
	}


	public void setWrittenExamTrans(String writtenExamTrans) {
		this.writtenExamTrans = writtenExamTrans;
	}


	public String getUploadingAnswerKeyTrans() {
		String uploadingAnswerKeyTransList = "";
		if (CommonUtils.isNotEmpty(this.uploadingAnswerKeyList)) {
			for (UploadingAnswerKey s : this.uploadingAnswerKeyList)
			{
				uploadingAnswerKeyTransList += s.getUploadingAnswerKey() + ",";
			}
		}
		return uploadingAnswerKeyTransList;
	}


	public void setUploadingAnswerKeyTrans(String uploadingAnswerKeyTrans) {
		this.uploadingAnswerKeyTrans = uploadingAnswerKeyTrans;
	}


	public String getObjectionOpenTrans() {
		String objectionOpenTransList = "";
		if (CommonUtils.isNotEmpty(this.objectionsOpenList)) {
			for (ObjectionsOpen s : this.objectionsOpenList)
			{
				objectionOpenTransList += s.getObjectionsOpen() + ",";
			}
		}
		return objectionOpenTransList;
	}


	public void setObjectionOpenTrans(String objectionOpenTrans) {
		this.objectionOpenTrans = objectionOpenTrans;
	}


	public String getObjectionCloseTrans() {
		String objectionCloseTransList = "";
		if (CommonUtils.isNotEmpty(this.objectionsClosedList)) {
			for (ObjectionsClosed s : this.objectionsClosedList)
			{
				objectionCloseTransList += s.getObjectionsClosed() + ",";
			}
		}
		return objectionCloseTransList;
	}


	public void setObjectionCloseTrans(String objectionCloseTrans) {
		this.objectionCloseTrans = objectionCloseTrans;
	}


	public String getUploadedRevisedAnswerKeyTrans() {
		String uploadedRevisedAnswerKeyTransList = "";
		if (CommonUtils.isNotEmpty(this.uploadedRevisedAnswerKeyList)) {
			for (UploadedRevisedAnswerKey s : this.uploadedRevisedAnswerKeyList)
			{
				uploadedRevisedAnswerKeyTransList += s.getUploadedRevisedAnswerKey() + ",";
			}
		}
		return uploadedRevisedAnswerKeyTransList;
	}


	public void setUploadedRevisedAnswerKeyTrans(String uploadedRevisedAnswerKeyTrans) {
		this.uploadedRevisedAnswerKeyTrans = uploadedRevisedAnswerKeyTrans;
	}


	public String getResultOfWrittenExamTrans() {
		String resultOfWrittenExamTransList = "";
		if (CommonUtils.isNotEmpty(this.resultOfWrittenExamList)) {
			for (ResultOfWrittenExam s : this.resultOfWrittenExamList)
			{
				resultOfWrittenExamTransList += s.getResultOfWrittenExam() + ",";
			}
		}
		return resultOfWrittenExamTransList;
	}


	public void setResultOfWrittenExamTrans(String resultOfWrittenExamTrans) {
		this.resultOfWrittenExamTrans = resultOfWrittenExamTrans;
	}


	public String getScrutinyStartTrans() {
		String scrutinyStartTransList = "";
		if (CommonUtils.isNotEmpty(this.scrutinyStartDateList)) {
			for (ScrutinyStartDate s : this.scrutinyStartDateList)
			{
				scrutinyStartTransList += s.getScrutinyStartDate() + ",";
			}
		}
		return scrutinyStartTransList;
	}


	public void setScrutinyStartTrans(String scrutinyStartTrans) {
		this.scrutinyStartTrans = scrutinyStartTrans;
	}


	public String getScrutinyEndTrans() {
		String scrutinyEndTransList = "";
		if (CommonUtils.isNotEmpty(this.scrutinyEndDateList)) {
			for (ScrutinyEndDate s : this.scrutinyEndDateList)
			{
				scrutinyEndTransList += s.getScrutinyEndDate() + ",";
			}
		}
		return scrutinyEndTransList;
	}


	public void setScrutinyEndTrans(String scrutinyEndTrans) {
		this.scrutinyEndTrans = scrutinyEndTrans;
	}


	public String getsCrutinyResultsTrans() {
		String scrutinyResultTransList = "";
		if (CommonUtils.isNotEmpty(this.scrutinyResultsList)) {
			for (ScrutinyResults s : this.scrutinyResultsList)
			{
				scrutinyResultTransList += s.getScrutinyResults() + ",";
			}
		}
		return scrutinyResultTransList;
	}


	public void setsCrutinyResultsTrans(String sCrutinyResultsTrans) {
		this.sCrutinyResultsTrans = sCrutinyResultsTrans;
	}


	public String getpMtHeightChestTrans() {
		String pmtHeightChestTransList = "";
		if (CommonUtils.isNotEmpty(this.pMTHeightChestList)) {
			for (PMTHeightChest s : this.pMTHeightChestList)
			{
				pmtHeightChestTransList += s.getPmtHeightChest() + ",";
			}
		}
		return pmtHeightChestTransList;
	}


	public void setpMtHeightChestTrans(String pMtHeightChestTrans) {
		this.pMtHeightChestTrans = pMtHeightChestTrans;
	}


	public String getrEsultOfPmtHeightChestTrans() {
		String resultOfPmtHeightChestTransList = "";
		if (CommonUtils.isNotEmpty(this.resultOfPmtHeightChestList)) {
			for (ResultOfPmtHeightChest s : this.resultOfPmtHeightChestList)
			{
				resultOfPmtHeightChestTransList += s.getResultOfPmtHeightChest() + ",";
			}
		}
		return resultOfPmtHeightChestTransList;
	}


	public void setrEsultOfPmtHeightChestTrans(String rEsultOfPmtHeightChestTrans) {
		this.rEsultOfPmtHeightChestTrans = rEsultOfPmtHeightChestTrans;
	}


	public String getaDmitCardsForInterviewTrans() {
		String getadmitCardForInterviewTransList = "";
		if (CommonUtils.isNotEmpty(this.admitCardsForInterviewList)) {
			for (AdmitCardsForInterview s : this.admitCardsForInterviewList)
			{
				getadmitCardForInterviewTransList += s.getAdmitCardsForInterview() + ",";
			}
		}
		return getadmitCardForInterviewTransList;
	}


	public void setaDmitCardsForInterviewTrans(String aDmitCardsForInterviewTrans) {
		this.aDmitCardsForInterviewTrans = aDmitCardsForInterviewTrans;
	}


	public String getiNterviewsStartDateTrans() {
		
		String getiNterviewsStartDateTransList = "";
		if (CommonUtils.isNotEmpty(this.interviewStartDateList)) {
			for (InterviewStartDate s : this.interviewStartDateList)
			{
				getiNterviewsStartDateTransList += s.getInterviewStartDate() + ",";
			}
		}
		return getiNterviewsStartDateTransList;
	}


	public void setiNterviewsStartDateTrans(String iNterviewsStartDateTrans) {
		this.iNterviewsStartDateTrans = iNterviewsStartDateTrans;
	}


	public String getiNterviewsEndDateTrans() {
		String iNterviewsEndDateTransList = "";
		if (CommonUtils.isNotEmpty(this.interviewEndDateList)) {
			for (InterviewEndDate s : this.interviewEndDateList)
			{
				iNterviewsEndDateTransList += s.getInterviewEndDate() + ",";
			}
		}
		return iNterviewsEndDateTransList;
	}


	public void setiNterviewsEndDateTrans(String iNterviewsEndDateTrans) {
		this.iNterviewsEndDateTrans = iNterviewsEndDateTrans;
	}


	public String getaNnouncementOfFinalResultTrans() {
		String aNnouncementOfFinalResultTransList = "";
		if (CommonUtils.isNotEmpty(this.announcementOfResultsList)) {
			for (AnnouncementOfResults s : this.announcementOfResultsList)
			{
				aNnouncementOfFinalResultTransList += s.getAnnouncementOfResults() + ",";
			}
		}
		return aNnouncementOfFinalResultTransList;
	}


	public void setaNnouncementOfFinalResultTrans(String aNnouncementOfFinalResultTrans) {
		this.aNnouncementOfFinalResultTrans = aNnouncementOfFinalResultTrans;
	}


	public String getrEcommendedDateTrans() {
		String rEcommendedDateTransList = "";
		if (CommonUtils.isNotEmpty(this.recommendedDateList)) {
			for (RecommendedDate s : this.recommendedDateList)
			{
				rEcommendedDateTransList += s.getRecommendedDate() + ",";
			}
		}
		return rEcommendedDateTransList;
	}


	public void setrEcommendedDateTrans(String rEcommendedDateTrans) {
		this.rEcommendedDateTrans = rEcommendedDateTrans;
	}

	
/*-----------------------------------------------------------------------------------------------------------------*/

	

	public List<AdmitCardsForInterview> getAdmitCardsForInterviewList() {
		return admitCardsForInterviewList;
	}

	public void setAdmitCardsForInterviewList(List<AdmitCardsForInterview> admitCardsForInterviewList) {
		this.admitCardsForInterviewList = admitCardsForInterviewList;
	}


	public List<AnnouncementOfResults> getAnnouncementOfResultsList() {
		return announcementOfResultsList;
	}


	public void setAnnouncementOfResultsList(List<AnnouncementOfResults> announcementOfResultsList) {
		this.announcementOfResultsList = announcementOfResultsList;
	}


	public List<ApplicationClosed> getApplicationClosedList() {
		return applicationClosedList;
	}


	public void setApplicationClosedList(List<ApplicationClosed> applicationClosedList) {
		this.applicationClosedList = applicationClosedList;
	}


	public List<ApplicationOpen> getApplicationOpenList() {
		return applicationOpenList;
	}


	public void setApplicationOpenList(List<ApplicationOpen> applicationOpenList) {
		this.applicationOpenList = applicationOpenList;
	}


	public List<InterviewEndDate> getInterviewEndDateList() {
		return interviewEndDateList;
	}


	public void setInterviewEndDateList(List<InterviewEndDate> interviewEndDateList) {
		this.interviewEndDateList = interviewEndDateList;
	}


	public List<InterviewStartDate> getInterviewStartDateList() {
		return interviewStartDateList;
	}


	public void setInterviewStartDateList(List<InterviewStartDate> interviewStartDateList) {
		this.interviewStartDateList = interviewStartDateList;
	}


	public List<ObjectionsClosed> getObjectionsClosedList() {
		return objectionsClosedList;
	}


	public void setObjectionsClosedList(List<ObjectionsClosed> objectionsClosedList) {
		this.objectionsClosedList = objectionsClosedList;
	}


	public List<ObjectionsOpen> getObjectionsOpenList() {
		return objectionsOpenList;
	}


	public void setObjectionsOpenList(List<ObjectionsOpen> objectionsOpenList) {
		this.objectionsOpenList = objectionsOpenList;
	}




	public List<PMTHeightChest> getpMTHeightChestList() {
		return pMTHeightChestList;
	}


	public void setpMTHeightChestList(List<PMTHeightChest> pMTHeightChestList) {
		this.pMTHeightChestList = pMTHeightChestList;
	}


	public List<PstEnd> getPstEndList() {
		return pstEndList;
	}


	public void setPstEndList(List<PstEnd> pstEndList) {
		this.pstEndList = pstEndList;
	}


	public List<PstStart> getPstStartList() {
		return pstStartList;
	}


	public void setPstStartList(List<PstStart> pstStartList) {
		this.pstStartList = pstStartList;
	}


	public List<RecommendedDate> getRecommendedDateList() {
		return recommendedDateList;
	}


	public void setRecommendedDateList(List<RecommendedDate> recommendedDateList) {
		this.recommendedDateList = recommendedDateList;
	}


	public List<ResultOfPmtHeightChest> getResultOfPmtHeightChestList() {
		return resultOfPmtHeightChestList;
	}


	public void setResultOfPmtHeightChestList(List<ResultOfPmtHeightChest> resultOfPmtHeightChestList) {
		this.resultOfPmtHeightChestList = resultOfPmtHeightChestList;
	}


	public List<ResultOfPst> getResultOfPstList() {
		return resultOfPstList;
	}


	public void setResultOfPstList(List<ResultOfPst> resultOfPstList) {
		this.resultOfPstList = resultOfPstList;
	}


	public List<ResultOfWrittenExam> getResultOfWrittenExamList() {
		return resultOfWrittenExamList;
	}


	public void setResultOfWrittenExamList(List<ResultOfWrittenExam> resultOfWrittenExamList) {
		this.resultOfWrittenExamList = resultOfWrittenExamList;
	}


	public List<ScrutinyEndDate> getScrutinyEndDateList() {
		return scrutinyEndDateList;
	}


	public void setScrutinyEndDateList(List<ScrutinyEndDate> scrutinyEndDateList) {
		this.scrutinyEndDateList = scrutinyEndDateList;
	}


	public List<ScrutinyResults> getScrutinyResultsList() {
		return scrutinyResultsList;
	}


	public void setScrutinyResultsList(List<ScrutinyResults> scrutinyResultsList) {
		this.scrutinyResultsList = scrutinyResultsList;
	}


	public List<ScrutinyStartDate> getScrutinyStartDateList() {
		return scrutinyStartDateList;
	}


	public void setScrutinyStartDateList(List<ScrutinyStartDate> scrutinyStartDateList) {
		this.scrutinyStartDateList = scrutinyStartDateList;
	}


	public List<UploadedRevisedAnswerKey> getUploadedRevisedAnswerKeyList() {
		return uploadedRevisedAnswerKeyList;
	}


	public void setUploadedRevisedAnswerKeyList(List<UploadedRevisedAnswerKey> uploadedRevisedAnswerKeyList) {
		this.uploadedRevisedAnswerKeyList = uploadedRevisedAnswerKeyList;
	}


	public List<UploadingAnswerKey> getUploadingAnswerKeyList() {
		return uploadingAnswerKeyList;
	}


	public void setUploadingAnswerKeyList(List<UploadingAnswerKey> uploadingAnswerKeyList) {
		this.uploadingAnswerKeyList = uploadingAnswerKeyList;
	}


	public List<WrittenExam> getWrittenExamList() {
		return writtenExamList;
	}


	public void setWrittenExamList(List<WrittenExam> writtenExamList) {
		this.writtenExamList = writtenExamList;
	}


	public List<AdvertisementPosted> getAdvtPostedDateList() {
		return advtPostedDateList;
	}


	public void setAdvtPostedDateList(List<AdvertisementPosted> advtPostedDateList) {
		this.advtPostedDateList = advtPostedDateList;
	}


	public Integer getsRNo() {
		return sRNo;
	}


	public void setsRNo(Integer sRNo) {
		this.sRNo = sRNo;
	}


	public String getaDvtNo() {
		return aDvtNo;
	}


	public void setaDvtNo(String aDvtNo) {
		this.aDvtNo = aDvtNo;
	}


	public Integer getaDvtId() {
		return aDvtId;
	}


	public void setaDvtId(Integer aDvtId) {
		this.aDvtId = aDvtId;
	}


	public Integer getcAtNo() {
		return cAtNo;
	}


	public void setcAtNo(Integer cAtNo) {
		this.cAtNo = cAtNo;
	}


	public Integer getcAtId() {
		return cAtId;
	}


	public void setcAtId(Integer cAtId) {
		this.cAtId = cAtId;
	}


	public Integer getdEpartmentId() {
		return dEpartmentId;
	}


	public void setdEpartmentId(Integer dEpartmentId) {
		this.dEpartmentId = dEpartmentId;
	}


	public String getnAmeOfPost() {
		return nAmeOfPost;
	}


	public void setnAmeOfPost(String nAmeOfPost) {
		this.nAmeOfPost = nAmeOfPost;
	}


	public Integer getnOOfPosts() {
		return nOOfPosts;
	}


	public void setnOOfPosts(Integer nOOfPosts) {
		this.nOOfPosts = nOOfPosts;
	}


	public String getmAcroStatus() {
		return mAcroStatus;
	}


	public void setmAcroStatus(String mAcroStatus) {
		this.mAcroStatus = mAcroStatus;
	}


	public String getnExtStep() {
		return nExtStep;
	}


	public void setnExtStep(String nExtStep) {
		this.nExtStep = nExtStep;
	}

	

	public String getCurrentStep() {
		return currentStep;
	}


	public void setCurrentStep(String currentStep) {
		this.currentStep = currentStep;
	}


	public Integer getcAndidatesRecommended() {
		return cAndidatesRecommended;
	}


	public void setcAndidatesRecommended(Integer cAndidatesRecommended) {
		this.cAndidatesRecommended = cAndidatesRecommended;
	}


	public Integer gettOtalNoOfApplications() {
		return tOtalNoOfApplications;
	}


	public void settOtalNoOfApplications(Integer tOtalNoOfApplications) {
		this.tOtalNoOfApplications = tOtalNoOfApplications;
	}


	public Integer getnOOfPeopleAttendingExam() {
		return nOOfPeopleAttendingExam;
	}


	public void setnOOfPeopleAttendingExam(Integer nOOfPeopleAttendingExam){
		this.nOOfPeopleAttendingExam = nOOfPeopleAttendingExam;
	}


	public Date getaDvertisementPosted() {
		return aDvertisementPosted;
	}


	public void setaDvertisementPosted(Date aDvertisementPosted) {
		this.aDvertisementPosted = aDvertisementPosted;
	}


	public Date getaPplicationsOpen() {
		return aPplicationsOpen;
	}


	public void setaPplicationsOpen(Date aPplicationsOpen) {
		this.aPplicationsOpen = aPplicationsOpen;
	}


	public Date getaPplicationsClose() {
		return aPplicationsClose;
	}


	public void setaPplicationsClose(Date aPplicationsClose) {
		this.aPplicationsClose = aPplicationsClose;
	}


	public Date getaDmitCards() {
		return aDmitCards;
	}


	public void setaDmitCards(Date aDmitCards) {
		this.aDmitCards = aDmitCards;
	}


	public Date getpStStart() {
		return pStStart;
	}


	public void setpStStart(Date pStStart) {
		this.pStStart = pStStart;
	}


	public Date getpStEnd() {
		return pStEnd;
	}


	public void setpStEnd(Date pStEnd) {
		this.pStEnd = pStEnd;
	}


	public Date getrEsultOfPst() {
		return rEsultOfPst;
	}


	public void setrEsultOfPst(Date rEsultOfPst) {
		this.rEsultOfPst = rEsultOfPst;
	}


	public Date getwRittenExam() {
		return wRittenExam;
	}


	public void setwRittenExam(Date wRittenExam) {
		this.wRittenExam = wRittenExam;
	}


	public String getwRittenExamSession() {
		return wRittenExamSession;
	}


	public void setwRittenExamSession(String wRittenExamSession) {
		this.wRittenExamSession = wRittenExamSession;
	}


	public Date getuPloadingAnswerKey() {
		return uPloadingAnswerKey;
	}


	public void setuPloadingAnswerKey(Date uPloadingAnswerKey) {
		this.uPloadingAnswerKey = uPloadingAnswerKey;
	}


	public Date getoBjectionsOpen() {
		return oBjectionsOpen;
	}


	public void setoBjectionsOpen(Date oBjectionsOpen) {
		this.oBjectionsOpen = oBjectionsOpen;
	}


	public Date getoBjectionsClose() {
		return oBjectionsClose;
	}


	public void setoBjectionsClose(Date oBjectionsClose) {
		this.oBjectionsClose = oBjectionsClose;
	}


	public Date getuPloadedRevisedAnswerKey() {
		return uPloadedRevisedAnswerKey;
	}


	public void setuPloadedRevisedAnswerKey(Date uPloadedRevisedAnswerKey) {
		this.uPloadedRevisedAnswerKey = uPloadedRevisedAnswerKey;
	}


	public Date getrEsultOfWrittenExam() {
		return rEsultOfWrittenExam;
	}


	public void setrEsultOfWrittenExam(Date rEsultOfWrittenExam) {
		this.rEsultOfWrittenExam = rEsultOfWrittenExam;
	}


	public Date getsCrutinyStartDate() {
		return sCrutinyStartDate;
	}


	public void setsCrutinyStartDate(Date sCrutinyStartDate) {
		this.sCrutinyStartDate = sCrutinyStartDate;
	}


	public Date getsCrutinyEndDate() {
		return sCrutinyEndDate;
	}


	public void setsCrutinyEndDate(Date sCrutinyEndDate) {
		this.sCrutinyEndDate = sCrutinyEndDate;
	}


	public Date getsCrutinyResults() {
		return sCrutinyResults;
	}


	public void setsCrutinyResults(Date sCrutinyResults) {
		this.sCrutinyResults = sCrutinyResults;
	}


	public Date getpMtHeightChest() {
		return pMtHeightChest;
	}


	public void setpMtHeightChest(Date pMtHeightChest) {
		this.pMtHeightChest = pMtHeightChest;
	}


	public Date getrEsultOfPmtHeightChest() {
		return rEsultOfPmtHeightChest;
	}


	public void setrEsultOfPmtHeightChest(Date rEsultOfPmtHeightChest) {
		this.rEsultOfPmtHeightChest = rEsultOfPmtHeightChest;
	}


	public Date getaDmitCardsForInterview() {
		return aDmitCardsForInterview;
	}


	public void setaDmitCardsForInterview(Date aDmitCardsForInterview) {
		this.aDmitCardsForInterview = aDmitCardsForInterview;
	}


	public Date getiNterviewsStartDate() {
		return iNterviewsStartDate;
	}


	public void setiNterviewsStartDate(Date iNterviewsStartDate) {
		this.iNterviewsStartDate = iNterviewsStartDate;
	}


	public Date getiNterviewsEndDate() {
		return iNterviewsEndDate;
	}


	public void setiNterviewsEndDate(Date iNterviewsEndDate) {
		this.iNterviewsEndDate = iNterviewsEndDate;
	}


	public Date getaNnouncementOfFinalResult() {
		return aNnouncementOfFinalResult;
	}


	public void setaNnouncementOfFinalResult(Date aNnouncementOfFinalResult) {
		this.aNnouncementOfFinalResult = aNnouncementOfFinalResult;
	}


	public Date getrEcommendedDate() {
		return rEcommendedDate;
	}


	public void setrEcommendedDate(Date rEcommendedDate) {
		this.rEcommendedDate = rEcommendedDate;
	}


	public String getdEtailedStatus() {
		return dEtailedStatus;
	}


	public void setdEtailedStatus(String dEtailedStatus) {
		this.dEtailedStatus = dEtailedStatus;
	}


	public Department getDeptObj() {
		return deptObj;
	}


	public void setDeptObj(Department deptObj) {
		this.deptObj = deptObj;
	}


	public List<AdmitCards> getAdmitCardsList() {
		return admitCardsList;
	}


	public void setAdmitCardsList(List<AdmitCards> admitCardsList) {
		this.admitCardsList = admitCardsList;
	}


	public List<CourtCaseDetails> getWritNoList() {
		return writNoList;
	}


	public void setWritNoList(List<CourtCaseDetails> writNoList) {
		this.writNoList = writNoList;
	}


	public String getWritNo() {
		
		String result="";
		List<String> writNoList=new ArrayList<String>();
		if (CommonUtils.isNotEmpty(this.writNoList)) {
		
		for (CourtCaseDetails s : this.writNoList)
		{	if(CommonUtils.isNotEmpty(s.getWritNo())){
			writNoList.add(s.getWritNo().toString());
		}
		}
	}
		Iterator<String> it = writNoList.iterator();
		if (it.hasNext()) {
			result += it.next()+"\t";
			
		}
		while (it.hasNext()) {
			result +=  ","+"\t"+it.next() ;
			
		}
		return result;
	}


	public void setWritNo(String writNo) {
		this.writNo = writNo;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public List<DepartmentDocs> getDepartmentDocsList() {
		return departmentDocsList;
	}


	public void setDepartmentDocsList(List<DepartmentDocs> departmentDocsList) {
		this.departmentDocsList = departmentDocsList;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getAdvtpostDates() {
		
		List<Date> dtList=new ArrayList<Date>();
		try {
		String ds2=null;
		if (CommonUtils.isNotEmpty(advtPostedDateList))
		{
		 for (AdvertisementPosted s : advtPostedDateList)
		  {	
		    if(CommonUtils.isNotEmpty(s.getAdvertisementPosted()))
			 {
			   dtList.add(s.getAdvertisementPosted());
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
			System.out.println(this.cAtNo);
		}
		return null;
	}


	public void setAdvtpostDates(String advtpostDates) {
		this.advtpostDates = advtpostDates;
	}

	

	

}
