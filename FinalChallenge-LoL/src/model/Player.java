/**
 * The player class represents a player in the game, which extends from User.
 * @author Irati
 * @author Alex
 * @version 1.0
 */
package model;

public class Player extends User{
	/**
	 * The nickname of the player.
	 */
	private String nickname;
	/**
	 * The constructor of the class.
	 * @param nickname The nickname of the player.
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * Sets the nickname of the player.
	 * @param nickname The nickname of the player.
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}