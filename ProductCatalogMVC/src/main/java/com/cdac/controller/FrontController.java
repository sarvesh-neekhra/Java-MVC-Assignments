package com.cdac.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/app/*")
public class FrontController extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getPathInfo();
		
		if(path==null || path.equals("/") || path.equals("")){
		request.getRequestDispatcher("/home").forward(request,response);
}
		else if(path.equals("/products")) {
			request.getRequestDispatcher("/products").forward(request,response);
		}
		else if(path.equals("/editProduct")) {
			request.getRequestDispatcher("/editProduct").forward(request,response);
		}
		else if(path.equals("/deleteProduct")) {
			request.getRequestDispatcher("/deleteProduct").forward(request,response);
		}
		else if(path.equals("/updateProduct")){
			request.getRequestDispatcher("/updateProduct").forward(request,response);
		}
		else if(path.equals("/addProduct")) {
			request.getRequestDispatcher("/addProduct").forward(request, response);
		}
		else {
			response.getWriter().println("Invaid URL");
			
		}
}
}