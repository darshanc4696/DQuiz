<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Instructions</title>
    <link rel="stylesheet" href="/css/startquizpage.css">
</head>
<body>
    <div class="containers">
        <h1>Quiz Instructions</h1>
        <div class="instructions">
            <p>Welcome to the quiz! Please read the following instructions carefully:</p>
            <ul>
                <li>Each question has only one correct answer.</li>
                <li>You will have a limited time to complete the quiz.</li>
                <li>Ensure you have a stable internet connection before starting the quiz.</li>
                <li>You can select only one category at a time.</li>
                <li>Your score will be displayed at the end of the quiz.</li>
            </ul>
        </div>
        <form action="/quizess/quizpage" method="GET">
            <label for="category">Select a Quiz Category:</label>
            <select name="category" id="category">
                <option value="Science">Science</option>
                <option value="World">World</option>
                <option value="History">History</option>
                <option value="Tech">Tech</option>
            </select>
            <br>
            <input type="submit" value="Start Quiz">
        </form>
    </div>
</body>
</html>
