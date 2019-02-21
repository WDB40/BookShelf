<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Authors</title>
</head>
<body>
<h1>All Authors</h1>

<form method="post" action="authorNavigator">
	<table>
		<tr>
			<th></th>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
		
		<c:forEach items="${requestScope.allAuthors}" var="currentAuthor">
			<tr>
				<td><input type="radio" name="id" value="${currentAuthor.id}"></td>
				<td>${currentAuthor.firstName}</td>
				<td>${currentAuthor.lastName}</td>
			</tr>
		</c:forEach>
	</table>
	
	<input type="submit" value="Update" name="action">
	<input type="submit" value="Add" name="action">
	<input type="submit" value="Remove" name="action">
	
</form>
<a href="index.html">Home</a>
</body>
</html>