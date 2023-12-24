package com.example.demo.web;

import com.example.demo.model.*;
import com.example.demo.model.response.WineryResponse;
import com.example.demo.repository.SpecialOffersWineriesRepository;
import com.example.demo.repository.WineryRepository;
import com.example.demo.service.*;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping( "/api")
@Validated
@CrossOrigin(origins="http://localhost:4200/")
public class WineryController {

   private final WineryService service;

   private final CommentService commentService;

   private final RatingService ratingService;

   private final SpecialOffersWineriesService specialOffersWineriesService;


   private final ReservationService reservationService;

   private final ImageConvertService imageConvertService;

    public WineryController(WineryService service, CommentService commentService,
                            RatingService ratingService,
                            SpecialOffersWineriesService specialOffersWineriesService,
                            ReservationService reservationService, ImageConvertService
                                    imageConvertService) {
        this.service = service;
        this.commentService = commentService;
        this.ratingService = ratingService;
        this.specialOffersWineriesService = specialOffersWineriesService;
        this.reservationService = reservationService;
        this.imageConvertService = imageConvertService;
    }

    @GetMapping("/all")
    public ResponseEntity<WineryResponse> list() {

        return new ResponseEntity<>(new WineryResponse(service.list()),HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Winery> getById(@PathVariable Long id){
        Winery winery = service.findWineryById(id);
        if(winery!=null){
            return new ResponseEntity<>(winery,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Winery> deleteById(@PathVariable Long id){
        Winery winery = service.findWineryById(id);
        if(winery!=null){
            service.deleteWinery(id);
            return new ResponseEntity<>(winery,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Winery> addWinery(@RequestBody Winery winery){

        String amenity = winery.getAmenity();
        String international_name= winery.getInternational_name();
        String name = winery.getName();
        String shop = winery.getShop();
        double latitude=winery.getLatitude();
        double longitude=winery.getLongitude();

        System.out.println(winery.getLatitude());


        if(amenity.isEmpty() || international_name.isEmpty() || name.isEmpty() || shop.isEmpty()
        || latitude==0 || longitude==0 ){
            return new ResponseEntity<>(winery,HttpStatus.PARTIAL_CONTENT);

        }else {
            service.save(winery);
            return new ResponseEntity<>(winery,HttpStatus.OK);
        }

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Winery> editWinery(@PathVariable Long id,@RequestBody Winery wineryReq){
        Winery winery = service.findWineryById(id);

        if(winery!=null){

          Winery updatedWinery =  service.updateWinery(winery,wineryReq);
            return new ResponseEntity<>(updatedWinery,HttpStatus.OK);

        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping("/rating/{id}")
    public ResponseEntity<Rating> rateWinery(@PathVariable Long id, @RequestBody Rating rating){

        try {
            Rating rating1 = ratingService.addRating(id, rating.getRating());
            return new ResponseEntity<>(rating1,HttpStatus.OK);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }


    }

    @PostMapping("/comment/{id}")
    public ResponseEntity<Comment> commentOnWinery(@PathVariable Long id,@RequestBody Comment comment){

        try {

            String text = comment.getComment();
            Comment comment1 = commentService.addComment(text, id);
            return new ResponseEntity<>(comment1,HttpStatus.OK);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping("/offer/{id}")
    public ResponseEntity<SpecialOffersWineries> addOfferWinery(@PathVariable Long id,@RequestBody SpecialOffersWineries specialOffersWineries){

        try{
           SpecialOffersWineries specialOffersWineries1 =  specialOffersWineriesService.addOffer(specialOffersWineries,id);
            return new ResponseEntity<>(specialOffersWineries1,HttpStatus.OK);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping("/reservation/{id}")
    public ResponseEntity<Reservation> addReservation(@PathVariable Long id,@RequestBody Reservation reservation){

        try {
           Reservation reservation1 =  reservationService.addReservation(reservation, id);
            return new ResponseEntity<>(reservation1,HttpStatus.OK);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


}


