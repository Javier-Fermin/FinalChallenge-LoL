/**
 * THis class is used to store the data of the top players
 * @author     Iñigo
 * @version   1.0
 */
package model;

// This is the Top Players class
public class TopPlayers {
	/**
	 * The position of the player.
	 */
	private String position;
	/**
	 * The name of the player.
	 */
	private String name;
	/**
	 * The nickname of the player.
	 */
	private String nickname;
	/**
	 * The total plays of the player.
	 */
    private int totalPlays;
	/**
	 * The wins of the player.
	 */
	private int wins;
	/**
	 * The win rate of the player.
	 */
	private float winRate;
	/**
	 * Returns the number of wins the player has had.
	 * @return an int representing the number of wins the player has had
	 */
	public int getWins() {
		return wins;
	}
	/**
	 * Sets the number of wins the player has had.
	 * @param wins an int representing the number of wins the player has had
	 */
	public void setWins(int wins) {
		this.wins = wins;
	}
	/**
	 * Returns the win rate of the player.
	 * @return the win rate of the player
	 */
	public float getWinRate() {
		return winRate;
	}
	/**
	 * Sets the win rate of the player.
	 * @param winRate the win rate of the player
	 */
	public void setWinRate(float winRate) {
		this.winRate = winRate;
	}
	/**
	 * Returns the total plays of the player.
	 * @return an int representing the total plays of the player
	 */
	public int getTotalPlays() {
		return totalPlays;
	}
	/**
	 * Sets the total plays of the player.
	 * @param totalPlays an int representing the total plays of the player
	 */
	public void setTotalPlays(int totalPlays) {
		this.totalPlays = totalPlays;
	}
	/**
	 * Returns the position of the player.
	 * @return a string representing the position of the player
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * Sets the position of the player.
	 * @param position a string representing the position of the player
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * Returns the name of the player.
	 * @return a string representing the name of the player
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name of the player.
	 * @param name a string representing the name of the player
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Returns the nickname of the player.
	 * @return a string representing the nickname of the player
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * Sets the nickname of the player.
	 * @param nickname a string representing the nickname of the player
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}