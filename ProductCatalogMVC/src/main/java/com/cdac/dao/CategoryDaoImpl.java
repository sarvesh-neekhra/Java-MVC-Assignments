package com.cdac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cdac.entities.Category;
import com.cdac.utils.DBUtils;

public class CategoryDaoImpl implements CategoryDao{
	@Override 
	public List<Category> getAllCategories(){
		
		List<Category> list= new ArrayList<>();
		
		try {
			Connection con = DBUtils.getConnection();
			
			String sql="select * from categories";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs= pst.executeQuery();
			
			while(rs.next()) {
				Category c= new Category();
				
				c.setCategoryId(rs.getLong("category_id"));
				c.setCategoryName(rs.getString("category_name"));
				c.setDescription(rs.getString("description"));
				
				list.add(c);
			}
			rs.close();
			pst.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
