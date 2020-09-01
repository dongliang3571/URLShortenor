package org.shortener.dong.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.shortener.dong.model.*;
import org.shortener.dong.dao.*;
import org.shortener.dong.service.*;

@RestController
public class UrlController {
	
	private URLService service; 
	
	public UrlController() {
		Dao<Url> dao = new URLDaoImpl(BuildSessionFactory.sessionFactory.openSession());
//		
//		this.service = new URLService(dao);
	}
	
	public UrlController(URLService service) {
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/addUrl")
	public EncodedUrl addUrl(String url) {
		
		Url urlToAdd = new Url(url);
		Url urlSaved = service.add(urlToAdd);
		
		return new EncodedUrl(urlSaved.getId().toString());
	}
}