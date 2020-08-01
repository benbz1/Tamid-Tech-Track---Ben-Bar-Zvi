package Challenge2;

/**
 * This is my solution to challenge #2 of the Senior Software Engineer
 * Application.
 * 
 * This class represents an Ice Cream.
 * 
 * @author benbarzvi
 * 
 *         08/01/2020
 *
 */
public class IceCream {
	private String name;
	private double price;
	private double cost;
	private int scoops;

	/**
	 * This is the constructor of the class.
	 * 
	 * @param name   - name of Ice Cream.
	 * @param price  - price to costumer.
	 * @param cost   - cost to truck.
	 * @param scoops - scoops available for purchase.
	 */
	public IceCream(String name, double price, double cost, int scoops) {
		this.name = name;
		this.price = price;
		this.cost = cost;
		this.scoops = scoops;
	}

	/**
	 * Simple get method.
	 * 
	 * @return name of ice cream.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Simple get method
	 * 
	 * @return cost of ice cream to truck
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * Simple get method
	 * 
	 * @return price for customers
	 */
	public double price() {
		return price;
	}

	/**
	 * Simple get method
	 * 
	 * @return number of scoops left for customers.
	 */
	public int getScoops() {
		return scoops;
	}

	/**
	 * This method "sells" a scoop of ice cream.
	 * 
	 * @return true if there is at least one scoop left to sell.
	 */
	public boolean sellScoop() {
		if (this.scoops > 0) {
			this.scoops--;
			return true;
		}
		return false;

	}

	/**
	 * Simple toString method.
	 */
	public String toString() {
		return name + " --- " + this.scoops + " available scoops";
	}

	/**
	 * Method to check if two objects of ice cream are the same.
	 * 
	 * @param c1 - ice cream to compare.
	 * @return true or false based on result.
	 */
	public boolean equals(IceCream c1) {
		return this.name.equals(c1.getName());
	}

	/**
	 * This method adds scoops to stock of ice cream.
	 * 
	 * @param c - how many scoops to add.
	 */
	public void addStock(IceCream c) {
		this.scoops += c.scoops;
		this.cost += this.cost;

	}
}
