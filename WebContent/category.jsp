<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Category</title>



	<!-- nav bar-->
	
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

 

  <!-- Bootstrap core CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	
	
	
<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {

  width: 100%;
  background-color: #007BFF;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  
}

input[type=submit]:hover {
  background-color: #0770FE;
}

.box{
  margin: auto;
  width: 31%;
  border-radius: 10px;
  background-color: #f2f2f2;
  padding: 20px;
  
}
.box1{
  margin: auto;
  width: 31%;
  background-color:white;

  
}
</style>

</head>
<body>



<!-- nav bar-->
	
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">EMS</a>
		
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		  <span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
                
            <li class="nav-item">
              <a class="nav-link" href="AddEmplpyee.html">Employee Management</a>
           </li>
			<li class="nav-item">
			  <a class="nav-link" href="employee.jsp">Salary</a>
			</li>
			<li class="nav-item">
			  <a class="nav-link" href="rooster.html">Roster Management</a>
			</li>
			<li class="nav-item">
			  <a class="nav-link" href="generateReport.html">Reports <span class="sr-only">(current)</span></a>
			</li>
		  </ul>
		</div>
</nav>
<br>
<!-- validation-->
	

<script>  
function validateform(){  
var designation=document.form.designation.value;  
var bonus=document.form.bonus.value;  
var allowances=document.form.allowances.value;  
var otrate=document.form.otrate.value;  
var federal=document.form.federal.value;  
var state=document.form.state.value;  


if (designation==null || designation=="")
{  
  alert("Designation can't be blank");  
  return false;  
}  

else if (bonus==null || bonus=="")
{  
  alert("Bonus can't be blank");  
  return false;  
} 

else if (isNaN(bonus))
{
	  alert("Enter numeric value only for bonus");  
	  return false;
}

else if (allowances==null || allowances=="")
{  
  alert("Allowances can't be blank");  
  return false;  
}  

else if (isNaN(allowances))
{
	  alert("Enter numeric value only for allowances");  
	  return false;
}

else if (otrate==null || otrate=="")
{  
  alert("O/T rate can't be blank");  
  return false;  
}  

else if (isNaN(otrate))
{
	  alert("Enter numeric value only for O/T rate");  
	  return false;
}

else if (federal==null || federal=="")
{  
  alert("Federal can't be blank");  
  return false;  
}  


else if (isNaN(federal))
{
	  alert("Enter numeric value only for federal");  
	  return false;
}

else if (state==null || state=="")
{  
  alert("State can't be blank");  
  return false;  
}  

else if (isNaN(state))
{
	  alert("Enter numeric value only for state");  
	  return false;
}


}  
</script>  

<!-- Add employee category-->
	
<div class="box">
<h2>Add New Employee Category</h2>
<form name="form" action="SaveServlet" method="post" onsubmit="return validateform()">
<table>
<tr><td><b>Designation</b></td><td><input type="text" name="designation" placeholder="Designation"/></td></tr>
<tr><td><b>Bonus</b></td><td><input type="text" name="bonus" placeholder="Bonus"/></td></tr>
<tr><td><b>Allowances</b></td><td><input type="text" name="allowances" placeholder="Allowances"/></td></tr>
<tr><td><b>O/T Rate</b></td><td><input type="text" name="otrate" placeholder="O/T Rate"/></td></tr>
<tr><td><b>Federal</b></td><td><input type="text" name="federal" placeholder="Federal"/></td></tr>
<tr><td><b>State</b></td><td><input type="text" name="state" placeholder="State"/></td></tr>



<tr><td colspan="2"><input type="submit" value="Save Employee"/></td></tr>
</table>
</form>
</div>

<br/>
<div class="box1">
<form action="ViewServlet">

		<tr>
			
			<td><input type="submit" value="View Employee Categories"></td>
		</tr>
	
	
</form>
</div>
</body>
</html>