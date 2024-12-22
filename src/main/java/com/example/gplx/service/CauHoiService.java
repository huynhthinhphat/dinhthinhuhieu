package com.example.gplx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gplx.entities.CauHoi;
import com.example.gplx.repository.CauHoiRepository;

@Service
public class CauHoiService {

	@Autowired
	private CauHoiRepository repo;
	
	public List<CauHoi> findAll(){
		return repo.findAll();
	}
}
