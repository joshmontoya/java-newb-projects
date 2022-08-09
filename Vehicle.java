package PortfolioProject;

public class Vehicle {
	// Class variable declarations
	private String make, model;
	private Double mpg;
	
	// Default constructor
	Vehicle() {
		make = null;
		model = null;
		mpg = null;
	}
	
	// Parameterized constructor
	Vehicle(String make, String model, Double mpg){
		this.make = make;
		this.model = model;
		this.mpg = mpg;
	}
	
	// Setter/getter methods for individual field use (where needed)
	public void setMake(String make) {
		this.make = make;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setMpg(Double mpg) {
		this.mpg = mpg;
	}
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public Double getMpg() {
		return mpg;
	}
	
	// toString method for object presentation in output
	@Override
	public String toString() {
		return String.format("Make: %s\nModel: %s\nMiles per gallon: %.1f", make, model, mpg);
	}
}
