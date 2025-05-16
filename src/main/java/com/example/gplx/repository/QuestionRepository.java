package com.example.gplx.repository;

import com.example.gplx.entities.Question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	boolean existsByQuestionText(String questionText);

	List<Question> findByQuestionType(String questionType);

	List<Question> findAllByTopic(int topic);
}
