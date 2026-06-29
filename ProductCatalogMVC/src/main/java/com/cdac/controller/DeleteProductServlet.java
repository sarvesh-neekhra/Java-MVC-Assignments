package com.cdac.controller;

import java.io.IOException;

import com.cdac.dao.ProductDao;
import com.cdac.dao.ProductDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long productId=Long.parseLong(request.getParameter("id"));
		
		long categoryId= Long.parseLong(request.getParameter("categoryId"));
		
		ProductDao dao= new ProductDaoImpl();
		
		dao.deleteProduct(productId);
		
		response.sendRedirect(
					request.getContextPath()+"/app/products?categoryId="+categoryId					
				);
	}
}
