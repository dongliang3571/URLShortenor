package org.shortener.dong.model;

public class UrlForResponse<T> {
	
	private T data;
	private Errors errors;
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Errors getErrors() {
		return errors;
	}

	public void setErrors(Errors errors) {
		this.errors = errors;
	}

	public UrlForResponse(T data, Errors errors) {
		setData(data);
		setErrors(errors);
	}
}

