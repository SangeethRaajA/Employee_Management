
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class checkeid
 */
@WebServlet("/checkeid")
public class checkeid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public checkeid() {
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

		int eid = Integer.parseInt(request.getParameter("eid"));

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root",
					"Tw12_02");

			PreparedStatement st = conn.prepareStatement("select * from employee where EmployeeID=" + eid);

			// st.setInt(1, eid);
			ResultSet rs = st.executeQuery();

			if (rs.next() == true) {

				String change = request.getParameter("eid");
				request.setAttribute("change", eid);
				request.getRequestDispatcher("/singleEmployee.jsp").forward(request, response);
			}

			else {
				response.sendRedirect("generateReport.html");

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
