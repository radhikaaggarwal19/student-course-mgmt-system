package project3;

public class Student implements Student_interface {
	//declare the variables in the class
	int studentID; //student ID
	String fName = ""; //student's first name with initially a blank value
	String lName; //student's last name
	String level; //student's level (freshman/sophomore/junior/senior)
	boolean status = true;
		
		
	Student() {	} //create a no-arg constructor to invoke the object
		
		
	//create a method that allows you to set values for the object
	public void setStudent(int studentID, String fName, String lName, String level, boolean status) {
		this.studentID = studentID; //set studentID
		this.fName = fName; //set student's first name
		this.lName = lName; //set student's last name
		this.level = level; //set student's level
	}
		
		
		
	// toString() method to display the object array
	public String toString() {
			
		String returnStr  = "\n" + this.fName + " " + this.lName + "\nID: " + this.studentID + "\nLevel: " + this.level + "\n";
			

		if (this.status == true) {
			returnStr += "Status: Active";
		} else if (this.status == false)  {
			returnStr += "Status: Inactive";
		}
			
		return returnStr;
			
	}
	
	//to get the first name
	public String getFName () {
		String firstName = this.fName;
		
		return firstName;
	}
	
	//to get the last name
	public String getLName () {
		String lastName = this.lName;
		
		return lastName;
	}
}
