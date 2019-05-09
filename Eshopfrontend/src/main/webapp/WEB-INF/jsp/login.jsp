<%@ page language="java" contentType="text/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<form class="form-inline" action="perform_login" method="post">
	<center>
	<div class="container" style="padding-left:500px; padding-right: 500px;">
	<br><br><br><br><b>LOGIN</b>
	</div>
	<br><br><br>
	<div class="container" style="padding-left:400px; padding-right: 400px;">
	<div class="col-lg-6; style="padding-left:1000px; padding-right: 1000px;">
		
    		<div class="input-group">
     		 <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
		<input 
		type="text"  
		name="username" 
		class="form-control"
		placeholder="username"
		 pattern="[A-Za-z0-9_.]+"
		
		required/>
		</div>
		<br><br>
		
		<div class="input-group">
      		<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
      		<input id="password" 
      		type="password"  
      		name="password"
      		class="form-control"
      		 placeholder="Password"/>
      		
  		</div>
		<br><br>
		<button type="button" class="btn btn-link">Forgot Password?</button> 
		<br><br>
		<Center><button>SUBMIT</button></Center>
	</div>
	</div>
		</center>
		</form>
</body>
</html>
		