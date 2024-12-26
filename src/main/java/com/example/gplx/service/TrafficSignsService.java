package com.example.gplx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gplx.entities.TrafficSigns;
import com.example.gplx.repository.TrafficSignsRepository;

@Service
public class TrafficSignsService {

	@Autowired
	private TrafficSignsRepository repo;
	
	public List<TrafficSigns> findAll(){
		return repo.findAll();
	}
}
