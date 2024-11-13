<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Resistration Successful</title>
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

h2{
    
text-transform: capitalize;
margin-bottom: .5em;
font-size: 6rem;
color:  #3b986d;
text-shadow: 0px 2px 4px #009999;

}

.row {
	width: 10%;
	padding: 15px;
	text-align: center;
	margin: 0px auto;
	display: inline-block;
	line-height: 10px;
	text-decoration: none;
	background-color: #3b986d;
	border-radius: 5px;
	color: white;
	font-size: 20px;
}

</style>
</head>
<body>
<header>
        <nav class="navbar navbar-expand-md">
         <ul class="head">
             <li><a href="http://localhost:9090/index">HOME</a></li>
             <li><a href="http://localhost:9090/register">REGISTER</a></li>
             <li><a href="http://localhost:9090/user">LOGIN</a></li>
                <li style="float:right; margin-right:30px;"><a href="http://localhost:9090/help">HELP</a></li>
         </ul>
        </nav>
     </header>
<center><h1  style="text-align:center;">Congratulations User!</h1>
<h2 style="text-align:center;font-size: 40px;">New User Created successfully </h2></center>
<center><a href="userlogin" class="row">Go to login</a></center><br>
</body>
</html>