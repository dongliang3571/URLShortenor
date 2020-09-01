package org.shortener.dong.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "urls")
public class Url implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@Column(name = "orignal_url")
	private String originalUrl;
	
	public Url(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	
}
