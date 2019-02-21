<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Genre</title>
</head>
<body>

<h1>Add Genre</h1>

<form method="post" action="addGenreServlet">
	<table>
		<tr>
			<th>Genre:</th>
			<td><input type="text" name="name"></td>
		</tr>
		
		<tr>
			<th>Description:</th>
			<td><input type="text" name="desc"></td>
		</tr>
	</table>
	
	<input type="submit" value="Add">
</form>

<a href="index.html">Home</a>

</body>
</html>