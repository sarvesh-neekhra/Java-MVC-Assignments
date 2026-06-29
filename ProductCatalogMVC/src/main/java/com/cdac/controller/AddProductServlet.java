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

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        long categoryId =
                Long.parseLong(request.getParameter("categoryId"));

        request.setAttribute("categoryId", categoryId);

        request.getRequestDispatcher("/WEB-INF/views/addProduct.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Product product = new Product();

        product.setProductName(
                request.getParameter("productName"));
        System.out.println("Product Name : " + request.getParameter("productName"));
        System.out.println("Price        : " + request.getParameter("price"));
        System.out.println("Stock        : " + request.getParameter("stock"));
        System.out.println("Category Id  : " + request.getParameter("categoryId"));
        product.setPrice(
                Double.parseDouble(request.getParameter("price")));

        product.setStock(
                Integer.parseInt(request.getParameter("stock")));

        long categoryId =
                Long.parseLong(request.getParameter("categoryId"));

        product.setCategoryId(categoryId);

        ProductDao dao = new ProductDaoImpl();

        dao.addProduct(product);

        response.sendRedirect(
                request.getContextPath()
                + "/app/products?categoryId="
                + categoryId);
    }
}
