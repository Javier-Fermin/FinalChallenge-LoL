package controller;

public class ChampEditableFactory {
private static ChampEditable obj = new ChampEditableDBImplementation();
	
	public static ChampEditable getChampEditable(){
		
		return obj;
	}
}
	
