<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${category.name}</h1>
	
	<h2>Products:</h2>
	
	<c:forEach items="${ category.products }" var="prod">
		<p>${prod.name }</p>
	</c:forEach>
	
	<form method="POST" action="/categories/join/${category.id}" >
		<select name="product_id">
			<c:forEach items="${products}" var="product">
				<option value="${product.id}">${product.name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Add">
	</form>
</body>
</html>