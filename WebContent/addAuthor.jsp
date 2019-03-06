<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Author</title>
<script src="authorValidation.js"></script>
</head>
<body>
	<h1>Add Author</h1>
	
	<form method="post" action="addAuthorServlet" onsubmit="return validateAuthor();">
		<table>
			<tr>
				<th>First Name:</th>
				<td><input type="text" name="firstName" id="firstName"></td>
				<td id="firstNameError"></td>
			</tr>
			
			<tr>
				<th>Last Name:</th>
				<td><input type="text" name="lastName" id="lastName"></td>
				<td id="lastNameError"></td>
			</tr>
		</table>
		
		<input type="submit" value="Add">
	</form>
	
	<a href="index.html">Home</a>
</body>
</html>