<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "navbar.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DQuiz - LeaderBoard</title>
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
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
				            <th>Username</th>
				            <th>Quiz Title</th>
				            <th>Score</th>
				            <th>Attempt Date</th>
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

</body>
</html>