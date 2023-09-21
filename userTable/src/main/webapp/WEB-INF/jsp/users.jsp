<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>User List</h2>
    <ul>
        <c:forEach items="${users}" var="user">
            <li>${user.name}</li>
        </c:forEach>
    </ul>
    <h2>Add User</h2>
    <form action="/addUser" method="post">
        Name: <input type="text" name="name">
        <input type="submit" value="Add User">
    </form>
</body>
</html>