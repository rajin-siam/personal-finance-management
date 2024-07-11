<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.siam.dao.TransactionDAO" %>
<%@ page import="com.siam.dao.TransactionDAOImpl" %>
<%@ page import="com.siam.model.Transaction" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="com.siam.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    // Retrieve user ID from session
    HttpSession ses = request.getSession(false);
    User user = (User) ses.getAttribute("user"); // Use the correct attribute name here
    int userId = user.getId();
    System.out.println(user.getUsername());

    // Initialize DAO and retrieve transactions
    TransactionDAO transactionDAO = new TransactionDAOImpl();
    List<Transaction> transactions = transactionDAO.getUserTransactions(userId);
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction History</title>
<style>
    table {
        width: 100%;
        border-collapse: collapse;
    }
    th, td {
        border: 1px solid black;
        padding: 8px;
        text-align: left;
    }
</style>
</head>
<body>
    <h2>Transaction History</h2>
    <table>
        <tr>
            <th>Transaction ID</th>
            <th>User ID</th>
            <th>Amount</th>
            <th>Date</th>
            <th>Category</th>
            <th>Quantity</th>
            <th>Description</th>
            <th colspan = 2>Action</th>
        </tr>
        <% for (Transaction transaction : transactions) { %>
        <tr>
            <td><%= transaction.getTransactionId() %></td>
            <td><%= transaction.getUserId() %></td>
            <td><%= transaction.getAmount() %></td>
            <td><%= dateFormat.format(transaction.getDate()) %></td>
            <td><%= transaction.getCategory() %></td>
            <td><%= transaction.getQuantity() %></td>
            <td><%= transaction.getDescription() %></td>
            <td>
            <a href="editTransaction.jsp?id=<%= transaction.getTransactionId()%>">Edit</a></td>
            <td>
            <a href="deleteTransaction?id=<%=transaction.getTransactionId()%>" onclick="return confirm('Are you sure you want to delete this transaction?');">Delete</a></td>
        </tr>
        <% } %>
    </table>
    <br>
    <br>
    <a href="welcome.jsp">Back to Menu Page</a></td>
</body>
</html>