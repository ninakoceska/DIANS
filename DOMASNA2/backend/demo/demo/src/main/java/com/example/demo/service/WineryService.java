package com.example.demo.service;

import com.example.demo.model.Winery;

import java.util.List;

public interface WineryService {


     Iterable<Winery> list();

     Winery save(Winery user);
    void save(List<Winery> users);

    Winery findWineryById(Long id);
}
