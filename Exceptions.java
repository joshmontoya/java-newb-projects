package montoyaClasses;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions {

	Scanner input = new Scanner(System.in);
	
	public String validString(String name) {
		boolean isValid = true;
		String inString = null;
		while(isValid) {
			try {
				System.out.println("Enter " + name + ":");
				inString = input.nextLine();
				isValid = false;
			} catch(InputMismatchException e) {
				System.out.println("please enter a valid input:");
				isValid = true;
			}
		}
		return inString;
	}
	
	public int validInt(String name) {
		boolean isValid = true;
		int inNum = 0;
		while(isValid) {
			try {
				System.out.println("Enter " + name + ":");
				// Accept input as string, parsed to integer to avoid next string input skip due to enter line
				inNum = Integer.parseInt(input.nextLine());
				isValid = false;
			} catch(NumberFormatException e) {
				System.out.println("please enter a valid input");
				isValid = true;
			}
		}
		return inNum;
	}
	
	public double validDouble(String name) {
		boolean isValid = true;
		double inNum = 0;
		while(isValid) {
			try {
				System.out.println("Enter " + name + ":");
				// Accept input as string, parsed to double to avoid next string input skip due to enter line
				inNum = Double.parseDouble(input.nextLine());
				isValid = false;
			} catch(NumberFormatException e) {
				System.out.println("please enter a valid input");
				isValid = true;
			}
		}
		return inNum;
	}
}
