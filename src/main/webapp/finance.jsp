<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Finance Overview</title>
</head>
<body>
    <h2>Finance Overview</h2>
    <p>Balance: <%= request.getAttribute("balance") %></p>
    
    <h3>Spending by Category:</h3>
    <ul>
        <%
            Map<String, Double> spendingByCategory = (Map<String, Double>) request.getAttribute("spendingByCategory");
            for (Map.Entry<String, Double> entry : spendingByCategory.entrySet()) {
        %>
            <li><%= entry.getKey() %>: <%= entry.getValue() %></li>
        <%
            }
        %>
    </ul>
    
    <h3>Spending by Year:</h3>
    <ul>
        <%
            Map<String, Double> spendingByYear = (Map<String, Double>) request.getAttribute("spendingByYear");
            for (Map.Entry<String, Double> entry : spendingByYear.entrySet()) {
        %>
            <li><%= entry.getKey() %>: <%= entry.getValue() %></li>
        <%
            }
        %>
    </ul>
    
    <h3>Spending by Month:</h3>
    <ul>
        <%
            Map<String, Double> spendingByMonth = (Map<String, Double>) request.getAttribute("spendingByMonth");
            for (Map.Entry<String, Double> entry : spendingByMonth.entrySet()) {
        %>
            <li><%= entry.getKey() %>: <%= entry.getValue() %></li>
        <%
            }
        %>
    </ul>
    
    <h3>Spending by Day:</h3>
    <ul>
        <%
            Map<String, Double> spendingByDay = (Map<String, Double>) request.getAttribute("spendingByDay");
            for (Map.Entry<String, Double> entry : spendingByDay.entrySet()) {
        %>
            <li><%= entry.getKey() %>: <%= entry.getValue() %></li>
        <%
            }
        %>
    </ul>
</body>
</html>
