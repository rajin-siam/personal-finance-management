<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <!-- Include any CSS or JavaScript as needed -->
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h1>Login</h1>
    <form action="login" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <input type="submit" value="Login">
    </form>
    <br>
    <% 
        String errorMessage = request.getParameter("error");
        if (errorMessage != null) {
    %>
        <p style="color:red;"><%= errorMessage %></p>
    <% 
        } 
    %>
</body>
</html>
