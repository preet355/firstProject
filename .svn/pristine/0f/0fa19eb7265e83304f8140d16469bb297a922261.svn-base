package in.hkcl.service;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import in.hkcl.model.CourtCaseDetails;
import in.hkcl.model.HearingDetails;
import in.hkcl.model.SmsReceivers;
import in.hkcl.smsIntegration.SmsSender;
import in.hkcl.utils.CommonUtils;
import in.hkcl.utils.DateFormatterUtility;

public class SchedularService {
	
	@Autowired
	CourtCaseService courtCaseService;
	
	@Autowired
	RequisitionService requisitionService;
	
	@Autowired
	SmsSender smsSender;
	
	@Scheduled(cron="0 30 17 * * ?")
    public void courtCaseCommunicationService() throws Exception
    {

		String smsMsg=null;
		String extendedMsg=null;
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1); 
		Date yesterdaydate=c.getTime();
		 List<HearingDetails> hearingList=courtCaseService.getAllHearingDates(yesterdaydate);
		   if(CommonUtils.isNotEmpty(hearingList)) {
			   for(HearingDetails obj: hearingList) {
				   CourtCaseDetails courtcaseObj=courtCaseService.getCourtCaseByCaseId(obj.getCaseId());
				   List<Date> maxDates=new ArrayList<Date>();
				   if(CommonUtils.isNotEmpty(courtcaseObj)) {
					   for(HearingDetails vo:courtcaseObj.getHearingDetailsList()) {
					    	  maxDates.add(vo.getDate());
					      }
					   
					   Date maxDate=Collections.max(maxDates);
					   String newMaxDate=DateFormatterUtility.datetoStringConversion(maxDate, DateFormatterUtility.FORMAT_PATTERN_7);
					   String newYesterdayDate=DateFormatterUtility.datetoStringConversion(yesterdaydate, DateFormatterUtility.FORMAT_PATTERN_7);
					     if(newMaxDate.equals(newYesterdayDate)) {
					    	 extendedMsg="Next Date of Hearing is not updated yet";					     
					    }
					     else {
					    	 extendedMsg="Next Date of Hearing is"+DateFormatterUtility.datetoStringConversion(maxDate, DateFormatterUtility.FORMAT_PATTERN_7);
					     }
					   smsMsg=URLEncoder.encode("This is to inform that court hearing for Court Case ["+courtcaseObj.getWritNo()+"] related to Post ["+courtcaseObj.getPoliceDetailsObj().getnAmeOfPost()+"] "
					   		+ "Advertisement ["+courtcaseObj.getPoliceDetailsObj().getaDvtNo()+"] happened on ["+yesterdaydate+"]."
					   		+ " The update from the court case is - ["+courtcaseObj.getStay()+"/"+extendedMsg+"].","UTF-8");
					   SmsReceivers receiverObj=new SmsReceivers();	
					    receiverObj.setReceiverRole("CC");
					    List<SmsReceivers> receiversList=requisitionService.getReceiversList(receiverObj);
					    String senderId=URLEncoder.encode("CCHSSC", "UTF-8");
					    smsSender.sendSms(receiversList, smsMsg,senderId);
				   }
			   }
		   }
		
		System.out.println(yesterdaydate);
    }
	
	@Scheduled(cron="0 30 11 * * ?")
	public void hearingDatePreCommunication() throws Exception{
		
		String smsMsg=null;
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 7); 
		Date preCommunicationDate=c.getTime();
		
	    List<HearingDetails> hearingList=courtCaseService.getAllHearingDates(preCommunicationDate);
	    
	    if(CommonUtils.isNotEmpty(hearingList)) {
			   for(HearingDetails obj: hearingList) {
				   CourtCaseDetails courtcaseObj=courtCaseService.getCourtCaseByCaseId(obj.getCaseId());
				   if(CommonUtils.isNotEmpty(courtcaseObj)) {
                        String comingDate=DateFormatterUtility.datetoStringConversion(obj.getDate(), DateFormatterUtility.FORMAT_PATTERN_7);
					   
					   smsMsg=URLEncoder.encode("This is a gentle reminder that the date of hearing for Court Case ["+courtcaseObj.getWritNo()+"] "
					   		+ "related to Post ["+courtcaseObj.getPoliceDetailsObj().getnAmeOfPost()+"] Advertisement "
					   				+ "["+courtcaseObj.getPoliceDetailsObj().getaDvtNo()+"] is ["+comingDate+"].","UTF-8");
					   SmsReceivers receiverObj=new SmsReceivers();	
					    receiverObj.setReceiverRole("CC");
					    List<SmsReceivers> receiversList=requisitionService.getReceiversList(receiverObj);
					    String senderId=URLEncoder.encode("CCHSSC", "UTF-8");
					    smsSender.sendSms(receiversList, smsMsg,senderId);
				   }
			   }
		   }
		
		System.out.println(preCommunicationDate);
      }

}
