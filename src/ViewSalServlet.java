

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ViewSalServlet")
public class ViewSalServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		

		
		List<Emp1> list=EmpDao1.getAllEmployees();
		//start html page
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Salary Report</title>");
		
		//css
		out.print("<style>");
				
		
		out.print(".button {background-color: #0770FE; width: 10%;font-size:15px; color: white; padding: 14px 20px; margin: 8px 0; border: none;border-radius: 4px; cursor: pointer;font-family:sans-serif;}");
		
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
		out.print("<a href='#'>Rooster Management</a>");
		out.print("</li>");
		out.print("<li>");
		out.print("<a href='generateReport.html'>Reports</a>");
		out.print("</li>");
		out.print("</ul>");


		
		
		
		out.println("<h1>Salary Report</h1>");
		out.println("<div style='overflow-x:auto;'>");
		out.print("<table id='salary' width='100%'>");
		
		out.print("<tr><th><font size='4'>Id</font></th><th><font size='4'>Employee Id</font></th><th><font size='4'>Gross Pay</font></th><th><font size='4'>O/T Amount</font></th><th><font size='4'>Deduction</font></th><th><font size='4'>Net Salary</font></th></tr>");
		
		//retrieve 
		for(Emp1 e:list){
			out.print("<tr><td><font size='4'>"+e.getId()+"</font></td><td><font size='4'>"+e.getEId()+"</font></td><td><font size='4'>"+e.getGross()+"</font></td><td><font size='4'>"+e.getOtAmount()+"</font></td><td><font size='4'>"+e.getDeduction()+"</font></td><td><font size='4'>"+e.getNetSal()+"</font></td></tr>");
		}
		
		out.print("</table>");
		out.print("</div>");
		out.print("<br>");
		out.print("<form method='post' action='slip.jsp'>");
		out.print("<input type='submit' value='Print' class='button'>");
		out.print("</form>");
		out.print("</body>");
		
		
		out.close();
	}
}
