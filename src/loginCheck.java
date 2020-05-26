
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginCheck
 */
@WebServlet("/loginCheck")
public class loginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String un = request.getParameter("username");
		String pass = request.getParameter("password");
		Hash check = new Hash();
		String password = null;
		try {
			 password = check.generateHash(pass);
		} catch (NoSuchAlgorithmException e1) {
			
			e1.printStackTrace();
		}

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "Tw12_02");
			
			PreparedStatement st = conn.prepareStatement("select * from Admin where UserName=?");
			st.setNString(1, un);
			ResultSet rs = st.executeQuery();
			

			while (rs.next()) {
				if (un.equals(rs.getString(2)) && password.equals(rs.getString(3))) 
				{
					HttpSession session = request.getSession();
					session.setAttribute("username", un );
					response.sendRedirect("AddEmplpyee.html");
				}
				
				{
					
					response.sendRedirect("index.html");
				}

			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
