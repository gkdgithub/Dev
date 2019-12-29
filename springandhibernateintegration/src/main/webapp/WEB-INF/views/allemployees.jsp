<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Employee Management</title>
	</head>
	<body>
		<center>
			<h2><a href='<c:url value="/new"></c:url>'>Add New Employee</a></h2>
			&nbsp;&nbsp;&nbsp;
			<h2>List of Employees</h2>
		</center>
		
		<div align="center">
			<table border="1" cellpadding="5">
				<caption>List of Employee</caption>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Gender</th>
					<th>DOB</th>
					<th>DOJ</th>
					<th>Email</th>
					<th>SALARY</th>
					<th>Actions</th>
				</tr>
				
				<c:forEach  items="${employees}" var="employee">
					<tr>
						<td><c:out value="${employee.id}"/></td>
						<td><c:out value="${employee.name}"/></td>
						<td><c:out value="${employee.gender}"/></td>
						<td><c:out value="${employee.dob}"/></td>
						<td><c:out value="${employee.doj}"/></td>
						<td><c:out value="${employee.email}"/></td>
						<td><c:out value="${employee.salary}"/></td>
						
						<td>
						<a href="edit?id=<c:out value='${employee.id}'></c:out>">Edit</a>
						&nbsp;&nbsp;&nbsp; 
						<a href="delete?id=<c:out value='${employee.id}'></c:out>">Delete</a>
						</td>					
					</tr>
				</c:forEach>
				
			</table>
		</div>
	</body>
</html>