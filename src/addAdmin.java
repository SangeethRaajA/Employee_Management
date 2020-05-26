

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addAdmin
 */
@WebServlet("/addAdmin")
public class addAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addAdmin() {
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
		
		String name = request.getParameter("name");
		String un = request.getParameter("username");
		String pass = request.getParameter("password");
		String password = null ;
		//encrypting password
		Hash encrypt = new Hash(); 
		try {
			password = encrypt.generateHash(pass);
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String designation = request.getParameter("designation");
		String department = request.getParameter("department");
		int age = Integer.parseInt(request.getParameter("age"));
		String contact = request.getParameter("contactno");
		String date = request.getParameter("joineddate");
		

		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "Tw12_02");
			
			
			
			String queryString = "INSERT INTO Admin(UserName,Password,Name,Age,Address,ContactNo,Email,DateJoined,Designation,Department) VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?)";
			PreparedStatement pstatement = conn.prepareStatement(queryString);
			pstatement.setString(1, un);
			pstatement.setString(2, password);
			pstatement.setString(3, name);
			pstatement.setInt(4, age);
			pstatement.setString(5, address);
			pstatement.setString(6, contact);
			pstatement.setString(7, email);
			pstatement.setString(8, date);
			pstatement.setString(9, designation);
			pstatement.setString(10, department);
			
			int updateQuery = pstatement.executeUpdate();
			response.sendRedirect("SignUp.jsp");
	
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	
	}

}



