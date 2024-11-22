<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "navbar.jsp" %>
<%@ page import="com.dquiz.models.Question, java.util.List, com.dquiz.models.Options" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Questions</title>
    <link rel="stylesheet" href="/css/l.css">
</head>
<body>
    <strong>Questions:</strong>
    <form action="/quizess/submit-quiz" method="Get">
        <%! int number = 1; %>
        <% 
            List<Question> questions = (List<Question>) session.getAttribute("questions");
            number = 1;
            for (Question question : questions) { 
        %>
            <p><%= number++ %>. <%= question.getContext() %></p>
            <% 
                String questionName = "question_" + question.getQuestionid(); 
                for (Options op : question.getOptions()) { 
            %>
                <label>
                    <input type="radio" name="<%= questionName %>" value="<%= op.getOptionCode() %>">
                    <%= op.getOptionText() %>
                </label><br>
            <% } %>
        <% } %>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
