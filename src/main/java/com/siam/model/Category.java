package com.siam.model;

public class Category {
    private String categoryName;
    private TransactionType transactionType;
    
    public Category() {
    }

    public Category(String categoryName, TransactionType transactionType) {
        this.categoryName = categoryName;
        this.transactionType = transactionType;
    }

    // Getters and setters
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
