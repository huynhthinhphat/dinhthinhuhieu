package com.example.gplx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gplx.entities.Question;
import com.example.gplx.service.CauHoiService;

@RestController
@RequestMapping("/cauhoi")
public class QuestionController {

	@Autowired
	private CauHoiService service;

	@GetMapping()
	private List<Question> findAll() {
		return service.findAll();
	}

	@GetMapping("{questionType}")
	private List<Question> findByID(@PathVariable("questionType") String questionType) {
		return service.findByType(questionType);
	}

	@GetMapping("topic/{topic}")
	private List<Question> findAllQuestifindAllQuestionByTopic(@PathVariable("topic") int topic) {
		return service.findAllQuestionsByTopic(topic);
	}

}
