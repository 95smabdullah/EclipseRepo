<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Employee</title>
</head>
<body>
    <h1>Add Employee</h1>
    <form action="/addEmployee" method="post">
        <!-- Input fields for employee information -->
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" required><br>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="salary">Salary:</label>
        <input type="text" id="salary" name="salary" required><br>

        <input type="submit" value="Add Employee">
    </form>

    <!-- Display success message if available -->
    <div>
        <p>${successMessage}</p>
    </div>
</body>
</html>
