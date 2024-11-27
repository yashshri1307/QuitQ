package com.hexaware.quitq.exception;
/* File: ProductAlreadyExists
 * Author: Yash Shrivastava
 * Date Created: 2024-11-15
 * Description: Exception for product Already Exists 
 *              When Adding a new product          
 */
public class ProductAlreadyExistsException extends RuntimeException{

	public ProductAlreadyExistsException(String message) {
		super(message);
	}

}
