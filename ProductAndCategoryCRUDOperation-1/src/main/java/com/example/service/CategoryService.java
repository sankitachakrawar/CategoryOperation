package com.example.service;

import com.example.model.Category;

public interface CategoryService {

	public Iterable<Category> getAllCategory();
	public Category saveCategory(Category category);
	public <optional>Category getCategoryById(Integer Id);
	public void deleteCategory(Integer id);
	
}
