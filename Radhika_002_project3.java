/*
 * Name: Radhika Aggarwal
 * Class & Section: ITSS 3312.002
 * Instructor: Prof. Khan
 * Assignment: Project 3
 */

package project3;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Radhika_002_project3 {
	

	public static void main(String[] args) {
		
		// declare variables
		int numberOfStudents; //the number of students that the system will hold
		boolean mainMenu = true; //for the while loop that determines repetition of the menu
		int mainMenuChoice; //menu choice chosen by the user
		
		int count = 0; //to keep count of number of students added to the database
		int empCount = 0; //to keep count of number of student employees added to the database
		
		// create scanner object
		Scanner input = new Scanner(System.in);
		
		
		// print introduction
		System.out.println("\t \t \t \tWelcome to Student and Course Management System\n \n");
		System.out.println("This system will allow you to manage courses and students. Let's start with the number of students this system will have: ");
		
		
		// read number of students from the system
		numberOfStudents = input.nextInt(); //record the number of Students from the user
		
		
		// create object array for students
		Student[] array = new Student[numberOfStudents]; 
		
		
		// create object array for student employees
		Student_Employee[] empArray = new Student_Employee[numberOfStudents]; 
		
		 
		//use a for loop to create objects for each element of the object arrays
		for (int i=0; i<numberOfStudents; i++) {
			array[i] = new Student(); //create a Student object for each element of the array
			empArray[i] = new Student_Employee(); //create a Student_Employee object for each element of the array
		}
		
		
		//display the main menu and iterate it until user wants to exit
		while(mainMenu) {
			
			// print menu with SMS and CMS options
			System.out.println("\n***Welcome to Student and Course Management System***\n");
			System.out.println("Press '1' for Student Management System (SMS)");
			System.out.println("Press '2' for Course Management System (CMS)");
			System.out.println("Press '0' to exit\n");
			
			mainMenuChoice = input.nextInt(); //record the menu option chosen by the user
			
			
			//call different methods according to the menu option chosen by the user
			switch(mainMenuChoice) {
			
				case 1: {
					// show SMS options
					count = sms(numberOfStudents, array, empArray, count, empCount); //call sms() method to execute sms
					break; //break out of the switch statement
				}
				
				case 2: {
					// show CMS options
					cms(array, numberOfStudents); //call cms() method to execute cms
					break; //break out of the switch statement
				}
				
				case 0: {
					// exit the system
					mainMenu = false;
					System.out.println("Good Bye!!!");
					break; //break out of the switch statement
				}
			
			}
			
		}
		
	}
	
	
	
	//sms() method: runs when user picks SMS option in main menu
	public static int sms(int numberOfStudents, Student[] array, Student_Employee[] empArray, int count, int empCount) {
		
		//declare the variables
		boolean smsMenu = true; //for the while loop that determines repetition of SMS 
		int smsMenuChoice; //to record the menu option chosen by the user
		
		
		//create Scanner object
		Scanner input = new Scanner(System.in);
		
		//run the menu options till the user doesn't want to exit SMS
		while (smsMenu) {
			//print introduction
			System.out.println("\n***Welcome to SMS***\n");
			
			
			//print menu
			System.out.println("Press '1' to add a student");
			System.out.println("Press '2' to deactivate a student");
			System.out.println("Press '3' to display all students");
			System.out.println("Press '4' to search for a student by ID");
			System.out.println("Press '5' to assign on-campus job");
			System.out.println("Press '6' to display all students with on-campus jobs");
			System.out.println("Press '0' to exit SMS\n");
			
			//read the menu choice from the user
			smsMenuChoice = input.nextInt();
			
			
			//call different methods on the basis of the sms menu option chosen by the user
			switch(smsMenuChoice) {
			
				case 1: {
					// add a student
					addStudent(numberOfStudents, array, count);
					count++; //increase the count of students added to the database
					break; //break out of the switch statement
				}
				
				case 2: {
					// deactivate a student
					deactivateStudent(numberOfStudents, array);
					break; //break out of the switch statement
				}
				case 3: {
					// display all students
					displayStudents(count, array);
					break; //break out of the switch statement
				}
				case 4: {
					// search for a student by ID
					searchStudent(numberOfStudents, array);
					break; //break out of the switch statement
				}
				case 5: {
					// assign on-campus job
					assignJob(numberOfStudents, array, empArray, empCount);
					empCount++;  //increase count of student employees in the database
					break; //break out of the switch statement
				}
				case 6: {
					// display all students with on-campus jobs
					displayJobStudents(empArray, empCount);
					break; //break out of the switch statement
				}
				case 0: {
					//exit the SMS
					smsMenu = false;
					break; //break out of the switch statement
				}
					
			}
			
		} 
		
		return count;
		
		
	}
	
	
	// cms() method: runs when user picks CMS option in main menu
	public static void cms(Student[] array, int numberOfStudents) {
		
		//declare the variables in use
		boolean cmsMenu = true; //for the while loop that determines repetition of CMS 
		int cmsMenuChoice; // for the cms menu option chosen by the user
		
		//create Scanner object
		Scanner input = new Scanner(System.in);
		
		//run the menu options till the user doesn't want to exit CMS
		while (cmsMenu) {
			//print introduction
			System.out.println("***Welcome to CMS***");
			
			
			//print menu
			System.out.println("Press '1' to add a new course");
			System.out.println("Press '2' to assign student a new course");
			System.out.println("Press '3' to display student with assigned courses");
			System.out.println("Press '0' to exit CMS");
			
			//read the input from the user
			cmsMenuChoice = input.nextInt();
			
			
			//call different methods according to the cms menu option chosen by the user
			switch(cmsMenuChoice) {
			
				case 1: {
					// add a new course
					addCourse();
					break; //break out of the switch statement
				}
				
				case 2: {
					// assign student a new course
					assignCourse(array, numberOfStudents);
					break; //break out of the switch statement
				}
				case 3: {
					// display student with assigned courses
					displayCourses(array, numberOfStudents);
					break; //break out of the switch statement
				}
				case 0: {
					//exit the SMS
					cmsMenu = false;
					break; //break out of the switch statement
				}
					
			}
			
		} //end of while loop
		
		
	}
	
	// addStudent() method: to add a student
	public static void addStudent(int numberOfStudents, Student[] array, int count ) {
		
		//declare variables in use
		String firstName; //student's first name
		String lastName; //student's last name
		String stuLevel; //student's level (freshman/sophomore/junior/senior)
		int stuID; //student ID (randomized)
		boolean status = true; //student's status
				
				
				
		//create scanner object
		Scanner input = new Scanner(System.in);
				
				
		// if the number of students already in the system is less than the number allowed, i.e. there is space in the system, then read the data from the user
		if (count < numberOfStudents) {
			System.out.println("Enter first name: ");
			firstName = input.next(); //read the student's first name
					
			System.out.println("Enter last name: ");
			lastName = input.next(); //read the student's last name
			
			do { //check for valid input and repeat till valid input is entered
					
				System.out.println("Enter level of the student: ");
				stuLevel = input.next(); //read the student's level
				
				//error message
				if (!(stuLevel.equalsIgnoreCase("freshman") || stuLevel.equalsIgnoreCase("sophomore") || stuLevel.equalsIgnoreCase("junior") || stuLevel.equalsIgnoreCase("senior"))) {
					System.out.println("Invalid output. Please enter one of the following: freshman, sophomore, junior, senior");
					
				}
			} while (!(stuLevel.equalsIgnoreCase("freshman") || stuLevel.equalsIgnoreCase("sophomore") || stuLevel.equalsIgnoreCase("junior") || stuLevel.equalsIgnoreCase("senior")));
			
		
					
			stuID = (int)(Math.random()*100); //assign a random student ID to the student between 0 and 99
					
			array[count].setStudent(stuID, firstName, lastName, stuLevel, status); //pass the values into the object using the setStudent() method
					
			System.out.println(array[count].fName + " " + array[count].lName + " has been added as a " + array[count].level + " with ID " + array[count].studentID + "\n");
		} else { //if the system is already full
			System.out.println("The system already contains " + numberOfStudents + " students in the system, so it can't add more students!");
		}
				
	}
	
	// deactivateStudent() method: to deactivate a student
	public static void deactivateStudent(int numberOfStudents, Student[] array) {
		
		//declare variables in use
		int stuID;	//studentID of the student to be deactivated
					
		//create scanner object
		Scanner input = new Scanner(System.in);
				
				
		//read the studentID for the student to be deactivated from the user
		System.out.println("Enter the ID for the student you want to deactivate: ");
		stuID = input.nextInt();
				
				
		//use a 'for' loop to find the student that corresponds to the studentID entered by the user, and then deactivate it
		for (int i=0; i<numberOfStudents; i++) {
			if (array[i].studentID == stuID) { //if the studentID matches then change the status
				array[i].status = false;
						
				System.out.println(array[i].fName + " " + array[i].lName + " has been deactivated");
				break; //end the for loop once the student has been found
			}
		}
		
	}
	
	// displayStudents() method: to display all students
	public static void displayStudents(int count, Student[] array) {	
		
		//sort the object array by first name
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                
                // to compare the first name of a student with the first name of the next student in the array
                if (array[i].getFName().compareTo(array[j].getFName()) > 0) {
                    // swapping the objects' position in the array
                    Student temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        
        //print to the file "StudentReport.txt"
        try {
	        File studentRoster = new File("/Users/radhikaaggarwal/Desktop/StudentReport.txt");
	        
	        studentRoster.createNewFile();
			
			PrintWriter studentWriter = new PrintWriter(studentRoster);
			
			// use a 'for' loop to iterate through each object in the array and print the data
			for (int i=0; i<count; i++) {
				System.out.println(array[i].toString() + "\n"); //print to console
				studentWriter.write(array[i].toString()); //print to file
				studentWriter.write("");
			}
			
			studentWriter.flush(); 
			studentWriter.close();
			
        } catch(IOException e) {
        	System.out.println("An error occurred.");
        }
	}
	
	// searchStudent() method: to search for a student by ID
	public static void searchStudent(int numberOfStudents, Student[] array) {
		
		//declare variables in use
		int stuID;
			
		//create scanner object
		Scanner input = new Scanner(System.in);
			
		//read the studentID from the user for the student to be shown
		System.out.println("Enter the student ID: ");
		stuID = input.nextInt();
		
		//use a 'for' loop to find the student that corresponds to the studentID entered by the user and then display the details for that student
		for (int i=0; i<numberOfStudents; i++) {
			if (array[i].studentID == stuID) { //if the studentID matches then display the student's details
					
				System.out.println(array[i].toString());
				break; //end the for loop once the student has been found
			}
		}
			
	}		
		
	// assignJob() method: to assign on-campus job
	public static void assignJob(int numberOfStudents, Student[] array, Student_Employee[] empArray, int empCount) {
		
		//declare variables in use
		int stuID;
		String job;
		String empType;
		
		//create scanner object
		Scanner input = new Scanner(System.in);
		
		//read student ID from the user
		System.out.println("Enter student ID: ");
		stuID = input.nextInt();
		
		
		do { //check for valid input and repeat till valid input is entered
			
			//read job title from the user
			System.out.println("Enter job: ");
			job = input.next();
			
			//error message
			if (!(job.equalsIgnoreCase("TA") || job.equalsIgnoreCase("RA"))) {
				System.out.println("Invalid output. Please enter one of the following: TA, RA");
				
			}
		} while (!(job.equalsIgnoreCase("TA") || job.equalsIgnoreCase("RA")));
		
		
		input.nextLine();
		
		//read employment type from the user;
		System.out.println("Enter job type: ");
		empType = input.nextLine();
		
		
		//iterate through the object array to find the corresponding student
		for (int i=0; i<numberOfStudents; i++) {
			if (array[i].studentID == stuID) { //if the studentID matches then add it to empArray
				
				//pass the student's details and job details into the setStudentEmployee() method of Student_Employee class
				empArray[empCount].setStudentEmployee(stuID, array[i].fName, array[i].lName, array[i].level, array[i].status, empType, job);
				
				System.out.println("\n" + empArray[empCount].fName + " " + empArray[empCount].lName + " has been assigned " + empArray[empCount].empType + " " + empArray[empCount].job + " job");
				
				break; //end the for loop once the student has been found
			}
		}
	}
	
	// displayJobStudents() method: to display all students with on-campus jobs
	public static void displayJobStudents(Student_Employee[] empArray, int empCount) {
		
		for (int i = 0; i<empCount; i++) {
			System.out.println(empArray[i].fName + " " + empArray[i].lName);
			System.out.println("ID - " + empArray[i].studentID);
			System.out.println(empArray[i].empType + " " + empArray[i].job);
		}
	}
	
	// addCourse() method: to add a new course
	public static void addCourse() {
		
		//declare the variables in use
		int courseID;
		String courseName;
		
		//create Scanner object 
		Scanner input = new Scanner(System.in);
		
		
		//read the courseID from the user
		System.out.println("Enter course ID: ");
		courseID = input.nextInt();
		
		input.nextLine();
		
		//read the course name from the user
		System.out.println("Enter course name: ");
		courseName = input.nextLine();
		
		
		// create course object in order to invoke the methods from course class
		Course course = new Course();
		
		
		//call the setCourse() method from the course object
		course.setCourse(courseID, courseName);
		
	}
	
	// assignCourse() method: to assign student a new course
	public static void assignCourse(Student[] array, int numberOfStudents) {
		
		//declare the variables in use
		int studentID;
		int courseID;
		String studentFName = "";
		String studentLName = "";
		
		//create Scanner object
		Scanner input = new Scanner(System.in);
		
		//read studentID
		System.out.println("Enter student ID: ");
		studentID = input.nextInt();
		
		//read courseID 
		System.out.println("Enter course ID: ");
		courseID = input.nextInt();
		
		//use a 'for' loop to iterate through the student object array to find the name of the student ID entered
		for (int i=0; i<numberOfStudents; i++) {
			if (array[i].studentID == studentID) { //if the studentID matches then record the student's details
					
				studentFName = array[i].getFName();
				studentLName = array[i].getLName();
					
				break; //end the for loop once the student has been found
			}
		}
		
		//create an object from Course class
		Course course = new Course();
		
		
		//call the assignStudent() method from the course object
		course.assignStudent(courseID, studentID, studentFName, studentLName);
		
	}
	
	// displayCourses() method: to display student with assigned courses
	public static void displayCourses(Student[] array, int numberOfStudents) {
		
		//create an object from Course class
		Course course = new Course();
		
		//call the displayStudent() method from the course object
		course.displayStudent(array, numberOfStudents);
		
	}

}
