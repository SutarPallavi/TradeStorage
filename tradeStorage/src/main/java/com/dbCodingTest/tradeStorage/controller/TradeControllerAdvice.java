package com.dbCodingTest.tradeStorage.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dbCodingTest.tradeStorage.exception.InvalidTradeException;





@ControllerAdvice
@RestController
public class TradeControllerAdvice extends ResponseEntityExceptionHandler{

	@ExceptionHandler (InvalidTradeException.class)
	public ResponseEntity<Object> handleInvalidTradeException (InvalidTradeException ex, WebRequest request){
		
		/*ExceptionResponse exceptionResponse = new ExceptionResponse (new Date(),
				 ex.getMessage(), request.getDescription(false)); */
		
		return new ResponseEntity<Object>( HttpStatus.NOT_ACCEPTABLE); 
	}
	
	/*@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> assertionException ( IllegalArgumentException)
	{
		return ResponseEntity<Object>(HttpStatus.NOT_ACCEPTABLE);
	}*/
}
