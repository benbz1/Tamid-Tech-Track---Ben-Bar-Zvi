package Challenge2;
/**
 * This is my solution to challenge #2 of the Senior Software Engineer
 * Application.
 * 
 * This class represents the Driver of a truck.
 * 
 * @author benbarzvi
 * 
 *    08/01/2020
 *
 */
public class Driver {
	private String name;
	private int age;
	private double wage;
	private boolean access;
	private String employmentStatus;

	/**
	 * A constructor for this class.
	 * @param name - name of driver
	 * @param age - age of driver
	 * @param emplymentStatus - employment status 
	 * @param wage - wage of driver
	 * @param access - access to drive
	 */
	public Driver(String name, int age, String employmentStatus, double wage, boolean access) {
		this.name = name;
		this.age = age;
		this.employmentStatus = employmentStatus;
		this.access = access;
		this.wage = wage;
	}
	/**
	 * Simple get method
	 * @return name of driver
	 */
	public String getName() {
		return name;
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
}
