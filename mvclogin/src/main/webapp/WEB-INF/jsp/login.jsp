<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<h2>Enter Login Details</h2>
<form action = "/logged_in" method = "post">
User ID = <input type = "text" name = "userID"><br>
Password = <input type = "text" name = "password"><br>
<input type = "submit" name = "Login">
</form>
</body>
</html>