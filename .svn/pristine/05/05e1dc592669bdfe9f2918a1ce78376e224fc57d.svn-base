package in.hkcl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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
import in.hkcl.model.AdvtStatusForSPE;
import in.hkcl.model.BifurcationHelper;
import in.hkcl.model.Department;
import in.hkcl.model.HsscConfig;
import in.hkcl.model.Notifications;
import in.hkcl.model.PostGroup;
import in.hkcl.model.PostMaster;
import in.hkcl.model.RequisitionDocs;
import in.hkcl.model.RequisitionInfo;
import in.hkcl.model.RequisitionInfoRemarks;
import in.hkcl.model.RequisitionReport;
import in.hkcl.model.RequisitionReservationInfo;
import in.hkcl.model.SeatsBifurcation;
import in.hkcl.model.SmsReceivers;
import in.hkcl.model.UserLogin;
import in.hkcl.model.ValidateBifurcation;
import in.hkcl.model.ValidateBifurcationCounts;
import in.hkcl.utils.ApplicationLogFactory;
import in.hkcl.utils.ApplicationLogger;
import in.hkcl.utils.CommonUtils;

public class RequisitionDAOImpl extends DaoSupport implements RequisitionDao {

	private static ApplicationLogger logger = ApplicationLogFactory.getLogger(RequisitionDAOImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	@Transactional(readOnly = false)
	public RequisitionInfo saveRequisitionForm(RequisitionInfo reqObj) throws Exception {
		try {
			getHibernateTemplate().save(reqObj);	
			reqObj.setUniqueRequisitionNumber("REQ-" + reqObj.getIdRequisition());
			/*-----------------Seats Bifurcation------------------------*/
/*			String[] categoryArr = {"GENERAL","GENERAL", "SC","SC","SC","BCA", "BCA","BCA","BCB","BCB","BCB", "SBC", "EBPGC"};
			String[] subCategoryArr = {"ESM","ESP", "None","ESM","ESP", "None","ESM","ESP", "None","ESM","ESP", "None", "None"};
			int[] valueArr = new int[13];
			
			int index = 0;
			for(String category : categoryArr) {				
				int value=getvalueAfterSeatBifurcation(reqObj.getNumberOfPostToBeFilled(),category,subCategoryArr[index]);		
				valueArr[index] = value;
				index++;				
			}
			
			//General
			prepareAndSaveReqResObject(reqObj, "GENERAL", "Total", reqObj.getNumberOfPostToBeFilled()- valueArr[2] - valueArr[5] - valueArr[8] - valueArr[11] - valueArr[12],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "GENERAL", "NonESMESP", reqObj.getNumberOfPostToBeFilled()- valueArr[2] - valueArr[5] - valueArr[8] - valueArr[11] - valueArr[12] - valueArr[0] - valueArr[1],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "GENERAL", "ESM", valueArr[0],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "GENERAL", "ESP", valueArr[1],reqObj.getIdRequisition(),"CALCULATED");

			//SC
			prepareAndSaveReqResObject(reqObj, "SC", "Total", valueArr[2],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "SC", "ESM", valueArr[3],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "SC", "ESP", valueArr[4],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "SC", "NonESMESP", valueArr[2] - valueArr[3] -valueArr[4],reqObj.getIdRequisition(),"CALCULATED");
			
			//BCA
			prepareAndSaveReqResObject(reqObj, "BCA", "Total", valueArr[5],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "BCA", "ESM", valueArr[6],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "BCA", "ESP", valueArr[7],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "BCA", "NonESMESP", valueArr[5] - valueArr[6] -valueArr[7],reqObj.getIdRequisition(),"CALCULATED");
			
			//BCB
			prepareAndSaveReqResObject(reqObj, "BCB", "Total", valueArr[8],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "BCB", "ESM", valueArr[9],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "BCB", "ESP", valueArr[10],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "BCB", "NonESMESP", valueArr[8] - valueArr[9] -valueArr[10],reqObj.getIdRequisition(),"CALCULATED");
			
			//SBC
			prepareAndSaveReqResObject(reqObj, "SBC", "Total", valueArr[11],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "SBC", "ESM", 0,reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "SBC", "ESP", 0,reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "SBC", "NonESMESP", valueArr[11],reqObj.getIdRequisition(),"CALCULATED");

			//EBPGC
			prepareAndSaveReqResObject(reqObj, "EBPGC", "Total", valueArr[12],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "EBPGC", "ESM", 0,reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "EBPGC", "ESP", 0,reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "EBPGC", "NonESMESP", valueArr[12],reqObj.getIdRequisition(),"CALCULATED");
			
			prepareAndSaveReqResObject(reqObj, "PWD", "None", Math.round((reqObj.getNumberOfPostToBeFilled()*4)/100),reqObj.getIdRequisition(),"CALCULATED");
			
			//General
			prepareAndSaveReqResObject(reqObj, "GENERAL", "Total", reqObj.getNumberOfPostToBeFilled()- valueArr[2] - valueArr[5] - valueArr[8] - valueArr[11] - valueArr[12],reqObj.getIdRequisition(),"FILLED");
			prepareAndSaveReqResObject(reqObj, "GENERAL", "NonESMESP", reqObj.getNumberOfPostToBeFilled()- valueArr[2] - valueArr[5] - valueArr[8] - valueArr[11] - valueArr[12] - valueArr[0] - valueArr[1],reqObj.getIdRequisition(),"FILLED");
			prepareAndSaveReqResObject(reqObj, "GENERAL", "ESM", valueArr[0],reqObj.getIdRequisition(),"FILLED");
			prepareAndSaveReqResObject(reqObj, "GENERAL", "ESP", valueArr[1],reqObj.getIdRequisition(),"FILLED");

			//SC
			prepareAndSaveReqResObject(reqObj, "SC", "Total", valueArr[2],reqObj.getIdRequisition(),"FILLED");
			prepareAndSaveReqResObject(reqObj, "SC", "ESM", valueArr[3],reqObj.getIdRequisition(),"FILLED");
			prepareAndSaveReqResObject(reqObj, "SC", "ESP", valueArr[4],reqObj.getIdRequisition(),"FILLED");
			prepareAndSaveReqResObject(reqObj, "SC", "NonESMESP", valueArr[2] - valueArr[3] -valueArr[4],reqObj.getIdRequisition(),"FILLED");
			
			//BCA
			prepareAndSaveReqResObject(reqObj, "BCA", "Total", valueArr[5],reqObj.getIdRequisition(),"FILLED");
			prepareAndSaveReqResObject(reqObj, "BCA", "ESM", valueArr[6],reqObj.getIdRequisition(),"FILLED");
			prepareAndSaveReqResObject(reqObj, "BCA", "ESP", valueArr[7],reqObj.getIdRequisition(),"FILLED");
			prepareAndSaveReqResObject(reqObj, "BCA", "NonESMESP", valueArr[5] - valueArr[6] -valueArr[7],reqObj.getIdRequisition(),"FILLED");
			
			//BCB
			prepareAndSaveReqResObject(reqObj, "BCB", "Total", valueArr[8],reqObj.getIdRequisition(),"FILLED");
			prepareAndSaveReqResObject(reqObj, "BCB", "ESM", valueArr[9],reqObj.getIdRequisition(),"FILLED");
			prepareAndSaveReqResObject(reqObj, "BCB", "ESP", valueArr[10],reqObj.getIdRequisition(),"FILLED");
			prepareAndSaveReqResObject(reqObj, "BCB", "NonESMESP", valueArr[8] - valueArr[9] -valueArr[10],reqObj.getIdRequisition(),"FILLED");
			
			//SBC
			prepareAndSaveReqResObject(reqObj, "SBC", "Total", valueArr[11],reqObj.getIdRequisition(),"FILLED");
			prepareAndSaveReqResObject(reqObj, "SBC", "ESM", 0,reqObj.getIdRequisition(),"FILLED");
			prepareAndSaveReqResObject(reqObj, "SBC", "ESP", 0,reqObj.getIdRequisition(),"FILLED");
			prepareAndSaveReqResObject(reqObj, "SBC", "NonESMESP", valueArr[11],reqObj.getIdRequisition(),"FILLED");

			//EBPGC
			prepareAndSaveReqResObject(reqObj, "EBPGC", "Total", valueArr[12],reqObj.getIdRequisition(),"FILLED");
			prepareAndSaveReqResObject(reqObj, "EBPGC", "ESM", 0,reqObj.getIdRequisition(),"FILLED");
			prepareAndSaveReqResObject(reqObj, "EBPGC", "ESP", 0,reqObj.getIdRequisition(),"FILLED");
			prepareAndSaveReqResObject(reqObj, "EBPGC", "NonESMESP", valueArr[12],reqObj.getIdRequisition(),"FILLED");*/
			
			
			if(CommonUtils.isNotEmpty(reqObj.getBifurcationList())) {
				 for(BifurcationHelper bifurObj:reqObj.getBifurcationList()) {
					 
					  if(bifurObj.getCategory().contains("GENERAL")) {
						  if(CommonUtils.isNotEmpty(bifurObj.getTotalCount())) {
							  reqObj.setBacklog(bifurObj.getTotalCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"Total", bifurObj.getTotalCount(),reqObj.getIdRequisition(),"FILLED");
						  }
						  if(CommonUtils.isNotEmpty(bifurObj.getNonEsmEspCount())) {
							  reqObj.setBacklog(bifurObj.getNonEsmEspCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"NonESMESP", bifurObj.getNonEsmEspCount(),reqObj.getIdRequisition(),"FILLED");
						  }
						  if(CommonUtils.isNotEmpty(bifurObj.getEsmCount())) {
							  reqObj.setBacklog(bifurObj.getEsmCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESM", bifurObj.getEsmCount(),reqObj.getIdRequisition(),"FILLED");
						  }
						  if(CommonUtils.isNotEmpty(bifurObj.getEspCount())) {
							  reqObj.setBacklog(bifurObj.getEspCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESP", bifurObj.getEspCount(),reqObj.getIdRequisition(),"FILLED");
						  }  
						  
						  
					  }
					  if(bifurObj.getCategory().contains("SC")) {
						  if(CommonUtils.isNotEmpty(bifurObj.getTotalCount())) {
							  reqObj.setBacklog(bifurObj.getTotalCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"Total", bifurObj.getTotalCount(),reqObj.getIdRequisition(),"FILLED");
						  }
						  if(CommonUtils.isNotEmpty(bifurObj.getNonEsmEspCount())) {
							  reqObj.setBacklog(bifurObj.getNonEsmEspCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"NonESMESP", bifurObj.getNonEsmEspCount(),reqObj.getIdRequisition(),"FILLED");
						  }
						  if(CommonUtils.isNotEmpty(bifurObj.getEsmCount())) {
							  reqObj.setBacklog(bifurObj.getEsmCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESM", bifurObj.getEsmCount(),reqObj.getIdRequisition(),"FILLED");
						  }
						  if(CommonUtils.isNotEmpty(bifurObj.getEspCount())) {
							  reqObj.setBacklog(bifurObj.getEspCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESP", bifurObj.getEspCount(),reqObj.getIdRequisition(),"FILLED");
						  }  
					  }
					  if(bifurObj.getCategory().contains("BCA")) {
						  if(CommonUtils.isNotEmpty(bifurObj.getTotalCount())) {
							  reqObj.setBacklog(bifurObj.getTotalCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"Total", bifurObj.getTotalCount(),reqObj.getIdRequisition(),"FILLED");
						  }
						  if(CommonUtils.isNotEmpty(bifurObj.getNonEsmEspCount())) {
							  reqObj.setBacklog(bifurObj.getNonEsmEspCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"NonESMESP", bifurObj.getNonEsmEspCount(),reqObj.getIdRequisition(),"FILLED");
						  }
						  if(CommonUtils.isNotEmpty(bifurObj.getEsmCount())) {
							  reqObj.setBacklog(bifurObj.getEsmCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESM", bifurObj.getEsmCount(),reqObj.getIdRequisition(),"FILLED");
						  }
						  if(CommonUtils.isNotEmpty(bifurObj.getEspCount())) {
							  reqObj.setBacklog(bifurObj.getEspCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESP", bifurObj.getEspCount(),reqObj.getIdRequisition(),"FILLED");
						  }  
					  }
					  if(bifurObj.getCategory().contains("BCB")) {
						  if(CommonUtils.isNotEmpty(bifurObj.getTotalCount())) {
							  reqObj.setBacklog(bifurObj.getTotalCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"Total", bifurObj.getTotalCount(),reqObj.getIdRequisition(),"FILLED");
						  }
						  if(CommonUtils.isNotEmpty(bifurObj.getNonEsmEspCount())) {
							  reqObj.setBacklog(bifurObj.getNonEsmEspCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"NonESMESP", bifurObj.getNonEsmEspCount(),reqObj.getIdRequisition(),"FILLED");
						  }
						  if(CommonUtils.isNotEmpty(bifurObj.getEsmCount())) {
							  reqObj.setBacklog(bifurObj.getEsmCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESM", bifurObj.getEsmCount(),reqObj.getIdRequisition(),"FILLED");
						  }
						  if(CommonUtils.isNotEmpty(bifurObj.getEspCount())) {
							  reqObj.setBacklog(bifurObj.getEspCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESP", bifurObj.getEspCount(),reqObj.getIdRequisition(),"FILLED");
						  }  
					  }
					 /* if(bifurObj.getCategory().contains("SBC")) {
						  if(CommonUtils.isNotEmpty(bifurObj.getTotalCount())) {
							  reqObj.setBacklog(bifurObj.getTotalCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"Total", bifurObj.getTotalCount(),reqObj.getIdRequisition(),"FILLED");
						  }
						  if(CommonUtils.isNotEmpty(bifurObj.getNonEsmEspCount())) {
							  reqObj.setBacklog(bifurObj.getNonEsmEspCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"NonESMESP", bifurObj.getNonEsmEspCount(),reqObj.getIdRequisition(),"FILLED");
						  }
						  if(CommonUtils.isNotEmpty(bifurObj.getEsmCount())) {
							  reqObj.setBacklog(bifurObj.getEsmCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESM", bifurObj.getEsmCount(),reqObj.getIdRequisition(),"FILLED");
						  }
						  if(CommonUtils.isNotEmpty(bifurObj.getEspCount())) {
							  reqObj.setBacklog(bifurObj.getEspCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESP", bifurObj.getEspCount(),reqObj.getIdRequisition(),"FILLED");
						  }  
					  }*/
					  if(bifurObj.getCategory().contains("EWS")) {
						  if(CommonUtils.isNotEmpty(bifurObj.getTotalCount())) {
							  reqObj.setBacklog(bifurObj.getTotalCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"Total", bifurObj.getTotalCount(),reqObj.getIdRequisition(),"FILLED");
						  }
						  if(CommonUtils.isNotEmpty(bifurObj.getNonEsmEspCount())) {
							  reqObj.setBacklog(bifurObj.getNonEsmEspCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"NonESMESP", bifurObj.getNonEsmEspCount(),reqObj.getIdRequisition(),"FILLED");
						  }
						  if(CommonUtils.isNotEmpty(bifurObj.getEsmCount())) {
							  reqObj.setBacklog(bifurObj.getEsmCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESM", bifurObj.getEsmCount(),reqObj.getIdRequisition(),"FILLED");
						  }
						  if(CommonUtils.isNotEmpty(bifurObj.getEspCount())) {
							  reqObj.setBacklog(bifurObj.getEspCountBackLog());
							  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESP", bifurObj.getEspCount(),reqObj.getIdRequisition(),"FILLED");
						  }  
					  }
				}
					
			}
			
			for(RequisitionReservationInfo info : reqObj.getRequisitionReservationInfoList()) {
				if(CommonUtils.isNotEmpty(info.getCategory())) {
					info.setIdRequisition(reqObj.getIdRequisition());
					info.setUniqueRequisitionNumber(reqObj.getUniqueRequisitionNumber());
					getHibernateTemplate().save(info);					
				}
			}
			
			//prepareAndSaveReqResObject(reqObj, "PWD", "None", Math.round((reqObj.getNumberOfPostToBeFilled()*4)/100),reqObj.getIdRequisition(),"FILLED");
			
			logger.logInfo("saveRequisitionForm", "successfully saved reservation");
			
		} catch (Exception e) {
			logger.logError("saveRequisitionForm", "exception while saving requisition form", e);
		}
		return reqObj;
	}
	@Override
	public List<BifurcationHelper> getBifucatedValues(String noOfPosts, String prevRosterPoint) throws Exception {
		List<BifurcationHelper> bifurcatedList=new ArrayList<BifurcationHelper>();
		BifurcationHelper generalBifurcation=new BifurcationHelper();
		BifurcationHelper scBifurcation=new BifurcationHelper();
		BifurcationHelper BCABifurcation=new BifurcationHelper();
		BifurcationHelper BCBBifurcation=new BifurcationHelper();
		BifurcationHelper SBCBifurcation=new BifurcationHelper();
		BifurcationHelper EBPGCBifurcation=new BifurcationHelper();
		try {
	    RequisitionInfo reqObj=new RequisitionInfo();
		reqObj.setNumberOfPostToBeFilled(Integer.parseInt(noOfPosts));
			
		String[] categoryArr = {"GENERAL","GENERAL", "SC","SC","SC","BCA", "BCA","BCA","BCB","BCB","BCB", "SBC", "EBPGC"};
		String[] subCategoryArr = {"ESM","ESP", "None","ESM","ESP", "None","ESM","ESP", "None","ESM","ESP", "None", "None"};
		int[] valueArr = new int[13];
		
		int index = 0;
		for(String category : categoryArr) {
			int value=getvalueAfterSeatBifurcation(Integer.parseInt(prevRosterPoint), reqObj.getNumberOfPostToBeFilled(),category,subCategoryArr[index]);		
			valueArr[index] = value;
			index++;				
		 }
		  
		//GENERAL
		generalBifurcation.setCategory("GENERAL");
		generalBifurcation.setTotalCount(reqObj.getNumberOfPostToBeFilled()- valueArr[2] - valueArr[5] - valueArr[8] - valueArr[11] - valueArr[12]);
		generalBifurcation.setNonEsmEspCount(reqObj.getNumberOfPostToBeFilled()- valueArr[2] - valueArr[5] - valueArr[8] - valueArr[11] - valueArr[12] - valueArr[0] - valueArr[1]);
		generalBifurcation.setEsmCount(valueArr[0]);
		generalBifurcation.setEspCount(valueArr[1]);
		bifurcatedList.add(0,generalBifurcation);
		
		//SC
		scBifurcation.setCategory("SC");
		scBifurcation.setTotalCount(valueArr[2]);
		scBifurcation.setNonEsmEspCount(valueArr[2] - valueArr[3] -valueArr[4]);
		scBifurcation.setEsmCount(valueArr[3]);
		scBifurcation.setEspCount(valueArr[4]);
		bifurcatedList.add(1, scBifurcation);
		
		//BCA
		BCABifurcation.setCategory("BCA");
		BCABifurcation.setTotalCount(valueArr[5]);
		BCABifurcation.setNonEsmEspCount(valueArr[5] - valueArr[6] -valueArr[7]);
		BCABifurcation.setEsmCount(valueArr[6]);
		BCABifurcation.setEspCount(valueArr[7]);
		bifurcatedList.add(2, BCABifurcation);
		
		//BCB
		BCBBifurcation.setCategory("BCB");
		BCBBifurcation.setTotalCount(valueArr[8]);
		BCBBifurcation.setNonEsmEspCount(valueArr[8] - valueArr[9] -valueArr[10]);
		BCBBifurcation.setEsmCount(valueArr[9]);
		BCBBifurcation.setEspCount(valueArr[10]);
		bifurcatedList.add(3, BCBBifurcation);
		
		//SBC
		SBCBifurcation.setCategory("SBC");
		SBCBifurcation.setTotalCount(valueArr[11]);
		SBCBifurcation.setNonEsmEspCount(valueArr[11]);
		SBCBifurcation.setEsmCount(0);
		SBCBifurcation.setEspCount(0);
		bifurcatedList.add(4, SBCBifurcation);
		
		//EBPGC
		EBPGCBifurcation.setCategory("EBPGC");
		EBPGCBifurcation.setTotalCount(valueArr[12]);
		EBPGCBifurcation.setNonEsmEspCount(valueArr[12]);
		EBPGCBifurcation.setEsmCount(0);
		EBPGCBifurcation.setEspCount(0);
		bifurcatedList.add(5, EBPGCBifurcation);
		
		return bifurcatedList;
		}catch(Exception e) {
			logger.logError("getBifucatedValues", "exception while getting bifuracated values", e);
			throw e;
		}
	}
	
	@Override
	@Transactional(readOnly = false)
	public RequisitionInfo updateRequisition(RequisitionInfo reqObj) throws Exception {
		try{
            String DELETE_reservationData= "delete from RequisitionReservationInfo where idRequisition=? ";
//            String DELETE_requisitionDocs= "delete from RequisitionDocs where idRequisition=?";
            
			
			getHibernateTemplate().bulkUpdate(DELETE_reservationData,reqObj.getIdRequisition());
//			getHibernateTemplate().bulkUpdate(DELETE_requisitionDocs,reqObj.getIdRequisition());
			
			getHibernateTemplate().update(reqObj);	
			reqObj.setUniqueRequisitionNumber("REQ-" + reqObj.getIdRequisition());
			/*-----------------Seats Bifurcation------------------------*/
			
			if(CommonUtils.isNotEmpty(reqObj.getBifurcationList())) {
			 for(BifurcationHelper bifurObj:reqObj.getBifurcationList()) {
				 
				  if(bifurObj.getCategory().contains("GENERAL")) {
					  
					  if(CommonUtils.isNotEmpty(bifurObj.getTotalCount())) {
						  reqObj.setBacklog(bifurObj.getTotalCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"Total", bifurObj.getTotalCount(),reqObj.getIdRequisition(),"FILLED");
					  }
					  if(CommonUtils.isNotEmpty(bifurObj.getNonEsmEspCount())) {
						  reqObj.setBacklog(bifurObj.getNonEsmEspCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"NonESMESP", bifurObj.getNonEsmEspCount(),reqObj.getIdRequisition(),"FILLED");
					  }
					  if(CommonUtils.isNotEmpty(bifurObj.getEsmCount())) {
						  reqObj.setBacklog(bifurObj.getEsmCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESM", bifurObj.getEsmCount(),reqObj.getIdRequisition(),"FILLED");
					  }
					  if(CommonUtils.isNotEmpty(bifurObj.getEspCount())) {
						  reqObj.setBacklog(bifurObj.getEspCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESP", bifurObj.getEspCount(),reqObj.getIdRequisition(),"FILLED");
					  }  
				  }
				  if(bifurObj.getCategory().contains("SC")) {
					  if(CommonUtils.isNotEmpty(bifurObj.getTotalCount())) {
						  reqObj.setBacklog(bifurObj.getTotalCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"Total", bifurObj.getTotalCount(),reqObj.getIdRequisition(),"FILLED");
					  }
					  if(CommonUtils.isNotEmpty(bifurObj.getNonEsmEspCount())) {
						  reqObj.setBacklog(bifurObj.getNonEsmEspCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"NonESMESP", bifurObj.getNonEsmEspCount(),reqObj.getIdRequisition(),"FILLED");
					  }
					  if(CommonUtils.isNotEmpty(bifurObj.getEsmCount())) {
						  reqObj.setBacklog(bifurObj.getEsmCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESM", bifurObj.getEsmCount(),reqObj.getIdRequisition(),"FILLED");
					  }
					  if(CommonUtils.isNotEmpty(bifurObj.getEspCount())) {
						  reqObj.setBacklog(bifurObj.getEspCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESP", bifurObj.getEspCount(),reqObj.getIdRequisition(),"FILLED");
					  }  
				  }
				  if(bifurObj.getCategory().contains("BCA")) {
					  if(CommonUtils.isNotEmpty(bifurObj.getTotalCount())) {
						  reqObj.setBacklog(bifurObj.getTotalCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"Total", bifurObj.getTotalCount(),reqObj.getIdRequisition(),"FILLED");
					  }
					  if(CommonUtils.isNotEmpty(bifurObj.getNonEsmEspCount())) {
						  reqObj.setBacklog(bifurObj.getNonEsmEspCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"NonESMESP", bifurObj.getNonEsmEspCount(),reqObj.getIdRequisition(),"FILLED");
					  }
					  if(CommonUtils.isNotEmpty(bifurObj.getEsmCount())) {
						  reqObj.setBacklog(bifurObj.getEsmCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESM", bifurObj.getEsmCount(),reqObj.getIdRequisition(),"FILLED");
					  }
					  if(CommonUtils.isNotEmpty(bifurObj.getEspCount())) {
						  reqObj.setBacklog(bifurObj.getEspCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESP", bifurObj.getEspCount(),reqObj.getIdRequisition(),"FILLED");
					  }  
				  }
				  if(bifurObj.getCategory().contains("BCB")) {
					  if(CommonUtils.isNotEmpty(bifurObj.getTotalCount())) {
						  reqObj.setBacklog(bifurObj.getTotalCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"Total", bifurObj.getTotalCount(),reqObj.getIdRequisition(),"FILLED");
					  }
					  if(CommonUtils.isNotEmpty(bifurObj.getNonEsmEspCount())) {
						  reqObj.setBacklog(bifurObj.getNonEsmEspCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"NonESMESP", bifurObj.getNonEsmEspCount(),reqObj.getIdRequisition(),"FILLED");
					  }
					  if(CommonUtils.isNotEmpty(bifurObj.getEsmCount())) {
						  reqObj.setBacklog(bifurObj.getEsmCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESM", bifurObj.getEsmCount(),reqObj.getIdRequisition(),"FILLED");
					  }
					  if(CommonUtils.isNotEmpty(bifurObj.getEspCount())) {
						  reqObj.setBacklog(bifurObj.getEspCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESP", bifurObj.getEspCount(),reqObj.getIdRequisition(),"FILLED");
					  }  
				  }
				  if(bifurObj.getCategory().contains("SBC")) {
					  if(CommonUtils.isNotEmpty(bifurObj.getTotalCount())) {
						  reqObj.setBacklog(bifurObj.getTotalCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"Total", bifurObj.getTotalCount(),reqObj.getIdRequisition(),"FILLED");
					  }
					  if(CommonUtils.isNotEmpty(bifurObj.getNonEsmEspCount())) {
						  reqObj.setBacklog(bifurObj.getNonEsmEspCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"NonESMESP", bifurObj.getNonEsmEspCount(),reqObj.getIdRequisition(),"FILLED");
					  }
					  if(CommonUtils.isNotEmpty(bifurObj.getEsmCount())) {
						  reqObj.setBacklog(bifurObj.getEsmCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESM", bifurObj.getEsmCount(),reqObj.getIdRequisition(),"FILLED");
					  }
					  if(CommonUtils.isNotEmpty(bifurObj.getEspCount())) {
						  reqObj.setBacklog(bifurObj.getEspCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESP", bifurObj.getEspCount(),reqObj.getIdRequisition(),"FILLED");
					  }  
				  }
				  if(bifurObj.getCategory().contains("EWS")) {
					  if(CommonUtils.isNotEmpty(bifurObj.getTotalCount())) {
						  reqObj.setBacklog(bifurObj.getTotalCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"Total", bifurObj.getTotalCount(),reqObj.getIdRequisition(),"FILLED");
					  }
					  if(CommonUtils.isNotEmpty(bifurObj.getNonEsmEspCount())) {
						  reqObj.setBacklog(bifurObj.getNonEsmEspCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"NonESMESP", bifurObj.getNonEsmEspCount(),reqObj.getIdRequisition(),"FILLED");
					  }
					  if(CommonUtils.isNotEmpty(bifurObj.getEsmCount())) {
						  reqObj.setBacklog(bifurObj.getEsmCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESM", bifurObj.getEsmCount(),reqObj.getIdRequisition(),"FILLED");
					  }
					  if(CommonUtils.isNotEmpty(bifurObj.getEspCount())) {
						  reqObj.setBacklog(bifurObj.getEspCountBackLog());
						  prepareAndSaveReqResObject(reqObj, bifurObj.getCategory(),"ESP", bifurObj.getEspCount(),reqObj.getIdRequisition(),"FILLED");
					  }  
				  }
			}
			 prepareAndSaveReqResObject(reqObj, "PWD", "None", Math.round((reqObj.getNumberOfPostToBeFilled()*4)/100),reqObj.getIdRequisition(),"FILLED");
				
		}

		    if(CommonUtils.isEmpty(reqObj.getBifurcationList())) {
				for(RequisitionReservationInfo info : reqObj.getRequisitionReservationInfoList()) {
					if(CommonUtils.isNotEmpty(info.getCategory())) {
						info.setIdRequisition(reqObj.getIdRequisition());
						info.setUniqueRequisitionNumber(reqObj.getUniqueRequisitionNumber());
						getHibernateTemplate().save(info);					
					}
				}
			
/*			String[] categoryArr = {"GENERAL","GENERAL", "SC","SC","SC","BCA", "BCA","BCA","BCB","BCB","BCB", "SBC", "EBPGC"};
			String[] subCategoryArr = {"ESM","ESP", "None","ESM","ESP", "None","ESM","ESP", "None","ESM","ESP", "None", "None"};
			int[] valueArr = new int[13];
			
			int index = 0;
			for(String category : categoryArr) {				
				//int value=getvalueAfterSeatBifurcation(reqObj.getNumberOfPostToBeFilled(),category,subCategoryArr[index]);
				int value=0;
				valueArr[index] = value;
				index++;				
			}
			
			//General
			prepareAndSaveReqResObject(reqObj, "GENERAL", "Total", reqObj.getNumberOfPostToBeFilled()- valueArr[2] - valueArr[5] - valueArr[8] - valueArr[11] - valueArr[12],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "GENERAL", "NonESMESP", reqObj.getNumberOfPostToBeFilled()- valueArr[2] - valueArr[5] - valueArr[8] - valueArr[11] - valueArr[12] - valueArr[0] - valueArr[1],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "GENERAL", "ESM", valueArr[0],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "GENERAL", "ESP", valueArr[1],reqObj.getIdRequisition(),"CALCULATED");

			//SC
			prepareAndSaveReqResObject(reqObj, "SC", "Total", valueArr[2],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "SC", "ESM", valueArr[3],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "SC", "ESP", valueArr[4],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "SC", "NonESMESP", valueArr[2] - valueArr[3] -valueArr[4],reqObj.getIdRequisition(),"CALCULATED");
			
			//BCA
			prepareAndSaveReqResObject(reqObj, "BCA", "Total", valueArr[5],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "BCA", "ESM", valueArr[6],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "BCA", "ESP", valueArr[7],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "BCA", "NonESMESP", valueArr[5] - valueArr[6] -valueArr[7],reqObj.getIdRequisition(),"CALCULATED");
			
			//BCB
			prepareAndSaveReqResObject(reqObj, "BCB", "Total", valueArr[8],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "BCB", "ESM", valueArr[9],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "BCB", "ESP", valueArr[10],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "BCB", "NonESMESP", valueArr[8] - valueArr[9] -valueArr[10],reqObj.getIdRequisition(),"CALCULATED");
			
			//SBC
			prepareAndSaveReqResObject(reqObj, "SBC", "Total", valueArr[11],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "SBC", "ESM", 0,reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "SBC", "ESP", 0,reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "SBC", "NonESMESP", valueArr[11],reqObj.getIdRequisition(),"CALCULATED");

			//EBPGC
			prepareAndSaveReqResObject(reqObj, "EBPGC", "Total", valueArr[12],reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "EBPGC", "ESM", 0,reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "EBPGC", "ESP", 0,reqObj.getIdRequisition(),"CALCULATED");
			prepareAndSaveReqResObject(reqObj, "EBPGC", "NonESMESP", valueArr[12],reqObj.getIdRequisition(),"CALCULATED");
			
			
			prepareAndSaveReqResObject(reqObj, "PWD", "None", Math.round((reqObj.getNumberOfPostToBeFilled()*4)/100),reqObj.getIdRequisition(),"CALCULATED");*/
		 }
		}catch(Exception e) {
			logger.logError("updateRequisition", "exception while updating requisition form", e);
		}
		return reqObj;
		}
		
	private void prepareAndSaveReqResObject(RequisitionInfo reqObj, String category, String subCat, int value,int idRequisition, String status) {
		RequisitionReservationInfo requisitionReservationInfo = new RequisitionReservationInfo();
		requisitionReservationInfo.setUniqueRequisitionNumber(reqObj.getUniqueRequisitionNumber());
		requisitionReservationInfo.setCategory(category);
		requisitionReservationInfo.setBacklog(reqObj.getBacklog());
		requisitionReservationInfo.setSubCategory(subCat);
		requisitionReservationInfo.setTotalSeatsForCategory(value);
		requisitionReservationInfo.setIdRequisition(idRequisition);
		//requisitionReservationInfo.setStatus(status);
		getHibernateTemplate().save(requisitionReservationInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RequisitionInfo> getAllRegisteredRequisitions(Integer dEpartmentId, int firstRecordIndex, int pageSize,
			SortOrderEnum sortDirection, String sortCriterion, String status,RequisitionInfo reqObj) throws Exception {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(RequisitionInfo.class);
			if (dEpartmentId != null) {
				criteria.add(Restrictions.eq("dEpartmentId", dEpartmentId));
			}
		    if(CommonUtils.isNotEmpty(status) && !status.equalsIgnoreCase("Search Status...")) {
				criteria.add(Restrictions.eq("status",status));
			}
		    
		    if(CommonUtils.isNotEmpty(reqObj.getUniqueRequisitionNumber()) && !reqObj.getUniqueRequisitionNumber().equalsIgnoreCase("Search ReqNo...")) {
				criteria.add(Restrictions.eq("uniqueRequisitionNumber",reqObj.getUniqueRequisitionNumber()));
			}
		    if(CommonUtils.isNotEmpty(reqObj.getdEpartmentId()) && reqObj.getdEpartmentId()!=0) {
				criteria.add(Restrictions.eq("dEpartmentId",reqObj.getdEpartmentId()));
				criteria.add(Restrictions.ne("status","saved"));
			}
		    
		    if(CommonUtils.isNotEmpty(reqObj.getPostmasterId()) && reqObj.getPostmasterId()!=0) {
				criteria.add(Restrictions.eq("postmasterId",reqObj.getPostmasterId()));
				if (dEpartmentId==null) {
					criteria.add(Restrictions.ne("status","saved"));
				}
			}
		    if(CommonUtils.isNotEmpty(reqObj.getClassAndServiceOfPost()) && !reqObj.getClassAndServiceOfPost().equalsIgnoreCase("Search Group...")) {
				criteria.add(Restrictions.eq("classAndServiceOfPost",reqObj.getClassAndServiceOfPost()));
				if(CommonUtils.isEmpty(dEpartmentId)) {
					criteria.add(Restrictions.ne("status", "saved"));
					 }
			}
		    
			else {
				 if(CommonUtils.isEmpty(dEpartmentId)) {
				criteria.add(Restrictions.ne("status", "saved"));
				 }
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
				}
				else if(sortCriterion.contains("postObj.postName")){
					criteria.createCriteria("postObj", "post");
					if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
						criteria.addOrder(Order.asc("post.postName"));
					}
					if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
						criteria.addOrder(Order.desc("post.postName"));
					}					
				}
				else {              
				if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
					criteria.addOrder(Order.asc(sortCriterion));
				}
				if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
					criteria.addOrder(Order.desc(sortCriterion));
				}
				}
			}
			else {
				criteria.addOrder(Order.asc("uniqueRequisitionNumber"));
			}
			List<RequisitionInfo> AllRegisteredRequisitionsList = (List<RequisitionInfo>) getHibernateTemplate()
					.findByCriteria(criteria, firstRecordIndex, pageSize);

			if (CommonUtils.isNotEmpty(AllRegisteredRequisitionsList)) {
				return AllRegisteredRequisitionsList;
			} else {
				return null;
			}	
		
		} catch (Exception e) {
			logger.logError("getAllRegisteredRequisitions", "exception while getting requisitions data", e);
			throw e;
		}

	}

	@Override
	public int getAllRegisteredRequisitionsCount(Integer dEpartmentId, String  status,RequisitionInfo reqObj) throws Exception {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(RequisitionInfo.class);
			if (dEpartmentId != null) {
				criteria.add(Restrictions.eq("dEpartmentId", dEpartmentId));
			}
		    if(CommonUtils.isNotEmpty(status) && !status.equalsIgnoreCase("Search Status...")) {
				criteria.add(Restrictions.eq("status",status));
			}
		    if(CommonUtils.isNotEmpty(reqObj.getUniqueRequisitionNumber()) && !reqObj.getUniqueRequisitionNumber().equalsIgnoreCase("Search ReqNo...")) {
				criteria.add(Restrictions.eq("uniqueRequisitionNumber",reqObj.getUniqueRequisitionNumber()));
			}
		    if(CommonUtils.isNotEmpty(reqObj.getdEpartmentId()) && reqObj.getdEpartmentId()!=0) {
				criteria.add(Restrictions.eq("dEpartmentId",reqObj.getdEpartmentId()));
				criteria.add(Restrictions.ne("status","saved"));
			}
		    if(CommonUtils.isNotEmpty(reqObj.getPostmasterId()) && reqObj.getPostmasterId()!=0) {
				criteria.add(Restrictions.eq("postmasterId",reqObj.getPostmasterId()));
				if (dEpartmentId==null) {
					criteria.add(Restrictions.ne("status","saved"));
				}
			}
		    if(CommonUtils.isNotEmpty(reqObj.getClassAndServiceOfPost()) && !reqObj.getClassAndServiceOfPost().equalsIgnoreCase("Search Group...")) {
				criteria.add(Restrictions.eq("classAndServiceOfPost",reqObj.getClassAndServiceOfPost()));
				if(CommonUtils.isEmpty(dEpartmentId)) {
					criteria.add(Restrictions.ne("status", "saved"));
					 }
			}
		    
			else {
				 if(CommonUtils.isEmpty(dEpartmentId)) {
				criteria.add(Restrictions.ne("status", "saved"));
				 }
			}
			criteria.setProjection(Projections.rowCount());
			final List<?> results = getHibernateTemplate().findByCriteria(criteria);
			return CommonUtils.isEmpty(results) == true ? 0 : ((Long) results.get(0)).intValue();
		} catch (Exception e) {
			logger.logError("getAllRegisteredRequisitionsCount", "exception while getting requisitions data count", e);
		}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RequisitionInfo> getRequisitionListByIdRequisition(Integer idRequisition, int firstRecordIndex,
			int pageSize, SortOrderEnum sortDirection, String sortCriterion) throws Exception {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(RequisitionInfo.class);
			if (CommonUtils.isNotEmpty(idRequisition)) {
				criteria.add(Restrictions.eq("idRequisition", idRequisition));
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
				}
				else {              
				if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
					criteria.addOrder(Order.asc(sortCriterion));
				}
				if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
					criteria.addOrder(Order.desc(sortCriterion));
				}
				}
			}
			else {
				criteria.addOrder(Order.asc("uniqueRequisitionNumber"));
			}
			List<RequisitionInfo> AllRegisteredRequisitionsList = (List<RequisitionInfo>) getHibernateTemplate()
					.findByCriteria(criteria, firstRecordIndex, pageSize);

			if (CommonUtils.isNotEmpty(AllRegisteredRequisitionsList)) {
				return AllRegisteredRequisitionsList;
			} else {
				return null;
			}	
		
		} catch (Exception e) {
			logger.logError("getRequisitionListByIdRequisition", "exception while getting requisitions data", e);
			throw e;
		}
	}
	@Override
	public int getRequisitionListByIdRequisition(Integer idRequisition) throws Exception {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(RequisitionInfo.class);
			if (CommonUtils.isNotEmpty(idRequisition)) {
				criteria.add(Restrictions.eq("idRequisition", idRequisition));
			}
			criteria.setProjection(Projections.rowCount());
			final List<?> results = getHibernateTemplate().findByCriteria(criteria);
			return CommonUtils.isEmpty(results) == true ? 0 : ((Long) results.get(0)).intValue();
		} catch (Exception e) {
			logger.logError("getRequisitionListByIdRequisition", "exception while getting requisitions data count", e);
		}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RequisitionInfo> getAllRequisitionsRequests(int firstRecordIndex, int pageSize,
			SortOrderEnum sortDirection, String sortCriterion) throws Exception {
		try{
			DetachedCriteria criteria = DetachedCriteria.forClass(RequisitionInfo.class);
			
			criteria.add(Restrictions.eq("status", "Submitted"));
			
			if (sortCriterion != null) {
				
				if(sortCriterion.contains("deptObj.dEpartment")){
					criteria.createCriteria("deptObj", "dept");
					if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
						criteria.addOrder(Order.asc("dept.dEpartment"));
					}
					if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
						criteria.addOrder(Order.desc("dept.dEpartment"));
					}					
				}

				if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
					criteria.addOrder(Order.asc(sortCriterion));
				}
				if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
					criteria.addOrder(Order.desc(sortCriterion));
				}
			}
			else {
				criteria.addOrder(Order.desc("uniqueRequisitionNumber"));
			}
			List<RequisitionInfo> AllRegisteredRequisitionsRequestsList = (List<RequisitionInfo>) getHibernateTemplate()
					.findByCriteria(criteria, firstRecordIndex, pageSize);

			if (CommonUtils.isNotEmpty(AllRegisteredRequisitionsRequestsList)) {
				return AllRegisteredRequisitionsRequestsList;
			} else {
				return AllRegisteredRequisitionsRequestsList;
			}	
		}catch(Exception e){
			logger.logError("getAllRequisitionsRequests", "exception while getting requisition requests", e);
			throw e;
		}
	}
	
	@Override
	public int getAllRequisitionsRequestsCount() throws Exception {
		try{
		DetachedCriteria criteria = DetachedCriteria.forClass(RequisitionInfo.class);
		
		criteria.add(Restrictions.eq("status", "Submitted"));
		
		criteria.setProjection(Projections.rowCount());
		final List<?> results = getHibernateTemplate().findByCriteria(criteria);
		return CommonUtils.isEmpty(results) == true ? 0 : ((Long) results.get(0)).intValue();
		}catch(Exception e){
			logger.logError("getAllRequisitionsRequestsCount", "exception while getting requisition requests count", e);
		}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RequisitionInfo> getRequisitionFormByRequisitionId(Integer idRequisition) throws Exception {
		List<RequisitionInfo> requisitionFormForDept = new ArrayList<RequisitionInfo>();
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(RequisitionInfo.class);
			criteria.add(Restrictions.eq("idRequisition", idRequisition));
			requisitionFormForDept = (List<RequisitionInfo>) getHibernateTemplate().findByCriteria(criteria);
			if (CommonUtils.isNotEmpty(requisitionFormForDept)) {
				return requisitionFormForDept;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.logError("getRequisitionFormByRequisitionId", "exception while getting requisition data", e);
			throw e;
		}
	}

	@Override
	public HsscConfig getHSSCConfig() throws Exception {
		try {
			List<HsscConfig> list = getHibernateTemplate().loadAll(HsscConfig.class);
			if (CommonUtils.isNotEmpty(list)) {
				return list.get(0);
			} else {
				return null;
			}

		} catch (Exception e) {
			logger.logError("getHSSCConfig", "error while getting hssc config", e);
			throw e;
		}
	}
	
	@Override
	public int getvalueAfterSeatBifurcation(int prevRosterPoint, int num, String category, String subCategory) {
		int totalPosts = 0;
		try {
				/*------------ Step 1--------------*/
				int prevRosterRemainder = prevRosterPoint % 100;
				List<SeatsBifurcation> bifuractionList = getValueFromRosterPoint(category, subCategory, 100, prevRosterRemainder);

				int noOfSeatsStart = 0;
				if(CommonUtils.isNotEmpty(bifuractionList)) {
					noOfSeatsStart = bifuractionList.size();	
				}				
				
				num = num + prevRosterPoint;
				int remainder = num % 100;
				bifuractionList = getValueFromRosterPoint(category, subCategory, remainder, null);

				int noOfSeats = 0;
				if(CommonUtils.isNotEmpty(bifuractionList)) {
					noOfSeats = bifuractionList.get(0).getSeries();	
				}
				

				/*------------ Step 2--------------*/
				int i = (num / 100) -(prevRosterPoint/100 + 1);

				bifuractionList = getValueFromRosterPoint(category, subCategory, 100, null);
				if(CommonUtils.isNotEmpty(bifuractionList)) {
					totalPosts = i * bifuractionList.get(0).getSeries() + noOfSeats + noOfSeatsStart;	
				}else {
					totalPosts = noOfSeats + noOfSeatsStart;	
				}

							
		} catch (Exception e) {
			logger.logError("getvalueAfterSeatBifurcation", "exception while getting requisition data", e);
		}
		return totalPosts;
	}

	private List<SeatsBifurcation> getValueFromRosterPoint(String category, String subCategory, int remainder, Integer startPoint) {
		StringBuffer query = new StringBuffer();
		query.append("select * from seatsBifurcation where category='" + category + "' and subCategory = '"+ subCategory + "'");
		if(CommonUtils.isNotEmpty(startPoint)) {
			query.append(" and rosterPoints>" + startPoint.intValue());
		}
		query.append(" and rosterPoints<=" + remainder + " ORDER BY rosterPoints DESC ");
		
		List<SeatsBifurcation> bifuractionList = (List<SeatsBifurcation>) getJdbcTemplate().query(query.toString(),
				new RowMapper<SeatsBifurcation>() {
					@Override
					public SeatsBifurcation mapRow(final ResultSet resultSet, final int arg1) throws SQLException {
						final SeatsBifurcation obj = new SeatsBifurcation();
						obj.setBifurcationId(resultSet.getInt("bifurcationId"));
						obj.setCategory(resultSet.getString("category"));
						obj.setRosterPoints(resultSet.getInt("rosterPoints"));
						obj.setSeries(resultSet.getInt("series"));
						obj.setSubCategory(resultSet.getString("subCategory"));
						return obj;
					}
				});
		return bifuractionList;
	}


	@Override
	public List<BifurcationHelper> getBifuractionHelperList(Integer idRequisition) {
		try {
			String query="SELECT T0.category,T0.idRequisition, T0.ESM, T1.ESP, T2.NonESMESP,T3.Total FROM \r\n" + 
					"	(SELECT category, idRequisition, backlog, totalSeats AS 'ESM' FROM requisitionreservationinfo  where subCategory = 'ESM' ) T0 \r\n" + 
					"	LEFT JOIN (SELECT category,  idRequisition, backlog, totalSeats AS 'ESP' FROM requisitionreservationinfo  where subCategory = 'ESP' ) T1 ON T0.category= T1.category and T0.idRequisition= T1.idRequisition  \r\n" + 
					"	LEFT JOIN (SELECT category, idRequisition,backlog, totalSeats AS 'NonESMESP' FROM requisitionreservationinfo  where subCategory = 'NonESMESP' ) T2 ON T0.category = T2.category and T0.idRequisition= T2.idRequisition  \r\n" + 
					"	LEFT JOIN (SELECT category, idRequisition, backlog, totalSeats AS 'Total' FROM requisitionreservationinfo where subCategory = 'Total') T3 ON T0.category = T3.category and T0.idRequisition= T3.idRequisition \r\n" + 
					"	WHERE T0.idRequisition =" +idRequisition+ 
					"   order by T3.Total desc;";
		List<BifurcationHelper> bifuractionList = (List<BifurcationHelper>) getJdbcTemplate().query(query
				 ,
				new RowMapper<BifurcationHelper>() {
					@Override
					public BifurcationHelper mapRow(final ResultSet resultSet, final int arg1) throws SQLException {
						final BifurcationHelper obj = new BifurcationHelper();
						obj.setCategory(resultSet.getString("category"));
						obj.setTotalCount(resultSet.getInt("Total"));
						obj.setEsmCount(resultSet.getInt("ESM"));
						obj.setEspCount(resultSet.getInt("ESP"));
						obj.setNonEsmEspCount(resultSet.getInt("NonESMESP"));	
						//obj.setBackLogCount(resultSet.getInt("backlog"));
						return obj;
					}
				});
		
		return bifuractionList;
		}catch(Exception e) {
			logger.logError("getBifuractionHelperList", "exception while getting requisition data", e);
		}
		return null;
			
	}
	
	@Override
	public List<BifurcationHelper> getSecondBifuractionHelperList(Integer idRequisition) {
		try {
			String query="SELECT T0.category,T0.idRequisition,T0.status, T0.ESM, T1.ESP, T2.NonESMESP,T3.Total FROM \r\n" + 
					"	(SELECT category, idRequisition, status, totalSeats AS 'ESM' FROM requisitionreservationinfo  where subCategory = 'ESM' ) T0 \r\n" + 
					"	LEFT JOIN (SELECT category,  idRequisition, status, totalSeats AS 'ESP' FROM requisitionreservationinfo  where subCategory = 'ESP' ) T1 ON T0.category= T1.category and T0.idRequisition= T1.idRequisition and T0.status= T1.status \r\n" + 
					"	LEFT JOIN (SELECT category, idRequisition,status, totalSeats AS 'NonESMESP' FROM requisitionreservationinfo  where subCategory = 'NonESMESP' ) T2 ON T0.category = T2.category and T0.idRequisition= T2.idRequisition and T0.status= T2.status \r\n" + 
					"	LEFT JOIN (SELECT category, idRequisition, status, totalSeats AS 'Total' FROM requisitionreservationinfo where subCategory = 'Total') T3 ON T0.category = T3.category and T0.idRequisition= T3.idRequisition and  T0.status= T3.status\r\n" + 
					"	WHERE T0.idRequisition =" +idRequisition+ 
					"   and T0.status='FILLED'  order by T3.Total desc;";
		List<BifurcationHelper> bifuractionList = (List<BifurcationHelper>) getJdbcTemplate().query(query
				 ,
				new RowMapper<BifurcationHelper>() {
					@Override
					public BifurcationHelper mapRow(final ResultSet resultSet, final int arg1) throws SQLException {
						final BifurcationHelper obj = new BifurcationHelper();
						obj.setCategory(resultSet.getString("category"));
						obj.setTotalCount(resultSet.getInt("Total"));
						obj.setEsmCount(resultSet.getInt("ESM"));
						obj.setEspCount(resultSet.getInt("ESP"));
						obj.setNonEsmEspCount(resultSet.getInt("NonESMESP"));	
						//obj.setStatus(resultSet.getString("status"));
						return obj;
					}
				});
		
		return bifuractionList;
		}catch(Exception e) {
			logger.logError("getBifuractionHelperList", "exception while getting requisition data", e);
		}
		return null;
		
	}

	@Override
	@Transactional(readOnly = false)
	public void savePathObjectByIdRequisition(RequisitionDocs docsObj) {
	try {
		getHibernateTemplate().save(docsObj);
	}catch(Exception e) {
		logger.logError("savePathObjectByIdRequisition", "exception while saving path", e);
	}
	
	}
	@Override
	@Transactional(readOnly = false)
	public void updateRequisitionStatus(RequisitionInfo reqObj) {
		try {
			
			getHibernateTemplate().update(reqObj);
		}catch(Exception e) {
			logger.logError("updateRequisitionStatus", "exception while updating status", e);	
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<RequisitionDocs> getDocsByRequisitionId(Integer idRequisition) throws Exception {
		List<RequisitionDocs> requisitionDocs = new ArrayList<RequisitionDocs>();
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(RequisitionDocs.class);
			criteria.add(Restrictions.eq("idRequisition", idRequisition));
			requisitionDocs = (List<RequisitionDocs>) getHibernateTemplate().findByCriteria(criteria);
			if (CommonUtils.isNotEmpty(requisitionDocs)) {
				return requisitionDocs;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.logError("getDocsByRequisitionId", "exception while getting requisition Docs", e);
			throw e;
		}
	}
	@Override
	public List<RequisitionInfo> getAllRequisitioData(Integer dEpartmentId) throws Exception {
		List<RequisitionInfo> AllRequisitions = new ArrayList<RequisitionInfo>();
		try {
		     if(CommonUtils.isNotEmpty(dEpartmentId)) {
			AllRequisitions = (List<RequisitionInfo>)getJdbcTemplate().query("select * from requisitioninfo where dEpartmentId="+dEpartmentId, 
						new RowMapper<RequisitionInfo>(){
					@Override
					public RequisitionInfo mapRow(final ResultSet resultSet, final int arg1) throws SQLException
					{
						final RequisitionInfo requisition = new RequisitionInfo();
						requisition.setNumberOfPostToBeFilled(resultSet.getInt("numberOfPostToBeFilled"));
						requisition.setStatus(resultSet.getString("status"));
						requisition.setPostmasterId(resultSet.getInt("postmasterId"));
						requisition.setdEpartmentId(resultSet.getInt("dEpartmentId"));
						requisition.setUniqueRequisitionNumber(resultSet.getString("uniqueRequisitionNumber"));
						return requisition;
					}				
			});
		   }
		     else {
		    	 AllRequisitions = (List<RequisitionInfo>)getJdbcTemplate().query("select * from requisitioninfo ", 
							new RowMapper<RequisitionInfo>(){
						@Override
						public RequisitionInfo mapRow(final ResultSet resultSet, final int arg1) throws SQLException
						{
							final RequisitionInfo requisition = new RequisitionInfo();
							requisition.setNumberOfPostToBeFilled(resultSet.getInt("numberOfPostToBeFilled"));
							requisition.setStatus(resultSet.getString("status"));
							requisition.setPostmasterId(resultSet.getInt("postmasterId"));
							requisition.setdEpartmentId(resultSet.getInt("dEpartmentId"));
							requisition.setUniqueRequisitionNumber(resultSet.getString("uniqueRequisitionNumber"));
							return requisition;
						}				
				});
		    	 
		     }
		
		} catch (Exception e) {
			logger.logError("getAllHsscPostListForDept", "error while fetching data for AllHsscPostListForDept", e);
			throw e;
		}
		return AllRequisitions;
	}
	@Override
	public List<RequisitionInfo> getAllDistinctStatusList() throws Exception {
		List<RequisitionInfo> allDistinctRecords = new ArrayList<RequisitionInfo>();
		try {
			allDistinctRecords = (List<RequisitionInfo>)getJdbcTemplate().query("select distinct status from requisitioninfo ", 
						new RowMapper<RequisitionInfo>(){
					@Override
					public RequisitionInfo mapRow(final ResultSet resultSet, final int arg1) throws SQLException
					{
						final RequisitionInfo requisition = new RequisitionInfo();
						requisition.setStatus(resultSet.getString("status"));
						return requisition;
					}				
			});
			
			return allDistinctRecords;
		}catch(Exception e) {
			logger.logError("getAllDistinctStatusList", "error while fetching distinct data", e);
			throw e;
		}
		
	}
	@Transactional(readOnly = false)
	@Override
	public RequisitionInfoRemarks saveRequisitionsRemark(RequisitionInfoRemarks reqRemarkObj) throws Exception {
	  try {
		    getHibernateTemplate().save(reqRemarkObj);
    		  
	  }catch(Exception e) {
		  logger.logError("saveRequisitionsRemark", "error while saving Requisitions Remark", e);
			throw e;
	  }
		return reqRemarkObj;
	}
	@SuppressWarnings("unchecked")
	@Override
	public RequisitionInfoRemarks getRequisitionRemarksInfoByIdRequisition(Integer idRequisition) throws Exception {
		List<RequisitionInfoRemarks> requisitionRemarkInfo = new ArrayList<RequisitionInfoRemarks>();
		List<RequisitionInfoRemarks> requisitionRemarkInfoWithMaxDate = new ArrayList<RequisitionInfoRemarks>();
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(RequisitionInfoRemarks.class);
			DetachedCriteria criteria2 = DetachedCriteria.forClass(RequisitionInfoRemarks.class);
			criteria.add(Restrictions.eq("idRequisition", idRequisition));
			criteria.add(Restrictions.eq("isRequisitionApprovedOrNot", false));
			requisitionRemarkInfo = (List<RequisitionInfoRemarks>) getHibernateTemplate().findByCriteria(criteria);
			  if(CommonUtils.isNotEmpty(requisitionRemarkInfo)) {
			   List<Date> datesCollection=new ArrayList<Date>();
			   for(RequisitionInfoRemarks r:requisitionRemarkInfo) {
				    if(CommonUtils.isNotEmpty(r.getLastUpdateDateAndTime())) {
				        datesCollection.add(r.getLastUpdateDateAndTime());
				    }
			   }
		       Date date=Collections.max(datesCollection);
		       criteria2.add(Restrictions.eq("lastUpdateDateAndTime", date));
			   requisitionRemarkInfoWithMaxDate= (List<RequisitionInfoRemarks>) getHibernateTemplate().findByCriteria(criteria2);
			}   
			if (CommonUtils.isNotEmpty(requisitionRemarkInfoWithMaxDate)) {
				return requisitionRemarkInfoWithMaxDate.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.logError("getDocsByRequisitionId", "exception while getting requisition Docs", e);
			throw e;
		}
	}
	@Transactional(readOnly=false)
	@Override
	public Notifications saveNotificaton(Notifications notifyObj) throws Exception {
		try {
			    getHibernateTemplate().save(notifyObj);
			return notifyObj;
		}catch(Exception e) {
			logger.logError("saveNotificaton", "exception while getting requisition Docs", e);
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Notifications> getAllNotificationsByDepartment(Integer dEpartmentId) throws Exception{
		List<Notifications> notificationsList = new ArrayList<Notifications>();
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Notifications.class);
			criteria.add(Restrictions.eq("dEpartmentId", dEpartmentId));
			notificationsList = (List<Notifications>) getHibernateTemplate().findByCriteria(criteria);
			if (CommonUtils.isNotEmpty(notificationsList)) {
				return notificationsList;
			} else {
				return null;
			}
			
		}catch(Exception e) {
			logger.logError("getAllNotificationsByDepartment", "exception while getting Notifications", e);
			throw e;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public Notifications getAllNotificationsByGeneratedTime(Date date) throws Exception {
		List<Notifications> notificationsList = new ArrayList<Notifications>();
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Notifications.class);
			criteria.add(Restrictions.eq("notificationGeneratedDateAndTime", date));
			notificationsList = (List<Notifications>) getHibernateTemplate().findByCriteria(criteria);
			if (CommonUtils.isNotEmpty(notificationsList)) {
				return notificationsList.get(0);
			} else {
				return null;
			}
			
		}catch(Exception e) {
			logger.logError("getAllNotificationsByDepartment", "exception while getting Notifications", e);
			throw e;
		}
	}
	@Override
	public void updateNotificationStatus(Integer notificationId) throws Exception {
			try{
				Session session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				 Query qry = session.createSQLQuery("update notifications as n set n.readUnreadStatus= ? where n.notificationId= ? ");
			     qry.setParameter(0,true);
			     qry.setParameter(1,notificationId);
				 int res = qry.executeUpdate(); 
				 System.out.println("query Executed successfully"+res);
				tx.commit();
				session.close();
				}catch(Exception e){
					logger.logError("updateProductionQuantity", "error while Updating quantity", e);
				}
	}
	

	public List<PostMaster> getAllDesignations(Integer postGroupId) throws Exception {
		List<PostMaster> desigList = new ArrayList<PostMaster>();
		try {
			if(CommonUtils.isNotEmpty(postGroupId)) {
			desigList = (List<PostMaster>)getJdbcTemplate().query("select * from postmaster where postgroupId="+postGroupId+ " and status=true", 
					new RowMapper<PostMaster>(){
				@Override
				public PostMaster mapRow(final ResultSet resultSet, final int arg1) throws SQLException
				{
					final PostMaster postobj = new PostMaster();
					postobj.setPostName(resultSet.getString("postName"));
					postobj.setPostmasterId(resultSet.getInt("postmasterId"));
					return postobj;
				}				
		   });
		}else {
			desigList = (List<PostMaster>)getJdbcTemplate().query("select * from postmaster", 
					new RowMapper<PostMaster>(){
				@Override
				public PostMaster mapRow(final ResultSet resultSet, final int arg1) throws SQLException
				{
					final PostMaster postobj = new PostMaster();
					postobj.setPostName(resultSet.getString("postName"));
					postobj.setPostmasterId(resultSet.getInt("postmasterId"));
					return postobj;
				}				
		   });
		}			
		}catch(Exception e) {
			logger.logError("getAllDesignations", "exception while getting Postnames", e);
			throw e;
		}
		return desigList;
	}
	@Override
	@Transactional(readOnly=false)
	public ValidateBifurcation saveValidateBifurcationObj(ValidateBifurcation validateBifurcationObj) {
		try {
			getHibernateTemplate().saveOrUpdate(validateBifurcationObj);
		}catch(Exception e) {
			
		}
		return validateBifurcationObj;
	}
	@Override
	@Transactional(readOnly=false)
	public void saveValidateBifurcationCounts(List<ValidateBifurcationCounts> validateCountList) {
		try {
		for (ValidateBifurcationCounts obj : validateCountList) {
			getHibernateTemplate().save(obj);
		}	
			
		}catch(Exception e) {
			
		}
	}
	@Override
	public List<RequisitionReport> getAllDepartmentRequisitions(String group) throws Exception {
		List<RequisitionReport> allDistinctRecords = new ArrayList<RequisitionReport>();
		try {
			String query="SELECT  Department,Postname,numberOfPostToBeFilled,ifnull(max(case when i.`category` ='GENERAL' and i.subCategory='Total' then   `totalSeats` else null end ),0) as GENERALTOTAL\r\n" + 
					",ifnull(max(case when i.`category` ='GENERAL' and i.subCategory='NonESMESP' then   `totalSeats` else null end ),0) as GENERALNONESMESP,\r\n" + 
					"ifnull(max(case when i.`category` ='GENERAL' and i.subCategory='ESM' then   `totalSeats` else null end ),0) as GENERALESM\r\n" + 
					",ifnull(max(case when i.`category` ='GENERAL' and i.subCategory='ESP' then   `totalSeats` else null end ),0) as GENERALESP\r\n" + 
					",ifnull(max(case when i.`category` ='BCA' and i.subCategory='Total' then   `totalSeats` else null end ),0) as BCATOTAL\r\n" + 
					",ifnull(max(case when i.`category` ='BCA' and i.subCategory='NonESMESP' then   `totalSeats` else null end ),0) as BCANONESMESP,\r\n" + 
					"ifnull(max(case when i.`category` ='BCA' and i.subCategory='ESM' then   `totalSeats` else null end ),0) as BCAESM\r\n" + 
					",ifnull(max(case when i.`category` ='BCA' and i.subCategory='ESP' then   `totalSeats` else null end ),0) as BCAESP\r\n" + 
					",ifnull(max(case when i.`category` ='BCB' and i.subCategory='Total' then   `totalSeats` else null end ),0) as BCBTOTAL\r\n" + 
					",ifnull(max(case when i.`category` ='BCB' and i.subCategory='NonESMESP' then   `totalSeats` else null end ),0) as BCBNONESMESP,\r\n" + 
					"ifnull(max(case when i.`category` ='BCB' and i.subCategory='ESM' then   `totalSeats` else null end ),0) as BCBESM\r\n" + 
					",ifnull(max(case when i.`category` ='BCB' and i.subCategory='ESP' then   `totalSeats` else null end ),0) as BCBESP\r\n" + 
					",ifnull(max(case when i.`category` ='EBPGC' and i.subCategory='Total' then   `totalSeats` else null end ),0) as EBPGCTOTAL\r\n" + 
					",ifnull(max(case when i.`category` ='EBPGC' and i.subCategory='NonESMESP' then   `totalSeats` else null end ),0) as EBPGCNONESMESP,\r\n" + 
					"ifnull(max(case when i.`category` ='EBPGC' and i.subCategory='ESM' then   `totalSeats` else null end ),0) as EBPGCESM\r\n" + 
					",ifnull(max(case when i.`category` ='EBPGC' and i.subCategory='ESP' then   `totalSeats` else null end ),0) as EBPGCESP\r\n" + 
					",ifnull(max(case when i.`category` ='SBC' and i.subCategory='Total' then   `totalSeats` else null end ),0) as SBCTOTAL\r\n" + 
					",ifnull(max(case when i.`category` ='SBC' and i.subCategory='NonESMESP' then   `totalSeats` else null end ),0) as SBCNONESMESP,\r\n" + 
					"ifnull(max(case when i.`category` ='SBC' and i.subCategory='ESM' then   `totalSeats` else null end ),0) as SBCESM\r\n" + 
					",ifnull(max(case when i.`category` ='SBC' and i.subCategory='ESP' then   `totalSeats` else null end ),0) as SBCESP\r\n" + 
					",ifnull(max(case when i.`category` ='SC' and i.subCategory='Total' then   `totalSeats` else null end ),0) as SCTOTAL\r\n" + 
					",ifnull(max(case when i.`category` ='SC' and i.subCategory='NonESMESP' then   `totalSeats` else null end ),0) as SCNONESMESP,\r\n" + 
					"ifnull(max(case when i.`category` ='SC' and i.subCategory='ESM' then   `totalSeats` else null end ),0) as SCESM\r\n" + 
					",ifnull(max(case when i.`category` ='SC' and i.subCategory='ESP' then   `totalSeats` else null end ),0) as SCESP, totalPWDSeats\r\n" + 
					"FROM `requisitionreservationinfo` i left join requisitioninfo r on  i.idRequisition=r.idRequisition  \r\n" + 
					"inner join department d on r.dEpartmentId=d.dEpartmentId\r\n" + 
					"inner join postmaster p on r.postmasterid=p.postmasterid where d.departmentid!=90 and r.classAndServiceOfPost='"+group+"'\r\n" + 
					"GROUP BY  dEpartment,postname  order by dEpartment,postname";
			allDistinctRecords = (List<RequisitionReport>)getJdbcTemplate().query(query, 
						new RowMapper<RequisitionReport>(){
					@Override
					public RequisitionReport mapRow(final ResultSet resultSet, final int arg1) throws SQLException
					{
						final RequisitionReport RequisitionReport = new RequisitionReport();
						RequisitionReport.setDepartmentName(resultSet.getString("Department"));
						RequisitionReport.setPostName(resultSet.getString("Postname"));
						RequisitionReport.setNumberOfPostToBeFilled(resultSet.getInt("numberOfPostToBeFilled"));
						RequisitionReport.setGeneralTotal(resultSet.getInt("GENERALTOTAL"));
						RequisitionReport.setGeneralNonesmesp(resultSet.getInt("GENERALNONESMESP"));
						RequisitionReport.setGeneralEsm(resultSet.getInt("GENERALESM"));
						RequisitionReport.setGeneralEsp(resultSet.getInt("GENERALESP"));
						RequisitionReport.setBcaTotal(resultSet.getInt("BCATOTAL"));
						RequisitionReport.setBcaNonesmesp(resultSet.getInt("BCANONESMESP"));
						RequisitionReport.setBcaEsm(resultSet.getInt("BCAESM"));
						RequisitionReport.setBcaEsp(resultSet.getInt("BCAESP"));
						RequisitionReport.setBcbTotal(resultSet.getInt("BCBTOTAL"));
						RequisitionReport.setBcbNonesmesp(resultSet.getInt("BCBNONESMESP"));
						RequisitionReport.setBcbEsm(resultSet.getInt("BCBESM"));
						RequisitionReport.setBcbEsp(resultSet.getInt("BCBESP"));
						RequisitionReport.setEbpgcTotal(resultSet.getInt("EBPGCTOTAL"));
						RequisitionReport.setEbpgcNonesmesp(resultSet.getInt("EBPGCNONESMESP"));
						RequisitionReport.setEbpgcEsm(resultSet.getInt("EBPGCESM"));
						RequisitionReport.setEbpgcEsp(resultSet.getInt("EBPGCESP"));
						RequisitionReport.setSbcTotal(resultSet.getInt("SBCTOTAL"));
						RequisitionReport.setSbcNonesmesp(resultSet.getInt("SBCNONESMESP"));
						RequisitionReport.setSbcEsm(resultSet.getInt("SBCESM"));
						RequisitionReport.setSbcEsp(resultSet.getInt("SBCESP"));
						RequisitionReport.setScTotal(resultSet.getInt("SCTOTAL"));
						RequisitionReport.setScNonesmesp(resultSet.getInt("SCNONESMESP"));
						RequisitionReport.setScEsm(resultSet.getInt("SCESM"));
						RequisitionReport.setScEsp(resultSet.getInt("SCESP"));
						RequisitionReport.setTotalPwd(resultSet.getInt("totalPWDSeats"));
						
						return RequisitionReport;
					}				
			});
			
			return allDistinctRecords;
		}catch(Exception e) {
			logger.logError("getAllDistinctStatusList", "error while fetching distinct data", e);
			throw e;
		}
	}

	@Override
	public List<UserLogin> getAllReqRegisteredUsers() throws Exception {
		List<UserLogin> registeredUsersList = new ArrayList<UserLogin>();
		try {
			registeredUsersList = (List<UserLogin>)getJdbcTemplate().query("SELECT *\r\n" + 
					"FROM `user_master`\r\n" + 
					"WHERE `idDept` IS NOT NULL AND `idDept` != '90'", 
						new RowMapper<UserLogin>(){
					@Override
					public UserLogin mapRow(final ResultSet resultSet, final int arg1) throws SQLException
					{
						final UserLogin users = new UserLogin();
						users.setUserId(resultSet.getInt("userId"));
						return users;
					}				
			});
		}catch(Exception e) {
			logger.logError("getAllNotificationsByDepartment", "exception while getting Notifications", e);
			throw e;
		}
		return registeredUsersList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Department getdepartmentData(Integer dEpartmentId) throws Exception {
		List<Department> deparment = new ArrayList<Department>();
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
			criteria.add(Restrictions.eq("dEpartmentId", dEpartmentId));
			deparment = (List<Department>) getHibernateTemplate().findByCriteria(criteria);
			if (CommonUtils.isNotEmpty(deparment)) {
				return deparment.get(0);
			} else {
				return null;
			}
			
		}catch(Exception e) {
			logger.logError("getdepartmentData", "exception while getting departmentInfo", e);
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RequisitionInfo> getAllDuplicateRecords(Integer dEpartmentId, Integer postmasterId,  Integer postmasterId2) throws Exception {
		List<RequisitionInfo> duplicatesList = new ArrayList<RequisitionInfo>();
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(RequisitionInfo.class);
			
			if(CommonUtils.isNotEmpty(postmasterId2)) {
				criteria.add(Restrictions.ne("postmasterId", postmasterId2));
			}
			criteria.add(Restrictions.eq("dEpartmentId", dEpartmentId));
			criteria.add(Restrictions.eq("postmasterId", postmasterId));
			criteria.add(Restrictions.ne("status", "Advertised"));
			duplicatesList = (List<RequisitionInfo>) getHibernateTemplate().findByCriteria(criteria);
			if (CommonUtils.isNotEmpty(duplicatesList)) {
				return duplicatesList;
			} else {
				return null;
			}
			
		}catch(Exception e) {
			logger.logError("getdepartmentData", "exception while getting departmentInfo", e);
			throw e;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SmsReceivers> getReceiversList(SmsReceivers receiverObj) throws Exception {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(SmsReceivers.class);
			 if(CommonUtils.isNotEmpty(receiverObj.getReceiverRole())) {
				 criteria.add(Restrictions.eq("receiverRole", receiverObj.getReceiverRole()));
			 }
			
			List<SmsReceivers> receiversList = (List<SmsReceivers>) getHibernateTemplate().findByCriteria(criteria);
			if (CommonUtils.isNotEmpty(receiversList)) {
				return receiversList;
			} else {
				return null;
			}
			
		}catch(Exception e) {
			logger.logError("getdepartmentData", "exception while getting departmentInfo", e);
			throw e;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public PostGroup getPostGroup(String classAndServiceOfPost) throws Exception {
		try {
		DetachedCriteria criteria = DetachedCriteria.forClass(PostGroup.class);
		
			 criteria.add(Restrictions.eq("postgroupName", classAndServiceOfPost));
	
		List<PostGroup> postGroupList = (List<PostGroup>) getHibernateTemplate().findByCriteria(criteria);
		if (CommonUtils.isNotEmpty(postGroupList)) {
			return postGroupList.get(0);
		} else {
			return null;
		}
		
	}catch(Exception e) {
		logger.logError("getdepartmentData", "exception while getting departmentInfo", e);
		throw e;
	}

}
	@Override
	public List<RequisitionInfo> getAllDistinctGroupList() throws Exception {
		List<RequisitionInfo> allDistinctRecords = new ArrayList<RequisitionInfo>();
		try {
			allDistinctRecords = (List<RequisitionInfo>)getJdbcTemplate().query("select distinct classAndServiceOfPost from requisitioninfo ", 
						new RowMapper<RequisitionInfo>(){
					@Override
					public RequisitionInfo mapRow(final ResultSet resultSet, final int arg1) throws SQLException
					{
						final RequisitionInfo requisition = new RequisitionInfo();
						requisition.setClassAndServiceOfPost(resultSet.getString("classAndServiceOfPost"));
						return requisition;
					}				
			});
			
			return allDistinctRecords;
		}catch(Exception e) {
			logger.logError("getAllDistinctGroupList", "error while fetching distinct data", e);
			throw e;
		}
	}
	@Override
	@Transactional(readOnly=false)
	public AdvtStatusForSPE saveAdvtStatusForSpe(AdvtStatusForSPE advtStatusReq) throws Exception {
		try {
			getHibernateTemplate().saveOrUpdate(advtStatusReq);
		}catch(Exception e) {
			logger.logError("saveAdvtStatusForSpe", "error while Save Or Update Advt Status For Spe Data", e);
		}
		return advtStatusReq;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<AdvtStatusForSPE> getAllAdvtForSPE(Integer dEpartmentId, int firstRecordIndex, int pageSize,
			SortOrderEnum sortDirection, String sortCriterion) throws Exception {
		     DetachedCriteria criteria = DetachedCriteria.forClass(AdvtStatusForSPE.class);
		try {
			  if(CommonUtils.isNotEmpty(dEpartmentId)) {
				  criteria.add(Restrictions.eq("dEpartmentId", dEpartmentId));
			  }
		
		if (CommonUtils.isNotEmpty(sortCriterion)) {
			if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
				criteria.addOrder(Order.asc(sortCriterion));
			}
			if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
				criteria.addOrder(Order.desc(sortCriterion));
			}
		}else {
			criteria.addOrder(Order.asc("createdDate"));
		}
		
		List<AdvtStatusForSPE> AllAdvtForSPE = (List<AdvtStatusForSPE>) getHibernateTemplate()
				.findByCriteria(criteria, firstRecordIndex, pageSize);

		if (CommonUtils.isNotEmpty(AllAdvtForSPE)) {
			return AllAdvtForSPE;
		} else {
			return null;
		}	
        }catch(Exception e) {
        	logger.logError("getAllAdvtForSPE", "error while getting advt Data", e);
		}
		return null;
	}
	@Override
	public int getAllAdvtForSPECount(Integer dEpartmentId) throws Exception {
		 DetachedCriteria criteria = DetachedCriteria.forClass(AdvtStatusForSPE.class);
		try {
			 if(CommonUtils.isNotEmpty(dEpartmentId)) {
				  criteria.add(Restrictions.eq("dEpartmentId", dEpartmentId));
			  }
		criteria.setProjection(Projections.rowCount());
		final List<?> results = getHibernateTemplate().findByCriteria(criteria);
		return CommonUtils.isEmpty(results) == true ? 0 : ((Long) results.get(0)).intValue();
		}catch(Exception e) {
			logger.logError("getAllAdvtForSPE", "error while getting advt Data count", e);
		}
		return 0;
	}

}
