package com.siam.dao;

import com.siam.model.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.siam.util.DBUtil;

public class TransactionDAOImpl implements TransactionDAO {
    @Override
    public void addTransaction(Transaction transaction) throws SQLException {
        String query = "INSERT INTO transactions (user_id, amount, category, date, quantity, description) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, transaction.getUserId());
            preparedStatement.setDouble(2, transaction.getAmount());
            preparedStatement.setString(3, transaction.getCategory());
            preparedStatement.setDate(4, new java.sql.Date(transaction.getDate().getTime()));
            preparedStatement.setInt(5, transaction.getQuantity());
            preparedStatement.setString(6, transaction.getDescription());
            preparedStatement.executeUpdate();
        }
    }
    
    
    
    public List<Transaction> getUserTransactions(int userId) {
    	 List<Transaction> transactions = new ArrayList<>();
         String query = "SELECT * FROM transactions WHERE user_id = ?";
         Connection connection = DBUtil.getConnection();
         try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             preparedStatement.setInt(1, userId);
             ResultSet rs = preparedStatement.executeQuery();

             while (rs.next()) {
            	 Transaction transaction = new Transaction();
                 transaction.setTransactionId(rs.getInt("id"));
                 transaction.setAmount(rs.getDouble("amount"));
                 transaction.setCategory(rs.getString("category"));
                 transaction.setDate(rs.getDate("date"));
                 transaction.setQuantity(rs.getInt("quantity"));
                 transaction.setDescription(rs.getString("description"));
                 transactions.add(transaction);
             }
         } catch (SQLException e) {
             e.printStackTrace();
             // Handle or log the exception appropriately
         }
         return transactions;
     }
}
