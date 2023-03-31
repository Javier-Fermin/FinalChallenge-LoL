package model;

public class Played {
	private boolean win;
	private String position;
	private final String[] postions = {"TOP","JNG","MID","ADC","SUP"}; 
	
	public boolean isWin() {
		return win;
	}
	public String[] getPostions() {
		return postions;
	}
	public void setWin(boolean win) {
		this.win = win;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}