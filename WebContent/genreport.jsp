<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import = "java.sql.Connection"%>
<%@ page import = "java.sql.DriverManager"%>
<%@ page import = "java.sql.PreparedStatement"%>
<%@ page import = "java.sql.ResultSet"%>
<html>
<head>


<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Overall Employee Report</title>
</head>
<body>


<%
try{

Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "Tw12_02");

PreparedStatement st = conn.prepareStatement("select * from employee");
ResultSet rs = st.executeQuery();


PreparedStatement stat = conn.prepareStatement("select * from salreport");
ResultSet res = stat.executeQuery();
%>
<center>
<h1>Overall Employees' Report</h1></center>
<h5><a style="margin-left: 90%;font-weight:bold;" href="generateReport.html">Go Back</a></h5>
<table class="table ">
<thead class="thead-dark">
  <tr>
    <th scope="col">#</th>
    <th scope="col">Name</th>
    <th scope="col">Designation</th>
    <th scope="col">Department</th>
     <th scope="col">NetSalary</th>
  </tr>
</thead>
<% 
while (rs.next() && res.next())
{	%>
		<td><%=rs.getString("EmployeeID")%></td>
		<td><%=rs.getString("Name")%></td>
		<td><%=rs.getString("Designation")%></td>
		<td><%=rs.getString("Department")%></td>		
		<td><%=res.getString("netSal")%></td>
		</tr>


<%
}
}
catch (Exception e){
System.out.println(e);
}
%>



</body>
</html>