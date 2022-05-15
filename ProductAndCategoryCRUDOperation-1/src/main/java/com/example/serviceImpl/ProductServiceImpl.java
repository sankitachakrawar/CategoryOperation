package com.example.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crudException.CrudException;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService{

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private ProductRepository repo; 

	@Override
	public Iterable<Product> getAllProduct() {
		logger.info("Product Service Implementation : getAllProduct() method");
		return repo.findAll(); 
	}

	@Override
	@Transactional
	public Product saveProduct(Product product) {
		logger.info("Product Service Implementation : saveProduct() method");
		return repo.save(product); 
	}

	@Override
	public Product getProductById(Integer Id) {
		logger.info("Product Service Implementation : getProductById() method");
		Product product=repo.findById(Id);
		if(product==null) {  
			throw new CrudException("Product id "+Id+" incorrect..");
		}
		return product;
	}

	@Override
	public void deleteProduct(Integer id) {
		logger.info("Product Service Implementation : deleteProduct() method");
		repo.deleteById(id);
	}

}
