package com.siam.model;

import java.util.Date;
import com.siam.dao.*;

public class Transaction {
    private int transactionId;
    private int user_id;
    private double amount;
    private Date date;
    private Category category;
    private int quantity;
    private String description;
    
    public Transaction() {
    	
    }
    
    public Transaction(int transactionId, int user_id, double amount, Date date, Category category, int quantity, String description) {
    	
        this.transactionId =transactionId;
        this.user_id = user_id;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this. quantity = quantity;
        this.description = description;
    }
    

    // Getters and Setters
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(String category) {
    	CategoryDAO c = new CategoryDAOImpl();
    	TransactionType transactionType = c.getTransactionTypeByCategory(category);
        this.category = new Category(category, transactionType);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    public void setUserId(int user_id) {
    	this.user_id = user_id;
    }
    
    public int getUserId() {
    	return user_id;
    }
}
