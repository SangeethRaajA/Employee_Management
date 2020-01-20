<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>

<%@ page import ="java.sql.PreparedStatement" %>


<%@ page import ="java.sql.ResultSet" %>
<%@ page import ="java.sql.Statement" %>
<%@ page import ="java.sql.Statement" %>
<%@ page import ="java.util.ArrayList" %>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Salary Calculator</title>
	
	
	
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
  padding: 0.5px 0.5px;
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

.box1{
 margin: auto;
  width: 60%;
  border-radius: 10px;
  background-color: #f2f2f2;
  padding: 3px;
  
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

<%

//connect database
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "Tw12_02");

	String id=request.getParameter("id");
	

	String name=request.getParameter("name");
	
	
	PreparedStatement statementName= conn.prepareStatement("SELECT name FROM employee1 where eid='"+id+"'");
	ResultSet resultName= statementName.executeQuery();
	ArrayList<String> arrayName=new ArrayList<String>();
	
	while(resultName.next())
	{
		name=resultName.getString("name");
		
	}
	
	
	String designation=request.getParameter("designation");
	
	PreparedStatement statementDesignation= conn.prepareStatement("SELECT designation FROM employee1 where eid='"+id+"'");
	ResultSet resultDesignation= statementDesignation.executeQuery();
	ArrayList<String> arrayDesignation=new ArrayList<String>();
	
	
	while(resultDesignation.next())
	{
		designation=resultDesignation.getString("designation");
		
	}
	
	String shours=request.getParameter("hours");
	
	PreparedStatement statementHours= conn.prepareStatement("SELECT hours FROM salary where eid='"+id+"'");
	ResultSet resultHours= statementHours.executeQuery();
	ArrayList<String> arrayHours=new ArrayList<String>();
	
	
	while(resultHours.next())
	{
		shours=resultHours.getString("hours");
		
	}
	int hours=Integer.parseInt(shours);
	

	
	String srate=request.getParameter("rate");
	
	PreparedStatement statementRate= conn.prepareStatement("SELECT rate FROM salary where eid='"+id+"'");
	ResultSet resultRate= statementRate.executeQuery();
	ArrayList<String> arrayRate=new ArrayList<String>();
	
	
	while(resultRate.next())
	{
		srate=resultRate.getString("rate");
		
	}
	double rate=Double.parseDouble(srate);

	
	String sothours=request.getParameter("othours");
	
	PreparedStatement statementOTHours= conn.prepareStatement("SELECT othours FROM salary where eid='"+id+"'");
	ResultSet resultOTHours= statementOTHours.executeQuery();
	ArrayList<String> arrayOTHours=new ArrayList<String>();
	
	
	while(resultOTHours.next())
	{
		sothours=resultOTHours.getString("othours");
		
	}
	int othours=Integer.parseInt(sothours);
	

	
	
	String sbonus=request.getParameter("bonus");
	
	
	PreparedStatement statementBonus= conn.prepareStatement("SELECT bonus FROM category where designation='"+designation+"'");
	ResultSet resultBonus= statementBonus.executeQuery();
	ArrayList<String> arrayBonus=new ArrayList<String>();
	
	
	while(resultBonus.next())
	{
		sbonus=resultBonus.getString("bonus");
		
	}
	double bonus=Double.parseDouble(sbonus);
	
	
	
	
	String sallowances=request.getParameter("allowances");
	
	
	PreparedStatement statementAllowances= conn.prepareStatement("SELECT allowances FROM category where designation='"+designation+"'");
	ResultSet resultAllowances= statementAllowances.executeQuery();
	ArrayList<String> arrayAllowances=new ArrayList<String>();
	
	
	while(resultAllowances.next())
	{
		sallowances=resultAllowances.getString("allowances");
		
	}
	double allowances=Double.parseDouble(sallowances);
	
	
	
	
	

	
	String sotrate=request.getParameter("otrate");
	
	
	PreparedStatement statementOtrate= conn.prepareStatement("SELECT otrate FROM category where designation='"+designation+"'");
	ResultSet resultOtrate= statementOtrate.executeQuery();
	ArrayList<String> arrayOtrate=new ArrayList<String>();
	
	
	while(resultOtrate.next())
	{
		sotrate=resultOtrate.getString("otrate");
		
	}
	double otrate=Double.parseDouble(sotrate);
	
	
	
	
	
	
	String sfederal=request.getParameter("federal");
	
	
	PreparedStatement statementFederal= conn.prepareStatement("SELECT federal FROM category where designation='"+designation+"'");
	ResultSet resultFederal= statementFederal.executeQuery();
	ArrayList<String> arrayFederal=new ArrayList<String>();
	
	
	while(resultFederal.next())
	{
		sfederal=resultFederal.getString("federal");
		
	}
	double federal=Double.parseDouble(sfederal);
	
		
	
	
	
	String sstate=request.getParameter("state");
	
	
	PreparedStatement statementState= conn.prepareStatement("SELECT state FROM category where designation='"+designation+"'");
	ResultSet resultState= statementState.executeQuery();
	ArrayList<String> arrayState=new ArrayList<String>();
	
	
	while(resultState.next())
	{
		sstate=resultState.getString("state");
		
	}
	double state=Double.parseDouble(sstate);
	
	
	//calculation
	
	
	double grossPay= rate * hours;
	double otAmount= otrate * othours;
	double tax1=federal/100;
	double federalTax= tax1 * grossPay;
	double tax2=state/100;
	double stateTax=tax2 * grossPay;
	double deduction= federalTax + stateTax;
	double netPay = (grossPay+otAmount+bonus+allowances) - deduction;

