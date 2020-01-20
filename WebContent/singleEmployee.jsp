<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>

<html>
<head>


<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Employee Report</title>
</head>
<body>


	<%
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root","Tw12_02");
			int value = (Integer) request.getAttribute("change");
			PreparedStatement st = conn.prepareStatement("select * from employee where EmployeeID=?");
			st.setInt(1, value);
			ResultSet rs = st.executeQuery();

			PreparedStatement stat = conn.prepareStatement("select * from salreport where eid=?");
			stat.setInt(1, value);
			ResultSet res = stat.executeQuery();

			while (rs.next() && res.next()) {
	%>
		
	<h1>Employee Report -<%=rs.getString("Name")%><h1>
	<center>
<h5><a style="margin-left: 90%;font-weight:bold;" href="generateReport.html">Go Back</a></h5>
</center>
			<table class="table">
				<tbody>
					<tr>
						<th>EmployeeID</th>
						<td><%=rs.getString("EmployeeID")%></td>

					</tr>
					<tr>
						<th>Name</th>
						<td><%=rs.getString("Name")%></td>

					</tr>
					<tr>
						<th>Designation</th>
						<td><%=rs.getString("Designation")%></td>

					</tr>
					<tr>
						<th>Department</th>
						<td><%=rs.getString("Department")%></td>

					</tr>
					<tr>
						<th>NetSalary</th>
						<td><%=res.getDouble("netSal")%></td>

					</tr>

				</tbody>
			</table>


			<%
				}
				} catch (Exception e) {
					e.printStackTrace();
				}
			%>
		
</body>
</html>