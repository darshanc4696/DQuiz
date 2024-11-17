package com.dquiz.quizservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dquiz.models.QuizAttempt;
import com.dquiz.quizrepo.QuizAttemptRepo;

@Service
public class QuizAttemptService {
	
	@Autowired
	private QuizAttemptRepo quizAttRepo;
	
	public List<QuizAttempt> getAllAttempt()
	{
		return (List<QuizAttempt>)quizAttRepo.findAll();
	}

}
