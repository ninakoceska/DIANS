package com.example.demo.model.exception;

public class InvalidCredentialsException extends RuntimeException{

    public InvalidCredentialsException() {
        super("Credentials are not valid try again");
    }
}
