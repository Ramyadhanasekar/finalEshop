<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<title>Product Description</title>
</head>
<body>
<%@ include file="Header.jsp"%>
<form method="post" action="<c:url value="/addCart/${product.productId}"/>">
<table>
<tr>
<td style="text-transform:uppercase;" id="name">${product.productName}</td>
</tr>
<tr>
<td  colspan="2" rowspan="2"><img class="img-fluid img-thumbnail" src="<c:url value="/resources/images/${product.productId}.jpg"/>" style="width:200px; height:200px;"></td>
<td>Description:${product.prodDesc}</td>
</tr>
<tr>
<td>Price:${product.price}</td>
</tr>
<tr>
<td>
<input type="submit" value="ADD TO CART">
</td>
</tr>
</table>
</form>



</body>
</html>