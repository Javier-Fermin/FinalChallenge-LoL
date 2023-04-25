package controller;

public class UserControllableFactory {
	private static UserControllable object = new UserControllableDBImplementation();

	public static UserControllable getUserControllable() {
		return object;
	}
}
