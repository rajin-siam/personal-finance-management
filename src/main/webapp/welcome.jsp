<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="com.siam.model.User" %>
<% 
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);

    HttpSession ses = request.getSession(false);
    User user = (User) ses.getAttribute("user");
    
    if(user == null)System.out.println("null user");
    //String username = user.getUsername();
    
    if (ses == null || ses.getAttribute("user") == null) {
    	
        response.sendRedirect("login.jsp"); // Redirect to login page if not logged  in
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
    <h2>Welcome, <%= user.getUsername() %></h2>
    <p>Content of your welcome page goes here...</p>
    
    <h3>Options:</h3>
    <ul>
        <li><a href="transaction.jsp">Add Transaction</a></li>
        <li><a href="history.jsp">View Previous Transactions</a></li>
        <li><a href="finance">View Reports</a></li>
        <!-- Add more options as needed -->
    </ul>
    
    <p><a href="logout">Logout</a></p> <!-- Link to logout -->
</body>
</html>
