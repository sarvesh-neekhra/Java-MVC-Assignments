<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<title>Add Product</title>

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
background:green;
color:white;
border:none;

}

</style>

</head>

<body>

<div class="container">

<h2>Add Product</h2>

<form action="<%=request.getContextPath()%>/app/addProduct"

method="post">

<input type="hidden"

name="categoryId"

value="<%=request.getAttribute("categoryId")%>">

<label>

Product Name

</label>

<input type="text"

name="productName"

required>

<label>

Price

</label>

<input type="text"

name="price"

required>

<label>

Stock

</label>

<input type="text"

name="stock"

required>

<button>

Save Product

</button>

</form>

</div>

</body>

</html>