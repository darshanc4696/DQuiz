package com.dquiz.controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dquiz.models.QuizAttempt;
import com.dquiz.models.User;
import com.dquiz.quizservices.QuizAttemptService;
import com.dquiz.quizservices.UserService;

@Controller
@RequestMapping("/auth")
@SessionAttributes("user")
public class AuthController {
    
    @Autowired
    private UserService userService;
    @Autowired
	private QuizAttemptService qas;
    
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) { 
    	userService.saveUser(user);
        return "success";  
    }

    @GetMapping("/login")
    public String login(@RequestParam("email") String email, 
                        @RequestParam("password") String password, 
                        Model model, RedirectAttributes redirectAttributes) {
        
        User user = userService.validateUser(email, password);
        
        if (user.getUserid() != 0) {
            redirectAttributes.addFlashAttribute("user", user);
            List<QuizAttempt> leaderboard = qas.getAllAttempt();
        	Collections.sort(leaderboard, Comparator.comparingInt(QuizAttempt::getScore).reversed());
            redirectAttributes.addFlashAttribute("leaderboard", leaderboard);
        }
        
        return "redirect:/quizess/index"; // Redirect to maintain data after login
    }
  
}

