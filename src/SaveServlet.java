

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String designation=request.getParameter("designation");
		
		String sbonus=request.getParameter("bonus");
		double bonus=Double.parseDouble(sbonus);//string parse to double
		
		String sallowances=request.getParameter("allowances");
		double allowances=Double.parseDouble(sallowances);
		
		String sotrate=request.getParameter("otrate");
		double otrate=Double.parseDouble(sotrate);
		
		String sfederal=request.getParameter("federal");
		double federal=Double.parseDouble(sfederal);
		
		String sstate=request.getParameter("state");
		double state=Double.parseDouble(sstate);
		
		
	
		
		Emp e=new Emp();
		e.setDesignation(designation);
		e.setBonus(bonus);
		e.setAllowances(allowances);
		e.setOtrate(otrate);
		e.setFederal(federal);
		e.setState(state);
		
		
		
		int status=EmpDao.save(e);
		if(status>0){
			//print alert msg
			out.print("<script>alert('Record saved successfully!')</script>");
			request.getRequestDispatcher("category.jsp").include(request, response);
		}else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
	}

	
	
	/*
	 * 
	 * 

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
						
		String date=request.getParameter("date");  
		        
        String sid=request.getParameter("empid");  
        int empid=Integer.parseInt(sid);
        
        String name=request.getParameter("uname");  
        
        String dept=request.getParameter("dept");  
        
        String design=request.getParameter("designation");  
        
        String duty=request.getParameter("duty");  
		
		
	
		Att a=new Att();
        
        a.setC_Date(date);
    	a.setEmployeeID(empid);
    	a.setName(name);
    	a.setDepartment(dept);
    	a.setDesignation(design);
    	a.setDuty(duty);
		
		
		int status=AttendDBhandler.AddAttend(a);
		if(status>0){
			out.print("<script>alert('Record saved successfully!')</script>");
			request.getRequestDispatcher("roster.jsp").include(request, response);
		}else{
			out.println("Sorry! unable to save record");
			
		}
		
		out.close();
	}

}

	 * 
	 */
	
	
}
