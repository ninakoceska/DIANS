package com.example.demo.repository;

import com.example.demo.model.SpecialOffersWineries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialOffersWineriesRepository extends JpaRepository<SpecialOffersWineries,Long> {

}
