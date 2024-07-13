package com.siam.dao;

import java.util.List;

import com.siam.model.Category;

public interface CategoryDAO {
    void addCategory(Category category);
    List<Category> getCategories();
}
