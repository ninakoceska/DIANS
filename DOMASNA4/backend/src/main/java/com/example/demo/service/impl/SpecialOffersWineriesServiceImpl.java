package com.example.demo.service.impl;

import com.example.demo.model.SpecialOffersWineries;
import com.example.demo.model.Winery;
import com.example.demo.model.exception.NoWineryException;
import com.example.demo.repository.SpecialOffersWineriesRepository;
import com.example.demo.repository.WineryRepository;
import com.example.demo.service.SpecialOffersWineriesService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecialOffersWineriesServiceImpl implements SpecialOffersWineriesService {
    private final SpecialOffersWineriesRepository specialOffersWineriesRepository;

    private final WineryRepository wineryRepository;

    public SpecialOffersWineriesServiceImpl(SpecialOffersWineriesRepository specialOffersWineriesRepository, WineryRepository wineryRepository) {
        this.specialOffersWineriesRepository = specialOffersWineriesRepository;
        this.wineryRepository = wineryRepository;
    }

    @Override
    public SpecialOffersWineries addOffer(SpecialOffersWineries specialOffersWineries,Long id)throws NoWineryException {

        Winery winery = wineryRepository.findById(id).orElse(null);

        if(winery==null)throw new NoWineryException();

        winery.setSpecialOffersWineries(specialOffersWineries);
        specialOffersWineries.setWinery(winery);
       return this.specialOffersWineriesRepository.save(specialOffersWineries);
    }
}
