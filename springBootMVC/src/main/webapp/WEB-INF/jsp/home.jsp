<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
<h1>Welcome to the home page</h1>
<form action="/login" method = "post">
	<label>Username: <input type = "text" name = "name"></label>
	<label>Password: <input type = "text" name = "pass"></label>
	<input type = "submit" value = "Login">
</form>
<form action="/register" method = "post">
	<label>Username: <input type = "text" name = "name"></label>
	<label>Password: <input type = "text" name = "pass"></label>
	<input type = "submit" value = "Register">
</form>
<p>${meesage}</p>
</body>
</html>