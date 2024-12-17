package com.hexaware.quitq.exception;

public class AdminNotFoundException extends RuntimeException {

    public AdminNotFoundException(String message) {
        super(message);  // Pass the message to the parent class (RuntimeException)
    }
}
