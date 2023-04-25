package controller;

public class GameStorableFactory {
	private static GameStorable object = new GameStorableDBImplementation();

	public static GameStorable getGameStorable() {
		return object;
	}
}
