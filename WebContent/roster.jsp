<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="ISO-8859-1">
		<!-- Bootstrap core CSS -->
		<link
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
			rel="stylesheet">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
			integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
			crossorigin="anonymous"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
			integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
			integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
			crossorigin="anonymous"></script>

		
		<!-- validation-->
		<script>  
		function validateform(){  
		var date=document.form.date.value;  
		var empid=document.form.empid.value;  
		var uname=document.form.uname.value;  
		var dept=document.form.dept.value;  
		var designation=document.form.designation.value;  
		var duty=document.form.duty.value;  
		
		 
		if (designation==null || designation=="")
		{  
		  alert("Designation can't be empty");  
		  return false;  
		}  
		
		else if (empid==null || empid=="")
		{  
		  alert("Employee Id can't be empty");  
		  return false;  
		} 
		
		else if (isNaN(empid))
		{
			  alert("Enter numeric value only for employee id");  
			  return false;
		}
		
		else if (uname==null || uname=="")
		{  
		  alert("username can't be empty");  
		  return false;  
		}
		
		else if (dept==null || dept=="")
		{  
		  alert("Department can't be empty");  
		  return false;  
		}
		
		else if (duty==null || duty=="")
		{  
		  alert("duty can't be empty");  
		  return false;  
		}
		
		
		
		
		}  
		</script>  

<title>Update Attendance</title>
</head>
<body>
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
						  <a class="nav-link" href="ro">Roster Management</a>
						</li>
						<li class="nav-item">
						  <a class="nav-link" href="generateReport.html">Reports <span class="sr-only">(current)</span></a>
						</li>
					  </ul>
					</div>
			</nav>
			<br>
					<div class="container-fluid">
			<div class="row">
			
			<div class="col"></div>
			<div class="col">
				<h3>Details of Employee</h3>	
					<form action="SaveServlet" method="post" onsubmit="return validateform()">
					
						<div class="form-group">
							<label>Date :</label> <input type="date"
								name="date" class="form-control" value=""
								placeholder="Date" required="true">
						</div>
						
						<div class="form-group">
							<label>Employee ID :</label> <input type="text"
								name="empid" class="form-control"  value=""
								placeholder="Employee id" required="true">
						</div>
						
						<div class="form-group">
							<label>Username :</label> <input type="text"
								name="uname" class="form-control"  value=""
								placeholder="Username" required="true">
						</div>
						
						<div class="form-group">
							<label>Department :</label> <input
								type="text" name="dept" class="form-control" 
								value="" placeholder="Department" required="true">
						</div>
						
						<div class="form-group">
							<label>Designation :</label> <input
								type="text" name="designation" class="form-control" 
								value="" placeholder="Designation" required="true">
						</div>
						
						<div class="form-group">
							<label>Duty :</label> <select
								class="form-control" name="duty"  value="w">
								<option value="w">9:00a.m. to 5.00p.m.</option>
								<option value="sl">Short Leave</option>
								<option value="l">Leave</option>
							</select>
						</div>
						
						<input type="submit" value="Update Roster" class="btn btn-success">
					</form>
					<br>
					<form action="ViewAttendServlet">				
					<a class="btn btn-primary" href="ViewAttendServlet" role="button">View Attend of Employees</a>
					</form>
				</div>
				<div class="col"></div>
				
				</div>
			</div>
</body>
</html>