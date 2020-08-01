package Challenge2;

/**
 * This is my solution to challenge #2 of the Senior Software Engineer
 * Application.
 * 
 * This class represents a worker of a truck.
 * 
 * @author benbarzvi
 * 
 *         08/01/2020
 *
 */
public class TruckWorker {
	private String name;
	private int age;
	private double wage;
	private String employmentStatus;
	private boolean access;

	/**
	 * A constructor for this class.
	 * 
	 * @param name            - name of driver
	 * @param age             - age of driver
	 * @param emplymentStatus - employment status
	 * @param wage            - wage of driver
	 * @param access          - access to register
	 */
	public TruckWorker(String name, int age, String emplymentStatus, double wage, boolean access) {
		this.name = name;
		this.age = age;
		this.employmentStatus = emplymentStatus;
		this.access = access;
		this.wage = wage;

	}

	/**
	 * Simple toString method.
	 */
	public String toString() {
		if (this.access == true)
			return this.name + "," + age + "," + " is " + this.employmentStatus + " and has access to the register.";
		return this.name + "," + age + "," + " is " + this.employmentStatus
				+ " and does not have access to the register.";
	}

	/**
	 * This method returns the name of the worker.
	 * @return a string rep of their name.
	 */
	public String getName() {
		return this.name;
	}
}
