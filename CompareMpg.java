package PortfolioProject;

import java.util.Comparator;

public class CompareMpg implements Comparator<Vehicle> {
	// Overridden compare method to return value for sorting by mpg field
	@Override
	public int compare(Vehicle v1, Vehicle v2) {
		if(v1.getMpg() > v2.getMpg()) {
			return 1;
		}
		else if(v1.getMpg() < v2.getMpg()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
}
