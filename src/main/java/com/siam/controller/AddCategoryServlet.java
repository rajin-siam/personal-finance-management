package com.siam.controller;

import com.siam.dao.CategoryDAO;
import com.siam.dao.CategoryDAOImpl;
import com.siam.model.Category;
import com.siam.model.TransactionType;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryDAO categoryDAO;

    public AddCategoryServlet() {
        this.categoryDAO = new CategoryDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String categoryName = request.getParameter("categoryName");
        String transactionTypeString = request.getParameter("transactionType");
        TransactionType transactionType = TransactionType.valueOf(transactionTypeString);

        // Create a new category object
        Category category = new Category(categoryName, transactionType);

        // Add the category to the database
        categoryDAO.addCategory(category);
        String referer = request.getParameter("referer");
        
        String extra = "";
        if(request.getParameter("id") != null)
        {
        	extra = "?" +  "id=" + request.getParameter("id");
        }
        String link = referer + extra;

        // Redirect to a confirmation page or the same form with a success message
        response.sendRedirect(link);
            
    }
}
