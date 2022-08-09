package bankAccountUpdates;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainBank {
	static Scanner input = new Scanner(System.in);
	
	//signIn method (access "database" of accounts to pull down account details)
	public static CheckingAccount signIn(CheckingAccount c, String userID, String password) {
		CheckingAccount temp = new CheckingAccount();
		try {
			FileInputStream fis = new FileInputStream("CheckingAccounts.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while(true) {
				try{
					temp = (CheckingAccount) ois.readObject();
					if(temp.getUserID().equalsIgnoreCase(userID)) {
						if(temp.getPassword().equals(password)) {
							c = temp;
							break;
						}else {
							c.setUserID(null);
							c.setPassword("MISMATCH");
							break;
						}
					}else {
						c.setUserID("MISMATCH");
						c.setPassword(null);
					}
				}catch(EOFException exp) {
					break;
				}	
			}
			ois.close();
			return c;
		}catch(StreamCorruptedException exp) {
			System.out.println("\n***UNABLE TO ACCESS DATABASE***\n");
			exp.printStackTrace();
			return c;
		}catch(FileNotFoundException exp) {
			System.out.println("\n***DATABASE NOT FOUND***\n");
			exp.printStackTrace();
			return c;
		}catch(IOException exp) {
			System.out.println("\n***UNKNOWN ERROR READING FROM DATABASE***\n");
			exp.printStackTrace();
			return c;
		}catch (ClassNotFoundException exp) {
			System.out.println("\n***UNKNOWN ERROR READING FROM DATABASE***\n");
			exp.printStackTrace();
			return c;
		}
	}
	
	//signOut method updates file with any changes to account while signed in
	public static void signOut(CheckingAccount c) {
		//Declare temp ArrayList for current CheckingAccount storage, count & index variables (for flagging list index)
		ArrayList<CheckingAccount> tempAccounts = new ArrayList<CheckingAccount>();
		int count = 0, index = -1;
		//access most recent CheckingAccounts "database" (text file)
		try {
			FileInputStream fis = new FileInputStream("CheckingAccounts.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			//loop through file accounts, writing to temp list, if accountID matches user signing out, write updated object to list 
			//so any changes made (balance change, etc.) are stored to file 
			while(true) {
				try{
					tempAccounts.add((CheckingAccount) ois.readObject());
					if(tempAccounts.get(count).getAccountID().equals(c.getAccountID())) {
						index = count;
					}
					count++;
				}catch(EOFException exp) {
					break;
				}
			}
			ois.close();
			if(index == -1) {
				tempAccounts.add(c);
			}else {
				tempAccounts.set(index, c);
			}
		}catch(StreamCorruptedException exp) {
			System.out.println("\n***UNABLE TO ACCESS DATABASE***\n");
			exp.printStackTrace();
		}catch(FileNotFoundException exp) {
			System.out.println("\n***DATABASE NOT FOUND***\n");
			exp.printStackTrace();
		}catch(IOException exp) {
			System.out.println("\n***UNKNOWN ERROR READING FROM DATABASE***\n");
			exp.printStackTrace();
		}catch (ClassNotFoundException exp) {
			System.out.println("\n***UNKNOWN ERROR READING FROM DATABASE***\n");
			exp.printStackTrace();
		}
		
		updateAccountDB(tempAccounts);
		
	}
	
	//updateAccountDB method to write all accounts to "database" with any applicable changes (existing acct updates or new accounts created)
	public static void updateAccountDB(ArrayList<CheckingAccount> accounts) {
		try {
			FileOutputStream fos = new FileOutputStream("CheckingAccounts.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(CheckingAccount account : accounts) {
				oos.writeObject(account);
			}
			oos.flush();
			oos.close();
		}catch(IOException exp) {
			System.out.println("***\nERROR ENCOUNTERED UPDATING ACCOUNT DATABASE***");
			exp.printStackTrace();
		}
	
	}
	
	//createAccount method for non-registered user create a new Checking Account object
	public static CheckingAccount createAccount(CheckingAccount c) {
		ArrayList<CheckingAccount> tempAccounts = new ArrayList<CheckingAccount>();
		//access most recent CheckingAccounts "database" (text file)
		try {
			FileInputStream fis = new FileInputStream("CheckingAccounts.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			//loop through file accounts, writing to temp list
			while(true) {
				try{
					tempAccounts.add((CheckingAccount) ois.readObject());
				}catch(EOFException exp) {
					break;
				}	
			}
			ois.close();
		}catch(StreamCorruptedException exp) {
			System.out.println("\n***UNABLE TO ACCESS DATABASE***\n");
			exp.printStackTrace();
		}catch(FileNotFoundException exp) {
			System.out.println("\n***DATABASE NOT FOUND***\n");
			exp.printStackTrace();
		}catch(IOException exp) {
			System.out.println("\n***UNKNOWN ERROR READING FROM DATABASE***\n");
			exp.printStackTrace();
		}catch (ClassNotFoundException exp) {
			System.out.println("\n***UNKNOWN ERROR READING FROM DATABASE***\n");
			exp.printStackTrace();
		}

		System.out.println("\nThanks for choosing Josh's Bank!");
		System.out.print("Please enter the first name associated with this account: ");
		c.setFirstName(input.next().toUpperCase());
		System.out.print("Please enter the last name associated with this account: ");
		c.setLastName(input.next().toUpperCase());
		System.out.print("Please enter the desired User ID to sign into this account: ");
		c.setUserID(input.next().toUpperCase());
		System.out.print("Please enter the desired password to sign into this account: ");
		c.setPassword(input.next());
		tempAccounts.sort((ob1, ob2) -> ob1.getAccountID().compareTo(ob2.getAccountID()));
		c.setAccountID((tempAccounts.get(tempAccounts.size() - 1).getAccountID()) + 1);
		
		tempAccounts.add(c);
		updateAccountDB(tempAccounts);
		return c;
	}
	
	public static void main(String[] args) {
		//Declarations/instantiation of class object, assignment of variables
		CheckingAccount account = new CheckingAccount();
		String activeInput, userIDInput, passwordInput;
		double deposit, withdrawal;
		
		//Sign In steps
		while(true) {
			System.out.print("Enter your User ID: ");
			userIDInput = input.next();
			System.out.print("Enter your password: ");
			passwordInput = input.next();
			account = signIn(account, userIDInput, passwordInput);
			if(account.getUserID() == "MISMATCH") {
				System.out.println("***USER ID NOT FOUND***");
				System.out.print("Press any key to try again or type \"REGISTER\" to create a new account: ");
				userIDInput = input.next();
				if(userIDInput.equalsIgnoreCase("REGISTER")) {
					account = createAccount(account);
					System.out.print("\n\n***ACCOUNT SUCCESSFULLY CREATED AND STORED TO DATABASE, ");
					System.out.println("PLEASE SIGN IN TO BEGIN USING YOUR ACCOUNT***");
				}
			}else if(account.getPassword() == "MISMATCH") {
				System.out.println("***PASSWORD INVALID, PLEASE TRY AGAIN***");
			}else {
				System.out.println("\n***SIGN IN SUCCESS!***\n");
				account.displayAccount();
				input.nextLine();
				break;
			}
		}
		
		
		//User input loops for any deposits / withdrawals & break functionality ("DONE")
			while(true) {
				try {
					System.out.print("\nEnter $ amount being deposited or withdrawn (as negative amount)");
					System.out.println("\nDO NOT enter $ symbol or commas | Enter \"DONE\" when finished: ");
					activeInput = input.nextLine();
					if(activeInput.equalsIgnoreCase("DONE")) {
						break;
					} else if(activeInput.charAt(0) == '-') {
						activeInput = activeInput.substring(1); //Remove negative symbol
						withdrawal = Double.valueOf(activeInput); //Convert string input to double
						account.processWithdrawal(withdrawal);
					} else {
						deposit = Double.valueOf(activeInput);
						account.deposit(deposit);
					}
				} catch(Exception NumberFormatException) { //Try/catch for incompatible input
					System.out.println("***ENTER VALID INPUT***");
				}
			}
		
		account.displayAccount();
		signOut(account);
		System.out.println("\n\n***ACCOUNT DATABASE UPDATED, SIGN OUT SUCCESSFUL***");
		input.close(); //Close scanner
		
	}

}


