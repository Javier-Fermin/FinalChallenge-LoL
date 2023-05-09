package controller;

import java.sql.SQLException;
import java.util.Set;

import exceptions.PersonalizedException;
import model.Played;
import model.TopPlayers;
/**
 * This interface is the responsible of getting all the Played that are related
 * to a certain Player by searching its Nickname
 * 
 * @author javier
 * @version 1.0
 *
 */
public interface Statable {
	/**
	 * This method is manages the way to get a Collection of Played related to a
	 * Player by using its Nickname
	 * 
	 * @param nickname
	 * @return
	 * @throws PersonalizedException
	 */
	public Set<Played> stadistics(String nickname) throws PersonalizedException;
	/**
	 * This method gets the  top 5 players with the highest winrate
	 * @return Set<Played> Players with the highest winrate
	 * @throws PersonalizedException
	 */
	public Set<TopPlayers> topPlayers() throws PersonalizedException;
}
