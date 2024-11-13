<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
</head>
<body>

<style>
.navbar{
            
            height: 33px;
            border-bottom: none;
            background-color: #3b986d;
        }
        .head{
            list-style: none;
            margin: 0px 0px;
        }
        .navbar li a{
            float: left;
            margin: 5px 10px;
            text-decoration: none;
            color: white;
        }
h1 {
	padding: 60px;
	text-align: center;
	background: #009999;
	border-radius: 5px;
	color: white;
	font-size: 30px;
  margin-top: 0px;
}


table {
	margin: auto auto;
	padding: 40px;
	border-radius: 5px;
	box-shadow: 0 0 10px #000;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	width: 450px;
	height: 320px;
	background-color: rgba(21, 134, 119, 0.301);
	font-family: verdana;
	color: black;
	font-style: normal;
	font-size: 16px;
	font-weight: bold;
}

.topnav{
    background-color:#3b986d;
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
  background-color : beige;
  color: black;
}

button{
    padding : 3px 10px ;
    background-color: #77d6a8;
    border-radius: 5px;
}
button:hover{
    background-color: #009999;
}


</style>
</head>
<body>
  <header>
    <nav class="navbar navbar-expand-md">
     <ul class="head">
         <li><a href="http://localhost:9090/index">HOME</a></li>
         <!--<li><a href="about.html" target="_blank">CONTACT</a></li>-->
        <!-- <li><a href="Services.html" target="_blank">ABOUT</a></li>-->
         <li><a href="http://localhost:9090/register">REGISTER</a></li>
         <li><a href="http://localhost:9090/user">LOGIN</a></li>
            <li style="float:right; margin-right:30px;"><a href="http://localhost:9090/help">HELP</a></li>
     </ul>
    </nav>
 </header>
<h1 style="text-align:center;">User Login</h1>
<div style="padding-left:50px;">
  <form  action="dashboard" method="post" onsubmit="return validateForm()">
    <table style="margin-left:auto;margin-right:auto;">
       <tr>
         <td><b>User ID :</b></td>
         <td><input type="text" id="userid" name="userid" placeholder="enter your user ID" ></td>
       </tr>
       
       <tr>
         <td><b>Password :</b></td>
         <td><input type="password" id="password" name="password" placeholder="enter your password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).{8,}" title="Must contain at least one number, one uppercase,lowercase letter,special character(@#$%&) and at least 8 or more characters"></td>
       </tr>
 	  
       
       <tr>
       <td><b>UserCategory</b></td>
        <td><select id="user_category" name="user_category">
        		       <option value="admin">Admin</option>
       			       <option value="doctor">Doctor</option>
       			       <option value="patient">Patient</option>
                    </select></td>
                    </tr>
                      <tr>
                 <td>   <p style="color:red;">${message} </p> </td>
                    </tr>
                    <tr>
       	 <td></td>
         <td><button type="submit" required>Login</button></td>
       </tr>
       <tr>
       	 <td><a href="retriveUserId">Retrive user id</a></td>
         <td><a href="forgetPassword">Forget Password</a></td>
       </tr>
       
    </table>
  </form>
    
</div>



<script>  
	 function validateForm(){  
		 
		//alert("Inside validate");
		var userId=document.getElementById("userid").value;
		if(userId==null || userId=="" ){  
			  alert("Please update the highlighted mandatory fields!");  
			  document.getElementById('userid').style.borderColor = "red";
			  return false;  
		}
		var userPassword=document.getElementById("password").value;
		if(userPassword==null || userPassword=="" ){  
			  alert("Please update the highlighted mandatory fields!");  
			  document.getElementById('password').style.borderColor = "red";
			  return false;  
		}
		var user_category=document.getElementById("user_category").value;
		if(user_category==null || user_category=="" ){  
			  alert("Please update the highlighted mandatory fields!");  
			  document.getElementById('user_category').style.borderColor = "red";
			  return false;  
		}
		
	 }		
</script>

</body>
</html>