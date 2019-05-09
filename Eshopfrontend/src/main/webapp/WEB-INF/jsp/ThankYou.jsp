<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstarp.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%@include file="Header.jsp"%>
<table class="table table-bordered">
<tr>
<td>Name:</td>
<td>${orderdetail.username}</td>
</tr>
<tr>
<td>Date:
<td>${orderdetail.orderDate}</td>
</tr>
<tr>
<td>TotalAmount:</td>
<td>${orderdetail.totalAmount}</td>
</tr>
<tr>
<td>TransactionType:</td>
<td>${orderdetail.transactionType}</td>
</tr>
<tr>
<td>Shipping Address:</td>
<td>${orderdetail.shippingAddr}</td>
</tr>
</table>
<table class="table table-hover">
<tr>
<td>Product Image</td>
<td>Product Name</td>
<td>Product Price</td>
<td>Quantity</td>
</tr>
<c:forEach items="${listPaidCarts}" var="cart">
<tr>
<td><img src="<c:url value="/resources/images/${cart.productId}.jpg"/>" width="75px" height="75px"><br>
</td>
<td>${cart.productName}</td>
<td>${cart.subtotal}</td>
<td>${cart.quantity}</td>
</tr>
</c:forEach>
</table>
Thank You
</body>
</html>