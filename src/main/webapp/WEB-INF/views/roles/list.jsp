<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Virtual Office | Role</title>
</head>
<body>

	<h1>List of Roles</h1>
	<h3>${message}</h3>
	<div>
		<h1>Roles List</h1>
		<table border="1">
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Description</td>
				<td>Action</td>

			</tr>
			<c:forEach items="${roles}" var="role">
				<tr>
					<td>${role.id}</td>
					<td>${role.name}</td>
					<td>${role.description}</td>
					<td><a href="/voffice/roles/delete/${role.id}" onclick="return confirm('Are you sure you want to delete? ')">Delete</a> | <a
						href="/voffice/roles/edit/${role.id}">Edit</a> | <a href="">View</a></td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<a href="/voffice/roles/add">Add Roles</a>
			<a href="#">Add Roles (Ajax)</a>
		</div>
	</div>

</body>
</html>