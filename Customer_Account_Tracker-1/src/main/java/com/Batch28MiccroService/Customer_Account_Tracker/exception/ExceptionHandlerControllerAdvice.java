package com.Batch28MiccroService.Customer_Account_Tracker.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;




@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ResponseBody ExceptionResponse handleResourceNotFoundException1(UserNotFoundException exception,HttpServletRequest reuest) {
		
		ExceptionResponse response=new ExceptionResponse();
		response.setErrorMessage(exception.getMessage());
		response.setRequestURI(response.getRequestURI());
		return  response;
		
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ResponseBody ExceptionResponse handleResourceNotFoundException(ResourceNotFoundException exception,HttpServletRequest reuest) {
		
		ExceptionResponse response=new ExceptionResponse();
		response.setErrorMessage(exception.getMessage());
		response.setRequestURI(response.getRequestURI());
		return  response;
		
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ResponseBody ExceptionResponse handleException(Exception exception,HttpServletRequest request)
	{
		ExceptionResponse response=new ExceptionResponse();
		response.setErrorMessage("Something Went Worng Somewhere");
		response.setRequestURI(request.getRequestURI());
		
		return response;
	}
	

}
