package com.example.crudException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class CrudException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorMessage;

	public CrudException(String errorMessage) {
		super(errorMessage); 
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
