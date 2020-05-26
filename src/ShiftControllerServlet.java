

import java.io.IOException;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class ShiftControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ShiftDbUtil shiftDbUtil;
	
	@Resource(name="jdbc/employeemanagement")
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listShift(request, response);
				break;
				
			case "ADD":
				addShift(request, response);
				break;
				
			default:
				listShift(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}



	private void addShift(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read shift info from form data
		String name = request.getParameter("shift_Name");
		String day = request.getParameter("days");
		String start = request.getParameter("start_at");
		String end = request.getParameter("end_at");

		
		// create a new shift object
		Shift theShift = new Shift(name,day,start,end);
		
		// add the student to the database
		shiftDbUtil.addShift(theShift);
				
		// send back to main page (the student list)
		listShift(request, response);
	}

	private void listShift(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get shift from db util
		List<Shift> shifts = shiftDbUtil.getShift();
		
		// add students to the request
		request.setAttribute("SHIFT_LIST", shifts);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
	}

}

