<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
	<title>Add Shift</title>
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

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">EMS</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">

				<li class="nav-item"><a class="nav-link" href="#">Employee Management</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Salary</a></li>
				<li class="nav-item"><a class="nav-link" href="rooster.html">Roster	Management<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="generateReport.html">Reports </a>
				</li>
			</ul>
		</div>
	</nav>
	
	<div id="container">

		<h3><br>Add shift</h3>
		
		<form action="ShiftControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
				
		
					<tr>
						<td><label>Shift name:</label></td>
						<td><input type="text" name="name" /></td>
					</tr>

					<tr>
		                <td><label>Date:</label></td>
		                <td ><input type="checkbox" name="day" value="Monday">Monday</input><br />
		                    <input type="checkbox" name="day" value="Tuesday">Tuesday</input><br />
		                    <input type="checkbox" name="day" value="Wednesday">Wednesday</input><br />
		                    <input type="checkbox" name="day" value="Thursday">Thursday</input><br />
		                    <input type="checkbox" name="day" value="Friday">Friday</input><br />
		                    <input type="checkbox" name="day" value="Satruday">Satruday</input><br />
		                </td> 
            		</tr>
            

					<tr>
						<td><label>Start Date:</label></td>
						<td><input type="time" name="start" /></td>
					</tr>
					
					<tr>
						<td><label>End Date:</label></td>
						<td><input type="time" name="end" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		
		<br>
		<a class="btn btn-primary" href="list-shift.jsp" role="button"><h3>View Shift</h3></a>
			
		
	</div>
</body>

</html>











