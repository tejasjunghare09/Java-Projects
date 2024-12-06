<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
</head>
<body style="text-align: center;">
	<h2>Add New User</h2>
	<form method="post" action="register.jsp">
		FirstName : <input type="text" name="firstName"> <br> <br>
		Last Name : <input type="text" name="lastName"/> <br> <br>
		Email : <input type="email" name="email"/> <br> <br>
		Password : <input type="password" name="password"/> <br> <br>
		Date of Birth : <input type="date" name="dob"/> <br> <br>
	
		<input type="submit" value=" Add User">
		<input type="reset" value= "Reset">
		
	</form>
	<p> 
		<a href="index.jsp">Sign In</a>
	</p>
</body>
</html>
