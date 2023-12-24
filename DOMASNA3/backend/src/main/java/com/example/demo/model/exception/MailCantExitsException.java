package com.example.demo.model.exception;

public class MailCantExitsException extends RuntimeException{
    public MailCantExitsException(String msg) {
        super(String.format("Email with %s doesn't exist",msg));
    }
}
