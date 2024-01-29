package com.example.demo.repository;

import com.example.demo.model.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {

    List<ImageModel> findByWineryId(Long wineryId);

}