%>
<div class="box1">

<table align="center">
	<tr>
		<td><h5>Employee Details</h5></td>
		
	</tr>
	
	
	<tr>
		<td>Employee ID</td>
		<td><input type="text" name="id" value="<%=id%>" disabled="disabled"></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>Employee Name</td>
		<td><input type="text" name="name" value="<%=name%>" disabled="disabled"></td>
	</tr>
	<tr>
		
		<td>Designation</td>
		<td><input type="text" name="designation" value="<%=designation%>" disabled="disabled"></td>
	</tr>
	
	<tr>
		<td><h5>Hours & Rates</h5></td>
	</tr>
	
	<tr>
		<td>Number of hours worked</td>
		<td><input type="text" name="hours" value="<%=hours%>" disabled="disabled"></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>Rates per working hour</td>
		<td><input type="text" name="rate" value="<%=rate%>" disabled="disabled"></td>
	</tr>
	
	<tr>
		<td>Number of O/T hours</td>
		<td><input type="text" name="othours" value="<%=othours%>" disabled="disabled"></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>Rates per O/T hour</td>
		<td><input type="text" name="otrate" value="<%=otrate%>" disabled="disabled"></td>
	</tr>
	
		
	
	<tr>
		<td><h5>Other</h5></td>
	</tr>
	<tr>
		<td>Bonus</td>
		<td><input type="text" name="bonus" value="<%=bonus%>" disabled="disabled"></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>Other Allowances</td>
		<td><input type="text" name="allowances" value="<%=allowances%>" disabled="disabled"></td>
	</tr>
	
	<tr>
		<td>Percentage Federal tax</td>
		<td><input type="text" name="federal" value="<%=federal%>" disabled="disabled"></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>Percentage State tax</td>
		<td><input type="text" name="state" value="<%=state%>" disabled="disabled"></td>
	</tr>
	
	<tr>
		<td><h5>Salary Calculation</h5></td>
	</tr>
	
	<tr>
		<td>Gross Pay</td>
		<td><input type="text" value="<%=grossPay%>"  readonly></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>O/T Amount</td>
		<td><input type="text" value="<%=otAmount%>" readonly></td>
	</tr>
	
	<tr>
		<td>Total Deduction</td>
		<td><input type="text" value="<%=deduction%>" readonly></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>Net Salary</td>
		<td><input type="text" value="<%=netPay%>" readonly></td>
	</tr>
	
	<tr>
		<td>&nbsp;</td>
	</tr>
	

	
	<tr>
	<form name="form1" method="post" action="slip.jsp">	
		<td><input type="submit" value="Print"></td>
</form>

</table>

</div>
</body>
</html>