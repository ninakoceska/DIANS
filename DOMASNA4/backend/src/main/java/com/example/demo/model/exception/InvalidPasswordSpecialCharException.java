package com.example.demo.model.exception;

public class InvalidPasswordSpecialCharException extends RuntimeException{
    public InvalidPasswordSpecialCharException() {
        super("Please have you password containing a special character!");
    }
}
