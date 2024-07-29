package com.siam.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.siam.dao.TransactionDAO;
import com.siam.dao.TransactionDAOImpl;
import com.siam.model.Transaction;
import com.siam.model.TransactionType;

public class FinanceCalculator {

    private TransactionDAO transactionDAO;
    private int userId;

    public FinanceCalculator() {
        this.transactionDAO = new TransactionDAOImpl();
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double calculateBalance() {
        List<Transaction> transactions = transactionDAO.getUserTransactions(userId);
        double incoming = 0.0;
        double outgoing = 0.0;
		/*
		 * for(Transaction transaction : transactions) {
		 * System.out.println(transaction.getCategory().getCategoryName()); }
		 */

        for (Transaction transaction : transactions) {

            if (transaction.getCategory().getTransactionType() == TransactionType.INCOMING) {
                incoming += transaction.getAmount();
                System.out.println(transaction.getCategory().getCategoryName());
            } else if (transaction.getCategory().getTransactionType() == TransactionType.OUTGOING) {
                outgoing += transaction.getAmount();
            }
        }
        System.out.println("Incoming " + incoming );

        return incoming - outgoing;
    }

    public Map<String, Double> calculateSpendingByCategory() {
        List<Transaction> transactions = transactionDAO.getUserTransactions(userId);
        Map<String, Double> spendingByCategory = new HashMap<>();

        for (Transaction transaction : transactions) {
            String category = transaction.getCategory().getCategoryName();
            double amount = transaction.getAmount();
            spendingByCategory.put(category, spendingByCategory.getOrDefault(category, 0.0) + amount);
        }

        return spendingByCategory;
    }

    public double calculateSpendingByPeriod(java.sql.Date startDate, java.sql.Date endDate) {
        List<Transaction> transactions = transactionDAO.getTransactionsByDateRange(startDate, endDate);
        double totalAmount = 0.0;

        for (Transaction transaction : transactions) {
            totalAmount += transaction.getAmount();
        }

        return totalAmount;
    }

    public Map<String, Double> calculateSpendingByMonth() {
        List<Transaction> transactions = transactionDAO.getUserTransactions(userId);
        Map<String, Double> spendingByMonth = new HashMap<>();

        for (Transaction transaction : transactions) {
            Date date = transaction.getDate();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            String monthKey = String.format("%d-%02d", calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1);

            double amount = spendingByMonth.getOrDefault(monthKey, 0.0);
            amount += transaction.getAmount();
            spendingByMonth.put(monthKey, amount);
        }

        return spendingByMonth;
    }

    public Map<String, Double> calculateSpendingByDay() {
        List<Transaction> transactions = transactionDAO.getUserTransactions(userId);
        Map<String, Double> spendingByDay = new HashMap<>();

        for (Transaction transaction : transactions) {
            Date date = transaction.getDate();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            String dayKey = String.format("%d-%02d-%02d", calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));

            double amount = spendingByDay.getOrDefault(dayKey, 0.0);
            amount += transaction.getAmount();
            spendingByDay.put(dayKey, amount);
        }

        return spendingByDay;
    }

    public Map<String, Double> calculateSpendingByYear() {
        List<Transaction> transactions = transactionDAO.getUserTransactions(userId);
        Map<String, Double> spendingByYear = new HashMap<>();

        for (Transaction transaction : transactions) {
            Date date = transaction.getDate();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            String yearKey = String.valueOf(calendar.get(Calendar.YEAR));

            double amount = spendingByYear.getOrDefault(yearKey, 0.0);
            amount += transaction.getAmount();
            spendingByYear.put(yearKey, amount);
        }

        return spendingByYear;
    }
}
