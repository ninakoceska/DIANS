package com.example.demo.model.exception;

public class InvalidReservationException extends RuntimeException{

    public InvalidReservationException() {
        super("Can't make a reservation on that date");
    }
}
