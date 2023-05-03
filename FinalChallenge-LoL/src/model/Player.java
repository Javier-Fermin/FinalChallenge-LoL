package model;

// This is the Player class, which extends from User
public class Player extends User{
	private String nickname;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}