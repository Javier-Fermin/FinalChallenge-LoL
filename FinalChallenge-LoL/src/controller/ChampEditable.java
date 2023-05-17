/**
 * Interface ChampEditable to add, modify and list champs
 * @author Iñigo Blanco
 * @version 1.0
 */

package controller;

import java.util.List;

import exceptions.PersonalizedException;
import model.Champ;

public interface ChampEditable {
	/**
	 * This method adds a new Champ to the DB
	 * 
	 * @param champ Champ to be added
	 * @return true if the champ has been added, false if not
	 * @throws PersonalizedException if there is an error adding the champ
	 */
	public boolean addChamp(Champ champ) throws PersonalizedException;

	/**
	 * This method modifies a Champ by using its name
	 * 
	 * @param champ Champ to be modified
	 * @return true if the champ has been modified, false if not
	 * @throws PersonalizedException if there is an error modifying the champ
	 */
	public boolean modifyChamp (Champ champ) throws PersonalizedException;

	/**
	 * This method is to list all the champs
	 * 
	 * @return List of all champs
	 * @throws PersonalizedException if there is an error listing the champs
	 */
	public List<Champ> listChamp() throws PersonalizedException;

	/**
	 * We use this method to list all champs 
	 * with a filter on position and/or region
	 * 
	 * @param filterPosition string with the position to filter
	 * @param filterRegion string with the region to filter
	 * @return List of all champs with the filter
	 * @throws PersonalizedException if there is an error listing the champs
	 */
	public List<Champ> listChamp(String filterPosition, String filterRegion) throws PersonalizedException;
		
	/**
	 * 	This method is used to check if a champ already exists in the database
	 *  by its name and returns it
	 * 
	 * @param name Name of the champ
	 * @return Champ with the name
	 * @throws PersonalizedException if there is an error checking the champ
	 */
	public Champ checkChampName(String name) throws PersonalizedException;
}
