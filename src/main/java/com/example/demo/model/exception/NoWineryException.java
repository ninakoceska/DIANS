package com.example.demo.model.exception;

public class NoWineryException extends RuntimeException{
    public NoWineryException() {
        super("The winery doesn't exist");
    }
}
