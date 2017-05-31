package com.rohith.springMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rohith.modal.News;
import com.rohith.service.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController {

	@Autowired
	@Qualifier("newsService")
	private NewsService newsService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getCnnNews(Model model) {
		
		News news = newsService.getNews();
		
		model.addAttribute("news", news);
		
		return "userForm";
	}

}
