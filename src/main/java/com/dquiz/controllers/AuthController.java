package com.dquiz.controllers;

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

import com.dquiz.models.User;
import com.dquiz.quizservices.QuizAttemptService;
import com.dquiz.quizservices.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
@SessionAttributes("leaderboard")
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
                        Model model, RedirectAttributes redirectAttributes, HttpSession
                        session) {
        
        User user = userService.validateUser(email, password);
        
        if (user.getUserid() != 0) {
//            redirectAttributes.addFlashAttribute("user", user);
//            List<QuizAttempt> leaderboard = qas.getAllAttempt();
//        	Collections.sort(leaderboard, Comparator.comparingInt(QuizAttempt::getScore).reversed());
//            redirectAttributes.addFlashAttribute("leaderboard", leaderboard);
            session.setAttribute("user", user);
//            session.setAttribute("leader", user);
        }

        
        
        return "index"; // Redirect to maintain data after login
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
    	session.invalidate();
    	return "index";
    }
  
}

