package org.shortener.dong.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "urls")
public class Url implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "created_date")
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name = "original_url", nullable = false)
	private String originalUrl;
	
	public Url() {
		
	}
	
	public Url(String originalUrl) {
		setOriginalUrl(originalUrl);
	}
	
	public Url(Long id, String originalUrl, LocalDateTime createdDate) {
		setId(id);
		setOriginalUrl(originalUrl);
		setCreatedDate(createdDate);
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
