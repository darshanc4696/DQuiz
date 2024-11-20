<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dquiz.models.QuizAttempt, java.util.List" %>  
<%@ include file="navbar.jsp" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DQuiz - History</title>
    <link rel="stylesheet" href="/css/history.css">
</head>
<body>
<h1>Your History</h1>
<%  List<QuizAttempt> history = (List<QuizAttempt>)session.getAttribute("history");

	if(history.isEmpty() == true)
	{%>
		<p>No quiz attempts yet &#128532;</p>
	<%}
	else
	{%>
	
		<table>
			<thead>
				<tr>
					<th>Attempt-Id</th>
					<th>Date</th>
					<th>Category</th>
					<th>Score</th>
				</tr>
			</thead>
			<tbody>
				<%for(QuizAttempt qa : history)
				  {%>
				   <tr>
				   		<td><%= qa.getAttemptid() %></td>
						<td><%= qa.getAttemptDate() %></td>
						<td><%= qa.getQuiz().getTitle() %></td>
						<td><%= qa.getScore() %></td>
				   </tr>		
				<%}%>
			</tbody>
		</table>

	<%}%>

</body>
</html>