package in.hkcl.dao;

import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.displaytag.properties.SortOrderEnum;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import in.hkcl.dao.common.DaoSupport;
import in.hkcl.model.AdmitCards;
import in.hkcl.model.AdmitCardsForInterview;
import in.hkcl.model.AdvertisementPosted;
import in.hkcl.model.AnnouncementOfResults;
import in.hkcl.model.ApplicationClosed;
import in.hkcl.model.ApplicationOpen;
import in.hkcl.model.Department;
import in.hkcl.model.DepartmentDocs;
import in.hkcl.model.DepartmentVO;
import in.hkcl.model.EmailTemplate;
import in.hkcl.model.InterviewEndDate;
import in.hkcl.model.InterviewStartDate;
import in.hkcl.model.NextStepsAdvt;
import in.hkcl.model.ObjectionsClosed;
import in.hkcl.model.ObjectionsOpen;
import in.hkcl.model.PMTHeightChest;
import in.hkcl.model.PasswordResetToken;
import in.hkcl.model.Police;
import in.hkcl.model.PstEnd;
import in.hkcl.model.PstStart;
import in.hkcl.model.RecommendedDate;
import in.hkcl.model.ResultOfPmtHeightChest;
import in.hkcl.model.ResultOfPst;
import in.hkcl.model.ResultOfWrittenExam;
import in.hkcl.model.ScrutinyEndDate;
import in.hkcl.model.ScrutinyResults;
import in.hkcl.model.ScrutinyStartDate;
import in.hkcl.model.UploadedRevisedAnswerKey;
import in.hkcl.model.UploadingAnswerKey;
import in.hkcl.model.UserEditLogs;
import in.hkcl.model.UserEditLogsMIS;
import in.hkcl.model.UserHistory;
import in.hkcl.model.UserLogin;
import in.hkcl.model.WrittenExam;
import in.hkcl.utils.ApplicationLogFactory;
import in.hkcl.utils.ApplicationLogger;
import in.hkcl.utils.CommonUtils;

public class BaseDataDaoImpl extends DaoSupport implements BaseDataDao {

