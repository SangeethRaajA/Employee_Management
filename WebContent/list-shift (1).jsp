<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>SHIFT LIST</title>
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
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
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
	
		<div id="content">
		
			<!-- put new button: Add shift -->
			
			<input type="button" value="Add Shift" 
				   onclick="window.location.href='add-shift-form.jsp'; return false;"
				   class="add-student-button"
			/>
			
			<table>
			
				<tr>
					<th>Shift Id</th>
					<th>Shift Name</th>
					<th>Days</th>
					<th>Start Time</th>
					<th>End time</th>
				</tr>
				
				<c:forEach var="tempShift" items="${SHIFT_LIST}">
					
					<tr>
						<td> ${tempShift.id} </td>
						<td> ${tempShift.name} </td>
						<td> ${tempShift.day} </td>
						<td> ${tempShift.start} </td>
						<td> ${tempShift.end} </td>
					</tr>
				
				</c:forEach>
					<tr>
						<td> 12</td>
						<td> alpah</td>
						<td> Monday Tuesday Wednesday Thursday Friday</td>
						<td> 09:00:AM</td>
						<td> 05:00:PM</td>
					</tr>
					<tr>
						<td> 13</td>
						<td> beta</td>
						<td> Satruday</td>
						<td> 09:00:AM</td>
						<td> 12:00:PM</td>
					</tr>
					
					<tr>
						<td> 14</td>
						<td> matrix</td>
						<td> Monday Tuesday Wednesday Thursday Friday Saturday</td>
						<td> 09:00:AM</td>
						<td> 12:00:PM</td>
					</tr>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








