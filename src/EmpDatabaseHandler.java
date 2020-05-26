
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDatabaseHandler {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "Tw12_02");
        
        }catch(Exception e){System.out.println(e);}  
        return con;  
    } 
	
    public static int AddEmp(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDatabaseHandler.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into employee(Name,Age,Address,ContactNo,Email,DateJoined,Designation,Department) values (?,?,?,?,?,?,?,?)");
                           
            ps.setString(1,e.getName());  
            ps.setString(2,e.getAge());  
            ps.setString(3,e.getAddress());  
            ps.setString(4,e.getContactno());  
            ps.setString(5,e.getEmail()); 
            ps.setString(6,e.getJoineddate()); 
            ps.setString(7,e.getDesignation()); 
            ps.setString(8,e.getDepartment()); 
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    } 
    
    public static int update(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDatabaseHandler.getConnection();  
            PreparedStatement ps=con.prepareStatement("update employee set Name=?,Age=?,Address=?,ContactNo=?,Email=?,DateJoined=?,Designation=?,Department=? where EmployeeID=?");  
                           
            ps.setString(1,e.getName());  
            ps.setString(2,e.getAge());  
            ps.setString(3,e.getAddress());  
            ps.setString(4,e.getContactno());
            ps.setString(5,e.getEmail()); 
            ps.setString(6,e.getJoineddate()); 
            ps.setString(7,e.getDesignation()); 
            ps.setString(8,e.getDepartment()); 
            ps.setInt(9,e.getEmpId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }
    
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=EmpDatabaseHandler.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from employee where EmployeeID=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }
    
    public static Emp getEmployeeById(int id){
        Emp e=new Emp();  
          
        try{  
            Connection con=EmpDatabaseHandler.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from employee where EmployeeID=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){ 
            	
                e.setEmpId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setAge(rs.getString(3));
                e.setAddress(rs.getString(4));
                e.setContactno(rs.getString(5));
                e.setEmail(rs.getString(6));
                e.setJoineddate(rs.getString(7));
                e.setDesignation(rs.getString(8));
                e.setDepartment(rs.getString(9));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }
    
    public static List<Emp> getAllEmployees(){  
        List<Emp> list=new ArrayList<Emp>();  
          
        try{  
            Connection con=EmpDatabaseHandler.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from employee");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();      
                e.setEmpId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setAge(rs.getString(3));
                e.setAddress(rs.getString(4));
                e.setContactno(rs.getString(5));
                e.setEmail(rs.getString(6));
                e.setJoineddate(rs.getString(7));
                e.setDesignation(rs.getString(8));
                e.setDepartment(rs.getString(9));
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  