<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>New Product: </h1>
	<form:form action="/products/new" method="POST" modelAttribute="product">
		
		<form:label path="name">Name:
			<form:input type="text" path="name"></form:input>
			<form:errors path="name"></form:errors>
		</form:label><br><br>
		
		<form:label path="description">Description:	
			<form:input type="text" path="description"></form:input>
			<form:errors path="description"></form:errors>
		</form:label><br><br>
		
		<form:label path="price">Price:
			<form:input type="float" path="price"></form:input>
			<form:errors path="price"></form:errors>
		</form:label><br><br>
		
		<input type="submit" value="Create Product">
	
	</form:form>

</body>
</html>