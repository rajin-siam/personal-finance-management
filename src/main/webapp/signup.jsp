<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <link rel="stylesheet" type="text/css" href="css/loginsignup.css">
</head>
<body>
    <div class="container">
        <div class="title">
            <h1>Sign Up</h1>
        </div>

        <form method="post" action="signup">
            <div class="form-group">
                <label for="username">Enter Username</label><br>
                <input type="text" name="username" id="username" 
                    placeholder="Username" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="password">Enter Password</label><br>
                <input type="password" name="password" id="password" 
                    placeholder="Password" class="form-control" required>
            </div>
            <div class="form-group">
                <button type="submit" class="btn">Sign Up</button>
            </div>
        </form>
        
        <% 
            String errorMessage = request.getParameter("error");
            if (errorMessage != null && !errorMessage.isEmpty()) {
        %>
            <p style="color: red;"><%= errorMessage %></p>
        <% 
            }
        %>
    </div>
</body>
</html>
