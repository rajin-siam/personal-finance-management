package com.siam.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.siam.dao.UserDAO;
import com.siam.model.User;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO(); // Initialize UserDAO
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate input (you can add more validations as per your requirements)
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            // Handle invalid input error
            response.sendRedirect("signup.jsp?error=Please%20fill%20all%20fields");
            return;
        }

        // Check if username already exists
        if (userDAO.getUserByUsername(username) != null) {
            // Username already exists, handle error or redirect back to signup page
            response.sendRedirect("signup.jsp?error=Username%20already%20exists");
            return;
        }

        // Create new User object
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);

        // Insert new user into database
        userDAO.addUser(newUser);

        HttpSession session = request.getSession();
        session.setAttribute("user", newUser);
        
        // Redirect to login page after successful welcome page
        response.sendRedirect("welcome.jsp");
    }
}
