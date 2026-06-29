<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.cdac.entities.Product"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>

<style>

body{
	font-family: Arial, sans-serif;
	background:#f4f4f4;
	margin:0;
	padding:0;
}

.container{
	width:900px;
	margin:40px auto;
	background:white;
	padding:20px;
	box-shadow:0 0 10px gray;
}

h2{
	text-align:center;
	color:#333;
}

table{
	width:100%;
	border-collapse:collapse;
	margin-top:20px;
}

table,th,td{
	border:1px solid #ccc;
}

th{
	background:#007bff;
	color:white;
	padding:10px;
}

td{
	padding:10px;
	text-align:center;
}

a{
	text-decoration:none;
}

.btn{
	padding:8px 15px;
	border-radius:5px;
	color:white;
	font-weight:bold;
}

.add{
	background:green;
}

.update{
	background:orange;
}

.delete{
	background:red;
}

.home{
	background:#007bff;
}

.top-buttons{
	margin-bottom:20px;
	text-align:right;
}

.message{
	text-align:center;
	color:red;
	font-size:18px;
	font-weight:bold;
	margin-top:20px;
}

</style>

</head>
<body>

<div class="container">

<h2>Products</h2>

<%
	List<Product> products =
	(List<Product>)request.getAttribute("products");

	Long categoryId =
	(Long)request.getAttribute("categoryId");
%>

<div class="top-buttons">

<a class="btn add"
href="<%=request.getContextPath()%>/app/addProduct?categoryId=<%=categoryId%>">
Add Product
</a>

</div>

<%
if(products==null || products.isEmpty()){
%>

<div class="message">
No products found for this category.
</div>

<%
}else{
%>

<table>

<tr>
	<th>Product ID</th>
	<th>Product Name</th>
	<th>Price</th>
	<th>Stock</th>
	<th>Update</th>
	<th>Delete</th>
</tr>

<%
for(Product p : products){
%>

<tr>

<td><%=p.getProductId()%></td>

<td><%=p.getProductName()%></td>

<td>₹ <%=p.getPrice()%></td>

<td><%=p.getStock()%></td>

<td>

<a class="btn update"
href="<%=request.getContextPath()%>/app/editProduct?id=<%=p.getProductId()%>">

Update

</a>

</td>

<td>

<a class="btn delete"

href="<%=request.getContextPath()%>/app/deleteProduct?id=<%=p.getProductId()%>&categoryId=<%=categoryId%>"

onclick="return confirm('Are you sure you want to delete this product?');">

Delete

</a>

</td>

</tr>

<%
}
%>

</table>

<%
}
%>

<br><br>

<center>

<a class="btn home"
href="<%=request.getContextPath()%>/app/">

Back To Home

</a>

</center>

</div>

</body>
</html>