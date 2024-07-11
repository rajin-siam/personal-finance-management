package com.siam.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.siam.dao.TransactionDAO;
import com.siam.dao.TransactionDAOImpl;
import com.siam.model.Transaction;
import com.siam.model.User;

@WebServlet("/transaction")
public class TransactionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TransactionDAO transactionDAO;

    public void init() {
        transactionDAO = new TransactionDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        double amount = Double.parseDouble(request.getParameter("amount"));
        String category = request.getParameter("category");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");

        // Parse the date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(request.getParameter("date"));
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("transaction.jsp?error=Invalid date format");
            return;
        }

        Transaction transaction = new Transaction();
        transaction.setUserId(user.getId());
        transaction.setAmount(amount);
        transaction.setCategory(category);
        transaction.setDate(date);
        transaction.setQuantity(quantity);
        transaction.setDescription(description);

        try {
            transactionDAO.addTransaction(transaction);
            response.sendRedirect("welcome.jsp?success=Transaction added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("transaction.jsp?error=Error adding transaction");
        }
    }
}
