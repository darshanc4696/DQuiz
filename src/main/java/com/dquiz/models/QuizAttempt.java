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
@Table(name = "quizattempt")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizAttempt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int attemptid;
	private int userid;
	private int quizid;
	private int score;
	private String attemptDate;
	
	public QuizAttempt() {
		super();
	}

	public QuizAttempt(int attemptid, int userid, int quizid, int score, String attemptDate) {
		super();
		this.attemptid = attemptid;
		this.userid = userid;
		this.quizid = quizid;
		this.score = score;
		this.attemptDate = attemptDate;
	}

	public QuizAttempt(int userid, int quizid, int score, String attemptDate) {
		super();
		this.userid = userid;
		this.quizid = quizid;
		this.score = score;
		this.attemptDate = attemptDate;
	}

	public int getAttemptid() {
		return attemptid;
	}

	public void setAttemptid(int attemptid) {
		this.attemptid = attemptid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getQuizid() {
		return quizid;
	}

	public void setQuizid(int quizid) {
		this.quizid = quizid;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getAttemptDate() {
		return attemptDate;
	}

	public void setAttemptDate(String attemptDate) {
		this.attemptDate = attemptDate;
	}
}
