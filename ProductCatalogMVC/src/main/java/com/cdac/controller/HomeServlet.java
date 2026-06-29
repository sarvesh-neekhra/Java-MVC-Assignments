package com.cdac.controller;

import java.io.IOException;
import java.util.List;

import com.cdac.dao.CategoryDao;
import com.cdac.dao.CategoryDaoImpl;
import com.cdac.entities.Category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException{
		
		CategoryDao dao= new CategoryDaoImpl();
		
		List<Category> categories= dao.getAllCategories();
		
		System.out.println("Categories count = " + categories.size());

		for (Category c : categories) {
		    System.out.println(c.getCategoryId() + " " + c.getCategoryName());
		}
		
		request.setAttribute("categories", categories);
		
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	
	}
}
