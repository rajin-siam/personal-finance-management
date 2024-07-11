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
                 transaction.setUserId(userId);
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
    
    
    @Override
    public Transaction getTransactionById(int transactionId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Transaction transaction = null;

        try {
            conn = DBUtil.getConnection(); // Assume DBUtil handles connection pooling

            String sql = "SELECT * FROM transactions WHERE id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, transactionId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                double amount = rs.getDouble("amount");
                java.util.Date date = rs.getDate("date");
                String category = rs.getString("category");
                int quantity = rs.getInt("quantity");
                String description = rs.getString("description");
                int user_id = rs.getInt("user_id");

                transaction = new Transaction(transactionId, user_id,amount, date, category, quantity, description);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log exception as necessary
        } finally {
            // Close resources in finally block
            DBUtil.closeConnection(conn);
        }

        return transaction;
    }
    
    public void updateTransaction(Transaction transaction) {
        String sql = "UPDATE transactions SET amount = ?, date = ?, category = ?, quantity = ?, description = ? WHERE id = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setDouble(1, transaction.getAmount());
            preparedStatement.setDate(2, new java.sql.Date(transaction.getDate().getTime()));
            preparedStatement.setString(3, transaction.getCategory());
            preparedStatement.setInt(4, transaction.getQuantity());
            preparedStatement.setString(5, transaction.getDescription());
            preparedStatement.setInt(6, transaction.getTransactionId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Transaction updated successfully!");
            } else {
                System.out.println("Transaction update failed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
