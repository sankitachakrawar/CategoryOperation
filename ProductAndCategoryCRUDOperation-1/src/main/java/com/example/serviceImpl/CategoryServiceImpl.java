package com.example.serviceImpl;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.crudException.CrudException;
import com.example.model.Category;
import com.example.repository.CategoryRepository;
import com.example.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	@Autowired
	private CategoryRepository repo; 

	@Override
	public Iterable<Category> getAllCategory() {
		logger.info("Category Service Implementation : getAllCategory() method");
		return repo.findAll(); 
	}

	@Override
	@Transactional
	public Category saveCategory(Category category) {
		logger.info("Category Service Implementation : saveCategory() method");
		return repo.save(category); 
	}

	@Override
	public Category getCategoryById(Integer Id) {
		logger.info("Category Service Implementation : getCategoryById() method");
		Category category=repo.findById(Id);
		if(category==null) {  
			throw new CrudException("Category id "+Id+" incorrect..");
		}
		return category;
	}

	@Override
	public void deleteCategory(Integer id) {
		logger.info("Category Service Implementation : deleteCategory() method");
		repo.deleteById(id);
	}

}

