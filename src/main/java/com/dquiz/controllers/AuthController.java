package com.dquiz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dquiz.models.User;
import com.dquiz.quizservices.UserService;

@Controller
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) { 
    	userService.saveUser(user);
        return "success";  
    }

    @GetMapping("/login")
    public void login(@RequestParam("email") String email, @RequestParam("password") String password) {
        
    	String vu = userService.validateUser(email, password);
    	
    	System.out.println(vu);
    	
    	
    }   
}

