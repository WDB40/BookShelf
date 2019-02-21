<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Entire Book Shelf</title>
</head>
<body>

<h1>All Available Books</h1>

<form method="post" action="navigationServlet">
	<table>
		<tr>
			<th></th>
			<th>Title</th>
			<th>Author First Name</th>
			<th>Author Last Name</th>
			<th>Genre</th>
		</tr>
		<c:forEach items="${requestScope.allBooks}" var="currentBook">
			<tr>
				<td> 
					<input type="radio" name="id" value="${currentBook.id}">
				</td>
				
				<td>${currentBook.title}</td>
				<td>${currentBook.author.firstName}</td>
				<td>${currentBook.author.lastName}</td>
				<td>${currentBook.genre.name}</td>
			</tr>
		</c:forEach>
	</table>
	
	<input type="submit" value="Update" name="action">
	<input type="submit" value="Check Out" name="action">
	<input type="submit" value="Check In" name="action">
</form>

<a href="index.html">Home</a>
</body>
</html>