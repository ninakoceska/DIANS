package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Entity
@Table(name = "[Winery]")
@NoArgsConstructor
@AllArgsConstructor

public class Winery implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;


    private String amenity;


    private String shop;


    private String international_name;

    private double longitude;


    private double latitude;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAmenity() {
        return amenity;
    }

    public String getShop() {
        return shop;
    }

    public String getInternational_name() {
        return international_name;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
