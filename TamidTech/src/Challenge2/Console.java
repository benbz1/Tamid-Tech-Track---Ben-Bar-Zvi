package Challenge2;

import java.util.Scanner;
/**
 * This is my solution to challenge #2 of the Senior Software Engineer
 * Application.
 * 
 * This class represents the console of the person using my system.
 * 
 * @author benbarzvi
 * 
 * 08/01/2020
 *
 */
public class Console {
	//Name of the track
	private static String name;
	//Cash invested in the truck
	private static double cash;
	//To represent the track 
	private static Truck truck;

	/**
	 * This is the main class that runs the system, here I am setting the name of the track and its
	 * 	investment money.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Congratulations! You have decided to start your own Ice Cream Truck! What is\n"
				+ "your new business's name and how much would you like to invest?\n\nBusiness Name: ");
		name = in.nextLine();

		getMoney();
		truck = new Truck(cash);


		truck.addCustomer(new Customer("Ben", 18, 22));
		truck.addCustomer(new Customer("Michelle", 20, 420));
		truck.addCustomer(new Customer("Jake", 23, 544));
		truck.addCustomer(new Customer("James", 18, 260));
		truck.addCustomer(new Customer("Ella", 20, 410));
		truck.addCustomer(new Customer("Mike", 23, 54));
		
		truck.addWorker(new TruckWorker("James", 18, "Employed", 12, false));
		truck.addWorker(new TruckWorker("Emily", 19, "Employed", 20, false));
		System.out.println("\nYou have created " + name + ", and invested $" + cash + "!");
		System.out.print("The following Customers are in line: " + truck.getCustomers());
		
		//Here I call the method that takes care of the looped prompt
		start();
	}
	/**
	 * This method will allow the user to select an option from the menu and execute the chosen option.
	 */
	public static void start() {
		try {
			Scanner in = new Scanner(System.in);
			boolean exit = false;
			int choice = 0;
			while (exit != true) {
				System.out.print("\n\nWelcome to " + name + "!\n" + "Please select an option from the menu below:\n"
						+ "1. Add a new Ice Cream Flavor\n" + "2. Hire a new Truck Worker\n" + "3. Hire a new Driver\n"
						+ "4. Show all Employees\n" + "5. Show Ice Cream stock\n"
						+ "6. Purchase more Ice Cream of an existing flavor\n"
						+ "7. Display # of sales (both the number of ice cream sold, and the cash those\n"
						+ "sales generated)\n" + "8. Close for the day (quit the loop)\n\nUser Input:\n");

				System.out.print("> ");
				choice = in.nextInt();
				switch (choice) {

				case 1:
					System.out.println("What flavor would you like to add?");
					System.out.print("Name: ");
					String iceCreamName = in.next();
					System.out.print("Number of Scoops: ");
					int iceCreamScoops = in.nextInt();
					System.out.print("Cost to Customer: ");
					double cost = in.nextDouble();
					System.out.print("Cost of purchase: ");
					double price = in.nextDouble();
					truck.addFlavor(new IceCream(iceCreamName, cost, price, iceCreamScoops));
					break;
				case 2:
					System.out.print("Name: ");
					String workerName = in.next();
					System.out.print("Age: ");
					int age = in.nextInt();
					System.out.print("Employment Status: ");
					String emplymentStatus = in.next();
					System.out.print("Give Access to Register(true/false): ");
					boolean access = in.nextBoolean();
					System.out.print("Wage: ");
					double wage = in.nextDouble();
					TruckWorker worker = new TruckWorker(workerName, age, emplymentStatus, wage, access);
					truck.addWorker(worker);
					break;
				case 3:
					System.out.print("Name: ");
					workerName = in.next();
					System.out.print("Age: ");
					age = in.nextInt();
					System.out.print("Employment Status: ");
					emplymentStatus = in.next();
					System.out.print("Give Access to Drive(true/false): ");
					access = in.nextBoolean();
					System.out.print("Wage: ");
					wage = in.nextDouble();
					Driver driver = new Driver(workerName, age, emplymentStatus, wage, access);
					truck.addDriver(driver);
					break;
				case 4:
					System.out.println("Employees: " + truck.getEmployees());

					break;
				case 5:
					System.out.println(truck.getIceCream());

					break;
				case 6:
					System.out.println("Which Flavor would you like to add?");
					String iceCream1 = in.next();
					System.out.println("How many scoops would you like to add?");
					int scoops1 = in.nextInt();
					System.out.println("How much did it cost you?");
					double cost1 = in.nextDouble();
					if (truck.restock(new IceCream(iceCream1, 0, cost1, scoops1)) == false) {
						System.out.println("This flavor does not exist in the system. Please add a new flavor.");
					}
					break;
				case 7:
					System.out.println("Truck " + truck.getPurchaseHistory());
					break;
				case 8:
					exit = true;
					break;
				default:
					start();

				}
				String s = truck.removeCustomer();
				if (s.equals("")) {
					System.out.println("No more ice cream available. Truck is Closed");
					exit = true;
				} else {
					System.out.println("\n\nCUSTOMER PURCHASE:\n" + s);
				}

				if (exit == false && truck.customersInLine() == false || truck.getCustomers().equals("")) {
					System.out.println("There are no more customers for the day. Goodbye!");
					exit = true;
				}
			}
		} catch (Exception c) {
			System.out.println("An error occured, please choose valid values.");
			start();
		}
	}
	/**
	 * This is just a helper method to ensure the input is a valid value for cash.
	 */
	private static void getMoney() {

		Scanner in = new Scanner(System.in);
		try {
			System.out.print("Start-Up Cash: ");
			cash = in.nextDouble();
		} catch (Exception e) {
			System.out.print("Please enter a valid amount of Start-Up Cash: ");
			getMoney();
		}
	}
}
