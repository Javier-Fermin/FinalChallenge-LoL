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
