<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Page</title>
<style>
.navbar {
	height: 33px;
	border-bottom: none;
	background-color: #3b986d;
}

.head {
	list-style: none;
	margin: 0px 0px;
}

.navbar li a {
	float: left;
	margin: 5px 10px;
	text-decoration: none;
	color: white;
}

.topnav {
	background-color: #3b986d;
	margin-bottom: 10px;
}

.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 25px;
}

.topnav a:hover {
	background-color: beige;
	color: black;
}

h1 {
	padding: 60px;
	text-align: center;
	background: #009999;
	border-radius: 5px;
	color: white;
	font-size: 30px;
	margin-top: 0px
}

table {
	margin-top: 220px;
	padding: 40px;
	border-radius: 5px;
	box-shadow: 0 0 10px #000;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	width: 650px;
	height: 320px;
	background-color: rgba(21, 134, 119, 0.301);
	font-family: verdana;
	color: black;
	font-style: normal;
	font-size: 16px;
	font-weight: bold;
	border-spacing: 0.5em;
}

table.inner {
	border: 10px;
}

button {
	padding: 3px 10px;
	background-color: #77d6a8;
	border-radius: 5px;
}

button:hover {
	background-color: #009999;
}
</style>
</head>
<body>
	<header> <nav class="navbar">
	<ul class="head">
		<li><a href="http://localhost:9090/index">HOME</a></li>
		<!--<li><a href="about.html" target="_blank">CONTACT</a></li>-->
		<!-- <li><a href="Services.html" target="_blank">ABOUT</a></li>-->
		<li><a href="http://localhost:9090/register">REGISTER</a></li>
		<li><a href="http://localhost:9090/user">LOGIN</a></li>
		<li style="float: right; margin-right: 30px;"><a
			href="http://localhost:9090/help">HELP</a></li>
	</ul>
	</nav> </header>
	<h1>New User Registration</h1>
	<div style="padding-left: 50px;">
		<form action="userRegister1" method="post"
			onsubmit="return validateForm()">
			<table style="margin-left: auto; margin-right: auto;">
				<tr>
					<td><b>First Name :</b></td>
					<td><input class="input" type="text" id="firstName"
						name="first_name" placeholder="enter your first name" size="30"></td>
				</tr>
				<tr>
					<td><b>Last Name :</b></td>
					<td><input type="text" id="last_name" name="lastName"
						placeholder="enter your last name" size="30"></td>
				</tr>
				<tr>
					<td><b>DoB :</b></td>
					<td><input type="date" id="Dob" name="dob"
						placeholder="enter your dob" size="30"></td>
				</tr>
				<tr>
					<td><b>Gender :</b></td>
					<td><input type="radio" name="gender" value="male">Male
						<input type="radio" name="gender" value="female">Female</td>
				</tr>
				<tr>
					<td><b>Contact Number:</b></td>
					<td><input type="tel" id="contact" name="contact"
						placeholder="enter your contact number" pattern="[7-9]{1}[0-9]{9}"
						title="The number should be 10 digits starting with 7/8/9."
						size="30"></td>
				</tr>
				<tr>
					<td><b>User ID:</b></td>
					<td><input type="text" id="userID" name="userId"
						placeholder="Enter your User ID" size="30"></td>
				</tr>
				<tr>
					<td><b>Password :</b></td>
					<td><input type="password" id="Password" name="password"
						placeholder="enter your password"
						pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).{8,}"
						title="Must contain at least one number, one uppercase,lowercase letter,special character(@#$%&) and at least 8 or more characters"
						size="30"></td>
				</tr>
				<tr>
					<td><b>Email: </b></td>
					<td><input type="email" placeholder="Enter Email" name="email"
						id="email" pattern="[a-zA-Z0-9]+@[a-zA-Z0-9]+.com"
						title="Enter in this form abc@gmail.com" size="30"></td>
				</tr>
				<tr>
					<td><b>UserCategory</b></td>
					<td><select id="user_category" name="userCategory">
							<option value="doctor">Doctor</option>
							<option value="patient">Patient</option>
					</select></td>
				</tr>
				<tr>
					<td><b>Enter your childhood nick name :</b></td>
					<td><input class="input" type="text" id="nickname"
						name="nickname" placeholder="Enter your Childhood nick name"
						size="30"></td>
				</tr>
				<tr>
					<td>Enter your first pet's name :</td>
					<td><input type="text" id="petname" name="petname"
						placeholder="Enter your first pet's name" size="30"></td>
				</tr>
				<tr>
					<td>Enter the name of the place where you born :</td>
					<td><input type="text" id="bornplace" name="bornplace"
						placeholder="Enter the name of the place " size="30"></td>
				</tr>

				<tr>
					<td></td>
					<td><button type="submit" required>Register</button></td>
				</tr>

			</table>
		</form>

	</div>

	<script>
		function validateForm() {
			//alert("Inside validateForm");

			var userFirstName = document.getElementById("first_name").value;
			if (userFirstName == null || userFirstName == "") {
				alert("Please update the highlighted mandatory fields!");
				document.getElementById('first_name').style.borderColor = "red";
				return false;
			}
			var userLastName = document.getElementById("last_name").value;
			if (userLastName == null || userLastName == "") {
				alert("Please update the highlighted mandatory fields!");
				document.getElementById('last_name').style.borderColor = "red";
				return false;
			}
			var userDob = document.getElementById("Dob").value;
			if (userDob == null || userDob == "") {
				alert("Please update the highlighted mandatory fields!");
				document.getElementById('Dob').style.borderColor = "red";
				return false;
			}

			var dateString = document.getElementById('Dob').value;
			var myDate = new Date(dateString);
			var today = new Date();
			if (myDate > today) {
				alert("You cannot enter a date in the future!");
				return false;
			}

			var userContact = document.getElementById("Contact").value;
			if (userContact == null || userContact == "") {
				alert("Please update the highlighted mandatory fields!");
				document.getElementById('Contact').style.borderColor = "red";
				return false;
			}
			var userID = document.getElementById("userID").value;
			if (userID == null || userID == "") {
				alert("Please update the highlighted mandatory fields!");
				document.getElementById('userID').style.borderColor = "red";
				return false;
			}
			var userPassword = document.getElementById("Password").value;
			if (userPassword == null || userPassword == "") {
				alert("Please update the highlighted mandatory fields!");
				document.getElementById('Password').style.borderColor = "red";
				return false;
			}
			var userEmail = document.getElementById("Email").value;
			if (userEmail == null || userEmail == "") {
				alert("Please update the highlighted question fields!");
				document.getElementById('email').style.borderColor = "red";
				return false;
			}
			var userCategory = document.getElementById("user_category").value;
			if (userCategory == null || userCategory == "") {
				alert("Please update the highlighted mandatory fields!");
				document.getElementById('user_category').style.borderColor = "red";
				return false;
			}
			var userGender = document.getElementsByName("Gender");
			var temp = 0;
			for (i = 0; i < userGender.length; i++) {
				if (userGender[i].checked) {
					temp = 1;
				}
			}
			if (temp == 0) {
				alert("Please update the highlighted mandatory fields!");
				//document.getElementById('userGender').style.borderColor = "red";
				return false;
			}
			var nickname = document.getElementById("nickname").value;
			if (nickname == null || nickname == "") {
				alert("Please update the highlighted question fields!");
				document.getElementById('nickname').style.borderColor = "red";
				return false;
			}

			var petname = document.getElementById("petname").value;
			if (petname == null || petname == "") {
				alert("Please update the highlighted question fields!");
				document.getElementById('petname').style.borderColor = "red";
				return false;
			}

			var bornplace = document.getElementById("bornplace").value;
			if (bornplace == null || bornplace == "") {
				alert("Please update the highlighted question fields!");
				document.getElementById('bornplace').style.borderColor = "red";
				return false;
			}

		}
	</script>
</body>
</html>