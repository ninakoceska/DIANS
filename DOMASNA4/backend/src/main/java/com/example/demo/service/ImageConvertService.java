package com.example.demo.service;

// ...

import com.example.demo.model.ImageModel;
import com.example.demo.model.ImageModelDTO;
import com.example.demo.repository.ImageRepository;

import java.util.List;


public interface ImageConvertService  {
     List<ImageModelDTO> getImageModelsForWinery(Long wineryId);

     ImageModelDTO convertToDTO(ImageModel imageModel);
}
