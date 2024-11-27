package com.hexaware.quitq.exception;
/* File: GlobalExceptionHandler
 * Author: Yash Shrivastava
 * Date Created: 2024-11-16
 * Description: GlobalExceptionHandler for 
 *              handling different Exception globally                    
 */
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
	
	@ExceptionHandler(AdminAccessException.class)
    public ResponseEntity<String> handleException(AdminAccessException ex) {
  
  return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
    }
	
	@ExceptionHandler(ProductCategoryNotFoundException.class)
    public ResponseEntity<String> handleException(ProductCategoryNotFoundException ex) {
  
  return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
    }
	
	@ExceptionHandler(InventoryNotFoundException.class)
    public ResponseEntity<String> handleException(InventoryNotFoundException ex) {
   return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
    }
	
   /* @ExceptionHandler(OrderNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleOrderNotFoundException(OrderNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    */
	
	
}
