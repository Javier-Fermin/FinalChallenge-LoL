package controller;

import java.util.Set;

import exceptions.PersonalizedException;
import model.Administrator;
import model.Player;
import model.User;

/**
 * 
 * @author Irati Garzón
 * @author Alex Salinero
 * @version 1.0
 *
 */
public interface UserControllable {
	/**
	 * Method use to check if the information related to the logIn is correct
	 * 
	 * @param usr
	 * @param passwd
	 * @return
	 * @throws PersonalizedException
	 */
	public boolean logIn(String usr, String passwd) throws PersonalizedException;

	/**
	 * Method in charge of deleting a User
	 * 
	 * @param user
	 * @param chooseConnection
	 * @return
	 * @throws PersonalizedException
	 */
	public boolean delete(User user, int chooseConnection) throws PersonalizedException;

	/**
	 * Method used to look for a certain User
	 * 
	 * @param usr
	 * @param chooseConnection
	 * @return
	 * @throws PersonalizedException
	 */
	public User findUser(String usr, int chooseConnection) throws PersonalizedException;

	/**
	 * Method used to add a User
	 * 
	 * @param user
	 * @param chooseConnection
	 * @throws PersonalizedException
	 */
	public void addUser(User user, int chooseConnection) throws PersonalizedException;

	/**
	 * Method responsible of modifications to a User
	 * 
	 * @param user
	 * @return
	 * @throws PersonalizedException
	 */
	public boolean modifyUser(User user) throws PersonalizedException;

	/**
	 * Method that lists the existing Players
	 * 
	 * @return
	 * @throws PersonalizedException
	 */
	public Set<User> listPlayers() throws PersonalizedException;
}
