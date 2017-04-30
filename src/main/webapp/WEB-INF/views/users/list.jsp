<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Virtual Office | Users</title>
</head>
<body>

	<h1>List of Users</h1>
	<h3>${message}</h3>
	<div>
		<h1>Users List</h1>
		<table border="1">
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Username</td>
				<td>Address</td>
				<td>Created Date</td>
				<td>Email</td>
				<td>Mobile</td>
				<td>Status</td>
				<td>Role</td>
				<td>Action</td>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.firstName} ${user.lastName}</td>
					<td>${user.username}</td>
					<td>${user.address}</td>
					<td>${user.createdDate}</td>
					<td>${user.email}</td>
					<td>${user.mobile}</td>
					<td>${user.status}</td>
					<td>${user.role.name}</td>
					<td><a href="/voffice/users/delete/${user.id}">Delete</a> | <a
						href="/voffice/users/edit/${user.id}">Edit</a> | <a href="">View</a></td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<a href="/voffice/users/add">Add Users</a>
		</div>
	</div>

</body>
</html>