package com.example.controller;

import java.util.Collections;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Category;
import com.example.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;

	/*
	 * This method is used to get all the categories details
	 * 
	 */
	@GetMapping("/categories")
	public @ResponseBody Iterable<Category> getAllCategory() throws Exception {
		logger.info("Category Rest Controller Implementation : getAllCategory() method");
		return categoryService.getAllCategory();
	}
	/*
	 * This method is used to store the categories details.
	 */

	@PostMapping("/categories")
	public ResponseEntity<Category> createCategory(@RequestBody Category category, HttpServletRequest request)
			throws Exception {
		Category createdCategory = this.categoryService.saveCategory(category); 
		logger.info("Category Rest Controller Implementation : createCategory() method");
		return ResponseEntity.ok().body(createdCategory);
	}
	/*
	 * This method is used to get the categories details by using id
	 */
	@GetMapping("/categories/{id}")   
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") Integer id) {
		Category category = categoryService. getCategoryById(id); 
		logger.info("Category Rest Controller Implementation : getCategoryById() method");
		return ResponseEntity.ok().body(category);
	}
	/*
	 * This method is used to delete the categories details using id.
	 */

	@DeleteMapping("/categories/{id}")
	public Map<String, String> deleteCategoryById(@PathVariable("id") Integer id) throws Exception {
		Category category= categoryService.getCategoryById(id); 
	logger.info("Product Rest Controller Implementation : deleteCategoryById() method");
		if (category != null) { 
			categoryService.deleteCategory(id); 
			return Collections.singletonMap("success", "Record Deleted Successfully");
		} else {
			return Collections.singletonMap("fail", "Something is wrong");
		}
	}
	@PutMapping("/categories/{id}")
	public ResponseEntity<Category> updateCategoryById(@PathVariable("id") Integer id, @RequestBody Category category) {
		Category category1 = categoryService.getCategoryById(id);
		category1.setId(category.getId());
		category1.setCat_name(category.getCat_name());
		category1.setDescription(category.getDescription());
	
		
		Category category2= categoryService.saveCategory(category1);
		return ResponseEntity.ok().body(category2);
	}

}
