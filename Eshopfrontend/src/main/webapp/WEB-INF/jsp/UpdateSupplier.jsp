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

<div class="background">
<%@ include file="Header.jsp"%>

<h4 align="center">SUPPLIER UPDATION</h4>
<div class="container">
    <form class="form-horizontal" action="<c:url value="/UpdateSupplier"/>" method="post">
  <div class="form-group">
    <label class="control-label col-sm-2" for="text">Supplier ID:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" readonly id="supid" name="supid" value="${SupplierInfo.supId}"/>
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="text">Supplier Name:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="supname" name="supname" value="${SupplierInfo.supName}"/>
    </div>
  </div>
	
  <div class="form-group">
    <label class="control-label col-sm-2" for="text">Supplier Location:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="suplocation" name="suplocation" value="${SupplierInfo.supLocation}"/>
    </div>
  </div>
  
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">SUBMIT</button>
      
    </div>
  </div>
	
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
			<a href="<c:url value="/updateSupplier/${supplier.supId}"/>">Update</a>/
				<a href="<c:url value="/deleteSupplier/${supplier.supId}"/>">Delete</a>
			</td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>