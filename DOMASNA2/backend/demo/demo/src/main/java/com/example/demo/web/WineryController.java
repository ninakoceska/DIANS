package com.example.demo.web;

import com.example.demo.model.Winery;
import com.example.demo.repository.WineryRepository;
import com.example.demo.service.WineryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping( "/api")
@Validated
@CrossOrigin(origins="http://localhost:4200/")
public class WineryController {

   private final WineryService service;

    public WineryController(WineryService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public Iterable<Winery> list() {
        return service.list();
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




}


