package in.hkcl.login.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import in.hkcl.model.UserLogin;

public class PasswordValidator implements ConstraintValidator<CustomAnnotationPassword, Object> { 
	
	  
  @Override
  public void initialize(CustomAnnotationPassword constraintAnnotation) {       
  }
  
  @Override
  public boolean isValid(Object obj, ConstraintValidatorContext context){   
	            UserLogin user = (UserLogin) obj;
	              
	           return user.getUserPassword().equals(user.getUserPassword());
	    
	   }   
}