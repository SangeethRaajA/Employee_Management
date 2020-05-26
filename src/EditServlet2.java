

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);//string parse to int
		
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
		e.setId(id);
		e.setDesignation(designation);
		e.setBonus(bonus);
		e.setAllowances(allowances);
		e.setOtrate(otrate);
		e.setFederal(federal);
		e.setState(state);
		
		
		
		int status=EmpDao.update(e);
		if(status>0){
			response.sendRedirect("ViewServlet");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
