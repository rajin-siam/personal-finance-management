<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Category</title>
    <style>
        body{
            background-image: url('css/static/addCategory.jpg');
            background-repeat: no-repeat;
            background-size: cover;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
        h1{
            text-align: center;
            color: rgb(71, 51, 253);
            font-size: 50px;
        }
        form {
            border-radius: 10px;
            color: rgb(58, 236, 118);
            margin: 20px;
            font-size:27px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            width: 70%;
            backdrop-filter: blur(8px);
            border: 1px solid rgba(255, 255, 255, 0.5);
            -webkit-backdrop-filter: blur(8px);
            height: 50vh;
        }


        label {
            display: block;
            margin: 10px 0 5px;
        }
        input{
            height: 50px;
            border-radius: 10px;
            font-size: large;
            color: rgb(3, 3, 31);
        }
        input, select {
            padding: 5px;
            width: 100%;
            max-width: 300px;
            height: 50px;
            border-radius: 10px;
        }
        input[type="submit"] {
            margin-top: 20px;
            width: auto;

        }
    </style>
</head>
<body>
<h1>Add New Category</h1>
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

    <input  type="submit" value="Add Category">
</form>
</body>
</html>
