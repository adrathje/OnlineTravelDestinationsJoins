<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Traveler List</title>
</head>
<body>
	<form method="post" action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.allDestinations}"
				var="currentdestination">
				<tr>
					<td><input type="radio" name="id"
						value="${currentdestination.id}"></td>
					<td>${currentdestination.country}</td>
					<td>${currentdestination.city}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToDestination">
		<input type="submit" value="delete" name="doThisToDestination">
		<input type="submit" value="add" name="doThisToDestination">
	</form>
</body>
</html>