package in.hkcl.smsIntegration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

import in.hkcl.model.SmsReceivers;
import in.hkcl.utils.CommonUtils;

public class SmsSender {
	
	public String sendSms(List<SmsReceivers> receiversList, String smsText,String senderId) {
		try {
			String sResult="";
			String username =URLEncoder.encode("hkcl", "UTF-8");
			String password ="Hkcl@123";
			if(CommonUtils.isNotEmpty(receiversList)) {
			for(SmsReceivers obj: receiversList) {
			String to =URLEncoder.encode("91"+obj.getReceiverMobile(), "UTF-8");
			
			String data = "https://nnljj.api.infobip.com/sms/1/text/query?username="+username+"&password="+password+"&to="+to+"&text="+smsText+"&from="+senderId;
			URL url = new URL(data);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
		
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			
			while ((line = rd.readLine()) != null) {	
	     
				sResult=sResult+line+" ";
			}
			rd.close();
		  }	
		}
			return sResult;
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}

}
