<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Genre</title>
</head>
<body>

<h1>Update Genre</h1>

<form method="post" action="updateGenreServlet">
	
	<input type="hidden" name="id" value="${genre.id}">
	
	<table>
		<tr>
			<td>Genre:</td>
			<td><input type="text" name="name" value="${genre.name}"></td>
		</tr>
		
		<tr>
			<td>Description:</td>
			<td><input type="text" name="desc" value="${genre.description}"></td>
		</tr>
	</table>
	
	<input type="submit" value="Update">
	
</form>

<a href="index.html">Home</a>

</body>
</html>