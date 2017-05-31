package com.rohith.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rohith.modal.News;
import com.rohith.service.NewsService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:**/WEB-INF/configuration/springDemo-context.xml"})
//@Configurable
public class NewsServiceTest {

	//@Autowired
	//@Qualifier("newsService")
	private NewsService newsService;
	
	//@Test
	public void getNewsTest() {
		
		System.out.println("We are in getNewsTest *************");
		  
			News news = newsService.getNews();
			System.out.println("Sort **********************" + news.getSort());
			System.out.println("Sort **********************"+ news.getStatus());
		
	}
	
	//@Test
	public void getUsersList() {
		
		System.out.println("We are in getNewsTest *************");
		  
			News news = newsService.getNews();
			System.out.println("Sort **********************" + news.getSort());
			System.out.println("Sort **********************"+ news.getStatus());
		
	}
	
}
