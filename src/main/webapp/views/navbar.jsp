<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DQuiz</title>
    <link rel="stylesheet" href="/css/navbar.css">
</head>
<body>
	    <!-- Navbar -->
    <header class="navbar">
        <div class="container">
            <div class="logo">DQuiz</div>
            <nav>
                <ul>
                    <li><a href="/quizess/home">Home</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="/quizess/leaderboard">Leaderboard</a></li>
					<c:choose>
					    <c:when test="${user != null}">
					        <li><a href="/quizess/login" class="signin">Logout</a></li>
					    </c:when>
					    <c:otherwise>
					        <li><a href="/quizess/login" class="signin">Sign In/ Sign Up</a></li>
					    </c:otherwise>
					</c:choose>
                </ul>
            </nav>
        </div>
    </header>
</body>
</html>