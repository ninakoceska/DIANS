package com.example.demo.repository;

import com.example.demo.model.Winery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface WineryRepository extends JpaRepository<Winery,Long> {

}
