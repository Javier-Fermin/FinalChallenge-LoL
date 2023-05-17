/**
 * This class is responsible for creating instances of the Statable interface
 * @author Iñigo
 * @version 1.0
 */
package controller;

public class StatableFactory {
	private static Statable obj = new StatableDBImplementation();
	/**
	 * Returns an instance of the Statable interface
	 * @return an instance of the Statable interface
	 */
	public static Statable getStatable() {
		return obj;
	}
}
