<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "navbar.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.dquiz.quizservices.QuizAttemptService,com.dquiz.quizservices.UserService, com.dquiz.quizservices.QuizService, com.dquiz.models.QuizAttempt, com.dquiz.models.User, java.util.List" %>

              
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DQuiz - Home</title>
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<!-- 
    Navbar
    <header class="navbar">
        <div class="container">
            <div class="logo">DQuiz</div>
            <nav>
                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">About</a></li>
               <li><a href="#">Categories</a> 
                        <select>
                            <option value="science">Science</option>
                            <option value="math">Math</option>
                            <option value="history">History</option>
                            <option value="tech">Tech</option>
                        </select>
                    </li>
                    <li><a href="#">Leaderboard</a></li>
                    <li><a href="/quizess/login" class="signin">Sign In</a></li>
                    <li><a href="#" class="signup">Sign Up</a></li>
                </ul>
            </nav>
        </div>
    </header> -->

    <!-- Hero Section -->
    <section class="hero">
        <div class="container">
            <h1>Challenge Your Knowledge!</h1>
            <p class="quote">"Learning is a treasure that will follow its owner everywhere."</p>
           <!--  <button class="startbutton">
    			<a href="/quizess/login">Start Quiz</a>
			</button> -->
			<% User user = (User)session.getAttribute("user");
				if(user != null)
				{%>	
   				 <button class="startbutton">
        			<a href="/quizess/login">Start Quiz</a>
    			</button>				
				<%}
			%>

        </div>
    </section>

    <!-- Leaderboard Section -->
    <section class="leaderboard">
        <div class="container">
            <h2>Leaderboard</h2>
            <strong><p style="color: red;">Top scorers of the quiz:</p></strong>
            <div class="leaderboard-table">
                <!-- Leaderboard content fetched from database -->
                <%! int rank = 1; %>
                 <table border="1">
				    <thead>
				        <tr>
				        	<th>Rank</th>
				            <th>Username</th>
				            <th>Quiz Title</th>
				            <th>Score</th>
				        </tr>
				    </thead>
				    <tbody>
                        <c:set var="rank" value="1" />
                        <c:forEach var="attempt" items="${leaderboard}">
                            <tr>
                                <td>${rank}</td> <!-- Display rank -->
                                <td>${attempt.user.username}</td>  <!-- Access username from User object -->
                                <td>${attempt.quiz.title}</td>     <!-- Access quiz title from Quiz object -->
                                <td>${attempt.score}</td>          <!-- Direct field of QuizAttempt -->
                            </tr>
                            <c:set var="rank" value="${rank + 1}" /> <!-- Increment rank for each row -->
                        </c:forEach>
                    </tbody>
				</table>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer class="footer">
        <div class="container">
            <p>&copy; 2024 DQuiz. All Rights Reserved.</p>
            <nav>
                <ul>
                    <li><a href="#">Privacy Policy</a></li>
                    <li><a href="#">Terms of Service</a></li>
                    <li><a href="#">Contact Us</a></li>
                </ul>
            </nav>
        </div>
    </footer>

</body>
</html>
