package com.example.demo.service.impl;

import com.example.demo.model.Rating;
import com.example.demo.model.Winery;
import com.example.demo.model.exception.NoWineryException;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.RatingRepository;
import com.example.demo.repository.WineryRepository;
import com.example.demo.service.RatingService;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    private final WineryRepository wineryRepository;

    public RatingServiceImpl(RatingRepository ratingRepository, WineryRepository wineryRepository) {
        this.ratingRepository = ratingRepository;
        this.wineryRepository = wineryRepository;
    }

    @Override
    public Rating addRating(Long id, double rating) throws NoWineryException {
        Winery winery = wineryRepository.findById(id).orElse(null);
        if(winery!=null){
            Rating rating_class = new Rating();
            rating_class.setRating(rating);
            rating_class.setWinery(winery);
            winery.addRating(rating_class);

            Rating finalRating = new Rating();
            finalRating.setWinery(winery);
            DoubleSummaryStatistics doubleSummaryStatistics = winery.getRating().stream().mapToDouble(Rating::getRating).summaryStatistics();
            finalRating.setRating(doubleSummaryStatistics.getAverage());
            Rating r = ratingRepository.findAllByWinery(winery).orElse(null);

            if(r!=null){
                ratingRepository.delete(r);
            }
           return ratingRepository.save(finalRating);

        }else{
            throw new NoWineryException();
        }
    }


}
