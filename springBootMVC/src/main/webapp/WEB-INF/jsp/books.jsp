<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
</head>
<body>
    <h1>Book List</h1>
    <br>
    <a href="<c:url value='/addBook'/>">Add new book</a>
    <br>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>
                    <a href="<c:url value='/books/update/${book.id}'/>">Update</a>
                    <a href="<c:url value='/books/delete/${book.id}'/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>