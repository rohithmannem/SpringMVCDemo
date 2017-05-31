package com.rohith.repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Repository;

import com.rohith.modal.Article;
import com.rohith.modal.News;

@Repository("newsDao")
public class NewsDaoImpl implements NewsDao {

	private static String CNN_BASE_URI = "https://newsapi.org";
	private static String PATH = "/v1/articles";
	static String response = "";
	FileWriter writer = null;
	
	@Override
	public News getNews() {

		File csvFile = new File("/Users/rohithmannem/Documents/news.csv");

		System.out.println(csvFile.getAbsolutePath());

		News news = null;

		try {

			writer = new FileWriter(csvFile);

			Client client = ClientBuilder.newClient();
			WebTarget target = client.target(CNN_BASE_URI).path(PATH).queryParam("source", "cnn")
					.queryParam("sortBy", "top").queryParam("apiKey", "2a4639109b424bd3970e2fdf00fa54de");

			System.out.println("URL : " + target.getUri());
			Response httpResponse = target.request(MediaType.APPLICATION_JSON_TYPE).get();

			// 200--> Success

			// 400--> Bad
			// 401--> UnAuthorized
			// 404--> Page Not found

			if (httpResponse != null && httpResponse.getStatus() != 200) {
				System.out.println("Error in CNN Rest API and error code is ****** : " + httpResponse.getStatus());
				System.out.println("Response Description ****** \n " + httpResponse.readEntity(String.class));
			} else {
				response = httpResponse.readEntity(String.class);
				System.out.println("Output from Server ******** \n" + response);
			}
			Object obj=JSONValue.parse(response);
			
			JSONObject cnnNewsObject = (JSONObject) obj;
			JSONArray jsonArticleArray = (JSONArray) cnnNewsObject.get("articles");

			news = new News(); //12345
			List<Article> articles = new ArrayList<Article>();
			Article article;
			for (int i = 0; i < jsonArticleArray.size(); i++) {

				article = new Article();

				JSONObject jsonArticle = (JSONObject) jsonArticleArray.get(i);

				if (jsonArticle.get("author") != null) {
					article.setAuthor((String) jsonArticle.get("author"));
				}
				
				article.setTitle((String) jsonArticle.get("title"));
				article.setDescription((String) jsonArticle.get("description"));
				article.setUrl((String) jsonArticle.get("url"));
				article.setUrlToImage((String) jsonArticle.get("urlToImage"));
				
				if (jsonArticle.get("publishedAt") != null) {
					article.setAuthor((String) jsonArticle.get("publishedAt"));
				}

				articles.add(article);	
				news.setArticles(articles);
				
			}
			

			news.setStatus((String) cnnNewsObject.get("status"));
			news.setSource((String) cnnNewsObject.get("source"));
			news.setSort((String) cnnNewsObject.get("sortBy"));
			news.setArticles(articles);

		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("dao class is called  "+ news.getArticles().get(0).getTitle());
		
		return news;
        
	}
	
}