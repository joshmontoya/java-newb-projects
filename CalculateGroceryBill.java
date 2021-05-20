package Main;
import java.util.Scanner;

public class CalculateGroceryBill {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Declarations
		double couponAmt, discAmt, monthTotal = 0, weeklyAvg, grocBillAmt;
		int weekCount = 4;
		
		//Prompt for user input of coupon amount & force to be > 0 & <= 100%
		System.out.println("Please enter coupon amount as a decimal:");
		couponAmt = input.nextDouble();
		if(couponAmt <= 0 || couponAmt > 1.0) {
			couponAmt = 0.10;
		}
		discAmt = 1.0 - couponAmt;
		
		//Loop gathering input of weekly grocery spend and compiling of monthly total spend
		for(int i = 0; i < weekCount; i++) {
			System.out.println("Enter week #" + (i + 1) + " grocery bill amount:");
			grocBillAmt = input.nextDouble();
			monthTotal += grocBillAmt;
		}
		//Calculate weekly average spend
		weeklyAvg = monthTotal / weekCount;
		
		//Display monthly total spend & weekly average spend with & without coupon applied
		System.out.printf("The monthly total spent on groceries WITHOUT the coupon is: $%.2f"
				+ "\nWeekly average spent WITHOUT the coupon is: $%.2f\n", monthTotal, weeklyAvg);
		System.out.printf("\nThe monthly total spent on groceries WITH the coupon is: $%.2f"
				+ "\nWeekly average spent WITH the coupon is: $%.2f\n", 
				(monthTotal * discAmt), (weeklyAvg * discAmt));		
		}

	}
