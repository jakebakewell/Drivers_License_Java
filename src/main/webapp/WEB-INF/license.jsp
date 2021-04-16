<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>License</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
	<div class="container text-center">
		<h1>New License</h1>
		<form action="/index/license" method="post" class="d-flex flex-column">
			<label for="number" class="form-label">License Number</label>
			<input type="text" id="number" name="number"/>
			<label for="expirationDate" class="form-label">Expiration Date</label>
			<input type="date" id="expirationDate" name="expirationDate"/>
			<label for="state" class="form-label">License State</label>
			<input type="text" id="state" name="state"/>
			<input type="hidden" name="person" value="${person.id}"/>
			<input type="submit" value="Submit" class="btn btn-success mt-3"/>
		</form>
<!-- 		<form:form action="/index/license" method="post" modelAttribute="license">
		    <p>
		        <form:label path="">First Name</form:label>
		        <form:errors path="firstName"/>
		        <form:input path="firstName"/>
		    </p>
		    <p>
		        <form:label path="lastName">Last Name</form:label>
		        <form:errors path="lastName"/>
		        <form:input path="lastName"/>
		    </p>    
		    <input type="submit" value="Submit" class="btn btn-success mt-3"/>
		</form:form> -->
	</div>
</body>
</html>