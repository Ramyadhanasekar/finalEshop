<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Header</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid" >
    <div class="navbar-header">     
	<c:if test="${username=='Admin'}">
	<a class="navbar-brand" href="<c:url value="/Categorypage"/>">Category</a>
	<a class="navbar-brand" href="<c:url value="/Supplierpage"/>">Supplier</a>
	<a class="navbar-brand" href="<c:url value="/Productpage"/>">Product</a>
	
	</c:if>
	<c:if test="${username!='Admin'}">
		<a class="navbar-brand" href="<c:url value="/Home"/>">Home</a>
		<a class="navbar-brand" href="<c:url value="/ProductDisplay"/>">ProductDisplay</a>
</c:if>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
	<ul class="nav navbar-nav navbar-right">
	<c:if test="${empty SuccessMessage}">
    	<li> <a href="<c:url value="/login"/>">Login
          <span class="glyphicon glyphicon-log-out"></span>
        </a></li>
	<li> <a href="<c:url value="/RegForm"/>">Register
	<span class="glyphicon glyphicon-pencil"></span>
	</a></li>
	</c:if>
	</ul>
	
	<ul class="nav navbar-nav navbar-right">
 <c:if test="${not empty SuccessMessage}">
   <li><a href="<c:url value="/perform_logout"/>"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
   <li> <a href="<c:url value="/Cart"/>">Cart
	<span class="glyphicon glyphicon-shopping-cart"></span>
	</a></li>
  <li> <font color="white"><span class="glyphicon glyphicon-user"></span> Hello! ${username}</font></li>
 </c:if>    
	</ul>
	
  </div>
  </div>
</nav>
</body>
</html>