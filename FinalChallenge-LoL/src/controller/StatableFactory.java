package controller;

public class StatableFactory {
	private static Statable obj = new StatableDBImplementation();

	public static Statable getStatable() {
		return obj;
	}
}
