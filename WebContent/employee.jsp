<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Calculate Salary</title>
	
	
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
  width: 40%;
  border-radius: 10px;
  background-color: #f2f2f2;
  padding: 20px;
  
}

.box1{
  margin: auto;
  width: 30%;
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
			  <a class="nav-link" href="#">Roster Management</a>
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
var id=document.myForm.id.value;  

if (id==null || id==""){  
  alert("Employee ID can't be blank");  
  return false;  
}
else if(id.length>=2){  
	  alert("Invalid Employee ID");  
	  return false;  
} 
  
   

}  
</script>  

<div class="box">

<form name="myForm" method="post" action="Controller"  onsubmit="return validateform()" >

	
		<h2>Calculate Salary</h2><br>
		<b>Employee ID</b><br/>
		<input type="text" name="id" placeholder="Employee ID">
		
	<table>
		
		<tr>
			<td>&nbsp;</td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Calculate" name="calculate"></td>
			
		</tr>
		
	</table>
	
</form>

</div>
<div class="box1">

<form action="ViewSalServlet">

	
	
	<input type="submit" value="Generate Salary Report">
</form>


<form method="post" action="category.jsp">

	<input type="submit" value="Employee Categories">
</form>
</div>



</body>
</html>