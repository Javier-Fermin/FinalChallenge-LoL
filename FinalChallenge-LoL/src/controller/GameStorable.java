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
	 * @param game
	 * @return
	 * @throws PersonalizedException
	 */
	public int addGame(Game game) throws PersonalizedException;

	/**
	 * This method is meant to look for all Games related to one Player by its
	 * Nickname
	 * 
	 * @param nickname
	 * @return
	 * @throws PersonalizedException
	 */
	public Set<Game> searchGames(String nickname) throws PersonalizedException;

	/**
	 * This method makes the additions of Played that are related to a Game, linking
	 * Game, Champ and Player
	 * 
	 * @param id
	 * @param nickname
	 * @param name
	 * @param win
	 * @param position
	 * @throws PersonalizedException
	 */
	public void completeGame(int id, String nickname, String name, boolean win, String position)
			throws PersonalizedException;
}