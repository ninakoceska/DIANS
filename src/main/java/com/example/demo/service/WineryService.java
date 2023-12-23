package com.example.demo.service;

import com.example.demo.model.Comment;
import com.example.demo.model.Winery;

import java.util.List;

public interface WineryService {


    List<Winery> list();

    Winery save(Winery user);

    void save(List<Winery> users);

    Winery findWineryById(Long id);

    void deleteWinery(Long id);

    Winery updateWinery(Winery winery, Winery wineryReq);

    void addRating(Winery winery, double rating);

    void addComment(Winery winery, String text);

    List<Winery> findAll();
}