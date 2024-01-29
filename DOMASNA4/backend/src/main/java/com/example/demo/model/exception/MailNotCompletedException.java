package com.example.demo.model.exception;

public class MailNotCompletedException extends RuntimeException{
    public MailNotCompletedException() {
        super("The mail has to end in .com");
    }
}
