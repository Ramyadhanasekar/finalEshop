<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%@ include file="Header.jsp"%>

<div class="background">

<h4 align="center">PRODUCT UPDATION</h4>
<div class="container">
    <form class="form-horizontal" action="<c:url value="/updateProductDB/${product.productId}"/>" method="post" enctype="multipart/form-data">
  
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
    <label class="control-label col-sm-2" for="text">Product Name:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="productName" name="productName" value="${product.productName}"/>
    </div>
  </div>
        
      
  <div class="form-group">
    <label class="control-label col-sm-2" for="text">Product Desc:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="prodDesc" name="prodDesc" value="${product.prodDesc}"/>
    </div>
  </div>
  
   <div class="form-group">
    <label class="control-label col-sm-2" for="text">Product stock:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="stock" name="stock" value="${product.stock}"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="text">Product Price:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="price" name="price" value="${product.price}"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="text">Product Image:</label>
    <div class="col-sm-10">
      <img src="<c:url value="/resources/images/${product.productId}.jpg"/>""width="75px" height="75px">
      
   </div>
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
	   
		<th>Product Name</th>
		<th>Product Desc</th>
		<th>Product stock</th>
		<th>Product Price</th>
		<th>Image</th>
		<th>Operation</th>
		</tr>
       </thead>
	<c:forEach items="${listProducts}" var="product">
		<tr>
			
			<td>${product.productName}</td>
			<td>${product.prodDesc}</td>
			<td>${product.stock}</td>
			<td>${product.price}</td>
			<td>
			<img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="75px" height="75px"></td>
			<td>
			<a href="<c:url value="/updateProduct/${product.productId}"/>">Update</a>/
							<a href="<c:url value="/deleteProduct/${product.productId}"/>">Delete</a>
			</td>
		</tr>
	</c:forEach>
   </div>
</body>
</html>