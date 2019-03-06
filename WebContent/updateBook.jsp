<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Book</title>
<script src="bookValidation.js"></script>
</head>
<body>
<h1>Update Book</h1>

<form action="updateBookServlet" method="post" onsubmit="return validateBook()">
	
	<input type="hidden" name="id" value="${bookToUpdate.id}">
	
	<table>
		<tr>
			<th>Title</th>
			<td><input type="text" name="title" value="${bookToUpdate.title}" id="title"></td>
			<td id="titleError"></td>
		</tr>
		
		<tr>
			<th>Author</th>
			<td>
				<select name="author">
					<c:forEach items="${requestScope.allAuthors}" var="currentAuthor">
						<option value="${currentAuthor.id}">${currentAuthor.firstName} ${currentAuthor.lastName}</option>
					</c:forEach>
				</select>
			</td>
		</tr>

		<tr>
			<th>Genre:</th>
			<td>
				<select name="genre">
					<c:forEach items="${requestScope.allGenres}" var="currentGenre">
						<option value="${currentGenre.id}">${currentGenre.name}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
	</table>
	
	<input type="submit" value="Update Book">
	
</form>

</body>
</html>