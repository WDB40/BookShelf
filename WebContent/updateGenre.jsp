<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Genre</title>
<script src="genreValidation.js"></script>
</head>
<body>

<h1>Update Genre</h1>

<form method="post" action="updateGenreServlet" onsubmit="return validateGenre()">
	
	<input type="hidden" name="id" value="${genre.id}">
	
	<table>
		<tr>
			<td>Genre:</td>
			<td><input type="text" name="name" value="${genre.name}" id="name"></td>
			<td id="nameError"></td>
		</tr>
		
		<tr>
			<td>Description:</td>
			<td><input type="text" name="desc" value="${genre.description}" id="desc"></td>
			<td id="descError"></td>
		</tr>
	</table>
	
	<input type="submit" value="Update">
	
</form>

<a href="index.html">Home</a>

</body>
</html>