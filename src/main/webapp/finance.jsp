<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Finance Overview</title>
    <link rel="stylesheet" type="text/css" href="css/financeOverview.css">
</head>
<body>
    <div class="finance-container">
        <div class="header">
            <h2>Finance Overview</h2>
        </div>

        <div class="balance-section">
            <p>Balance: <span class="balance-amount"><%= request.getAttribute("balance") %></span></p>
        </div>

        <div class="spending-category-section">
            <h3>Spending by Category:</h3>
            <ul>
                <%
                    Map<String, Double> spendingByCategory = (Map<String, Double>) request.getAttribute("spendingByCategory");
                    for (Map.Entry<String, Double> entry : spendingByCategory.entrySet()) {
                %>
                    <li><%= entry.getKey() %>: <span class="spending-amount"><%= entry.getValue() %></span></li>
                <%
                    }
                %>
            </ul>
        </div>

        <div class="spending-year-section">
            <h3>Spending by Year:</h3>
            <ul>
                <%
                    Map<String, Double> spendingByYear = (Map<String, Double>) request.getAttribute("spendingByYear");
                    for (Map.Entry<String, Double> entry : spendingByYear.entrySet()) {
                %>
                    <li><%= entry.getKey() %>: <span class="spending-amount"><%= entry.getValue() %></span></li>
                <%
                    }
                %>
            </ul>
        </div>

        <div class="spending-month-section">
            <h3>Spending by Month:</h3>
            <ul>
                <%
                    Map<String, Double> spendingByMonth = (Map<String, Double>) request.getAttribute("spendingByMonth");
                    for (Map.Entry<String, Double> entry : spendingByMonth.entrySet()) {
                %>
                    <li><%= entry.getKey() %>: <span class="spending-amount"><%= entry.getValue() %></span></li>
                <%
                    }
                %>
            </ul>
        </div>

        <div class="spending-day-section">
            <h3>Spending by Day:</h3>
            <ul>
                <%
                    Map<String, Double> spendingByDay = (Map<String, Double>) request.getAttribute("spendingByDay");
                    for (Map.Entry<String, Double> entry : spendingByDay.entrySet()) {
                %>
                    <li><%= entry.getKey() %>: <span class="spending-amount"><%= entry.getValue() %></span></li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</body>
</html>
