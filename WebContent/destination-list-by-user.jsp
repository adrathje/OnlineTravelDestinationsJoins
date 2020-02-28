<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Destination Lists</title>
</head>
<body>
<body>
	<form method="post" action="listNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allDestinations}" var="currentlist">
				<tr>
					<td><input type="radio" name="id" value="${currentdestination.id}"></td>
					<td><h2>${currentdestination.listName}</h2></td>
				</tr>
				<tr>
					<td colspan="3">Traveler: ${currentlist.traveler.travelerName}</td>
				</tr>
				<c:forEach var="listVal" items="${currentlist.listOfDestinations}">
					<tr>
						<td></td>
						<td colspan="3">${listVal.country},${listVal.city}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToDestination"> <input
			type="submit" value="delete" name="doThisToDestination"> <input
			type="submit" value="add" name="doThisToDestination">
	</form>
	<a href="addDestinationsForListServlet">Create a new List</a>
	<a href="index.html">Insert a new destination</a>
</body>

</body>
</html>