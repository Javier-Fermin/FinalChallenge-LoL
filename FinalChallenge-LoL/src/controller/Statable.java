package controller;

import java.sql.SQLException;
import java.util.Set;

import exceptions.PersonalizedException;
import model.Played;
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
}
