package com.siam.controller;

import com.siam.dao.TransactionDAO;
import com.siam.dao.TransactionDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteTransaction")
public class DeleteTransactionServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int transactionId = Integer.parseInt(request.getParameter("id"));
            TransactionDAO transactionDAO = new TransactionDAOImpl();
            transactionDAO.deleteTransaction(transactionId);
            response.sendRedirect("history.jsp");
        } catch (NumberFormatException e) {
            response.sendRedirect("history.jsp?error=InvalidTransactionId");
        }
    }
}
