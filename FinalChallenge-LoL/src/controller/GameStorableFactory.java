/**
 * THis class is responsible for creating and providing an instance of GameStorable.
 * It uses the GameStorableDBImplementation class as the implementation
 * @author Javi
 * @version 1.0
 */
package controller;

public class GameStorableFactory {
	private static GameStorable object = new GameStorableDBImplementation();
	/**
	 * This method provides an instance of GameStorable
	 * @return GameStorable instance
	 */
	public static GameStorable getGameStorable() {
		return object;
	}
}
