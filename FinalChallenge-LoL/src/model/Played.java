/**
 * This is the Played class that represents a played game by a user.
 * @author Javi
 * @version 1.0
 */
package model;

public class Played {
	/**
	 * The ID of the played game.
	 */
	private int id;
	/**
	 * The result of the played game.
	 */
	private boolean win;
	/**
	 * The position of the played game, the name and the nickname of the user.
	 */
	private String position,name,nickname;
	/**
	 * The array of the positions.
	 */
	private final String[] postions = {"TOP","JNG","MID","ADC","SUP"};
	/**
	 * Returns whether the played game was a win or a loss.
	 * @return true if the game was a win, false if it was a loss.
	 */
	public boolean isWin() {
		return win;
	}
	/**
	 * Returns the array of the positions.
	 * @return the list of valid positions ("TOP","JNG","MID","ADC","SUP").
	 */
	public String[] getPostions() {
		return postions;
	}
	/**
	 * Sets whether the played game was a win or a loss.
	 * @param win true if the game was a win, false if it was a loss.
	 */
	public void setWin(boolean win) {
		this.win = win;
	}
	/**
	 * Returns the position of the played game.
	 * @return the position of the played game.
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * Sets the position of the played game.
	 * @param position the position of the played game.
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * Returns the name of the user.
	 * @return the name of the user.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name of the user.
	 * @param name the name of the user.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Returns the nickname of the user.
	 * @return the nickname of the user.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Sets the nickname of the user.
	 * @param nickname the nickname of the user.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Returns the nickname of the user.
	 * @return the nickname of the user.
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * Sets the nickname of the user.
	 * @param nickname the nickname of the user.
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}