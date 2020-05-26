

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Emp e=EmpDao.getEmployeeById(id);
		
		
		out.print("<html>");
		out.print("<head>");
		
		//css
		
		out.print("<style>");
		
		
		out.print("input[type=text], select {width: 100%;padding: 12px 20px;margin: 8px 0;display: inline-block;border: 1px solid #ccc;border-radius: 4px;box-sizing: border-box;}");

		out.print("input[type=submit] {width: 100%;background-color: #0770FE;color: white;padding: 14px 20px;margin: 8px 0;border: none;border-radius: 4px;cursor: pointer;}");

		out.print("input[type=submit]:hover { background-color: #0770FE;}");

		out.print(".box{margin: auto;width: 20%;border-radius: 10px;background-color: #f2f2f2;padding: 20px;}");

		
		
		
		
				
		
		out.print(".button {background-color: #4CAF50; width: 10%;font-size:15px; color: white; padding: 14px 20px; margin: 8px 0; border: none;border-radius: 4px; cursor: pointer;font-family:sans-serif;}");
		
		out.print("ul{list-style-type: none; margin: 0; padding: 0; overflow: hidden;background-color: #343A40; position: -webkit-sticky; position: sticky;top: 0;}");

		out.print("li {float: left;}");

		out.print("li a {display: block;color: white;text-align: center;padding: 14px 16px;text-decoration: none; font-family:sans-serif;}");

		out.print("li a:hover { background-color: #111;}");
		
		
		out.print("</style>");
		out.print("</head>");
		out.print("<body>");
		

		
		
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
		out.print("<a href='#'>Reports</a>");
		out.print("</li>");
		out.print("</ul>");
		out.print("<br>");
		
		out.println("<div class='box'>");
		out.println("<h2>Update Employee Category</h2>");
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
		out.print("<tr><td><b>Designation</b></td><td><input type='text' name='designation' value='"+e.getDesignation()+"'/></td></tr>");
		out.print("<tr><td><b>Bonus</b></td><td><input type='text' name='bonus' value='"+e.getBonus()+"'/></td></tr>");
		out.print("<tr><td><b>Allowances</b></td><td><input type='text' name='allowances' value='"+e.getAllowances()+"'/></td></tr>");
		out.print("<tr><td><b>O/T Rate</b></td><td><input type='text' name='otrate' value='"+e.getOtrate()+"'/></td></tr>");
		out.print("<tr><td><b>Federal</b></td><td><input type='text' name='federal' value='"+e.getFederal()+"'/></td></tr>");
		out.print("<tr><td><b>State</b></td><td><input type='text' name='state' value='"+e.getState()+"'/></td></tr>");
		
		
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.println("</div>");
		
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
}
