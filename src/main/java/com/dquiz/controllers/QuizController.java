package com.dquiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dquiz.models.QuizAttempt;
import com.dquiz.quizservices.QuizAttemptService;
import com.dquiz.quizservices.QuizService;
import com.dquiz.quizservices.UserService;


@Controller
@RequestMapping("/quizess")
public class QuizController {
	
	@Autowired
	private QuizAttemptService qas;
	private UserService us;
	private QuizService qs;
    
    @GetMapping({"/", "/home"})
    public String homePage() {
        return "index";  // This should look for home.jsp in the /views/ folder
    }
    
    @GetMapping("/login")
    public String getMethodName() {
        return "login";
    }
    
    @GetMapping("/leaderboard")
    public String leaderboard(Model model)
    {
    	List<QuizAttempt> quizAttempt = qas.getAllAttempt();
    	
    	return "leaderboard";
     }
    
}

