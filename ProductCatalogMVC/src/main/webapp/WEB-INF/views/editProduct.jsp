<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.cdac.entities.Product"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Edit Product</title>

<style>

body{

font-family:Arial;

background:#f4f4f4;

}

.container{

width:500px;

margin:auto;

margin-top:50px;

background:white;

padding:20px;

}

input{

width:100%;

padding:10px;

margin:10px 0;

}

button{

padding:10px 20px;

background:blue;

color:white;

border:none;

}

</style>

</head>

<body>

<%

Product product=

(Product)request.getAttribute("product");

%>

<div class="container">

<h2>Edit Product</h2>

<form

action="<%=request.getContextPath()%>/app/updateProduct"

method="post">

<input

type="hidden"

name="productId"

value="<%=product.getProductId()%>">

<input

type="hidden"

name="categoryId"

value="<%=product.getCategoryId()%>">

<label>

Product Name

</label>

<input

type="text"

value="<%=product.getProductName()%>"

readonly>

<label>

Price

</label>

<input

type="text"

name="price"

value="<%=product.getPrice()%>">

<label>

Stock

</label>

<input

type="text"

name="stock"

value="<%=product.getStock()%>">

<button>

Update Product

</button>

</form>

</div>

</body>

</html>