<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    
    
<!DOCTYPE html>
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
<h4 align="center">CATEGORY UPDATION</h4>
<div class="container">
    <form class="form-horizontal" action="<c:url value="/UpdateCategory"/>" method="post">
  <div class="form-group">
    <label class="control-label col-sm-2" for="text">Category ID:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" readonly id="catid" name="catid" value="${categoryInfo.catid}"/>
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="text">Category Name:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="catname" name="catname" value="${categoryInfo.catname}"/>
    </div>
  </div>
	
  <div class="form-group">
    <label class="control-label col-sm-2" for="text">Category Description:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="catdesc" name="catdesc" value="${categoryInfo.catdesc}"/>
    </div>
  </div>
  
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">SUBMIT</button>
      
    </div>
  </div>
	
	</form>
	</div>
	
<div class="container">
	   <table class="table table-bordered">
	   <thead>
	   <tr>
		<th>Category ID</th>
		<th>Category Name</th>
		<th>Category Desc</th>
		<th>Operation</th>
		</tr>
	</thead>
	<c:forEach items="${listCategories}" var="category">
	<tr>
		<td>${category.catid}</td>
		<td>${category.catname}</td>
		<td>${category.catdesc}</td>
		<td>
		<a href="<c:url value="/updateCategory/${category.catid}"/>">Update</a>/
		<a href="<c:url value="/deleteCategory/${category.catid}"/>">Delete</a>
		</td>
	</tr>
	</c:forEach>
	
</table>



</div>

</body>
</html>