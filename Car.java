package montoyaClasses;
import java.util.Scanner;

public class Car {

	private String brand;
	private String model;
	private String year;
	private int startOdom;
	private int endOdom;
	private double gallonsUsed;
	
	public Car(String brandIn, String modelIn, String yearIn, int startOdomIn, int endOdomIn, double gallonsUsedIn) {
		this.brand = brandIn;
		this.model = modelIn;
		this.year = yearIn;
		this.startOdom = startOdomIn;
		this.endOdom = endOdomIn;
		this.gallonsUsed = gallonsUsedIn;
	}
	
	private int mpgCalc() {
		int milesDiff = this.endOdom - this.startOdom;
		double mpgCalc = milesDiff / this.gallonsUsed;
		int mpgCalcRound = (int)(Math.round(mpgCalc));
		return mpgCalcRound;
	}
	
	public void display() {
		System.out.println("\n**********\nYou Entered:\n");
		System.out.println("Car Brand: " + this.brand + "\nCar Model: " + this.model +
				"\nCar Year: " + this.year + "\nCar Starting Odometer: " + this.startOdom +
				"\nCar Ending Odom: " + this.endOdom + "\nCar Gallons Used: " + this.gallonsUsed);
		System.out.println("Car Calculated MPG: " + mpgCalc());
		System.out.println("\n**********");
		
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String carBrand;
		String carModel;
		String carYear;
		int carStartOdom;
		int carEndOdom;
		double carGallonsUsed;

		System.out.print("Enter Car Brand: ");
		carBrand = input.nextLine();
		System.out.print("Enter Car Model: ");
		carModel = input.nextLine();
		System.out.print("Enter Car Year: ");
		carYear = input.nextLine();
		System.out.print("Enter Car Starting Odometer: ");
		carStartOdom = input.nextInt();
		System.out.print("Enter Car Ending Odometer: ");
		carEndOdom = input.nextInt();
		System.out.print("Enter Car Gallons Used: ");
		carGallonsUsed = input.nextDouble();
		
		Car c = new Car(carBrand, carModel, carYear, carStartOdom, carEndOdom, carGallonsUsed);
		c.display();
		
		
	}

}
