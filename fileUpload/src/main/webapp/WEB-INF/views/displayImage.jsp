<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@page import="com.quinnox.fileUpload.model.Image" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Image Displayed</title>
	</head>
	<body>
		<div align="center">
			<h3><c:out value="${image.fileName}"></c:out></h3>
			<img src="data:image/jpg;base64,${image.base64Image}" width="650" height="410"/>
		</div>
	</body>
</html>