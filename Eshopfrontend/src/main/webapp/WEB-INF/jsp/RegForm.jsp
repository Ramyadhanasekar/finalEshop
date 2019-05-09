<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>RegForm</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<form class="form-inline" action="addRegForm" method="post">

<center><b>${name}</b></center><br>
<center><b><u>REGISTRATION FORM</u></b></br></br></br>
Enter Username:
<input 
	type="text" 
	name="username" 
	pattern="[A-Za-z]+" 
	title="Enter only the alphabets between a to z"
	required/><br><br>
Enter Email id:
<input 
	type="text"  
	name="email" 
	pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" 
	title="Eg:abc@xyz.com"
	required/><br><br>
	Enter password:
	<input
	type="password"
	name="password"
	pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
	required/>
	
	
Enter Contact No:
<input type="text" name="number" pattern="[6-9]{1}[0-9]{9}" title="Enter 10 digit numbers, first digit should be from 6 to 9" required> </br></br>
<input type="submit" name="submit"/>
</table>
</center>
</form>
</body>
</html>
