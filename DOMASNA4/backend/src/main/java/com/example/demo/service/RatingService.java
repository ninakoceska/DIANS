package com.example.demo.service;

import com.example.demo.model.Rating;
import com.example.demo.model.Winery;
import com.example.demo.model.exception.NoWineryException;

public interface RatingService {
    Rating addRating(Long id, double rating)throws NoWineryException;
}
