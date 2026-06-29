package com.cdac.controller;

import java.io.IOException;

import com.cdac.dao.ProductDao;
import com.cdac.dao.ProductDaoImpl;
import com.cdac.entities.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		long productId= Long.parseLong(request.getParameter("id"));
		ProductDao dao= new ProductDaoImpl();
		
		Product product= dao.getProductById(productId);
		
		request.setAttribute("product", product);
		
		request.getRequestDispatcher(
				"/WEB-INF/views/editProduct.jsp").forward(request, response);
	}
}
