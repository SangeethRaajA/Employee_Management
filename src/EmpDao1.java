
import java.util.*;
import java.sql.*;

public class EmpDao1{

	public static Connection getConnection(){
		Connection con =null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//connect database
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "Tw12_02");
		}catch(Exception e){System.out.println(e);}
		return con;
	}

	public static Emp1 getEmployeeById(int id){
		Emp1 e=new Emp1();
		
		try{
			Connection con=EmpDao1.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from salreport where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			System.out.println(rs.next());
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setEId(rs.getString(2));
				e.setGross(rs.getDouble(3));
				e.setOtAmount(rs.getDouble(4));
				e.setDeduction(rs.getDouble(5));
				e.setNetSal(rs.getDouble(6));
			
				
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<Emp1> getAllEmployees(){
		List<Emp1> list=new ArrayList<Emp1>();
		
		try{
			Connection con=EmpDao1.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from salreport");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Emp1 e=new Emp1();
				e.setId(rs.getInt(1));
				e.setEId(rs.getString(2));
				e.setGross(rs.getDouble(3));
				e.setOtAmount(rs.getDouble(4));
				e.setDeduction(rs.getDouble(5));
				e.setNetSal(rs.getDouble(6));
			
				
				
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}

	
	}

