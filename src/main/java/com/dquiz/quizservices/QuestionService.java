package com.dquiz.quizservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dquiz.quizrepo.QuestionRepo;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;

}
