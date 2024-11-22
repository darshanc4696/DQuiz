package com.dquiz.quizservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dquiz.models.QuizAttempt;
import com.dquiz.quizrepo.QuizAttemptRepo;
import com.dquiz.quizrepo.QuizRepo;

@Service
public class QuizAttemptService {
	
	@Autowired
	private QuizAttemptRepo quizAttRepo;
	
	public List<QuizAttempt> getAllAttempt()
	{
		return quizAttRepo.findAll();
	}

	public List<QuizAttempt> getAttemptHistory(int userid) {
		
		return quizAttRepo.findByUserId(userid);
		
	}

	public void addAttempt(QuizAttempt quizAttempt) {
		quizAttRepo.save(quizAttempt);
		
	}
	
	

}
