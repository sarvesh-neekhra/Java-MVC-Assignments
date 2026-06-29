<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.cdac.entities.Category"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Catalog</title>

<style>

body{

font-family:Arial;
background:#f4f4f4;

}

.container{

width:500px;
margin:auto;
margin-top:80px;
background:white;
padding:30px;
box-shadow:0px 0px 10px gray;

}

select{

width:100%;
padding:10px;
margin-top:20px;

}

input{

padding:10px 20px;
margin-top:20px;
background:blue;
color:white;
border:none;
cursor:pointer;

}

h2{

text-align:center;

}

</style>

</head>

<body>

<div class="container">

<h2>Product Catalog</h2>

<form action="<%=request.getContextPath()%>/app/products" method="post">

<select name="categoryId">

<%

List<Category> categories =
(List<Category>)request.getAttribute("categories");

for(Category c : categories){

%>

<option value="<%=c.getCategoryId()%>">

<%=c.getCategoryName()%>

</option>

<%

}

%>

</select>

<br>

<input type="submit" value="Show Products">

</form>

</div>

</body>
</html>