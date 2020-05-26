/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Intel
 */
public class UpdateEmpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Emp e=EmpDatabaseHandler.getEmployeeById(id);
		
		out.print("<html>");
		out.print("<head>");
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
		out.print("<a href='ViewEmpServlet'>Employee Management</a>");
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
		out.print("<form action='update' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getEmpId()+"'/></td></tr>");
		out.print("<tr><td><b>Name</b></td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
		out.print("<tr><td><b>Age</b></td><td><input type='text' name='age' value='"+e.getAge()+"'/></td></tr>");
		out.print("<tr><td>Designation:</td><td>");  
        out.print("<select name='designation' value='"+e.getDesignation()+"' style='width:150px'>");  
        out.print("<option>HR</option>");  
        out.print("<option>Accountatant</option>");  
        out.print("<option>Receptionist</option>");  
        out.print("<option>Intern</option>");
        out.print("<option>Consultant</option>");
        out.print("<option>Minor Staff</option>"); 
        out.print("</select>");  
        out.print("</td></tr>");
        
        out.print("<tr><td>Department:</td><td>");  
        out.print("<select name='department'value='"+e.getDepartment()+"' style='width:150px'>");  
        out.print("<option>Account & Finance</option>");  
        out.print("<option>Production</option>");  
        out.print("<option>Marketing</option>");  
        out.print("<option>Reserch and Development</option>");
        out.print("<option>Human Resourse Management</option>");
        out.print("<option>Purchasing</option>");
        out.print("</select>");  
        out.print("</td></tr>");
        
		out.print("<tr><td><b>Address</b></td><td><input type='text' name='address' value='"+e.getAddress()+"'/></td></tr>");
		out.print("<tr><td><b>ContactNo</b></td><td><input type='text' name='contactno' value='"+e.getContactno()+"'/></td></tr>");
		out.print("<tr><td><b>Email</b></td><td><input type='text' name='email' value='"+e.getEmail()+"'/></td></tr>");
		out.print("<tr><td><b>Date Joined</b></td><td><input type='date' name='joineddate' value='"+e.getJoineddate()+"'/></td></tr>");
		
		
		out.print("<tr><td colspan='2'><input type='submit' value='Update'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.println("</div>");
		
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

}
