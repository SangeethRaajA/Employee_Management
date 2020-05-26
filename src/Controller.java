

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		
		
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			//connect to database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "Tw12_02");
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee1 where eid='"+id+"'");
			
			
			
			while (rs.next()) {
				//valid employee id
				if (id.equals(rs.getString(1))) 
				{
					
					System.out.println("Valid Employee ID");
					RequestDispatcher rd=request.getRequestDispatcher("payroll.jsp");
					rd.forward(request, response);
				}
			
				//invalid employee id
				else
				{
					System.out.println("Invalid Employee ID");
					RequestDispatcher rd=request.getRequestDispatcher("error.jsp");  
            		rd.forward(request, response);
					
				}

			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		
		
		
		
	}
	

}
