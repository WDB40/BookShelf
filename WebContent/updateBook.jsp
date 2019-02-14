<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Book</title>
</head>
<body>
<h1>Update Book</h1>

<form action="updateBookServlet" method="post">
	
	<input type="hidden" name="id" value="${bookToUpdate.id}">
	
	<table>
		<tr>
			<th>Title</th>
			<td><input type="text" name="title" value="${bookToUpdate.title}"></td>
		</tr>
		<tr>
			<th>Author First Name</th>
			<td><input type="text" name="authorFirstName" value="${bookToUpdate.authorFirstName}"></td>
		</tr>
		<tr>
			<th>Author Last Name</th>
			<td><input type="text" name="authorLastName" value="${bookToUpdate.authorLastName}"></td>
		</tr>
		<tr>
			<th>Genre</th>
			<td><input type="text" name="genre" value="${bookToUpdate.genre}"></td>
		</tr>
	</table>
	
	<input type="submit" value="Update Book">
	
</form>

</body>
</html>