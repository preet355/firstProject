package in.hkcl.Interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import in.hkcl.model.UserLogin;
public class AuthorizationInterceptor implements HandlerInterceptor {

	private static final Logger log = LoggerFactory.getLogger(AuthorizationInterceptor.class);
	    @Override
	    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {

			log.info("Interceptor: Pre-handle");

			 // Avoid a redirect loop for some links
		if (!request.getRequestURI().equals("/HSSCList/")&&
			    !request.getRequestURI().equals("/HSSCList/Home")&&
			    !request.getRequestURI().equals("/HSSCList/login")&&
			    !request.getRequestURI().equals("/HSSCList/contact")&&
			    !request.getRequestURI().equals("/HSSCList/registrationConfirm")&&
			    !request.getRequestURI().equals("/HSSCList/errorSignup")&&
			    !request.getRequestURI().equals("/HSSCList/resendRegistrationToken")&&
			    !request.getRequestURI().equals("/HSSCList/forgotPassword")&&
			    !request.getRequestURI().equals("/HSSCList/resetPassword")&&
			    !request.getRequestURI().equals("/HSSCList/changePassword")&&
			    !request.getRequestURI().equals("/HSSCList/saveNewPassword")&&
			    !request.getRequestURI().equals("/HSSCList/register")&&
			    !request.getRequestURI().equals("/HSSCList/privacyControl")&&
			    !request.getRequestURI().equals("/HSSCList/showRoles")&&
			    !request.getRequestURI().equals("/HSSCList/changeExpiredPassword")&&
			    !request.getRequestURI().equals("/HSSCList/changeExpiredpasswordAlreadyexistError")&&
				!request.getRequestURI().equals("/HSSCList/test")&&
				!request.getRequestURI().equals("/HSSCList/HSSCListRequisitionJsonInfo")&&
				!request.getRequestURI().equals("/HSSCList/signUp")&&
				!request.getRequestURI().equals("/HSSCList/emailTemplate")&&
				!request.getRequestURI().equals("/HSSCList/readOnlyReq")&&
				!request.getRequestURI().equals("/HSSCList/saveReadOnlyReq")&&
			    !request.getRequestURI().equals("/HSSCList/httpReferrer")&&
			    !request.getRequestURI().equals("/HSSCList/testSmsUtility"))
			  {
				  UserLogin userData = (UserLogin) request.getSession().getAttribute("user");
			   if(userData == null)
			   {
			    response.sendRedirect("/HSSCList/login");
			    return false;
			   }   
			  }
			  return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		    log.debug("Post-handle");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.debug("After-Complition");
		
	}

	
}