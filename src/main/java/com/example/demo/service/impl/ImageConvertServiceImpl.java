package com.example.demo.service.impl;

import com.example.demo.model.ImageModel;
import com.example.demo.model.ImageModelDTO;
import com.example.demo.model.Winery;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.WineryRepository;
import com.example.demo.service.ImageConvertService;
import com.example.demo.web.config.ModelMapperConfig;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImageConvertServiceImpl implements ImageConvertService {

    private final WineryRepository wineryRepository;

    private final ImageRepository imageRepository;

    private final ModelMapper modelMapper;

    public ImageConvertServiceImpl(WineryRepository wineryRepository, ImageRepository imageRepository, ModelMapper modelMapper) {
        this.wineryRepository = wineryRepository;
        this.imageRepository = imageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ImageModelDTO> getImageModelsForWinery(Long wineryId) {
        List<ImageModel> imageModels = imageRepository.findByWineryId(wineryId);

        // Convert List<ImageModel> to List<ImageModelDTO>

        return imageModels.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ImageModelDTO convertToDTO(ImageModel imageModel) {
        ImageModelDTO imageModelDTO = modelMapper.map(imageModel, ImageModelDTO.class);
        if (imageModel.getWinery() != null) {
            imageModelDTO.setWineryId(imageModel.getWinery().getId());
        }
        return imageModelDTO;
    }
}

