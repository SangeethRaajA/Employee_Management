

public class Shift {
	
	private int shift_Id;
	private String shift_Name,days,start_at,end_at;
	
	Shift(){
		
	}
	
	public Shift(String shift_Name, String days, String start_at, String end_at) {
		
		this.shift_Name = shift_Name;
		this.days = days;
		this.start_at = start_at;
		this.end_at = end_at;
	}

	public Shift(int shift_Id, String shift_Name, String days, String start_at, String end_at) {
	
		this.shift_Id = shift_Id;
		this.shift_Name = shift_Name;
		this.days = days;
		this.start_at = start_at;
		this.end_at = end_at;
	}

	public int getShift_Id() {
		return shift_Id;
	}

	public void setShift_Id(int shift_Id) {
		this.shift_Id = shift_Id;
	}

	public String getShift_Name() {
		return shift_Name;
	}

	public void setShift_Name(String shift_Name) {
		this.shift_Name = shift_Name;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getStart_at() {
		return start_at;
	}

	public void setStart_at(String start_at) {
		this.start_at = start_at;
	}

	public String getEnd_at() {
		return end_at;
	}

	public void setEnd_at(String end_at) {
		this.end_at = end_at;
	}

	@Override
	public String toString() {
		return "Shift [shift_Id=" + shift_Id + ", shift_Name=" + shift_Name + ", days=" + days + ", start_at="
				+ start_at + ", end_at=" + end_at + "]";
	}
	
	
	  

}
