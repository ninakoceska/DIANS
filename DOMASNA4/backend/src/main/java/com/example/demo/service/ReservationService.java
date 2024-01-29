package com.example.demo.service;

import com.example.demo.model.Reservation;

public interface ReservationService {
    Reservation addReservation(Reservation reservation, Long id);
}
