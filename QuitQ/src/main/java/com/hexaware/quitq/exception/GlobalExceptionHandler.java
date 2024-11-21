package com.hexaware.quitq.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<String> handleException(CustomerAlreadyExistsException ex) {
  
  return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
    }
	
	@ExceptionHandler(SupplierNotFoundException.class)
    public ResponseEntity<String> handleException(SupplierNotFoundException ex) {
  
  return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
    }
	
	@ExceptionHandler(SupplierAlreadyExistsException.class)
    public ResponseEntity<String> handleException(SupplierAlreadyExistsException ex) {
  
  return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
    }
	
	
}
