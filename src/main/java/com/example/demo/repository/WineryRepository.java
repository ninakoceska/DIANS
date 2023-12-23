package com.example.demo.repository;

import com.example.demo.model.ImageModel;
import com.example.demo.model.Winery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface WineryRepository extends JpaRepository<Winery,Long> {


    Optional<Winery> findById(Long aLong);


}
