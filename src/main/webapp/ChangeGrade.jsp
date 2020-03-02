<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Grade Details</title>
</head>
<body>
<style>
body {
  background-image: url('assets/images/bg_1.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: cover;
}
</style>
<body>
<form action="ChangeGradeServ">
<pre>
<br></br>
<h1 style="color:white; font-size:30px; font-family:courier; text-align:centre;">                            UPDATE INTERVIEW MARKS</h1>
</pre><pre>
<div style="text-align:center">
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">   MINIMUM MARKS    <input type="text" name="minmarks"/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">   MAXIMUM MARKS    <input type="text" name="maxmarks"/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">          STATUS    <input type="radio" name="status" value="selected" >SELECTED  
                  <input type="radio" name="status" value="rejected" >REJECTED
<p style="color:white; font-size:20px; font-family:courier;text-align:center;"><button type="submit" >UPDATE</button>
</div>
</pre>
</form>

</body>
</html>