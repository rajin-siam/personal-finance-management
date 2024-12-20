package com.siam.dao;

import com.siam.model.Transaction;


import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface TransactionDAO {
    void addTransaction(Transaction transaction) throws SQLException;
    void updateTransaction(Transaction transaction);
    void deleteTransaction(int transactionId);
    Transaction getTransactionById(int transactionId);
 //   List<Transaction> getAllTransactions();
    public List<Transaction> getUserTransactions(int userId) ;
    List<Transaction> getTransactionsByDateRange(java.sql.Date startDate, java.sql.Date endDate);
    List<Transaction> getTransactionsByCategory(String categoryName);
}
