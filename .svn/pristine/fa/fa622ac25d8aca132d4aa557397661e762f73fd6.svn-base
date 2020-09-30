package in.hkcl.service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

import in.hkcl.model.EmailLogs;
import in.hkcl.model.EmailTemplate;

import in.hkcl.dao.BaseDataDao;
import in.hkcl.service.EmailService;
import in.hkcl.utils.ApplicationLogFactory;
import in.hkcl.utils.ApplicationLogger;
import in.hkcl.utils.CommonUtils;

@Repository("emailService")
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSender mailSender;
	
	private static ApplicationLogger logger = ApplicationLogFactory.getLogger(EmailServiceImpl.class);
	
	@Autowired
	BaseDataDao baseDataDao;
	

	@Override
	public EmailLogs sendEmail(EmailLogs emailObj,EmailTemplate obj) throws Exception {
		try{
			
			
			final JavaMailSenderImpl ms = (JavaMailSenderImpl) mailSender;
			MimeMessage message = mailSender.createMimeMessage();
			final MimeMessageHelper Helper = new MimeMessageHelper(
					message, true, "UTF-8");
			emailObj.setEmailSender(ms.getUsername());
			
			if (emailObj == null
					|| emailObj.getEmailrecipient() == null) {
				throw new RuntimeException();
			}
			
			Helper.setTo(emailObj.getEmailrecipient());
			
			if (!CommonUtils.isEmpty(emailObj.getEmailCC())) {
				Helper.setCc(emailObj.getEmailCC());
			}

			if (!CommonUtils.isEmpty(emailObj.getEmailBCC())) {
				Helper.setBcc(emailObj.getEmailBCC());
			}
			
			if (!CommonUtils.isEmpty(emailObj.getEmailSubject())) {
				Helper.setSubject(emailObj.getEmailSubject());
			}
			
			Helper.setFrom(new InternetAddress(null, "HSSC"));
			String emailTxt=null;
	  if(CommonUtils.isNotEmpty(obj.getEmailType())){
			if(obj.getEmailType().contains("Approve"))	{
			 emailTxt=obj.getEmailHeadOne()+obj.getEmailCss()+obj.getEmailHeadTwo()+obj.getEmailBodyOne()
			+obj.getEmailBodyTwo()+obj.getEmailBodyThree()+emailObj.getEmailBody()
			+obj.getEmailBodyFour()+obj.getEmailFooter();
			}
	   if(obj.getEmailType().contains("Approve")){
			 emailTxt=obj.getEmailHeadOne()+obj.getEmailCss()+obj.getEmailHeadTwo()+obj.getEmailBodyOne()
			 +obj.getEmailBodyTwo()+obj.getEmailBodyThree()+emailObj.getEmailBody()
			 +obj.getEmailBodyFour()+obj.getEmailFooter();
		}
	
		if(obj.getEmailType().contains("Cancel"))
		{
			emailTxt=obj.getEmailHeadOne()+obj.getEmailCss()+obj.getEmailHeadTwo()+obj.getEmailBodyOne()
			+obj.getEmailBodyTwo()+emailObj.getEmailBody()+obj.getEmailBodyThree()+obj.getEmailFooter();
		}
		if(obj.getEmailType().contains("ResetPassword")){
			emailTxt=obj.getEmailHeadOne()+obj.getEmailCss()+obj.getEmailHeadTwo()+obj.getEmailBodyOne()
			+obj.getEmailBodyTwo()+emailObj.getEmailBody()+obj.getEmailBodyThree()+obj.getEmailFooter();
		}
		
		}		
			Helper.setText(emailTxt, true);
			
			mailSender.send(Helper.getMimeMessage());

		}catch(Exception e){
			logger.logError("sendEmail", "Exception while sending the email", e);
		}
	return emailObj;	
		
	}


	@Override
	public EmailLogs sendEmail(EmailLogs emailObj) throws Exception 
	{
		try{
			
			
			final JavaMailSenderImpl ms = (JavaMailSenderImpl) mailSender;
			MimeMessage message = mailSender.createMimeMessage();
			final MimeMessageHelper Helper = new MimeMessageHelper(
					message, true, "UTF-8");
			emailObj.setEmailSender(ms.getUsername());
			
			if (emailObj == null
					|| emailObj.getEmailrecipient() == null) {
				throw new RuntimeException();
			}
			
			Helper.setTo(emailObj.getEmailrecipient());
			
			if (!CommonUtils.isEmpty(emailObj.getEmailCC())) {
				Helper.setCc(emailObj.getEmailCC());
			}

			if (!CommonUtils.isEmpty(emailObj.getEmailBCC())) {
				Helper.setBcc(emailObj.getEmailBCC());
			}
			
			if (!CommonUtils.isEmpty(emailObj.getEmailSubject())) {
				Helper.setSubject(emailObj.getEmailSubject());
			}
			
			Helper.setFrom(new InternetAddress(null, "HSSC"));
						
			Helper.setText(emailObj.getEmailBody(), true);
			
			mailSender.send(Helper.getMimeMessage());

		}catch(Exception e){
			logger.logError("sendEmail", "Exception while sending the email", e);
			throw e;
		}
	return emailObj;	
		
	}


	@Override
	public EmailLogs saveEmailLogs(EmailLogs emailObj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