	private static ApplicationLogger logger = ApplicationLogFactory.getLogger(BaseDataDaoImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public List<Police> getAllHsscPostList() throws Exception {
		List<Police> allMisData = new ArrayList<Police>();
		try {
			
			 allMisData = (List<Police>)getJdbcTemplate().query("SELECT A.sRNo,A.nExtStep,A.aDvtNo,A.nAmeOfPost,"
	+ "A.cAtNo,A.dEpartmentId,A1.dEpartment,B.advertisementPosted,"
	+"C.applicationopen,D.writtenExam,E.scrutinyStartDate,F.interviewStartDate,G.recommendedDate,H.admitcard,"
    +"I.admitCardsForInterview,J.announcementOfResults,K.applicationclosed,L.interviewEndDate,N.objectionsClosed,"
    +"O.objectionsOpen,P.pmtHeightChest,Q.pstend,R.pststart,S.uploadingAnswerKey,T.resultOfPmtHeightChest,"
    +"U.resultofpst,V.resultOfWrittenExam,W.scrutinyEndDate,X.scrutinyResults,Y.uploadedRevisedAnswerKey FROM police"
    +" A LEFT JOIN advertisementposteddate B ON A.sRNo = B.sRNo LEFT JOIN applicationopendate C ON A.sRNo = C.sRNo LEFT"
    +" JOIN writtenexam D ON A.sRNo = D.sRNo LEFT JOIN scrutinyStartDate E ON A.sRNo = E.sRNo LEFT JOIN interviewStartDate F"
    +" ON A.sRNo = F.sRNo LEFT JOIN  recommendedDate G ON A.sRNo = G.sRNo LEFT JOIN admitcards H ON A.sRNo = H.sRNo LEFT JOIN"
    +" admitCardsForInterview I ON A.sRNo = I.sRNo LEFT JOIN announcementOfResults J ON A.sRNo = J.sRNo LEFT JOIN"
    +" applicationclosedate K ON A.sRNo = K.sRNo LEFT JOIN interviewEndDate L ON A.sRNo = L.sRNo  LEFT JOIN objectionsclosed N"
    +" ON A.sRNo = N.sRNo LEFT JOIN objectionsopen O ON A.sRNo = O.sRNo  LEFT JOIN pMTHeightChest P ON A.sRNo = P.sRNo  LEFT JOIN"
    +" pstenddate Q ON A.sRNo = Q.sRNo LEFT JOIN pstStartdate R ON A.sRNo = R.sRNo LEFT JOIN uploadinganswerkey S ON "
    +" A.sRNo = S.sRNo LEFT JOIN resultOfPmtHeightChest T ON A.sRNo = T.sRNo LEFT JOIN resultofpst U ON A.sRNo = U.sRNo"
    +" LEFT JOIN resultOfWrittenExam V ON A.sRNo = V.sRNo LEFT JOIN scrutinyEndDate W ON A.sRNo = W.sRNo"
    +" LEFT JOIN scrutinyResults X ON A.sRNo = X.sRNo LEFT JOIN uploadedRevisedAnswerKey Y ON A.sRNo = Y.sRNo "
    + "LEFT JOIN department A1 ON A.dEpartmentId = A1.dEpartmentId ORDER BY E.scrutinyStartDate DESC", 
					new RowMapper<Police>(){
				@Override
				public Police mapRow(final ResultSet resultSet, final int arg1) throws SQLException
				{
					final List<AdvertisementPosted> advpostedList=new ArrayList<AdvertisementPosted>();
					final List<ApplicationOpen> aplOpenList=new ArrayList<ApplicationOpen>();
					final List<WrittenExam> wrtExmList=new ArrayList<WrittenExam>();
					final List<ScrutinyStartDate> scrList=new ArrayList<ScrutinyStartDate>();
					final List<InterviewStartDate> intrVList=new ArrayList<InterviewStartDate>();
					final List<RecommendedDate> recDateList=new ArrayList<RecommendedDate>();
					final List<AdmitCards> admitCardList=new ArrayList<AdmitCards>();
					final List<AdmitCardsForInterview> admitCardfrIntrList=new ArrayList<AdmitCardsForInterview>();
					final List<AnnouncementOfResults> anouncemntOfResList=new ArrayList<AnnouncementOfResults>();
					final List<ApplicationClosed> aplCloseList=new ArrayList<ApplicationClosed>();
					final List<InterviewEndDate> intrendList=new ArrayList<InterviewEndDate>();
					final List<ObjectionsClosed> objCloseList=new ArrayList<ObjectionsClosed>();
					final List<ObjectionsOpen> objOpenList=new ArrayList<ObjectionsOpen>();
					final List<PMTHeightChest> pmtheightchestList=new ArrayList<PMTHeightChest>();
					final List<PstEnd> pstendList=new ArrayList<PstEnd>();
					final List<PstStart> pststrtList=new ArrayList<PstStart>();
					final List<UploadingAnswerKey> uplanskeyList=new ArrayList<UploadingAnswerKey>();
					final List<ResultOfPmtHeightChest> resOfPmtList=new ArrayList<ResultOfPmtHeightChest>();
					final List<ResultOfPst> resOfPstList=new ArrayList<ResultOfPst>();
					final List<ResultOfWrittenExam> resOfwrtnExmList=new ArrayList<ResultOfWrittenExam>();
					final List<ScrutinyEndDate> scrEndList=new ArrayList<ScrutinyEndDate>();
					final List<ScrutinyResults>scrResList=new ArrayList<ScrutinyResults>();
					final List<UploadedRevisedAnswerKey> uplRevAnsKeyList=new ArrayList<UploadedRevisedAnswerKey>();
					
					
					final Police police = new Police();
					final AdvertisementPosted advtObj=new AdvertisementPosted();
					final ApplicationOpen aplObj=new ApplicationOpen();
					final WrittenExam wrtExm=new WrittenExam();
					final ScrutinyStartDate scr=new ScrutinyStartDate();
					final InterviewStartDate intr=new InterviewStartDate();
					final RecommendedDate recDate=new RecommendedDate();
					final AdmitCards admitCardObj=new AdmitCards();
					final AdmitCardsForInterview admitCardfrIntrObj=new AdmitCardsForInterview();
					final AnnouncementOfResults anouncemntOfResObj=new AnnouncementOfResults();
					final ApplicationClosed aplCloseObj=new ApplicationClosed();
					final InterviewEndDate intrendObj=new InterviewEndDate();
					final ObjectionsClosed objCloseObj=new ObjectionsClosed();
					final ObjectionsOpen objOpenObj=new ObjectionsOpen();
					final PMTHeightChest pmtheightchestObj=new PMTHeightChest();
					final PstEnd pstendObj=new PstEnd();
					final PstStart pststrtObj=new PstStart();
					final UploadingAnswerKey uplanskeyObj=new UploadingAnswerKey();
					final ResultOfPmtHeightChest resOfPmtObj=new ResultOfPmtHeightChest();
					final ResultOfPst resOfPstObj=new ResultOfPst();
					final ResultOfWrittenExam resOfwrtnExmObj=new ResultOfWrittenExam();
					final ScrutinyEndDate scrEndObj=new ScrutinyEndDate();
					final ScrutinyResults scrResObj=new ScrutinyResults();
					final UploadedRevisedAnswerKey uplRevAnsKeyObj=new UploadedRevisedAnswerKey();
					
					
					police.setnExtStep(resultSet.getString("nExtStep"));
					police.setsRNo(resultSet.getInt("sRNo"));
					police.setaDvtNo(resultSet.getString("aDvtNo"));
					police.setnAmeOfPost(resultSet.getString("nAmeOfPost"));
					police.setcAtNo(resultSet.getInt("cAtNo"));
					police.setDeptName(resultSet.getString("dEpartment"));
					if(CommonUtils.isNotEmpty(resultSet.getDate("advertisementPosted"))){
					advtObj.setAdvertisementPosted(resultSet.getDate("advertisementPosted"));
					advpostedList.add(advtObj);
					police.setAdvtPostedDateList(advpostedList);
					}
					if(CommonUtils.isNotEmpty(resultSet.getDate("applicationopen"))){
					aplObj.setApplicationopen(resultSet.getDate("applicationopen"));
					aplObj.setsRNo(resultSet.getInt("sRNo"));
					aplOpenList.add(aplObj);
					police.setApplicationOpenList(aplOpenList);
				    }
					if(CommonUtils.isNotEmpty(resultSet.getDate("writtenExam"))){
						wrtExm.setWrittenExam(resultSet.getDate("writtenExam"));
						wrtExm.setsRNo(resultSet.getInt("sRNo"));
						wrtExmList.add(wrtExm);
						police.setWrittenExamList(wrtExmList);
					 }
					if(CommonUtils.isNotEmpty(resultSet.getDate("scrutinyStartDate"))){
						scr.setScrutinyStartDate(resultSet.getDate("scrutinyStartDate"));
						scr.setsRNo(resultSet.getInt("sRNo"));
						scrList.add(scr);
						police.setScrutinyStartDateList(scrList);
					   }
					if(CommonUtils.isNotEmpty(resultSet.getDate("interviewStartDate"))){
						intr.setInterviewStartDate(resultSet.getDate("interviewStartDate"));
						intr.setsRNo(resultSet.getInt("sRNo"));
						intrVList.add(intr);
						police.setInterviewStartDateList(intrVList);
					   }
					if(CommonUtils.isNotEmpty(resultSet.getDate("recommendedDate"))){
						recDate.setRecommendedDate(resultSet.getDate("recommendedDate"));
						recDate.setsRNo(resultSet.getInt("sRNo"));
						recDateList.add(recDate);
						police.setRecommendedDateList(recDateList);
					   }
					if(CommonUtils.isNotEmpty(resultSet.getDate("admitcard"))){
						admitCardObj.setAdmitcard(resultSet.getDate("admitcard"));
						admitCardObj.setsRNo(resultSet.getInt("sRNo"));
						admitCardList.add(admitCardObj);
						police.setAdmitCardsList(admitCardList);
					   }
					
					
					if(CommonUtils.isNotEmpty(resultSet.getDate("admitCardsForInterview"))){
						admitCardfrIntrObj.setAdmitCardsForInterview(resultSet.getDate("admitCardsForInterview"));
						admitCardfrIntrObj.setsRNo(resultSet.getInt("sRNo"));
						admitCardfrIntrList.add(admitCardfrIntrObj);
						police.setAdmitCardsForInterviewList(admitCardfrIntrList);
				   }
					if(CommonUtils.isNotEmpty(resultSet.getDate("announcementOfResults"))){
						anouncemntOfResObj.setAnnouncementOfResults(resultSet.getDate("announcementOfResults"));
						anouncemntOfResObj.setsRNo(resultSet.getInt("sRNo"));
						anouncemntOfResList.add(anouncemntOfResObj);
						police.setAnnouncementOfResultsList(anouncemntOfResList);
				   }
					if(CommonUtils.isNotEmpty(resultSet.getDate("applicationclosed"))){
						aplCloseObj.setApplicationclosed(resultSet.getDate("applicationclosed"));
						aplCloseObj.setsRNo(resultSet.getInt("sRNo"));
						aplCloseList.add(aplCloseObj);
						police.setApplicationClosedList(aplCloseList);
					}
					if(CommonUtils.isNotEmpty(resultSet.getDate("interviewEndDate"))){
						intrendObj.setInterviewEndDate(resultSet.getDate("interviewEndDate"));
						intrendObj.setsRNo(resultSet.getInt("sRNo"));
						intrendList.add(intrendObj);
						police.setInterviewEndDateList(intrendList);
					}
					if(CommonUtils.isNotEmpty(resultSet.getDate("objectionsClosed"))){
						objCloseObj.setObjectionsClosed(resultSet.getDate("objectionsClosed"));
						objCloseObj.setsRNo(resultSet.getInt("sRNo"));
						objCloseList.add(objCloseObj);
						police.setObjectionsClosedList(objCloseList);
					}
					if(CommonUtils.isNotEmpty(resultSet.getDate("objectionsOpen"))){
						objOpenObj.setObjectionsOpen(resultSet.getDate("objectionsOpen"));
						objOpenObj.setsRNo(resultSet.getInt("sRNo"));
						objOpenList.add(objOpenObj);
						police.setObjectionsOpenList(objOpenList);
					}
					if(CommonUtils.isNotEmpty(resultSet.getDate("pmtHeightChest"))){
						pmtheightchestObj.setPmtHeightChest(resultSet.getDate("pmtHeightChest"));
						pmtheightchestObj.setsRNo(resultSet.getInt("sRNo"));
						pmtheightchestList.add(pmtheightchestObj);
						police.setpMTHeightChestList(pmtheightchestList);
					 }
					if(CommonUtils.isNotEmpty(resultSet.getDate("pstend"))){
						pstendObj.setPstend(resultSet.getDate("pstend"));
						pstendObj.setsRNo(resultSet.getInt("sRNo"));
						pstendList.add(pstendObj);
						police.setPstEndList(pstendList);
					 }
					if(CommonUtils.isNotEmpty(resultSet.getDate("pststart"))){
						pststrtObj.setPststart(resultSet.getDate("pststart"));
						pststrtObj.setsRNo(resultSet.getInt("sRNo"));
						pststrtList.add(pststrtObj);
						police.setPstStartList(pststrtList);
					 }
					if(CommonUtils.isNotEmpty(resultSet.getDate("uploadingAnswerKey"))){
						uplanskeyObj.setUploadingAnswerKey(resultSet.getDate("uploadingAnswerKey"));
						uplanskeyObj.setsRNo(resultSet.getInt("sRNo"));
						uplanskeyList.add(uplanskeyObj);
						police.setUploadedRevisedAnswerKeyList(uplRevAnsKeyList);
					 }
					if(CommonUtils.isNotEmpty(resultSet.getDate("resultOfPmtHeightChest"))){
						resOfPmtObj.setResultOfPmtHeightChest(resultSet.getDate("resultOfPmtHeightChest"));
						resOfPmtObj.setsRNo(resultSet.getInt("sRNo"));
						resOfPmtList.add(resOfPmtObj);
						police.setResultOfPmtHeightChestList(resOfPmtList);
					 }
					
					if(CommonUtils.isNotEmpty(resultSet.getDate("resultofpst"))){
						resOfPstObj.setResultofpst(resultSet.getDate("resultofpst"));
						resOfPstObj.setsRNo(resultSet.getInt("sRNo"));
						resOfPstList.add(resOfPstObj);
						police.setResultOfPstList(resOfPstList);
					 }
					
					if(CommonUtils.isNotEmpty(resultSet.getDate("resultOfWrittenExam"))){
						resOfwrtnExmObj.setResultOfWrittenExam(resultSet.getDate("resultOfWrittenExam"));
						resOfwrtnExmObj.setsRNo(resultSet.getInt("sRNo"));
						resOfwrtnExmList.add(resOfwrtnExmObj);
						police.setResultOfWrittenExamList(resOfwrtnExmList);
					 }
					if(CommonUtils.isNotEmpty(resultSet.getDate("scrutinyEndDate"))){
						scrEndObj.setScrutinyEndDate(resultSet.getDate("scrutinyEndDate"));
						scrEndObj.setsRNo(resultSet.getInt("sRNo"));
						scrEndList.add(scrEndObj);
						police.setScrutinyEndDateList(scrEndList);
					 }
					if(CommonUtils.isNotEmpty(resultSet.getDate("scrutinyResults"))){
						scrResObj.setScrutinyResults(resultSet.getDate("scrutinyResults"));
						scrResObj.setsRNo(resultSet.getInt("sRNo"));
						scrResList.add(scrResObj);
						police.setScrutinyResultsList(scrResList);
					 }
					if(CommonUtils.isNotEmpty(resultSet.getDate("uploadedRevisedAnswerKey"))){
						uplRevAnsKeyObj.setUploadedRevisedAnswerKey(resultSet.getDate("uploadedRevisedAnswerKey"));
						uplRevAnsKeyObj.setsRNo(resultSet.getInt("sRNo"));
						uplRevAnsKeyList.add(uplRevAnsKeyObj);
						police.setUploadedRevisedAnswerKeyList(uplRevAnsKeyList);
					 }
					
					
					
					return police;
				}				
		});
			
			
			
			/*String getAllData="SELECT lastname, firstname, tag, vehicles.class FROM drivers, vehicles WHERE"
					+ " drivers.location = vehicles.location AND drivers.class = vehicles.class";*/
			return allMisData;
		} catch (Exception e) {
			logger.logError("getAllHsscPostList", "error while fetching value post name", e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Police> getAllHsscPostListForDept(Integer dEpartmentId) throws Exception {
		List<Police> AllHsscPostListForDept = new ArrayList<Police>();
		try {
			if(CommonUtils.isEmpty(dEpartmentId)){
				AllHsscPostListForDept = (List<Police>)getJdbcTemplate().query("select * from police ", 
						new RowMapper<Police>(){
					@Override
					public Police mapRow(final ResultSet resultSet, final int arg1) throws SQLException
					{
						final Police police = new Police();
						police.setmAcroStatus(resultSet.getString("mAcroStatus"));
						police.setnOOfPosts(resultSet.getInt("nOOfPosts"));
						police.setnAmeOfPost(resultSet.getString("nAmeOfPost"));
						police.setnExtStep(resultSet.getString("nExtStep"));
						return police;
					}				
			});
				
			}else{
				AllHsscPostListForDept = (List<Police>)getJdbcTemplate().query("select * from police where dEpartmentId like ?", 
						new Object[]{dEpartmentId},
						new RowMapper<Police>(){
					@Override
					public Police mapRow(final ResultSet resultSet, final int arg1) throws SQLException
					{
						final Police police = new Police();
						police.setmAcroStatus(resultSet.getString("mAcroStatus"));
						police.setnOOfPosts(resultSet.getInt("nOOfPosts"));
						police.setnAmeOfPost(resultSet.getString("nAmeOfPost"));
						return police;
					}				
			});
				
			}
			
/*			if (dEpartmentId == null) {
				AllHsscPostListForDept = getHibernateTemplate().loadAll(Police.class);
			} else {
				DetachedCriteria criteria = DetachedCriteria.forClass(Police.class);
				criteria.add(Restrictions.eq("dEpartmentId", dEpartmentId));
				AllHsscPostListForDept = (List<Police>) getHibernateTemplate().findByCriteria(criteria);
			}
			if (CommonUtils.isNotEmpty(AllHsscPostListForDept)) {
				return AllHsscPostListForDept;
			} else {
				return null;
			}
*/
			
		
		
		} catch (Exception e) {
			logger.logError("getAllHsscPostListForDept", "error while fetching data for AllHsscPostListForDept", e);
			throw e;
		}
		return AllHsscPostListForDept;
	}

	@SuppressWarnings("unchecked")
	public List<Police> getAllHsscStatusListForDept(String mAcroStatus) throws Exception {
		List<Police> AllHsscStatusListForDept = new ArrayList<Police>();
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Police.class);
			criteria.add(Restrictions.eq("mAcroStatus", mAcroStatus));		
			AllHsscStatusListForDept = (List<Police>) getHibernateTemplate().findByCriteria(criteria);
			if (CommonUtils.isNotEmpty(AllHsscStatusListForDept)) {
				return AllHsscStatusListForDept;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.logError("getAllHsscPostListForDept", "error while fetching data for AllHsscPostListForDept", e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Police> getPostDetails(Integer srNo) throws Exception {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Police.class);
			criteria.add(Restrictions.eq("sRNo", srNo));
			List<Police> PostDetailsListForDept = (List<Police>) getHibernateTemplate().findByCriteria(criteria);
			if (CommonUtils.isNotEmpty(PostDetailsListForDept)) {
				return PostDetailsListForDept;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.logError("getPostDetails", "error while fetching data for PostDetails", e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Police> getpostNameById(String sRNo, String aDvtNo, String status, Integer dEpartmentId)
			throws Exception {
		List<Police> refinedList = new ArrayList<Police>();
		try {

			DetachedCriteria criteria = DetachedCriteria.forClass(Police.class);
			if (CommonUtils.isNotEmpty(sRNo)) {
				criteria.add(Restrictions.like("nAmeOfPost", sRNo));
			}
			if (CommonUtils.isNotEmpty(aDvtNo)) {
				criteria.add(Restrictions.like("aDvtNo", aDvtNo));
			}
			if (CommonUtils.isNotEmpty(status)) {
				criteria.add(Restrictions.like("mAcroStatus", status));
			}
			if (CommonUtils.isNotEmpty(dEpartmentId)) {
				criteria.add(Restrictions.like("dEpartmentId", dEpartmentId));
			}

			// criteria.add(Restrictions.like(aDvtNo, aDvtNo,
			// MatchMode.ANYWHERE));
			refinedList = (List<Police>) getHibernateTemplate().findByCriteria(criteria);
			// refinedList=(List<Police>) getHibernateTemplate().find("from
			// Police where sRNo=? AND aDvtNo=?", new Object[]{sRNo, aDvtNo});
			if (CommonUtils.isNotEmpty(refinedList)) {
				return refinedList;
			} else {
				return null;
			}

		} catch (Exception e) {
			logger.logError("getpostNameById", "error while postNameById details", e);
		}
		return refinedList;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getDistinctAdvtNo(Integer dEpartmentId) throws Exception {
		try {
			/*
			 * String query=
			 * "select  from Police  GROUP BY aDvtNo where dEpartmentId=?";
			 * double list=getHibernateTemplate().bulkUpdate(query,
			 * dEpartmentId);
			 */
			DetachedCriteria criteria = DetachedCriteria.forClass(Police.class);
			criteria.setProjection(Projections.distinct(Projections.property("aDvtNo")));
			if (dEpartmentId != null) {
				criteria.add(Restrictions.eq("dEpartmentId", dEpartmentId));
			}
			return (List<String>) getHibernateTemplate().findByCriteria(criteria);
		} catch (Exception e) {
			logger.logError("getDistinctAdvtNo", "error while getDistinctAdvtNo details", e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getDistinctNextStep(Integer dEpartmentId) throws Exception {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Police.class);
			criteria.setProjection(Projections.distinct(Projections.property("nExtStep")));
			if (dEpartmentId != null) {
				criteria.add(Restrictions.eq("dEpartmentId", dEpartmentId));
			}
			return (List<String>) getHibernateTemplate().findByCriteria(criteria);
		} catch (Exception e) {
			logger.logError("getDistinctNextStep", "error while getting DistinctNextStep details", e);
			throw e;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Police> getAllPostData(int dEpartmentId, int firstRecordIndex, int pageSize,
			SortOrderEnum sortDirection, String sortCriterion) throws Exception {
		try {

			DetachedCriteria criteria = DetachedCriteria.forClass(Police.class);
			criteria.addOrder(Order.asc("aDvtNo"));
			criteria.add(Restrictions.eq("dEpartmentId", dEpartmentId));
			List<Police> postList = (List<Police>) getHibernateTemplate().findByCriteria(criteria);

			if (sortCriterion != null) {
				if (sortCriterion.equals(SortOrderEnum.ASCENDING)) {
					criteria.addOrder(Order.asc("aDvtNo"));
				}
				if (sortCriterion.equals(SortOrderEnum.DESCENDING)) {
					criteria.addOrder(Order.desc("aDvtNo"));
				}
			} else {
				criteria.addOrder(Order.asc("aDvtNo"));
			}

			// return
			// (List<JsonMasterCategory>)getHibernateTemplate().findByCriteria(criteria,
			// 0, 20);

			postList = (List<Police>) getHibernateTemplate().findByCriteria(criteria, firstRecordIndex, pageSize);
			if (CommonUtils.isNotEmpty(postList)) {
				return postList;
			} else {
				return null;
			}

		} catch (Exception e) {
			logger.logError("getDepartmentData", "error while fetching value", e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	//@Override
	public List<Police> getAllPostData(Integer sessionDepart,Police police, int firstRecordIndex, int pageSize,
			SortOrderEnum sortDirection, String sortCriterion) throws Exception {
		DetachedCriteria criteria;
		try {
			criteria = DetachedCriteria.forClass(Police.class);
			if(!police.getmAcroStatus().equalsIgnoreCase("Withdrawn")) {
				criteria.add(Restrictions.ne("mAcroStatus", "Withdrawn"));
			}
			
			if(CommonUtils.isNotEmpty(sessionDepart)){
				criteria.add(Restrictions.eq("dEpartmentId", sessionDepart));
			}
			if(CommonUtils.isNotEmpty(police.getaDvtNo())){
				if(police.getaDvtNo().contains("Search Advertisement Number...")){}
				else{
				criteria.add(Restrictions.eq("aDvtNo", police.getaDvtNo()));}
			}
			if(CommonUtils.isNotEmpty(police.getnAmeOfPost())){
				if(police.getnAmeOfPost().contains("Search Post Name...")){}
				else{
				criteria.add(Restrictions.eq("nAmeOfPost", police.getnAmeOfPost()));}
			}
			if(CommonUtils.isNotEmpty(police.getmAcroStatus())){
				if(police.getmAcroStatus().contains("Search Macro Status...")){
					criteria.add(Restrictions.ne("mAcroStatus", "Withdrawn"));
				}
				else{
				criteria.add(Restrictions.eq("mAcroStatus", police.getmAcroStatus()));}
			}
			if(CommonUtils.isNotEmpty(police.getnExtStep())){
				if(police.getnExtStep().contains("Search Next Step...")){}
				else{
				criteria.add(Restrictions.eq("nExtStep", police.getnExtStep()));}
			}
			if(CommonUtils.isNotEmpty(police.getdEpartmentId())){
				if(police.getdEpartmentId().intValue()==0){}
				else{
				criteria.add(Restrictions.eq("dEpartmentId", police.getdEpartmentId()));}
			}
			
				
			
			if (CommonUtils.isNotEmpty(sortCriterion)) {
				if(sortCriterion.contains("deptObj.dEpartment")){
					criteria.createCriteria("deptObj", "dept");
					if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
						criteria.addOrder(Order.asc("dept.dEpartment"));
					}
					if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
						criteria.addOrder(Order.desc("dept.dEpartment"));
					}					
				}else if(sortCriterion.contains("advtpostDates")){
					criteria.createCriteria("advtPostedDateList", "advtPostedDate");
					if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
						criteria.addOrder(Order.asc("advtPostedDate.advertisementPosted"));
					}
					if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
						criteria.addOrder(Order.desc("advtPostedDate.advertisementPosted"));
					}					
				}else{
					if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
						criteria.addOrder(Order.asc(sortCriterion));
					}
					if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
						criteria.addOrder(Order.desc(sortCriterion));
					}
				}

			} else {
				criteria.addOrder(Order.asc("aDvtNo"));
			}
			
			// postList = (List<Police>) getHibernateTemplate().findByCriteria(criteria);
			 List<Police>	postList = (List<Police>) getHibernateTemplate().findByCriteria(criteria, firstRecordIndex, pageSize);
			
			if (CommonUtils.isNotEmpty(postList)) {
				return postList;
			} else {
				return null;
			}

		} catch (Exception e) {
			logger.logError("getDepartmentData", "error while fetching value", e);
			throw e;
		}
	}
	
	
	public int getAllPostDataCount(Integer sessionDepart,Police police) throws Exception {
		final DetachedCriteria criteria = DetachedCriteria.forClass(Police.class);
		if(!police.getmAcroStatus().equalsIgnoreCase("Withdrawn")) {
			criteria.add(Restrictions.ne("mAcroStatus", "Withdrawn"));
		}
		if(CommonUtils.isNotEmpty(police.getaDvtNo())){
			if(police.getaDvtNo().contains("Search Advertisement Number...")){}
			else{
			criteria.add(Restrictions.eq("aDvtNo", police.getaDvtNo()));}
		}
		if(CommonUtils.isNotEmpty(police.getnAmeOfPost())){
			if(police.getnAmeOfPost().contains("Search Post Name...")){}
			else{
			criteria.add(Restrictions.eq("nAmeOfPost", police.getnAmeOfPost()));}
		}
		if(CommonUtils.isNotEmpty(police.getmAcroStatus())){
			if(police.getmAcroStatus().contains("Search Macro Status...")){
				criteria.add(Restrictions.ne("mAcroStatus", "Withdrawn"));
			}
			else{
			criteria.add(Restrictions.eq("mAcroStatus", police.getmAcroStatus()));}
		}
		if(CommonUtils.isNotEmpty(police.getnExtStep())){
			if(police.getnExtStep().contains("Search Next Step...")){}
			else{
			criteria.add(Restrictions.eq("nExtStep", police.getnExtStep()));}
		}
		if(CommonUtils.isNotEmpty(police.getdEpartmentId())){
			if(police.getdEpartmentId().intValue()==0){}
			else{
			criteria.add(Restrictions.eq("dEpartmentId", police.getdEpartmentId()));}
		}
		if(CommonUtils.isNotEmpty(sessionDepart)){
			criteria.add(Restrictions.eq("dEpartmentId",sessionDepart));
		}
		
		criteria.setProjection(Projections.rowCount());
		final List<?> results = getHibernateTemplate().findByCriteria(criteria);
		return CommonUtils.isEmpty(results) == true ? 0 : ((Long) results.get(0)).intValue();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Police> getAllDepartData(int firstRecordIndex, int pageSize, SortOrderEnum sortDirection,
			String sortCriterion) throws Exception {
		try {

			DetachedCriteria criteria = DetachedCriteria.forClass(Police.class);
			DetachedCriteria criteria2 = DetachedCriteria.forClass(Department.class);
			// criteria.addOrder(Order.asc("aDvtNo"));
			// List<Police> postList = (List<Police>)
			// getHibernateTemplate().findByCriteria(criteria);

			if (sortCriterion != null && sortCriterion.contains("deptObj.dEpartment")) {

				if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
					criteria2.addOrder(Order.asc(sortCriterion));
				}
				if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
					criteria2.addOrder(Order.desc(sortCriterion));
				}
			}

			else if (sortCriterion != null && sortCriterion != "deptObj.dEpartment") {
				if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
					criteria.addOrder(Order.asc(sortCriterion));
				}
				if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
					criteria.addOrder(Order.desc(sortCriterion));
				}
			} else {
				criteria.addOrder(Order.asc("aDvtNo"));
			}

			// return
			// (List<JsonMasterCategory>)getHibernateTemplate().findByCriteria(criteria,
			// 0, 20);

			List<Police> postList = (List<Police>) getHibernateTemplate().findByCriteria(criteria, firstRecordIndex,
					pageSize);
			if (CommonUtils.isNotEmpty(postList)) {
				return postList;
			} else {
				return null;
			}

		} catch (Exception e) {
			logger.logError("getDepartmentData", "error while fetching value", e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Police> getAllSearchedData(String mAcroStatus, int firstRecordIndex, int pageSize,
			SortOrderEnum sortDirection, String sortCriterion) throws Exception {
		try {

			DetachedCriteria criteria = DetachedCriteria.forClass(Police.class);
			criteria.add(Restrictions.eq("mAcroStatus", mAcroStatus));
			List<Police> postList = (List<Police>) getHibernateTemplate().findByCriteria(criteria);

			if (sortCriterion != null) {
				if (sortCriterion.equals(SortOrderEnum.ASCENDING)) {
					criteria.addOrder(Order.asc("mAcroStatus"));
				}
				if (sortCriterion.equals(SortOrderEnum.DESCENDING)) {
					criteria.addOrder(Order.desc("mAcroStatus"));
				}
			} else {
				criteria.addOrder(Order.asc("mAcroStatus"));
			}

			// return
			// (List<JsonMasterCategory>)getHibernateTemplate().findByCriteria(criteria,
			// 0, 20);

			postList = (List<Police>) getHibernateTemplate().findByCriteria(criteria, firstRecordIndex, pageSize);
			if (CommonUtils.isNotEmpty(postList)) {
				return postList;
			} else {
				return null;
			}

		} catch (Exception e) {
			logger.logError("getDepartmentData", "error while fetching value", e);
			throw e;
		}
	}

	@Override
	public int getTotalPostDataCount(Integer departmentId) throws Exception {
		final DetachedCriteria criteria = DetachedCriteria.forClass(Police.class);
		if (departmentId == null) {
			criteria.setProjection(Projections.rowCount());
		} else {
			criteria.add(Restrictions.eq("dEpartmentId", departmentId));
			criteria.setProjection(Projections.rowCount());
		}
		final List<?> results = getHibernateTemplate().findByCriteria(criteria);
		return CommonUtils.isEmpty(results) == true ? 0 : ((Long) results.get(0)).intValue();
	}

	@Override
	public int getTotalPostStatusCount(String mAcroStatus) throws Exception {
		final DetachedCriteria criteria = DetachedCriteria.forClass(Police.class);
		if (mAcroStatus == null) {
			criteria.setProjection(Projections.rowCount());
		} else {
			criteria.add(Restrictions.eq("mAcroStatus", mAcroStatus));
			criteria.setProjection(Projections.rowCount());
		}
		final List<?> results = getHibernateTemplate().findByCriteria(criteria);
		return CommonUtils.isEmpty(results) == true ? 0 : ((Long) results.get(0)).intValue();
	}

	@Override
	public int getTotalDepartDataCount() throws Exception {
		final DetachedCriteria criteria = DetachedCriteria.forClass(Police.class);
		criteria.setProjection(Projections.rowCount());

		final List<?> results = getHibernateTemplate().findByCriteria(criteria);
		return CommonUtils.isEmpty(results) == true ? 0 : ((Long) results.get(0)).intValue();
	}

	public UserLogin loginUser(UserLogin user) throws Exception {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String password = user.getUserPassword();
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());

			byte byteData[] = md.digest();

			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				String hex = Integer.toHexString(0xff & byteData[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			System.out.println("Digest(in hex format):: " + hexString.toString());

			user.setUserPassword(hexString.toString());
			String hql = "from in.hkcl.model.UserLogin as c where c.email=? and c.userPassword=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, user.getEmail());
			query.setParameter(1, user.getUserPassword());
			user = (UserLogin) query.uniqueResult();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			logger.logError("login", "error while login the user", e);
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserLogin getVerifiedUser(String Email) throws Exception {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(UserLogin.class);
			criteria.add(Restrictions.eq("email", Email));
			List<UserLogin> recordList = (List<UserLogin>) getHibernateTemplate().findByCriteria(criteria);
			if (CommonUtils.isNotEmpty(recordList)) {
				return recordList.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.logError("getUser", "error while fetching value", e);
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public void createPasswordResetToken(UserLogin user, String token) {
		try {
			Date expiryDate=calculateExpiryDate(60*24);
			PasswordResetToken resetToken = new PasswordResetToken();
			resetToken.setToken(token);
			resetToken.setExpiryDate(expiryDate);
			resetToken.setUserId(user.getUserId());
			getHibernateTemplate().save(resetToken);
		} catch (Exception e) {
			logger.logError("createPasswordResetToken", "error while saving Token", e);
		}
	}

	public Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

	@SuppressWarnings("unchecked")
	@Override
	public PasswordResetToken getPasswordResetUser(String passwordResetToken) throws Exception {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(PasswordResetToken.class);
			criteria.add(Restrictions.eq("token", passwordResetToken));
			List<PasswordResetToken> recordList = (List<PasswordResetToken>) getHibernateTemplate()
					.findByCriteria(criteria);
			if (CommonUtils.isNotEmpty(recordList)) {
				return recordList.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.logError("getUser", "error while fetching value", e);
			throw e;
		}
	}

	@Transactional
	@Override
	public UserLogin updateUserPassword(UserLogin user) throws Exception {
		try {
			UserLogin userDetails = getVerifiedUser(user.getEmail());
			 String password=user.getUserPassword();
			 BeanUtils.copyProperties(user, userDetails);
			  if(user.getIdRole().equals(0)) {
				  user.setIdRole(null);
			  }
			  if(user.getOldDept().equals(0)) {
				  user.setOldDept(null);
			  }
			 user.setUserPassword(password);
			  if(CommonUtils.isNotEmpty(user.getUserId())) {
				  getHibernateTemplate().update(user);
			  }else {
				  getHibernateTemplate().save(user);
			  }
			
		} catch (Exception e) {
			logger.logError("saveLastPasswords", "error while saving new password", e);
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserLogin getChangedPasswordUserData(Integer userId) throws Exception {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(UserLogin.class);
			criteria.add(Restrictions.eq("userId", userId));
			List<UserLogin> recordList = (List<UserLogin>) getHibernateTemplate().findByCriteria(criteria);
			if (CommonUtils.isNotEmpty(recordList)) {
				return recordList.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.logError("getChangedPasswordUserData", "error while fetching value", e);
			throw e;
		}
	}

	@Transactional(readOnly = false)
	@Override
	public UserLogin saveLastPasswords(UserLogin user) {

		try {

			UserLogin userDetails = getVerifiedUser(user.getEmail());
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			user.setEnabled(userDetails.isEnabled());
			user.setUserName(userDetails.getUserName());
			user.setCandidateName(userDetails.getCandidateName());
			user.setIdDept(userDetails.getIdDept());
			user.setIsAdmin(userDetails.getIsAdmin());
            user.setModule(userDetails.getModule());
			
			session.saveOrUpdate(user);
			tx.commit();
			session.close();
		} catch (Exception e) {
			logger.logError("saveLastPasswords", "error while saving new password", e);

		}
		return user;
	}

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public List<Police> getpostNameById(String sRNo,String aDvtNo,
	 * String status,String dEpartment, Integer dEpartmentId ) throws Exception
	 * { List<Police> refinedList=new ArrayList<Police>(); try{
	 * 
	 * DetachedCriteria criteria = DetachedCriteria.forClass(Police.class);
	 * if(CommonUtils.isNotEmpty(sRNo)){
	 * criteria.add(Restrictions.like("nAmeOfPost", sRNo)); }
	 * if(CommonUtils.isNotEmpty(aDvtNo)){
	 * criteria.add(Restrictions.like("aDvtNo", aDvtNo)); }
	 * if(CommonUtils.isNotEmpty(status)){
	 * criteria.add(Restrictions.like("mAcroStatus", status)); }
	 * if(CommonUtils.isNotEmpty(dEpartment)){
	 * criteria.add(Restrictions.like("dEpartmentId",
	 * Integer.parseInt(dEpartment))); }
	 * if(CommonUtils.isNotEmpty(dEpartmentId)){
	 * criteria.add(Restrictions.like("dEpartmentId", dEpartmentId)); }
	 * 
	 * //criteria.add(Restrictions.like(aDvtNo, aDvtNo, MatchMode.ANYWHERE));
	 * refinedList=(List<Police>)
	 * getHibernateTemplate().findByCriteria(criteria); //
	 * refinedList=(List<Police>) getHibernateTemplate().find(
	 * "from Police where sRNo=? AND aDvtNo=?", new Object[]{sRNo, aDvtNo});
	 * if(CommonUtils.isNotEmpty(refinedList)){ return refinedList; }else{
	 * return null; }
	 * 
	 * }catch(Exception e){ logger.logError("getpostNameById",
	 * "error while postNameById details", e); } return refinedList;
	 * 
	 * }
	 */
	@Override
	public Department getDeptName(Integer dEpartmentId) throws Exception {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
			criteria.add(Restrictions.eq("dEpartmentId", dEpartmentId));
			Department obj = (Department) getHibernateTemplate().findByCriteria(criteria);
			if (CommonUtils.isNotEmpty(obj)) {
				return obj;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.logError("getDeptName", "error while fetching value DeptName", e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Police> getCountsForRecommended(Integer dEpartmentId) throws Exception {
		try {

			// String recommendedCount="Select from Police where mAcroStatus =
			// 'Recommended' AND dEpartmentId=?";
			return (List<Police>) getHibernateTemplate().find("from Police where mAcroStatus=? AND dEpartmentId=?",
					new Object[] { "Recommended", dEpartmentId });

		} catch (Exception e) {
			logger.logError("getUser", "error while fetching value", e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Police> getCountsForcourtStay(Integer dEpartmentId) throws Exception {
		try {
			// String recommendedCount="Select from Police where mAcroStatus =
			// 'Court Stay' AND dEpartmentId=?";
			return (List<Police>) getHibernateTemplate().find("from Police where mAcroStatus=? AND dEpartmentId=?",
					new Object[] { "Court Stay", dEpartmentId });
		} catch (Exception e) {
			logger.logError("getUser", "error while fetching value", e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Police> getCountsForinProcessCount(Integer dEpartmentId) throws Exception {
		try {
			// String recommendedCount="Select from Police where mAcroStatus =
			// 'In Process' AND dEpartmentId=?";
			return (List<Police>) getHibernateTemplate().find("from Police where mAcroStatus=? AND dEpartmentId=?",
					new Object[] { "In Process", dEpartmentId });
		} catch (Exception e) {
			logger.logError("getUser", "error while fetching value", e);
			throw e;
		}
	}

	@Override
	public List<Police> getHsscDataForAdmin() throws Exception {
		List<Police> HsscDataForAdmin = new ArrayList<Police>();
		try {
			HsscDataForAdmin = getHibernateTemplate().loadAll(Police.class);
		} catch (Exception e) {
			logger.logError("getHsscDataForAdmin", "error while fetching HsscDataForAdmin", e);
		}
		return HsscDataForAdmin;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Police> getCountsForRecommendedForAdmin() {
		List<Police> CountsForRecommendedList = new ArrayList<Police>();
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Police.class);
			criteria.add(Restrictions.eq("mAcroStatus", "Recommended"));
			CountsForRecommendedList = (List<Police>) getHibernateTemplate().findByCriteria(criteria);
			if (CommonUtils.isNotEmpty(CountsForRecommendedList)) {
				return CountsForRecommendedList;
			} else {
				return null;
			}
		} catch (Exception e) {

		}
		return CountsForRecommendedList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Police> getCountsForcourtStayForAdmin() {
		List<Police> CountsForcourtStayList = new ArrayList<Police>();
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Police.class);
			criteria.add(Restrictions.eq("mAcroStatus", "Court Stay"));
			CountsForcourtStayList = (List<Police>) getHibernateTemplate().findByCriteria(criteria);
			if (CommonUtils.isNotEmpty(CountsForcourtStayList)) {
				return CountsForcourtStayList;
			} else {
				return null;
			}
		} catch (Exception e) {

		}
		return CountsForcourtStayList;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Police> getCountsForinProcessCountForAdmin() {
		List<Police> CountsForinProcessList = new ArrayList<Police>();
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Police.class);
			criteria.add(Restrictions.eq("mAcroStatus", "In Process"));
			CountsForinProcessList = (List<Police>) getHibernateTemplate().findByCriteria(criteria);
			if (CommonUtils.isNotEmpty(CountsForinProcessList)) {
				return CountsForinProcessList;
			} else {
				return null;
			}
		} catch (Exception e) {

		}
		return CountsForinProcessList;
	}

	@Override
	@Transactional(readOnly = false)
	public Police updatePostDetails(Police post) throws Exception {
		try {
			if(post.getsRNo()!=null){
			 String DELETE_admitCards= "delete from AdmitCards where sRNo=?";
			 String DELETE_admitCardsForInterview= "delete from AdmitCardsForInterview where sRNo=?";
			 String DELETE_advertisementPosted= "delete from AdvertisementPosted where sRNo=?";
			 String DELETE_announcementOfResults= "delete from AnnouncementOfResults where sRNo=?";
			 String DELETE_applicationClosed= "delete from ApplicationClosed where sRNo=?";
			 String DELETE_applicationOpen= "delete from ApplicationOpen where sRNo=?";
			 String DELETE_interviewEndDate= "delete from InterviewEndDate where sRNo=?";
			 String DELETE_interviewStartDate= "delete from InterviewStartDate where sRNo=?";
			 String DELETE_objectionsClosed= "delete from ObjectionsClosed where sRNo=?";
			 String DELETE_objectionsOpen= "delete from ObjectionsOpen where sRNo=?";
			 String DELETE_pmtHeightChest= "delete from PMTHeightChest where sRNo=?";
			 String DELETE_pstEnd= "delete from PstEnd where sRNo=?";
			 String DELETE_recommendedDate= "delete from RecommendedDate where sRNo=?";
			 String DELETE_resultOfPmtHeightChest= "delete from ResultOfPmtHeightChest where sRNo=?";
			 String DELETE_resultOfPst= "delete from ResultOfPst where sRNo=?";
			 String DELETE_resultOfWrittenExam= "delete from ResultOfWrittenExam where sRNo=?";
			 String DELETE_scrutinyEndDate= "delete from ScrutinyEndDate where sRNo=?";
			 String DELETE_scrutinyResults= "delete from ScrutinyResults where sRNo=?";
			 String DELETE_scrutinyStartDate= "delete from ScrutinyStartDate where sRNo=?";
			 String DELETE_uploadedRevisedAnswerKey= "delete from UploadedRevisedAnswerKey where sRNo=?";
			 String DELETE_uploadedAnswerKey= "delete from UploadingAnswerKey where sRNo=?";
			 String DELETE_WrittenExam= "delete from WrittenExam where sRNo=?";			 

			 getHibernateTemplate().bulkUpdate(DELETE_admitCards,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_admitCardsForInterview,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_advertisementPosted,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_announcementOfResults,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_applicationClosed,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_applicationOpen,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_interviewEndDate,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_interviewStartDate,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_objectionsClosed,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_objectionsOpen,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_pmtHeightChest,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_pstEnd,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_recommendedDate,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_resultOfPmtHeightChest,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_resultOfPst,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_resultOfWrittenExam,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_scrutinyEndDate,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_scrutinyResults,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_scrutinyStartDate,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_uploadedRevisedAnswerKey,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_uploadedAnswerKey,post.getsRNo());
			 getHibernateTemplate().bulkUpdate(DELETE_WrittenExam,post.getsRNo());
			
			 getHibernateTemplate().update(post);
			
			}
				else{
					getHibernateTemplate().save(post);
				}
			if(CommonUtils.isNotEmpty(post)) {
				UserEditLogsMIS userLogsObj=new UserEditLogsMIS();
				userLogsObj.setUserId(post.getUserId());
				userLogsObj.setDateOfEdit(new Date());
				
				getHibernateTemplate().save(userLogsObj);
			}
			if(CommonUtils.isNotEmpty(post.getAdvtPostedDateList())){
			for(int i=0;i<post.getAdvtPostedDateList().size();i++){
				post.getAdvtPostedDateList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			
			if(CommonUtils.isNotEmpty(post.getApplicationOpenList())){
			for(int i=0;i<post.getApplicationOpenList().size();i++){
				post.getApplicationOpenList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			if(CommonUtils.isNotEmpty(post.getApplicationClosedList())){
			for(int i=0;i<post.getApplicationClosedList().size();i++){
				post.getApplicationClosedList().get(i).setsRNo(post.getsRNo());
			}
			}

			
			if(CommonUtils.isNotEmpty(post.getAdmitCardsList())){
			for(int i=0;i<post.getAdmitCardsList().size();i++){
				post.getAdmitCardsList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			if(CommonUtils.isNotEmpty(post.getPstStartList())){
			for(int i=0;i<post.getPstStartList().size();i++){
				post.getPstStartList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			
			if(CommonUtils.isNotEmpty(post.getPstEndList())){
			for(int i=0;i<post.getPstEndList().size();i++){
				post.getPstEndList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			if(CommonUtils.isNotEmpty(post.getResultOfPstList())){
			for(int i=0;i<post.getResultOfPstList().size();i++){
				post.getResultOfPstList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			if(CommonUtils.isNotEmpty(post.getWrittenExamList())){
			for(int i=0;i<post.getWrittenExamList().size();i++){
				post.getWrittenExamList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			if(CommonUtils.isNotEmpty(post.getUploadingAnswerKeyList())){
			for(int i=0;i<post.getUploadingAnswerKeyList().size();i++){
				post.getUploadingAnswerKeyList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			if(CommonUtils.isNotEmpty(post.getUploadedRevisedAnswerKeyList())){
			for(int i=0;i<post.getUploadedRevisedAnswerKeyList().size();i++){
				post.getUploadedRevisedAnswerKeyList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			if(CommonUtils.isNotEmpty(post.getObjectionsOpenList())){
			for(int i=0;i<post.getObjectionsOpenList().size();i++){
				post.getObjectionsOpenList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			
			if(CommonUtils.isNotEmpty(post.getObjectionsClosedList())){
			for(int i=0;i<post.getObjectionsClosedList().size();i++){
				post.getObjectionsClosedList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			if(CommonUtils.isNotEmpty(post.getResultOfWrittenExamList())){
			for(int i=0;i<post.getResultOfWrittenExamList().size();i++){
				post.getResultOfWrittenExamList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			if(CommonUtils.isNotEmpty(post.getScrutinyStartDateList())){
			for(int i=0;i<post.getScrutinyStartDateList().size();i++){
				post.getScrutinyStartDateList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			if(CommonUtils.isNotEmpty(post.getScrutinyEndDateList())){
			for(int i=0;i<post.getScrutinyEndDateList().size();i++){
				post.getScrutinyEndDateList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			if(CommonUtils.isNotEmpty(post.getScrutinyResultsList())){
			for(int i=0;i<post.getScrutinyResultsList().size();i++){
				post.getScrutinyResultsList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			if(CommonUtils.isNotEmpty(post.getpMTHeightChestList())){
			for(int i=0;i<post.getpMTHeightChestList().size();i++){
				post.getpMTHeightChestList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			if(CommonUtils.isNotEmpty(post.getResultOfPmtHeightChestList())){
			for(int i=0;i<post.getResultOfPmtHeightChestList().size();i++){
				post.getResultOfPmtHeightChestList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			if(CommonUtils.isNotEmpty(post.getAdmitCardsForInterviewList())){
			for(int i=0;i<post.getAdmitCardsForInterviewList().size();i++){
				post.getAdmitCardsForInterviewList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			if(CommonUtils.isNotEmpty(post.getInterviewStartDateList())){
			for(int i=0;i<post.getInterviewStartDateList().size();i++){
				post.getInterviewStartDateList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			if(CommonUtils.isNotEmpty(post.getInterviewEndDateList())){
			for(int i=0;i<post.getInterviewEndDateList().size();i++){
				post.getInterviewEndDateList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			if(CommonUtils.isNotEmpty(post.getAnnouncementOfResultsList())){
			for(int i=0;i<post.getAnnouncementOfResultsList().size();i++){
				post.getAnnouncementOfResultsList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			if(CommonUtils.isNotEmpty(post.getRecommendedDateList())){
			for(int i=0;i<post.getRecommendedDateList().size();i++){
				post.getRecommendedDateList().get(i).setsRNo(post.getsRNo());
			}
			}
			
			
			
		} catch (Exception e) {
			logger.logError("updatePostDetails", "error while updating Department Details", e);
			throw e;
		}

		return post;
	}

	@Override
	public List<Department> loadAllDepartments() throws Exception {

		try {
			return (List<Department>) getHibernateTemplate().loadAll(Department.class);
		} catch (Exception e) {
			logger.logError("loadAllDepartments", "error while fetching Department Details", e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Police> getpostNameById(String sRNo, String aDvtNo, String status, String dEpartment,
			Integer dEpartmentId, String nExtStep) throws Exception {
		List<Police> refinedList = new ArrayList<Police>();
		try {

			DetachedCriteria criteria = DetachedCriteria.forClass(Police.class);
			if (CommonUtils.isNotEmpty(sRNo)) {
				criteria.add(Restrictions.like("nAmeOfPost", sRNo));
			}
			if (CommonUtils.isNotEmpty(aDvtNo)) {
				criteria.add(Restrictions.like("aDvtNo", aDvtNo));
			}
			if (CommonUtils.isNotEmpty(status)) {
				criteria.add(Restrictions.like("mAcroStatus", status));
			}
			if (CommonUtils.isNotEmpty(nExtStep)) {
				criteria.add(Restrictions.like("nExtStep", nExtStep));
			}
			if (CommonUtils.isNotEmpty(dEpartment)) {
				criteria.add(Restrictions.like("dEpartmentId", Integer.parseInt(dEpartment)));
			}
			if (CommonUtils.isNotEmpty(dEpartmentId)) {
				criteria.add(Restrictions.like("dEpartmentId", dEpartmentId));
			}

			// criteria.add(Restrictions.like(aDvtNo, aDvtNo,
			// MatchMode.ANYWHERE));
			refinedList = (List<Police>) getHibernateTemplate().findByCriteria(criteria);
			// refinedList=(List<Police>) getHibernateTemplate().find("from
			// Police where sRNo=? AND aDvtNo=?", new Object[]{sRNo, aDvtNo});
			if (CommonUtils.isNotEmpty(refinedList)) {
				return refinedList;
			} else {
				return null;
			}

		} catch (Exception e) {
			logger.logError("getpostNameById", "error while postNameById details", e);
		}
		return refinedList;
	}

	@Override
	@Transactional(readOnly = false)
	public Department addNewDepartment(Department department) throws Exception {
		try{
			getHibernateTemplate().saveOrUpdate(department);
		}catch(Exception e){
			logger.logError("addNewDepartment", "error while adding details", e);
		}
		 return department;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DepartmentVO> getGroupedPostListForDept(Integer dEpartmentId) throws Exception {
		List<DepartmentVO> groupedPostListForDept = new ArrayList<DepartmentVO>();
		try {
			if(CommonUtils.isEmpty(dEpartmentId)){
				groupedPostListForDept = (List<DepartmentVO>)getJdbcTemplate().query("select count(*) as totalPosts, "
						+ "d.dEpartment, nExtStep from police a, "
						+ " department d where a.dEpartmentId = d.dEpartmentId and  nExtStep!= 'NA' "
						+ "group by dEpartment,nExtStep order by d.dEpartment, nextstep ", 
						new RowMapper<DepartmentVO>(){
					@Override
					public DepartmentVO mapRow(final ResultSet resultSet, final int arg1) throws SQLException
					{
						final DepartmentVO depVo = new DepartmentVO();
						depVo.setCount(resultSet.getInt("totalPosts"));
						depVo.setDepartmentName(resultSet.getString("dEpartment"));
						depVo.setStatus(resultSet.getString("nExtStep"));
						return depVo;
					}				
			});
				
			}else{
				groupedPostListForDept = (List<DepartmentVO>)getJdbcTemplate().query("select count(*) as totalPosts, "
						+ "d.dEpartment, nExtStep from police a, "
						+ " department d where a.dEpartmentId = d.dEpartmentId and  nExtStep!= 'NA' "
						+ "group by dEpartment,nExtStep order by d.dEpartment, nextstep ", 
						new Object[]{dEpartmentId},
						new RowMapper<DepartmentVO>(){
					@Override
					public DepartmentVO mapRow(final ResultSet resultSet, final int arg1) throws SQLException
					{
						final DepartmentVO depVo = new DepartmentVO();
						depVo.setCount(resultSet.getInt("totalPosts"));
						depVo.setDepartmentName(resultSet.getString("dEpartment"));
						depVo.setStatus(resultSet.getString("nExtStep"));
						return depVo;
					}				
			}); 
			}
		} catch (Exception e) {
			logger.logError("getAllHsscPostListForDept", "error while fetching data for AllHsscPostListForDept", e);
			throw e;
		}
		return groupedPostListForDept;
	}
	
	public List<DepartmentVO> getUniqueNextStep(Integer dEpartmentId) throws Exception{
		List<DepartmentVO> nextStepList = new ArrayList<DepartmentVO>();
		try{
			if(CommonUtils.isEmpty(dEpartmentId)){
				nextStepList = (List<DepartmentVO>)getJdbcTemplate().query("select distinct nExtStep from police ",
						new RowMapper<DepartmentVO>(){
					@Override
					public DepartmentVO mapRow(final ResultSet resultSet, final int arg1) throws SQLException
					{
						final DepartmentVO depVo = new DepartmentVO();
						depVo.setStatus(resultSet.getString("nExtStep"));
						return depVo;
					}				
			});
				
			}else{
				nextStepList = (List<DepartmentVO>)getJdbcTemplate().query("select distinct nExtStep from police ",
						new Object[]{dEpartmentId},
						new RowMapper<DepartmentVO>(){
					@Override
					public DepartmentVO mapRow(final ResultSet resultSet, final int arg1) throws SQLException
					{
						final DepartmentVO depVo = new DepartmentVO();
						depVo.setStatus(resultSet.getString("nExtStep"));
						return depVo;
					}				
			}); 
			}			
		}catch(Exception e){
			
		}
		
		return nextStepList;
	}

	
	@Override
	public List<DepartmentVO> getStatusCountValue(String status,Integer dEpartmentId) {
		List<DepartmentVO> groupedPostListForDept=new ArrayList<DepartmentVO>();
		try {
			if(CommonUtils.isEmpty(dEpartmentId)){
				  String query=null;
				  if(status.equalsIgnoreCase("Advertisement Posted")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`, ifnull(a.advertisementPosted,'') as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join  advertisementposteddate a on  p.srno=a.srno where nExtStep='"+status+"'";
				   }
				  
				  if(status.equalsIgnoreCase("Applications Open")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`,ifnull(a.applicationopen,'')  as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join  applicationopendate  a on  p.srno=a.srno where nExtStep='"+status+"'";
				   }
				  
				  if(status.equalsIgnoreCase("Applications Close")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`,ifnull(a.applicationclosed,'')  as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join  applicationclosedate  a on  p.srno=a.srno where nExtStep='"+status+"'";
				   }
				  
				  if(status.equalsIgnoreCase("Admit Cards")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`,ifnull(a.admitcard,'')  as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join  admitcards  a on  p.srno=a.srno where nExtStep='"+status+"'";
				   }
				  
				  if(status.equalsIgnoreCase("PST Start(For Police only)")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`,ifnull(a.pststart,'')  as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join pststartdate a on  p.srno=a.srno where nExtStep='"+status+"'";
				   }
				  
				  if(status.equalsIgnoreCase("PST End(For Police only)")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`,ifnull(a.pstend,'')  as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join pstenddate a on  p.srno=a.srno where nExtStep='"+status+"'";
				   }
				  
				  if(status.equalsIgnoreCase("Result of PST(For Police only)")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`,ifnull(a.resultofpst,'')  as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join resultofpst a on  p.srno=a.srno where nExtStep='"+status+"'";
				   }
				  
				   if(status.equalsIgnoreCase("Written Exam")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`,ifnull(w.writtenexam,'') as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join  writtenexam w on  p.srno=w.srno where nExtStep='"+status+"'";
				   }
				   
				   if(status.equalsIgnoreCase("Uploading Answer Key")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`,ifnull(w.uploadingAnswerKey,'') as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join  uploadinganswerkey w on  p.srno=w.srno where nExtStep='"+status+"'";
				   }
				   
				   if(status.equalsIgnoreCase("Objections Open")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`,ifnull(w.objectionsOpen,'') as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join  objectionsopen w on  p.srno=w.srno where nExtStep='"+status+"'";
				   }
				   
				   if(status.equalsIgnoreCase("Objections Close")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`,ifnull(w.objectionsClosed,'') as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join  objectionsclosed w on  p.srno=w.srno where nExtStep='"+status+"'";
				   }
				   
				   if(status.equalsIgnoreCase("Upload Revised Answer Key")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`,ifnull(w.uploadedRevisedAnswerKey,'') as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join  uploadedrevisedanswerkey w on  p.srno=w.srno where nExtStep='"+status+"'";
				   }
				   
				   if(status.equalsIgnoreCase("Result of Written Exam")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`,ifnull(w.resultOfWrittenExam,'') as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join  resultofwrittenexam w on  p.srno=w.srno where nExtStep='"+status+"'";
				   }
				   
				   if(status.equalsIgnoreCase("Scrutiny")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`,ifnull(w.scrutinyStartDate,'') as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join  scrutinystartdate w on  p.srno=w.srno where nExtStep='"+status+"'";
				   }
				   
				   if(status.equalsIgnoreCase("Scrutiny Results")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`,ifnull(w.scrutinyResults,'') as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join  scrutinyresults w on  p.srno=w.srno where nExtStep='"+status+"'";
				   }
				   
				   if(status.equalsIgnoreCase("PMT Height-Chest (For Police only)")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`,ifnull(w.pmtHeightChest,'') as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join pmtheightchest w on  p.srno=w.srno where nExtStep='"+status+"'";
				   }
				   
				   if(status.equalsIgnoreCase("Admit Cards(for Interview)")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`,ifnull(w.admitCardsForInterview,'') as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join admitcardsforinterview w on  p.srno=w.srno where nExtStep='"+status+"'";
				   }
				   
				   if(status.equalsIgnoreCase("Interviews")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`,ifnull(w.interviewStartDate,'') as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join interviewstartdate w on  p.srno=w.srno where nExtStep='"+status+"'";
				   }
				   
				   if(status.equalsIgnoreCase("Recommend")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`,ifnull(w.recommendedDate,'') as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join recommendeddate w on  p.srno=w.srno where nExtStep='"+status+"'";
				   }
				   
				   if(status.equalsIgnoreCase("Announcement of Final Result")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`,ifnull(w.announcementOfResults,'') as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join announcementofresults w on  p.srno=w.srno where nExtStep='"+status+"'";
				   }
				   
				   if(status.equalsIgnoreCase("Joining")) {
				         query="SELECT `aDvtNo`, `cAtNo`, `nAmeOfPost`,`nExtStep`, `nOOfPosts`, ifnull(w.recommendedDate,'') as LastStepDate\r\n" + 
				  		"\r\n" + 
				  		"FROM `police` p left join recommendeddate w on  p.srno=w.srno where nExtStep='"+status+"'";
				   }
				   
				groupedPostListForDept = (List<DepartmentVO>)getJdbcTemplate().query(query, 
						new RowMapper<DepartmentVO>(){
					@Override
					public DepartmentVO mapRow(final ResultSet resultSet, final int arg1) throws SQLException
					{
						final DepartmentVO depVo = new DepartmentVO();
						depVo.setAdvtNo(resultSet.getString("aDvtNo"));
						depVo.setCatNo(resultSet.getInt("cAtNo"));
						depVo.setnAmeOfPost(resultSet.getString("nAmeOfPost"));
						depVo.setStatus(resultSet.getString("nExtStep"));
						depVo.setnOOfPosts(resultSet.getLong("nOOfPosts"));
						depVo.setNextStepDate(resultSet.getDate("lastStepDate"));
						return depVo;
					}				
			});
				
			}else{
				groupedPostListForDept = (List<DepartmentVO>)getJdbcTemplate().query("select count(*) as totalPosts, "
						+ "d.dEpartment, nExtStep, nOOfPosts from police a, "
						+ " department d where a.dEpartmentId = d.dEpartmentId and nExtStep="+"'"+status+"'"
						+ " group by dEpartment,nExtStep, nOOfPosts order by d.dEpartment, nextstep, nOOfPosts ", 
						new Object[]{dEpartmentId},
						new RowMapper<DepartmentVO>(){
					@Override
					public DepartmentVO mapRow(final ResultSet resultSet, final int arg1) throws SQLException
					{
						final DepartmentVO depVo = new DepartmentVO();
						depVo.setCount(resultSet.getInt("totalPosts"));
						depVo.setDepartmentName(resultSet.getString("dEpartment"));
						depVo.setStatus(resultSet.getString("nExtStep"));
						depVo.setnOOfPosts(resultSet.getLong("nOOfPosts"));
						return depVo;
					}				
			}); 
			}
		} catch (Exception e) {
			logger.logError("getStatusCountValue", "error while fetching data for AllHsscPostListForDept", e);
			
		}
		return groupedPostListForDept;
	}

	@Override
	public List<String> getUniqueMacroStatusList() {
		List<String> UniqueMacroStatusList=new ArrayList<String>();
		try {
		
			UniqueMacroStatusList = (List<String>)getJdbcTemplate().query("select distinct mAcroStatus from police ",
					new RowMapper<String>(){
				@Override
				public String mapRow(final ResultSet resultSet, final int arg1) throws SQLException
				{	
					return resultSet.getString("mAcroStatus");
				}				
		});
			if(CommonUtils.isNotEmpty(UniqueMacroStatusList)) {
				return 	UniqueMacroStatusList;
				}else {
				return null;	
				}		
		}catch(Exception e) {
			logger.logError("getUniqueMacroStatusList", "error while fetching data for getUniqueMacroStatusList", e);		
		}
		return null;
	}

	@Override
	public List<Police> getHsscPostList(String dEpartmentId, String mAcroStatus, String nameOfPost,String startDate,String endDate) {
		List<Police> list=new ArrayList<Police>();
		try {
			String policeDataQuery="SELECT * FROM police ";
	        //MapSqlParameterSource parameters = new MapSqlParameterSource();			
			if(CommonUtils.isNotEmpty(startDate)) {
				policeDataQuery=policeDataQuery+" p left join advertisementposteddate a on p.srno=a.srno " + 
						"WHERE a.advertisementPosted >='"+startDate+"' ";
			}
			if(CommonUtils.isNotEmpty(endDate)) {
				if(policeDataQuery.contains("WHERE")) {
				policeDataQuery=policeDataQuery+" AND a.advertisementPosted <='"+endDate+"' ";
				}
				else {
					policeDataQuery=policeDataQuery+" WHERE a.advertisementPosted <='"+endDate+"' ";
					}
			}
			if(CommonUtils.isNotEmpty(mAcroStatus) && !(mAcroStatus.contains("MacroStatus...")))
	        {	if(policeDataQuery.contains("WHERE")) {			
	        	policeDataQuery = policeDataQuery + " AND mAcroStatus ='"+mAcroStatus+"'";
	        }else {
	        	policeDataQuery = policeDataQuery + "  WHERE mAcroStatus ='"+mAcroStatus+"'";	
	        }
	          
	        }
			if(CommonUtils.isNotEmpty(dEpartmentId) && !(dEpartmentId.contains("Department..."))) {
				if(policeDataQuery.contains("WHERE")) {
					policeDataQuery = policeDataQuery + " AND dEpartmentId ="+dEpartmentId;
		           
				}else {
					policeDataQuery = policeDataQuery + " WHERE dEpartmentId ="+dEpartmentId;
		          
				}
			}
			if(CommonUtils.isNotEmpty(nameOfPost) && !(nameOfPost.contains("Name Of Post..."))) {
				if(policeDataQuery.contains("WHERE")) {
					policeDataQuery = policeDataQuery + " AND nAmeOfPost ='"+nameOfPost+"'";
		           
				}else {
					policeDataQuery = policeDataQuery + " WHERE nAmeOfPost ='"+nameOfPost+"'";
		          
				}
			}

			
			list = (List<Police>)getJdbcTemplate().query(policeDataQuery,new RowMapper<Police>(){
				@Override
				public Police mapRow(final ResultSet resultSet, final int arg1) throws SQLException
				{	
					Police obj=new Police();
					obj.setsRNo(resultSet.getInt("sRNo"));
					obj.setmAcroStatus(resultSet.getString("mAcroStatus"));
					obj.setnExtStep(resultSet.getString("nExtStep"));
					obj.setnOOfPosts(resultSet.getInt("nOOfPosts"));
					obj.setnAmeOfPost(resultSet.getString("nAmeOfPost"));
					 return obj;
				}				
		});	
			
		if(CommonUtils.isNotEmpty(list)) {
		return list;	
		}else {
			return null;
		}
		}catch(Exception e) {
			logger.logError("getHsscPostList", "error while fetching data for getHsscPostList", e);	
		}
		return null;
	}

	@Override
	public List<Department> getDepartmentList() {
		List<Department> deptList=new ArrayList<Department>();
		try {
			deptList = (List<Department>)getJdbcTemplate().query("SELECT * FROM department"
					,new RowMapper<Department>(){
				@Override
				public Department mapRow(final ResultSet resultSet, final int arg1) throws SQLException
				{	
					Department obj=new Department();
					obj.setdEpartment(resultSet.getString("dEpartment"));
					obj.setdEpartmentId(resultSet.getInt("dEpartmentId"));
					 return obj;
				}				
			});	
			if(CommonUtils.isNotEmpty(deptList)) {
				return deptList;	
				}else {
					return null;
				}
		}catch(Exception e) {
			logger.logError("getDepartmentList", "error while fetching data for getDepartmentList", e);		
		}
		return null;
	}

	@Override
	public List<String> getUniqueNameOfPostList() {
		List<String> list=new ArrayList<String>();
		try {
		
			list = (List<String>)getJdbcTemplate().query("select distinct nAmeOfPost from police ",
					new RowMapper<String>(){
				@Override
				public String mapRow(final ResultSet resultSet, final int arg1) throws SQLException
				{	
					return resultSet.getString("nAmeOfPost");
				}				
		});
			if(CommonUtils.isNotEmpty(list)) {
				return 	list;
				}else {
				return null;	
				}		
			
		}catch(Exception e) {
			logger.logError("getUniqueNameOfPostList", "error while fetching data for getUniqueNameOfPostList", e);		
		}
		return null;
	}

	public List<DepartmentVO> getAllRequisitionData(Integer sessionDepart, Police searcPolice) throws Exception{
	    	List<DepartmentVO> deptList=new ArrayList<DepartmentVO>();
		try {
			    String query="select `nAmeOfPost`, `nOOfPosts` from police";
			    
			    if(CommonUtils.isNotEmpty(sessionDepart)) {
			    	query=query+ " WHERE dEpartmentId='"+sessionDepart+"'";
			    }
			    if(CommonUtils.isNotEmpty(searcPolice.getdEpartmentId()) && searcPolice.getdEpartmentId().intValue()!=0) {
			    	query=query+ " WHERE dEpartmentId='"+searcPolice.getdEpartmentId()+"'";
			    }
			    if(CommonUtils.isNotEmpty(searcPolice.getmAcroStatus())) {
			    	if(searcPolice.getmAcroStatus().contains("Search Macro Status...")) {
			    		if(query.contains("WHERE")) {
				    		query=query+ " AND mAcroStatus!='Withdrawn'";
				    	}
				    	else {
				    		query=query+ " WHERE mAcroStatus!='Withdrawn'";
				    	}
			    	}
			    	else {
			    		if(query.contains("WHERE")) {
				    		query=query+ " AND mAcroStatus='"+searcPolice.getmAcroStatus()+"'";
				    	}
				    	else {
				    		query=query+ " WHERE mAcroStatus='"+searcPolice.getmAcroStatus()+"'";
				    	}
			    	}	
			    	
			    } 
			    if(CommonUtils.isNotEmpty(searcPolice.getnAmeOfPost()) && !searcPolice.getnAmeOfPost().contains("Search Post Name...")) {
			    	if(query.contains("WHERE")) {
			    		query=query+ " AND nAmeOfPost='"+searcPolice.getnAmeOfPost()+"'";
			    	}
			    	else {
			    		query=query+ " WHERE nAmeOfPost='"+searcPolice.getnAmeOfPost()+"'";
			    	}
			    }
			    
			    if(CommonUtils.isNotEmpty(searcPolice.getaDvtNo()) && !searcPolice.getaDvtNo().contains("Search Advertisement Number...")) {
			    	if(query.contains("WHERE")) {
			    		query=query+ " AND aDvtNo='"+searcPolice.getaDvtNo()+"'";
			    	}
			    	else {
			    		query=query+ " WHERE aDvtNo='"+searcPolice.getaDvtNo()+"'";
			    	}
			    }
			    
			    if(CommonUtils.isNotEmpty(searcPolice.getnExtStep()) && !searcPolice.getnExtStep().contains("Search Next Step...")) {
			    	if(query.contains("WHERE")) {
			    		query=query+ " AND nExtStep='"+searcPolice.getnExtStep()+"'";
			    	}
			    	else {
			    		query=query+ " WHERE nExtStep='"+searcPolice.getnExtStep()+"'";
			    	}
			    }
			    
			deptList = (List<DepartmentVO>)getJdbcTemplate().query(query
					,new RowMapper<DepartmentVO>(){
				@Override
				public DepartmentVO mapRow(final ResultSet resultSet, final int arg1) throws SQLException
				{	
					DepartmentVO obj=new DepartmentVO();
					obj.setnAmeOfPost(resultSet.getString("nAmeOfPost"));
					obj.setnOOfPosts(resultSet.getLong("nOOfPosts"));
					 return obj;
				}				
			});	
			if(CommonUtils.isNotEmpty(deptList)) {
				return deptList;	
				}else {
					return null;
				}
			
		}catch(Exception e) {
			logger.logError("getAllRequisitionData", "error while fetching data for getAllRequisitionData", e);		
		}
		return null;
	}

	@Override
	@Transactional(readOnly=false)
	public void savePathForDepartmentDocs(DepartmentDocs deptObj) throws Exception {
		try {
			String DELETE_Docs= "delete from DepartmentDocs where sRNo=?";
			getHibernateTemplate().bulkUpdate(DELETE_Docs,deptObj.getsRNo());
			getHibernateTemplate().save(deptObj);
		}catch(Exception e) {
			logger.logError("savePathForDepartmentDocs", "error while fetching saving path", e);		
		}
		
	}
	
	@Override
	public EmailTemplate getemailTemplateCode(String emailtype) throws Exception{
		try{
		DetachedCriteria criteria=DetachedCriteria.forClass(EmailTemplate.class);
		criteria.add(Restrictions.eq("emailType", emailtype));
		@SuppressWarnings("unchecked")
		List<EmailTemplate> list=(List<EmailTemplate>) getHibernateTemplate().findByCriteria(criteria);
		if(CommonUtils.isNotEmpty(list)){
		return list.get(0);	
		}else{
			return null;
		}
		}catch(Exception e){
			logger.logError("getemailTemplateCode", "error fetching data  at DAO level", e);	
		}
		return null;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEditLogs> getLastUpdateTime() throws Exception {
		try {
			DetachedCriteria criteria=DetachedCriteria.forClass(UserEditLogs.class);
			criteria.setProjection(Projections.max("dateOfEdit"));
			List<UserEditLogs> list=(List<UserEditLogs>) getHibernateTemplate().findByCriteria(criteria);
			if(CommonUtils.isNotEmpty(list)){
			return list;	
			}else{
				return null;
			}
			
		}catch(Exception e) {
			logger.logError("getLastUpdateTime", "error fetching data  at DAO level", e);	
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEditLogsMIS> getMISLastUpdateTime() throws Exception {
		try {
			DetachedCriteria criteria=DetachedCriteria.forClass(UserEditLogsMIS.class);
			criteria.setProjection(Projections.max("dateOfEdit"));
			List<UserEditLogsMIS> list=(List<UserEditLogsMIS>) getHibernateTemplate().findByCriteria(criteria);
			if(CommonUtils.isNotEmpty(list)){
			return list;	
			}else{
				return null;
			}
			
		}catch(Exception e) {
			logger.logError("getLastUpdateTime", "error fetching data  at DAO level", e);	
		}
		return null;
	}

	@Transactional(readOnly=false)
	@Override
	public UserLogin saveUserInfo(UserLogin userObj) throws Exception {
		try {
			String password = userObj.getUserPassword();
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());

			byte byteData[] = md.digest();

			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				String hex = Integer.toHexString(0xff & byteData[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			userObj.setUserPassword(hexString.toString());
			
		    getHibernateTemplate().save(userObj);
		}catch(Exception e) {
			logger.logError("saveUserInfo", "error while saving user", e);	
		}
		return userObj;
	}
	
	
	@SuppressWarnings("unchecked")
	public UserLogin getVerifiedUserByDeptId(Integer idDept) throws Exception{
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(UserLogin.class);
			criteria.add(Restrictions.eq("idDept", idDept));
			List<UserLogin> recordList = (List<UserLogin>) getHibernateTemplate().findByCriteria(criteria);
			if (CommonUtils.isNotEmpty(recordList)) {
				return recordList.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.logError("getUser", "error while fetching value", e);
			throw e;
		}
	}

	@Transactional(readOnly=false)
	@Override
	public void saveLoginHistory(UserHistory userHisObj) throws Exception {
		try {
			getHibernateTemplate().save(userHisObj);
		}catch(Exception e) {
			logger.logError("saveLoginHistory", "error while userInfo", e);
			throw e;
		}
		
	}

	@Override
	public void saveLogOutHistory(UserHistory userHisObj) throws Exception {
		try{
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			 Query qry = session.createSQLQuery("update userhistory as l set l.loggedOutTime= ? where l.userId= ?");
		     qry.setParameter(0,userHisObj.getLoggedOutTime());
		     qry.setParameter(1,userHisObj.getUserId());
			 int res = qry.executeUpdate(); 
			 
			 System.out.println("query Executed successfully"+res);
			tx.commit();
			session.close();
			}catch(Exception e){
				logger.logError("saveLogOutHistory", "error while savingLogout info", e);
				throw e;
			}		
		
	}

	@Override
	public List<Police> getAllDistinctPostName() throws Exception {
		List<Police> AllHsscPostListForDept = new ArrayList<Police>();
		try {
		AllHsscPostListForDept = (List<Police>)getJdbcTemplate().query("select distinct nAmeOfPost from police ", 
				new RowMapper<Police>(){
			@Override
			public Police mapRow(final ResultSet resultSet, final int arg1) throws SQLException
			{
				final Police police = new Police();
				police.setnAmeOfPost(resultSet.getString("nAmeOfPost"));
				return police;
			}				
	});
	} catch (Exception e) {
		logger.logError("getAllDistinctPostName", "error while fetching data for distinct posts", e);
		throw e;
	}
	return AllHsscPostListForDept;
}

	@Override
	public List<NextStepsAdvt> getAllNextSteps() throws Exception {
		List<NextStepsAdvt> AllNextSteps = new ArrayList<NextStepsAdvt>();
	   try {
		   AllNextSteps = (List<NextStepsAdvt>)getJdbcTemplate().query("select distinct nextStep from nextsteps", 
					new RowMapper<NextStepsAdvt>(){
				@Override
				public NextStepsAdvt mapRow(final ResultSet resultSet, final int arg1) throws SQLException
				{
					final NextStepsAdvt nextsteps = new NextStepsAdvt();
					nextsteps.setNextStep(resultSet.getString("nextStep"));
					return nextsteps;
				}				
		});
	   }catch(Exception e) {
		   logger.logError("getAllNextSteps", "error while fetching data for next steps", e);
			throw e;
	   }
		return AllNextSteps;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Department getdepartmentByDepartmentId(Integer idDept) throws Exception {
		try {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		criteria.add(Restrictions.eq("dEpartmentId", idDept));
		List<Department> recordList = (List<Department>) getHibernateTemplate().findByCriteria(criteria);
		if (CommonUtils.isNotEmpty(recordList)) {
			return recordList.get(0);
		} else {
			return null;
		}
	} catch (Exception e) {
		logger.logError("getUser", "error while fetching value", e);
		throw e;
	}
	}		

}
