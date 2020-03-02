<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<style>
body {
  background-image: url('assets/images/bbg.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: cover;
}
</style>
<body>
<pre>
<br></br>
<h1 style="color:white; font-size:30px; font-family:courier; text-align:centre;">                                   LOGIN</h1>
</pre>
<form action="LoginServ">
<div style="text-align:center">
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Email Id  <input type="text" name="name"/>
<br/><br/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Password   <input type="password" name="password" placeholder="Enter password"/>
<br/><br/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;"><button type="submit">SIGN IN</button>
<a href="Register.jsp">                                                    <button type="button" class="btn btn-danger">SIGN UP</button>
</a>


</div>
</form>
</body>
</html>