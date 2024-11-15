<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello, Welcome :) Darshan!</h1>
	
	<form action="/auth/register" method="post">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name = "username"></td>
			</tr>
			
			<tr>
				<td>email</td>
				<td><input type="email" name = "email"></td>
			</tr>
			
			<tr>
				<td>password</td>
				<td><input type="password" name = "password"></td>
			</tr>
			
			<tr>
				<td>role</td>
				<td><input type="text" name = "role"></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value = "Register"></td>
			</tr>
	
		</table>
	</form>
</body>
</html>