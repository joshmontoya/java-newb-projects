package Main;
import java.util.Scanner;

public class Password {
	
	public static boolean inCharArray(char[] array, char character) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == character) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n********************\n" + "Hello! Your new "
				+ "password must be minimum 8 characters long, & include "
				+ "at least 1 number, have one capital letter and\n"
				+ "include 1 special character (%, $, @, &, #)");
		boolean pwdAuth = false;
		char[] specChar = {'%', '$', '@', '&', '#'};
		
		do {
			System.out.println("\nEnter your new password:");
			
			String newPwd = input.nextLine();
			char[] pwdArray = newPwd.toCharArray();
			
			if(pwdArray.length < 8) {
				System.out.println("Your password is not long enough, dummy! Try Again.");
			}else {
				int numCount = 0;
				int charCount = 0;
				int upperCount = 0;
				boolean space = false;
				for(int i = 0; i < pwdArray.length; i++) {
					if(Character.isUpperCase(pwdArray[i])) {
						upperCount += 1;
					}else if(inCharArray(specChar, pwdArray[i]) == true) {
						charCount += 1;
					}else if(Character.isDigit(pwdArray[i])) {
						numCount += 1;
					}else if(Character.isWhitespace(pwdArray[i])) {
						space = true;
					}
					}
				if(space == true) {
					System.out.println("Your password cannot include spaces, dummy! Try Again.");
				}else if(numCount >= 1 && charCount >= 1 && upperCount >= 1) {
					System.out.println("Congratulations, your password passed authentication!");
					pwdAuth = true;
					newPwd = String.valueOf(pwdArray);
				    System.out.println("Type is: " + ((Object) newPwd).getClass().getSimpleName());
					System.out.println("Your new password is: " + newPwd + "\n\n********************\n");
				}else {
					System.out.println("Your password did not pass authentication, dummy! Try Again.");
				}
	
				}

		}while(pwdAuth == false);
		input.close();
	}

}
