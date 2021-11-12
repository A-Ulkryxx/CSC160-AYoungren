//Austin Youngren

import java.util.Scanner;

public class CSclassesAY
{
	static Scanner input;
	public static void main( String[ ] list )
	{
		input = new Scanner(System.in);
		CourseAY course1 = new CourseAY();
		CourseAY course2 = new CourseAY("CSC120632", 20, 22, 105, 5);
		
		setCustomClass(course1);
		getCustomClass(course1);
		System.out.println(course1.toString ( ));
		
//		setCustomClass(course2);
//		getCustomClass(course2);
		System.out.println(course2.toString ( ));
	}
	
	public static void setCustomClass(CourseAY course)
	{
		String courseNum;
		int numStudents;
		int maxStudents;
		int room;
		int credits;
		
		System.out.println("What is the course number?");
		courseNum = input.nextLine();
		course.setCourseNumber(courseNum);
		
		System.out.println("How many students are in the class?");
		numStudents = input.nextInt();
		course.setNumStudents(numStudents);
		
		System.out.println("What is the max amount of students the class can have?");
		maxStudents = input.nextInt();
		course.setMaxStudents(maxStudents);
		
		System.out.println("What is the room number?");
		room = input.nextInt();
		course.setRoom(room);
		
		System.out.println("How many credits is the class?");
		credits = input.nextInt();
		course.setRoom(credits);
	}
	
	public static void getCustomClass(CourseAY course)
	{
		System.out.println("The course number is: " + course.getCourseNumber());
		System.out.println("The number of students in class is: " + course.getNumStudents());
		System.out.println("The max amount of students are: " + course.getMaxStudents());
		System.out.println("The course room number is: " + course.getRoom());
		System.out.println("The course credits are: " + course.getCredits());
	}
}	


