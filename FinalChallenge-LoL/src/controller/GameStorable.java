package controller;

import java.util.Set;

import exceptions.PersonalizedException;
import model.Game;
/**
 * This interface manage everything related to modifying, deleting and adding
 * Games
 * 
 * @author javier
 * @version 1.0
 *
 */
public interface GameStorable {
	/**
	 * This method is in charge of managing the addition of a Game
	 * 
	 * @param game Game to be added
	 * @return int id of the Game added
	 * @throws PersonalizedException if there is an error adding the Game
	 */
	public int addGame(Game game) throws PersonalizedException;

	/**
	 * This method is meant to look for all Games related to one Player by its
	 * Nickname
	 * 
	 * @param nickname Nickname of the Player
	 * @return Set<Game> Collection of Games related to the Player
	 * @throws PersonalizedException if there is an error looking for the Games
	 */
	public Set<Game> searchGames(String nickname) throws PersonalizedException;

	/**
	 * This method makes the additions of Played that are related to a Game, linking
	 * Game, Champ and Player
	 * 
	 * @param id 	  id of the Game
	 * @param nickname	  Nickname of the Player
	 * @param name	  Name of the Champ
	 * @param win	  Boolean that indicates if the Player won or not
	 * @param position Position of the Champ
	 * @throws PersonalizedException if there is an error adding the Played
	 */
	public void completeGame(int id, String nickname, String name, boolean win, String position)
			throws PersonalizedException;
}