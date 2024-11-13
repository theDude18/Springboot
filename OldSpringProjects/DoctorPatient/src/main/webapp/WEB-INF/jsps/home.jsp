<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style>
.navbar{      
            height: 33px;
            border-bottom: none;
            background-color:#003848;
             
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
	padding: 22px;
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

.container {
	padding: 16px;
	background-color: white;
}

.button {
	background-color: #010611;
	font-size: 15px;
	color: white;
	padding: 10px 10px;
	margin: 15px 0;
	cursor: pointer;

}
img{
              height: 250px !important;
              width: 100%;
              padding: 0px;
}
/*body{
  background-image: url('health.jpg');
}*/
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
			<b>Health Inspector</b>
		</h1>
	</div>
	<div>
		<center>
			<a href="admin" class="row"><h3>ADMIN</h3></a><br>
		</center>
		<center>
			<a href="user" class="row"><h3>USER</h3></a><br>
		</center>
	</div>
	<div></div>
	<!--End of nav-->
	<!--	<img src="health.jpg" class="img-responsive" alt="Responsive image" style = "background-size: cover;"> 	-->
	
		<!--<div class="col-sm-2"></div>-->
	
</body>
</html>