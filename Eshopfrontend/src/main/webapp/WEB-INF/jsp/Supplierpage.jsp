<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>

<title>Supplier</title>
</head>
<body>
<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="container">
    <form class="form-inline" action="InsertSupplier" method="post">
    <div class="form-group">
      <label for="text">Supplier Name:</label>
      <input type="text" class="form-control" id="supName" placeholder="Enter supplier name" name="supName">
    </div>
    <div class="form-group">
      <label for="text">Supplier Location:</label>
      <input type="text" class="form-control" id="supLocation" placeholder="Enter supplier Location" name="supLocation">
    </div>
    
    <button type="submit" class="btn btn-default">SUBMIT</button>&nbsp
   
</form>
</div>


<br><br>
<div class="container">
	   <table class="table table-bordered">
	   <thead>
	   <tr>
		<th>Supplier ID</th>
		<th>Supplier Name</th>
		<th>Supplier Location</th>
		<th>Operation</th>
		</tr>
       </thead>
      
	<c:forEach items="${listSuppliers}" var="supplier">
		<tr>
			<td>${supplier.supId}</td>
			<td>${supplier.supName}</td>
			<td>${supplier.supLocation}</td>
			<td>
			<a	href="<c:url value="/updateSupplier/${supplier.supId}"/>">Update</a>/
				<a href="<c:url value="/deleteSupplier/${supplier.supId}"/>">Delete</a>
			</td>
		</tr>
	</c:forEach>
</table>
</div>


</body>
</html>