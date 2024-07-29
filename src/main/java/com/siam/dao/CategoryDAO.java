package com.siam.dao;

import java.util.List;

import com.siam.model.Category;
import com.siam.model.TransactionType;

public interface CategoryDAO {
    void addCategory(Category category);
    List<Category> getCategories();
    TransactionType getTransactionTypeByCategory(String x);

}
