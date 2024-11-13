<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js">
</script>
<script>
	$(document).ready(function() {
		$("#id").change(function() {
			$.ajax({

				url : "checkId",
				data : {
					id : $("#id").val()
				},
				success : function(responseText) {
					$("#errMsg").text(responseText);

					if (responseText != "") {
						$("#id").focus();
					}
				}
			});

		});

	});
</script>
<title>User Registration Page</title>
</head>
<body>
	<form action="registeredPage" method="post">
		<pre>
		Id:<input type="text" name="id" id="id" /><span id="errMsg"></span>    <!-- In input tag id attribute is must -->
		Name:<input type="text" name="name" />
		Email:<input type="text" name="email" />
		<input type="submit" name="Register" />
		</pre>
	</form>
	<br> ${user}
	<br> ${res}
	<br>
</body>
</html>