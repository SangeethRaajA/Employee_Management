
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ShiftDbUtil {

	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql80://localhost:3306/employeemanagement", "root", "Tw12_02");
        
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }
	
	public List<Shift> getShift() throws Exception {
		
		List<Shift> shifts = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = ShiftDbUtil.getConnection();
			
			// create sql statement
			String sql = "select * shift";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String name = myRs.getString("shift_Name");
				String day = myRs.getString("days");
				String start = myRs.getString("start_at");
				String end = myRs.getString("end_at");
				
				
				
				// create new shift object
				Shift tempShift = new Shift(id,name,day,start,end);
				
				// add it to the list of students
				shifts.add(tempShift);			
			}
			
			return shifts;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addShift(Shift theShift) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = ShiftDbUtil.getConnection();
			
			// create sql for insert
			String sql = "insert into shift"
					+ "(shift_Name, days,start_at ,end_at )"
					+ "values (?, ?, ?, ?)";
						
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the shift
			myStmt.setString(1, theShift.getShift_Name());
			myStmt.setString(2, theShift.getDays());
			myStmt.setString(3, theShift.getStart_at());
			myStmt.setString(4, theShift.getEnd_at());
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}
}















