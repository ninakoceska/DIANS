package com.example.demo.model.exception;

public class PasswordNumberException extends RuntimeException{
    public PasswordNumberException() {
        super("Password has to contain al least one number");
    }
}
