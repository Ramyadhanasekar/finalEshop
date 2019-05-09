<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<title>product</title>
</head>
<body>
<%@ include file="Header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="container">
<form class="form-inline" action="InsertProduct" method="post" enctype="multipart/form-data">
	
	PRODUCT DETAILS<br><br>
	<div class="form-group">
	<label for="sell">Category ID:</label>
	<select class="form-control"  name="categoryid">
	<c:forEach items="${listCategories }" var="cat">
	<option value="${cat.catid}">${cat.catname}</option>
	
	</c:forEach>
	</select>
	<br>
</div>
<br>
<div class="form-group">
	<label for="sell">Supplier ID:</label>
	<select class="form-control"  name="supplierid">
	<c:forEach items="${listSuppliers }" var="supp">
	<option value="${supp.supId}">${supp.supName}</option>
	
	</c:forEach>
	</select>
	<br>
</div>
<br>

 <div class="form-group">
      <label for="text">Product Name:</label>
      <input type="text" class="form-control" id="productName" placeholder="Enter product name" name="productName">
    </div>
    <div class="form-group">
      <label for="text">Product Desc:</label>
      <input type="text" class="form-control" id="prodDesc" placeholder="Enter product description" name="prodDesc">
    </div>
   
    <div class="form-group">
      <label for="text">Product Stock:</label>
      <input type="text" class="form-control" id="stock" placeholder="Enter stock" name="stock">
    </div>
    <div class="form-group">
      <label for="text">Product Price:</label>
      <input type="text" class="form-control" id="price" placeholder="Enter price" name="price">
    </div>
    
    <div class="form-group">
      <input type="file" accept="resources/images/*" name="pimage">
    </div>
   <button type="submit" class="btn btn-default">Submit</button>&nbsp
   <br><br>
    </form>
</div>
<div class="container">
	   <table class="table table-bordered">
	   <thead>
	   <tr>
	   <th>Product Id</th>
		<th>Product Name</th>
		<th>Product Desc</th>
		<th>Product stock</th>
		<th>Product Price</th>
		<th>image</th>
		<th>Operation</th>
		</tr>
       </thead>
	<c:forEach items="${listProducts}" var="product">
		<tr>
			<td>${product.productId}</td>
			<td>${product.productName}</td>
			<td>${product.prodDesc}</td>
			<td>${product.stock}</td>
			<td>${product.price}</td>
			<td>
			
			<img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="75px" height="75px"></td>
			<td>			<a href="<c:url value="/updateProduct/${product.productId}"/>">Update</a>/
				<a href="<c:url value="/deleteProduct/${product.productId}"/>">Delete</a>
			</td>
		</tr>
	</c:forEach>
	</table>
   </div>


</body>
</html>