package com.dquiz.controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dquiz.models.QuizAttempt;
import com.dquiz.quizservices.QuizAttemptService;
import com.dquiz.quizservices.QuizService;
import com.dquiz.quizservices.UserService;


@Controller
@RequestMapping("/quizess")
@SessionAttributes("user")
public class QuizController {
	
	@Autowired
	private QuizAttemptService qas;
	private UserService us;
	private QuizService qs;
    
    @GetMapping({"/", "/home"})
    public String homePage(Model model) {
    	List<QuizAttempt> leaderboard = qas.getAllAttempt();
    	Collections.sort(leaderboard, Comparator.comparingInt(QuizAttempt::getScore).reversed());
        model.addAttribute("leaderboard", leaderboard);
        return "index"; 
    }
    
    @GetMapping("/index")
    public String index(Model model) {
        if (!model.containsAttribute("leaderboard")) {
        	List<QuizAttempt> leaderboard = qas.getAllAttempt();
        	Collections.sort(leaderboard, Comparator.comparingInt(QuizAttempt::getScore).reversed());
            model.addAttribute("leaderboard", leaderboard);
        }
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
    	Collections.sort(leaderboard, Comparator.comparingInt(QuizAttempt::getScore).reversed());
        model.addAttribute("leaderboard", leaderboard);
        return "leaderboard";
     }
    
}

