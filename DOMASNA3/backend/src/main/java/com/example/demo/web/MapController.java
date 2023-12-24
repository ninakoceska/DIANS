package com.example.demo.web;

import com.example.demo.model.UserLocation;
import com.example.demo.model.Winery;
import com.example.demo.model.response.MapResponse;
import com.example.demo.service.WineryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/map")
public class MapController {

    private final WineryService wineryService;

    public MapController(WineryService wineryService) {
        this.wineryService = wineryService;
    }

    @PostMapping
    @RequestMapping("/user-location")
    public ResponseEntity<MapResponse> getCloseWineriesLocations(@RequestBody UserLocation userLocation){
        MapResponse mapResponse = new MapResponse(wineryService.findAll(),userLocation);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

}
