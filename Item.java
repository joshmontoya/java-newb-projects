package montoyaClasses;

public class Item {

	private String itemName;
	private int qty;
	private double cost;
	
	public Item(String itemIn, int qtyIn, double costIn) {
		this.itemName = itemIn;
		this.qty = qtyIn;
		this.cost = costIn;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public int getItemQty() {
		return qty;
	}
	
	public double getItemCost() {
		return cost;
	}
}
