package com.example.gplx.entities;

import jakarta.persistence.*;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition = "VARCHAR(5000)")
	private String questionText; // Nội dung câu hỏi
	@Column(columnDefinition = "VARCHAR(5000)")
	private String option1; // Lựa chọn 1
	@Column(columnDefinition = "VARCHAR(5000)")
	private String option2; // Lựa chọn 2
	@Column(columnDefinition = "VARCHAR(5000)")
	private String option3; // Lựa chọn 3
	@Column(columnDefinition = "VARCHAR(5000)")
	private String option4; // Lựa chọn 4
	@Column(columnDefinition = "VARCHAR(5000)")
	private String correctAnswer; // Lựa chọn đúng (1, 2, 3, hoặc 4)
	private String questionType; // Loại câu hỏi
	@Column(columnDefinition = "VARCHAR(5000)")
	private String explanation; // Giải thích
	private String imageUrl;
	private int topic;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public void setTopic(int topic) {
		this.topic = topic;
	}

	public int getTopic() {
		return this.topic;
	}
}
