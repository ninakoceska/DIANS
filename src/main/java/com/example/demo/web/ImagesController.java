package com.example.demo.web;

import com.example.demo.model.ImageModel;
import com.example.demo.repository.ImageRepository;
import com.example.demo.service.WineryService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/image-upload")
public class ImagesController {

   private final ImageRepository imageRepository;

    private final WineryService wineryService;


    public ImagesController(ImageRepository imageRepository, WineryService wineryService) {
        this.imageRepository = imageRepository;
        this.wineryService = wineryService;
    }

    @PostMapping("/upload")
    public ImageModel uploadImage(@RequestParam("myFile") MultipartFile file) throws IOException {

        ImageModel img = new ImageModel(file.getOriginalFilename(),file.getContentType(),file.getBytes());
        final ImageModel savedImage = imageRepository.save(img);
        System.out.println("Image saved");
        return savedImage;

    }

    @GetMapping("/image/{id}")
    public ImageModel getImage(@PathVariable Long id) {

        ImageModel img  = wineryService.findWineryById(id).getImages().get(1);
        return img;
    }
}