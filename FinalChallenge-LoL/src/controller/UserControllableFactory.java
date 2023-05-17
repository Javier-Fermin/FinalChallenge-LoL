/**
 * THis is a factory class that is responsible for creating and providing an instance of UserControllable.
 * @author Irati
 * @author Alex
 * @version 1.0
 */
package controller;

public class UserControllableFactory {
	private static UserControllable object = new UserControllableDBImplementation();
	/**
	 * Returns an instance of UserControllable interface
	 * @return an instance of UserControllable interface
	 */
	public static UserControllable getUserControllable() {
		return object;
	}
}
