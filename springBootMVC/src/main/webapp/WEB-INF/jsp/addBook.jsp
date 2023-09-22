<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a new book</title>
</head>
<body>
<form action="addBook" method = "post">
<label>Name: <input type = "text" name = "name"></label>
<label>Price: <input type = "number" name = "price" step = "any"></label>
<input type = "submit" value = "Add">
</form>
</body>
</html>