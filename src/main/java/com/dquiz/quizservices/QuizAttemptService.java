package com.dquiz.quizservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dquiz.quizrepo.QuizAttemptRepo;

@Service
public class QuizAttemptService {
	
	@Autowired
	private QuizAttemptRepo quizAttRepo;

}
