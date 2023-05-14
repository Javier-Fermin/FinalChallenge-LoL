/** 
 * The main class of the program that creates the main window of the application and starts the program.
 * @author Irati
 * @version 1.0
*/
package main;

import controller.ChampEditable;
import controller.ChampEditableFactory;
import controller.GameStorable;
import controller.GameStorableFactory;
import controller.Statable;
import controller.StatableFactory;
import controller.UserControllable;
import controller.UserControllableFactory;
import gui.MainWindow;

public class main {
	/**
	 * The main method of the program that creates the main window of the application and starts the program.
	 * @param args an array of command-line arguments for the program (not used)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChampEditable champEditable = ChampEditableFactory.getChampEditable();
		Statable statable = StatableFactory.getStatable();
		GameStorable gameStorable = GameStorableFactory.getGameStorable();
		UserControllable userControllable = UserControllableFactory.getUserControllable();
		
		MainWindow frame = new MainWindow(userControllable, champEditable, gameStorable, statable);
		frame.setVisible(true);
	}

}
