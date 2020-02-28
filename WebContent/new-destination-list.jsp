<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a list</title>
</head>
<body>
	<form action="editExistingListServlet" method="post">
		List Name: <input type="text" name="listName" type="text"
			name="travelerName" value="${listToEdit.traveler.travelerName}"><br />
		<input type="hidden" name="id" value="${listToEdit.id}">
		Current Destinations:<br /> <select name="currentDestinations"
			multiple size="6">
			<c:forEach var="listVal" items="${listToEdit.listOfItems}">
				<option value="${listVal.id}">${listVal.country}|
					${listVal.city}</option>
			</c:forEach>
		</select> <br /> Remaining Destinations:<br /> <select
			name="destinationsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allDestinationsToAdd}"
				var="currentdestination">
				<option value="${currentdestination.id}">${currentdestination.country}|
					${currentdestination.city}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Edit List and Edit Destinations">
	</form>
	<a href="index.html">Go add new destinations instead.</a>
</body>

</html>