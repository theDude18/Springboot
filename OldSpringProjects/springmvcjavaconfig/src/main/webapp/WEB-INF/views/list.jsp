<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.karthi.springmvc.dto.Employee,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Display</title>
</head>
<body>
	<% ArrayList<Employee> employee=(ArrayList<Employee>)request.getAttribute("empo"); 
	   out.println(employee);
	%>

</body>
</html>