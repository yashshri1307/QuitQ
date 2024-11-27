package com.hexaware.quitq.exception;
/* File: CustomerAlreadyExists
 * Author: Yash Shrivastava
 * Date Created: 2024-11-15
 * Description: Exception for customer Already Exists 
 *              When Adding a new customer          
 */
public class CustomerAlreadyExistsException extends RuntimeException {

	public CustomerAlreadyExistsException(String message) {
		super(message);
	}

	
}
