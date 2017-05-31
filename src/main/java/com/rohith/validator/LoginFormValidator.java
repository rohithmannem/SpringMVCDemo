package com.rohith.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rohith.modal.UserLoginBean;

@Component
public class LoginFormValidator  implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		boolean verifyType  = UserLoginBean.class.equals(arg0);
		return verifyType;
	}

	@Override
	public void validate(Object form, Errors errors) {
		
		UserLoginBean userLoginBean = (UserLoginBean) form;
		
		String password = userLoginBean.getPassword();
		
		
		if ( userLoginBean.getUserName() == null ||  userLoginBean.getUserName().equals("") ) {

			errors.rejectValue("userName", "400", "not a valid username or username already exist");
		}
		if (password == null) {
			
			errors.rejectValue("password", "400", "enter a valid password");
			
		}
	
	}

	








}
