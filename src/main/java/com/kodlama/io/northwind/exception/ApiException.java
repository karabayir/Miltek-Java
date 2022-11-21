package com.kodlama.io.northwind.exception;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiException {

	private final String message;
	private final HttpStatus httpStatus;
	private final LocalDateTime timeStamp;
	//private final Throwable throwable;
	
	
}
