package com.example.demo.model.exception;

public class NoUserFoundException extends RuntimeException{
    public NoUserFoundException(String username) {
        super(String.format("Can't find user "+username));
    }
}
