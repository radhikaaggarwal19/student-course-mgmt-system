package project3;

interface Course_interface {
	public void setCourse(int courseID, String courseName);
	public void assignStudent(int courseID, int studentID, String studentFName, String studentLName);
	public void displayStudent(Student[] array, int numberOfStudents);
	public void writeCourseToFile(int courseID, String courseName);
}
