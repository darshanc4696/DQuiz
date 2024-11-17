package com.dquiz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/quizess")
public class QuizController {
    
    @GetMapping({"/", "/home"})
    public String homePage() {
        return "index";  // This should look for home.jsp in the /views/ folder
    }
    
    @GetMapping("/login")
    public String getMethodName() {
        return "login";
    }
    
    @GetMapping("/givequiz")
    public void give()
    {
    	System.out.println("inside give");
    }
    
}

