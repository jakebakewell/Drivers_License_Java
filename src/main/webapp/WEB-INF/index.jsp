<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
	<div class="text-center">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>Name</th>
					<th>License Number</th>
					<th>License Expiration Date</th>
					<th>License State</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${people}" var="person">
	        	<tr class="table-info">
		            <td><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></td>
		            <td><c:out value="${person.license.number}"/></td>
		            <td><c:out value="${person.license.expirationDate}"/></td>
		            <td><c:out value="${person.license.state}"/></td>
		            <td><a href="/license/${person.id}">Add License</a></td>
	        	</tr>
	        	</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container text-center">
		<h1>New Person</h1>
		<form:form action="/index/person" method="post" modelAttribute="person">
		    <p>
		        <form:label path="firstName">First Name</form:label>
		        <form:errors path="firstName"/>
		        <form:input path="firstName"/>
		    </p>
		    <p>
		        <form:label path="lastName">Last Name</form:label>
		        <form:errors path="lastName"/>
		        <form:input path="lastName"/>
		    </p>    
		    <input type="submit" value="Submit" class="btn btn-success mt-3"/>
		</form:form>
	</div>
</body>
</html>