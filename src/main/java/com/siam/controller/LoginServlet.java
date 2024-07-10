

package com.siam.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.siam.dao.*;
import com.siam.model.User;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDAO.authenticateUser(username, password);

        if (user != null) {
            // Successful login
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getUsername());

            response.sendRedirect("welcome.jsp");
        } else {
            // Failed login
            String errorMessage = URLEncoder.encode("Invalid username or password", StandardCharsets.UTF_8.toString());
            response.sendRedirect("login.jsp?error=" + errorMessage);
        }
    }
}
