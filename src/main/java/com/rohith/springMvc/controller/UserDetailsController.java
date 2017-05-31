package com.rohith.springMvc.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import com.rohith.modal.SearchBean;
import com.rohith.modal.UserBean;
import com.rohith.service.NewsService;
import com.rohith.service.UserService;
import com.rohith.validator.UserFormValidator;

@Controller
@RequestMapping("/user")
public class UserDetailsController {

	
	@Autowired
	private UserFormValidator userFormValidator;
 
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@InitBinder
	protected void initBinderUserForm(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}
	
	@Autowired
	@Qualifier("newsService")
	private NewsService newsService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage(Model model) {

		model.addAttribute("message", "This is Rohith");
		System.out.println("Hello we are in WelcomeController class and getHomePage method **************");

		News news = newsService.getNews();

		model.addAttribute("news", news);
		// model.addAttribute("articles", news.getArticles());
		System.out.println("Sort **********************" + news.getSort());
		System.out.println("Sort **********************" + news.getStatus());

		return "home";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String populateUserform(Model model, @ModelAttribute("userForm") UserBean user) {

		System.out.println("Hello we are in WelcomeController class and populateUserform method **************");

		Map<String, String> country = new LinkedHashMap<String, String>();
		country.put("US", "United Stated");
		country.put("CN", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");
		model.addAttribute("countryList", country);

		// user.setName("");

		return "userForm";
	}

	@RequestMapping(value = "/searchUser", method = RequestMethod.GET)
	public String populateFindUserForm(Model model, @ModelAttribute("searchUser") SearchBean searchBean) {

		return "searchUser";

	}

	@RequestMapping(value = "/submitUser", method = RequestMethod.POST)
	public String fetchUser(Model model, @Validated @ModelAttribute("userDetails") UserBean userBean, BindingResult results) {

		if (!results.hasErrors()) {

			userService.insertUser(userBean);
			
			return "confirmation";

		} else {

			return "login";
		}
	}

	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public String listAllUsers(Model model) {

		List<UserBean> userList = userService.listUsers();

		for (UserBean user : userList) {

			System.out.println("************" + user.getName());

		}

		model.addAttribute("userList", userList);

		return "listUsers";

	}


}
