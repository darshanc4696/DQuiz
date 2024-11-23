<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quiz Score</title>
    <link rel="stylesheet" type="text/css" href="/css/scorepage.css">
</head>
<body>
    <div class="score-container">
        <h1>Congratulations!</h1>
        <p class="message">You have successfully completed the quiz.</p>
        <div class="score-display">
            <p>Your Score(out of 10):</p>
            <h2>${score}</h2>
        </div>
        <a href="/" class="btn">Back to Quiz Menu</a>
    </div>
</body>
</html>
