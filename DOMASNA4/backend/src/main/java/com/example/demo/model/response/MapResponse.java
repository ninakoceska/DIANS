package com.example.demo.model.response;

import com.example.demo.model.UserLocation;
import com.example.demo.model.Winery;
import com.example.demo.repository.WineryRepository;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Data
public class MapResponse {



    private  UserLocation userLocation;
    private List<Winery> wineriesAll;

    private String message;



    public MapResponse(List<Winery> wineriesAll,UserLocation userLocation) {
        this.userLocation = userLocation;
        this.wineriesAll = wineriesAll;
    }

    public List<Winery> getCloseWineries(double distance) {
        return wineriesAll.stream()
                .filter(winery -> calculateDistance(winery, userLocation) <= distance)
                .collect(Collectors.toList());
    }

    public  double calculateDistance(Winery winery, UserLocation userLocation) {
        // Radius of the Earth in kilometers
        double lat1 = winery.getLatitude();
        double lon1 = winery.getLongitude();
        double lat2 = userLocation.getLatitude();
        double lon2 = userLocation.getLongitude();
        double earthRadius = 6371;

        // Calculate the difference in latitude and longitude
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // Haversine formula
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Distance in kilometers
        double distance = earthRadius * c;

        return distance;
    }



}
