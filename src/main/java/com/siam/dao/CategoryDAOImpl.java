package com.siam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.siam.model.Category;
import com.siam.model.TransactionType;
import com.siam.util.DBUtil;

public class CategoryDAOImpl implements CategoryDAO {

    @Override
    public void addCategory(Category category) {
    	String sql = "INSERT INTO categories (categoryName, transactionType) VALUES (?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, category.getCategoryName());
            stmt.setString(2, category.getTransactionType().toString());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories";
        
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryName(resultSet.getString("categoryName"));
                category.setTransactionType(TransactionType.valueOf(resultSet.getString("transactionType")));
                categories.add(category);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return categories;
    }

    // Implement other methods like update, delete, getCategories, etc.
}
