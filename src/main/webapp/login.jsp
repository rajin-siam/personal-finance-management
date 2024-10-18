<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <!-- Include any CSS or JavaScript as needed -->
    <link rel="stylesheet" type="text/css" href="css/signup.css">
</head>
<body>
    <div class="container">
        <div class="title">
            <h1>Login</h1>
        </div>

        <form action="login" method="post">
            <div class="form-group">
                <label for="username">Enter Username</label><br>
                <input type="text" id="username" name="username" 
                       placeholder="Username" class="form-control" required><br><br>
            </div>

            <div class="form-group">
                <label for="password">Enter Password</label><br>
                <input type="password" id="password" name="password" 
                       placeholder="Password" class="form-control" required><br><br>
            </div>

            <div class="form-group">
                <button type="submit" class="btn">Login</button>
            </div>
        </form>

        <br>
        <% 
            String errorMessage = request.getParameter("error");
            if (errorMessage != null && !errorMessage.isEmpty()) {
        %>
            <p style="color:red;"><%= errorMessage %></p>
        <% 
            } 
        %>
    </div>
</body>
</html>
