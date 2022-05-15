package com.example.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Category;

	@Repository
	public interface CategoryRepository extends CrudRepository<Category, Serializable>{
		
		public Category findById(Integer Id);

	
}
