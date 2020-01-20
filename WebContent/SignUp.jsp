<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

  <!-- Bootstrap core CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<title>Add Employee</title>
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
              <a class="nav-link" href="home.jsp">Employee Management<span class="sr-only">(current)</span></a>
           </li>
			<li class="nav-item">
			  <a class="nav-link" href="employee.jsp">Salary</a>
			</li>
			<li class="nav-item">
			  <a class="nav-link" href="#">Roster Management</a>
			</li>
			<li class="nav-item">
			  <a class="nav-link" href="generateReport.html">Reports </a>
			</li>
		  </ul>
		</div>
      </nav> 
<h1>Add New Admin

</h1>
        <br><br><br>
 <div class="container-fluid" >  
        <form action="addAdmin" method="post">  

                <div class="form-row">
           
                  <div class="form-group col-md-3">
                    <label for="inputName">Name</label>
                    <input type="text" name="name" class="form-control" id="inputName" value="" placeholder="Name" required="true">
                  </div>
                   <div class="form-group col-md-3">
                    <label for="inputName">Username</label>
                    <input type="text" name="username" class="form-control" id="inputusername" value="" placeholder="Username" 
                    required="true">
                  </div>
                  <div class="form-group col-md-2" ;">
                    <label for="inputAge">Age</label>
                    <input type="text" name="age" class="form-control" id="inputAge" value=""  placeholder="Age" required="true">
                  </div>
                </div>
                <div class="form-row">

					<div class="form-group col-md-4">
                    <label for="inputName">Password</label>
                    <input type="password" name="password" class="form-control" id="inputName" value="" placeholder="Password" 
                    required="true">
                  </div>
                  
</div>
                <!-- Drop Downs-->
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="sel1">Designation:</label>
                        <select class="form-control" name="designation" id="sel1" value="" >
                          <option>Admin</option>
                          <option>Finance Manager</option>
                          <option>HR Manager</option>
                          <option>General Manager</option>
                          <option>Marketing Manager</option>
                        </select>
                    </div>

                    <div class="form-group col-md-4">
                            <label for="sel1">Department:</label>
                            <select class="form-control" name="department" id="sel1" value="" >
                              <option>Account & Finance</option>
                              <option>Production</option>
                              <option>Marketing</option>
                              <option>Research and Development</option>
                              <option>Human Resource Management</option>
                              <option>Purchasing</option>
                            </select>
                        </div>
                </div>
                
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputAddress">Address</label>
                        <input type="text" name="address" class="form-control" id="inputAddress" value=""  placeholder="1234 Main St"
                         required="true">
                    </div>
                    <div class="form-group col-md-2">
                        <label for="inputCN">Contact Number:</label>
                        <input type="text" name="contactno" class="form-control" id="inputCN" value=""  placeholder="07XXXXXXXX" 
                         maxlength="10"  required="true">
                    </div>
                </div>

                <div class="form-row">
                  <div class="form-group col-md-4">
                    <label for="inputmail">Email</label>
                    <input type="email" name="email" class="form-control" value="" id="inputemail" required="true">
                  </div>
                  <div class="form-group col-md-4">
                    <label for="inputState">Joined date:</label>
                    <input type="date" name="joineddate" class="form-control" value="" id="inputdate" required="true">
                  </div>
                </div>

			<input type="submit" value="Add Admin">
        </form>
</div>
</body>
</html>