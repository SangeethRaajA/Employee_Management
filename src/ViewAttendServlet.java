

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ViewAttendServlet")
public class ViewAttendServlet extends HttpServlet {
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
				
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Attendance</title>");
		
		//css
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
		
		
		
		
		out.print("</style>");
		out.print("</head>");
		
		out.print("<body>");
		
		//navigation bar
		
		out.print("<ul>");
		out.print("<li>");
		out.print("<a href='#'>EMS</a>");
		out.print("</li>");
		out.print("<li>");
		out.print("<a href='#'>Employee Management</a>");
		out.print("</li>");
		out.print("<li>");
		out.print("<a href='employee.jsp'>Salary</a>");
		out.print("</li>");
		out.print("<li>");
		out.print("<a href='rooster.html'>Rooster Management</a>");
		out.print("</li>");
		out.print("<li>");
		out.print("<a href='generateReport.html'>Reports</a>");
		out.print("</li>");
		out.print("</ul>");
		
		
		out.println("<h1>Employee Attendance</h1>");
		
		List<Att> list=AttendDBhandler.getAttendById();
		out.println("<div style='overflow-x:auto;'>");
		out.print("<table align='center' id='salary' width='80%'");
		out.print("<tr><th>Date</th><th>EmployeeID</th><th>UserName</th><th>Designation</th><th>Department</th><th>Duty</th><th>Update</th></tr>");
		
		//retrieve data
		for(Att e:list){
			out.print("<tr><td>"+e.getC_Date()+"</td><td>"+e.getEmployeeID()+"</td><td>"+e.getName()+"</td><td>"+e.getDesignation()+"</td><td>"+e.getDepartment()+"</td><td>"+e.getDuty()+"</td><td><a href='UpdateEmpServlet?id="+e.getEmployeeID()+"'>Update</a></td></tr>");
		}
		out.print("</table>");
		out.print("</div>");
				
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
