<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OBSS</title>
</head>
<body>
	<h2>${message}</h2>
	
	<form action='<spring:url value="/logout"/>' method="get">
		<input value="Logout" type="submit">
	</form>
</body>
</html>