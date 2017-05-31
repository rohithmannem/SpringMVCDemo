package com.rohith.springMvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rohith.modal.News;
import com.rohith.modal.UserBean;
import com.rohith.modal.UserLoginBean;
import com.rohith.service.NewsService;
import com.rohith.service.UserService;
import com.rohith.validator.LoginFormValidator;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	@Autowired
	private LoginFormValidator loginFormValidator;

	@Autowired
	private NewsService newsService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;

//	@InitBinder
//	protected void initBinderLoginForm(WebDataBinder binder) {
//		binder.setValidator(loginFormValidator);
//	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getUserHomePage(Model model, @ModelAttribute("loginForm") UserLoginBean userLoginBean) {

		System.out.println("In WelcomeController, method : getUserHomePage() @@@@@@@@@ @@@@");

		return "login";
	}

	@RequestMapping(value = "/login/submit", method = RequestMethod.POST)
	public String authenticateUser(Model model, @Valid @ModelAttribute("loginForm") UserLoginBean userLoginBean,
			BindingResult results) {

		System.out.println("Hello we are in WelcomeController class and populateUserform method $$$$");
		System.out.println("Name entered in JSP : " + userLoginBean.getUserName() +"  the password entered is "+ userLoginBean.getPassword());

		if(loginFormValidator.supports(userLoginBean.getClass())) {
			loginFormValidator.validate(userLoginBean, results);
		}
		
		if (!results.hasErrors()) {
			
			UserBean userBean = userService.getUser(userLoginBean.getUserName());
			if(userBean != null && userLoginBean.getUserName().equals(userBean.getName()) && userLoginBean.getPassword().equals(userBean.getPassword())){
				
				News news = newsService.getNews();

				model.addAttribute("news", news);
				
				return "home";
			} else {
				
				return "login";
			}
			
		} else {
			return "login";
		}

	}


}