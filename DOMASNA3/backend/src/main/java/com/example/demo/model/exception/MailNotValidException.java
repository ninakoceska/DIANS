package com.example.demo.model.exception;

public class MailNotValidException extends RuntimeException{
    public MailNotValidException() {
        super("The mail has to be validated from a reliable source");

    }
}
