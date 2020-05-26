

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ViewServlet")
public class ViewEmpServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
				
		out.print("<html>");
		out.print("<head>");
		out.print("<style>");
				
		
		out.print(".button {background-color: #0770FE; width: 25%;font-size:15px; color: white; padding: 14px 20px; margin: 8px 0; border: none;border-radius: 4px; cursor: pointer;font-family:sans-serif;}");
		out.print(".green{color:#4CAF50}");
		out.print(".red{color:#FF0000}");
		out.print("ul{list-style-type: none; margin: 0; padding: 0; overflow: hidden;background-color: #343A40; position: -webkit-sticky; position: sticky;top: 0;}");

		out.print("li {float: left;}");

		out.print("li a {display: block;color: white;text-align: center;padding: 14px 16px;text-decoration: none; font-family:sans-serif;}");

		out.print("li a:hover { background-color: #111;}");
		
		
		out.print("table {border-collapse: collapse;width: 100%;}");

		out.print("th, td {padding: 8px;text-align: left;}");
		
		

		out.print("#salary tr:nth-child(even){background-color: #f2f2f2;}");

		out.print("#salary tr:hover {background-color: #ddd;}");

		out.print("#salary th {padding-top: 12px;padding-bottom: 12px;text-align: left;background-color: #343A40;color: white;}");
		
		out.print(".buttonn {\r\n" + 
				"  background-color: #4CAF50; /* Green */\r\n" + 
				"  border-radius: 8px;\r\n" + 
				"  color: white;\r\n" + 
				"  padding: 16px 32px;\r\n" + 
				"  text-align: center;\r\n" + 
				"  text-decoration: none;\r\n" + 
				"  display: inline-block;\r\n" + 
				"  font-size: 16px;\r\n" + 
				"  margin: 4px 2px;\r\n" + 
				"  -webkit-transition-duration: 0.4s; /* Safari */\r\n" + 
				"  transition-duration: 0.4s;\r\n" + 
				"  cursor: pointer;\r\n" + 
				"}");
		
		out.print(".button1 {\r\n" + 
				"  background-color: white; \r\n" + 
				"  color: black; \r\n" + 
				"  border: 2px solid #4CAF50;\r\n" + 
				"}\r\n" + 
				"");
		
		out.print(".button1:hover {\r\n" + 
				"  background-color: #4CAF50;\r\n" + 
				"  color: white;\r\n" + 
				"}");
		
		out.print("</style>");
		out.print("</head>");
		
		out.print("<body>");
		

		out.print("<ul>");
		out.print("<li>");
		out.print("<a href='#'>EMS</a>");
		out.print("</li>");
		out.print("<li>");
		out.print("<a href='ViewEmpServlet'>Employee Management</a>");
		out.print("</li>");
		out.print("<li>");
		out.print("<a href='employee.jsp'>Salary</a>");
		out.print("</li>");
		out.print("<li>");
		out.print("<a href='#'>Rooster Management</a>");
		out.print("</li>");
		out.print("<li>");
		out.print("<a href='generateReport.html'>Reports</a>");
		out.print("</li>");
		out.print("</ul>");
		
		
		out.println("<h1>Employee Category List</h1>");
		out.print("<form action='AddEmployee.html' method='post'>");
		out.print("<input type='submit' class='buttonn button1' value='Add Employee' href='AddEmployee.html'>");
		out.println("</form>");
		List<Emp> list=EmpDatabaseHandler.getAllEmployees();
		out.println("<div style='overflow-x:auto;'>");
		out.print("<table id='salary' width='100%'");
		out.print("<tr><th><font size='4'>Id</font></th><th><font size='4'>Name</font></th><th><font size='4'>Age</font></th><th><font size='4'>Contact No</font></th><th><font size='4'>Designation</font></th><th><font size='4'>Department</font></th><th><font size='4'>Joined Date</font></th><th><font size='4'>Address</font></th><th><font size='4'>Email</font></th><th><font size='4'>Edit</font></th><th><font size='4'>Delete</font></th></tr>");
		for(Emp e:list){
			out.print("<tr><td><font size='4'>"+e.getEmpId()+"</font></td><td><font size='4'>"+e.getName()+"</font></td><td><font size='4'>"+e.getAge()+"</font></td><td><font size='4'>"+e.getContactno()+"</font></td><td><font size='4'>"+e.getDesignation()+"</font></td><td><font size='4'>"+e.getDepartment()+"</font></td><td><font size='4'>"+e.getJoineddate()+"</font></td><td><font size='4'>"+e.getAddress()+"</font></td><td><font size='4'>"+e.getEmail()+"</font></td><td><a class='green' href='UpdateEmpServlet?id="+e.getEmpId()+"'><font size='4'>Edit</font></a></td><td><a class='red' href='DeleteEmpServlet?id="+e.getEmpId()+"'><font size='4'>Delete</font></a></td></tr>");
		}
		out.print("</table>");
		out.print("</div>");
		
	
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
}