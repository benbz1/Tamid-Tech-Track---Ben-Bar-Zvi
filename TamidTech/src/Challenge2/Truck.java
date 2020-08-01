package Challenge2;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This is my solution to challenge #2 of the Senior Software Engineer
 * Application.
 * 
 * This class represents a Truck.
 * 
 * @author benbarzvi
 * 
 *         08/01/2020
 *
 */
public class Truck {
	// This variable holds the different ice cream objects.
	ArrayList<IceCream> flavors;
	// This variable holds the current money a truck has.
	private double money;
	// This variable is how much money the truck has generated from sales.
	private double salesMoney;
	// This variable is how much money sales the truck has made.
	private int sales;
	// This variable tracks how many scoops of each flavor were sold.
	ArrayList<Integer> flavorSales;
	// How many scoops of ice cream are currently available.
	private int iceCreamAvailable;
	// Queue of customers.
	private Queue<Customer> customers;
	// How many flavors of ice cream the truck has.
	private int flavorCount;
	// Keeps track of truck workers.
	private ArrayList<TruckWorker> workers;
	// Keeps track of truck drivers.
	private ArrayList<Driver> drivers;

	/**
	 * This class constructs the truck object.
	 * 
	 * @param money - how much investing money truck has.
	 */
	public Truck(double money) {
		this.money = money;
		this.sales = 0;
		this.iceCreamAvailable = 0;
		this.flavors = new ArrayList<IceCream>();
		this.customers = (Queue<Customer>) new LinkedList();
		this.flavorCount = 0;
		workers = new ArrayList<TruckWorker>();
		drivers = new ArrayList<Driver>();
		flavorSales = new ArrayList<Integer>();
		this.salesMoney = 0;
	}

	/**
	 * This method returns ice cream objects of the truck.
	 * 
	 * @return
	 */
	public ArrayList<IceCream> getFlavors() {
		return flavors;
	}

	/**
	 * Simple get method.
	 * 
	 * @return how much money the truck has.
	 */
	public double getMone() {
		return money;
	}

	/**
	 * This is a simple get method.
	 * 
	 * @return the number of sales made.
	 */
	public int getSales() {
		return sales;
	}

	/**
	 * This is a simple get method.
	 * 
	 * @return the number of ice cream available.
	 */
	public int getIceCreamAva() {
		return this.iceCreamAvailable;
	}

	/**
	 * This method adds a worker to the truck.
	 * 
	 * @param w - worker to be added.
	 */
	public void addWorker(TruckWorker w) {
		this.workers.add(w);
	}

	/**
	 * This method adds a driver.
	 * 
	 * @param w - driver to be added.
	 */
	public void addDriver(Driver w) {
		this.drivers.add(w);
	}

	/**
	 * This method adds an ice cream flavor.
	 * 
	 * @param iceCream - new flavor to be added.
	 */
	public void addFlavor(IceCream iceCream) {

		this.flavorCount++;
		this.money -= iceCream.getCost();
		this.iceCreamAvailable += iceCream.getScoops();
		this.flavors.add(iceCream);
		this.flavorSales.add(0);
	}

	/**
	 * This method adds a customer to the queue of the truck.
	 * 
	 * @param c - customer to be added.
	 */
	public void addCustomer(Customer c) {
		this.customers.add(c);
	}

	/**
	 * This method removes a customer and sells ice cream to them.
	 * 
	 * @return the string of the resulted action. For instance, ice cream flavor is
	 *         unavailable or customer does not have enough money.
	 *         
	 *         Clarification: if a customer is turned away even though they have money and there is ice cream
	 *         it's because they requested more scoops than the truck has.
	 */
	public String removeCustomer() {

		if (this.iceCreamAvailable == 0) {
			return "";
		}
		Customer removed = this.customers.remove();
		int index;
		index = ((int) (this.flavorCount * Math.random()));
		IceCream chosen = this.flavors.get(index);

		int scoops = (int) (3 * Math.random());
		if (scoops == 0)
			scoops = 1;
		if (chosen.getScoops() < scoops) {
			return chosen.getName() + " is currently unavailable in stock to satisfy the customer's # of scoops request. " + removed.getName() + " left.";
		}

		if (removed.purchase(scoops * chosen.price()) == true) {

			this.money += scoops * chosen.price();
			this.salesMoney += scoops * chosen.price();
			this.iceCreamAvailable -= scoops;
			for (int i = 0; i < scoops; i++) {
				chosen.sellScoop();
				this.flavorSales.set(index, this.flavorSales.get(index) + 1);
				this.sales++;
			}
			return removed.getName() + " has $" + (removed.getMoney() + scoops * chosen.price())
					+ " in their bank account. They purchased " + scoops + " scoop of " + chosen.getName()
					+ " ice cream for\n" + "$" + scoops * chosen.price() + ".";
		} else {
			return removed.getName() + " has " + removed.getMoney()
					+ " in their bank account.\nThey cannot purchase ice cream";
		}

	}

	/**
	 * This method returns the customers of the truck.
	 * 
	 * @return a string representation of the truck.
	 */
	public String getCustomers() {
		if (this.customers.isEmpty() == true) {
			return "";
		}
		return this.customers.toString();

	}

	/**
	 * This method returns a String representation of the truck workers.
	 * 
	 * @return
	 */
	public String getTruckWorkers() {
		return this.workers.toString();

	}

	/**
	 * This method returns a String representation of the truck drivers.
	 * 
	 * @return
	 */
	public String getDrivers() {
		return this.drivers.toString();

	}

	/**
	 * This method returns a String representation of the truck's employees.
	 * 
	 * @return
	 */
	public String getEmployees() {
		String res = "[";
		for (int i = 0; i < this.workers.size(); i++) {
			res += this.workers.get(i).getName() + ", ";
		}
		for (int i = 0; i < this.drivers.size(); i++) {
			res += this.drivers.get(i).getName() + ", ";
		}
		res = res.substring(0, res.length() - 2);
		res += "]";
		return res;
	}

	/**
	 * This method returns a string representation of the ice cream stock of the
	 * truck.
	 * 
	 * @return
	 */
	public String getIceCream() {
		return this.flavors.toString();
	}

	/**
	 * This method adds ice cream scoops to an exisitng flavor of ice cream.
	 * 
	 * @param c
	 * @return
	 */
	public boolean restock(IceCream c) {
		int index = -1;
		for (int i = 0; i < this.flavorCount; i++) {
			if (this.flavors.get(i).getName().equals(c.getName())) {
				index = i;
			}
		}
		if (index > -1) {
			this.flavors.get(index).addStock(c);
			iceCreamAvailable += c.getScoops();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method helps determine if there are customers in line, if not the truck wil close for the day. 
	 * @return
	 */
	public boolean customersInLine() {
		return !this.customers.isEmpty();

	}
	/**
	 * This method returns the purchase history of the truck's ice cream 
	 * @return a string representation of it.
	 */
	public String getPurchaseHistory() {
		String res = " has sold " + this.sales + " scoops for $" + this.salesMoney;
		for (int i = 0; i < this.flavorCount; i++) {
			if (this.flavorSales.get(i) > 0) {
				res += "\n*" + this.flavorSales.get(i) + " Scoops of " + this.flavors.get(i) + " Ice cream";
			}
		}
		res += "\nTruck currently has $" + this.money;
		return res;
	}
}
