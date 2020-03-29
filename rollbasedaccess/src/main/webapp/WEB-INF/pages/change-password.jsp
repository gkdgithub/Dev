<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Change Password</title>
	</head>
	
	<body>
		<center>
			<h1>User Management Change Password</h1>
				<c:if test="${password!=null}">
					<h2><c:out value="${password}"></c:out></h2>
				</c:if>
		</center>
		<div align="center">
			<form action="ChangePassword" method="post">
				<table border="1" cellpadding="10">
				
					<tr>
						<th>Enter Old Password : </th>
						<td>
							<input type="password" name="oldPassword" size="40"></input>
						</td>
					</tr>
					<tr>
						<th>Enter New Password : </th>
						<td>
							<input type="password" name="EnterNewPassword" size="40"></input>
						</td>
					</tr>
					<tr>
						<th>Re-Enter New Password : </th>
						<td>
							<input type="password" name="ReEnterNewPassword" size="40"></input>
						</td>
					</tr>
					<tr>
						<td align="center">
							<input type="submit" value="Change"/>
						</td>
					</tr>
					
				</table>
			</form>
		</div>		
	</body>
	
</html>