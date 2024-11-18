<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <p>Top scorers of the week:</p>
            <div class="leaderboard-table">
                <!-- Leaderboard content fetched from database -->
                <%! int rank = 1; %>
                 <table>
			        <thead>
			            <tr>
			                <th>Rank</th>
			                <th>Username</th>
			                <th>Category</th>
			                <th>Score</th>
			            </tr>
			        </thead>
			        <tbody>
			            <c:forEach var="attempt" items="${leaderboard}" varStatus="status">
			                <tr>
			                    <td><%= rank++ %></td>
			                    <td>${attempt.user.username}</td>
			                    <td>${attempt.quiz.title}</td>
			                    <td>${attempt.score}</td>

			                </tr>
			            </c:forEach>
			        </tbody>
    			</table>
            </div>
        </div>
    </section>

</body>
</html>