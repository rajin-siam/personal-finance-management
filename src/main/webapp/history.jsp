<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.siam.model.Transaction" %>
<%@ page import="com.siam.dao.TransactionDAO" %>
<%@ page import="com.siam.dao.TransactionDAOImpl" %>
<%@page import="com.siam.model.User" %>


<%
	User user = (User) session.getAttribute("user");
	int userId = user.getId();
    // Fetch transactions from DAO
    TransactionDAO transactionDAO = new TransactionDAOImpl(); // Assuming your DAO implementation
    List<Transaction> transactions = transactionDAO.getUserTransactions(userId); // Fetch all transactions

    // Format date using DateFormatter class
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
            <th>Amount</th>
            <th>Date</th>
            <th>Category</th>
            <th>Quantity</th>
            <th>Description</th>
        </tr>
        <%System.out.println(transactions.size()); %>
        <% for (Transaction transaction : transactions) { %>
        <tr>
            <td><%= transaction.getTransactionId() %></td>
            <td><%= transaction.getAmount() %></td>
            <td><%= dateFormat.format(transaction.getDate()) %></td>
            <td><%= transaction.getCategory() %></td>
            <td><%= transaction.getQuantity() %></td>
            <td><%= transaction.getDescription() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
