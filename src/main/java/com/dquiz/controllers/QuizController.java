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
    public String homePage(Model model) {
    	List<QuizAttempt> leaderboard = qas.getAllAttempt();
    	for(QuizAttempt qa : leaderboard)
    	{
    		System.out.println(qa);
    	}
    	
    	System.err.println(leaderboard);
        model.addAttribute("leaderboard", leaderboard);
        return "index"; 
    }
    
    @GetMapping("/login")
    public String getMethodName() {
        return "login";
    }
    
    @GetMapping("/leaderboard")
    public String leaderboard(Model model)
    {
    	List<QuizAttempt> leaderboard = qas.getAllAttempt();
    	for(QuizAttempt qa : leaderboard)
    	{
    		System.out.println(qa);
    	}
    	
    	System.err.println(leaderboard);
        model.addAttribute("leaderboard", leaderboard);
        return "leaderboard";
     }
    
}

