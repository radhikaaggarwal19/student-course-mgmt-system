package project3;

public class Student_Employee extends Student {
	
	//declare variables
	String empType;
	String job;
	
	Student_Employee() {};
	
	
	public void setStudentEmployee(int studentID, String fName, String lName, String level, boolean status, String empType, String job) {
		this.studentID = studentID;
		this.fName = fName;
		this.lName = lName;
		this.level = level;
		this.status = status;
		this.empType = empType; //set employee type
		this.job = job; //set job
	}
	
	
	
}
