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

@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Product product = new Product();

        product.setProductId(
                Long.parseLong(request.getParameter("productId")));

        product.setPrice(
                Double.parseDouble(request.getParameter("price")));

        product.setStock(
                Integer.parseInt(request.getParameter("stock")));

        long categoryId =
                Long.parseLong(request.getParameter("categoryId"));

        ProductDao dao = new ProductDaoImpl();

        dao.updateProduct(product);

        response.sendRedirect(
                request.getContextPath()
                + "/app/products?categoryId="
                + categoryId);

    }
}