

public class Att {

	private String C_Date;

	private int EmployeeID;

	private String Name;

	private String Designation;

	private String Department;

	private String Duty;
	
	public Att() {
		
	}

	public Att(String c_Date, int employeeID, String name, String designation, String department, String duty) {

		C_Date = c_Date;
		EmployeeID = employeeID;
		Name = name;
		Designation = designation;
		Department = department;
		Duty = duty;
	}

	public String getC_Date() {
		return C_Date;
	}

	public void setC_Date(String c_Date) {
		C_Date = c_Date;
	}

	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int empid) {
		EmployeeID = empid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getDuty() {
		return Duty;
	}

	public void setDuty(String duty) {
		Duty = duty;
	}

	@Override
	public String toString() {
		return "Att [C_Date=" + C_Date + ", EmployeeID=" + EmployeeID + ", Name=" + Name + ", Designation="
				+ Designation + ", Department=" + Department + ", Duty=" + Duty + "]";
	}

	

}
