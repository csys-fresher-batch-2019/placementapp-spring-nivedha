<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD CLIENT COMPANY</title>
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
<form action="AddClientCompanyServ" autocomplete="off">
<div style="text-align:centre">
<pre>
<br></br>
<h1 style="color:white; font-size:30px; font-family:courier; text-align:centre;">                             ADD COMPANY DETAILS</h1>
<%String errorMessage = (String)request.getAttribute("errorMessage");
if(errorMessage !=null)
{%>
<font color="red" style="font: bold" size="5"><center><%=errorMessage%></center></font>
<%}%>

<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Company Name        <input type="text" name="name" required autofocus/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Company Type        <input type="text" name="type" placeholder="software" required/>  
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Company Address     <input type="text" name="address"  required/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Contact Number      <input type="text" name="mobileno"  required/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Contact Person      <input type="text" name="person"  required/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Email Id            <input type="email" name="email"  required/>
</pre>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">                     <button type="submit" >ADD</button><br></br>
</div>
<br/><br/>
</form>
</body>
</html>