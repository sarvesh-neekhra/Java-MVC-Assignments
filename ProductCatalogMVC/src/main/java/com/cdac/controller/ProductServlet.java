package com.cdac.controller;

import java.io.IOException;
import java.util.List;

import com.cdac.dao.ProductDao;
import com.cdac.dao.ProductDaoImpl;
import com.cdac.entities.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/products")
public class ProductServlet extends HttpServlet{
	
	@Override
//	@Override
	protected void doPost(HttpServletRequest request,
	        HttpServletResponse response)
	        throws ServletException, IOException {

	    long categoryId =
	            Long.parseLong(request.getParameter("categoryId"));

	    ProductDao dao = new ProductDaoImpl();

	    List<Product> products =
	            dao.getProductByCategory(categoryId);

	    request.setAttribute("products", products);

	    request.setAttribute("categoryId", categoryId);

	    request.getRequestDispatcher("/WEB-INF/views/products.jsp")
	           .forward(request, response);
	}
	
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		long categoryId= Long.parseLong(request.getParameter("categoryId"));
		
		ProductDao dao= new ProductDaoImpl();
		List<Product> products= dao.getProductByCategory(categoryId);
		
		request.setAttribute("products", products);
		request.setAttribute("categoryId", categoryId);
		
		request.getRequestDispatcher("WEB-INF/views/products.jsp").forward(request, response);
		
		
	}
	
	
}
