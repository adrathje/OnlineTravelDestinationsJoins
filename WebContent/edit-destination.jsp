<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Destination</title>
<style>
h1 {
	text-align: center;
	border: 2px solid black;
}

form {
	text-align: center;
}
</style>
</head>
<body style="width: 35%">
	<h1>Edit Travel Destination</h1>
	<form action="editDestinationServlet" method="post">
		Country: <input type="text" name="country"
			value="${destinationToEdit.country}"> City: <input
			type="text" name="city" value="${destinationToEdit.city}"> <input
			type="hidden" name="id" value="${destinationToEdit.id}"> <br />
		<br /> <input type="submit" value="Save Edited Destination">
	</form>
</body>
</html>