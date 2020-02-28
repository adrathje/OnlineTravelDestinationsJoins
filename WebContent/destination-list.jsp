<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
h1 {
	border: 2px solid black;
	text-align: center;
}

table {
	style ="font-size: 20px;
	color: blue;
}
</style>
<body>
	<h1 style="width: 25%">The Travel Destination List</h1>
	<br />
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
		<br /> <br /> <input type="submit" value="Edit Destination"
			name="doThisToDestination"> <input type="submit"
			value="Delete Destination" name="doThisToDestination"> <input
			type="submit" value="Add Destination" name="doThisToDestination">
	</form>
</body>
</html>