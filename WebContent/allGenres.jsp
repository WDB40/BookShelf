<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Genres</title>
</head>
<body>

<h1>All Genres</h1>

<form method="post" action="genreNavigator">
	<table>
		<tr>
			<th></th>
			<th>Genre</th>
			<th>Description</th>
		</tr>
		
		<c:forEach items="${requestScope.allGenres}" var="currentGenre">
			<tr>
				<td><input type="radio" name="id" value="${currentGenre.id}"></td>
				<td>${currentGenre.name}</td>
				<td>${currentGenre.description }</td>
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