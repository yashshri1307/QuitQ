package com.hexaware.quitq.exception;

/* File: PaymentNotFoundException
 * Author: Yash Shrivastava
 * Date Created: 2024-12-18
 * Description: Exception for payment not found            
 */
public class PaymentNotFoundException extends RuntimeException {

    public PaymentNotFoundException(String message) {
        super(message);
    }
}
