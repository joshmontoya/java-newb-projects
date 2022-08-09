package bankAccountUpdates;

import java.io.*;
import java.text.DecimalFormat;

//Superclass that includes main fields and methods to support user accounts
public class BankAccount implements Serializable {
	//Class field declarations. Protected in order for access to be restricted to subclasses only.
	private String userID, password, firstName, lastName;
	private Integer accountID;
	protected Double balance;
	// Instantiate DecimalFormat object to output balance with commas and rounded to 2 decimal places
	DecimalFormat dispBal = new DecimalFormat("#,##0.00");
	
	//Default constructor for BankAccount
	public BankAccount() {
		userID = null;
		password = null;
		firstName = null;
		lastName = null;
		accountID = 0;
		balance = 0.0; //Initial value of all new BankAccount objects
	}
	
	//Setters and getters for individual object attributes
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getUserID() {
		return userID;
	}
	public String getPassword() {
		return password;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Integer getAccountID() {
		return accountID;
	}
	public Double getBalance() {
		return balance;
	}
	
	//Balance adjustment methods for deposits and withdrawals by user
	public void deposit(double depositAmt) {
		balance += depositAmt;
	}
	public void withdrawal(double withdrawalAmt) {
		balance -= withdrawalAmt;
	}
	
	//Account summary method to output all account information
	public void accountSummary() {
		System.out.printf("\n**********Account Summary for %s %s**********\n", firstName, lastName);
		System.out.printf("\nAccount Number  : %d", accountID);
		System.out.printf("\nAccount Balance : $%s\n", dispBal.format(balance));
	}
}

