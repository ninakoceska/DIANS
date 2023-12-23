package com.example.demo.model.exception;

public class InvalidEmailException extends RuntimeException{
    public InvalidEmailException(String msg) {
        super(String.format("Email %s isn't valid",msg));
    }
}
