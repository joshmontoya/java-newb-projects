package bankAccountUpdates;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AcctDB {
	
	
	public static void checkingAccountsProperties(ArrayList<CheckingAccount> list) {
		System.out.printf("%-20s%-20s%-15s%-15s%-15s%-15s\n\n", "USER ID", "PASSWORD", "FIRST NAME", "LAST NAME", "ACCOUNT ID", "BALANCE");
		for(CheckingAccount x : list) {
			System.out.printf("%-20s%-20s%-15s%-15s%-15d%-15.2f\n", x.getUserID(), x.getPassword(), x.getFirstName(), x.getLastName(), x.getAccountID(), x.getBalance());
		}
	}
	
	public static void sort(ArrayList<CheckingAccount> list) {
		list.sort((ob1, ob2) -> ob1.getAccountID().compareTo(ob2.getAccountID()));
	}
	
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
	

	public static void main(String[] args) {
		ArrayList<CheckingAccount> checkingAccounts = new ArrayList<>();
		
		CheckingAccount c1 = new CheckingAccount();
		c1.setUserID("TMONEY42");
		c1.setPassword("abcd1234");
		c1.setFirstName("TOM");
		c1.setLastName("HOLLAND");
		c1.setAccountID(967225);
		c1.setBalance(8767.44);
		checkingAccounts.add(c1);
		
		CheckingAccount c2 = new CheckingAccount();
		c2.setUserID("JMROX24");
		c2.setPassword("p@ssw0rd");
		c2.setFirstName("JOSH");
		c2.setLastName("MONTOYA");
		c2.setAccountID(942673);
		c2.setBalance(47886.52);
		checkingAccounts.add(c2);
		
		CheckingAccount c3 = new CheckingAccount();
		c3.setUserID("REGGIEROX55");
		c3.setPassword("abcd1234");
		c3.setFirstName("REGINALD");
		c3.setLastName("HASELTINE");
		c3.setAccountID(988743);
		c3.setBalance(12745.20);
		checkingAccounts.add(c3);
		
		CheckingAccount c4 = new CheckingAccount();
		c4.setUserID("JESSM83");
		c4.setPassword("LuvJ1983");
		c4.setFirstName("JESSIKA");
		c4.setLastName("MONTOYA");
		c4.setAccountID(942672);
		c4.setBalance(800.01);
		checkingAccounts.add(c4);
		
		CheckingAccount c5 = new CheckingAccount();
		c5.setUserID("AWESOMESAUCE9");
		c5.setPassword("doge566$");
		c5.setFirstName("JACK");
		c5.setLastName("JACKFORD");
		c5.setAccountID(910888);
		c5.setBalance(56.47);
		checkingAccounts.add(c5);
		
		CheckingAccount c6 = new CheckingAccount();
		c6.setUserID("TADGHOSTAL100");
		c6.setPassword("Banjo42");
		c6.setFirstName("TAD");
		c6.setLastName("GHOSTAL");
		c6.setAccountID(933487);
		c6.setBalance(1076.00);
		checkingAccounts.add(c6);
		
		
		checkingAccountsProperties(checkingAccounts);
		updateAccountDB(checkingAccounts);
		
	}

}
