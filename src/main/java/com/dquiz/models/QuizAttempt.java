package com.dquiz.models;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
//	private int userid;
//	private int quizid;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quizid", nullable = false)
    private Quiz quiz;
    
	private int score;
	private LocalDate attemptDate;
	

	public QuizAttempt() {
		super();
	}



	public QuizAttempt(int attemptid, User user, Quiz quiz, int score, LocalDate attemptDate) {
		super();
		this.attemptid = attemptid;
		this.user = user;
		this.quiz = quiz;
		this.score = score;
		this.attemptDate = attemptDate;
	}



	public QuizAttempt(User user, Quiz quiz, int score, LocalDate attemptDate) {
		super();
		this.user = user;
		this.quiz = quiz;
		this.score = score;
		this.attemptDate = attemptDate;
	}



	public QuizAttempt(User user, Quiz quiz, int score) {
		super();
		this.user = user;
		this.quiz = quiz;
		this.score = score;
		this.attemptDate = LocalDate.now();
	}



	public int getAttemptid() {
		return attemptid;
	}



	public void setAttemptid(int attemptid) {
		this.attemptid = attemptid;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Quiz getQuiz() {
		return quiz;
	}



	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}



	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}



	public LocalDate getAttemptDate() {
		return attemptDate;
	}



	public void setAttemptDate(LocalDate attemptDate) {
		this.attemptDate = attemptDate;
	}



	@Override
	public String toString() {
		return attemptid + ", " + user.getUsername() + ", " + quiz.getTitle() + ", " + score+ ", " + attemptDate;
	}
	
	
}
