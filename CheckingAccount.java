package bankAccountUpdates;

import java.io.*;
import java.text.DecimalFormat;

//Subclass that includes main constants and methods to support user checking accounts
public class CheckingAccount extends BankAccount {

	private final double INTEREST_RATE = 0.0004;
	private final double OVERDRAFT_FEE = 30.00;	
	DecimalFormat dispAmt = new DecimalFormat("#,##0.00");
	
	//Checking account withdrawal method that handles overdrafts
	public void processWithdrawal(double withdrawalAmt) {
		withdrawal(withdrawalAmt);
		if(balance < 0) {
			withdrawal(OVERDRAFT_FEE);
			System.out.println("*****You have overdrawn from your Checking Account*****");
			System.out.printf("Your balance is now $%s. This includes a $%.2f Overdraft Fee\n", 
					dispAmt.format(balance), OVERDRAFT_FEE);
		} 
	}
	
	//Account summary method to output all account information including checking account interest rate
	public void displayAccount() {
		super.accountSummary();
		System.out.printf("\nAccount Interest Rate: %.2f%%\n", (INTEREST_RATE * 100));
	}
	
}

