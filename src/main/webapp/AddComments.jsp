<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD COMMENTS</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<style>
body {
	background-image: url('assets/images/feedbackbg.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
</style>
<body>
<form action="AddCommentsServlet">
</br>
<%String errorMessage = (String)request.getAttribute("errorMessage");
if(errorMessage !=null)
{%>
<center><font color="red"style="font:bold; size:'6'"><%=errorMessage%></center>
<%}%>
<center>
</br></br></br>
<div class="card text-black bg-light mb-3" style="width: 30rem; height: 28rem;">
</br></br>
<label><h2>STUDENTS FEEDBACK</h2></label>
</br>
  <div class="form-group row">
    <label for="exampleFormControlInput1" class="col-sm-3 col-form-label"><h6>YOUR ID</h6></label>
     <div class="col-sm-7">
    <input type="number" class="form-control" name="usercourseid" id="exampleFormControlInput1" placeholder="user_course_id">
  </div></div>
  <div class="form-group row">
    <label for="exampleFormControlSelect1" class="col-sm-3 col-form-label"><h6>RATING</h6></label>
    <div class="col-sm-7">
    <select class="form-control" name="rating" id="exampleFormControlSelect1">
      <option>1</option>
      <option>2</option>
      <option>3</option>
      <option>4</option>
      <option>5</option>
    </select>
    </div>
  </div>
  <div class="form-group row">
    <label for="exampleFormControlTextarea1" class="col-sm-3 col-form-label"><h6>COMMENTS</h6></label>
    <div class="col-sm-7">
    <textarea class="form-control" name="comments" id="exampleFormControlTextarea1" rows="5"></textarea>
  </div>
  </div>
    <center> <button type="submit" class="btn btn-primary">SUBMIT</button></center>  
  </div> 
</form>
</center>
</body>
</html>