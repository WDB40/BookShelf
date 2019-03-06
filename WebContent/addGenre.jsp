<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Genre</title>
<script src="genreValidation.js"></script>
</head>
<body>

<h1>Add Genre</h1>

<form method="post" action="addGenreServlet" onsubmit="return validateGenre();">
	<table>
		<tr>
			<th>Genre:</th>
			<td><input type="text" name="name" id="name"></td>
			<td id="nameError"></td>
		</tr>
		
		<tr>
			<th>Description:</th>
			<td><input type="text" name="desc" id="desc"></td>
			<td id="descError"></td>
		</tr>
	</table>
	
	<input type="submit" value="Add">
</form>

<a href="index.html">Home</a>

</body>
</html>