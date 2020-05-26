

import java.io.IOException;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateAttendServlet
 */

public class UpdateAttendServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;


    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
    }
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
         PrintWriter out=response.getWriter();  
        out.println("<h1>Update Attendance</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Att e=AttendDBhandler.getAttendById(id);          
       
        out.print("<form action='UpdateAttendServlet2' method='post'>");         
        out.print("<div class='form-group'>"); 
        out.print("<label>Duty :</label>");  
        out.print("<select name='duty' value='"+e.getDuty()+"'>"); 
        out.print("	<option>9:00a.m. to 5.00p.m.</option>"); 
        out.print(" <option>Short Leave</option>"); 
        out.print(" <option>Leave</option>"); 
        out.print("	</select>"); 
        out.print("	</div>"); 
        out.print("	<div class='form-group'>"); 
        out.print("	<label>Date :</label> "); 
        out.print(" <input type='date' name='date' value='"+e.getC_Date()+"'"); 
        out.print("	placeholder='Name' required='true'>"); 
        out.print("	</div>"); 
        out.print("	<input type='submit' value='Update' class='btn btn-success'>");

        out.print("</form>"); 
          
        out.close();  
        
    }

}
