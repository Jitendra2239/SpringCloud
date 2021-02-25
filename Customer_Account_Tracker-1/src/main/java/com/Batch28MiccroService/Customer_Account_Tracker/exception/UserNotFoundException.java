package com.Batch28MiccroService.Customer_Account_Tracker.exception;

import org.springframework.http.HttpStatus;  
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		// TODO Auto-generated constructor stub
		super();
	}

	public UserNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

}
