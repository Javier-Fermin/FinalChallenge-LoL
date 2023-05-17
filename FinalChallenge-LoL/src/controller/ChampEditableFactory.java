/**
 * This class is used to create an instance of the ChampEditableDBImplementation class.
 * @author Iñigo
 * @version 1.0
 */
package controller;

public class ChampEditableFactory {
private static ChampEditable obj = new ChampEditableDBImplementation();
	/**
	 * Returns an instance of the ChampEditable interface.
	 * @return an instance of the ChampEditable interface.
	 */
	public static ChampEditable getChampEditable(){	
		return obj;
	}
}
	
