package project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Course implements Course_interface {
	
	//declare the variables in the class
	int courseID;
	String courseName;
	
	//create the no-arg constructor for the class
	Course() { }
	
	//setCourse() method: to be used for adding a new course
	public void setCourse(int courseID, String courseName) {
		
		//declare the variables in use
		boolean found = false; //to check if the course exists in the file
		
		try {
			//create file object
			File courseList = new File("/Users/radhikaaggarwal/Desktop/Course.txt");
			if (courseList.createNewFile()) { //if new file was created
				System.out.println("File created.");
			}
			
			//check if the course exists in the file
			
			//create a scanner object to parse through "Course.txt"
			Scanner sc = new Scanner(courseList);
			
			//if the document is blank, directly proceed to writing the new course to the document
			if(!sc.hasNextLine()) {

				writeCourseToFile(courseID, courseName);
				
			}
			
			//if the document is not blank, first parse through the document to check if the course already exists
			while(sc.hasNextLine()) {
				
				//parse through each line and separate the courseID and courseName into a String[] array
				String[] courseData = sc.nextLine().split(" ");
				
				if(courseData[0].equals(Integer.toString(courseID))) { //if the courseID matches a pre-existing a courseID
					found = true; //change the boolean to true
					System.out.println("The course already exists.");
					break; //break out of the while loop, since course is already found once
				}
				else {
					found = false; //set boolean to false as a safeguard
				}
				
			}
			
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		
		//if after parsing through the entire document, the course is not already found, then proceed to write it to the document
		if (found == false) { 	
			writeCourseToFile(courseID, courseName);
		}
		
	}
	
	public void assignStudent(int courseID, int studentID, String studentFName, String studentLName) {
		
		try {
			//create file object
			File courseAssign = new File("/Users/radhikaaggarwal/Desktop/CourseAssignment.txt");
			
			//write to file
			PrintWriter courseWriter = new PrintWriter(courseAssign); //create PrintWriter object
			courseWriter.write(courseID + " " +studentID);
			
			courseWriter.flush();
			courseWriter.close();
			
		}catch(IOException e){
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		//print confirmation
		System.out.println(studentFName + " " + studentLName + " has been assigned the course " + courseID);
	}
	
	public void displayStudent(Student[] array, int numberOfStudents) {
		String studentID;
		String courseID;
		String studentFName = "";
		String studentLName = "";
		
		//read from file
		
		//create file object
		File courseAssign = new File("/Users/radhikaaggarwal/Desktop/CourseAssignment.txt");
		try {
			Scanner sc = new Scanner(courseAssign);
			while (sc.hasNextLine()) { 
				
				//parse through each line and separate the courseID and studentID into a String[] array
				String[] courseAssignData = sc.nextLine().split(" ");
				courseID = courseAssignData[0];
				studentID = courseAssignData[1];
				
				
				//iterate through the Student object array to find the additional details of the corresponding student
				for (int i=0; i<numberOfStudents; i++) {
					if (Integer.toString(array[i].studentID).equals(studentID)) { //if the studentID matches then record the student's details
							
						studentFName = array[i].getFName();
						studentLName = array[i].getLName();
							
						break; //end the for loop once the student has been found
					}
				}
				
				//print the details of the student and the courses he/she is taking to the console
				System.out.println(studentFName + " " + studentLName);
				System.out.println("ID - " + studentID);
				System.out.println("Courses: " + courseID);
			}
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
	}
	
	//writeCourseToFile() method: to write the course to the file
	public void writeCourseToFile(int courseID, String courseName) {
		
		
		PrintWriter courseWriter; //declare PrintWriter object
		try {
			courseWriter = new PrintWriter(new FileWriter("/Users/radhikaaggarwal/Desktop/Course.txt", true)); //instantiate Printwriter object
			courseWriter.println(courseID + " " +courseName);
			
			courseWriter.flush();
			courseWriter.close();
			System.out.println("Confirmation: New course " + courseID + " has been added");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
