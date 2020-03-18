<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Message</title>
	</head>
	<body>
		<center>
			<h2><%=request.getAttribute("message") %></h2>
			<h3><a href="FileDisplayServlet">Click here To see the uploaded Pic</a></h3>
		</center>
	</body>
</html>