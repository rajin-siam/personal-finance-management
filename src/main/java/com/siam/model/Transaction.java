package com.siam.model;

import java.util.Date;

public class Transaction {
    private int transactionId;
    private int user_id;
    private double amount;
    private Date date;
    private String category;
    private int quantity;
    private String description;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
