package com.example.demo.model.exception;

public class InvalidPasswordLenghtException extends RuntimeException{
    public InvalidPasswordLenghtException() {
        super("Please have you password contain al least 8 chars");
    }
}
