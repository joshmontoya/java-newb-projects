package montoyaClasses;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class User {
	
	private String firstName, lastName, userName, userPwd, userEmail;
	
	private String userNameCreate(String fn, String ln) {
		char[] lnCutArr = {ln.charAt(0), ln.charAt(1), ln.charAt(2), ln.charAt(3)};
		String lnCutStr = String.valueOf(lnCutArr).toLowerCase();
		char[] fnCutArr = {fn.charAt(0), fn.charAt(1), fn.charAt(2)};
		String fnCutStr = String.valueOf(fnCutArr).toLowerCase();
		int userNameNum = new Random().nextInt(10);
		String userName = lnCutStr.concat(fnCutStr).concat(String.valueOf(userNameNum));
		return userName;
		}
	
	private String userEmailCreate(String fn, String ln) {
		String userEmail = fn.concat(".").concat(ln).concat("@JoshCo.com");
		return userEmail;
	}
	
	private static boolean inCharArray(char[] array, char character) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == character) {
				return true;
			}
		}
		return false;
	}
	
	public static String pwdCreate() {
		
		Scanner input = new Scanner(System.in);
		boolean pwdAuth = false;
		char[] specChar = {'%', '$', '@', '&', '#'};
		String newPwd;
		
		do {
			System.out.println("\nEnter your new password:");
			
			newPwd = input.nextLine();
			char[] pwdArray = newPwd.toCharArray();
			
			if(pwdArray.length < 8) {
				System.out.println("Password is not long enough, Try Again.");
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
					System.out.println("Password cannot include spaces, Try Again.");
				}else if(numCount >= 1 && charCount >= 1 && upperCount >= 1) {
					System.out.println("Congratulations, your password passed authentication!\n");
					newPwd = String.valueOf(pwdArray);
					pwdAuth = true;
				}else {
					System.out.println("Password does not pass authentication, Try Again.");
				}
	
				}
	
		}while(pwdAuth == false);
		return newPwd;
	}
	
	public void dispUser() {
		System.out.println("User First Name is: " + this.firstName);
		System.out.println("User Last Name is: " + this.lastName);
		System.out.println("User Email Address is: " + this.userEmail);
		System.out.println("User Username is: " + this.userName);
		System.out.println("User Password is: " + this.userPwd);
	}
	
	public User() {
		this.firstName = "first";
		this.lastName = "last";
		this.userEmail = userEmailCreate(firstName, lastName);
		this.userName = userNameCreate(firstName, lastName);
		this.userPwd = "DEFAULT";
	}
	
	public User(String fn, String ln, String pwd) {
		this.firstName = fn;
		this.lastName = ln;
		this.userEmail = userEmailCreate(fn, ln);
		this.userName = userNameCreate(fn, ln);
		this.userPwd = pwd;
	}
}
