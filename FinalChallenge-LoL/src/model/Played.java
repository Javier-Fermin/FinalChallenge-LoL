package model;

public class Played {
	private int id;
	private boolean win;
	private String position,name,nickname;

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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}