<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Category</title>
    <style>
        form {
            margin: 20px;
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input, select {
            padding: 5px;
            width: 100%;
            max-width: 300px;
        }
        input[type="submit"] {
            margin-top: 20px;
            width: auto;
        }
    </style>
</head>
<body>
    <h2>Add New Category</h2>
    <form action="AddCategoryServlet" method="post">
    
    <% if (request.getParameter("id") != null) { %>
            <input type="hidden" name="id" value="${param.id}">
        <% } %>

    	<input type="hidden" name="referer" value="${param.referer}">
        <label for="categoryName">Category Name:</label>
        <input type="text" id="categoryName" name="categoryName" required>

        <label for="transactionType">Transaction Type:</label>
        <select id="transactionType" name="transactionType" required>
            <option value="INCOMING">Incoming</option>
            <option value="OUTGOING">Outgoing</option>
        </select>

        <input type="submit" value="Add Category">
    </form>
</body>
</html>
