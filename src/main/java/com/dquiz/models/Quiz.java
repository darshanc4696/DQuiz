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
@Table(name = "quiz")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quizid;
	private String title;
	private String description;
	
	public Quiz() {
		super();
	}

	public Quiz(int quizid, String title, String description) {
		super();
		this.quizid = quizid;
		this.title = title;
		this.description = description;
	}

	public Quiz(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public int getQuizid() {
		return quizid;
	}

	public void setQuizid(int quizid) {
		this.quizid = quizid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
