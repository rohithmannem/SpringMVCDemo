package com.rohith.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rohith.modal.News;
import com.rohith.repository.NewsDao;

@Service("newsService")
public class NewsServiceImpl implements NewsService {
    
	@Autowired
	@Qualifier("newsDao")
	public NewsDao newsDao;
	
	@Override
	public News getNews() {
	
	return newsDao.getNews();
				
	}
}
