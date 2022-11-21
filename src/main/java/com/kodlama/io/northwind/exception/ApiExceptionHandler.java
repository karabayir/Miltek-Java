package com.kodlama.io.northwind.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(value = {ApiRequestException.class})
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
		// Create payload(ApiException) containing exception details 
		
		ApiException apiException = new ApiException(
				e.getMessage(),
				//e, 
				HttpStatus.BAD_REQUEST, 
				LocalDateTime.now());
		
		// Return response entity
		return new ResponseEntity<>(apiException,HttpStatus.BAD_REQUEST); 
	}
}
