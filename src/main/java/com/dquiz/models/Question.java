package com.dquiz.models;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Table(name = "question")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionid;
	private int quizid;
	private String context;
	private String correctAnswer;
	
	public Question() {
		super();
	}

	public Question(int questionid, int quizid, String context, String correctAnswer) {
		super();
		this.questionid = questionid;
		this.quizid = quizid;
		this.context = context;
		this.correctAnswer = correctAnswer;
	}

	public Question(int quizid, String context, String correctAnswer) {
		super();
		this.quizid = quizid;
		this.context = context;
		this.correctAnswer = correctAnswer;
	}

	public Question(String context, String correctAnswer) {
		super();
		this.context = context;
		this.correctAnswer = correctAnswer;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public int getQuizid() {
		return quizid;
	}

	public void setQuizid(int quizid) {
		this.quizid = quizid;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
}
