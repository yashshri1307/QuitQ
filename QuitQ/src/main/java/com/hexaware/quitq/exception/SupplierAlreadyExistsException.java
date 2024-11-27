package com.hexaware.quitq.exception;
/* File: SupplierAlreadyExists
 * Author: Yash Shrivastava
 * Date Created: 2024-11-15
 * Description: Exception for supplier Already Exists 
 *              When Adding a new supplier          
 */
public class SupplierAlreadyExistsException extends RuntimeException {

	public SupplierAlreadyExistsException(String message) {
		super(message);
	}

	
}
