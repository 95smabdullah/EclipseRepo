<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/books/update" method = "post">
<input type="hidden" name="id" value="${book.id}">
<label>Name: <input type = "text" name = "name"></label>
<label>Price: <input type = "number" name = "price" step = "any"></label>
<input type = "submit" value = "Update">
</form>
</body>
</html>