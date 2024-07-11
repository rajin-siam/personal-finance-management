<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.siam.dao.TransactionDAO" %>
<%@ page import="com.siam.dao.TransactionDAOImpl" %>
<%@ page import="com.siam.model.Transaction" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>

<%
    // Retrieve transaction ID from request parameter
    int transactionId = Integer.parseInt(request.getParameter("id"));
	System.out.println(transactionId);
    // Initialize DAO and retrieve transaction details
    TransactionDAO transactionDAO = new TransactionDAOImpl();
    Transaction transaction = transactionDAO.getTransactionById(transactionId);
	System.out.println(transaction.getAmount());
    // Check if transaction exists
    if (transaction == null) {
        response.sendRedirect("history.jsp"); // Redirect if transaction not found
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Transaction</title>
    <!-- Include any necessary CSS -->
</head>
<body>
    <h2>Edit Transaction</h2>
    <form action="updateTransaction" method="post">
        <input type="hidden" name="transactionId" value="<%= transaction.getTransactionId() %>">
        <label for="amount">Amount:</label>
        <input type="text" id="amount" name="amount" value="<%= transaction.getAmount() %>"><br><br>
        
        <label for="date">Date:</label>
        <input type="date" id="date" name="date" value="<%= new SimpleDateFormat("yyyy-MM-dd").format(transaction.getDate()) %>"><br><br>
        
        <label for="category">Category:</label>
        <input type="text" id="category" name="category" value="<%= transaction.getCategory() %>"><br><br>
        
        <label for="quantity">Quantity:</label>
        <input type="text" id="quantity" name="quantity" value="<%= transaction.getQuantity() %>"><br><br>
        
        <label for="description">Description:</label><br>
        <textarea id="description" name="description"><%= transaction.getDescription() %></textarea><br><br>
        
        <input type="submit" value="Update Transaction">
    </form>
</body>
</html>
