<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>
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
.heading {
padding: 30px;
text-align: center;
background: #009999;
border-radius: 5px;  
color: white;
font-size: 20px;

}

.row {
width: 20%;
padding: 15px;
text-align: center;
margin: 10px 0;
display: inline-block;
line-height: 20px;
text-decoration: none;
background-color: #3b986d;
border-radius:25px;
color: white;
font-size: 20px;
}

.row:hover{
    background-color: #009999;
}

.buttons{
    text-align: center;
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
 
<div class="heading">
    <h1>
        <b>Hello User</b>
    </h1>
</div>
<div class="buttons">
    
        <a href="userlogin" class="row"><h3>Login</h3></a><br>
    
   
        <a href="userregister" class="row"><h3>Register</h3></a><br>
    
</div>
<div></div>

</body>
</html>