package com.example.demo.service.impl;

import com.example.demo.model.Winery;
import com.example.demo.repository.WineryRepository;
import com.example.demo.service.WineryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WineryServiceImpl implements WineryService {


        private final WineryRepository wineryRepository;

    public WineryServiceImpl(WineryRepository wineryRepository) {
        this.wineryRepository = wineryRepository;
    }

    @Override
    public Iterable<Winery> list() {
            return wineryRepository.findAll();
        }

        @Override
        public Winery save(Winery user) {
            return wineryRepository.save(user);
        }


        @Override
        public void save(List<Winery> users) {
            wineryRepository.saveAll(users);
        }

    @Override
    public Winery findWineryById(Long id) {
        return wineryRepository.findById(id).orElseThrow();
    }


}
