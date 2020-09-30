package in.hkcl.service;

import in.hkcl.model.EmailLogs;
import in.hkcl.model.EmailTemplate;

public interface EmailService {
	
      public EmailLogs sendEmail( EmailLogs emailObj, EmailTemplate obj) throws Exception;
      public EmailLogs saveEmailLogs(EmailLogs emailObj) throws Exception;
      public EmailLogs sendEmail( EmailLogs emailObj) throws Exception;
}
