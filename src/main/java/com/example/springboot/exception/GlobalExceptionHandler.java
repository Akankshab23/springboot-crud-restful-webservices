package com.example.springboot.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.springboot.entity.User;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<User> resourseNotFoundException(ResourceNotFoundException ex, WebRequest request){
	    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<User> (HttpStatus.NOT_FOUND);	
	}
  
  @ExceptionHandler(Exception.class)
  public ResponseEntity<User> globalExceptionhandler(Exception ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<User> (HttpStatus.INTERNAL_SERVER_ERROR);	
  }
  
  protected ResponseEntity<User> handleMethodArgumentNotValid (MethodArgumentNotValidException ex,
		 HttpHeaders headers, HttpStatus status, WebRequest request){
	     ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed",
	    		 ex.getBindingResult().toString());
	     return new ResponseEntity<User> (HttpStatus.BAD_REQUEST);
			  
  }
		  
}

