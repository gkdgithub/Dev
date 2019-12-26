<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Employee Management</title>
	</head>
	<body>
		<center>
			<h2>Registration Form</h2>
			&nbsp;&nbsp;&nbsp;
			<h2><a href='<c:url vale="/list"></c:url>'></a></h2>
		</center>
		<div align="center">
					
		    <form:form action="save" method="POST" modelAttribute="employee">
		        <form:input type="hidden" readonly="readonly" path="id" id="id"/>
		        <table>
		            <tr>
		                <td><label for="name">Name: </label> </td>
		                <td><form:input path="name" id="name"/></td>
		                <td><form:errors path="name" cssClass="error"/></td>
		            </tr>
		         	
		         	<tr>
		                <td><label for="gender">Gender: </label> </td>
		                <td><form:input path="gender" id="gender"/></td>
		                <td><form:errors path="gender" cssClass="error"/></td>
		            </tr>
		         	
		         	<tr>
		                <td><label for="dob">Date of Birth : </label> </td>
		                <td><form:input path="dob" id="dob"/></td>
		                <td><form:errors path="dob" cssClass="error"/></td>
		            </tr>
		         	
		            <tr>
		                <td><label for="doj">Joining Date: </label> </td>
		                <td><form:input path="doj" id="doj"/></td>
		                <td><form:errors path="doj" cssClass="error"/></td>
		            </tr>
		     		
		     		<tr>
		                <td><label for="email">Email: </label> </td>
		                <td><form:input path="email" id="email"/></td>
		                <td><form:errors path="email" cssClass="error"/></td>
		            </tr>
		     		
		            <tr>
		                <td><label for="salary">Salary: </label> </td>
		                <td><form:input path="salary" id="salary"/></td>
		                <td><form:errors path="salary" cssClass="error"/></td>
		            </tr>
		     
		            <tr>
		                <td colspan="3" align="center">              
		                     <input type="submit" value="Register"/>     
		                </td>
		            </tr>
		        </table>
		    </form:form>
					
		</div>
	</body>
</html>