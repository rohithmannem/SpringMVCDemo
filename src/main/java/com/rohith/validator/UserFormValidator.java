package com.rohith.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.rohith.modal.UserBean;


@Component
public class UserFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return UserBean.class.equals(arg0);
	}

	@Override
	public void validate(Object form, Errors errors) {

		UserBean userBean = (UserBean) form;
		String emailId = userBean.getEmail();
		
		if (userBean.getName() == null || userBean.getName().equals("")) {

			errors.rejectValue("name", "400", "not a valid username or username already exist");
		}
		if (emailId == null || !(emailId.contains("@") || emailId.contains(".com"))) {

			errors.rejectValue("email", "400", "not a valid emailId");
		}

	}

}
