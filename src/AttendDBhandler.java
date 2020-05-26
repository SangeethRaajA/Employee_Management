

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AttendDBhandler {

			public static Connection getConnection(){  
		        Connection con=null;  
		        try{  
		            Class.forName("com.mysql.jdbc.Driver");
		            con = DriverManager.getConnection("jdbc:mysql80://localhost:3306/employeemanagement", "root", "sangeeth");
		        
		        }catch(Exception e){System.out.println(e);}  
		        return con;  
		    }  
			
			
		    public static int AddAttend(Att a){  
		        int status=0;  
		        try{  
		            Connection con=AttendDBhandler.getConnection();  
		            PreparedStatement ps=con.prepareStatement(  
		                         "insert into attend(C_Date,EmployeeID,Name,Department,Designation,Duty) values (?,?,?,?,?,?)");  
		            ps.setString(1,a.getC_Date());  
		            ps.setInt(2,a.getEmployeeID());  
		            ps.setString(3,a.getName());  
		            ps.setString(4,a.getDesignation());  
		            ps.setString(5,a.getDepartment()); 
		            ps.setString(6,a.getDuty());
		              
		            status=ps.executeUpdate();  
		              
		            con.close();  
		        }catch(Exception ex){ex.printStackTrace();}  
		          
		        return status;  
		    }  
		    
		    
		    public static int update(Att a){  
		        int status=0;  
		        try{  
		            Connection con=AttendDBhandler.getConnection();  
		            PreparedStatement ps=con.prepareStatement(  
		                         "update attend set C_Date=?,Duty=? where EmployeeID=?");  
		            ps.setString(1,a.getC_Date()); 
		            ps.setString(2,a.getDuty()); 
		            
		            status=ps.executeUpdate();  
		              
		            con.close();  
		        }catch(Exception ex){ex.printStackTrace();}  
		          
		        return status;  
		    }  
		    
		    
		    public static int delete(int id){  
		        int status=0;  
		        try{  
		            Connection con=AttendDBhandler.getConnection();  
		            PreparedStatement ps=con.prepareStatement("delete from attend where EmployeeID=?");  
		            ps.setInt(1,id);  	            
		            status=ps.executeUpdate();  
		              
		            con.close();  
		        }catch(Exception e){e.printStackTrace();}  
		          
		        return status;  
		    } 
		    
		    public static Att getAttendById(int id){  
		    	Att a=new Att();
		          
		        try{  
		            Connection con=AttendDBhandler.getConnection();  
		            PreparedStatement ps=con.prepareStatement("select * from attend where EmployeeID=?");  
		            ps.setInt(2,id);  
		            ResultSet rs=ps.executeQuery();  
		            if(rs.next()){  
		            	a.setC_Date(rs.getString(1));
		            	a.setEmployeeID(rs.getInt(2));
		            	a.setName(rs.getString(3));
		            	a.setDepartment(rs.getString(4));
		            	a.setDesignation(rs.getString(5));
		            	a.setDuty(rs.getString(6));
		            }  
		            con.close();  
		        }catch(Exception ex){ex.printStackTrace();}  
		          
		        return a;  
		    }
		    
		   public static List<Att> getAttendById(){  
		    	ArrayList<Att> list=new ArrayList<Att>();  
		          
		        try{  
		            Connection con=AttendDBhandler.getConnection();  
		            PreparedStatement ps=con.prepareStatement("select * from employee");  
		            ResultSet rs=ps.executeQuery();  
		            while(rs.next()){  
		            	Att a=new Att();  
		            	a.setC_Date(rs.getString(1));
		            	a.setEmployeeID(rs.getInt(2));
		            	a.setName(rs.getString(3));
		            	a.setDepartment(rs.getString(4));
		            	a.setDesignation(rs.getString(5));
		            	a.setDuty(rs.getString(6));  
		                list.add(a);  
		            }  
		            con.close();  
		        }catch(Exception e){e.printStackTrace();}  
		          
		        return list;  
		    }
	
}
