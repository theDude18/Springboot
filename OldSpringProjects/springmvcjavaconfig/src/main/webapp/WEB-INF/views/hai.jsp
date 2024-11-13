<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hai da dhoni</title>
</head>
<body>
	Welcome to SpringMVC from hai.jsp <br>
	<% String name=(String)request.getAttribute("name"); %>
	<% Integer id=(Integer)request.getAttribute("id"); %>
	<%= name  %> <br>
	 ${id}
</body>
</html>