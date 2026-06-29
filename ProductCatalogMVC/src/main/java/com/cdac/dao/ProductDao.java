package com.cdac.dao;

import java.util.List;

import com.cdac.entities.Product;

public interface ProductDao {
	
	List<Product> getProductByCategory(long categoryId);
	
	Product getProductById(long productId);
	
	void addProduct(Product product);
	
	
	void updateProduct(Product product);
	
	void deleteProduct(long productId);
	
}

