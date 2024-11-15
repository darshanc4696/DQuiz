package com.dquiz.quizservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dquiz.quizrepo.OptionRepo;

@Service
public class OptionService {
	
	@Autowired
	private OptionRepo optionRepo;

}
