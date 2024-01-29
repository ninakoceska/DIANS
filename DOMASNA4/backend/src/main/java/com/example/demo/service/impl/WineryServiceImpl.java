package com.example.demo.service.impl;

import com.example.demo.model.Comment;
import com.example.demo.model.Winery;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.RatingRepository;
import com.example.demo.repository.WineryRepository;
import com.example.demo.service.WineryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WineryServiceImpl implements WineryService {


        private final WineryRepository wineryRepository;

        private final RatingRepository ratingRepository;

        private final CommentRepository commentRepository;


    public WineryServiceImpl(WineryRepository wineryRepository, RatingRepository ratingRepository, CommentRepository commentRepository) {
        this.wineryRepository = wineryRepository;
        this.ratingRepository = ratingRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Winery> list() {
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

    @Override
    public void deleteWinery(Long id) {
        wineryRepository.deleteById(id);
    }

    @Override
    public Winery updateWinery(Winery winery, Winery wineryReq) {

        Winery saveWinery = new Winery();

      saveWinery.setId(winery.getId());

      saveWinery.setName(wineryReq.getName());
      saveWinery.setInternational_name(wineryReq.getInternational_name());
      saveWinery.setShop(wineryReq.getShop());
      saveWinery.setLatitude(wineryReq.getLatitude());
      saveWinery.setLongitude(wineryReq.getLongitude());
      saveWinery.setAmenity(wineryReq.getAmenity());

      if(saveWinery.getShop()==null) saveWinery.setShop(winery.getShop());
      if(saveWinery.getName()==null) saveWinery.setName(winery.getName());
      if(saveWinery.getInternational_name()==null) saveWinery.setInternational_name(winery.getInternational_name());
      if(saveWinery.getAmenity()==null) saveWinery.setAmenity(winery.getAmenity());
      if(saveWinery.getLatitude()==0) saveWinery.setLatitude(winery.getLatitude());
      if(saveWinery.getLongitude()==0) saveWinery.setLongitude(winery.getLongitude());

      wineryRepository.save(saveWinery);
        return saveWinery;

    }

    @Override
    public void addRating(Winery winery, double rating ) {


    }

    @Override
    public void addComment(Winery winery, String text) {

    }

    @Override
    public List<Winery> findAll() {
        return wineryRepository.findAll();
    }


}
