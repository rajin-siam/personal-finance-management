package com.siam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

import com.siam.model.User;
import com.siam.service.FinanceCalculator;

@WebServlet("/finance")
public class FinanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FinanceCalculator financeCalculator;

    public FinanceServlet() {
        this.financeCalculator = new FinanceCalculator();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        if (user == null) {
            // Handle case where user is not found in session (e.g., redirect to login page)
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = user.getId();
        financeCalculator.setUserId(userId);

        double balance = financeCalculator.calculateBalance();
        System.out.println(balance);
        Map<String, Double> spendingByCategory = financeCalculator.calculateSpendingByCategory();
        Map<String, Double> spendingByYear = financeCalculator.calculateSpendingByYear();
        Map<String, Double> spendingByMonth = financeCalculator.calculateSpendingByMonth();
        Map<String, Double> spendingByDay = financeCalculator.calculateSpendingByDay();

        request.setAttribute("balance", balance);
        request.setAttribute("spendingByCategory", spendingByCategory);
        request.setAttribute("spendingByYear", spendingByYear);
        request.setAttribute("spendingByMonth", spendingByMonth);
        request.setAttribute("spendingByDay", spendingByDay);

        request.getRequestDispatcher("finance.jsp").forward(request, response);
    }
}
