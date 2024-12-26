package com.example.gplx.repository;

import com.example.gplx.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	boolean existsByQuestionText(String questionText);
}
