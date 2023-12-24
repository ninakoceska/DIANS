package com.example.demo.model.exception;

public class MailSpecialCharException extends RuntimeException{
    public MailSpecialCharException() {
        super("Mail has to contain @");
    }
}
