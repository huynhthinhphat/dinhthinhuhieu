package com.example.gplx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.gplx.entities.CauHoi;

@Repository
public interface CauHoiRepository extends JpaRepository<CauHoi, Integer>{
}
