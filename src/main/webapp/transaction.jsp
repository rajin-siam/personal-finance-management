<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Transaction</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <h2>Add Transaction</h2>
    <form action="transaction" method="post">
        <label for="amount">Money Amount:</label><br>
        <input type="text" id="amount" name="amount" required><br><br>

        <label for="category">Category:</label><br>
        <input type="text" id="category" name="category" required><br><br>

        <label for="date">Date:</label><br>
        <input type="date" id="date" name="date" value="<fmt:formatDate value="${now}" pattern="yyyy-MM-dd"/>" required><br><br>

        <label for="quantity">Quantity:</label><br>
        <input type="text" id="quantity" name="quantity" required><br><br>

        <label for="description">Description:</label><br>
        <textarea id="description" name="description" rows="4" cols="50"></textarea><br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
