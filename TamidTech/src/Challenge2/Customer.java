package Challenge2;

/**
 * This is my solution to challenge #2 of the Senior Software Engineer
 * Application.
 * 
 * This class represents a Customer.
 * 
 * @author benbarzvi
 * 
 *         08/01/2020
 *
 */
public class Customer {
	private String name;
	private int age;
	double money;

	/**
	 * This is the constructor of the class.
	 * 
	 * @param name  - name of customer.
	 * @param age   - age of customer.
	 * @param money - money in customer's bank.
	 */
	public Customer(String name, int age, double money) {
		this.name = name;
		this.age = age;
		this.money = money;
	}

	/**
	 * This method subtracts money from customer's bank account
	 * 
	 * @param price - how much money to subtract.
	 * @return true if subtraction was successful, false if not.
	 */
	public boolean purchase(double price) {
		if (money >= price) {
			this.money -= price;
			return true;
		}
		return false;
	}

	/**
	 * Simple get method.
	 * 
	 * @return age of customer
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Simple get method.
	 * 
	 * @return money of customer
	 */
	public double getMoney() {
		return money;
	}

	/**
	 * Simple get method.
	 * 
	 * @return name of customer
	 */
	public String getName() {
		return name;
	}

	/**
	 * Simple toString method.
	 */
	public String toString() {
		return name + " is " + age + " years old and has $" + money + " in their account.";
	}
}
