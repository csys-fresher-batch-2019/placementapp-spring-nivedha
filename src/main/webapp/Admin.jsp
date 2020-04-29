<!DOCTYPE html>
<html lang="en">
<head>
  <title>ADMIN</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<style>
body {
  background-image: url('assets/images/image_3.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: cover;
}
</style>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li class="active"><a href="Index.jsp">HOME</a></li>
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">USER DETAILS <span class="caret"></span></a>
        <ul class="dropdown-menu">
          
                     <li><a href="ViewAllUsersServ">VIEW</a></li>
          
        </ul>
      </li>
      
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">COURSE DETAILS <span class="caret"></span></a>
        <ul class="dropdown-menu">
          
                     <li><a href="AddCourse.jsp">ADD</a></li>
          
        </ul>
      </li>
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">COMPANY DETAILS <span class="caret"></span></a>
        <ul class="dropdown-menu">
          
          <li><a href="CompanyDetailsServ">VIEW</a></li>
           <li><a href="AddClientCompany.jsp">ADD</a></li>
          
        </ul>
      </li>
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">TRAINER DETAILS <span class="caret"></span></a>
        <ul class="dropdown-menu">
        
           <li><a href="TrainerDetailsServ">VIEW</a></li>
          <li><a href="AddTrainer.jsp">ADD</a></li>
          
        </ul>
      </li>
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">INTERVIEW DETAILS <span class="caret"></span></a>
        <ul class="dropdown-menu">
           <li><a href="AddInterviewSchedule.jsp">ADD SCHEDULE</a></li>
           <li><a href="DisplayCategoryServ">ADD QUESTIONS</a></li>
           <li><a href="AllInterviewStatusServ">VIEW STATUS</a></li>
        </ul>
      </li>
     
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">GRADE <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="ViewGradeServ">VIEW GRADE</a></li>
        </ul>
      </li>
      
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="Index.jsp"><span class="glyphicon glyphicon-user"></span> Sign Out</a></li>
<!--       <li><a href="AdminLogin.html"><span class="glyphicon glyphicon-log-in"></span>Sign In</a></li>
 -->    </ul>
  </div>
</nav>
</body>
</html>