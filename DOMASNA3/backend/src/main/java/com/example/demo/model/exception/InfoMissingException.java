package com.example.demo.model.exception;

public class InfoMissingException extends RuntimeException{
    public InfoMissingException() {
        super("PLease enter all of the information");
    }
}
