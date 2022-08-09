package PortfolioProject;

import java.util.*;
import java.io.*;

public class VehicleDriver {
	
	/** saveVehicles method takes
	 * @param vehicles (list of Vehicle objects)
	 * @param c (comparator for specific Vehicle object attribute)
	 * Calls Collections.sort method using passed list & comparator
	 * Loops through list and prints to offline text file:
	 * Label, individual vehicle object from list, and blank line between all objects
	 * *no blank line at end of list*
	 */
	static void saveVehicles(List<Vehicle> vehicles, Comparator<Vehicle> c) {
		try {
			FileWriter fw = new FileWriter("Vehicle_List.txt");
			PrintWriter pw = new PrintWriter(fw);
			Collections.sort(vehicles, c);
			for(int i = 0; i < vehicles.size(); i++) {
				pw.print(String.format("***Vehicle #%d***\n", i + 1));
				pw.print(vehicles.get(i));
				if(i != (vehicles.size() - 1)) {
					pw.print("\n\n");
				}
			}
			fw.close();
			System.out.println("Written to file \"Vehicles_List.txt\" (sorted by MPG)");
		} catch (IOException e) {
			System.out.println("***UNABLE TO WRITE TO FILE***");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Driver main class declarations
		Scanner input = new Scanner(System.in);
		String vehMake, vehModel;
		Double vehMpg = null;
		int count = 1;
		LinkedList<Vehicle> vehiclesList = new LinkedList<Vehicle>();
		
		/** While loop that continues if first input is not equal to "DONE"
		 * Prompts user to enter vehicle attributes (make, model, mpg)
		 * mpg format (Double) validated with try/catch within while loop:
		 * validates & allows for repeated input attempt until valid
		 * end of loop: Vehicle object instantiated with input attributes
		 */
		while(true) {
			System.out.printf("Enter vehicle #%d make or \"DONE\" if finished entering vehicles: ", count);
			vehMake = input.nextLine();
			if(vehMake.equalsIgnoreCase("DONE")) {
				break;
			}else {
				System.out.printf("Enter vehicle #%d model: ", count);
				vehModel = input.nextLine();
				boolean validMpg = false; 
				while(!validMpg) {
					try {
						System.out.printf("Enter vehicle #%d miles per gallon: ", count);
						vehMpg = input.nextDouble();
						input.nextLine(); // nextLine command to handle prior Double input command
						validMpg = true;
					}catch(InputMismatchException e) {
						System.out.println("***YOU MUST ENTER VALID NUMBER***");
						input.nextLine(); // nextLine command to handle prior Double input command
					}
				}
				count++;
				vehiclesList.add(new Vehicle(vehMake, vehModel, vehMpg));
			}
		}
		System.out.println("\nThanks for entering all vehicle information");
		saveVehicles(vehiclesList, new CompareMpg()); // saveVehicles method call to write Vehicle list to file
		
		input.close();

	}

}

