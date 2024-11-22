package com.dquiz.quizservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dquiz.models.Quiz;
import com.dquiz.quizrepo.QuizRepo;

@Service
public class QuizService {
	
	@Autowired
	private QuizRepo quizRepo;
	
	public String getQuiztitleById(int id)
	{
		return quizRepo.findById(id).orElse(new Quiz()).getTitle();
	}

	public Quiz getQuizId(String category) {
		return quizRepo.findByTitle(category);
		
	}

	public Quiz findById(int quizid) {
		return quizRepo.findById(quizid).orElse(new Quiz());
	}

}
