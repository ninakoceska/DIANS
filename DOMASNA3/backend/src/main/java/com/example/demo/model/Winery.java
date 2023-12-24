package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "winery")
@NoArgsConstructor
@AllArgsConstructor

public class Winery implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "winery_id")
    private Long id;


    //columnDefinition="VARCHAR(255) COLLATE Macedonian_FYROM_90_CI_AS
    //za baza koga kje se hostira
    private String name;


    private String amenity;


    private String shop;


    private String international_name;

    private double longitude;


    private double latitude;


    @OneToMany(mappedBy = "winery")
    private List<Rating> rating=new ArrayList<>();

    @OneToMany(mappedBy = "winery")
    private List<Comment> commentList=new ArrayList<>();

    @OneToMany(mappedBy = "winery")
    private List<SpecialOffersWineries> specialOffersWineries=new ArrayList<>();

    @OneToMany(mappedBy = "winery")
    private List<Reservation> reservations=new ArrayList<>();

    @OneToMany(mappedBy = "winery",fetch = FetchType.LAZY)
    private List<ImageModel> images = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmenity() {
        return amenity;
    }

    public void setAmenity(String amenity) {
        this.amenity = amenity;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getInternational_name() {
        return international_name;
    }

    public void setInternational_name(String international_name) {
        this.international_name = international_name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public List<Rating> getRating() {
        return rating;
    }

    public void setRating(List<Rating> rating) {
        this.rating = rating;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void addComment(Comment comment) {
      this.commentList.add(comment);
    }

    public void addRating(Rating rating) {
        this.rating.add(rating);
    }

    public List<SpecialOffersWineries> getSpecialOffersWineries() {
        return specialOffersWineries;
    }

    public void setSpecialOffersWineries(SpecialOffersWineries specialOffersWineries) {
        this.specialOffersWineries.add(specialOffersWineries);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Reservation reservations) {
        this.reservations.add(reservations);
    }

    public List<ImageModel> getImages() {
        return images;
    }

    public void setImages(List<ImageModel> images) {
        this.images = images;
    }
}



