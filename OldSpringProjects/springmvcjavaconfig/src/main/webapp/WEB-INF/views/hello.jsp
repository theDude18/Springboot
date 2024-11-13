<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      //To use EL this directive tag is needed in this version
<html>
<head>
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello</title>
</head>
<body>
	<% int id=(int)request.getAttribute("id");    //Integer id=(Integer)request.getAttribute("id"); .Integer is an inbuilt Class same like "int" datatype
	   String name=(String)request.getAttribute("name");
	   int salary=(int)request.getAttribute("salary");
	   //out.println(id);
	   //out.println(name);
	   //out.println(salary);
	 %>
	   
	<%= id %>            //Here it is possible to use only bcoz of getAttribute
	<%= name %>
	<%= salary %>
	
	<br>
	ID: <b>${id} </b>           //Here u can use Expression language directly to print without getAttribute but u need to import a directive tag above
	Name: <b> ${name} </b> 
	Salary: <b> ${salary} </b> 
</body>
</html>