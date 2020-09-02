package org.shortener.dong.model;

public class EncodedUrl {
	private String hostname;
	private String endpoint;
	
	public EncodedUrl(String hostname, String endpoint) {
		this.setHostname(hostname);
		this.setEndpoint(endpoint);
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	
	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
	@Override
	public String toString() {
		return hostname + getEndpoint();
	}
}
