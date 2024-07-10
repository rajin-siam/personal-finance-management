<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ page import="jakarta.servlet.http.HttpSession" %>
<% 




	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);



    HttpSession ses = request.getSession(false);
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("login.jsp"); // Redirect to login page if not logged in
    }
    
    
    
    
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
		welcome ${username}
		<p>Content of your welcome page goes here...</p>
    
    	<p><a href="logout">Logout</a></p> <!-- Link to logout -->
		

</body>
</html>