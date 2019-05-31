package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@RestController
@ControllerAdvice
@Slf4j
public class IMExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<?> handleExceptions(Exception ex, WebRequest request){
		
		
		ExceptionResponse exceptionResponse =new ExceptionResponse(new Date(),ex.getMessage());

		//Log.info("ControllerAdvice -> ExceptionHandler : "+ex);
		return new ResponseEntity<>(exceptionResponse,HttpStatus.EXPECTATION_FAILED);
	}
	
}
