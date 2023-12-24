package com.example.demo.model.exception;

public class InvalidPasswordSavedException extends RuntimeException{
    public InvalidPasswordSavedException() {
        super(String.format("Please have capital letters, [A-Z] in your password!"));
    }
}
