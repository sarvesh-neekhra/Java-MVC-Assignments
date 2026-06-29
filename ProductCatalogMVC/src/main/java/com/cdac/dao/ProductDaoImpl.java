package com.cdac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cdac.entities.Product;
import com.cdac.utils.DBUtils;

public class ProductDaoImpl implements ProductDao{
		
	
	
//	Get products by category
	@Override
	public List<Product> getProductByCategory(long categoryId) {
		List<Product> list= new ArrayList<>();
	try {
		Connection con = DBUtils.getConnection();
		
		String sql="select * from product where category_id=?";
		
		PreparedStatement pst = con.prepareStatement(sql);
		
		pst.setLong(1,categoryId);
		
		ResultSet rs= pst.executeQuery();
		
		while(rs.next()) {
			Product p= new Product();
			
			p.setProductId(rs.getLong("product_id"));

			p.setProductName(rs.getString("product_name"));
			
			p.setPrice(rs.getDouble("price"));
			
			p.setStock(rs.getInt("stock"));
			
			p.setCategoryId(rs.getLong("category_id"));
			
			list.add(p);
			
		}
		rs.close();
//		pst.close();
//		con.close();
		
	}catch(Exception e) {
		e.printStackTrace();
		}
	
	return list;
	
	}	



// Get product by ID;

@Override 
public Product getProductById(long productId) {
	Product product=null;
	
	try {
		Connection con = DBUtils.getConnection();
		PreparedStatement pst= con.prepareStatement(
				"Select * from products where product_id=?"
				);
		pst.setLong(1, productId);
					
		ResultSet rs= pst.executeQuery();
					
		if(rs.next()) {
			product = new Product();
						
			product.setProductId(rs.getLong("product_id"));
			product.setProductName(rs.getString("product_name"));
			product.setPrice(rs.getDouble("price"));
			product.setStock(rs.getInt("stock"));
			product.setCategoryId(rs.getLong("category_id"));
			}
		rs.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	return product;
}

// update product

@Override 
public void updateProduct(Product product) {
	try {
		Connection con= DBUtils.getConnection();
		PreparedStatement pst= con.prepareStatement("Update products set price=?, stock=? where product_id=?");
		
		pst.setDouble(1, product.getPrice());
		pst.setInt(2, product.getStock());
		pst.setLong(3, product.getProductId());
		
		pst.executeUpdate();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}

//Delete product
@Override
public void deleteProduct(long productId) {
	try {
	Connection con= DBUtils.getConnection();
	PreparedStatement pst= con.prepareStatement("Delete from products where product_id=?");
	pst.setLong(1,productId);
	
	pst.executeUpdate();
	
	}catch(Exception e) {
		e.printStackTrace();
	 }
	}
	
@Override
public void addProduct(Product product) {
	
	try {
		Connection con = DBUtils.getConnection();
		
		String sql="INSERT into products(product_name,price,stock,category_id) values(?,?,?,?)";
		
		PreparedStatement pst= con.prepareStatement(sql);
		
		pst.setString(1,product.getProductName());
		pst.setDouble(2, product.getPrice());
		pst.setInt(3, product.getStock());
		pst.setLong(4, product.getCategoryId());
		
		pst.executeUpdate();
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}



 }








