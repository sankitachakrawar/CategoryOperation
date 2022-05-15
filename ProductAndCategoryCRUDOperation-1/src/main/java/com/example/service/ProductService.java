package com.example.service;

import com.example.model.Product;

public interface ProductService {
	
	
	public Iterable<Product> getAllProduct();
	public Product saveProduct(Product product);
	public <optional>Product getProductById(Integer Id);
	public void deleteProduct(Integer id);
	
}
