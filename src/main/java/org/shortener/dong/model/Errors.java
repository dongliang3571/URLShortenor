package org.shortener.dong.model;

public class Errors {
	public int errorCode;
	public String errorMessage;
	
	public Errors(int errorCode, String errorMessage) {
		setErrorCode(errorCode);
		setErrorMessage(errorMessage);
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}