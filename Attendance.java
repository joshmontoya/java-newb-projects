package Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Attendance {
	
	//Declare global scanner object
	public static final Scanner INPUT = new Scanner(System.in);
	
	/* Method with no parameters. Takes in user input of attendance for 5 school days.
	Returns boolean array of values that align with days "attended" or "absent" 
	 */
	public static boolean[] getAttendance() {
		boolean[] weeklyAttendanceArray = new boolean[5];
		boolean isValid;
		
		/* Prompt user to loop through days prompting/entering
		"true" if attended, "false" if missed. Based on input, add applicable boolean value to array
		*/
		for(int i = 0; i < weeklyAttendanceArray.length; i++) {
			isValid = false;
			// try/catch exception loop to ensure user input is either "true" or "false"
			while(!isValid) {
				try {
					System.out.println("For " + outputDay(i) + ", Enter \"true\" if present, \"false\" if absent:");
					weeklyAttendanceArray[i] = INPUT.nextBoolean();
					isValid = true;
				}catch(InputMismatchException e) {
					System.out.println("***You must enter either \"true\" or \"false\"***");
					isValid = false;
					INPUT.next(); // required to prevent infinite while loop
				}
			}
		}
		return weeklyAttendanceArray;
	}
	
	/* Method with no parameters, initiatlizes boolean array from another class method.
	Loops through and counts up "true" values, then divides by the total length of array to 
	determine percentage (in decimal) of days in attended. Value is then converted from a 
	decimal to a rounded int percentage for output in main method.
	 */
	public static int attendanceRate() {
		boolean[] attendance = getAttendance();
		double rateDec;
		int ratePerc, count = 0;
		
		for(int i = 0; i < attendance.length; i++) {
			if(attendance[i]) {
				count++;
			}
		}
		rateDec = (double) count / (double) (attendance.length);
		ratePerc = (int) Math.round(rateDec * 100);
		return ratePerc;
	}
	
	/* Method to return a weekday String (Monday - Friday) from an array for output.
	Parameter is an integer, typically 0-4 being passed via a loop counter
	 */
	public static String outputDay(int dayNum) {
		String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		return weekdays[dayNum];
	}

	
	public static void main(String[] args) {
		String studentName;

		System.out.println("Enter student name:");
		studentName = INPUT.nextLine();
		System.out.println(studentName + "'s attendance rate is: " + attendanceRate() + "%");
	}
}
