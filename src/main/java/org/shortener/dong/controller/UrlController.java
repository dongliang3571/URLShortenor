package org.shortener.dong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.shortener.dong.model.*;
import org.shortener.dong.service.*;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Base64;


@Controller
public class UrlController {
	
	private static String hostname = "https://urlshortenor.herokuapp.com/";
	
	@Autowired
	private URLServiceImpl service;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/ping")
	@ResponseBody
	public String ping() {
		return "ok 200";
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/addUrl", headers = "Accept=application/json")
	@ResponseBody
	public UrlForResponse<EncodedUrl> addUrl(@RequestBody UrlForRequest url) {
		System.out.println("entering addUrl");
		System.out.println("URL is: " + url.getUrl());
		
		// validate url
		String link = url.getUrl(); 
		if (!link.startsWith("http://") && !link.startsWith("https://")) {
			
			return new UrlForResponse<EncodedUrl>(
					null, new Errors(3, "Invalid url"));
		}
		
		Url urlToAdd = new Url(url.getUrl());
		Long id = service.add(urlToAdd);
		
		String encodedId = Base64.getEncoder().encodeToString(id.toString().getBytes());
		
		UrlForResponse<EncodedUrl> resp = new UrlForResponse<>(
				new EncodedUrl(hostname, encodedId), null);
		
		return resp;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{endpoint:.+}")
	public ResponseEntity<Void> index(@PathVariable String endpoint) {
		System.out.println("incoming traffic");
		System.out.println(endpoint);
		
		String pattern = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$";
		if (!endpoint.matches(pattern)) {
			return ResponseEntity.status(HttpStatus.FOUND)
			                     .location(URI.create("/"))
						         .build();
		}
		
		byte[] data = Base64.getDecoder().decode(endpoint);
		String endp = null;
		try {
			endp = new String(data, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(endp);
		Url originalUrl = service.find(Long.valueOf(endp));
		
		if (originalUrl == null) {
			return ResponseEntity.status(HttpStatus.FOUND)
                                 .location(URI.create("/"))
	        			         .build();
		}
		
		return ResponseEntity.status(HttpStatus.FOUND)
		        .location(URI.create(originalUrl.getOriginalUrl()))
		        .build();
	}
	
}