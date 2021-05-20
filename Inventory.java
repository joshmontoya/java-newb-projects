package Main;

import java.util.ArrayList;
import java.util.Scanner;
import montoyaClasses.Exceptions;
import montoyaClasses.Item;

public class Inventory {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Exceptions exp = new Exceptions();
		
		String prodName = null;
		int qty = 0;
		double cost = 0;
		int prodToEnter;
		
		ArrayList<Object> prodList = new ArrayList<>();

		
		System.out.println("********************************\nWELCOME TO THE INVENTORY SYSTEM");
		System.out.println("Please enter number of products you will be entering:");
		prodToEnter = input.nextInt();
		for(int i = 0; i < prodToEnter; i++) {
			prodName = exp.validString("product");
			qty = exp.validInt("quantity");
			cost = exp.validDouble("cost");
			Item prod = new Item(prodName, qty, cost);
			prodList.add(prod);
		}
		System.out.println(prodList); // output list of object instances
		
		//Loop output of individual object attributes
		for(int i = 0; i < prodList.size(); i++) {
			System.out.println("Name of product #" + (i + 1));
			System.out.println(((Item) prodList.get(i)).getItemName());
			System.out.println("Quantity of product #" + (i + 1));
			System.out.println(((Item) prodList.get(i)).getItemQty());
			System.out.println("Cost of product #" + (i + 1));
			System.out.println("$" + ((Item) prodList.get(i)).getItemCost());
		}
		
	}

}
