package com.siam.controller;

import java.io.IOException;
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

@WebServlet("/updateTransaction")
public class UpdateTransactionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TransactionDAO transactionDAO;

    public void init() {
        transactionDAO = new TransactionDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int transactionId = Integer.parseInt(request.getParameter("transactionId"));
        HttpSession ses = request.getSession(false);
        User user = (User) ses.getAttribute("user");
        int user_id = user.getId();
        double amount = Double.parseDouble(request.getParameter("amount"));
        String category = request.getParameter("category");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Transaction transaction = new Transaction();
        
        transaction.setTransactionId(transactionId);
        transaction.setUserId(user_id);
        transaction.setAmount(amount);
        transaction.setDate(date);
        transaction.setCategory(category);
        transaction.setQuantity(quantity);
        transaction.setDescription(description);
        
        
        transactionDAO.updateTransaction(transaction);

        response.sendRedirect("history.jsp");
    }
}
