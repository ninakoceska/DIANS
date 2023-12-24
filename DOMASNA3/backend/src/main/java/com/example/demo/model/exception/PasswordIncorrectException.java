package com.example.demo.model.exception;

public class PasswordIncorrectException extends RuntimeException{
    public PasswordIncorrectException() {
        super("The password isn't correct");
    }
}
