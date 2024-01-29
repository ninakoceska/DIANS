package com.example.demo.service.impl;

import com.example.demo.model.Reservation;
import com.example.demo.model.Winery;
import com.example.demo.model.exception.NoWineryException;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.WineryRepository;
import com.example.demo.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    private final WineryRepository wineryRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, WineryRepository wineryRepository) {
        this.reservationRepository = reservationRepository;
        this.wineryRepository = wineryRepository;
    }

    @Override
    public Reservation addReservation(Reservation reservation, Long id) throws NoWineryException {

        Winery winery = wineryRepository.findById(id).orElse(null);
        if(winery==null) throw new NoWineryException();

       // List<Reservation> res = winery.getReservations();
        //treba da se napravi proverka za rezervacie treba da se razmisli kako kje se implementira


        winery.setReservations(reservation);
        reservation.setWinery(winery);
       return reservationRepository.save(reservation);

    }
}
