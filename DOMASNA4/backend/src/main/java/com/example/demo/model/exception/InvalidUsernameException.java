package com.example.demo.model.exception;


public class InvalidUsernameException extends RuntimeException{
    public InvalidUsernameException(String msg) {
        super(String.format("The username "+msg+" already exists!"));
    }
}
