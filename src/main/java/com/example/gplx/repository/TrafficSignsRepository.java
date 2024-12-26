package com.example.gplx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gplx.entities.TrafficSigns;

@Repository
public interface TrafficSignsRepository extends JpaRepository<TrafficSigns, Long>{

}
