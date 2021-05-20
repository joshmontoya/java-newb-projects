package Main;

import java.util.Scanner;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Children {
	
	/* Method to take in array data, loop through arrays, convert DOB's to days, months or years
	based on their age, and display linked elements (Name, Age)
	*/
	public static void dispChildren(String[] fNames, String[] lNames, LocalDate[] dobs) {
		LocalDate today = LocalDate.now();
		System.out.println("\nNames & ages of children in the input family are:");
		for(int i = 0; i < (fNames.length); i++) {
			System.out.print(fNames[i] + " " + lNames[i] + ", Age: ");
			if((ChronoUnit.MONTHS.between(dobs[i], today)) < 1) {
				if(ChronoUnit.DAYS.between(dobs[i], today) == 1) {
					System.out.println(ChronoUnit.DAYS.between(dobs[i], today) + " day old");
				}else {
					System.out.println(ChronoUnit.DAYS.between(dobs[i], today) + " days old");
				}
			}else if((ChronoUnit.YEARS.between(dobs[i], today)) < 2) {
				if(ChronoUnit.MONTHS.between(dobs[i], today) == 1) {
					System.out.println(ChronoUnit.MONTHS.between(dobs[i], today) + " month old");
				}else {
					System.out.println(ChronoUnit.MONTHS.between(dobs[i], today) + " months old");
				}
			}else {
				System.out.println(ChronoUnit.YEARS.between(dobs[i], today) + " years old");
			}
		}
	}

	// Method to take in date in XX/XX/XXXX format and convert to java.time.* LocalDate format
	public static LocalDate dateConv(String date) {
		LocalDate formattedDate;
		int year;
		int month;
		int day;
		
		year = Integer.valueOf(date.substring(6));
		month = Integer.valueOf(date.substring(0, 2));
		day = Integer.valueOf(date.substring(3, 5));
		
		formattedDate = LocalDate.of(year, month, day);
		return formattedDate;
	}
	
	// Method to force correct date format
	public static boolean forceDateFormat(String date) {
		boolean isNumIndex = false;
		if(date.length() != 10) {
			return false;
		}else if ((Integer.valueOf(date.substring(6)) > LocalDate.now().getYear())){
			System.out.println("Invalid Year");
			return false;
		}else {
			for(int i = 0; i < date.length(); i++) {
				switch(i) {
					case 0: case 1: case 3: case 4: case 6: case 7: case 8: case 9:
						isNumIndex = true;
						break;
					case 2: case 5:
						isNumIndex = false;
						break;
				}
				if((isNumIndex == true) && (!Character.isDigit(date.charAt(i)))) {
					return false;
				}else if((isNumIndex == false) && (date.charAt(i) != '/')) {
					return false;
				}
			}
			return true;
		}
	}

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Declarations
		int numChildren; 
		String dob;
		boolean valid;
		String[] firstNames, lastNames;
		LocalDate [] datesOfBirth;
		
		System.out.println("Enter number of children in family: ");
		numChildren = input.nextInt();
		input.nextLine();
		
		// Initialize all arrays to be size of number of children entered
		firstNames = new String[numChildren];
		lastNames = new String[numChildren];
		datesOfBirth = new LocalDate[numChildren];
		
		/* Loop (iterate) number of children, prompt for input of each array element and
		add input to applicable linked arrays (i.e., child #1 first name is in first name array index 0,
		last name of child #1 is in last name array index 0, etc.)
		*/
		for(int i = 0; i < numChildren; i++) {
			System.out.println("Enter first name of child #" + (i + 1));
			firstNames[i] = input.nextLine();
			System.out.println("Enter last name of child #" + (i + 1));
			lastNames[i] = input.nextLine();
			do {
				System.out.println("Enter DOB (formatted XX/XX/XXXX) of child #" + (i + 1));
				dob = input.nextLine();
				if(!forceDateFormat(dob)) {
					System.out.println("You must enter a valid format!");
					valid = false;
				}else {
					valid = true;
				}
			}while(valid == false);
			datesOfBirth[i] = dateConv(dob);
		}
		
		// Call method to display all the entered info 
		dispChildren(firstNames, lastNames, datesOfBirth);

	}

}

