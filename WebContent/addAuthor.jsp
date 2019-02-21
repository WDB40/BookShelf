<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Author</title>
</head>
<body>
	<h1>Add Author</h1>
	
	<form method="post" action="addAuthorServlet">
		<table>
			<tr>
				<th>First Name:</th>
				<td><input type="text" name="firstName"></td>
			</tr>
			
			<tr>
				<th>Last Name:</th>
				<td><input type="text" name="lastName"></td>
			</tr>
		</table>
		
		<input type="submit" value="Add">
	</form>
	
	<a href="index.html">Home</a>
</body>
</html>