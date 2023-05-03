package controller;

import java.util.List;

import exceptions.PersonalizedException;
import model.Champ;

/**
 * 
 * @author Iñigo Blanco
 * @version 1.0
 *
 */

public interface ChampEditable {
	/**
	 * This method adds a new Champ to the DB
	 * 
	 * @param champ
	 * @return 
	 * @throws PersonalizedException
	 */
	public boolean addChamp(Champ champ) throws PersonalizedException;

	/**
	 * This method modifies a Champ by using its name
	 * 
	 * @param champ
	 * @return 
	 * @throws PersonalizedException
	 */
	public boolean modifyChamp (Champ champ) throws PersonalizedException;

	/**
	 * This method is to list all the champs
	 * 
	 * @return 
	 * @throws PersonalizedException
	 */
	public List<Champ> listChamp() throws PersonalizedException;

	/**
	 * We use this method to list all champs 
	 * with a filter on position and/or region
	 * 
	 * @param filterPosition
	 * @param filterRegion
	 * @return 
	 * @throws PersonalizedException
	 */
	public List<Champ> listChamp(String filterPosition, String filterRegion) throws PersonalizedException;
		
	/**
	 * 	This method is used to check if a champ already exists in the database
	 *  by its name and returns it
	 * 
	 * @param name
	 * @return 
	 * @throws PersonalizedException
	 */
	public Champ checkChampName(String name) throws PersonalizedException;
}
