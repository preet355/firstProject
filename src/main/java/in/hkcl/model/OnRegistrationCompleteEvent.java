package in.hkcl.model;

import java.util.Locale;

import javax.persistence.Column;

import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
public class OnRegistrationCompleteEvent extends ApplicationEvent{
	
	@Column(name="appUrl")
	private String appUrl;
	
	@Column(name="locale")
    private Locale locale;
	
	
    private UserLogin user;

    public OnRegistrationCompleteEvent(
    	      UserLogin user, Locale locale, String appUrl) {
    	        super(user);
    	         
    	        this.user = user;
    	        this.locale = locale;
    	        this.appUrl = appUrl;
    	    }

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public UserLogin getUser() {
		return user;
	}

	public void setUser(UserLogin user) {
		this.user = user;
	}
    
}
