package com.dquiz.controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dquiz.models.Options;
import com.dquiz.models.Question;
import com.dquiz.models.Quiz;
import com.dquiz.models.QuizAttempt;
import com.dquiz.models.User;
import com.dquiz.quizservices.QuestionService;
import com.dquiz.quizservices.QuizAttemptService;
import com.dquiz.quizservices.QuizService;
import com.dquiz.quizservices.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/quizess")
public class QuizController {
	
	@Autowired
	private QuizAttemptService qas;
	@Autowired
	private UserService us;
	@Autowired
	private QuizService qs;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private Options options;
    
    @GetMapping({"/", "/home"})
    public String homePage(Model model, HttpSession session) {
    	List<QuizAttempt> leaderboard = qas.getAllAttempt();
    	Collections.sort(leaderboard, Comparator.comparingInt(QuizAttempt::getScore).reversed());
//        model.addAttribute("leaderboard", leaderboard);
        session.setAttribute("leaderboard", leaderboard);
        return "index"; 
    }
    
//    @GetMapping("/index")
//    public String index(Model model) {
//        if (!model.containsAttribute("leaderboard")) {
//        	List<QuizAttempt> leaderboard = qas.getAllAttempt();
//        	Collections.sort(leaderboard, Comparator.comparingInt(QuizAttempt::getScore).reversed());
//            model.addAttribute("leaderboard", leaderboard);
//        }
//        return "index";
//    }

    
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
   
    
    @GetMapping("/leaderboard")
    public String leaderboard(Model model, HttpSession session)
    {
    	List<QuizAttempt> leaderboard = qas.getAllAttempt();
    	Collections.sort(leaderboard, Comparator.comparingInt(QuizAttempt::getScore).reversed());
//        model.addAttribute("leaderboard", leaderboard);
        session.setAttribute("leaderboard", leaderboard);
        return "leaderboard";
     }
    
    @GetMapping("/history")
    public String getHistory(HttpSession session)
    {
    	User user = (User)session.getAttribute("user");
    	List<QuizAttempt> history = qas.getAttemptHistory(user.getUserid());
    	
    	session.setAttribute("history", history);
    	return "history";
    }
    
    @GetMapping("/startquiz")
    public String startQuiz()
    {
    	return "startquizpage";
    }
    
    @GetMapping("/quizpage")
    public String quizPage(HttpServletRequest req, HttpSession session)
    {
    	String category = (String)req.getParameter("category");
    	Quiz quiz = qs.getQuizId(category);
    	List<Question> questions = questionService.getQuestions(quiz.getQuizid());
    	
    	session.setAttribute("quiz", quiz);
    	session.setAttribute("questions", questions);
    	return "questions";	
    }
    
    @GetMapping("/submit-quiz")
    public String calculateScore(@RequestParam Map<String, String> userAnswer, HttpSession session)
    {
    	int score = questionService.calculateScore(userAnswer);
    	User user = us.findById(((User) session.getAttribute("user")).getUserid());
        Quiz quiz = qs.findById(((Quiz) session.getAttribute("quiz")).getQuizid());
    	session.setAttribute("score", score);
    	QuizAttempt quizAttempt = new QuizAttempt(user, quiz, score);
    	qas.addAttempt(quizAttempt);

    	return "scorepage";	
    }
    
}

