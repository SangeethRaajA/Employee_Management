
import java.util.*;
import java.sql.*;

public class EmpDao{

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//connect database
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "Tw12_02");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int save(Emp e){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			
			//insert
			PreparedStatement ps=con.prepareStatement("insert into category(designation,bonus,allowances,otrate,federal,state) values (?,?,?,?,?,?)");
			ps.setString(1,e.getDesignation());
			ps.setDouble(2,e.getBonus());
			ps.setDouble(3,e.getAllowances());
			ps.setDouble(4,e.getOtrate());
			ps.setDouble(5,e.getFederal());
			ps.setDouble(6,e.getState());
			
			
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(Emp e){
		int status=0;
		Connection con;
		try{
			 con=EmpDao.getConnection();
			 //update
			PreparedStatement ps=con.prepareStatement("update category set designation=?,bonus=?,allowances=?,otrate=?,federal=?,state=? where id=?");
			ps.setString(1,e.getDesignation());
			ps.setDouble(2,e.getBonus());
			ps.setDouble(3,e.getAllowances());
			ps.setDouble(4,e.getOtrate());
			ps.setDouble(5,e.getFederal());
			ps.setDouble(6,e.getState());
			
			
			ps.setInt(7,e.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		
		return status;
	}
	public static int delete(int id){
		int status=0;
		Connection con;
		try{
			 con=EmpDao.getConnection();
			 //delete
			PreparedStatement ps=con.prepareStatement("delete from category where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static Emp getEmployeeById(int id){
		Emp e=new Emp();
		
		try{
			Connection con=EmpDao.getConnection();
			//retrieve 
			PreparedStatement ps=con.prepareStatement("select * from category where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setDesignation(rs.getString(2));
				e.setBonus(rs.getDouble(3));
				e.setAllowances(rs.getDouble(4));
				e.setOtrate(rs.getDouble(5));
				e.setFederal(rs.getDouble(6));
				e.setState(rs.getDouble(7));
				
				
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<Emp> getAllEmployees(){
		List<Emp> list=new ArrayList<Emp>();
		
		try{
			Connection con=EmpDao.getConnection();
			//retrieve 
			PreparedStatement ps=con.prepareStatement("select * from category");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Emp e=new Emp();
				e.setId(rs.getInt(1));
				e.setDesignation(rs.getString(2));
				e.setBonus(rs.getDouble(3));
				e.setAllowances(rs.getDouble(4));
				e.setOtrate(rs.getDouble(5));
				e.setFederal(rs.getDouble(6));
				e.setState(rs.getDouble(7));
				
				
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}
