<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp" %>
<%@ page import="com.dquiz.models.Question, java.util.List, com.dquiz.models.Options" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Questions</title>
    <link rel="stylesheet" href="/css/questions.css">
</head>
<body>
    <div class="containers">
        <h1>Quiz Questions</h1>
        <form action="/quizess/submit-quiz" method="GET" class="quiz-form">
            <% 
                List<Question> questions = (List<Question>) session.getAttribute("questions");
                int number = 1;
                for (Question question : questions) { 
            %>
            <div class="question">
                <p class="question-text"><%= number++ %>. <%= question.getContext() %></p>
                <div class="options">
                    <% 
                        String questionName = "question_" + question.getQuestionid(); 
                        for (Options op : question.getOptions()) { 
                    %>
                    <label class="option-label">
                        <input type="radio" name="<%= questionName %>" value="<%= op.getOptionCode() %>" required>
                        <%= op.getOptionText() %>
                    </label>
                    <% } %>
                </div>
            </div>
            <% } %>
            <button type="submit" class="submit-btn">Submit Quiz</button>
        </form>
    </div>
</body>
</html>
