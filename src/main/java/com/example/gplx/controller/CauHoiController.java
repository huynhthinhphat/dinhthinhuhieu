package com.example.gplx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gplx.entities.CauHoi;
import com.example.gplx.service.CauHoiService;

@RestController
@RequestMapping("/cauhoi")
public class CauHoiController {

	@Autowired
	private CauHoiService service;
	
	@GetMapping()
	private List<CauHoi> findAll(){
		return service.findAll();
	}
}
