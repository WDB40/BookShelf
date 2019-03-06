<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Author</title>
<script src="authorValidation.js"></script>
</head>
<body>

<h1>Update Author</h1>

<form method="post" action="updateAuthorServlet" onsubmit="return validateAuthor()">
	
	<input type="hidden" name="id" value="${author.id}">
	
	<table>
		<tr>
			<td>First Name:</td>
			<td><input type="text" name="firstName" value="${author.firstName}" id="firstName"></td>
			<td id="firstNameError"></td>
		</tr>
		
		<tr>
			<td>Last Name:</td>
			<td><input type="text" name="lastName" value="${author.lastName}" id="lastName"></td>
			<td id="lastNameError"></td>
		</tr>
	</table>
	
	<input type="submit" value="Update">
</form>
<a href="index.html">Home</a>
</body>
</html>