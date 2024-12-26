package com.example.gplx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gplx.entities.TrafficSigns;
import com.example.gplx.service.TrafficSignsService;

@RestController
@RequestMapping("/traffic_signs")
public class TrafficSignsController {
	
	@Autowired
	private TrafficSignsService service;

	@GetMapping()
	private List<TrafficSigns> findAll(){
		return service.findAll();
	}
	
}
